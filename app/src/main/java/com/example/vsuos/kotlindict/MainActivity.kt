package com.example.vsuos.kotlindict

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.View
import com.example.vsuos.kotlindict.adapter.DictionaryAdapter
import com.example.vsuos.kotlindict.model.DictionaryModel
import com.example.vsuos.kotlindict.repository.provider.SearchRepositoryProvider
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val compositeDisposable: CompositeDisposable = CompositeDisposable()
    var dictionaryAdapter = DictionaryAdapter()
    var isFirstTime : Boolean? = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        rvResultSearch.layoutManager = LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false)

        btnSearch.setOnClickListener(View.OnClickListener {
            findWord(edtKeyWord.text.toString())
        })
    }

    override fun onPause() {
        compositeDisposable.clear()
        super.onPause()
    }

    private fun findWord(word: String? = ""): Unit {

        var repository = SearchRepositoryProvider.provideSearchRepository()

        compositeDisposable.add(
                repository.findWord(word!!)
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                { listDict -> showResult(listDict) },
                                { error -> { error.printStackTrace() } })
        )
    }

    private fun showResult(listDictionary: ArrayList<DictionaryModel>) {
        dictionaryAdapter.setList(listDictionary)
        if(isFirstTime!!){
            isFirstTime = false
            rvResultSearch.adapter = dictionaryAdapter
        }
        dictionaryAdapter.notifyDataSetChanged()
    }

}