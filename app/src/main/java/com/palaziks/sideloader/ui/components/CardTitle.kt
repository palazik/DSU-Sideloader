package com.palaziks.sideloader.ui.components

import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.rememberScrollState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import top.yukonga.miuix.kmp.basic.Text
import top.yukonga.miuix.kmp.theme.MiuixTheme

@Composable
fun CardTitle(modifier: Modifier = Modifier, cardTitle: String) {
    val scroll = rememberScrollState(0)
    Text(
        modifier = modifier.horizontalScroll(scroll),
        text = cardTitle,
        fontSize = 20.sp,
        maxLines = 1,
        style = MiuixTheme.textStyles.title2,
    )
}
