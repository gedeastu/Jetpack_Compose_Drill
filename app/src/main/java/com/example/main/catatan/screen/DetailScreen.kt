package com.example.main.catatan.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.icons.outlined.Check
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardCapitalization
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.main.R

const val KEY_ID_CATATAN = "idCatatan"
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DetailScreen(navController: NavHostController, id:Long? = null) {
    val viewModel: DetailViewModel = viewModel()
    var judul by remember {
        mutableStateOf("")
    }
    var catatan by remember {
        mutableStateOf("")
    }
    if (id != null){
        val data = viewModel.getCatatan(id)
        judul = data.judul
        catatan = data.catatan
    }
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    if (id == null){
                        Text(text = stringResource(id = R.string.tambah_catatan))
                    }else{
                        Text(text = stringResource(id = R.string.edit_catatan))
                    }
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                ),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = stringResource(
                            id = R.string.kembali
                        ), tint = MaterialTheme.colorScheme.primary)
                    }
                },
                actions = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.Outlined.Check, contentDescription = stringResource(
                            id = R.string.simpan
                        ), tint = MaterialTheme.colorScheme.primary)
                    }
                }
            )
        }
    ){paddingValues ->
        FormCatatan(title = judul, onTitleChange = { judul = it }, modifier = Modifier.padding(paddingValues), desc = catatan, onDescChange = { catatan = it })
    }
}

@Composable
fun FormCatatan(
    title:String,onTitleChange:(String)->Unit,
    desc: String, onDescChange: (String)->Unit,
    modifier: Modifier
) {
    Column(modifier = modifier
        .fillMaxSize()
        .padding(16.dp), verticalArrangement = Arrangement.spacedBy(16.dp)){
        OutlinedTextField(
            value = title,
            onValueChange = {
                onTitleChange(it)
            },
            label = {
                Text(text = stringResource(id = R.string.judul))
            },
            singleLine = true,
            keyboardOptions = KeyboardOptions(
                capitalization = KeyboardCapitalization.Words,
                imeAction = ImeAction.Next
            ),
            modifier = Modifier.fillMaxWidth()
        )
        OutlinedTextField(value = desc, onValueChange = { onDescChange(it) }, label = { Text(text = stringResource( id = R.string.isi_catatan )) }, keyboardOptions = KeyboardOptions(
            capitalization = KeyboardCapitalization.Sentences
        ), modifier = Modifier.fillMaxSize()
        )
    }
}