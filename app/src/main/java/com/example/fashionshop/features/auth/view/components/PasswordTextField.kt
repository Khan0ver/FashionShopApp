package com.example.fashionshop.features.auth.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Visibility
import androidx.compose.material.icons.filled.VisibilityOff
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.fashionshop.R

@Composable
fun PasswordTextField(
    maxChar: Int = 48,
    value: MutableState<String>,
    placeholder: String = stringResource(R.string.password),
    topPadding: Dp = 12.dp,
    colors: TextFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = MaterialTheme.colorScheme.secondary,
        unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
        focusedIndicatorColor = MaterialTheme.colorScheme.onSecondary,
        unfocusedIndicatorColor = MaterialTheme.colorScheme.onSecondary,
    ),
    isSupportingText: Boolean = true
) {
    var passwordVisible by rememberSaveable { mutableStateOf(false) }

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = topPadding),
        value = value.value,
        onValueChange = { if (it.length <= maxChar) value.value = it },
        singleLine = true,
        colors = colors,
        placeholder = { Text(text = placeholder, color = Color.LightGray) },
        supportingText = {
            if (isSupportingText) {
                Text(
                    text = "${value.value.length} / $maxChar",
                    modifier = Modifier.fillMaxWidth(),
                    textAlign = TextAlign.End
                )
            }
        },
        textStyle = MaterialTheme.typography.bodyMedium,
        visualTransformation = if (passwordVisible) VisualTransformation.None else PasswordVisualTransformation(),
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Password),
        trailingIcon = {
            val image = if (passwordVisible) Icons.Filled.Visibility else Icons.Filled.VisibilityOff
            IconButton(onClick = { passwordVisible = !passwordVisible }) {
                Icon(imageVector = image, null)
            }
        }
    )
}