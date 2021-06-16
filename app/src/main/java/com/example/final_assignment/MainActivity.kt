package com.example.final_assignment

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import com.realpacific.clickshrinkeffect.applyClickShrink
import render.animations.Attention
import render.animations.Render

class MainActivity : AppCompatActivity() {

    private lateinit var framelayout_wild: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))

        framelayout_wild = findViewById(R.id.framelayout_wild)

        val render = Render(this@MainActivity)
        render.setAnimation(Attention.Wobble(framelayout_wild))
        render.setDuration(3000)
        render.start()

        framelayout_wild.setOnClickListener {

        }
        framelayout_wild.applyClickShrink()
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
            R.id.action_learn -> true

            else -> super.onOptionsItemSelected(item)
        }
    }

}