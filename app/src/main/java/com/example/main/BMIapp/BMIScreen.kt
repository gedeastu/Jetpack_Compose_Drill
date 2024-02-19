package com.example.main.BMIapp

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.main.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BMIScreen(modifier: Modifier = Modifier){
    var berat by remember {
        mutableStateOf("")
    }
    var tinggi by remember {
        mutableStateOf("")
    }
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)){
        Text(
            text = stringResource(id = R.string.bmi_intro),
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyLarge,
        )
        OutlinedTextField(
            value = berat, 
            onValueChange = {
                berat = it
            },
            label = {
                Text(text = stringResource(id = R.string.berat_badan))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 10.dp),
            trailingIcon = {
                Text(text = stringResource(id = R.string.kg))
            },
        )
        OutlinedTextField(
            value = tinggi,
            onValueChange = {
                tinggi = it
            },
            label = {
                Text(text = stringResource(id = R.string.tinggi_badan))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            singleLine = true,
            modifier = Modifier
                .fillMaxWidth()
                .padding(bottom = 10.dp),
            trailingIcon = {
                Text(text = stringResource(id = R.string.cm))
            },
        )
        GenderSection()
        HitungButton()
    }
}