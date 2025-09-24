package com.example.modifierdemo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.sp
import com.example.modifierdemo.ui.theme.ModifierDemoTheme
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.padding
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.foundation.Image
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.Alignment
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.ui.draw.clip
import androidx.compose.ui.layout.ContentScale

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            ModifierDemoTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    DemoScreen(Modifier.padding(innerPadding))

                }
            }
        }
    }
}

@Composable
fun DemoScreen(modifier: Modifier = Modifier) {
    val mymodifier = modifier
        .padding(all = 10.dp)
        .border(width = 2.dp, color = Color.Black)
    Column(
        Modifier.padding(20.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(
            "Hello Compose",
            mymodifier,
            fontSize = 40.sp,
            fontWeight = FontWeight.Bold
        )
        Spacer(Modifier.height(16.dp))
        CustomImage(R.drawable.vacation,
            Modifier
                .padding(16.dp)
                .width(270.dp)
                .clip(shape = RoundedCornerShape(30.dp))
        )


    }


}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ModifierDemoTheme {
        DemoScreen()
    }
}
@Composable
fun CustomImage(image: Int, modifier: Modifier = Modifier) {
    Image(
        painter = painterResource(image),
        contentDescription = null,
        contentScale = ContentScale.Crop,
        modifier = modifier
    )
}