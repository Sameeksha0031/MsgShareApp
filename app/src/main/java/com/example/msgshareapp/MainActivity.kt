package com.example.msgshareapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var button = findViewById<Button>(R.id.button)
       button.setOnClickListener {
           Log.i("MainActivity", "You press try to key")
           Toast.makeText(this,"Button was clicked !", Toast.LENGTH_SHORT).show()
       }
       var buttonTwo= findViewById<Button>(R.id.buttonTwo)
       buttonTwo.setOnClickListener {
           var editUserMessage = findViewById<EditText>(R.id.editUserMessage)
           var message = editUserMessage.text.toString()
           Toast.makeText(this,message, Toast.LENGTH_SHORT).show()

           val intent = Intent(this,SecondActivity::class.java) //explicit Intend
           intent.putExtra("userMessage", message)
           startActivity(intent)
        }
       var buttonThree = findViewById<Button>(R.id.buttonThree) //implicit
        buttonThree.setOnClickListener {
            val message : String = buttonTwo.text.toString()
            val intent = Intent()
            intent.action = Intent.ACTION_SEND
            intent.putExtra(Intent.EXTRA_TEXT,message)
            intent.type="text/plain"

            startActivity(Intent.createChooser(intent,"Share to :"))
        }
    }
}