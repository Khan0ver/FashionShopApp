package com.example.fashionshop.features.account.common.view.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldColors
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.example.fashionshop.R

@Composable
fun EmailTextField(
    maxChar: Int = 120,
    value: MutableState<String>,
    placeholder: String = stringResource(R.string.email),
    topPadding: Dp = 12.dp,
    colors: TextFieldColors = TextFieldDefaults.colors(
        focusedContainerColor = MaterialTheme.colorScheme.secondary,
        unfocusedContainerColor = MaterialTheme.colorScheme.secondary,
        focusedIndicatorColor = MaterialTheme.colorScheme.onSecondary,
        unfocusedIndicatorColor = MaterialTheme.colorScheme.onSecondary,
    ),
    isSupportingText: Boolean = true
) {
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
        keyboardOptions = KeyboardOptions(keyboardType = KeyboardType.Email),
        textStyle = MaterialTheme.typography.bodyMedium,
    )
}