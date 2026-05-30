package com.tehseen.quotegenerator.navigation

sealed class Screen(val route: String) {
    object Splash : Screen("splash_route")
    object Dashboard : Screen("dashboard_route")
}