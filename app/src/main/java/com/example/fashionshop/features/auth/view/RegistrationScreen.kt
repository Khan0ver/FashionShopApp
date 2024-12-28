package com.example.fashionshop.features.auth.view

import android.util.Log
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.example.fashionshop.R
import com.example.fashionshop.features.auth.data.model.AuthState
import com.example.fashionshop.features.auth.domain.RegistrationViewModel
import com.example.fashionshop.features.auth.view.components.CircularProgress
import com.example.fashionshop.features.auth.view.components.DefaultCheckBox
import com.example.fashionshop.features.auth.view.components.DefaultTextField
import com.example.fashionshop.features.auth.view.components.EmailTextField
import com.example.fashionshop.features.auth.view.components.PasswordTextField
import com.example.fashionshop.ui.components.BackArrowTopBar
import com.example.fashionshop.ui.components.DefaultBottomAppBar
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun RegistrationScreen() {
    val viewModel = hiltViewModel<RegistrationViewModel>()

    val authState = viewModel.authState.observeAsState()

    val nameValue = rememberSaveable { mutableStateOf("") }
    val surnameValue = rememberSaveable { mutableStateOf("") }
    val emailValue = rememberSaveable { mutableStateOf("") }
    val passwordValue = rememberSaveable { mutableStateOf("") }
    val checkedEmailNews = rememberSaveable { mutableStateOf(false) }
    val checkedAgreeTerms = rememberSaveable { mutableStateOf(false) }

    Scaffold(
        topBar = {
            BackArrowTopBar()
        },

        bottomBar = {
            DefaultBottomAppBar()
        }
    ) { innerPadding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
                .verticalScroll(rememberScrollState()),
            verticalArrangement = Arrangement.SpaceBetween,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {
            Text(
                modifier = Modifier.clickable { Firebase.auth.signOut(); Log.i("info", Firebase.auth.currentUser.toString()) },
                text = stringResource(R.string.personal_information),
                style = MaterialTheme.typography.titleLarge,
            )

            if (authState.value == AuthState.Loading) CircularProgress()

            Column(
                modifier = Modifier
                    .fillMaxWidth(0.9f)
                    .fillMaxHeight(0.9f)
                    .padding(bottom = 36.dp),
                horizontalAlignment = Alignment.Start
            ) {

                DefaultTextField(
                    value = nameValue,
                    placeholder = stringResource(R.string.name)
                )
                DefaultTextField(
                    value = surnameValue,
                    placeholder = stringResource(R.string.surname)
                )
                EmailTextField(
                    value = emailValue,
                )
                PasswordTextField(
                    value = passwordValue,
                )

                DefaultCheckBox(
                    checkedMutableState = checkedEmailNews,
                    text = stringResource(R.string.email_agreement)
                )
                DefaultCheckBox(
                    checkedMutableState = checkedAgreeTerms,
                    text = stringResource(R.string.agree_with_terms)
                )

                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .align(Alignment.CenterHorizontally)
                ) {
                    Button(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(24.dp),
                        onClick = {
                            viewModel.signUpWithEmailAndPassword(
                                emailValue.value,
                                passwordValue.value
                            )
                        },
                        shape = RectangleShape,
                    ) {
                        Text(
                            text = stringResource(R.string.create_account),
                            color = MaterialTheme.colorScheme.secondary,
                            style = MaterialTheme.typography.titleMedium
                        )
                    }
                }
            }
        }
    }
}

