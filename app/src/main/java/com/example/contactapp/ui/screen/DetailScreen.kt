package com.example.contactapp.ui.screen

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Call
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.Edit
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import com.example.contactapp.model.Contact
import com.example.contactapp.ui.component.ContactInfoCard



@Composable
fun DetailsScreen(navController: NavController,contact: Contact) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Account Info",
            modifier = Modifier
                .size(200.dp)
                .padding(top = 50.dp)
        )
        Spacer(modifier = Modifier.height(20.dp))
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 20.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceEvenly
        ) {
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = Icons.Default.Call, contentDescription = "Phone")
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Call")
            }
            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = Icons.Default.Edit, contentDescription = "Edit")
                Spacer(modifier = Modifier.height(4.dp))
                Text("Edit")
            }

            Column(
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Icon(imageVector = Icons.Default.Delete, contentDescription = "Delete")
                Spacer(modifier = Modifier.height(4.dp))
                Text(text = "Delete")
            }


        }

        Spacer(modifier = Modifier.height(20.dp))
        ContactInfoCard(contact)

    }
}