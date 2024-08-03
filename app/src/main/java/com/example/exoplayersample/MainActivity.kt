package com.example.exoplayersample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.material3.Surface
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.exoplayersample.screens.NavigationGroupsScreen
import com.example.exoplayersample.screens.SinglePlayerScreen
import com.example.exoplayersample.screens.SinglePlayerScreenMetaData
import com.example.exoplayersample.ui.theme.ExoplayerSampleTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExoplayerSampleTheme {
                Surface {
                    val navController = rememberNavController()
                    NavHost(navController = navController, startDestination = "navigationList") {
                        composable("navigationList") {
                            NavigationGroupsScreen(navController = navController)
                        }
                        composable(route = SinglePlayerScreenMetaData.SCREEN_NAME) {
                            SinglePlayerScreen()
                        }
                    }
                }
            }
        }
    }
}

