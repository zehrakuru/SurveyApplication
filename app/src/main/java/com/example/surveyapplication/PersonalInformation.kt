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

        with(binding) {
            val nameSurname = intent.getStringExtra("nameSurname")
            receivedNameId.text = nameSurname

            btnNext.setOnClickListener {
                val email = editTextEmail.text.toString()
                val phone = editTextPhone.text.toString()
                val age = editTextAge.text.toString()
                val city = editTextCity.text.toString()

                if(email.isNotEmpty() && phone.isNotEmpty() && age.isNotEmpty() && city.isNotEmpty()) {
                    val person = PersonalInfo(nameSurname.toString(), email, phone, age.toInt(), city)
                    val intent = Intent(this@PersonalInformation, CustomInfos::class.java)
                    intent.putExtra("person", person)
                    startActivity(intent)
                }
            }
        }
    }
}