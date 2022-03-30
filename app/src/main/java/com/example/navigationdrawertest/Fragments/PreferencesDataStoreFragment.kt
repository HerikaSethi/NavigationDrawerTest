package com.example.navigationdrawertest.Fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.asLiveData
import com.example.navigationdrawertest.R
import com.example.navigationdrawertest.UserManager
import kotlinx.android.synthetic.main.fragment_preferences_data_store.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch


class PreferencesDataStoreFragment : Fragment() {
    lateinit var userManager: UserManager
    var name = ""
    var age = 0
    var gender = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_preferences_data_store, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //instantiating user Manager
        userManager = UserManager(requireContext())

        //fuction so that every time user clicks the button then value is saved
        buttonSave()

        observeData()

    }

    private fun observeData() {
        btn_save.setOnClickListener {
            //retreiving text frm the edit text
            name = et_name.text.toString()
            age = et_age.text.toString().toInt()
            //if checked then male else it will e a female
            val isMale = switch_gender.isChecked

            //suspend function made which is to be called in coroutine scope
            GlobalScope.launch {
                userManager.storeUser(age, name, isMale)
            }

        }
    }

    private fun buttonSave() {

        userManager.userNameFlow.asLiveData().observe(requireActivity(), {
            //everytime anything changes in user name flow it will be updated through here
            name = it
            tv_name.text = it.toString()
        })
        userManager.userAgeFlow.asLiveData().observe(requireActivity(),{
            age = it
            tv_age.text = it.toString()
        })

        userManager.userGenderFlow.asLiveData().observe(requireActivity(),{
            gender = if(it) "Male" else "Female"
            tv_gender.text = gender
        })
    }

}
