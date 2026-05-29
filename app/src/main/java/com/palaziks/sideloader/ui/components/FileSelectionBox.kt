package com.palaziks.sideloader.ui.components

import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import top.yukonga.miuix.kmp.basic.TextField

@Composable
fun FileSelectionBox(
    modifier: Modifier = Modifier,
    isReadOnly: Boolean = false,
    keyboardOptions: KeyboardOptions = KeyboardOptions(),
    isEnabled: Boolean,
    isError: Boolean,
    textFieldTitle: String,
    textFieldValue: String,
    textFieldInteraction: MutableInteractionSource = MutableInteractionSource(),
    onValueChange: (String) -> Unit = {},
) {
    TextField(
        modifier = modifier.fillMaxWidth(),
        value = textFieldValue,
        label = textFieldTitle,
        onValueChange = onValueChange,
        enabled = isEnabled,
        singleLine = true,
        readOnly = isReadOnly,
        keyboardOptions = keyboardOptions,
        interactionSource = textFieldInteraction,
    )
}
