package com.example.main.trapesiumFormula.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Warning
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.VerticalDivider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.main.R

@Composable
fun TrapesiumFormulaScreenContent(modifier: Modifier) {
    var sisiPertama by remember {
        mutableStateOf("")
    }
    var sisiKedua by remember {
        mutableStateOf("")
    }
    var sisiKetiga by remember {
        mutableStateOf("")
    }
    var sisiKeempat by remember {
        mutableStateOf("")
    }
    var tinggi by remember {
        mutableStateOf("")
    }

    var sisiPertamaError by remember {
        mutableStateOf(false)
    }
    var sisiKeduaError by remember {
        mutableStateOf(false)
    }
    var sisiKetigaError by remember {
        mutableStateOf(false)
    }
    var sisiKeempatError by remember {
        mutableStateOf(false)
    }
    var tinggiError by remember {
        mutableStateOf(false)
    }
    var luasResult by remember {
        mutableFloatStateOf(0f)
    }
    var kelilingResult by remember {
        mutableFloatStateOf(0f)
    }
    var resetResult by remember {
        mutableStateOf(false)
    }

    Column(
        modifier = modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(16.dp)
    ){
        Text(text = stringResource(id = R.string.trapesium_formula_intro))
        OutlinedTextField(
            value = sisiPertama, 
            onValueChange = {
                sisiPertama = it
            },
            label = {
                Text(text = stringResource(id = R.string.sisiPertama))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            trailingIcon = {
                IconPicker(isError = sisiPertamaError, unit = "cm")
            },
            isError = sisiPertamaError,
            supportingText = {
                ErrorHint(isError = sisiPertamaError)
            }
        )
        OutlinedTextField(
            value = sisiKedua,
            onValueChange = {
                sisiKedua = it
            },
            label = {
                Text(text = stringResource(id = R.string.sisiKedua))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            trailingIcon = {
                IconPicker(isError = sisiKeduaError, unit = "cm")
            },
            isError = sisiKeduaError,
            supportingText = {
                ErrorHint(isError = sisiKeduaError)
            }
        )
        OutlinedTextField(
            value = sisiKetiga,
            onValueChange = {
                sisiKetiga = it
            },
            label = {
                Text(text = stringResource(id = R.string.sisiKetiga))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            trailingIcon = {
                IconPicker(isError = sisiKetigaError, unit = "cm")
            },
            isError = sisiKetigaError,
            supportingText = {
                ErrorHint(isError = sisiKetigaError)
            }
        )
        OutlinedTextField(
            value = sisiKeempat,
            onValueChange = {
                sisiKeempat = it
            },
            label = {
                Text(text = stringResource(id = R.string.sisiKeempat))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            trailingIcon = {
                IconPicker(isError = sisiKeempatError, unit = "cm")
            },
            isError = sisiKeempatError,
            supportingText = {
                ErrorHint(isError = sisiKeempatError)
            }
        )
        OutlinedTextField(
            value = tinggi,
            onValueChange = {
                tinggi = it
            },
            label = {
                Text(text = stringResource(id = R.string.tinggi))
            },
            keyboardOptions = KeyboardOptions(
                keyboardType = KeyboardType.Number,
                imeAction = ImeAction.Done
            ),
            modifier = Modifier.fillMaxWidth(),
            singleLine = true,
            trailingIcon = {
                IconPicker(isError = tinggiError, unit = "cm")
            },
            isError = tinggiError,
            supportingText = {
                ErrorHint(isError = tinggiError)
            }
        )
        Row(modifier = Modifier.fillMaxWidth(), horizontalArrangement = Arrangement.SpaceEvenly){
            Button(
                onClick = {
                    sisiPertamaError = (sisiPertama == "") || (sisiPertama == "0")
                    sisiKeduaError = (sisiKedua == "") || (sisiKedua == "0")
                    sisiKetigaError = (sisiKetiga == "") || (sisiKetiga == "0")
                    sisiKeempatError = (sisiKeempat == "") || (sisiKeempat == "0")
                    tinggiError = (tinggi == "" || tinggi == "0")
                    if (sisiPertamaError || sisiKeduaError || sisiKetigaError || sisiKeempatError || tinggiError) return@Button

                    luasResult = luasTrapesiumFormula(sisiPertama = sisiPertama.toFloat(), sisiKedua = sisiKedua.toFloat(), tinggi = tinggi.toFloat())
                    kelilingResult = kelilingTrapesiumFormula(sisiPertama = sisiPertama.toFloat(), sisiKedua = sisiKedua.toFloat(), sisiKetiga = sisiKetiga.toFloat(), sisiKeempat = sisiKeempat.toFloat())

                },
                modifier = Modifier.padding(top = 8.dp),
                contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
            ) {
                Text(text = stringResource(id = R.string.hitung))
            }

            if (luasResult != 0f || kelilingResult != 0f){
                Button(
                    onClick = {
                        sisiPertama = ""
                        sisiKedua = ""
                        sisiKetiga = ""
                        sisiKeempat = ""
                        tinggi = ""
                        resetResult = true
                    },
                    modifier = Modifier.padding(top = 8.dp),
                    contentPadding = PaddingValues(horizontal = 32.dp, vertical = 16.dp)
                ) {
                    Text(text = stringResource(id = R.string.Reset))
                }
            }
        }
        if (luasResult != 0f && kelilingResult != 0f && !resetResult){
            VerticalDivider(
                modifier = Modifier.padding(vertical = 8.dp)
            )
            Text(text = stringResource(id = R.string.Luas_Trapesium,luasResult), style = MaterialTheme.typography.titleLarge)
            Text(text = stringResource(id = R.string.Keliling_Trapesium,kelilingResult), style = MaterialTheme.typography.titleLarge)
        }else{
            VerticalDivider(
                modifier = Modifier.padding(vertical = 0.dp)
            )
            Text(text = "", style = MaterialTheme.typography.titleLarge)
            Text(text = "", style = MaterialTheme.typography.titleLarge)
        }
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

    private fun luasTrapesiumFormula(sisiPertama:Float, sisiKedua:Float, tinggi:Float) : Float {
        return 0.5f * (sisiPertama + sisiKedua) * tinggi
    }

    private fun kelilingTrapesiumFormula(sisiPertama:Float, sisiKedua:Float, sisiKetiga: Float, sisiKeempat: Float) : Float{
        return sisiPertama + sisiKedua + sisiKetiga + sisiKeempat
    }