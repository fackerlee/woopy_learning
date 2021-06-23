package com.example.final_assignment

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.view.Menu
import android.view.MenuItem
import android.widget.*
import androidx.cardview.widget.CardView
import com.realpacific.clickshrinkeffect.applyClickShrink
import render.animations.Attention
import render.animations.Bounce
import render.animations.Render

class BirdAnimalsActivity : AppCompatActivity() {

    //GUI components
    private lateinit var title_animal: TextView
    private lateinit var image_animal: ImageView
    private lateinit var content_diet: TextView
    private lateinit var content_habitat: TextView
    private lateinit var content_lifespan: TextView
    private lateinit var content_speed: TextView
    private lateinit var button_next: FrameLayout
    private lateinit var framelayout_btn_icon_speaker: FrameLayout
    private lateinit var bg_ice: ImageView
    private lateinit var cardView_image: CardView
    //declared components that need animation
    val render_title = Render(this@BirdAnimalsActivity)
    val render_image = Render(this@BirdAnimalsActivity)
    val render_diet = Render(this@BirdAnimalsActivity)
    val render_habitat = Render(this@BirdAnimalsActivity)
    val render_lifespan = Render(this@BirdAnimalsActivity)
    val render_speed = Render(this@BirdAnimalsActivity)

    //create a set of bird animal details
    val animals = arrayOf(
        Animal(
            "Eagle", R.drawable.eagle, "Carnivores", "Wetlands, on the coasts and in marshes", "23-28 Years", "320 km/h"
        ),
        Animal(
            "Owl", R.drawable.owl, "Carnivores", "Forests, mountains, deserts, and plains", "5-15 Years", "45 km/h"
        ),
        Animal(
            "Peafowl", R.drawable.peafowls, "Omnivores", "Forests and farmland", "10-25 Years", "16 km/h"
        ),
        Animal("Crow"
            , R.drawable.crow, "Omnivores", "Forests, grasslands, agricultural areas and farmland", "10-15 Years", "45 km/h"
        )
    )
    private var index:Int = 0   //index used to keep track the animal details

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bird_animals)
        setReference()      //set GUI references
        setListeners()      //create event handling for the button
        loadAnimal(0)   //load the first animal details

        //set animation for the first animal details
        render_title.setAnimation(Attention.Shake(title_animal))
        render_image.setAnimation(Bounce.InLeft(cardView_image))
        render_diet.setAnimation(Bounce.InLeft(content_diet))
        render_habitat.setAnimation(Bounce.InLeft(content_habitat))
        render_lifespan.setAnimation(Bounce.InLeft(content_lifespan))
        render_speed.setAnimation(Bounce.InLeft(content_speed))
        //set animation duration
        render_title.setDuration(1000)
        render_image.setDuration(1000)
        render_diet.setDuration(1000)
        render_habitat.setDuration(1000)
        render_lifespan.setDuration(1000)
        render_speed.setDuration(1000)
        //start animation
        render_title.start()
        render_image.start()
        render_diet.start()
        render_habitat.start()
        render_lifespan.start()
        render_speed.start()
        //apply click animation
        framelayout_btn_icon_speaker.applyClickShrink()
        button_next.applyClickShrink()

        //play animal sound after button speaker is clicked
        framelayout_btn_icon_speaker.setOnClickListener {
            if (index == 0) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.eagle)
                mediaPlayer.start()
            } else if (index == 1) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.owl)
                mediaPlayer.start()
            } else if (index == 2) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.peafowl)
                mediaPlayer.start()
            } else if (index == 3) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.crow)
                mediaPlayer.start()
            } else {
            }
        }
    }
    //function for load and change animal details
    private fun loadAnimal(index: Int = 0){
        title_animal.text = animals[index].text_animal
        image_animal.setImageResource(animals[index].image)
        content_diet.text = animals[index].text_diet
        content_habitat.text = animals[index].text_habitat
        content_lifespan.text = animals[index].text_lifespan
        content_speed.text = animals[index].text_speed
    }
    //function for setting listener to populate the next animal
    private fun setListeners() {
        button_next.setOnClickListener {
            //set animation for the next animal details
            render_title.setAnimation(Attention.Shake(title_animal))
            render_image.setAnimation(Bounce.InLeft(cardView_image))
            render_diet.setAnimation(Bounce.InLeft(content_diet))
            render_habitat.setAnimation(Bounce.InLeft(content_habitat))
            render_lifespan.setAnimation(Bounce.InLeft(content_lifespan))
            render_speed.setAnimation(Bounce.InLeft(content_speed))
            //start animation
            render_title.start()
            render_image.start()
            render_diet.start()
            render_habitat.start()
            render_lifespan.start()
            render_speed.start()
            //move to the next index position
            index++
            //reset to the first animal
            if (index == animals.size)
                index = 0

            loadAnimal(index)     //load and update animal details
        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }
    //set GUI references
    private fun setReference() {
        framelayout_btn_icon_speaker = findViewById(R.id.framelayout_btn_icon_speaker)
        cardView_image = findViewById(R.id.cardView_image)
        title_animal = findViewById(R.id.textview_title)
        image_animal = findViewById(R.id.image_animals)
        content_diet = findViewById(R.id.textview_diet)
        content_habitat = findViewById(R.id.textview_habitat)
        content_lifespan = findViewById(R.id.textview_lifespan)
        content_speed = findViewById(R.id.textview_speed)
        button_next = findViewById(R.id.framelayout_btn_icon_next)
        bg_ice = findViewById(R.id.image_bg)
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