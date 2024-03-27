package com.rbb.justdoggos

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rbb.feed.ImageDetailsScreen
import com.rbb.home.HomeScreen
import com.rbb.justdoggos.ui.theme.JustDoggosTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            JustDoggosTheme {
                val navController = rememberNavController()
                NavHost(
                    navController = navController,
                    startDestination = MainNavigation.Splash.route
                ) {
                    composable(MainNavigation.Splash.route) {
                        SplashScreen(navController)
                    }
                    composable(MainNavigation.Home.route) {
                        HomeScreen(
                            onClick = { id ->
                                navController.navigate(MainNavigation.ImageDetails.route + "/$id")
                            }
                        )
                    }
                    composable(MainNavigation.ImageDetails.route + "/{id}") { backStackEntry ->
                        ImageDetailsScreen()
                    }
                }
            }
        }
    }
}
