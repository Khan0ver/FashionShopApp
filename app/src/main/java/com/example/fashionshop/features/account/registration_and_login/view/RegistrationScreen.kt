package com.example.fashionshop.features.account.registration_and_login.view

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
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.example.fashionshop.R
import com.example.fashionshop.di.Paddings
import com.example.fashionshop.features.account.common.data.model.AuthState
import com.example.fashionshop.features.account.registration_and_login.domain.RegisterAndLoginViewModel
import com.example.fashionshop.features.account.common.view.components.CircularProgress
import com.example.fashionshop.features.account.common.view.components.DefaultCheckBox
import com.example.fashionshop.features.account.common.view.components.DefaultTextField
import com.example.fashionshop.features.account.common.view.components.EmailTextField
import com.example.fashionshop.features.account.common.view.components.PasswordTextField
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

@Composable
fun RegistrationScreen(navController: NavController) {
    val viewModel = hiltViewModel<RegisterAndLoginViewModel>()

    val authState = viewModel.authState.collectAsStateWithLifecycle()
    val currentUser = viewModel.currentUser.collectAsStateWithLifecycle()

    val nameValue = rememberSaveable { mutableStateOf("") }
    val surnameValue = rememberSaveable { mutableStateOf("") }
    val emailValue = rememberSaveable { mutableStateOf("") }
    val passwordValue = rememberSaveable { mutableStateOf("") }
    val checkedEmailNews = rememberSaveable { mutableStateOf(false) }
    val checkedAgreeTerms = rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(Paddings.innerPadding)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.SpaceBetween,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {

        Text(
            modifier = Modifier.clickable {
                Firebase.auth.signOut(); Log.i(
                "info",
                Firebase.auth.currentUser.toString()
            )
            },
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
                placeholder = stringResource(R.string.name),
            )

            DefaultTextField(
                value = surnameValue,
                placeholder = stringResource(R.string.surname),
            )

            EmailTextField(
                value = emailValue,
                placeholder = stringResource(R.string.email)
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
                            passwordValue.value,
                            nameValue.value,
                            surnameValue.value,
                        )
                    },
                    shape = RectangleShape,
                    //TODO validation of entered data
                    enabled = checkedAgreeTerms.value,
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

    if (currentUser.value != null) {
        navController.navigate("profile")
    }
}