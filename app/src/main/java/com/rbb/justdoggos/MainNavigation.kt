package com.rbb.justdoggos

sealed class MainNavigation(val route: String) {
    object Splash: MainNavigation("splash_route")
    object Home: MainNavigation("home_route")
    object ImageDetails: MainNavigation("image_details_route")
}
