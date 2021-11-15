package com.example.fragmentex

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.navigation.findNavController
import com.example.fragmentex.databinding.FragmentExBinding


class ExFragment : Fragment(){
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentExBinding>(inflater, R.layout.fragment_ex, container, false)
        binding.goButton.setOnClickListener {  view:View ->
            val dataEntered = binding.dataEditText.text.toString().toInt()

            val navController = view.findNavController()
            val action = ExFragmentDirections.actionExFragmentToSecondFragment(dataEntered)
            navController.navigate(action)

        }
        return binding.root
    }
}
