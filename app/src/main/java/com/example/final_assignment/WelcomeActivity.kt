package com.example.final_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.animation.Animation
import android.widget.FrameLayout
import com.realpacific.clickshrinkeffect.applyClickShrink

class WelcomeActivity : AppCompatActivity() {

    private lateinit var framelayout_btn_icon: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)


        framelayout_btn_icon = findViewById(R.id.framelayout_btn_icon)

        framelayout_btn_icon.setOnClickListener {

            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)

        }

        framelayout_btn_icon.applyClickShrink()

    }
}