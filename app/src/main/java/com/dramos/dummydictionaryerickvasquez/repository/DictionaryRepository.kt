package com.dramos.dummydictionaryerickvasquez.repository

import androidx.lifecycle.MutableLiveData
import com.dramos.dummydictionaryerickvasquez.data.model.Word
import com.dramos.dummydictionaryerickvasquez.data.model.dao.AntonymDao
import com.dramos.dummydictionaryerickvasquez.data.model.dao.SynonymDao
import com.dramos.dummydictionaryerickvasquez.data.model.dao.WordDao

class DictionaryRepository(
    private val wordDoa: WordDao,
    val synonymDao: SynonymDao,
    val antonymDao: AntonymDao
) {

    fun getAllWords() = wordDoa.getAllWords()

    suspend fun addWord(word: Word) {
        wordDoa.insertWord(word)
    }
}