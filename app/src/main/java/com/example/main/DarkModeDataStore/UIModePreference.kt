package com.example.main.DarkModeDataStore
import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.preferencesDataStore
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

val Context.dataStore : DataStore<Preferences> by preferencesDataStore("theme_preference")
class UIModePreference(private val context: Context){
    companion object{
        private val IS_DARK = booleanPreferencesKey(name = "is_dark")
    }

    val themeFlow: Flow<Boolean> = context.dataStore.data.map {preferences ->
        preferences[IS_DARK] ?: false
    }

    suspend fun toggleDarkMode(){
        context.dataStore.edit {mutablePreferences ->
            val currentMode = mutablePreferences[IS_DARK] ?: false
            mutablePreferences[IS_DARK] = !currentMode
        }
    }
}