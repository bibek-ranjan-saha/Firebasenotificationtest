package com.crazylab.firebasenotificationtest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.messaging.FirebaseMessagingService

class MainActivity : AppCompatActivity() {

    lateinit var text2:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        text2=findViewById(R.id.text2)

        val s= intent.extras?.get("data")
        if (s!=null){
            if (s.toString()=="news")
            {
                val intent=Intent(this,MainActivity2::class.java)
                intent.putExtra("msg",s.toString())
                startActivity(intent)
                finish()
            }

        }


    }


}