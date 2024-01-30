package com.example.main

import android.annotation.SuppressLint
import android.content.ClipDescription
import android.icu.text.CaseMap.Title
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CardElevation
import androidx.compose.material3.ElevatedCard
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.BitmapPainter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
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
import com.example.main.ui.theme.MainTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                //State Compose
                Column(Modifier.fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center) {
                    val backgroundColor = remember {
                        mutableStateOf(Color.Yellow)
                    }
                    StateCompose(
                        modifier =  Modifier
                            .fillMaxWidth()
                            .height(200.dp)
                    ){
                        backgroundColor.value = it
                    }
                    Box(modifier = Modifier
                        .background(backgroundColor.value)
                        .fillMaxWidth()
                        .height(200.dp)
                    )
                }

                //Styling Text
                //StylingText()

                //ImageCard
                //ImageCard(painter = painterResource(id = R.drawable.milli_2l0cwtpcchi_unsplash), contentDescription = "Doogy", title = "My Doggy is cutee!!")

                //Modifiers
                //Modifiers()

                //RowsColumnsAndBasicSizing()

                // A surface container using the 'background' color from the theme
                //Surface(
                //modifier = Modifier.fillMaxSize(),
                //color = MaterialTheme.colorScheme.background
                //) {
                //   Greeting("Android")
                //}
            }
        }
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

//Rows, Columns & Basic Sizing
@Composable
fun RowsColumnsAndBasicSizing(){
    Column(modifier = Modifier
        .fillMaxSize()
        .width(300.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.SpaceEvenly) {
        Column(modifier = Modifier) {
            Text(text = "This is Column")
            Text(text = "Hello")
            Text(text = "Kontol")
        }
        Row(modifier = Modifier) {
            Text(text = "This is Row")
            Spacer(modifier = Modifier.padding(horizontal = 5.dp))
            Text(text = "Hello")
            Text(text = "Kontol")
        }
    }
}

//Modifiers
@Composable
fun Modifiers(){
    Column(
        modifier = Modifier
            .background(Color.Green)
            .fillMaxWidth()
            .height(300.dp)
            .border(5.dp, Color.Magenta),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        Text(text = "Hello", modifier = Modifier.clickable{})
        Text(text = "Astu")
    }
}

//Image
@Composable
fun ImageCard(painter: Painter, contentDescription: String, title: String, modifier: Modifier = Modifier){
    ElevatedCard(
        modifier = modifier
            .fillMaxWidth(0.5f)
            .padding(16.dp),
        shape = RoundedCornerShape(15.dp),
        elevation = CardDefaults.cardElevation(
            defaultElevation = 6.dp
        ),
    ) {
        Box(modifier = Modifier.height(200.dp)) {
            Image(
                painter = painter,
                contentDescription = contentDescription,
                contentScale = ContentScale.Crop
            )
            Box(modifier = Modifier
                .fillMaxSize()
                .background(
                    Brush.verticalGradient(
                        colors = listOf(
                            Color.Transparent,
                            Color.Black
                        ),
                        startY = 300f
                    )
                )) {

            }
            Box(modifier = Modifier
                .fillMaxSize()
                .padding(15.dp), contentAlignment = Alignment.BottomStart) {
                Text(text = title, style = TextStyle(color = Color.White, fontSize = 16.sp))
            }
        }
    }
}

//Styling Text
val fontFamily = FontFamily(
    Font(R.font.poppins_regular, FontWeight.Normal),
    Font(R.font.poppins_medium, FontWeight.Medium)
)
@Composable
fun StylingText(){
    Text(
        text = buildAnnotatedString {
                                    withStyle(
                                        style = SpanStyle(
                                            color = Color.Red,
                                            fontSize = 40.sp
                                        )
                                    ){
                                        append("H")
                                    }
            append("ello this is ")
            withStyle(
                style = SpanStyle(
                    color = Color.Blue,
                    fontSize = 40.sp
                )
            ){
                append("ME!")
            }
            append("\n How are you today?")
        },
        fontSize = 30.sp,
        color = Color.Black,
        fontFamily = fontFamily,
        fontWeight = FontWeight.Medium,
        textAlign = TextAlign.Center,
        fontStyle = FontStyle.Normal,
        textDecoration = TextDecoration.Underline
    )
}

//State Compose
@Composable
fun StateCompose(modifier: Modifier = Modifier, stateColor: (Color) -> Unit){
    Box(modifier = Modifier
        .fillMaxWidth()
        .height(200.dp)
        .background(Color.Red)
        .clickable {
            stateColor(
                Color(
                    Random.nextFloat(),
                    Random.nextFloat(),
                    Random.nextFloat(),
                    1f
                )
            )
        }) {

    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainTheme {
        Greeting("Android")
    }
}