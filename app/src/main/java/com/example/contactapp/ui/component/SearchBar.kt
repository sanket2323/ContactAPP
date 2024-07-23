package com.example.contactapp.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp



@Preview(showSystemUi = true)
@Composable
fun SearchBar(){

    var userInput by remember {
        mutableStateOf("")
    }
    OutlinedTextField(
        trailingIcon = {
            Row {
                Icon(imageVector = Icons.Default.MoreVert, contentDescription ="Null" )
            }
        },
        leadingIcon = {
            Icon(imageVector = Icons.Default.Search, contentDescription ="Search Icon" )
        },
        value = userInput,
        onValueChange = {
            userInput = it
        },
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp, start = 16.dp,end = 16.dp),
        shape = RoundedCornerShape(40.dp),
        label = {
            Text(text = "Search for contact")
        }
    )
}