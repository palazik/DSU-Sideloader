package com.palaziks.sideloader.ui.components

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import top.yukonga.miuix.kmp.basic.Icon
import top.yukonga.miuix.kmp.basic.IconButton
import top.yukonga.miuix.kmp.basic.MiuixScrollBehavior
import top.yukonga.miuix.kmp.basic.TopAppBar
import top.yukonga.miuix.kmp.icon.MiuixIcons
import top.yukonga.miuix.kmp.icon.icons.useful.Back

@Composable
fun TopBar(
    scrollBehavior: MiuixScrollBehavior? = null,
    barTitle: String,
    icon: ImageVector? = null,
    iconContentDescription: String? = "icon",
    onClickIcon: () -> Unit = {},
    onClickBackButton: (() -> Unit)? = null,
) {
    TopAppBar(
        title = barTitle,
        largeTitle = barTitle,
        navigationIcon = {
            if (onClickBackButton != null) {
                IconButton(onClick = onClickBackButton) {
                    Icon(
                        imageVector = MiuixIcons.Useful.Back,
                        contentDescription = "Back",
                    )
                }
            }
        },
        actions = {
            if (icon != null) {
                IconButton(onClick = onClickIcon) {
                    Icon(
                        imageVector = icon,
                        contentDescription = iconContentDescription,
                    )
                }
            }
        },
        scrollBehavior = scrollBehavior,
    )
}
