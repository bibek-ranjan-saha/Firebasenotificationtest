package com.crazylab.firebasenotificationtest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class MainActivity2 : AppCompatActivity() {
    lateinit var text:TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        text=findViewById(R.id.text)
        val msg=intent.getStringExtra("msg")
        text.text=msg

    }
}