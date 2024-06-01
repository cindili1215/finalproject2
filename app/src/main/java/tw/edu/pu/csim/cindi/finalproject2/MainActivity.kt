package tw.edu.pu.csim.cindi.finalproject2

import android.graphics.Rect


import android.content.Intent
import android.os.Bundle
import android.text.style.BackgroundColorSpan
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material.icons.rounded.AccountBox
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults.buttonColors
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.res.painterResource
//import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.unit.IntOffset

import tw.edu.pu.csim.cindi.finalproject2.ui.theme.Finalproject2Theme
import kotlin.math.roundToInt

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Finalproject2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(android.graphics.Color.parseColor("#EFE7DA"))),
                    //color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    FirstScreen()
                    Main()
                    Drag()
                    //Drag_Horizontal()
                    //Drag_Vertical()
                }
            }
        }
    }
}



@Composable
fun FirstScreen() {
    val context = LocalContext.current
    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(android.graphics.Color.parseColor("#EFE7DA"))),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        /*Image(
            painter = painterResource(id = R.drawable.watercolor),
            contentDescription = "水彩盤"
        )*/

        Image(
            painter = painterResource(id = R.drawable.logo),
            contentDescription = "摟狗"
        )

        Button(onClick = {
            var it = Intent(context, ThirdActivity::class.java)
            context.startActivity(it)
        },
            colors = (
                buttonColors(Color(android.graphics.Color.parseColor("#B29079")))
            )
        )
        {
            Text(text = "介紹")
            Image(
                painterResource(id = R.drawable.red),
                contentDescription ="button icon",
                modifier = Modifier.size(20.dp)
            )

        }

        Button(onClick = {
            var it = Intent(context, SecondActivity::class.java)
            context.startActivity(it)
        },
            colors = (
                    buttonColors(Color(android.graphics.Color.parseColor("#B29079"))
                    )
            )
        )
        {
            Text(text = "Start")
            Image(
                painterResource(id = R.drawable.red),
                contentDescription ="button icon",
                modifier = Modifier.size(20.dp)
            )

        }

    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Main() {
    val context = LocalContext.current

    Column {
        TopAppBar(
            title = { Text(text = "咖樂") },


            navigationIcon = {
                IconButton(onClick = {
                    Toast.makeText(context, "您點選了導覽圖示", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(Icons.Default.Menu, contentDescription = "Navigation icon")
                }
            },
            actions = {
                IconButton(
                    onClick = { Toast.makeText(context, "作者：李欣諦,蔡譯嫺,謝棨亘,李盈蓁", Toast.LENGTH_SHORT).show() }
                ) {
                    Icon(Icons.Rounded.AccountBox, contentDescription = "Author")
                }
            }
        )
    }
}


@Composable
fun Drag() {
    var offset1 by remember { mutableStateOf(Offset.Zero) }
    var offset2 by remember { mutableStateOf(Offset(500f, 500f)) }
    var height by remember { mutableStateOf(0) }
    var width by remember { mutableStateOf(0) }

    Box(modifier = Modifier.fillMaxSize()) {

        Box(
            modifier = Modifier
                .align(Alignment.TopEnd)
        ) {
            var r1: Rect = Rect(
                offset1.x.toInt(), offset1.y.toInt(),
                offset1.x.toInt() + width, offset1.y.toInt() + height
            )
            var r2: Rect = Rect(
                offset2.x.toInt(), offset2.y.toInt(),
                offset2.x.toInt() + width, offset2.y.toInt() + height
            )

            if (r1.intersect(r2)) {
                Text(text = "碰撞")
            } else {
                Text(text = "")
            }
        }
        Box(modifier = Modifier
            .onGloballyPositioned { coordinates ->
                height = coordinates.size.height
                width = coordinates.size.width
            }
            .offset { IntOffset(offset1.x.roundToInt(), offset1.y.roundToInt()) }
            .pointerInput(Unit) {
                detectDragGestures { change, dragAmount ->
                    offset1 += dragAmount
                }
            }
        ) {
            Image(
                painter = painterResource(id = R.drawable.sheepy),
                contentDescription = "西皮小羊",
            )
        }

    }
}