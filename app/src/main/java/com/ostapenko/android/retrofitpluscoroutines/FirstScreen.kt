package com.ostapenko.android.retrofitpluscoroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.Navigation
import kotlin.random.Random

class FirstScreen : Fragment() {

    private val model: NumbersViewModel by viewModels()
    private lateinit var mainTextView: TextView
    private lateinit var textView: TextView
    private lateinit var textView2: TextView
    private lateinit var buttonGetFact: Button
    private lateinit var buttonRandomFact: Button
    private lateinit var editNumber: EditText
    private lateinit var currentNumberSelected: String

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.first_screen, container, false)
        mainTextView = view.findViewById(R.id.main_text_view) as TextView
        textView = view.findViewById(R.id.textView) as TextView
        textView2 = view.findViewById(R.id.textView2) as TextView
        buttonGetFact = view.findViewById(R.id.button_get_fact) as Button
        buttonRandomFact = view.findViewById(R.id.button_random_fact) as Button
        editNumber = view.findViewById(R.id.editTextNumber) as EditText
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        model.numbersLiveData.observe(viewLifecycleOwner, Observer { number ->

            model.numbersLiveData.value?.forEach {
                model.addNumber(it)

                textView2.text = textView.text
                textView.text = mainTextView.text
                mainTextView.text = it.text
            }
        })

        buttonGetFact.setOnClickListener {
            if (editNumber.text.isEmpty()) {
                Toast.makeText(requireContext(), "Enter a number to get fact", Toast.LENGTH_SHORT)
                    .show()
            } else {
                model.getNumberQuery(editNumber.text.toString())
            }
        }

        buttonRandomFact.setOnClickListener {
            val randomInt = Random.nextInt(0, 100)
            model.getNumberQuery(randomInt.toString())
        }

        mainTextView.setOnClickListener {
            val text = mainTextView.text.toString()
            getCurrentNumber(text)

            val action = FirstScreenDirections
                .actionFirstScreenToSecondScreenFragment(
                    number = currentNumberSelected,
                    text = text
                )

            Navigation.findNavController(view)
                .navigate(action)
        }

        textView.setOnClickListener {
            val text = textView.text.toString()
            getCurrentNumber(text)

            val action = FirstScreenDirections
                .actionFirstScreenToSecondScreenFragment(
                    number = currentNumberSelected,
                    text = text
                )

            Navigation.findNavController(view)
                .navigate(action)
        }

        textView2.setOnClickListener {
            val text = textView2.text.toString()
            getCurrentNumber(text)

            val action = FirstScreenDirections
                .actionFirstScreenToSecondScreenFragment(
                    number = currentNumberSelected,
                    text = text
                )

            Navigation.findNavController(view)
                .navigate(action)
        }
    }

    private fun getCurrentNumber(text: String) {
        var currentNumber = ""
        model.numbersListData.forEach { it ->
            if (it.text == text) {
                currentNumber = it.number
            }
        }

        currentNumberSelected = currentNumber
    }

}