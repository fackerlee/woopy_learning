package com.example.final_assignment

object Constants {
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val TOTAL_QUESTIONS: String = "total_questions"
    fun getQuestions(): ArrayList<Listen> {
        val questionsList = ArrayList<Listen>()

        // 1
        val que1 = Listen(
            1,
            R.drawable.icon_12,
            "TIGER",
            R.drawable.icon_06,
            "SNAKE",
            R.drawable.icon_11,
            "ELEPHANT",
            R.drawable.icon_07,
            "RED FOX",
            1
        )

        questionsList.add(que1)

        //2
        val que2 = Listen(
            2,
            R.drawable.icon_13,
            "SEAL",
            R.drawable.icon_14,
            "DOLPHIN",
            R.drawable.icon_05,
            "WHALE",
            R.drawable.icon_15,
            "POLAR BEAR",
            3
        )
        questionsList.add(que2)

        //3
        val que3 = Listen(
            3,
            R.drawable.icon_18,
            "EAGLE",
            R.drawable.icon_19,
            "OWL",
            R.drawable.icon_13,
            "SEAL",
            R.drawable.icon_11,
            "ELEPHANT",
            2
        )
        questionsList.add(que3)

        //4
        val que4 = Listen(
            4,
            R.drawable.icon_09,
            "MONKEY",
            R.drawable.icon_04,
            "CHICKEN",
            R.drawable.icon_01,
            "PIG",
            R.drawable.icon_06,
            "SNAKE",
            4
        )
        questionsList.add(que4)

        //5
        val que5 = Listen(
            5,
            R.drawable.icon_04,
            "CHICKEN",
            R.drawable.icon_18,
            "EAGLE",
            R.drawable.icon_14,
            "DOLPHIN",
            R.drawable.icon_07,
            "RED FOX",
            1
        )
        questionsList.add(que5)

        return questionsList
    }
}