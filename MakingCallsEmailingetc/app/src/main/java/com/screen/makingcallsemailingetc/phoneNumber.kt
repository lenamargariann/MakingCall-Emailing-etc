package com.screen.makingcallsemailingetc

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_phone_number.*


class phoneNumber : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_calling_emailing, container, false)
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
    phoneNum.setText(arguments?.getString("number"))
        val button = button2
        button.setOnClickListener {
            val intentCall = Intent(Intent.ACTION_CALL, Uri.parse("tel:${phoneNum.text}"))
            startActivity(intentCall)
        }
    }
}