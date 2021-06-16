package com.example.final_assignment

import android.content.Intent
import android.os.Bundle
import android.widget.FrameLayout
import androidx.appcompat.app.AppCompatActivity
import com.realpacific.clickshrinkeffect.applyClickShrink
import render.animations.Attention
import render.animations.Render


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