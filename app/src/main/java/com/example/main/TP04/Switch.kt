package com.example.main.TP04

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Switch
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

@Composable
fun SwitchCase() {
    var checked by remember { mutableStateOf(false) }

    Column(
        modifier = Modifier.padding(16.dp)
    ) {
        Text("${if (checked) "on" else "off"}")

        Spacer(modifier = Modifier.height(16.dp))

        Switch(
            checked = checked,
            onCheckedChange = { checked = it }
        )
    }
}