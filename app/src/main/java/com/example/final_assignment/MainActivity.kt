package com.example.final_assignment

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.Menu
import android.view.MenuItem
import android.widget.FrameLayout
import com.realpacific.clickshrinkeffect.applyClickShrink
import render.animations.Attention
import render.animations.Render

class MainActivity : AppCompatActivity() {

    //GUI components
    private lateinit var framelayout_wild: FrameLayout
    private lateinit var framelayout_sea: FrameLayout
    private lateinit var framelayout_farm: FrameLayout
    private lateinit var framelayout_mammal: FrameLayout
    private lateinit var framelayout_bird: FrameLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_main)

        setReferences()

        setButtonClickEffect()
        //clicked and go to WildAnimalsActivity
        framelayout_wild.setOnClickListener {

            val intent = Intent(this, WildAnimalsActivity::class.java)
            startActivity(intent)

        }
        //clicked and go to SeaAnimalsActivity
        framelayout_sea.setOnClickListener {

            val intent = Intent(this, SeaAnimalsActivity::class.java)
            startActivity(intent)

        }
        //clicked and go to FarmAnimalsActivity
        framelayout_farm.setOnClickListener {

            val intent = Intent(this, FarmAnimalsActivity::class.java)
            startActivity(intent)

        }
        //clicked and go to MammalAnimalsActivity
        framelayout_mammal.setOnClickListener {

            val intent = Intent(this, MammalAnimalsActivity::class.java)
            startActivity(intent)

        }
        //clicked and go to BirdAnimalsActivity
        framelayout_bird.setOnClickListener {

            val intent = Intent(this, BirdAnimalsActivity::class.java)
            startActivity(intent)

        }

    }
    //function apply click animation
    private fun setButtonClickEffect() {
        framelayout_wild.applyClickShrink()
        framelayout_sea.applyClickShrink()
        framelayout_farm.applyClickShrink()
        framelayout_mammal.applyClickShrink()
        framelayout_bird.applyClickShrink()
    }
    //set GUI references
    private fun setReferences() {
        framelayout_wild = findViewById(R.id.framelayout_wild)
        framelayout_sea = findViewById(R.id.framelayout_sea)
        framelayout_farm = findViewById(R.id.framelayout_farm)
        framelayout_mammal = findViewById(R.id.framelayout_mammal)
        framelayout_bird = findViewById(R.id.framelayout_bird)
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
            else -> super.onOptionsItemSelected(item)
        }
    }

}