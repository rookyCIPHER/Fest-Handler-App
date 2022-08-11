package com.example.festhandler

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import com.example.festhandler.databinding.ActivityMainBinding
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.api.ApiException
import com.google.android.gms.tasks.Task
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.auth.GoogleAuthProvider
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
//this is branch17
class MainActivity : AppCompatActivity() {

    private companion object {
        private const val TAG = "LOGINACTIvity"
        private const val RC_GOOGLE_SIGN_IN = 4926
    }

    private lateinit var binding: ActivityMainBinding
    private lateinit var auth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        setContentView(R.layout.activity_sign_in)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        setContentView(binding.root)

        auth = Firebase.auth



        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        // Configure sign-in to request the user's ID, email address, and basic
// profile. ID and basic profile are included in DEFAULT_SIGN_IN.
        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestIdToken("852545648688-i53scoe00d0dgv6h4c6jqqgru035cl5b.apps.googleusercontent.com")
            .requestEmail()
            .build()

        var client = GoogleSignIn.getClient(this, gso)
        binding.signinbtn.setOnClickListener {
            val signInIntent = client.signInIntent
            startActivityForResult(signInIntent, RC_GOOGLE_SIGN_IN)
        }

    }

    override fun onStart() {
        super.onStart()

        val currentUser = auth.currentUser
        updateUi(currentUser)
    }


    private fun updateUi(currentUser: FirebaseUser?) {

        if (currentUser == null) {
            Log.i(TAG,"If out")
            return
        }
        Log.i(TAG,"Line70")
        val email = auth.currentUser?.email.toString()
        startActivity(Intent(this, MainActivity2::class.java)
            .putExtra("Email",email.toString()))  /////////////////////////////////////////////
        finish()


    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)



        // Result returned from launching the Intent from GoogleSignInClient.getSignInIntent(...);
        if (requestCode == RC_GOOGLE_SIGN_IN) {
            // The Task returned from this call is always completed, no need to attach
            // a listener.
            val task: Task<GoogleSignInAccount> = GoogleSignIn.getSignedInAccountFromIntent(data)
            try {
                val account = task.getResult(ApiException::class.java)!!
                Log.i(TAG, "firebaeauthgoogle:" + account.id)
                firebaseAuthWithGoogle(account.idToken!!)
            } catch (e: ApiException) {
                Log.i(TAG, "google sigin failed", e)
            }

        }
    }

    private fun firebaseAuthWithGoogle(idToken: String) {
        val credential = GoogleAuthProvider.getCredential(idToken, null)
        auth.signInWithCredential(credential)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.i(TAG, "siging succesfull:success")
                    var user = auth.currentUser
                    updateUi(user)
                } else {
                    Toast.makeText(this, "login failde", Toast.LENGTH_LONG).show()
                    updateUi(null)
                }
            }

    }
}

