package com.example.ejemplo1

import android.os.Bundle
import android.widget.Space
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Shapes
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.clipToBounds
import androidx.compose.ui.draw.rotate
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.ejemplo1.ui.theme.Ejemplo1Theme
import org.intellij.lang.annotations.JdkConstants.HorizontalAlignment

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            Ejemplo1Theme() {
                Content()
            }
        }
    }
}

@Composable
fun Content(){
    Column ( Modifier.fillMaxSize() ){
        Content1()
        Content2()
        Content3()
        AlphaModifier()
        RotateModifier()
        ScaleModifier()
        ClipModifier()
    }
}

@Composable
fun Content1(){
    Column ( Modifier.fillMaxWidth() ){
        Spacer(Modifier.size(20.dp))
        Text(
            "Marcos Juárez",
            Modifier.border(width = 5.dp, color = Color.Black)
                .background(color = Color.Magenta)
                .padding(20.dp)
                .align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.size(20.dp))
    }
}

@Composable
fun Content2(){
    Column ( Modifier.fillMaxWidth() ){
        Spacer(Modifier.size(20.dp))
        Text(
            "Marcos Juárez",
            Modifier.border(width = 5.dp, color = Color.Blue)
                .background(color = Color.Yellow)
                .padding(20.dp)
                .align(Alignment.CenterHorizontally),
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.size(20.dp))
    }
}

@Composable
fun Content3() {
    Column ( Modifier.rotate(49f).offset(x = 100.dp).shadow(elevation = 20.dp)) {
        Text(
            text = "Probando",
            Modifier.border(width = 5.dp, color = Color.Blue)
                .background(color = Color.Yellow)
                .padding(20.dp).scale(2f).rotate(30f)
        )
    }
}

@Composable
fun AlphaModifier() {
    Box( Modifier.size(250.dp).alpha(0.3f).background(Color.Red)
    )
}

@Composable
fun RotateModifier() {
    Box(
        Modifier.rotate(45f).size(50.dp).shadow(30.dp).background(Color.Blue)
    )
}

@Composable
fun ScaleModifier() {
    Box(
        Modifier.scale(scaleX = 2f, scaleY = 5f).size(50.dp).shadow(30.dp).background(Color.Green)
    )
}

@Composable
fun ClipModifier() {
    Text(
        text = "Text with Clipped background",
        color = Color.White,
        modifier = Modifier
            .padding(Dp(10f))
            .clip(RoundedCornerShape(25.dp))
            .background(Color.Blue)
            .padding(Dp(15f))
    )
}

@Preview(showBackground = true)
@Composable
fun Preview() {
    Content()
}