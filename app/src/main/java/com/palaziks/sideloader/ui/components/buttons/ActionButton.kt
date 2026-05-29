package com.palaziks.sideloader.ui.components.buttons

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import top.yukonga.miuix.kmp.basic.Button
import top.yukonga.miuix.kmp.basic.ButtonDefaults
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.basic.TextButton

@Composable
fun ActionButton(
    modifier: Modifier = Modifier,
    text: String,
    onClick: () -> Unit,
    colorButton: Color? = null,
    colorText: Color? = null,
    textButton: Boolean = false,
    isEnabled: Boolean = true,
    content: @Composable () -> Unit = {},
) {
    if (textButton) {
        TextButton(
            text = text,
            onClick = onClick,
            modifier = modifier,
            enabled = isEnabled,
        )
    } else {
        Button(
            modifier = modifier,
            onClick = onClick,
            enabled = isEnabled,
            colors = if (colorButton != null) {
                ButtonDefaults.buttonColors(color = colorButton)
            } else {
                ButtonDefaults.buttonColorsPrimary()
            },
        ) {
            Text(text = text, color = colorText ?: Color.Unspecified)
            content()
        }
    }
}
