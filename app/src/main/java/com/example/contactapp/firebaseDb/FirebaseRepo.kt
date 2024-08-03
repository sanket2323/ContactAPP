package com.example.contactapp.firebaseDb

import android.widget.Toast
import androidx.compose.ui.platform.LocalContext
import com.example.contactapp.model.Contact
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.Query
import kotlinx.coroutines.tasks.await

class FirebaseRepo {
    val db = FirebaseFirestore.getInstance()


    suspend fun getContactList():ArrayList<Contact> {
        val data = ArrayList<Contact>()
        val docs = db.collection("contacts").orderBy("fname", Query.Direction.ASCENDING).get().await()

        for (doc in docs){
            data.add(
                Contact(
                    doc.data["number"].toString(),
                    doc.data["fname"].toString(),
                    doc.data["lname"].toString(),
                    doc.data["email"].toString()
                )
            )
        }
        return data
    }

    fun addContact(contact: Contact):String {

        var result =""
        if (contact.number.isNotEmpty() && contact.fname.isNotEmpty()) {
            val data = hashMapOf(
                "number" to contact.number,
                "fname" to contact.fname,
                "lname" to contact.lname,
                "email" to contact.email
            )
            db.collection("contacts").add(data).addOnSuccessListener {
                result = "success"
            }.addOnFailureListener {
                result = "failure"
            }
        }
        return result
    }

    fun deleteContact(){

    }
}