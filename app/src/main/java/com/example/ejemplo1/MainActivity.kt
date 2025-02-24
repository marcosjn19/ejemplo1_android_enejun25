package com.example.ejemplo1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

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
fun Content() {
    var text1 by remember { mutableStateOf(TextFieldValue("")) }
    var text2 by remember { mutableStateOf(TextFieldValue("")) }
    var resultado by remember { mutableStateOf(0.0) }
    ImagenDescuento()
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.Transparent)
            .padding(30.dp),
        verticalArrangement = Arrangement.Center
    ) {
        FormDatos(
            text1 = text1,
            text2 = text2,
            onText1Change = { text1 = it },
            onText2Change = { text2 = it }
        )
        Spacer(modifier = Modifier.size(20.dp))
        Button(
            onClick = {
                val num1 = text1.text.toDoubleOrNull() ?: 0.0
                val num2 = text2.text.toDoubleOrNull() ?: 0.0
                val aux = 1.0 - (num2 * 0.01)
                resultado = num1 * aux
            },
            colors = ButtonDefaults.buttonColors(containerColor = Color.hsl(hue = 285f, saturation = 1f, lightness = .25f, alpha = 1f)),
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 8.dp),
        ) {
            Text("Calcular Precio", color = Color.White)
        }
        Spacer(Modifier.size(20.dp))
        FormResultado(resultado)
    }
}

@Composable
fun FormDatos(
    text1: TextFieldValue,
    text2: TextFieldValue,
    onText1Change: (TextFieldValue) -> Unit,
    onText2Change: (TextFieldValue) -> Unit
) {
    Column(
        Modifier
            .shadow(elevation = 30.dp)
            .clip(RoundedCornerShape(10))
            .background(Color.White)
            .padding(20.dp)
    ) {
        Titulo1("Datos del producto")
        Spacer(modifier = Modifier.height(20.dp))
        TextFieldNumerico(
            ph = "Precio",
            lbl = "Ingresa el precio",
            text = text1,
            onTextChange = onText1Change
        )
        Spacer(modifier = Modifier.height(20.dp).background(Color.Transparent).alpha(1f))
        TextFieldNumerico(
            ph = "Descuento",
            lbl = "Ingresa el descuento",
            text = text2,
            onTextChange = onText2Change
        )
    }
}

@Composable
fun TextFieldNumerico(
    ph: String,
    lbl: String,
    text: TextFieldValue,
    onTextChange: (TextFieldValue) -> Unit
) {
    TextField(
        value = text,
        label = { Text(text = lbl) },
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number),
        onValueChange = { onTextChange(it) },
        placeholder = { Text(ph) }
    )
}

@Composable
fun FormResultado(resultado: Double) {
    Column(
        modifier = Modifier
            .shadow(elevation = 30.dp)
            .clip(RoundedCornerShape(10))
            .background(Color.White)
            .padding(20.dp)
    ) {
        Titulo1(titulo = "Resultado")
        Spacer(modifier = Modifier.size(15.dp))
        Resultado(label = "Total a pagar", res = resultado)
    }
}

@Composable
fun Titulo1(titulo: String) {
    Text(
        text = titulo,
        fontWeight = FontWeight(weight = 800),
        fontSize = 25.sp,
        textAlign = TextAlign.Center,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun Resultado(label: String, res: Double) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp),
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Text(
            text = "$label:",
            fontWeight = FontWeight(weight = 600),
            fontSize = 18.sp,
            textAlign = TextAlign.Start
        )
        Text(
            text = "$$res",
            fontWeight = FontWeight(weight = 400),
            fontSize = 18.sp,
            textAlign = TextAlign.End
        )
    }
}

@Composable
fun ImagenDescuento() {
    Image(
        painter = painterResource(R.drawable.descuento),
        contentDescription = "img",
        modifier = Modifier
            .padding(0.dp, 0.dp, 0.dp, 20.dp).offset(x = 220.dp, y = -20.dp).rotate(30f)
    )
}