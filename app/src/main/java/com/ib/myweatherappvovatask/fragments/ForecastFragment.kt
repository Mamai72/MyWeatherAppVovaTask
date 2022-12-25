package com.ib.myweatherappvovatask.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
import com.ib.myweatherappvovatask.databinding.FragmentForecastBinding
import com.ib.myweatherappvovatask.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ForecastFragment : Fragment() {
    lateinit var binding: FragmentForecastBinding
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentForecastBinding.inflate(inflater, container, false)
        myViewModel.currentData.observe(this as LifecycleOwner) {
            binding.apply {
                tvTemp.text = it.user
            }
        }
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        apiUser()
    }

    fun apiUser(){
        binding.btnUser.setOnClickListener {
            myViewModel.getWeatherApi()

        }
    }

//    private fun updateWeatherCard() {
//
//
//
//    }
}