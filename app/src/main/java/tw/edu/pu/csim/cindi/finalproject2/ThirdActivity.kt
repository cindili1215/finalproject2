package tw.edu.pu.csim.cindi.finalproject2

import android.app.Activity
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import tw.edu.pu.csim.cindi.finalproject2.ui.theme.Finalproject2Theme

class ThirdActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Finalproject2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color.LightGray)
    ) {
        // 顏色和例子
        val colorExamples = listOf(
            Triple(R.drawable.apple, "紅色", "蘋果"),
            Triple(R.drawable.blueberry, "藍色", "藍莓"),
            Triple(R.drawable.guava, "綠色", "芭樂"),
            Triple(R.drawable.banana, "黃色", "香蕉"),
            Triple(R.drawable.rice, "白色", "米飯"),
            Triple(R.drawable.bear, "黑色", "黑熊")
        )

        colorExamples.forEach { (imageRes, colorText, exampleText) ->
            ColorRow(
                imageRes = imageRes,
                colorText = colorText,
                exampleText = exampleText,
                modifier = modifier
            )
            Spacer(modifier = Modifier.height(16.dp))
        }
    }
}

@Composable
fun ColorRow(imageRes: Int, colorText: String, exampleText: String, modifier: Modifier) {
    Row(
        modifier = Modifier
            .padding(8.dp)
            .background(Color.White)
            .fillMaxWidth()
    ) {
        Image(
            painter = painterResource(id = imageRes),
            contentDescription = "圖片",
            alpha = 0.7f,
            modifier = Modifier
                .background(Color.DarkGray)
                .size(100.dp) // 設置圖片大小
        )
        Spacer(modifier = Modifier.width(16.dp))
        Text(
            text = "顏色：$colorText\n例子：$exampleText",
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = Color.Black,
            modifier = modifier
        )
    }
}