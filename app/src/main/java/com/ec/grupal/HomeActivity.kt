package com.ec.grupal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.ec.grupal.databinding.ActivityAuthBinding
import com.ec.grupal.databinding.ActivityHomeBinding
import com.google.firebase.auth.FirebaseAuth

enum class ProviderType{
    BASIC
}

class HomeActivity : AppCompatActivity() {
    private lateinit var binding: ActivityHomeBinding


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val bundle: Bundle? = intent.extras
        val email:String? =  bundle?.getString("email")
        val provider:String? =  bundle?.getString("provider")
        setup(email?:"", provider?:"")
    }

    private fun setup(email:String , provider: String){
        title = "inicio"
        binding.emailTextView.text = email
        binding.providerTextView.text = provider
        binding.logoutbutton.setOnClickListener {
            FirebaseAuth.getInstance().signOut()
            onBackPressed()
        }
    }
}