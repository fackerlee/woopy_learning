package com.example.final_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.view.Menu
import android.widget.*
import render.animations.Attention
import render.animations.Render

class BirdAnimalsActivity : AppCompatActivity() {

    private lateinit var title_animal: TextView
    private lateinit var image_animal: ImageView
    private lateinit var content_diet: TextView
    private lateinit var content_habitat: TextView
    private lateinit var content_lifespan: TextView
    private lateinit var content_speed: TextView
    private lateinit var button_next: FrameLayout
    private lateinit var framelayout_btn_icon_speaker: FrameLayout
    private lateinit var bg_ice: ImageView

    val animals = arrayOf(
        Animal("Eagle"
            , R.drawable.eagle, "Carnivores", "Wetlands, on the coasts and in marshes", "23-28 Years", "320 km/h"
        ),
        Animal("Owl"
            , R.drawable.owl, "Carnivores", "Forests, mountains, deserts, and plains", "5-15 Years", "45 km/h"
        ),
        Animal("Peafowl"
            , R.drawable.peafowls, "Omnivores", "Forests and farmland", "10-25 Years", "16 km/h"
        ),
        Animal("Crow"
            , R.drawable.crow, "Omnivores", "Forests, grasslands, agricultural areas and farmland", "10-15 Years", "45 km/h"
        )
    )
    private var index:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_bird_animals)
        setReference()
        setListeners()
        loadBook(0)

        framelayout_btn_icon_speaker = findViewById(R.id.framelayout_btn_icon_speaker)

        framelayout_btn_icon_speaker.setOnClickListener {
            val mediaPlayer = MediaPlayer.create(this, R.raw.snake)
            mediaPlayer.start()

        }
    }

    private fun loadBook(index: Int = 0){
        title_animal.text = animals[index].text_animal
        image_animal.setImageResource(animals[index].image)
        content_diet.text = animals[index].text_diet
        content_habitat.text = animals[index].text_habitat
        content_lifespan.text = animals[index].text_lifespan
        content_speed.text = animals[index].text_speed
    }

    private fun setListeners() {

        button_next.setOnClickListener {

            val render = Render(this@BirdAnimalsActivity)

            render.setAnimation(Attention.Wobble(title_animal))
            render.start()

            index++

            if (index == animals.size)
                index = 0

            loadBook(index)

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        // Inflate the menu; this adds items to the action bar if it is present.
        menuInflater.inflate(R.menu.menu_main, menu)
        return true
    }

    private fun setReference(){
        title_animal = findViewById(R.id.textview_title)
        image_animal = findViewById(R.id.image_animals)
        content_diet = findViewById(R.id.textview_diet)
        content_habitat = findViewById(R.id.textview_habitat)
        content_lifespan = findViewById(R.id.textview_lifespan)
        content_speed = findViewById(R.id.textview_speed)
        button_next = findViewById(R.id.framelayout_btn_icon_next)
        bg_ice = findViewById(R.id.image_bg)
    }
}