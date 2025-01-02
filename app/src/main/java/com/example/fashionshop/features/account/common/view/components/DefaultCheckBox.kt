package com.example.fashionshop.features.account.common.view.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Checkbox
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableState
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun DefaultCheckBox(
    checkedMutableState: MutableState<Boolean>,
    text: String,
) {
    Row(
        modifier = Modifier
            .fillMaxWidth(0.8f)
            .wrapContentHeight(),
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {
        Checkbox(
            checked = checkedMutableState.value,
            onCheckedChange = { checkedMutableState.value = it }
        )
        Text(
            modifier = Modifier.clickable {
                checkedMutableState.value = !checkedMutableState.value
            },
            text = text,
            style = MaterialTheme.typography.bodyMedium
        )
    }
}