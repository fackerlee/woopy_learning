package com.example.final_assignment

object Constants2 {
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val TOTAL_QUESTIONS: String = "total_questions"
    fun getQuestions(): ArrayList<Listen> {
        val questionsList = ArrayList<Listen>()

        // 1
        val que1 = Listen(
            1,
            R.drawable.icon_12,
            "TssIGER",
            R.drawable.icon_06,
            "SssNAKE",
            R.drawable.icon_11,
            "EssLEPHANT",
            R.drawable.icon_07,
            "RED FOX",
            1
        )

        questionsList.add(que1)

        //2
        val que2 = Listen(
            2,
            R.drawable.icon_13,
            "SEssAL",
            R.drawable.icon_14,
            "DOssLPHIN",
            R.drawable.icon_05,
            "WssHALE",
            R.drawable.icon_15,
            "POssLAR BEAR",
            1
        )
        questionsList.add(que2)


        return questionsList
    }
}