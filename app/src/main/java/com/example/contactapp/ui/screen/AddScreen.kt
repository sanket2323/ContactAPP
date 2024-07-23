package com.example.contactapp.ui.screen

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp

import com.example.contactapp.ui.component.TopBarAddContactScreen

@Composable()
fun AddScreen(){
    Scaffold(
        topBar = { TopBarAddContactScreen() },
    ) {
        Spacer(modifier = Modifier.height(0.dp).padding(it))
    }
}


@Preview
@Composable
fun PreviewAddScreen() {
    AddScreen()
}