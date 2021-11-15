package com.example.fragmentex

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import androidx.fragment.app.Fragment
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.navigation.fragment.navArgs
import com.example.fragmentex.databinding.FragmentExBinding
import com.example.fragmentex.databinding.FragmentSecondBinding


class SecondFragment : Fragment(){//(R.layout.fragment_second){
    val args: SecondFragmentArgs by navArgs()

    val viewModel: ScoreViewModel by viewModels()


    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        val binding = DataBindingUtil.inflate<FragmentSecondBinding>(inflater, R.layout.fragment_second, container, false)

        val dataToDisplay = args.data
        Log.v("SECOND FRAG", "data is $dataToDisplay")


        binding.textView.text = "data is $dataToDisplay"

//        val scoreViewA: TextView = view.findViewById(R.id.scoreA)
//        val plusOneButtonA: Button = view.findViewById(R.id.incA)

        binding.viewModel = viewModel
        binding.lifecycleOwner = this
//        plusOneButtonA.setOnClickListener {
//            viewModel.incrementScore(true)
//            scoreViewA.text = viewModel.scoreA.toString()
//        }

        binding.incA.setOnClickListener {
            viewModel.incrementScore(true)
            //binding.scoreViewA.text = viewModel.scoreA.toString()
        }
        binding.incB.setOnClickListener {
            viewModel.incrementScore(false)
            //binding.scoreViewA.text = viewModel.scoreA.toString()
        }
//        val scoreA_Observer = Observer<Int> { newValue ->
//            binding.scoreViewA.text = newValue.toString()
//        }
//
//        viewModel.scoreA.observe(viewLifecycleOwner, scoreA_Observer)


        return binding.root

    }
}
