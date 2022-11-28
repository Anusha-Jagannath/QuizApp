package com.example.quizapp.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.quizapp.Utils.USER_NAME
import com.example.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.submitBtn.setOnClickListener {
            val name = binding.nameInput.text.toString().trim()
            if (name.isNotEmpty()) {
                val intent = Intent(this, QuizActivity::class.java)
                intent.putExtra(USER_NAME,name)
                startActivity(intent)
            }
            else {
                Toast.makeText(this,"Please enter valid credentials", Toast.LENGTH_SHORT).show()
            }

        }
    }
}