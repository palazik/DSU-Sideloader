package com.palaziks.sideloader.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.theme.MiuixTheme

@Composable
fun DialogItem(
    icon: ImageVector,
    title: String,
    text: String,
    textColor: Color = Color.Unspecified,
) {
    Row(verticalAlignment = Alignment.CenterVertically) {
        Icon(
            modifier = Modifier
                .size(32.dp)
                .padding(end = 6.dp),
            tint = MiuixTheme.colorScheme.onSurfaceVariantSummary,
            imageVector = icon,
            contentDescription = "Icon",
        )
        Column(Modifier.padding(4.dp)) {
            Text(
                text = title,
                fontSize = 12.sp,
                color = textColor,
            )
            Text(
                color = textColor,
                text = text,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
            )
        }
    }
}

