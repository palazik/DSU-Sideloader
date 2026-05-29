package com.palaziks.sideloader.ui.components

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.runtime.Composable
import androidx.compose.ui.unit.dp

@Composable
fun DynamicListItem(
    listLength: Int,
    currentValue: Int,
    content: @Composable () -> Unit,
) {
    val shape = when (currentValue) {
        0 -> RoundedCornerShape(topStart = 18.dp, topEnd = 18.dp)
        listLength -> RoundedCornerShape(bottomEnd = 18.dp, bottomStart = 18.dp)
        else -> RoundedCornerShape(0.dp)
    }
    CardBox(
        addPadding = false,
        roundedCornerShape = shape,
    ) {
        content()
    }
}
