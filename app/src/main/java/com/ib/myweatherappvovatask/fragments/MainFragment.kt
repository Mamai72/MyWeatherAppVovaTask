package com.ib.myweatherappvovatask.fragments

import android.os.Bundle
import android.text.TextUtils
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.fragment.app.viewModels
import androidx.lifecycle.LifecycleOwner
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
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        goToForecast()
    }

    private fun saveRequestToTheBase() {
        if (inputCheck(binding.edSearch.text.toString())){
            myViewModel.getWeatherApi(binding.edSearch.text.toString())
            myViewModel.currentData.observe(this as LifecycleOwner) {

                binding.tvWeather.text = it.id.toString()
//                binding.apply {
//                    tvWeather.text = it.id.toString()
//                }
            }
            Toast.makeText(requireContext(), "This has been successfully added", Toast.LENGTH_LONG).show()
        }else{
            Toast.makeText(requireContext(), "You need to fill out all fields", Toast.LENGTH_LONG).show()
        }
    }

    private fun inputCheck(name: String): Boolean {
return !(TextUtils.isEmpty(name))
    }

    private fun goToForecast(){
        binding.imSearch.setOnClickListener {
            saveRequestToTheBase()
//            myViewModel.currentData.observe(this as LifecycleOwner) {
//                binding.apply {
//                    tvWeather.text = it.id.toString()
//                }
//            }
//            parentFragmentManager
//                .beginTransaction()
//                .replace(R.id.place_holder, ForecastFragment())
//                .commit()
        }
    }
}