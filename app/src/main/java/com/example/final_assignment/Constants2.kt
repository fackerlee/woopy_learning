package com.example.final_assignment

object Constants2 {
    // Declare value string
    const val CORRECT_ANSWERS: String = "correct_answers"
    const val TOTAL_QUESTIONS: String = "total_questions"
    // Create questions array lists
    fun getQuestions(): ArrayList<Listen> {
        val questionsList = ArrayList<Listen>()

        // 1
        val que1 = Listen(
            1,
            R.drawable.dolphin,
            "DOLPHIN",
            R.drawable.peafowls,
            "PEAFOWLS",
            R.drawable.owl,
            "OWL",
            R.drawable.lion,
            "LION",
            3
        )

        questionsList.add(que1)

        //2
        val que2 = Listen(
            2,
            R.drawable.pig,
            "PIG",
            R.drawable.fox,
            "FOX",
            R.drawable.monkey,
            "MONKEY",
            R.drawable.tiger,
            "TIGER",
            1
        )
        questionsList.add(que2)

        //3
        val que3 = Listen(
            3,
            R.drawable.horse,
            "HORSE",
            R.drawable.elephant,
            "ELEPHANT",
            R.drawable.lion,
            "LION",
            R.drawable.cow,
            "COW",
            4
        )
        questionsList.add(que3)

        //4
        val que4 = Listen(
            4,
            R.drawable.dolphin,
            "DOLPHIN",
            R.drawable.seal,
            "SEAL",
            R.drawable.whale,
            "WHALE",
            R.drawable.polarbear,
            "POLAR BEAR",
            2
        )
        questionsList.add(que4)

        //5
        val que5 = Listen(
            5,
            R.drawable.fox,
            "FOX",
            R.drawable.snake_1,
            "SNAKE",
            R.drawable.giraffe,
            "GIRAFFE",
            R.drawable.hippopotamus,
            "HIPPOPOTAMUS",
            1
        )
        questionsList.add(que5)

        return questionsList
    }
}