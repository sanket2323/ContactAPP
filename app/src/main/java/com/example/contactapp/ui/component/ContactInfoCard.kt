package com.example.contactapp.ui.component

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Call
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contactapp.model.Contact



@Composable
fun ContactInfoCard(contact: Contact) {

    Card(
        modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .height(130.dp)
    ) {
        Text(
            text = "Contact Information",
            modifier = Modifier.padding(16.dp),
            fontSize = MaterialTheme.typography.bodyLarge.fontSize,
            fontWeight = FontWeight.Bold
        )
        Row(
            modifier = Modifier.padding(16.dp)

        ) {
            Icon(imageVector = Icons.Default.Call, contentDescription = "Call")
            Spacer(modifier = Modifier.width(8.dp))
            Text(
                text = contact.number,
//                modifier = Modifier.padding(start = 16.dp, top = 8.dp),
                fontSize = MaterialTheme.typography.bodyLarge.fontSize
            )
        }

    }
}