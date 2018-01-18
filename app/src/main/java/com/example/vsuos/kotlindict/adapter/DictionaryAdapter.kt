package com.example.vsuos.kotlindict.adapter
import android.support.v7.widget.RecyclerView
import android.view.View
import android.view.ViewGroup
import com.example.vsuos.kotlindict.R
import com.example.vsuos.kotlindict.model.DictionaryModel
import com.example.vsuos.kotlindict.model.ListDictionary
import com.example.vsuos.kotlindict.utilities.inflate
import kotlinx.android.synthetic.main.definition_layout.view.*
import kotlin.properties.Delegates


/**
 * Created by v.suos on 10/4/2017.
 */
public class DictionaryAdapter : RecyclerView.Adapter<DictionaryAdapter.ViewHolder>() {

    var listDictionary : ArrayList<DictionaryModel>? = null

    fun setList(listDictionary: ArrayList<DictionaryModel>){
        this.listDictionary = listDictionary
    }

    override fun getItemCount() = listDictionary!!.size

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder?.bind(this.listDictionary!![position], position)
    }

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder? {
        var view : View? = parent?.inflate(R.layout.definition_layout)
        return ViewHolder(view!!)
    }

    class ViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView){
        fun bind(dictionary: DictionaryModel, id: Int) = with(itemView){
            txtDefinition.text = "Definition : (${dictionary.partOfSpeech}) ${dictionary.text}"
        }
    }
}