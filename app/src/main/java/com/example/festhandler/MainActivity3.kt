package com.example.festhandler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import androidx.core.view.isGone
import androidx.core.view.isInvisible
import com.example.festhandler.databinding.ActivityMain3Binding


class MainActivity3 : AppCompatActivity() {

    private lateinit var binding: ActivityMain3Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain3Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textview.text=intent.getStringExtra("Edited_Text")
        binding.edit.setOnClickListener{
            val intent2 = Intent(this, MainActivity4::class.java)
            startActivity(intent2)
        }







//        if (binding.edit.isPressed){
//
//        } else {
//            binding.textview.text="Welcome to ABC Fest, ABC is India's largest Technical meetup, and we are delighted to welcome you to the family. With the expertise of our teammates, we at IIT Goa provide a platform to showcase one's adroitness in spheres of Computational Understanding. And this year is no different. This year we are host to various events, the information about which can be found in the document, whose link is attached below."
//        }






    }
}