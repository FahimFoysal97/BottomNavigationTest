package com.example.bottomnavigationtest.ui.fragments

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResult
import androidx.navigation.fragment.findNavController
import com.example.bottomnavigationtest.data.Constants
import com.example.bottomnavigationtest.databinding.FragmentSecondBinding

class SecondFragment : Fragment() {
    private lateinit var binding: FragmentSecondBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentSecondBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        val movieName = arguments?.getString(Constants.MOVIE_NAME) ?: "NA"
        val movieId = arguments?.getInt(Constants.MOVIE_ID) ?: 0
        binding.receivedDataTxt.text = "Id: $movieId\nTitle: $movieName"

        binding.receivedDataTxt.setOnClickListener {
            setFragmentResult(Constants.REQUEST_KEY, bundleOf(Constants.RESULT_KEY to "Received"))
            findNavController().navigateUp()
        }
    }


}