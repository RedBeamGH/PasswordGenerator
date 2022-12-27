package com.example.passwordgenerator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity(), OnFragmentChange {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadFragment("home")
    }

    fun loadFragment(name:String){
        val transaction = supportFragmentManager.beginTransaction()

        val fragment = if(name == "home"){
            FragmentHome()
        } else {
            FragmentPassword()
        }

        transaction.replace(R.id.flContainer, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    override fun onChange(name: String) {
        loadFragment(name)
    }
}