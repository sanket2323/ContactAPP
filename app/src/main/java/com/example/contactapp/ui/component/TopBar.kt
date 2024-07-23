package com.example.contactapp.ui.component

import android.content.Intent
import android.widget.Toast
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material.icons.filled.Email
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.contactapp.MainActivity
import com.example.contactapp.firebaseDb.FirebaseRepo
import com.example.contactapp.firebaseDb.FirebaseViewModel
import com.example.contactapp.model.Contact

@OptIn(ExperimentalMaterial3Api::class)
@Composable()
fun TopBarAddContactScreen() {
    val firebaseRepo : FirebaseRepo = FirebaseRepo()
    val firebaseViewModel:FirebaseViewModel = FirebaseViewModel(firebaseRepo)
    val context = LocalContext.current
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var phoneNumber by remember { mutableStateOf("") }
    var email by remember { mutableStateOf("") }
    val state by firebaseViewModel.state.collectAsState()


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Account Info",
            modifier = Modifier
                .size(200.dp)
                .padding(top = 100.dp)
        )
        Text(text = "Add Photo")
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            androidx.compose.material3.Icon(imageVector = Icons.Default.Person, contentDescription = "Null")
            Column {
                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    label = {
                        Text(text = "First name")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 0.dp),

                    )

                //text field for last name
                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    label = {
                        Text(text = "Last name")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 0.dp),
                )

            }
        }

        //for phone number
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            androidx.compose.material3.Icon(imageVector = Icons.Default.Phone, contentDescription = "Phone Number")
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = {
                    Text(text = "Phone number")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 0.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Phone
                )
            )

        }

        //Mail address
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            androidx.compose.material3.Icon(imageVector = Icons.Default.Email, contentDescription = "Phone Number")
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(text = "Email")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 0.dp),

                )

        }




    }

    TopAppBar(
        title = {
            Text(
                text = "Add Contact",
                modifier = Modifier.padding(10.dp),
                fontWeight = FontWeight.Bold
            )
        },

        navigationIcon = {
            IconButton(onClick = {
                val intent = Intent(context,MainActivity::class.java)
                context.startActivity(intent)
            }) {
                Icon(imageVector = Icons.Default.ArrowBack, contentDescription = "Go back arrow")
            }
        },

        actions = {

            Row(
                verticalAlignment = Alignment.CenterVertically
            ) {
                Button(
                    onClick = {
                        //save data to firebase

                        //add contact logic
                        val contact = Contact(
                            fname = firstName,
                            lname = lastName,
                            number = phoneNumber,
                            email = email
                        )

                        firebaseViewModel.addContact(contact)
                        if (state.addSuccess){
                            Toast.makeText(context, "Contact Added", Toast.LENGTH_SHORT).show()
                        }

                    },
                    modifier = Modifier.padding(10.dp),
                ) {
                    Text(text = "Save")
                }

                Icon(
                    imageVector = Icons.Default.MoreVert,
                    contentDescription = null,
                    modifier = Modifier.padding(end = 10.dp)
                )
            }

        }

    )


    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = "Account Info",
            modifier = Modifier
                .size(200.dp)
                .padding(top = 100.dp)
        )
        Text(text = "Add Photo")
        Spacer(modifier = Modifier.height(20.dp))
        Row (
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ){
            androidx.compose.material3.Icon(imageVector = Icons.Default.Person, contentDescription = "Null")
            Column {
                OutlinedTextField(
                    value = firstName,
                    onValueChange = { firstName = it },
                    label = {
                        Text(text = "First name")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 0.dp),

                    )

                //text field for last name
                OutlinedTextField(
                    value = lastName,
                    onValueChange = { lastName = it },
                    label = {
                        Text(text = "Last name")
                    },
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 10.dp, vertical = 0.dp),
                )

            }
        }

        //for phone number
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            androidx.compose.material3.Icon(imageVector = Icons.Default.Phone, contentDescription = "Phone Number")
            OutlinedTextField(
                value = phoneNumber,
                onValueChange = { phoneNumber = it },
                label = {
                    Text(text = "Phone number")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 0.dp),
                keyboardOptions = KeyboardOptions.Default.copy(
                    keyboardType = KeyboardType.Phone
                )
            )

        }

        //Mail address
        Row(
            modifier = Modifier
                .fillMaxWidth()
                .padding(horizontal = 10.dp, vertical = 0.dp),
            horizontalArrangement = Arrangement.SpaceBetween,
            verticalAlignment = Alignment.CenterVertically
        ) {
            androidx.compose.material3.Icon(imageVector = Icons.Default.Email, contentDescription = "Phone Number")
            OutlinedTextField(
                value = email,
                onValueChange = { email = it },
                label = {
                    Text(text = "Email")
                },
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 10.dp, vertical = 0.dp),

                )

        }




    }
}


@Preview(showSystemUi = true)
@Composable()
fun PreviewTopBar() {
    TopBarAddContactScreen()
}