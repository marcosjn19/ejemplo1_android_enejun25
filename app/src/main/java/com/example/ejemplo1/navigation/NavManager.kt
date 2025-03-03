package com.example.ejemplo1.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.example.ejemplo1.views.DetailView
import com.example.ejemplo1.views.HomeView

@Composable
fun NavManager () {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable( route = "Home" ){
            HomeView( navController )
        }
        composable ( route = "Detail"){
            DetailView( navController )
        }

    }
}