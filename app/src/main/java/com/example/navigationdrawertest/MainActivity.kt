package com.example.navigationdrawertest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.navigationdrawertest.Fragments.*
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    var TAG = "Activitylifecycle"
    lateinit var toggle:ActionBarDrawerToggle
    //To access drawer layout outside oncreate method
    lateinit var drawerLayout: DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        Log.d(TAG, "onCreate: In onCreate of activity")

        drawerLayout = findViewById(R.id.drawerLayout)
        val navView: NavigationView = findViewById(R.id.nav_view)

        toggle = ActionBarDrawerToggle(this, drawerLayout, R.string.open, R.string.close)

        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)

   navView.setNavigationItemSelectedListener {
       //to highlight that particular item on which the user has clicked
       it.isChecked = true
       when(it.itemId)
       {
           R.id.nav_fragment_lifecycle -> replaceFragment(FragmentLifecycle(),it.title.toString())
           R.id.nav_toast -> replaceFragment(ToastFragment(),it.title.toString())
           R.id.nav_snackbar -> replaceFragment(SnackbarFragment(), it.title.toString())
           R.id.nav_notification -> replaceFragment(NotificationFragment(),it.title.toString())
           R.id.nav_backgroundservice -> replaceFragment(BackgroundServiceFragment(),it.title.toString())
           R.id.nav_bottomnav -> replaceFragment(BottomNavBarFragment(),it.title.toString())
           R.id.nav_rcvretrofit -> replaceFragment(RcvRetrofitFragment(),it.title.toString())
           R.id.nav_preferenceDataStore -> replaceFragment(PreferencesDataStoreFragment(),it.title.toString())
           R.id.nav_sharedPreferences -> replaceFragment(SharedPreferencesFragment(),it.title.toString())

           R.id.nav_login -> Toast.makeText(applicationContext,"Clicked login",Toast.LENGTH_SHORT).show()
       }
       true
       }
    }

    //function to replace fragment
    private fun replaceFragment(fragment: Fragment, title: String) {
        val fragmentManager = supportFragmentManager
        val fragmentTransaction = fragmentManager.beginTransaction()
        fragmentTransaction.replace(R.id.frameLayout, fragment)

        fragmentTransaction.commit()

        //To close the drawer once user clicks the menu item from the navigation drawer
        drawerLayout.closeDrawers()

        //To set the title we are getting in this function from call
        setTitle(title)

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if(toggle.onOptionsItemSelected(item)){
            return true
        }
        return super.onOptionsItemSelected(item)
    }

    override fun onStart() {
        Log.d(TAG, "onStart: In onStart of activity")
        super.onStart()
    }

    override fun onResume() {
        Log.d(TAG, "onResume: In onResume of activity")
        super.onResume()
    }

    override fun onPause() {
        Log.d(TAG, "onPause: In onPause of activity")
        super.onPause()
    }

    override fun onStop() {
        Log.d(TAG, "onStop: In onStop of activity")
        super.onStop()
    }

    override fun onDestroy() {
        Log.d(TAG, "onDestroy: In onDestroy of activity")
        super.onDestroy()
    }


}