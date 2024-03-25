package com.example.main.bmiApp

sealed class Screen(val route:String){
    object Home: Screen("home")
}