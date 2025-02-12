package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Ejemplo1Theme {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Center
                ) {
                    TextFieldSencillo()
                    Spacer(Modifier.size(50.dp))
                    TextFieldPlaceHolder()
                    Spacer(Modifier.size(50.dp))
                    TextFieldKeyboard()
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

@Preview(showBackground = true)
@Composable
fun GreetingPreview () {
    Column {
        TextFieldSencillo()
    }
}

@Composable
fun TextFieldSencillo () {
    var text by remember { mutableStateOf ( "" ) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField (
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text("Introduce tu nombre") }
        )
        Text(
            text = "Tu nombre es $text"
        )
    }
}

@Composable
fun TextFieldPlaceHolder() {
    var text by remember { mutableStateOf ( "" ) }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField (
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text("Nombre") },
            placeholder = { Text("Introduce tu nombre")}
        )
        Text(
            text = "Tu nombre es $text"
        )
    }
}

@Composable
fun TextFieldKeyboard() {
    var text by remember { mutableStateOf("") }
    Column(
        modifier = Modifier.fillMaxWidth(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            value = text,
            onValueChange = { newText -> text = newText },
            label = { Text("Número") },
            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        )
        Text(
            text = "El numero es $text"
        )
    }

    @Composable
    fun OutLineTextField() {
        var text by remember { mutableStateOf("") }
        Column(
            modifier = Modifier.fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            OutlinedTextField(
                value = text,
                onValueChange = { newText -> text = newText },
                label = { Text("Número") }
            )
            Text(
                text = "El numero es $text"
            )
        }
    }
}