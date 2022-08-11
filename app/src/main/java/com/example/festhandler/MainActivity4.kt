package com.example.festhandler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.festhandler.databinding.ActivityMain4Binding

class MainActivity4 : AppCompatActivity() {

    private lateinit var binding: ActivityMain4Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMain4Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.done.setOnClickListener {
            val message= binding.editedtext.text.toString()
            startActivity(Intent(this, MainActivity3::class.java)
                .putExtra("Edited_Text",message))
        }
    }
}