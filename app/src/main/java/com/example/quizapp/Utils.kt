package com.example.quizapp

import com.example.quizapp.model.Country

object Utils {

    const val USER_NAME = "user_name"
    const val TOTAL_QUESTIONS = "total_questions"
    const val CORRECT_ANSWERS = "correct_answers"

    fun getCountries(): ArrayList<Country> {
        val questionList = arrayListOf<Country>()
        questionList.add(
            Country(
                1,
                "Which country does this flag belongs to?",
                R.drawable.india,
                "India",
                "Germany",
                "Netherlands",
                "usa",
                1
            )
        )

        questionList.add(
            Country(
                1,
                "Which country does this flag belongs to?",
                R.drawable.germany,
                "India",
                "Germany",
                "Netherlands",
                "usa",
                2
            )
        )

        questionList.add(
            Country(
                1,
                "Which country does this flag belongs to?",
                R.drawable.italy,
                "India",
                "Germany",
                "Italy",
                "usa",
                3
            )
        )

        questionList.add(
            Country(
                1,
                "Which country does this flag belongs to?",
                R.drawable.netherland,
                "India",
                "Germany",
                "Netherlands",
                "usa",
                3
            )
        )

        questionList.add(
            Country(
                1,
                "Which country does this flag belongs to?",
                R.drawable.srilanka,
                "India",
                "Germany",
                "Netherlands",
                "srilanka",
                4
            )
        )

        questionList.add(
            Country(
                1,
                "Which country does this flag belongs to?",
                R.drawable.usa,
                "India",
                "Germany",
                "Netherlands",
                "usa",
                4
            )
        )
        return questionList
    }
}