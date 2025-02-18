package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Content()
        }
    }
}

@Preview(showBackground = true)
@Composable
fun Content () {
    Column (Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally) {
        ImagenBanner()
        Spacer(Modifier.size(30.dp))
        TextFieldNumerico("Valor 1")
        Spacer(Modifier.size(30.dp))
        TextFieldNumerico("Valor 2")
        Spacer(Modifier.size(50.dp))
        BotonRedondeado()
    }
}

// Imagen
@Composable
fun ImagenBanner () {
    Row () {
        Image(painter = painterResource(R.drawable.paisaje), contentDescription = "Paisaje",
            modifier = Modifier.fillMaxWidth().height(300.dp).offset(y = 0.dp).width(600.dp))
    }
}

// Textfield
@Composable
fun TextFieldNumerico ( texto1:String ) {
    var text by remember { mutableStateOf(TextFieldValue("")) }
    TextField(
        value = text,
        label = { Text(text = texto1) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { it ->
            text = it
        },
        placeholder = { Text(text="Introduce un número")}
    )
}

// Botón
@Composable
fun BotonRedondeado() {
    Button(onClick = {}, shape = RoundedCornerShape(20.dp)) {
        Text(text = "Calcular")
    }
}

