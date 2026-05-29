package com.palaziks.sideloader.ui.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import top.yukonga.miuix.kmp.basic.MiuixScrollBehavior
import top.yukonga.miuix.kmp.basic.Scaffold
import top.yukonga.miuix.kmp.basic.Surface
import top.yukonga.miuix.kmp.basic.rememberTopAppBarState

@Composable
fun ApplicationScreen(
    modifier: Modifier = Modifier,
    verticalArrangement: Arrangement.HorizontalOrVertical = Arrangement.spacedBy(0.dp),
    columnContent: Boolean = true,
    enableDefaultScrollBehavior: Boolean = true,
    topBar: @Composable (MiuixScrollBehavior) -> Unit = {},
    bottomBar: @Composable () -> Unit = {},
    outsideContent: @Composable (PaddingValues) -> Unit = {},
    content: @Composable () -> Unit = {},
) {
    val scrollBehavior = MiuixScrollBehavior(rememberTopAppBarState())

    val scrollBehaviorModifier = Modifier.fillMaxSize()

    Surface {
        Scaffold(
            modifier = scrollBehaviorModifier,
            topBar = { topBar(scrollBehavior) },
            bottomBar = { bottomBar() },
            content = { innerPadding ->
                val scrollModifier =
                    if (enableDefaultScrollBehavior) Modifier.verticalScroll(rememberScrollState()) else Modifier
                if (columnContent) {
                    Column(
                        modifier = modifier
                            .padding(top = innerPadding.calculateTopPadding())
                            .then(scrollModifier),
                        verticalArrangement = verticalArrangement,
                    ) {
                        content()
                        Spacer(modifier = Modifier.padding(innerPadding.calculateBottomPadding()))
                    }
                } else {
                    Surface(modifier = modifier.padding(top = innerPadding.calculateTopPadding())) {
                        content()
                        Spacer(modifier = Modifier.padding(innerPadding.calculateBottomPadding()))
                    }
                }
            },
        )
    }

    outsideContent(PaddingValues())
}
