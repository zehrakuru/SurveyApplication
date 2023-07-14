package com.example.surveyapplication

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.surveyapplication.databinding.ActivityPersonalInformationBinding


class PersonalInformation : AppCompatActivity() {
    private lateinit var binding: ActivityPersonalInformationBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPersonalInformationBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view);

        val str = intent.getStringExtra("nameSurname")
        binding.receivedNameId.text = str
    }
}