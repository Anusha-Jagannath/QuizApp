package com.example.quizapp.ui

import android.content.Intent
import android.graphics.Color
import android.graphics.Typeface
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.appcompat.widget.AppCompatTextView
import androidx.core.content.ContextCompat
import com.example.quizapp.R
import com.example.quizapp.Utils
import com.example.quizapp.Utils.CORRECT_ANSWERS
import com.example.quizapp.Utils.TOTAL_QUESTIONS
import com.example.quizapp.Utils.USER_NAME
import com.example.quizapp.databinding.ActivityQuizBinding
import com.example.quizapp.model.Country

class QuizActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityQuizBinding
    private var mCurrentPosition: Int = 1
    private var mQuestionsList: ArrayList<Country>? = null
    private var mSelectedPosition: Int = 0
    private var mUserName: String? = null
    private var mCorrectAnswers: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityQuizBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mUserName = intent.getStringExtra(USER_NAME)
        mQuestionsList = Utils.getCountries()
        binding.option1.setOnClickListener(this)
        binding.option2.setOnClickListener(this)
        binding.option3.setOnClickListener(this)
        binding.option4.setOnClickListener(this)
        binding.submitBtn.setOnClickListener(this)
        setQuestion()
    }

    private fun setQuestion() {
        setDefaultBackground()
        val currentQuestion = mQuestionsList!![mCurrentPosition - 1]
        binding.questionTv.text = currentQuestion.question
        binding.image.setImageResource(currentQuestion.image)
        binding.progressbar.progress = mCurrentPosition
        binding.progressTv.text = "$mCurrentPosition/${mQuestionsList!!.size}"
        binding.option1.text = currentQuestion.optionOne
        binding.option2.text = currentQuestion.optionTwo
        binding.option3.text = currentQuestion.optionThree
        binding.option4.text = currentQuestion.optionFour

        if (mCurrentPosition == mQuestionsList!!.size) {
            binding.submitBtn.text = "FINISH"
        } else {
            binding.submitBtn.text = "SUBMIT"
        }
    }

    private fun setDefaultBackground() {
        val options = ArrayList<AppCompatTextView>()
        options.add(binding.option1)
        options.add(binding.option2)
        options.add(binding.option3)
        options.add(binding.option4)

        options.forEach {
            it.setTextColor(Color.parseColor("#7a8089"))
            it.typeface = Typeface.DEFAULT
            it.background = ContextCompat.getDrawable(this, R.drawable.default_background)
        }

    }

    private fun selectedOptionsView(tv: AppCompatTextView, selectedOptionsNum: Int) {
        setDefaultBackground()
        mSelectedPosition = selectedOptionsNum
        tv.setTextColor(Color.parseColor("#363a43"))
        tv.typeface = Typeface.DEFAULT_BOLD
        tv.background = ContextCompat.getDrawable(this, R.drawable.selected_option_background)
    }

    override fun onClick(view: View?) {
        when (view?.id) {
            R.id.option1 -> {
                selectedOptionsView(binding.option1, 1)
            }

            R.id.option2 -> {
                selectedOptionsView(binding.option2, 2)
            }

            R.id.option3 -> {
                selectedOptionsView(binding.option3, 3)
            }

            R.id.option4 -> {
                selectedOptionsView(binding.option4, 4)
            }

            R.id.submitBtn -> {
                if (mSelectedPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList?.size!! -> {
                            setQuestion()
                        }

                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(USER_NAME, mUserName)
                            intent.putExtra(TOTAL_QUESTIONS, mQuestionsList!!.size)
                            intent.putExtra(CORRECT_ANSWERS, mCorrectAnswers)
                            startActivity(intent)
                        }
                    }
                } else {
                    val currentQuestion = mQuestionsList!![mCurrentPosition - 1]
                    if (currentQuestion.correctAnswer != mSelectedPosition) {
                        answerView(mSelectedPosition, R.drawable.wrong_answer_background)
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(currentQuestion.correctAnswer, R.drawable.correct_answer_background)
                    if (mCurrentPosition == mQuestionsList!!.size) {
                        binding.submitBtn.text = "Finish"
                    } else {
                        binding.submitBtn.text = "Goto next question"
                    }
                    mSelectedPosition = 0
                }
            }
        }
    }

    private fun answerView(answer: Int, drawableView: Int) {
        when (answer) {
            1 -> {
                binding.option1.background = ContextCompat.getDrawable(this, drawableView)
            }
            2 -> {
                binding.option2.background = ContextCompat.getDrawable(this, drawableView)
            }
            3 -> {
                binding.option3.background = ContextCompat.getDrawable(this, drawableView)
            }
            4 -> {
                binding.option4.background = ContextCompat.getDrawable(this, drawableView)
            }

        }
    }
}