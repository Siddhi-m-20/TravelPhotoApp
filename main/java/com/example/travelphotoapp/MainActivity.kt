package com.example.travelphotoapp

import android.os.Bundle
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private var currentImage = 0
    private lateinit var imageViews: List<ImageView>

    var places= arrayOf("Hirayanakeshi Temple","Malai Pathar","Sunset Point","Sunrise point","snake" ,"sunset pt","snake","WaterFall")

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnPrev = findViewById<ImageButton>(R.id.btnPrev)
        val btnNext = findViewById<ImageButton>(R.id.btnNext)
        val placeName=findViewById<TextView>(R.id.tVName)



        // Initialize the list of ImageViews
        imageViews = listOf(
            findViewById(R.id.images0),
            findViewById(R.id.images1),
            findViewById(R.id.images2),
            findViewById(R.id.images3),
            findViewById(R.id.images4),
            findViewById(R.id.images5),
            findViewById(R.id.images6),
            findViewById(R.id.images7)
        )

        // Initialize the first image
        updateImage()

        btnNext.setOnClickListener {
            currentImage = (currentImage + 1) % imageViews.size // Use the size of the list
            placeName.text=places[currentImage]
            updateImage()
        }

        btnPrev.setOnClickListener {
            currentImage = (currentImage - 1 + imageViews.size) % imageViews.size // Use the size of the list
            placeName.text=places[currentImage]
            updateImage()
        }
    }

    private fun updateImage() {
        // Hide all images first
        for (imageView in imageViews) {
            imageView.alpha = 0f // Fade out all images
        }

        // Show the current image
        val currentImageView = imageViews[currentImage]
        currentImageView.alpha = 1f // Fade in the current image

    }
}