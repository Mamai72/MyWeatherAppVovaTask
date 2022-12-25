package com.ib.myweatherappvovatask.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.viewModels
import com.ib.myweatherappvovatask.R
import com.ib.myweatherappvovatask.databinding.FragmentMainBinding
import com.ib.myweatherappvovatask.viewmodel.MyViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainFragment : Fragment() {
    lateinit var binding: FragmentMainBinding
    private val myViewModel: MyViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentMainBinding.inflate(inflater,container,false)
        goToForecast()
        return binding.root
    }

    private fun goToForecast(){
        binding.imSearch.setOnClickListener {
            parentFragmentManager
                .beginTransaction()
                .replace(R.id.place_holder, ForecastFragment())
                .commit()
        }
    }
}