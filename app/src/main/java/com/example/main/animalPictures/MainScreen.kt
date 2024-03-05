package com.example.main.animalPictures

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun MainScreen(content : @Composable (Modifier) -> Unit){
    Scaffold(){paddingValues ->
        content(Modifier.padding(paddingValues))
    }
}