package com.example.surveyapplication

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import com.example.surveyapplication.databinding.ActivityResultPageBinding


class ResultPage : AppCompatActivity() {
    private lateinit var binding : ActivityResultPageBinding
    private var doubleBackToExitPressedOnce = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultPageBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view);

        val results = intent.getParcelableExtra("all_information") as CombinedInfo?

        with(binding) {
            tvAns1.text = results?.personalInfo?.nameSurname.toString()
            tvAns2.text = results?.personalInfo?.email.toString()
            tvAns4.text = results?.personalInfo?.age.toString()
            tvAns3.text = results?.personalInfo?.phone.toString()
            tvAns5.text = results?.personalInfo?.city.toString()
            tvAns6.text = results?.hobbies.toString()
            tvAns7.text = results?.book.toString()
            tvAns8.text = results?.answer.toString()

            button.setOnClickListener {
                val intent = Intent(this@ResultPage, MainActivity::class.java)
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                startActivity(intent)
            }
        }

        onBackPressedDispatcher.addCallback(this, object: OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                if (doubleBackToExitPressedOnce) {
                    val intent = Intent(this@ResultPage, MainActivity::class.java)
                    intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP)
                    startActivity(intent)
                } else {
                    Toast.makeText(
                        this@ResultPage,
                        "Press back button again to return to Homepage.",
                        Toast.LENGTH_SHORT
                    ).show()
                    doubleBackToExitPressedOnce = true
                }
            }
        })
    }
}