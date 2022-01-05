package com.example.bottomnavigationtest.ui.fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.fragment.app.setFragmentResultListener
import androidx.navigation.fragment.findNavController
import com.example.bottomnavigationtest.R
import com.example.bottomnavigationtest.data.Constants
import com.example.bottomnavigationtest.databinding.FragmentFirstBinding

class FirstFragment : Fragment() {
    private lateinit var binding: FragmentFirstBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        binding = FragmentFirstBinding.inflate(layoutInflater)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        initUI()
    }

    private fun initUI() {
        initButtons()
        fragmentResult()
    }

    private fun initButtons() {
        binding.sendToSecondpageBtn.setOnClickListener {
            findNavController().navigate(
                R.id.secondFragment,
                bundleOf(Constants.MOVIE_ID to 1, Constants.MOVIE_NAME to "Spider-man : No way home")
            )
        }
    }

    private fun fragmentResult() {
        setFragmentResultListener(Constants.REQUEST_KEY) { requestKey, bundle ->
            val result = bundle.getString(Constants.RESULT_KEY)
            Toast.makeText(context, result, Toast.LENGTH_SHORT).show()
        }
    }

}