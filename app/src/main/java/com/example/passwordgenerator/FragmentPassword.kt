package com.example.passwordgenerator

import android.os.Bundle
import android.text.Editable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_password.*
import kotlinx.android.synthetic.main.fragment_password.view.*

class FragmentPassword : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_password, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btPasswordLength.setText("12")

        getPassword()

        view.btResetPassword.setOnClickListener {
            getPassword()
        }
    }

    fun getPassword(){

        var password = (0..10).random()

        var digitsEnabled = swDigits.isChecked()
        var capitalLettersEnadled = swCapitalLetters.isChecked()
        var specialSymbolsEnabled = swSpecialSymbols.isChecked()
        var passwordLength = btPasswordLength.text.toString().toInt()

        val digits = "0123456789"
        val letters = "abcdefghijklmnopqrstuvwxyz"
        val capital = "ABCDEFGHIJKLMNOPQRSTUVWXYZ"
        val symbols = "~!@#$%^&*_+-"

        var all = letters
        if (digitsEnabled) all += digits
        if (capitalLettersEnadled) all += capital
        if (specialSymbolsEnabled) all += symbols

        if(passwordLength < 1)
        {
            btPasswordLength.setText("1")
            passwordLength = 1
        }
        if(passwordLength > 30)
        {
            btPasswordLength.setText("30")
            passwordLength = 30
        }

        var psw = ""
        for(i in 1..passwordLength)
        {
            psw += all.random()
        }

        textViewPassword.setText(psw)
    }
}