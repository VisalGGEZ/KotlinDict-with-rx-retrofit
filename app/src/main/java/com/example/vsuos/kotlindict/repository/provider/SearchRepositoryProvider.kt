package com.example.vsuos.kotlindict.repository.provider

import com.example.vsuos.kotlindict.repository.SearchRepository
import com.example.vsuos.kotlindict.service.DictionaryService

/**
 * Created by v.suos on 10/3/2017.
 */

object SearchRepositoryProvider{

    fun provideSearchRepository() : SearchRepository {
        return SearchRepository(DictionaryService.create())
    }

}