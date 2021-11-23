package com.schiavone.honorsmobileapps.quizapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.schiavone.honorsmobileapps.quizapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
    }
    data class questionData(val resourceId: Int, val answer:Boolean){
    }
}