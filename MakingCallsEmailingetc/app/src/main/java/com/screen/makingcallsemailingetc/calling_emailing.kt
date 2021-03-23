package com.screen.makingcallsemailingetc

import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class calling_emailing : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_calling_emailing)
        val  phone : Button = findViewById(R.id.makeCall)
        val email : Button = findViewById(R.id.Email)
        val camera :  Button = findViewById(R.id.camera)
        val phoneNumber = phoneNumber()
        val Mailing = Mailing()
        camera.setOnClickListener {
            val intentCamera = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivity(intentCamera)
        }
        phone.setOnClickListener {
            supportFragmentManager.beginTransaction().apply{
                replace ( R.id.frameLayout, phoneNumber)
                commit()
            }
        }
        email.setOnClickListener {
            supportFragmentManager.beginTransaction().apply{
                replace(R.id.frameLayout, Mailing)
                commit()
            }
        }
        }
    }

