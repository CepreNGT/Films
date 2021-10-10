package com.example.films

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.example.films.main.Numbers
import com.google.android.material.button.MaterialButton

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val textView = findViewById<TextView>(R.id.text_view)
        var index = -1
        findViewById<MaterialButton>(R.id.button_tap_me).setOnClickListener {
            index += 1
            val data = Numbers(index, index * index)
            textView.text = data.toString()
        }

        for (i in 1..10) {
            println(i)
        }

        println()

        for (i in 10 downTo 1 step 5) {
            println(i)
        }
    }
}