package com.screen.makingcallsemailingetc

import android.content.Intent
import android.os.Bundle
import android.util.Patterns
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val name: EditText = findViewById(R.id.name)
        val lastName: EditText = findViewById(R.id.LastName)
        val phone: EditText = findViewById(R.id.Phone)
        val email: EditText = findViewById(R.id.email)
        val button: Button = findViewById(R.id.button)
        val bundlePhone = Bundle()
        bundlePhone.putString("number", "$phone")
        val objPhone = phoneNumber()
        objPhone.arguments = bundlePhone
        val bundleMail = Bundle()
        bundleMail.putString("mail", "$email")
        val objMail = Mailing()
        objMail.arguments = bundleMail

        button.setOnClickListener {
            if (valid(email, phone, name, lastName)) {
                val intent = Intent(this, calling_emailing :: class.java)
                intent.putExtra("mail","$email")
                intent.putExtra("phone","$phone")
                startActivity(intent)
            }
        }

    }

private fun valid(email : EditText, phone : EditText, name : EditText, lastName : EditText) : Boolean {
    var mailValid = false
    var nameValid = false
    var phoneValid = false
    var lastNameValid = false
    if(email.text.toString().isEmpty()){
        email.error = "Email is not valid !"
    } else if(!Patterns.EMAIL_ADDRESS.matcher(email.text.toString()).matches()){
        email.error = "Email is not valid !"
    } else mailValid = true
    if(name.text.toString().isEmpty()){
        name.error =" Name is not valid !"
    } else nameValid = true
    if(lastName.text.toString().isEmpty()){
        lastName.error =" LastName is not valid !"
    } else lastNameValid = true
    if(phone.text.toString().isEmpty()) {
    phone.error = "Phone Number is not valid !"
    } else if(phone.text.toString().length < 8){
        phone.error = "Phone Number is not valid !"
    } else phoneValid = true
   return nameValid && phoneValid && lastNameValid && mailValid
    }

}

