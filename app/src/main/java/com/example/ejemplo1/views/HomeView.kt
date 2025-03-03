package com.example.ejemplo1.views

import android.annotation.SuppressLint
import android.app.Notification
import android.app.Notification.Action
import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.contentColorFor
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import androidx.navigation.NavHost
import androidx.navigation.NavHostController
import androidx.navigation.Navigation
import com.example.ejemplo1.components.ActionButton
import com.example.ejemplo1.components.MainButton
import com.example.ejemplo1.components.Spacers
import com.example.ejemplo1.components.TitleBar
import com.example.ejemplo1.components.TitleView
import com.example.ejemplo1.navigation.NavManager

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeView( navController : NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    TitleBar("HomeView")
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Red
                )
            )
        },
        floatingActionButton = {
            ActionButton(Color.Red)
        }
    ) {
        ContentView( navController )
    }
}

@Composable
private fun ContentView( navController: NavHostController) {
    Column(
        modifier = Modifier.fillMaxSize(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        TitleView("HomeView")
        Spacers()
        MainButton( name = "Soy un botón", backColor = Color.hsl(320f, 0.7f, 0.8f), color = Color.Black, onClick = { navController.navigate("Detail")}  )
    }
}