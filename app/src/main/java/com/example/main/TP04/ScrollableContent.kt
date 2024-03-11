package com.example.main.TP04

import androidx.compose.foundation.Image
import androidx.compose.foundation.gestures.rememberScrollableState
import androidx.compose.foundation.gestures.scrollable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.example.main.R

@Composable
fun ScrollableContent() {
    Column(modifier = Modifier
        .fillMaxSize().padding(start = 18.dp, end = 18.dp , top = 40.dp)
        .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
        ){
        Image(painter = painterResource(id = R.drawable.light_on), contentDescription = "light_on", modifier = Modifier.padding(bottom = 10.dp))
        Text(text = "The IDEA", style = MaterialTheme.typography.displayLarge, modifier = Modifier.padding(bottom = 10.dp))
        Text(text = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Habitasse platea dictumst vestibulum rhoncus est pellentesque elit ullamcorper. Fames ac turpis egestas maecenas. Eu lobortis elementum nibh tellus. Rhoncus urna neque viverra justo nec ultrices. Curabitur vitae nunc sed velit dignissim sodales. Lorem sed risus ultricies tristique nulla. Est ante in nibh mauris cursus mattis molestie a. Gravida cum sociis natoque penatibus et magnis dis. Pharetra sit amet aliquam id diam maecenas ultricies. Massa sed elementum tempus egestas sed sed. Viverra accumsan in nisl nisi scelerisque eu ultrices vitae auctor. Purus in massa tempor nec feugiat nisl pretium fusce id. Amet dictum sit amet justo donec enim diam.\n" +
                "\n" +
                "Quis varius quam quisque id diam. Dolor purus non enim praesent elementum facilisis leo. Orci sagittis eu volutpat odio. Id faucibus nisl tincidunt eget nullam non. At elementum eu facilisis sed. Enim ut sem viverra aliquet eget sit amet tellus. Faucibus ornare suspendisse sed nisi lacus sed viverra tellus in. Tortor consequat id porta nibh venenatis cras sed felis eget. Lectus vestibulum mattis ullamcorper velit sed ullamcorper morbi tincidunt ornare. Orci ac auctor augue mauris augue neque gravida in fermentum.\n" +
                "\n" +
                "Mi sit amet mauris commodo. Tristique nulla aliquet enim tortor at auctor. Vitae sapien pellentesque habitant morbi tristique. Fusce ut placerat orci nulla. Amet justo donec enim diam vulputate ut pharetra sit amet. Et tortor consequat id porta nibh venenatis cras sed felis. Volutpat ac tincidunt vitae semper quis lectus nulla. Egestas tellus rutrum tellus pellentesque eu tincidunt. Volutpat consequat mauris nunc congue nisi vitae suscipit tellus mauris. Mauris vitae ultricies leo integer malesuada. Sit amet mauris commodo quis imperdiet massa. Ac orci phasellus egestas tellus rutrum tellus. Bibendum neque egestas congue quisque egestas diam in arcu cursus. Faucibus ornare suspendisse sed nisi lacus sed.\n" +
                "\n" +
                "Arcu vitae elementum curabitur vitae nunc. Augue mauris augue neque gravida in fermentum et. Congue mauris rhoncus aenean vel elit scelerisque mauris pellentesque pulvinar. Turpis nunc eget lorem dolor. Sit amet est placerat in egestas erat imperdiet. Sem viverra aliquet eget sit amet tellus cras adipiscing enim. Lectus urna duis convallis convallis tellus id interdum velit. Ullamcorper a lacus vestibulum sed arcu non odio. Lobortis scelerisque fermentum dui faucibus in ornare quam viverra orci. Sed risus pretium quam vulputate dignissim suspendisse in. Platea dictumst quisque sagittis purus sit amet volutpat consequat mauris. Facilisis leo vel fringilla est. Semper viverra nam libero justo laoreet sit amet cursus. Eget felis eget nunc lobortis mattis aliquam. Suscipit adipiscing bibendum est ultricies integer. In nulla posuere sollicitudin aliquam ultrices sagittis orci a. Porttitor rhoncus dolor purus non enim praesent elementum. Quis auctor elit sed vulputate. Interdum velit euismod in pellentesque massa placerat duis ultricies. Ultrices eros in cursus turpis massa tincidunt dui.")
    }
}