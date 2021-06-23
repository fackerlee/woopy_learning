package com.example.final_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.widget.FrameLayout

class PlayActivity : AppCompatActivity() {

    private lateinit var framelayout_Listen: FrameLayout
    private lateinit var framelayout_Find: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        framelayout_Listen = findViewById(R.id.framelayout_Listen)
        framelayout_Find = findViewById(R.id.framelayout_Find)


        framelayout_Listen.setOnClickListener {
            val intent = Intent(this, ListenActivity::class.java)
            startActivity(intent)

        }

        framelayout_Find.setOnClickListener {
            val intent = Intent(this, FindActivity::class.java)
            startActivity(intent)

        }


    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
}