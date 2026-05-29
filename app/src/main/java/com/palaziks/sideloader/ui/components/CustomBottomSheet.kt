package com.palaziks.sideloader.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.WindowInsetsSides
import androidx.compose.foundation.layout.asPaddingValues
import androidx.compose.foundation.layout.only
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.systemBars
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.overlay.OverlayBottomSheet

@Composable
fun CustomBottomSheet(
    modifier: Modifier = Modifier,
    title: String,
    icon: ImageVector,
    onDismiss: () -> Unit = {},
    content: @Composable ColumnScope.(hideSheet: suspend () -> Unit) -> Unit,
) {
    OverlayBottomSheet(
        show = true,
        title = title,
        onDismissRequest = onDismiss,
    ) {
        val insets = WindowInsets
            .systemBars
            .only(WindowInsetsSides.Vertical)
            .asPaddingValues()
        Column(
            modifier = Modifier
                .align(Alignment.End)
                .padding(end = 18.dp, start = 18.dp, bottom = insets.calculateBottomPadding() + 14.dp, top = 14.dp),
        ) {
            content { onDismiss() }
        }
    }
}
