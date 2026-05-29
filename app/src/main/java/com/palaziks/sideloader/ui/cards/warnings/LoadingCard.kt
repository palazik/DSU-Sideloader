package com.palaziks.sideloader.ui.cards.warnings
import top.yukonga.miuix.kmp.basic.LinearProgressIndicator

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.palaziks.sideloader.R
import com.palaziks.sideloader.ui.components.SimpleCard

@Composable
fun GrantingPermissionCard() {
    SimpleCard(
        modifier = Modifier.fillMaxWidth(),
        cardTitle = stringResource(id = R.string.missing_permission),
        text = stringResource(id = R.string.granting_permission),
    ) {
        LinearProgressIndicator(
            modifier = Modifier.fillMaxWidth()
                .padding(top = 10.dp, bottom = 10.dp),
        )
    }
}
