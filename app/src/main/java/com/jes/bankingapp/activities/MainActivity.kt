package com.jes.bankingapp.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.navigation.fragment.NavHostFragment
import com.jes.bankingapp.R
import com.jes.bankingapp.databinding.ActivityMainBinding
import com.jes.bankingapp.utils.setColorStatusBar

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var navFragment: NavHostFragment


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        setUpNav()

    }


    private fun setUpNav() {
        navFragment = supportFragmentManager.findFragmentById(R.id.navHostFragment) as NavHostFragment
        navFragment.navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.home -> { setColorStatusBar(R.color.white) }
                R.id.cardSettings -> setColorStatusBar(R.color.white)
                R.id.profile ->{ setColorStatusBar(R.color.white) }
                R.id.resetPin-> {setColorStatusBar(R.color.white)}
                else -> setColorStatusBar(R.color.color_bg_screen)
            }
        }
    }



    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val navController = navFragment.navController
        if (navController.currentDestination?.id == R.id.home) {
            // If we are on the first fragment, exit the app
            finish()
        } else {
            // Otherwise, navigate back to the first fragment
            navController.navigateUp()
        }
    }



}