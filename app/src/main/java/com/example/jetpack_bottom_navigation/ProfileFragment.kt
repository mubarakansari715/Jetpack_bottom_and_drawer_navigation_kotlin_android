package com.example.jetpack_bottom_navigation

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.fragment.app.Fragment
import androidx.navigation.Navigation

class ProfileFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val view = inflater.inflate(R.layout.fragment_profile, container, false)
        getData(view)
        return view
    }

    //transfer one fragment to another fragment
    private fun getData(view: View?) {
        val navController = requireActivity().let {
            Navigation.findNavController(it, R.id.my_nav_host_fragment)
        }
        val btn = view?.findViewById<Button>(R.id.btn_next)
        btn?.setOnClickListener {
            navController.navigate(R.id.searchFragment)
        }
    }


}