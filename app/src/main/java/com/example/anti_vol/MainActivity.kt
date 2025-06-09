package com.example.anti_vol

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import com.example.anti_vol.navigation.MainNavigation
import com.example.anti_vol.ui.theme.AntivolTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            AntivolTheme {
                MainNavigation()
            }
        }
    }
}