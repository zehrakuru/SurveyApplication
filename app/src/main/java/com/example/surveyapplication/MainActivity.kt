package com.example.surveyapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.surveyapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view);

        with(binding) {
            btnGoSurvey.setOnClickListener {
                val userInput = editTextNameSurname.text.toString()
                val newIntent = Intent(this@MainActivity, PersonalInformation::class.java)
                newIntent.putExtra("nameSurname", userInput)
                startActivity(newIntent)
            }
        }
    }
}