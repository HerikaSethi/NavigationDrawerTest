package com.example.navigationdrawertest.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import com.example.navigationdrawertest.R
import com.example.navigationdrawertest.bottomNavFragments.DashboardFragment
import com.example.navigationdrawertest.bottomNavFragments.InfoFragment
import com.example.navigationdrawertest.bottomNavFragments.SettingsFragment
import com.example.navigationdrawertest.databinding.FragmentBottomNavBarBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class BottomNavBarFragment : Fragment() {

   //lateinit var binding: FragmentBottomNavBarBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)


    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        //binding = DataBindingUtil.setContentView(requireActivity(),R.layout.fragment_bottom_nav_bar)
       // binding = BottomNavBarFragment.inflate(inflater,container,false)
        return inflater.inflate(R.layout.fragment_bottom_nav_bar, container, false)
       // return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //find bottom nav bar

        val bottomNav = requireView().findViewById<BottomNavigationView>(R.id.bottom_navigation)

        replacefragment(DashboardFragment())

        bottomNav.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.dashboard -> replacefragment(DashboardFragment())
                R.id.settings -> replacefragment(SettingsFragment())
                R.id.info -> replacefragment(InfoFragment())
            }
            true
        }
    }

    private fun replacefragment(fragment: Fragment) {
        val transaction = childFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

}