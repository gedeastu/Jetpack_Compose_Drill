package com.example.main.TP04

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material.icons.filled.KeyboardArrowUp
import androidx.compose.material3.DropdownMenu
import androidx.compose.material3.DropdownMenuItem
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.layout.onGloballyPositioned
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.toSize

@Composable
fun DropDown() {
    var expanded by remember { mutableStateOf(false) }

    val list = listOf<String>("Kotlin","JavaScript","Dart","Java","TypeScript")

    var selectedItem by remember {
        mutableStateOf("")
    }

    var textFiledSize by remember {
        mutableStateOf(Size.Zero)
    }

    val icon = if (expanded){
        Icons.Filled.KeyboardArrowUp
    }else{
        Icons.Filled.KeyboardArrowDown
    }

    Column(modifier = Modifier.padding(16.dp)){
        OutlinedTextField(value = selectedItem, onValueChange ={
            selectedItem = it
        }, modifier = Modifier
            .fillMaxWidth(0.5f)
            .onGloballyPositioned { coordinates ->
                textFiledSize = coordinates.size.toSize()
            }.clickable{
                       expanded = !expanded
            },
            label = { Text(text = "Select Item") },
            trailingIcon = {
                Icon(icon, contentDescription = "", Modifier.clickable{
                    expanded = !expanded
                })
            },
        )
        DropdownMenu(
            expanded = expanded,
            onDismissRequest = { expanded = false },
            modifier = Modifier.width(with(LocalDensity.current){
                textFiledSize.width.toDp()
            })
        ) {
            list.forEach { label ->
                DropdownMenuItem(
                    text = {
                        Text(text = label)
                    },

                    onClick = {
                        selectedItem = label
                        expanded = false
                    })
            }
        }
    }
}