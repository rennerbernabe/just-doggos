package com.rbb.home

sealed class HomeNavigation(val route: String) {
    object Feed: HomeNavigation("feed_route")
    object Favorite: HomeNavigation("favorite_route")
}
