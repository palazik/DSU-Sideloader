package com.palaziks.sideloader.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.palaziks.sideloader.ui.components.buttons.PrimaryButton
import com.palaziks.sideloader.ui.components.buttons.SecondaryButton
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.overlay.OverlayDialog
import top.yukonga.miuix.kmp.theme.MiuixTheme

@Composable
fun Dialog(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String = "",
    text: String = "",
    confirmText: String = "",
    cancelText: String = "",
    onClickConfirm: () -> Unit = {},
    onClickCancel: () -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    OverlayDialog(
        show = true,
        modifier = modifier,
        title = title,
        summary = text,
        onDismissRequest = onClickCancel,
    ) {
        content()
        Row(modifier = Modifier.fillMaxWidth().padding(top = 8.dp)) {
            if (cancelText.isNotEmpty()) {
                SecondaryButton(
                    text = cancelText,
                    onClick = onClickCancel,
                    modifier = Modifier.weight(1f),
                )
            }
            if (cancelText.isNotEmpty() && confirmText.isNotEmpty()) {
                Spacer(modifier = Modifier.width(12.dp))
            }
            if (confirmText.isNotEmpty()) {
                PrimaryButton(
                    text = confirmText,
                    onClick = onClickConfirm,
                    modifier = Modifier.weight(1f),
                )
            }
        }
    }
}
