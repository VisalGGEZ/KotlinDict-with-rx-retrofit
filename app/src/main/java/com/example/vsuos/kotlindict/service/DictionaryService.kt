package com.example.vsuos.kotlindict.service

import com.example.vsuos.kotlindict.model.DictionaryModel
import io.reactivex.Observable
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Created by v.suos on 10/3/2017.
 */
interface DictionaryService {

    @GET("word.json/{word}/definitions")
    fun findDefinition(@Path("word") word : String?,
                       @Query("limit") limit : String? = "200",
                       @Query("partOfSpeech") partOfSpeech : String = "",
                       @Query("includeRelated") includeRelated : Boolean = true,
                       @Query("sourceDictionaries") sourceDictionaries : String = "wordnet",
                       @Query("useCanonical") useCanonical : Boolean = false,
                       @Query("includeTags") includeTags : Boolean = false,
                       @Query("api_key") api_key : String? = "a2a73e7b926c924fad7001ca3111acd55af2ffabf50eb4ae5") : Observable<ArrayList<DictionaryModel>>

    companion object Factory {
        fun create(): DictionaryService {
            val retrofit = retrofit2.Retrofit.Builder()
                    .addCallAdapterFactory(retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory.create())
                    .addConverterFactory(retrofit2.converter.gson.GsonConverterFactory.create())
                    .baseUrl("http://api.wordnik.com:80/v4/")
                    .build()

            return retrofit.create(DictionaryService::class.java);
        }
    }
}