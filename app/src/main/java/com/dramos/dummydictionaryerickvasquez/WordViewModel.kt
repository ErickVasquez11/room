package com.dramos.dummydictionaryerickvasquez

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dramos.dummydictionaryerickvasquez.data.model.Word
import com.dramos.dummydictionaryerickvasquez.repository.DictionaryRepository
import kotlinx.coroutines.launch


class WordViewModel(private val repository: DictionaryRepository): ViewModel() {
    val words = repository.getAllWords()

    fun addWord(word: Word) {
        viewModelScope.launch {
            repository.addWord(word)
        }
    }
}