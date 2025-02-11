package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1Theme {
                GreetingPreview()
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    Content( "Hola", "Mundo ")
}

@Composable
fun Content(mensaje1: String, mensaje2: String) {
    Column {
        Text(
            mensaje1,
            fontWeight = FontWeight.ExtraBold,
            fontSize = 28.sp,
            lineHeight = 28.sp, color = Color.Blue)
        Text(
            "Probando Rows",
            fontWeight = FontWeight.SemiBold,
            fontSize = 20.sp,
            lineHeight = 20.sp)
        Row {
            Text(mensaje1,
                fontWeight = FontWeight.SemiBold,
                fontSize = 30.sp,
                lineHeight = 20.sp)
            Column {
                Text("Columna",
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 10.sp,
                    lineHeight = 50.sp, color = Color.Red)
                Text(mensaje2,
                    fontWeight = FontWeight.ExtraBold,
                    fontSize = 10.sp,
                    lineHeight = 5.sp)
            }

        }
    }
}