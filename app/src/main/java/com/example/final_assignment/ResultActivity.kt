package com.example.final_assignment

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.view.View
import android.view.WindowInsets
import android.view.WindowInsetsController
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity


class ResultActivity : AppCompatActivity() {
    private lateinit var button_finish: Button
    private lateinit var text_score: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        button_finish = findViewById(R.id.button_finish)
        text_score = findViewById(R.id.text_score)

        button_finish.visibility = View.VISIBLE

        button_finish.setOnClickListener {
//            val intent = Intent(this, PlayActivity::class.java)
//            startActivity(intent)
//            finish()
            startActivity(Intent(this, PlayActivity::class.java))
            finish()
        }

        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        text_score.text = "Your score is $correctAnswers out of $totalQuestions"


    }
}