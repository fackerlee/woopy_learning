package com.example.final_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import com.realpacific.clickshrinkeffect.applyClickShrink

class PlayActivity : AppCompatActivity() {

    //GUI components
    private lateinit var framelayout_Listen: FrameLayout
    private lateinit var framelayout_Find: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_play)

        //set GUi references
        framelayout_Listen = findViewById(R.id.framelayout_Listen)
        framelayout_Find = findViewById(R.id.framelayout_Find)

        //set click listener
        //clicked and go to ListenActivity
        framelayout_Listen.setOnClickListener {
            val intent = Intent(this, ListenActivity::class.java)
            startActivity(intent)
        }
        //clicked and go to FindActivity
        framelayout_Find.setOnClickListener {
            val intent = Intent(this, FindActivity::class.java)
            startActivity(intent)
        }
        //apply click animation
        framelayout_Listen.applyClickShrink()
        framelayout_Find.applyClickShrink()
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