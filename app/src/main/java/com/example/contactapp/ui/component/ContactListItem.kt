package com.example.contactapp.ui.component

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.example.contactapp.model.Contact


@Composable
fun ContactListItem(contact: Contact, navigateToDetails: (Contact) -> Unit){
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp).clickable {
                navigateToDetails(contact)
            },
        colors = CardDefaults.cardColors(
            containerColor = Color.Transparent
        )

    ) {
        Row(modifier = Modifier.padding(horizontal = 20.dp)) {
            Icon(imageVector = Icons.Default.AccountCircle, contentDescription = "Account Circle")
            Spacer(modifier = Modifier.width(5.dp))

            Text(text = "${contact.fname} ${contact.lname}")

        }
    }
}