package tw.edu.pu.csim.cindi.finalproject2

import android.app.Activity
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tw.edu.pu.csim.cindi.finalproject2.ui.theme.Finalproject2Theme

class SecondActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Finalproject2Theme {
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
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
            .background(Color(android.graphics.Color.parseColor("#EFE7DA"))), // Set the background color here
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Button(
            onClick = {
                activity.finish()
            },
            colors = buttonColors(Color(android.graphics.Color.parseColor("#B29079"))
            ),
            modifier = Modifier.size(150.dp, 50.dp) // Set button size here
        ) {
            Text(
                text = "回到主頁",
                fontSize = 20.sp // Set button text size here
            )
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
                Button(
                    onClick = {
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
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.LightGray,
                        contentColor = getButtonTextColor(colorName)
                    ),
                    modifier = Modifier.size(170.dp, 55.dp) // Set button size here
                ) {
                    Text(
                        text = colorName,
                        fontSize = 20.sp // Set button text size here
                    )
                }
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(text = "得分: $score")
        }
    }
}

fun generateRandomColor(): Color {
    val colors = listOf(
        Color.Red,   // 紅色
        Color.Blue,  // 藍色
        Color.White, // 白色
        Color.Black, // 黑色
        Color.Green, // 綠色
        Color.Yellow // 黃色
    )
    return colors.random()
}

fun getColorName(color: Color): String {
    return when (color) {
        Color.Red -> "紅色"
        Color.Blue -> "藍色"
        Color.Black -> "黑色"
        Color.Green -> "綠色"
        Color.Yellow -> "黃色"
        else -> "白色"
    }
}

fun getButtonTextColor(colorName: String): Color {
    return when (colorName) {
        "紅色" -> Color.Red
        "藍色" -> Color.Blue
        "黑色" -> Color.Black
        "綠色" -> Color.Green
        "黃色" -> Color.Yellow
        "白色" -> Color.White
        else -> Color.Gray
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Finalproject2Theme {
        ColorQuizScreen()
    }
}
