package tw.edu.pu.csim.cindi.finalproject2

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tw.edu.pu.csim.cindi.finalproject2.ui.theme.Finalproject2Theme
import kotlin.random.Random

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Finalproject2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                    //color = Color(android.graphics.Color.parseColor("#FFA500"))
                ) {
                    //Greeting()
                    ColorQuizScreen()

                }
            }
        }
    }
}

@Composable
fun ColorQuizScreen() {
    val context = LocalContext.current
    val activity = (context as Activity)
    var currentColor by remember { mutableStateOf(generateRandomColor()) }
    var score by remember { mutableStateOf(0) }
    val colorNames = listOf("紅色", "藍色", "黑色", "綠色", "黃色", "白色")
    val correctColorName = getColorName(currentColor)

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                activity.finish()
            })
        {
            Text(text = "回到主頁")
        }
        Text(
            text = "歡迎來到顏色測驗區",
            fontSize = 35.sp,
        )
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            Box(
                modifier = Modifier
                    .size(150.dp)
                    .background(currentColor)
            )

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "請選擇正確的顏色:")

            colorNames.forEach { colorName ->
                Spacer(modifier = Modifier.height(8.dp))
                Button(onClick = {
                    if (colorName == correctColorName) {
                        score++
                        Toast.makeText(context, "答對了!", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(
                            context,
                            "錯誤! 這是 $correctColorName",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                    currentColor = generateRandomColor()
                }) {
                    Text(text = colorName)
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "得分: $score")
        }
    }
}
fun generateRandomColor(): Color {
    val colors = listOf(
        Color(1.0f, 0.0f, 0.0f), // 紅色
        Color(0.0f, 0.0f, 1.0f), // 藍色
        Color(1.0f, 1.0f, 1.0f), // 白色
        Color(0.0f, 0.0f, 0.0f), // 黑色
        Color(0.0f, 1.0f, 0.0f), // 綠色
        Color(1.0f, 1.0f, 0.0f)  // 黃色
    )
    return colors.random()
}

fun getColorName(color: Color): String {
    return when {
        color.red == 1.0f && color.green == 0.0f && color.blue == 0.0f -> "紅色"
        color.red == 0.0f && color.green == 0.0f && color.blue == 1.0f -> "藍色"
        color.red == 0.0f && color.green == 0.0f && color.blue == 0.0f -> "黑色"
        color.red == 0.0f && color.green == 1.0f && color.blue == 0.0f -> "綠色"
        color.red == 1.0f && color.green == 1.0f && color.blue == 0.0f -> "黃色"
        else -> "白色"
    }
}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Main()
}