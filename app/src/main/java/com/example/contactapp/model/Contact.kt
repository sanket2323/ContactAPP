package com.example.contactapp.model

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import kotlinx.serialization.Serializable


@Parcelize
data class Contact(
    var number: String,
    var fname:String,
    var lname:String,
    var email:String
) : Parcelable
