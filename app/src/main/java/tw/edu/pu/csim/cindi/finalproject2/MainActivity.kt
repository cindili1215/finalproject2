package tw.edu.pu.csim.cindi.finalproject2

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
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
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import tw.edu.pu.csim.cindi.finalproject2.ui.theme.Finalproject2Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Finalproject2Theme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    //Greeting("Android")
                    FirstScreen()
                    Main()
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
            .background(Color.White),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    )
    {
        Button(onClick = {
            var it = Intent(context, SecondActivity::class.java)
            context.startActivity(it)
        },colors = buttonColors(Color.DarkGray)
        )
        {
            Text(text = "Start!")
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
            title = { Text(text = "APP名") },

            navigationIcon = {
                IconButton(onClick = {
                    Toast.makeText(context, "您點選了導覽圖示", Toast.LENGTH_SHORT).show()
                }) {
                    Icon(Icons.Default.Menu, contentDescription = "Navigation icon")
                }
            },
            actions = {
                IconButton(
                    onClick = { Toast.makeText(context, "作者：米納桑", Toast.LENGTH_SHORT).show() }
                ) {
                    Icon(Icons.Rounded.AccountBox, contentDescription = "Author")
                }
            }


        )
    }
}