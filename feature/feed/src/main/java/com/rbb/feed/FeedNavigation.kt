package com.rbb.feed

import androidx.navigation.NavController
import androidx.navigation.NavOptions

const val FEED_ROUTE = "feed_route"

fun NavController.navigateToFeed(navOptions: NavOptions) = navigate(FEED_ROUTE, navOptions)
