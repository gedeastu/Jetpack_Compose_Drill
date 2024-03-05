package com.example.main.animalPictures.challenge

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.main.animalPictures.MainScreen

@Composable
fun SmartLamp(onClick:() -> Unit = {},status:Boolean,getLamp: List<Lamp>){
    MainScreen {modifier ->  
      Column(
          modifier = modifier
              .fillMaxSize()
              .padding(16.dp),
          verticalArrangement = Arrangement.Center,
          horizontalAlignment = Alignment.CenterHorizontally
      )
      {
        Image(painter = painterResource(id = if (status) getLamp[0].imageResId else getLamp[1].imageResId), contentDescription = "lamp")
          Spacer(modifier = modifier.height(20.dp))
          Text(text = if (status) getLamp[0].desc else getLamp[1].desc, fontSize = 25.sp)
          Spacer(modifier = modifier.height(20.dp))
          Button(onClick = {
              onClick()
          }) {
            Text(text = if (status) getLamp[0].status else getLamp[1].status)
          }
      }
    }
}