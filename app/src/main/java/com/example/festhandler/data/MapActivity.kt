package com.example.festhandler.data

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.festhandler.databinding.ActivityMapBinding

class MapActivity : AppCompatActivity() {

    private lateinit var binding:ActivityMapBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMapBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.imageView.setOnClickListener{
            val i = Intent(Intent.ACTION_VIEW, Uri.parse("geo:15.422931681012525, 73.98246269746139"))
            i.setClassName(
                "com.google.android.apps.maps",
                "com.google.android.maps.MapsActivity"
            )
            startActivity(i)
        }


    }
}


