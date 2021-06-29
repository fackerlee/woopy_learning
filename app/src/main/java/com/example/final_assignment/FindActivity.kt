package com.example.final_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.core.content.ContextCompat
import com.realpacific.clickshrinkeffect.applyClickShrink

class FindActivity : AppCompatActivity(), View.OnClickListener {

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
    private lateinit var animal_shadow: ImageView
    private lateinit var button_submit: Button

    private var mCurrentPosition: Int = 1 // Default and the first question position
    private var mQuestionsList: ArrayList<Listen>? = null

    private var mCorrectAnswers: Int = 0
    private var mSelectedOptionPosition: Int = 0


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_find)

        mQuestionsList = Constants2.getQuestions()
        setReferences()

        //Set the Question
        setQuestion()

        if (savedInstanceState != null) {
            mCurrentPosition = savedInstanceState.getInt("CurrentPosition", 0)
            mCorrectAnswers = savedInstanceState.getInt("mCorrectAnswers", 0)
        }

        //THis is the click event
        cardview_listen_1.setOnClickListener(this)
        cardview_listen_2.setOnClickListener(this)
        cardview_listen_3.setOnClickListener(this)
        cardview_listen_4.setOnClickListener(this)
        button_submit.setOnClickListener(this)

        LoadAnimalShadow()

        button_submit.applyClickShrink()
        cardview_listen_1.applyClickShrink()
        cardview_listen_2.applyClickShrink()
        cardview_listen_3.applyClickShrink()
        cardview_listen_4.applyClickShrink()
    }

    private fun LoadAnimalShadow() {
            if (mCurrentPosition == 1) {
                animal_shadow.setImageResource(R.drawable.owl_shadow)
            } else if (mCurrentPosition == 2) {
                animal_shadow.setImageResource(R.drawable.pig_shadow)
            } else if (mCurrentPosition == 3) {
                animal_shadow.setImageResource(R.drawable.cow_shadow)
            } else if (mCurrentPosition == 4) {
                animal_shadow.setImageResource(R.drawable.seal_shadow)
            } else if (mCurrentPosition == 5) {
                animal_shadow.setImageResource(R.drawable.fox_shadow)
            } else {
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
                    enableClick()
                    mCurrentPosition++

                    when {
                        mCurrentPosition <= mQuestionsList!!.size -> {
                            setQuestion()
                            LoadAnimalShadow()
                        }
                        else -> {
                            val intent = Intent(this, ResultActivity::class.java)
                            intent.putExtra(Constants2.CORRECT_ANSWERS, mCorrectAnswers)
                            intent.putExtra(Constants2.TOTAL_QUESTIONS, mQuestionsList!!.size)
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
                        disableClick()
                    } else {
                        button_submit.text = "Next Question"
                        disableClick()
                    }
                    mSelectedOptionPosition = 0

                }
            }
        }
    }

    //function to disable user to click on the answer
    private fun disableClick() {
        cardview_listen_1.isClickable = false
        cardview_listen_2.isClickable = false
        cardview_listen_3.isClickable = false
        cardview_listen_4.isClickable = false
    }
    //function to enable user to click on the answer
    private fun enableClick() {
        cardview_listen_1.isClickable = true
        cardview_listen_2.isClickable = true
        cardview_listen_3.isClickable = true
        cardview_listen_4.isClickable = true
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
            this@FindActivity,
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
                this@FindActivity,
                R.drawable.default_border
            )
        }
    }

    //default options view when the new question is loaded or when the answer is reselected
    private fun answerView(answer: Int, drawableView: Int) {

        when (answer) {

            1 -> {
                cardview_listen_1.background = ContextCompat.getDrawable(
                    this@FindActivity,
                    drawableView
                )
            }
            2 -> {
                cardview_listen_2.background = ContextCompat.getDrawable(
                    this@FindActivity,
                    drawableView
                )
            }
            3 -> {
                cardview_listen_3.background = ContextCompat.getDrawable(
                    this@FindActivity,
                    drawableView
                )
            }
            4 -> {
                cardview_listen_4.background = ContextCompat.getDrawable(
                    this@FindActivity,
                    drawableView
                )
            }
        }
    }

    private fun setReferences() {
        button_submit = findViewById(R.id.button_submit)
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
        animal_shadow = findViewById(R.id.animal_shadow)
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putInt("CurrentPosition", mCurrentPosition)
        outState.putInt("mCorrectAnswers", mCorrectAnswers)

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