package com.example.main.bmiApp.screens

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.semantics.Role
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.main.R
import kotlin.math.pow

@Composable
fun ScreenContent(modifier: Modifier){
    var berat by remember {
        mutableStateOf("")
    }
    var beratError by remember {
        mutableStateOf(false)
    }

    var tinggi by remember {
        mutableStateOf("")
    }
    var tinggiError by remember {
        mutableStateOf(false)
    }
    
    val radioOptions = listOf(
        stringResource(id = R.string.pria),
        stringResource(id = R.string.wanita)
    )

    var gender by remember {
        mutableStateOf(radioOptions[0])
    }

    var bmi by remember {
        mutableFloatStateOf(0f)
    }

    var kategori by remember {
        mutableIntStateOf(0)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){

        Text(text = stringResource(id = R.string.bmi_intro), style = MaterialTheme.typography.bodyLarge, modifier = Modifier.fillMaxWidth())

        OutlinedTextField(
            value = berat,
            onValueChange = {
                berat = it
            },
            label = {
                Text(text = stringResource(id = R.string.berat_badan))
            },
            trailingIcon = {
                IconPicker(isError = beratError, unit = "kg")
            },
            supportingText = {
                             ErrorHint(isError = beratError)
            },
            singleLine = true,
            isError = beratError,
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )

        OutlinedTextField(
            value = tinggi,
            onValueChange = {
                tinggi = it
            },
            label = {
                Text(text = stringResource(id = R.string.tinggi_badan))
            },
            isError = tinggiError,
            trailingIcon = {
                IconPicker(isError = tinggiError, unit = "cm")
            },
            singleLine = true,
            supportingText = {ErrorHint(isError = tinggiError)},
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        Row(modifier = Modifier
            .padding(top = 6.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))){
            radioOptions.forEach{ value ->
                GenderOption(label = value, isSelected = value == gender, modifier = Modifier
                    .selectable(
                        selected = gender == value,
                        onClick = {
                            gender = value
                        },
                        role = Role.RadioButton
                    )
                    .weight(1f)
                    .padding(16.dp)
                )
            }
        }

        Button(
            onClick = {
                beratError = (berat == "" || berat == "0")
                tinggiError = (tinggi == "" || tinggi == "0")
                if (beratError || tinggiError) return@Button

                bmi = hitungBMI(berat.toFloat(),tinggi.toFloat())
                kategori = getKategori(bmi = bmi, isMale = gender == radioOptions[0])
            },
            modifier = Modifier.padding(top = 8.dp),
            contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
        ) {
            Text(text = stringResource(id = R.string.hitung))
        }

        if (bmi != 0f){
            VerticalDivider(
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(text = stringResource(id = R.string.bmi_x, bmi), style = MaterialTheme.typography.titleLarge)
            Text(text = stringResource(kategori).uppercase(), style = MaterialTheme.typography.headlineLarge)
        }

    }
}

@Composable
fun GenderOption(label:String, isSelected: Boolean, modifier: Modifier){
    Row(modifier = modifier, verticalAlignment = Alignment.CenterVertically){
        RadioButton(selected = isSelected, onClick = null)
        Text(text = label, style = MaterialTheme.typography.bodyLarge, modifier = Modifier.padding(start = 8.dp))
    }
}

@Composable
fun IconPicker(isError:Boolean,unit:String){
    if (isError){
        Icon(imageVector = Icons.Filled.Warning, contentDescription = null)
    }else{
        Text(text = unit)
    }
}

@Composable
fun ErrorHint(isError: Boolean){
    if (isError){
        Text(text = stringResource(id = R.string.input_invalid))
    }
}

private fun hitungBMI(berat:Float,tinggi:Float):Float{
    return berat/(tinggi/100).pow(2)
}

private  fun getKategori(bmi:Float, isMale:Boolean):Int{
    return if (isMale){
        when{
            bmi < 20.5 -> R.string.kurus
            bmi >= 27.0 -> R.string.gemuk
            else -> R.string.ideal
        }
    }else{
        when{
            bmi < 18.5 -> R.string.kurus
            bmi >= 25.0 -> R.string.gemuk
            else->R.string.ideal
        }
    }
}