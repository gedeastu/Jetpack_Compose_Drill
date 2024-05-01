package com.example.main.catatan.navigation

import com.example.main.catatan.screen.KEY_ID_CATATAN

sealed class Screen(val route:String){
    object Home : Screen("mainScreen")
    object FormBaru : Screen("detailScreen")
    object FormUbah : Screen("detailScreen/{$KEY_ID_CATATAN}"){
        fun withId(id: Long) = "detailScreen/$id"
    }

}