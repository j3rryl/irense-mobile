package com.example.irense

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {

    private lateinit var firebaseAuth: FirebaseAuth

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        firebaseAuth = FirebaseAuth.getInstance()
        val signIn = findViewById<Button>(R.id.sign_in)
        val usernameInput = findViewById<TextInputEditText>(R.id.username_input)
        val passwordInput = findViewById<TextInputEditText>(R.id.password_input)

        signIn.setOnClickListener {
            val username = usernameInput.text.toString().trim()
            val password = passwordInput.text.toString().trim()

            if(username.isNotEmpty() && password.isNotEmpty()){
                firebaseAuth.signInWithEmailAndPassword(username, password).addOnCompleteListener{
                    if(it.isSuccessful){
                        val intent = Intent(this, MainActivity::class.java)
                        startActivity(intent)
                    } else {
                        Toast.makeText(this, it.exception.toString(), Toast.LENGTH_LONG).show()
                    }
                }
            } else {
                Toast.makeText(this, "Fill in all fields.", Toast.LENGTH_LONG).show()
            }
        }
    }

    override fun onStart() {
        super.onStart()
        if(firebaseAuth.currentUser!=null){
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}