package com.example.main.BMIapp

import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.selection.selectable
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
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
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.main.R

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

@Composable
fun GenderSection(){
    val radioOptions = listOf<String>(
        stringResource(id = R.string.pria),
        stringResource(id = R.string.wanita)
    )
    var gender by remember {
        mutableStateOf(radioOptions[0])
    }
    Row(modifier = Modifier.padding(top = 6.dp).border(1.dp, Color.Gray, RoundedCornerShape(4.dp)).fillMaxWidth(), horizontalArrangement = Arrangement.SpaceAround){
        radioOptions.forEach{value ->
            GenderOptions(label = value, isSelected = gender == value, modifier = Modifier.selectable(
                selected = gender == value,
                onClick = { gender = value },
                role = Role.RadioButton
            ).weight(1f).padding(16.dp))
        }
    }
}