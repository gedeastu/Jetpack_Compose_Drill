package com.example.main.navigation

import android.content.Context
import android.content.Intent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Info
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.main.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Navigation(navController: NavController) {
    val context = LocalContext.current
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                title = {
                    Text(text = "MY APP")
                },
                actions = {
                    IconButton(
                        onClick = {
                            navController.navigate("about")
                        }
                    ) {
                        Icon(imageVector = Icons.Default.Info, contentDescription = "info")
                    }
                }
            )
        },
    ){ paddingValues ->
        Column(modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize(), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
            Text(text = "MAIN SCREEN")
            Button(onClick = {

            }) {
                Text(text = "Bagikan")
            }
        }
    }
}

private fun shareData(context: Context, message:String){
    val shareIntent = Intent(Intent.ACTION_SEND).apply {
        type = "text/plain"
        putExtra(Intent.EXTRA_TEXT, message)
    }
    if (shareIntent.resolveActivity(context.packageManager) != null){
        context.startActivity(shareIntent)
    }
}