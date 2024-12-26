package com.sulivan.navegacaoentretelas.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.sulivan.navegacaoentretelas.R


class SecondFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View = inflater.inflate(R.layout.fragment_second, container, false)

        /*
         * Adiciciona navegação entre as fragments conforme navigate.xml
         * */
        val buttonSecondToFirst = view.findViewById<Button>(R.id.buttonSecondToFirst)
        buttonSecondToFirst.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_firstFragment)
        }

        val buttonSecondToThird = view.findViewById<Button>(R.id.buttonSecondToThird)
        buttonSecondToThird.setOnClickListener {
            findNavController().navigate(R.id.action_secondFragment_to_thirdFragment)
        }

        return view

    }


}