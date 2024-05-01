package com.example.main.DarkModeDataStore

import android.widget.ToggleButton
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Switch
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DarkMode() {
    val dataStore = UIModePreference(LocalContext.current)
    val darkMode by dataStore.themeFlow.collectAsState(initial = false)
    Scaffold(
        topBar = {
            TopAppBar(
                title = { /*TODO*/ },
                actions = {
                    Switch(checked = darkMode, onCheckedChange = { CoroutineScope(Dispatchers.IO).launch {
                        dataStore.toggleDarkMode()
                    }})
                }
            )
        }
    ){paddingValues->
        Column(modifier = Modifier.padding(paddingValues = paddingValues)){

        }
    }
}