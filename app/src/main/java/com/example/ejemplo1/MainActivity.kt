package com.example.ejemplo1

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.BlendMode
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.RectangleShape
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
                SetContent()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    SetContent ()
}

@Composable
fun SetContent() {
    Column (modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center) {

        Row ( modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Column () { SimpleButton() }
            Spacer(modifier = Modifier.size(10.dp))
            Column () { ButtonWithColor() }
        }

        Spacer(modifier = Modifier.size(20.dp))

        Row ( modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Column () { ButtonWithTwoTextView() }
            Spacer(modifier = Modifier.size(10.dp))
            Column () { ButtonWithIcon() }
        }

        Spacer(modifier = Modifier.size(20.dp))

        Row ( modifier = Modifier.fillMaxWidth(),
            horizontalArrangement = Arrangement.Center) {
            Column () { ButtonWithRectangleShape() }
            Spacer(modifier = Modifier.size(10.dp))
            Column () { ButtonWithIcon() }
        }
    }
}

@Composable
fun SimpleButton() {
    Button(onClick = {
        //your onclick code here
    }) {
        Text(text = "Simple Button")
    }
}

@Composable
fun ButtonWithColor(){
    Button(onClick = {
        //your onclick code
    },
        colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray))

    {
        Text(text = "Color button",color = Color.White)
    }
}

@Composable
fun ButtonWithTwoTextView() {
    Button(onClick = {
        //your onclick code here
    }, colors = ButtonDefaults.buttonColors(containerColor = Color.DarkGray)) {
        Text(text = "Click ", color = Color.Yellow)
        Text(text = "Here", color = Color.Green)
    }
}

@Composable
fun ButtonWithIcon() {
    Button(onClick = {}) {
        Image(
            painterResource(id = R.drawable.ic_foco),
            contentDescription ="Light button icon",
            modifier = Modifier.size(20.dp),
            colorFilter = ColorFilter.tint(color = Color.Yellow))

        Text(text = "On",Modifier.padding(start = 10.dp))
    }
}

@Composable
fun ButtonWithRectangleShape() {
    Button(onClick = {}, shape = RectangleShape, colors = ButtonDefaults.buttonColors(containerColor = Color.hsl( hue = 110.0f, saturation = 0.4f, lightness = 0.5f ))) {
        Text(text = "Forma de Rectangulo")
    }
}