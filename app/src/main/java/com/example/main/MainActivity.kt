package com.example.main

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.main.ui.theme.MainTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MainTheme {
                //

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
            .fillMaxHeight()
            .width(300.dp)
    ) {
        Text(text = "Hello")
        Text(text = "Astu")
    }
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    MainTheme {
        Greeting("Android")
    }
}