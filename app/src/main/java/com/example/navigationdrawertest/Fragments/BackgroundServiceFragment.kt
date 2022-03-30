package com.example.navigationdrawertest.Fragments

import android.media.MediaPlayer
import android.os.Bundle
import android.provider.Settings
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.Button
import androidx.databinding.DataBindingUtil
import androidx.databinding.DataBindingUtil.inflate
import androidx.fragment.app.Fragment
import com.example.navigationdrawertest.R
import com.example.navigationdrawertest.databinding.FragmentBackgroundServiceBinding
import com.example.navigationdrawertest.databinding.FragmentRcvRetrofitBinding


class BackgroundServiceFragment : Fragment() {

    lateinit var binding: FragmentBackgroundServiceBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
//       binding = DataBindingUtil.setContentView(requireActivity(),R.layout.fragment_background_service)

      return inflater.inflate(R.layout.fragment_background_service, container, false)
       // binding = BackgroundServiceFragment.inflate(inflater, container,false)
       // return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        //binding.backgroundServiceButton.setOnClickListener { click_here(view) }
        val button = view.findViewById<Button>(R.id.backgroundServiceButton)
        button.setOnClickListener { click_here(view) }

    }
    fun click_here(view: View?) {
        val player: MediaPlayer = MediaPlayer.create(requireContext(), Settings.System.DEFAULT_ALARM_ALERT_URI)
        //to play it in loop
        player.isLooping = true
        player.start()
    }
}