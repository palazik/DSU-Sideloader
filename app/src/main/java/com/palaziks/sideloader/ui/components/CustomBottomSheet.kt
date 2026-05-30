package com.palaziks.sideloader.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import top.yukonga.miuix.kmp.window.WindowBottomSheet

@Composable
fun CustomBottomSheet(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    onDismiss: () -> Unit = {},
    content: @Composable ColumnScope.(hideSheet: suspend () -> Unit) -> Unit,
) {
    WindowBottomSheet(
        show = true,
        title = title,
        onDismissRequest = onDismiss,
        modifier = modifier,
    ) {
        Column {
            content { onDismiss() }
        }
    }
}
