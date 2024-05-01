package com.example.main.catatan.screen

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavHostController
import com.example.main.R
import com.example.main.catatan.model.Catatan
import com.example.main.catatan.navigation.Screen

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen(navController: NavHostController) {
    //val context = LocalContext.current
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text(text = stringResource(id = R.string.app_name))
                },
                colors = TopAppBarDefaults.mediumTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        },
        floatingActionButton = {
            FloatingActionButton(onClick = {
                navController.navigate(Screen.FormBaru.route)
                //Toast.makeText(context, R.string.tambah_error, Toast.LENGTH_SHORT).show()
            }) {
                Icon(imageVector = Icons.Filled.Add, contentDescription = stringResource(id = R.string.tambah_catatan), tint = MaterialTheme.colorScheme.primary)
            }
        }
    ){paddingValues ->
        ScreenContent(Modifier.padding(paddingValues = paddingValues), navController = navController)
    }
}

@Composable
fun ScreenContent(modifier: Modifier, navController: NavHostController) {

    val viewModel: MainViewModel = viewModel()
    //val data = emptyList<Catatan>()
    val data = viewModel.data
    //val context = LocalContext.current

    if (data.isEmpty()){
        Column(modifier = modifier
            .fillMaxSize()
            .padding(16.dp), verticalArrangement = Arrangement.Center, horizontalAlignment = Alignment.CenterHorizontally){
            Text(text = stringResource(id = R.string.list_kosong))
        }
    }else{
        LazyColumn(
            modifier = modifier.fillMaxSize(),
            contentPadding = PaddingValues(bottom = 84.dp),
            content = {
                items(data){
                    ListItem(catatan = it, onClick = {
                        //val pesan = context.getString(R.string.x_diklik, it.judul)
                        //Toast.makeText(context,pesan,Toast.LENGTH_SHORT).show()
                        navController.navigate(Screen.FormUbah.withId(it.id))
                    })
                    HorizontalDivider()
                }
            })
    }
}

@Composable
fun ListItem(catatan: Catatan, onClick: () -> Unit) {
    Column(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick() }
            .padding(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp))
    {
        Text(text = catatan.judul, maxLines = 1, overflow = TextOverflow.Ellipsis, fontWeight = FontWeight.Bold)
        Text(text = catatan.catatan, maxLines = 2, overflow = TextOverflow.Ellipsis)
        Text(text = catatan.tanggal)
    }
}