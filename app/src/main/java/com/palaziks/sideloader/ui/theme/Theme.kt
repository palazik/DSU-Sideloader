package com.palaziks.sideloader.ui.theme

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.runtime.remember
import androidx.compose.ui.platform.LocalView
import androidx.core.view.WindowCompat
import top.yukonga.miuix.kmp.theme.MiuixTheme
import top.yukonga.miuix.kmp.theme.ThemeController
import top.yukonga.miuix.kmp.utils.ColorSchemeMode

@Composable
fun DSUHelperTheme(
    content: @Composable () -> Unit,
) {
    val controller = remember { ThemeController(ColorSchemeMode.System) }

    val view = LocalView.current
    val isDark = controller.isDark
    if (!view.isInEditMode) {
        SideEffect {
            val window = (view.context as Activity).window
            WindowCompat.getInsetsController(window, view).isAppearanceLightStatusBars = !isDark
            WindowCompat.getInsetsController(window, view).isAppearanceLightNavigationBars = !isDark
        }
    }

    MiuixTheme(
        controller = controller,
        content = content,
    )
}
