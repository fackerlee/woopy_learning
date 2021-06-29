package com.example.final_assignment

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.provider.MediaStore
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.realpacific.clickshrinkeffect.applyClickShrink


class WelcomeActivity : AppCompatActivity() {
    //GUI components
    private lateinit var framelayout_btn_icon: FrameLayout
    private var player: MediaPlayer? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        //set background music
        player = MediaPlayer.create(this, R.raw.bg_music)
        player?.setVolume(0.1f,0.1f)
        player?.isLooping = true
        player?.start()

        //set GUI references
        framelayout_btn_icon = findViewById(R.id.framelayout_btn_icon_next)

        //button clicked and go to MainActivity
        framelayout_btn_icon.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }
        //apply click animation
        framelayout_btn_icon.applyClickShrink()

    }   //end onCreate
}   //end class