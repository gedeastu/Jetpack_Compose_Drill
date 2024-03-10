package com.example.main.TP04

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OutlinedTextFieldCase(title:String,content: @Composable (Modifier) -> Unit) {
    Scaffold(
        topBar = {
            TopAppBar(
                modifier = Modifier.padding(),
                title = {
                    Text(title)
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.Gray,
                    titleContentColor = Color.White
                )
            )
        }
    ){ paddingValues ->
        content(Modifier.padding(paddingValues = paddingValues))
    }
}