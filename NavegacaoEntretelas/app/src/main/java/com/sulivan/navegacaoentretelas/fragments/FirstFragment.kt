package com.sulivan.navegacaoentretelas.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.navigation.fragment.findNavController
import com.sulivan.navegacaoentretelas.R


class FirstFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view: View = inflater.inflate(R.layout.fragment_first, container, false)

        /*
        * Adiciciona navegação entre as fragments conforme navigate.xml
        * */
        val buttonFirstToSecond = view.findViewById<Button>(R.id.buttonFirstToSecond)
        buttonFirstToSecond.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_secondFragment)
        }

        val buttonFirstToThird = view.findViewById<Button>(R.id.buttonFirstToThird)
        buttonFirstToThird.setOnClickListener {
            findNavController().navigate(R.id.action_firstFragment_to_thirdFragment)
        }

        return view
    }
}