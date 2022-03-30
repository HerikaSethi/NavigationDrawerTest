package com.example.navigationdrawertest.Fragments

import android.app.ActionBar
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.navigationdrawertest.R
//import com.example.navigationdrawertest.databinding.FragmentSnackbarBinding
import com.google.android.material.snackbar.Snackbar


class SnackbarFragment : Fragment() {

   // lateinit var binding: FragmentSnackbarBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //val actionBar: ActionBar = getSupportActionBar()
        //actionBar.setDisplayHomeAsUpEnabled(true)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // binding = DataBindingUtil.setContentView(requireActivity(),R.layout.fragment_snackbar)
        return inflater.inflate(R.layout.fragment_snackbar, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val  button = view.findViewById<Button>(R.id.btn)
       // val coordinatorLayout = view.findViewById<CoordinatorLayout>(R.id.coordinator_layout)

        button.setOnClickListener {
            Snackbar.make(view, "Hello from Snackbar", Snackbar.LENGTH_SHORT).show()
        }
    }


}