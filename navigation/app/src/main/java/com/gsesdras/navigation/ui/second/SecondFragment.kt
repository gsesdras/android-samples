package com.gsesdras.navigation.ui.second

import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.gsesdras.navigation.databinding.SecondFragmentBinding

class SecondFragment : Fragment() {

    private lateinit var binding: SecondFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ) = SecondFragmentBinding.inflate(
        inflater,
        container,
        false
    ).also {
        binding = it
    }.root
}