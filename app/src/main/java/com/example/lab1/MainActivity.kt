package com.example.lab1
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import NewsScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            NewsScreen()
        }
    }
}

