package com.screen.makingcallsemailingetc

import android.annotation.SuppressLint
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_mailing.*


class Mailing : Fragment() {
    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.activity_calling_emailing, container, false)
    }
    @SuppressLint("IntentReset")
    override fun onViewCreated(view: View, savedInstanceState: Bundle?){
        super.onViewCreated(view, savedInstanceState)
        mailAddress.setText(arguments?.getString("mail"))
        val buttonSend = buttonSend
        val message = message
        buttonSend.setOnClickListener {
            val emailIntent = Intent(Intent.ACTION_SEND)
            emailIntent.data = Uri.parse("mailto:")
            emailIntent.type = "$message"
            startActivity(emailIntent)
        }
    }
    }

