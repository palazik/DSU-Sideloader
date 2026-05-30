package com.palaziks.sideloader.ui.components

import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalFocusManager
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.palaziks.sideloader.ui.components.buttons.PrimaryButton
import com.palaziks.sideloader.ui.components.buttons.SecondaryButton
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.overlay.OverlayBottomSheet
import top.yukonga.miuix.kmp.theme.MiuixTheme

@OptIn(ExperimentalComposeUiApi::class)
@Composable
fun DialogLikeBottomSheet(
    modifier: Modifier = Modifier,
    icon: ImageVector,
    title: String = "",
    text: String = "",
    confirmText: String = "",
    cancelText: String = "",
    hideKeyboard: Boolean = true,
    onClickConfirm: () -> Unit = {},
    onClickCancel: () -> Unit = {},
    onDismiss: () -> Unit = onClickCancel,
    content: @Composable () -> Unit = {},
) {
    if (hideKeyboard) {
        LocalSoftwareKeyboardController.current?.hide()
        LocalFocusManager.current.clearFocus()
    }

    OverlayBottomSheet(
        show = true,
        title = title,
        onDismissRequest = onDismiss,
        modifier = modifier,
    ) {
        if (text.isNotEmpty()) {
            Text(
                modifier = Modifier.fillMaxWidth(),
                text = text,
                textAlign = TextAlign.Justify,
                color = MiuixTheme.colorScheme.onBackground,
            )
        }
        content()
        Row(modifier = Modifier.padding(top = 16.dp)) {
            Spacer(modifier = Modifier.weight(1F))
            SecondaryButton(text = cancelText, onClick = onClickCancel)
            Spacer(modifier = Modifier.padding(4.dp))
            PrimaryButton(text = confirmText, onClick = onClickConfirm)
        }
    }
}
