package com.example.final_assignment

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.*
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat

class ListenActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var framelayout_btn_play: FrameLayout
    private lateinit var imageView_listen_1: ImageView
    private lateinit var imageView_listen_2: ImageView
    private lateinit var imageView_listen_3: ImageView
    private lateinit var imageView_listen_4: ImageView
    private lateinit var cardview_listen_1: CardView
    private lateinit var cardview_listen_2: CardView
    private lateinit var cardview_listen_3: CardView
    private lateinit var cardview_listen_4: CardView
    private lateinit var text_listen_1: TextView
    private lateinit var text_listen_2: TextView
    private lateinit var text_listen_3: TextView
    private lateinit var text_listen_4: TextView
    private lateinit var button_submit: Button

    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<Listen>? = null

    private var mCorrectAnswers: Int = 0
    private var mSelectedOptionPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listen)
        mQuestionsList = Constants.getQuestions()
        setReferences()

        //Set the Question
        setQuestion()

        //THis is the click event
        cardview_listen_1.setOnClickListener(this)
        cardview_listen_2.setOnClickListener(this)
        cardview_listen_3.setOnClickListener(this)
        cardview_listen_4.setOnClickListener(this)
        framelayout_btn_play.setOnClickListener(this)
        button_submit.setOnClickListener(this)

        //when loaded different sound effect when different question
        LoadTheSound()


    }

    //Loaded the sound effect for the question
    private fun LoadTheSound() {
        framelayout_btn_play.setOnClickListener {
            if (mCurrentPosition == 1) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.tiger)
                mediaPlayer.start()
            } else if (mCurrentPosition == 2) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.whale)
                mediaPlayer.start()
            } else if (mCurrentPosition == 3) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.owl)
                mediaPlayer.start()
            } else if (mCurrentPosition == 4) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.snake)
                mediaPlayer.start()
            } else if (mCurrentPosition == 5) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.chicken)
                mediaPlayer.start()
            } else {
            }
        }
    }

    //declare the the click listener
    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.cardview_listen_1 -> {
                selectedOptionView(cardview_listen_1, 1)
            }
            R.id.cardview_listen_2 -> {
                selectedOptionView(cardview_listen_2, 2)
            }
            R.id.cardview_listen_3 -> {
                selectedOptionView(cardview_listen_3, 3)
            }
            R.id.cardview_listen_4 -> {
                selectedOptionView(cardview_listen_4, 4)
            }
            R.id.button_submit -> {
                if (mSelectedOptionPosition == 0) {
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants.TOTAL_QUESTIONS, mQuestionsList!!.size)
                            startActivity(intent)
                        }
                    }
                } else {
                    val question = mQuestionsList?.get(mCurrentPosition - 1)

                    // This is to check if the answer is wrong
                    if (question!!.correctAnswer != mSelectedOptionPosition) {
                        answerView(
                            mSelectedOptionPosition,
                            R.drawable.wrong_border
                        )
                    } else {
                        mCorrectAnswers++
                    }
                    answerView(
                        question.correctAnswer,
                        R.drawable.correct_border
                    )

                    // This is for correct answer
                    if (mCurrentPosition == mQuestionsList!!.size) {
                        button_submit.text = "FINISH"
                    } else {
                        button_submit.text = "Next Question"
                    }
                    mSelectedOptionPosition = 0
                }

            }


        }
    }

    //this will be handle to set the question to which the item already
    private fun setQuestion() {
        button_submit.visibility = View.INVISIBLE

        // Getting the question from the list with the help of current position.
        val question = mQuestionsList!!.get(mCurrentPosition - 1)

        defaultOptionsView()

        //if the position of question is last then change the text of the button
        if (mCurrentPosition == mQuestionsList!!.size) {
            button_submit.text = "SUBMIT"
        } else {
            button_submit.text = "SUBMIT"
        }

        imageView_listen_1.setImageResource(question.image_1)
        text_listen_1.text = question.text_1
        imageView_listen_2.setImageResource(question.image_2)
        text_listen_2.text = question.text_2
        imageView_listen_3.setImageResource(question.image_3)
        text_listen_3.text = question.text_3
        imageView_listen_4.setImageResource(question.image_4)
        text_listen_4.text = question.text_4

    }

    //declare user when click on the card view will be got selected broader line
    private fun selectedOptionView(CV: CardView, selectedOptionNum: Int) {

        defaultOptionsView()

        mSelectedOptionPosition = selectedOptionNum
        button_submit.visibility = View.VISIBLE
        CV.background = ContextCompat.getDrawable(
            this@ListenActivity,
            R.drawable.selected_border
        )
    }

    //default options view when the new question is loaded or when the answer is reselected
    private fun defaultOptionsView() {

        val options = ArrayList<CardView>()
        options.add(0, cardview_listen_1)
        options.add(1, cardview_listen_2)
        options.add(2, cardview_listen_3)
        options.add(3, cardview_listen_4)

        for (option in options) {
            option.background = ContextCompat.getDrawable(
                this@ListenActivity,
                R.drawable.default_border
            )
        }
    }

    //default options view when the new question is loaded or when the answer is reselected
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                cardview_listen_1.background = ContextCompat.getDrawable(
                    this@ListenActivity,
                    drawableView
                )
            }
            2 -> {
                cardview_listen_2.background = ContextCompat.getDrawable(
                    this@ListenActivity,
                    drawableView
                )
            }
            3 -> {
                cardview_listen_3.background = ContextCompat.getDrawable(
                    this@ListenActivity,
                    drawableView
                )
            }
            4 -> {
                cardview_listen_4.background = ContextCompat.getDrawable(
                    this@ListenActivity,
                    drawableView
                )
            }
        }
    }

    private fun setReferences() {
        button_submit = findViewById(R.id.button_submit)
        framelayout_btn_play = findViewById(R.id.framelayout_shadow)
        imageView_listen_1 = findViewById(R.id.imageView_listen_1)
        imageView_listen_2 = findViewById(R.id.imageView_listen_2)
        imageView_listen_3 = findViewById(R.id.imageView_listen_3)
        imageView_listen_4 = findViewById(R.id.imageView_listen_4)
        text_listen_1 = findViewById(R.id.text_listen_1)
        text_listen_2 = findViewById(R.id.text_listen_2)
        text_listen_3 = findViewById(R.id.text_listen_3)
        text_listen_4 = findViewById(R.id.text_listen_4)
        cardview_listen_1 = findViewById(R.id.cardview_listen_1)
        cardview_listen_2 = findViewById(R.id.cardview_listen_2)
        cardview_listen_3 = findViewById(R.id.cardview_listen_3)
        cardview_listen_4 = findViewById(R.id.cardview_listen_4)
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.action_learn -> {

                val intent = Intent(this, MainActivity::class.java)
                startActivity(intent)
                true
            }
            R.id.action_play -> {

                val intent = Intent(this, PlayActivity::class.java)
                startActivity(intent)
                true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }


}