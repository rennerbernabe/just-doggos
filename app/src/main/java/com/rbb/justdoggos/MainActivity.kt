package com.rbb.justdoggos

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Favorite
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.outlined.FavoriteBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rbb.home.HomeScreen
import com.rbb.justdoggos.ui.theme.JustDoggosTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val homeTab = TabBarItem(
                title = stringResource(R.string.home),
                selectedIcon = Icons.Filled.Home,
                unselectedIcon = Icons.Outlined.Home,
            )
            val favoriteTab = TabBarItem(
                title = stringResource(R.string.favorite),
                selectedIcon = Icons.Filled.Favorite,
                unselectedIcon = Icons.Outlined.FavoriteBorder,
            )
            val tabBarItems = listOf(homeTab, favoriteTab)
            val navController = rememberNavController()

            JustDoggosTheme {
                LazyColumn {

                }
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Scaffold(
                        bottomBar = { TabView(tabBarItems, navController) }
                    ) {
                        NavHost(navController = navController, startDestination = homeTab.title) {
                            composable(homeTab.title) {
                                HomeScreen()
                            }
                            composable(favoriteTab.title) {
                                Text(favoriteTab.title)
                            }
                        }
                    }
                }
            }
        }
    }
}

@Composable
fun TabView(tabBarItems: List<TabBarItem>, navController: NavHostController) {
    var selectedTabIndex by rememberSaveable { mutableIntStateOf(0) }

    NavigationBar {
        tabBarItems.forEachIndexed { index, item ->
            NavigationBarItem(
                selected = selectedTabIndex == index,
                onClick = {
                    selectedTabIndex = index
                    navController.navigate(item.title)
                },
                icon = {
                    Icon(
                        imageVector = if (index == selectedTabIndex) {
                            item.selectedIcon
                        } else item.unselectedIcon,
                        contentDescription = item.title
                    )
                }
            )
        }
    }
}
