package com.example.msgshareapp

import android.os.Bundle
import android.os.PersistableBundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class SecondActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.newlayoutfile)

        val bundle:Bundle? = intent.extras // to get the value from the main Activity
        val msg = bundle!!.getString("userMessage") // bundle should not be null that we use(!!)
        Toast.makeText(this,msg,Toast.LENGTH_SHORT).show()

        val userTextMsg = findViewById<TextView>(R.id.userTextView)
        userTextMsg.text = msg
    }
}