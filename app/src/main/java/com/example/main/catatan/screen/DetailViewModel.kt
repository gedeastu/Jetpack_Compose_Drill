package com.example.main.catatan.screen

import androidx.lifecycle.ViewModel
import com.example.main.catatan.model.Catatan

class DetailViewModel : ViewModel() {
    fun getCatatan(id:Long): Catatan {
        return Catatan( id = id, judul = "Kuliah Mobpro $id April", catatan = "Yey, hari ini belajar membuat aplikasi Android counter dan berhasil. Hehe.. Mudah2an modul selanjutnya juga lancar. Aamiin", tanggal = "2024-04-$id 12:34:56")
    }
}