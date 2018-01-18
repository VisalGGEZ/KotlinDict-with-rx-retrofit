package com.example.vsuos.kotlindict.model

/**
 * Created by v.suos on 10/4/2017.
 */
public class ListDictionary{
    var listDictionary : ArrayList<DictionaryModel>? = null

    companion object {
        val instance : ListDictionary by lazy { ListDictionary() }
    }

    fun setList(list: ArrayList<DictionaryModel>){
        this.listDictionary = list
    }

    fun getList() = this.listDictionary
}