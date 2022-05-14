package com.gsesdras.navigation.ui.first

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.gsesdras.navigation.databinding.FirstFragmentBinding
import com.gsesdras.navigation.extension.navigateSafe

class FirstFragment : Fragment() {

    private lateinit var binding: FirstFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = FirstFragmentBinding.inflate(
        inflater,
        container,
        false
    ).also {
        binding = it
    }.root

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.goToSecond.setOnClickListener {
            findNavController().navigateSafe(FirstFragmentDirections.toSecondFragment())
        }
    }
}