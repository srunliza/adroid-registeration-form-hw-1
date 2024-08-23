package com.example.practice_register_form

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.practice_register_form.ui.theme.PracticeregisterformTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            PracticeregisterformTheme {
                val userDataFormInput: FormViewModel = viewModel()
                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(20.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        horizontalArrangement = Arrangement.SpaceBetween,
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        Text(
                            text = "Registration Form",
                            fontWeight = FontWeight.Bold,
                            fontSize = 24.sp,
                            modifier = Modifier.padding(bottom = 16.dp)
                        )
                        Icon(imageVector = Icons.Default.AccountCircle, contentDescription = null)
                    }
                    InputFieldComponent(
                        placeholder = "Enter your full name",
                        label = "Full name",
                        onTextChange = { userDataFormInput.updateFullName(it) },
                        event = "fullName",
                        userDataFormInput,
                    )
                    Row(
                        modifier = Modifier.fillMaxWidth()
                    ) {
                        InputFieldComponent(
                            placeholder = "gender",
                            label = "Gender",
                            onTextChange = { userDataFormInput.updateGender(it) },
                            event = "gender",
                            userDataFormInput,
                            modifier = Modifier
                                .weight(0.3f)
                                .padding(end = 8.dp)
                        )
                        InputFieldComponent(
                            placeholder = "Enter your phone",
                            label = "Phone",
                            onTextChange = { userDataFormInput.updatePhone(it) },
                            event = "phone",
                            userDataFormInput,
                            modifier = Modifier
                                .weight(0.7f)
                                .padding(start = 8.dp),
                            keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Number)
                        )
                    }
                    InputFieldComponent(
                        placeholder = "Enter your address",
                        label = "Address",
                        onTextChange = { userDataFormInput.updateAddress(it) },
                        event = "address",
                        vm = userDataFormInput,
                    )

                    Button(
                        onClick = { /*TODO*/ },
                        enabled = userDataFormInput.isFormValid,
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 16.dp),
                        shape = RoundedCornerShape(18.dp),
                    ) {
                        Text(text = "Register", color = Color.White)
                    }
                }
            }
        }
    }
}


@Composable
fun InputFieldComponent(
    placeholder: String,
    label: String,
    onTextChange: (newText: String) -> Unit,
    event: String,
    vm: FormViewModel,
    modifier: Modifier = Modifier,
    keyboardOptions: KeyboardOptions = KeyboardOptions.Default
) {
    OutlinedTextField(
        value = when (event) {
            "fullName" -> vm.userData.value.fullName
            "gender" -> vm.userData.value.gender
            "phone" -> vm.userData.value.phone
            else -> vm.userData.value.address
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(bottom = 8.dp),
        onValueChange = {
            onTextChange(it)
        },
        placeholder = { Text(text = placeholder) },
        label = { Text(text = label) },
        keyboardOptions = keyboardOptions
    )
}


