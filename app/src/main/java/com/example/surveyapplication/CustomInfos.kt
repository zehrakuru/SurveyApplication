package com.example.surveyapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.surveyapplication.databinding.ActivityCustomInfosBinding
import com.example.surveyapplication.databinding.ActivityPersonalInformationBinding

class CustomInfos : AppCompatActivity() {

    private lateinit var binding: ActivityCustomInfosBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityCustomInfosBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view);

        val person = intent.getParcelableExtra("person") as PersonalInfo?

        with(binding) {
            receivedNameId.text = person?.nameSurname

            btnSaveAndNext.setOnClickListener {
                val hobbies = editTextHobbies.text.toString()
                val lastReadBook = editTextLastBook.text.toString()
                val lastAnswer = editTextAnswer.text.toString()

                if(hobbies.isNotEmpty() && lastReadBook.isNotEmpty() && lastAnswer.isNotEmpty()) {
                    val combinedInfo = CombinedInfo(person!!, hobbies, lastReadBook, lastAnswer)
                    val intent = Intent(this@CustomInfos, ResultPage::class.java)
                    intent.putExtra("all_information", combinedInfo)
                    startActivity(intent)
                }
            }
        }
    }
}