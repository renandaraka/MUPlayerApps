package com.raka.muplayerapps.ui.navigation

sealed class Screen(val route: String) {
    object Home : Screen("home")
    object Profile : Screen("profile")
    object DetailGroup : Screen("home/{playerId}") {
        fun createRoute(playerId: Int) = "home/$playerId"
    }
}