package com.example.ejemplo1.views

import android.annotation.SuppressLint
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavHostController
import com.example.ejemplo1.components.ActionButton
import com.example.ejemplo1.components.MainButton
import com.example.ejemplo1.components.TitleBar
import com.example.ejemplo1.components.TitleView

@SuppressLint("UnusedMaterial3ScaffoldPaddingParameter")
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailView( navController : NavHostController) {
    Scaffold(
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    TitleBar("DetailsView")
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = Color.Blue
                )
            )
        },
        floatingActionButton = {
            ActionButton(Color.Blue)
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
        horizontalAlignment = Alignment.CenterHorizontally

    ) {
        TitleView("DetailsView")
        MainButton( name = "Regresar jaja", backColor = Color.hsl(320f, 0.7f, 0.8f), color = Color.Black, onClick = { navController.popBackStack()}  )
    }
}