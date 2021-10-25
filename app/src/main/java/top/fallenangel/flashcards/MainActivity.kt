package top.fallenangel.flashcards

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
//import androidx.navigation.compose.rememberNavController
import top.fallenangel.flashcards.ui.theme.FlashcardsTheme
import top.fallenangel.flashcards.ui.theme.home.Home

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            FlashcardsTheme {
                Home()
            }
        }
    }
}
