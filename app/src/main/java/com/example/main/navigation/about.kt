package com.example.main.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.KeyboardArrowLeft
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AboutScreen(navController: NavController) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopAppBar(
                navigationIcon = {
                                 IconButton(onClick = {
                                     navController.popBackStack()
                                 }) {
                                    Icon(imageVector = Icons.AutoMirrored.Filled.KeyboardArrowLeft, contentDescription = "back")
                                 }
                },
                title = {
                    Text(text = "ABOUT APP")
                },
            )
        },
    ){ paddingValues ->  
        Box(modifier = Modifier
            .padding(paddingValues = paddingValues)
            .fillMaxSize()
            .padding(16.dp)){
            Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit. Curabitur eu nisi imperdiet, dapibus nisi sed, tempor odio. Vestibulum ante ipsum primis in faucibus orci luctus et ultrices posuere cubilia curae; Proin arcu sem, tincidunt vel ultricies eget, tincidunt et justo. Ut commodo, nisi et mollis ultrices, enim ante rutrum est, eget tempus arcu lectus tincidunt sem. Suspendisse potenti. Ut accumsan odio a arcu rutrum, a vulputate erat venenatis. Aenean tempus bibendum felis, eu finibus velit congue vel. Proin ornare tincidunt facilisis.")
        }
    }
}