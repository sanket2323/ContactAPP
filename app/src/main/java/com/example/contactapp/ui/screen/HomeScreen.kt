package com.example.contactapp.ui.screen

import android.content.Intent
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.navigation.NavController
import com.example.contactapp.AddContactActivityMain
import com.example.contactapp.firebaseDb.FirebaseRepo
import com.example.contactapp.firebaseDb.FirebaseState
import com.example.contactapp.firebaseDb.FirebaseViewModel
import com.example.contactapp.model.Contact
import com.example.contactapp.ui.component.ContactListItem
import com.example.contactapp.ui.component.SearchBar
import com.example.contactapp.ui.component.Upperpart


@Composable
fun HomeScreen(
    modifier: Modifier,
    navController: NavController,
    navigateToDetail: (Contact) -> Unit
) {
    val context = LocalContext.current
    val firebaseViewModel = FirebaseViewModel(FirebaseRepo())

    LaunchedEffect(Unit) {
        firebaseViewModel.getContactList()
    }

    val state by firebaseViewModel.state.collectAsState()
    Scaffold(
        floatingActionButton = {

            Button(
                onClick = {
                    val intent = Intent(context, AddContactActivityMain::class.java)
                    context.startActivity(intent)
                },
                shape = MaterialTheme.shapes.extraLarge,
            ) {
                Icon(
                    imageVector = Icons.Default.Add,
                    contentDescription = "Add Contact",
                )
            }

        }

    ) { it ->
        Column(
            modifier = modifier.padding(it)
        ) {
            SearchBar()
            Upperpart()
            LazyColumn {
                items(state.contactList) { contact ->
                    ContactListItem(contact,navigateToDetail)
                }
            }
        }
    }

}

@Composable
fun ContactList(navigateToDetail: (Contact) -> Unit, state: FirebaseState) {

    var progressState by remember {
        mutableStateOf(false)
    }




}