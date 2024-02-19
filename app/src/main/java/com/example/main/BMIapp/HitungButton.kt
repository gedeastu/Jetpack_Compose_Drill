package com.example.main.BMIapp

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.main.R

@Composable
fun HitungButton(){
    Button(onClick = {  }, modifier = Modifier.padding(top = 8.dp), contentPadding = PaddingValues(horizontal = 32.dp)) {
        Text(text = stringResource(id = R.string.hitung))
    }
}