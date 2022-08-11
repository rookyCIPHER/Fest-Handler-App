package com.example.festhandler


import android.content.Intent
import android.os.Bundle
import android.provider.MediaStore.ACTION_IMAGE_CAPTURE
import androidx.appcompat.app.AppCompatActivity
import com.example.festhandler.data.MapActivity
import com.example.festhandler.databinding.ActivityMain2Binding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase



class MainActivity2 : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMain2Binding

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMain2Binding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.email.text = intent.getStringExtra("Email")

        val emailtext=binding.email.text
        binding.camera.setOnClickListener {
            startActivity(Intent(ACTION_IMAGE_CAPTURE))
        }

        binding.about.setOnClickListener {
            val intent = Intent(this, MainActivity3::class.java)
            startActivity(intent)
        }

        binding.map.setOnClickListener {
            startActivity(Intent(this,MapActivity::class.java))
        }

        auth = Firebase.auth

        binding.logout.setOnClickListener {
            Firebase.auth.signOut()


            val intent4 = Intent(this, MainActivity::class.java)

            startActivity(intent4)
            finish()

        }


    }
}