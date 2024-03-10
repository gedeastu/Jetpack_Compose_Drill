package com.example.main.TP04

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Checkbox
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun CheckBox() {
    val checkBoxItems = listOf("Sayur Hijau", "Daging Ayam", "Pisang Kuning")
    val checkedItems = remember { mutableStateListOf<String>() }

    Column {
        checkBoxItems.forEach { item ->
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier.padding(8.dp)
            ) {
                Checkbox(
                    checked = checkedItems.contains(item),
                    onCheckedChange = { isChecked ->
                        if (isChecked) {
                            checkedItems.add(item)
                        } else {
                            checkedItems.remove(item)
                        }
                    }
                )
                Text(text = item, modifier = Modifier.padding(start = 8.dp))
            }
        }

        Spacer(modifier = Modifier.height(16.dp))

        Text("Yang Telah Di beli: ${checkedItems.joinToString()}")
    }
}