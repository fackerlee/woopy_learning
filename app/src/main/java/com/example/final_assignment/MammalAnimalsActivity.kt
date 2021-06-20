package com.example.final_assignment

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.media.MediaPlayer
import android.view.Menu
import android.widget.*
import androidx.cardview.widget.CardView
import render.animations.Attention
import render.animations.Bounce
import render.animations.Render

class MammalAnimalsActivity : AppCompatActivity() {

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

    val render_title = Render(this@MammalAnimalsActivity)
    val render_image = Render(this@MammalAnimalsActivity)
    val render_diet = Render(this@MammalAnimalsActivity)
    val render_habitat = Render(this@MammalAnimalsActivity)
    val render_lifespan = Render(this@MammalAnimalsActivity)
    val render_speed = Render(this@MammalAnimalsActivity)


    val animals = arrayOf(
        Animal(
            "Monkey",
            R.drawable.monkey,
            "Omnivores",
            "Tropical rainforests of Asia, Africa, and America",
            "15-20 Years",
            "55 km/h"
        ),
        Animal(
            "Lion",
            R.drawable.lion,
            "Carnivores",
            "Grassland, savanna, and open woodland",
            "8-15 Years",
            "80 km/h"
        ),
        Animal(
            "Elephant"
            , R.drawable.elephant, "Herbivores", "Deserts, swamps, and highlands in tropical and subtropical", "60-70 Years", "40 km/h"
        ),
        Animal("Giraffe"
            , R.drawable.giraffe, "Herbivores", "Grasslands and open woodlands in East Africa", "20-26 Years", "60 km/h"
        )
    )
    private var index:Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_mammal_animals)
        setReference()
        setListeners()
        loadBook(0)

        render_title.setAnimation(Attention.Shake(title_animal))
        render_image.setAnimation(Bounce.InLeft(cardView_image))
        render_diet.setAnimation(Bounce.InLeft(content_diet))
        render_habitat.setAnimation(Bounce.InLeft(content_habitat))
        render_lifespan.setAnimation(Bounce.InLeft(content_lifespan))
        render_speed.setAnimation(Bounce.InLeft(content_speed))

        render_title.setDuration(1000)
        render_image.setDuration(1000)
        render_diet.setDuration(1000)
        render_habitat.setDuration(1000)
        render_lifespan.setDuration(1000)
        render_speed.setDuration(1000)

        render_title.start()
        render_image.start()
        render_diet.start()
        render_habitat.start()
        render_lifespan.start()
        render_speed.start()

        framelayout_btn_icon_speaker.setOnClickListener {
            if (index == 0) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.monkey)
                mediaPlayer.start()
            } else if (index == 1) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.lion)
                mediaPlayer.start()
            } else if (index == 2) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.elephant)
                mediaPlayer.start()
            } else if (index == 3) {
                val mediaPlayer = MediaPlayer.create(this, R.raw.girrafe)
                mediaPlayer.start()
            } else {
            }
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

            render_title.setAnimation(Attention.Shake(title_animal))
            render_image.setAnimation(Bounce.InLeft(cardView_image))
            render_diet.setAnimation(Bounce.InLeft(content_diet))
            render_habitat.setAnimation(Bounce.InLeft(content_habitat))
            render_lifespan.setAnimation(Bounce.InLeft(content_lifespan))
            render_speed.setAnimation(Bounce.InLeft(content_speed))

            render_title.start()
            render_image.start()
            render_diet.start()
            render_habitat.start()
            render_lifespan.start()
            render_speed.start()
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

    private fun setReference() {
        cardView_image = findViewById(R.id.cardView_image)
        framelayout_btn_icon_speaker = findViewById(R.id.framelayout_btn_icon_speaker)
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