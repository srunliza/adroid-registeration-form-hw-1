package com.example.practice_register_form

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel

class FormViewModel : ViewModel() {
    val userData = mutableStateOf(FormData())
    val isFormValid: Boolean
        get() = userData.value.fullName.isNotEmpty() &&
                userData.value.gender.isNotEmpty() &&
                userData.value.phone.isNotEmpty() &&
                userData.value.address.isNotEmpty()



    fun updateFullName(input: String) {
        userData.value = userData.value.copy(
            fullName = input
        )
    }

    fun updateGender(input: String) {
        userData.value = userData.value.copy(
            gender = input
        )
    }

    fun updatePhone(input: String) {
        userData.value = userData.value.copy(
            phone = input
        )
    }

    fun updateAddress(input: String) {
        userData.value = userData.value.copy(
            address = input
        )
    }

}

