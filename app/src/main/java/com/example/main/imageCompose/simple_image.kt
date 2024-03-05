package com.example.main.imageCompose

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.main.R

@Composable
fun SimpleImage(){
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp), horizontalAlignment = Alignment.CenterHorizontally, verticalArrangement = Arrangement.Center){
        //Image(painter = painterResource(id = R.drawable.milli_2l0cwtpcchi_unsplash),modifier = Modifier.size(200.dp) ,contentDescription = "Doggy Picture",)
        Text(text = stringResource(id = R.string.app_name), fontSize = 40.sp)
    }
}