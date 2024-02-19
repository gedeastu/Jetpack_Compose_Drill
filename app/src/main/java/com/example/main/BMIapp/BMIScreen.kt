package com.example.main.BMIapp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.RadioButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun BMIScreen(modifier: Modifier = Modifier){

    var berat by remember {
        mutableStateOf("")
    }
    var tinggi by remember {
        mutableStateOf("")
    }
    var bmi by remember {
        mutableStateOf(0f)
    }
    var kategori by remember {
        mutableStateOf(0)
    }
    val radioOptions = listOf(
        stringResource(id = R.string.pria),
        stringResource(id = R.string.wanita)
    )
    var gender by remember {
        mutableStateOf(radioOptions[0])
    }

    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)){

        //Text Title
        Text(
            text = stringResource(id = R.string.bmi_intro),
            modifier = Modifier.fillMaxWidth(),
            style = MaterialTheme.typography.bodyLarge,
        )

        //TextField Berat
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

        //TextField Tinggi
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

        //Radio
        Row(modifier = Modifier
            .padding(top = 6.dp)
            .border(1.dp, Color.Gray, RoundedCornerShape(4.dp))
            .fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
            radioOptions.forEach{ value ->
                GenderOptions(label = value, isSelected = gender == value, modifier = Modifier
                    .selectable(
                        selected = gender == value,
                        onClick = { gender = value },
                        role = Role.RadioButton
                    )
                    .weight(1f)
                    .padding(16.dp))
            }

            //Tombol Counting
            Button(onClick = {
                bmi = countBMI(berat = berat.toFloat(), tinggi = tinggi.toFloat())
                kategori = getKategori( bmi = bmi, isMale = gender == radioOptions[0])
            }, modifier = Modifier.padding(top = 8.dp), contentPadding = PaddingValues(horizontal = 32.dp)) {
                Text(text = stringResource(id = R.string.hitung))
            }
        }
    }

}


@Composable
fun GenderOptions(label:String, isSelected:Boolean, modifier: Modifier){
    Row(modifier = Modifier, verticalAlignment = Alignment.CenterVertically){
        RadioButton(selected = isSelected, onClick = {  })
        Text(
            text = label,
            style = MaterialTheme.typography.bodyLarge,
            modifier = Modifier.padding(start = 2.dp)
        )
    }
}

private fun countBMI(berat: Float,tinggi: Float):Float{
    return berat / ( tinggi / 100 ).pow(2)
}
private fun getKategori(bmi: Float, isMale: Boolean): Int{
    return if (isMale){
        when{
            bmi < 20.5 -> R.string.kurus
            bmi > 27.0 -> R.string.gemuk
            else -> R.string.ideal
        }
    }else{
        when{
            bmi < 18.5 -> R.string.kurus
            bmi >= 25.0 -> R.string.gemuk
            else -> R.string.ideal
        }
    }
}
