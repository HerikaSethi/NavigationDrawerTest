package com.example.navigationdrawertest.Fragments

import android.content.Context
import android.content.SharedPreferences
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import com.example.navigationdrawertest.R
import com.example.navigationdrawertest.databinding.FragmentSharedPreferencesBinding


class SharedPreferencesFragment : Fragment() {

    lateinit var binding: FragmentSharedPreferencesBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
       // binding = DataBindingUtil.setContentView(requireActivity(),R.layout.fragment_shared_preferences)
        return inflater.inflate(R.layout.fragment_shared_preferences, container, false)
       // return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val name = view.findViewById<EditText>(R.id.name)
        val address = view.findViewById<EditText>(R.id.address)
        val saveBtn = view.findViewById<Button>(R.id.saveBtn)
        val getBtn = view.findViewById<Button>(R.id.getBtn)
        val clearBtn = view.findViewById<Button>(R.id.clearBtn)
        val deleteBtn = view.findViewById<Button>(R.id.deleteBtn)

        val sharedPref : SharedPreferences?= activity?.getPreferences(Context.MODE_PRIVATE);
        var edit = sharedPref?.edit()



        saveBtn.setOnClickListener {
            if (edit != null) {
                edit.putString("name",name.text.toString())
                edit.putString("address",address.text.toString())
                edit.commit()
                Toast.makeText(requireContext(),"data saved",Toast.LENGTH_SHORT).show()
            }
        }
        getBtn.setOnClickListener {
            val name = sharedPref?.getString("name","default value")
            val add = sharedPref?.getString("address","default value")
            Toast.makeText(requireContext(),name+" address"+add, Toast.LENGTH_SHORT).show()
        }
        clearBtn.setOnClickListener { edit?.remove("address")
            if (edit != null) {
                edit.commit()
            }
        }
        deleteBtn.setOnClickListener { edit!!.clear()
        edit.commit()}
    }

}