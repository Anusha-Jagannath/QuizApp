package com.example.quizapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quizapp.Utils.CORRECT_ANSWERS
import com.example.quizapp.Utils.TOTAL_QUESTIONS
import com.example.quizapp.Utils.USER_NAME
import com.example.quizapp.databinding.ActivityResultBinding

class ResultActivity : AppCompatActivity() {
    private lateinit var binding: ActivityResultBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityResultBinding.inflate(layoutInflater)
        setContentView(binding.root)
        val name = intent.getStringExtra(USER_NAME)
        val totalQuestions = intent.getIntExtra(TOTAL_QUESTIONS,0)
        val correctAnswers = intent.getIntExtra(CORRECT_ANSWERS,0)
        binding.nameTv.text = name
        binding.scoreTv.text = "You scored $correctAnswers out of $totalQuestions"
        binding.finishBtn.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

    }
}