package com.example.contactapp.ui.screen

import android.content.Intent
import android.widget.ProgressBar
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column

import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavController
import com.example.contactapp.AddContactActivityMain
import com.example.contactapp.firebaseDb.FirebaseRepo
import com.example.contactapp.firebaseDb.FirebaseViewModel
import com.example.contactapp.model.Contact
import com.example.contactapp.ui.component.ContactListItem
import com.example.contactapp.ui.component.SearchBar
import com.example.contactapp.ui.component.Upperpart
import com.google.firebase.Firebase
import kotlinx.coroutines.time.delay


@Composable
fun HomeScreen(
    modifier: Modifier,
    navController: NavController,
    navigateToDetail: (Contact) -> Unit
) {
    val context = LocalContext.current
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

    ) {
        Column(
            modifier = modifier.padding(it)
        ) {
            SearchBar()
            Upperpart()
            ContactList()
        }
    }

}

@Composable
fun ContactList() {

    val firebaseViewModel = FirebaseViewModel(FirebaseRepo())
    LaunchedEffect(Unit) {
        firebaseViewModel.getContactList()
    }
    val state by firebaseViewModel.state.collectAsState()

    var progressState by remember {
        mutableStateOf(false)
    }

    LazyColumn {
        items(state.contactList) {
            ContactListItem(it)
        }
    }


}