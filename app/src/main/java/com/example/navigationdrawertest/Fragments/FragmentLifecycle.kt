package com.example.navigationdrawertest.Fragments

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.navigationdrawertest.R


class FragmentLifecycle : Fragment() {

    var TAG = "FragLifecycle"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        Log.d(TAG, "onCreate: I am in onCreate  ")

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        Log.d(TAG, "onCreateView: I am in onCreateView ")
        return inflater.inflate(R.layout.fragment_lifecycle, container, false)
    }

    override fun onStart() {
        Log.d(TAG, "onStart: I am in onStart")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume: I am in onResume")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause: I am in onPause")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop: I am in onStop")
        super.onStop()
    }

    override fun onDestroyView() {
        Log.d(TAG, "onDestroyView: I am in onDestroyView")
        super.onDestroyView()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: I am in onDestroy")
        super.onDestroy()
    }

}