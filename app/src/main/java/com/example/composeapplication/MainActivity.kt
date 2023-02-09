package com.example.composeapplication

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.ui.theme.ComposeApplicationTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeApplicationTheme {
                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//                    //Greeting("Android")
//                    MyFunction()
//                }
                //Boder()
                val painter = painterResource(id = R.drawable.kermit)
                val description = "Kermit is playing"
                val title = "Kermit"
                SimpleCard(painter = painter, contentDescription = description, title = title)
            }
        }
    }
}

@Composable
fun SimpleCard(
    painter: Painter,
    contentDescription: String,
    title: String,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier.fillMaxWidth(),
        shape = RoundedCornerShape(15.dp),
        elevation = 5.dp
    ) {
        Box(modifier = Modifier.height(200.dp)){
            Image(
                painter = painter,
                contentDescription =contentDescription,
                contentScale = ContentScale.Crop
            )
            Box (
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(title,style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }

    }
}
@Composable
fun Greeting(name: String) {
   Column(
       modifier = Modifier
           //.fillMaxSize() // match parent and match parent
           //.fillMaxSize() // match parent and match parent
           //.fillMaxSize(0.5f)// 1 is max i.e 100% 0.5f is 500%
           .width(300.dp)
           //.height(300.dp)
           .fillMaxSize()//can also pass %
           .background(Color.Gray),
       horizontalAlignment =  Alignment.CenterHorizontally,
       verticalArrangement = Arrangement.Center
   ) {
       Text(text = "Hello")
       Text(text = "Amar")
   }
}

@Composable
fun Boder(){

    Column(
        modifier = Modifier

            .background(Color.Green)
//            .fillMaxSize()
            .fillMaxHeight()
            .fillMaxWidth()
            //works in order
            .padding(50.dp)
            .border(2.dp, Color.Black)
            .padding(16.dp)
            .border(5.dp, Color.Blue)
            .border(10.dp, Color.Red)
            .padding(16.dp)
    ) {
        Text(text = "Amar",
//            modifier = Modifier
//            .offset(0.dp, 20.dp)
            modifier = Modifier
                .clickable { }
                //works in order
                .border(5.dp, Color.Yellow)
                .padding(5.dp)
                .offset(20.dp, 20.dp)
                .border(10.dp, Color.Magenta)
                .padding(10.dp)
        )
        Spacer(modifier = Modifier.height(50.dp))
        Text(text = "Venkat")

    }

}
@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeApplicationTheme {
       // Greeting("Android")
       // Boder()
        val painter = painterResource(id = R.drawable.kermit)
        val description = "Kermit is playing"
        val title = "Kermit"
        SimpleCard(painter = painter, contentDescription = description, title = title)
    }
}