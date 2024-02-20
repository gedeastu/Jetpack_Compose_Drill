package com.example.main.squareFormula

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import com.example.main.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun SquareFormulaScreen(){
    var panjang by remember {
        mutableStateOf("")
    }
    var lebar by remember {
        mutableStateOf("")
    }
    var luas by remember {
        mutableStateOf(0f)
    }
    var keliling by remember {
        mutableStateOf(0f)
    }
    val reset = ""
    val resetFloat = 0f
    Column(modifier = Modifier
        .fillMaxSize()
        .padding(16.dp)){

        Text(text = stringResource(id = R.string.square_formula_intro), modifier = Modifier.padding(bottom = 10.dp))

        Column(horizontalAlignment = Alignment.CenterHorizontally, modifier = Modifier.fillMaxWidth()){

            OutlinedTextField(
                value = panjang,
                onValueChange = {panjang = it},
                label = {
                    Text(text = stringResource(id = R.string.panjang))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(bottom = 5.dp)
            )
            OutlinedTextField(
                value = lebar,
                onValueChange = {lebar = it},
                label = {
                    Text(text = stringResource(id = R.string.Lebar))
                },
                keyboardOptions = KeyboardOptions(
                    keyboardType = KeyboardType.Number,
                    imeAction = ImeAction.Done
                ),
                modifier = Modifier.fillMaxWidth()
            )

            Column(modifier = Modifier.padding(bottom = 20.dp, top = 20.dp)) {
                Button(onClick = {
                    luas = luasFormula(panjang.toFloat(),lebar.toFloat())
                    keliling = kelilingFormula(panjang.toFloat(),lebar.toFloat())
                },) {
                    Text(text = stringResource(id = R.string.Hitung))
                }
                if (keliling != 0f && luas != 0f){
                    Button(onClick = {
                        panjang = reset
                        lebar = reset
                        keliling = resetFloat
                        luas = resetFloat
                    }) {
                        Text(text = stringResource(id = R.string.Reset))
                    }
                }
            }

            if (keliling != 0f && luas != 0f){
                Divider(
                    modifier = Modifier.padding(vertical = 8.dp),
                    thickness = 1.dp
                )
                Text(text = stringResource(id = R.string.Luas_x,luas))
                Text(text = stringResource(id = R.string.Keliling_x,keliling))
            }
        }
    }
}
private fun luasFormula(panjang:Float,lebar:Float) : Float{
    return panjang * lebar
}

private fun kelilingFormula(panjang: Float, lebar: Float) : Float{
    return 2 * (panjang + lebar)
}