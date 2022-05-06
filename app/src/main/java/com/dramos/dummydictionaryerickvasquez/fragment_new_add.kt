package com.dramos.dummydictionaryerickvasquez

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import com.dramos.dummydictionaryerickvasquez.data.model.Word
import com.dramos.dummydictionaryerickvasquez.databinding.FragmentNewAddBinding


class fragment_new_add : Fragment() {

    private val viewModelFactory by lazy {
        val application = requireActivity().application as DummyDictionaryApplication
        WordViewModelFactory(application.getDictionaryRepository())
    }
    private val viewModel: WordViewModel by viewModels {
        viewModelFactory
    }

    private lateinit var binding: FragmentNewAddBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {

       binding = DataBindingUtil.inflate(inflater, R.layout.fragment_new_add,container,false)
        return binding.root

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.actionAdd.setOnClickListener {
            var newTitle = binding.editWord.text.toString()
            var newDescription = binding.editDescription.text.toString()

            var newWord = Word(newTitle, newDescription, true)
            viewModel.addWord(newWord)
        }
    }
}