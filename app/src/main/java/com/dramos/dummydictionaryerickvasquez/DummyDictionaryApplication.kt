package com.dramos.dummydictionaryerickvasquez

import android.app.Application
import com.dramos.dummydictionaryerickvasquez.data.model.DummyDictionaryDatabase
import com.dramos.dummydictionaryerickvasquez.repository.DictionaryRepository

class DummyDictionaryApplication : Application() {
    val dataBase by lazy {
        DummyDictionaryDatabase.getInstance(this)
    }

    fun getDictionaryRepository() = with(dataBase) {
        DictionaryRepository(wordDao(), synonymDao(), antonymDao())
    }
}