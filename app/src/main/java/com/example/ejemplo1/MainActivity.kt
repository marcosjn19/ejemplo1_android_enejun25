package com.example.ejemplo1

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.blur
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Chava",
                        modifier = Modifier.padding(innerPadding)
                    )

                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "$name!",
        fontSize = 50.sp,
        modifier = modifier,
    )
}

@Composable
fun SimpleImage() {
    Image(
        painter = painterResource(id = R.drawable.tdb_2402_andy_rubin),
        contentDescription = "Andy Rubin",
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable fun CircleImageView() {
    Image(
        painter = painterResource(R.drawable.tdb_2402_andy_rubin),
        contentDescription = "Circle Image",
        contentScale = ContentScale.Crop, modifier = Modifier .size(128.dp) .clip(CircleShape) .border(1.dp, Color.Gray, CircleShape) )
}

@Composable
fun RoundCornerImageView() {
    Image(
        painter = painterResource(R.drawable.tdb_2402_andy_rubin),
        contentDescription = "Round corner image",
        contentScale = ContentScale.Crop,
        modifier = Modifier
            .size(128.dp)
            .clip(RoundedCornerShape(10))
            .border(5.dp, Color.Gray, RoundedCornerShape(10)).rotate(180f)
    )
}

@Composable
fun GreetingPreview() {
    Ejemplo1Theme {
        SimpleImage()
        CircleImageView()
    }
}

@Composable
fun ImageWithBackgroundColor() {
    Image(
        painter = painterResource(id = R.drawable.ic_cart),
        contentDescription = "",
        modifier = Modifier
            .size( 200.dp)
            .background(Color.DarkGray)
            .padding(20.dp)
    )
}

@Composable
fun ImageWithTint() {
    Image(
        painter = painterResource(id = R.drawable.ic_cart),
        contentDescription = "",
        colorFilter = ColorFilter.tint(Color.Black),
        modifier = Modifier
            .size( 200.dp)
    )
}


@Preview(showBackground = true)
@Composable
fun Content () {
    Column ( Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        SimpleImage()
        Spacer(Modifier.size(10.dp))
        CircleImageView()
        Spacer(Modifier.size(10.dp))
        RoundCornerImageView()
        Spacer(Modifier.size(10.dp))
        ImageWithBackgroundColor()
        Spacer(Modifier.size(10.dp))
        ImageWithTint()
    }
}

