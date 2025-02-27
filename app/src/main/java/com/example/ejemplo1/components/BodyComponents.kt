package com.example.ejemplo1.components

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.semantics.Role.Companion.Button
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun TitleView(name: String) {
    Text(text = name, fontSize = 25.sp, color = Color.Black, fontWeight = FontWeight.Bold)
}

@Composable
fun Spacers() {
    Spacer(modifier = Modifier.height(10.dp))
}

@Composable
fun MainButton (name : String, backColor : Color, color : Color, onClick:() -> Unit ) {
    Button(onClick = onClick, colors = ButtonDefaults.buttonColors(
        contentColor = color,
        containerColor = backColor
    ), modifier = Modifier.shadow(10.dp, shape = CircleShape)) {
        Text(text = name)
    }
}