package com.example.final_assignment

import android.content.Intent
import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView

class ListenActivity : AppCompatActivity() {

    private lateinit var framelayout_btn_play: FrameLayout
    private lateinit var imageView_listen_1: ImageView
    private lateinit var imageView_listen_2: ImageView
    private lateinit var imageView_listen_3: ImageView
    private lateinit var imageView_listen_4: ImageView
    private lateinit var text_listen_1: TextView
    private lateinit var text_listen_2: TextView
    private lateinit var text_listen_3: TextView
    private lateinit var text_listen_4: TextView
    private lateinit var button_submit: Button

    val options = arrayOf(
        Listen(
            R.drawable.icon_12, "TIGER", R.drawable.icon_06, "SNAKE", R.drawable.icon_11, "ELEPHANT", R.drawable.icon_07, "RED FOX"
        ),
        Listen(
            R.drawable.icon_13, "SEAL", R.drawable.icon_14, "DOLPHIN", R.drawable.icon_05, "WHALE", R.drawable.icon_15, "POLAR BEAR"
        ),
        Listen(
            R.drawable.icon_17, "CROW", R.drawable.icon_20, "PEAFOWL", R.drawable.icon_19, "OWL", R.drawable.icon_18, "EAGLE"
        )
    )

    private var index:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listen)

        setReferences()
        setListeners()
        loadAnimal()

        framelayout_btn_play.setOnClickListener {
            if (index == 0) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.tiger)
                mediaPlayer.start()
            } else if (index == 1) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.whale)
                mediaPlayer.start()
            } else if (index == 2) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.owl)
                mediaPlayer.start()
            } else {
            }
        }
    }

    private fun loadAnimal(index: Int = 0){
        imageView_listen_1.setImageResource(options[index].image_1)
        text_listen_1.text = options[index].text_1
        imageView_listen_2.setImageResource(options[index].image_2)
        text_listen_2.text = options[index].text_2
        imageView_listen_3.setImageResource(options[index].image_3)
        text_listen_3.text = options[index].text_3
        imageView_listen_4.setImageResource(options[index].image_4)
        text_listen_4.text = options[index].text_4
    }

    private fun setListeners() {
        button_submit.setOnClickListener {
            //move to the next index position
            index++
            //reset to the first question
            if (index == options.size)
                index = 0

            loadAnimal(index)     //load and update animal options
        }
    }

    private fun setReferences() {
        button_submit = findViewById(R.id.button_submit)
        framelayout_btn_play = findViewById(R.id.framelayout_btn_play)
        imageView_listen_1 = findViewById(R.id.imageView_listen_1)
        imageView_listen_2 = findViewById(R.id.imageView_listen_2)
        imageView_listen_3 = findViewById(R.id.imageView_listen_3)
        imageView_listen_4 = findViewById(R.id.imageView_listen_4)
        text_listen_1 = findViewById(R.id.text_listen_1)
        text_listen_2 = findViewById(R.id.text_listen_2)
        text_listen_3 = findViewById(R.id.text_listen_3)
        text_listen_4 = findViewById(R.id.text_listen_4)
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