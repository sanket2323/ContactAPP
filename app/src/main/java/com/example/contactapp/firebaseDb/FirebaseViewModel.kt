package com.example.contactapp.firebaseDb

import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import com.example.contactapp.model.Contact
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow

class FirebaseViewModel(private val firebaseRepo: FirebaseRepo) : ViewModel() {
    private val _state = MutableStateFlow(FirebaseState())
    val state: StateFlow<FirebaseState> = _state

    suspend fun getContactList() {
        _state.value = _state.value.copy(isContactLoading = true)

        val contactList = firebaseRepo.getContactList()
        _state.value = _state.value.copy(contactList = contactList)
        _state.value = _state.value.copy(isContactLoading = false)
        if (contactList.isEmpty()) {
            _state.value = _state.value.copy(isContactError = "List Empty")
        } else {
            _state.value = _state.value.copy(isContactLoading = false)
        }
    }

    fun addContact(
        contact: Contact
    ) {
        val res = firebaseRepo.addContact(contact)
        val result = "success"
        println("result is $res")
        println("result is $result")
        if(res == "success"){
            _state.value = _state.value.copy(addSuccess = "success")
        }
    }


}