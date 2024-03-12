package com.example.main.trapesiumFormula

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.main.bmiApp.screens.ScreenContent
import com.example.main.trapesiumFormula.screens.TrapesiumFormulaScreenContent

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrapesiumFormulaScreen(){
    Scaffold(
        topBar = {
            TopAppBar(
                title = { 
                    Text(text = "Trapesium Formula", modifier = Modifier.padding(vertical = 16.dp))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = Color.DarkGray,
                    titleContentColor = Color.White,
                ),
            )
        }
    ){paddingValue ->
        TrapesiumFormulaScreenContent(modifier = Modifier.padding( paddingValues = paddingValue))
    }
}
