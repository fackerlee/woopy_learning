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
import com.realpacific.clickshrinkeffect.applyClickShrink

class ResultActivity : AppCompatActivity() {

    //GUI components
    private lateinit var button_finish: Button
    private lateinit var text_score: TextView
    private lateinit var text_total: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_result)

        //set references
        button_finish = findViewById(R.id.button_finish)
        text_score = findViewById(R.id.text_score)
        text_total = findViewById(R.id.text_total)

        button_finish.visibility = View.VISIBLE

        //set click listener
        button_finish.setOnClickListener {
            startActivity(Intent(this, PlayActivity::class.java))
            finish()
        }

        //calculate correct answers and total questions
        val totalQuestions = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)
        text_score.text = "$correctAnswers"
        text_total.text = "$totalQuestions"

        //apply click animation
        button_finish.applyClickShrink()
    }
}