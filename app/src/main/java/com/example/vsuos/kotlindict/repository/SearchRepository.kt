package com.example.vsuos.kotlindict.repository

import com.example.vsuos.kotlindict.model.DictionaryModel
import com.example.vsuos.kotlindict.service.DictionaryService
import io.reactivex.Observable

/**
 * Created by v.suos on 10/3/2017.
 */

class SearchRepository(val apiService: DictionaryService){
    fun findWord(word: String) : Observable<ArrayList<DictionaryModel>> {
        return apiService.findDefinition(word = word)
    }
}