package com.example.final_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.FrameLayout
import android.widget.TextView
import androidx.cardview.widget.CardView

class ListenActivity : AppCompatActivity() {

    lateinit var framelayout_listen_play: FrameLayout
    lateinit var cardview_listen_1: CardView
    lateinit var cardview_listen_2: CardView
    lateinit var cardview_listen_3: CardView
    lateinit var cardview_listen_4: CardView
    lateinit var text_listen_1: TextView
    lateinit var text_listen_2: TextView
    lateinit var text_listen_3: TextView
    lateinit var text_listen_4: TextView

    lateinit var button_listen: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_listen)

        setReferences()


    }

    private fun setReferences() {
        button_listen = findViewById(R.id.button_listen)
        framelayout_listen_play = findViewById(R.id.framelayout_listen_play)
        cardview_listen_1 = findViewById(R.id.cardview_listen_1)
        cardview_listen_2 = findViewById(R.id.cardview_listen_2)
        cardview_listen_3 = findViewById(R.id.cardview_listen_3)
        cardview_listen_4 = findViewById(R.id.cardview_listen_4)
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