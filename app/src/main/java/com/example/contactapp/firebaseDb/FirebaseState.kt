package com.example.contactapp.firebaseDb

import com.example.contactapp.model.Contact

data class FirebaseState(
    var isContactLoading : Boolean = true,
    val isContactError : String?= null,
    val contactList : List<Contact> = emptyList(),

    val addSuccess : Boolean = false,
    val addFailure : String? = null,

)
