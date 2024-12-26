package com.sulivan.navegacaoentretelas.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.sulivan.navegacaoentretelas.R

class ThirdFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view:View =  inflater.inflate(R.layout.fragment_third, container, false)

        /*
         * Adiciciona navegação entre as fragments conforme navigate.xml
         * */
        val buttonThirdToFirst = view.findViewById<Button>(R.id.buttonThirdToFirst)
        buttonThirdToFirst.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_firstFragment)
        }

        val buttonThirdToSecond = view.findViewById<Button>(R.id.buttonThirdToSecond)
        buttonThirdToSecond.setOnClickListener {
            findNavController().navigate(R.id.action_thirdFragment_to_secondFragment)
        }

        return view

    }

}