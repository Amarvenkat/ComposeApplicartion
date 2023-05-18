package com.example.composeapplication

import android.os.Bundle
import android.provider.SyncStateContract.Columns
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.layout.ModifierInfo
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.composeapplication.ui.theme.ComposeApplicationTheme
import kotlinx.coroutines.launch
import java.util.Random

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val fontfamily = FontFamily(
            Font(R.font.lexend_thin, FontWeight.Thin),
            Font(R.font.lexend_black, FontWeight.Black),
            Font(R.font.lexend_bold, FontWeight.Bold),
            Font(R.font.lexend_extrabold, FontWeight.ExtraBold),
            Font(R.font.lexend_extralight, FontWeight.ExtraLight),
            Font(R.font.lexend_medium, FontWeight.Medium),
            Font(R.font.lexend_regular, FontWeight.Normal),
            Font(R.font.lexend_semibold, FontWeight.SemiBold)
        )

        setContent {
            ComposeApplicationTheme {


                // A surface container using the 'background' color from the theme
//                Surface(modifier = Modifier.fillMaxSize(), color = MaterialTheme.colors.background) {
//                    //Greeting("Android")
//                    MyFunction()
//                } 
                //Boder()

                //Card
//                val painter = painterResource(id = R.drawable.kermit)
//                val description = "Kermit is playing"
//                val title = "Kermit is playing with guitar"
//                Box(modifier = Modifier
//                    .fillMaxWidth(0.5f)
//                    .padding(16.dp)){
//                SimpleCard(painter = painter, contentDescription = description, title = title)
//                }

                //TextStyle
                //TextStyleView(fontfamily)

                //Color Box

//                Column(Modifier.fillMaxSize()){
//                    val color = remember {
//                        mutableStateOf(Color.Yellow)
//                    }
//                ColorBox(
//                    Modifier
//                        .weight(1f)
//                        .fillMaxSize()
//                ){
//                    color.value = it
//                }
//                    Box(modifier = Modifier
//                        .background(color.value)
//                        .weight(1f)
//                        .fillMaxSize())
//                }

                SimpleSnackBar()

            }
        }
    }
}

@Composable
fun SimpleSnackBar() {

    val scaffoldState = rememberScaffoldState()
    var textFieldState by remember {
        mutableStateOf("")
    }
    val scope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        scaffoldState = scaffoldState
    ) {
        Column(
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center,
            modifier = Modifier
                .fillMaxSize()
                .padding(horizontal = 30.dp)
        ) {
            TextField(
                value = textFieldState,
                label = {
                        Text(text = "Enter your name")
                },
                onValueChange = {
                textFieldState = it
                },
                singleLine = true,
                modifier = Modifier.fillMaxWidth()
            )
            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = {
                scope.launch {
                scaffoldState.snackbarHostState.showSnackbar("Hello $textFieldState")
                }
                }) {
                Text(text = "Press This")
            }
        }
    }
}

@Composable
fun ColorBox(modifier: Modifier = Modifier, updateColor: (Color) -> Unit) {

    Box(modifier = modifier
        .background(Color.Red)
        .clickable {
            updateColor(
                Color(
                    Random().nextFloat(),
                    Random().nextFloat(),
                    Random().nextFloat(),
                    1f
                )
            )

        }
    )
}

@Composable
fun TextStyleView(fontfamily: FontFamily) {
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFF101010))
    ) {
        //default style for this text
        Text(
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 50.sp,
                    )
                ) {
                    append("J")
                }
                append("etpack ")
                withStyle(
                    style = SpanStyle(
                        color = Color.Green,
                        fontSize = 50.sp,
                    )
                ) {
                    append("C")
                }
                append("ompose")
            },
            color = Color.White,
            fontSize = 30.sp,
            fontFamily = fontfamily,
            fontWeight = FontWeight.SemiBold,
            fontStyle = FontStyle.Italic,
            textAlign = TextAlign.Center,
            textDecoration = TextDecoration.Underline
        )
//        Text(text = "Jetpack Compose",
//            color = Color.White,
//            fontSize = 30.sp,
//            fontFamily = fontfamily,
//            fontWeight = FontWeight.SemiBold,
//            fontStyle = FontStyle.Italic,
//            textAlign = TextAlign.Center,
//            textDecoration = TextDecoration.Underline
//        )

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
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        Brush.verticalGradient(
                            colors = listOf(
                                Color.Transparent,
                                Color.Black
                            ),
                            startY = 300f
                        )
                    )
            )
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(12.dp),
                contentAlignment = Alignment.BottomStart
            ) {
                Text(
                    title, style = TextStyle(
                        color = Color.White, fontSize = 16.sp, textAlign = TextAlign.Center
                    )
                )
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
            //.width(300.dp)
            //.height(300.dp)
            //.fillMaxSize(.5f)//can also pass %
            .fillMaxWidth(0.9f)
            .fillMaxHeight(0.7f)
            .background(Color.Yellow)
            .padding(16.dp)
        //horizontalAlignment = Alignment.CenterHorizontally,
        //verticalArrangement = Arrangement.SpaceAround
    ) {
        Text(text = "Hello")
        Spacer(modifier = Modifier.height(20.dp))
        Text(text = name)
    }
}

@Composable
fun Boder() {

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
//        val painter = painterResource(id = R.drawable.kermit)
//        val description = "Kermit is playing"
//        val title = "Kermit is playing with guitar"
//        SimpleCard(painter = painter, contentDescription = description, title = title)

    }
}