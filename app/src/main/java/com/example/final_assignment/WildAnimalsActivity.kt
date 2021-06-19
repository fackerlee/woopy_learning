package com.example.final_assignment

import android.media.MediaPlayer
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout

class WildAnimalsActivity : AppCompatActivity() {

    private lateinit var framelayout_btn_icon_speaker: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_wild_animals)
        setSupportActionBar(findViewById(R.id.toolbar))

        framelayout_btn_icon_speaker = findViewById(R.id.framelayout_btn_icon_speaker)

        framelayout_btn_icon_speaker.setOnClickListener {
            var mediaPlayer = MediaPlayer.create(this, R.raw.snake)
            mediaPlayer.start()


        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

}

