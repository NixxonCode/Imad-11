package com.example.ff

import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {

    lateinit var edtTime: EditText
    lateinit var btnSuggest: Button
    lateinit var btnReset: Button
    lateinit var tvSuggestion: TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)



        edtTime = findViewById(R.id.edtTime)
        btnSuggest = findViewById(R.id.btnSuggest)
        btnReset = findViewById(R.id.btnReset)
        tvSuggestion = findViewById(R.id.tvSuggestion)

        btnSuggest.setOnClickListener {
            val time = edtTime.text.toString().trim().lowercase()
            Log.d("Social Spark App", "Time: $time")

            val suggestion = when (time) {
                "morning" -> "send a 'Good Morning' message to a family member."
                "mid-morning" -> "send a 'Thank you' message to a colleague."
                "afternoon" -> "share a funny meme with a friend."
                "dinner" -> "Call a friend for a 5-minute catch-up."
                "night" -> "Leave a thoughtful comment on a friend's post."
                else -> "Invalid time of day"
            }
            tvSuggestion.text = suggestion
        }

        btnReset.setOnClickListener {
            Log.d( "Social Spark App",  "Reset button clicked")
            edtTime.text.clear()
            tvSuggestion.text = ""
        }



        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }
}