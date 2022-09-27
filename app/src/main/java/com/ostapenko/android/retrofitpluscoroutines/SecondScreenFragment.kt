package com.ostapenko.android.retrofitpluscoroutines

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.navArgs

class SecondScreenFragment : Fragment() {

    private lateinit var currentNumber: TextView
    private lateinit var numberFullText: TextView
    private val args: SecondScreenFragmentArgs by navArgs()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.second_screen, container, false)

        currentNumber = view.findViewById(R.id.current_number) as TextView
        numberFullText = view.findViewById(R.id.number_full_text) as TextView

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        val number = args.number
        val text = args.text

        currentNumber.text = number
        numberFullText.text = text
    }

}