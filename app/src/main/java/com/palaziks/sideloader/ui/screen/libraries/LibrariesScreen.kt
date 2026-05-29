package com.palaziks.sideloader.ui.screen.libraries

import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.mikepenz.aboutlibraries.Libs
import com.mikepenz.aboutlibraries.util.withContext
import com.palaziks.sideloader.R
import com.palaziks.sideloader.ui.components.ApplicationScreen
import com.palaziks.sideloader.ui.components.DynamicListItem
import com.palaziks.sideloader.ui.components.PreferenceItem
import com.palaziks.sideloader.ui.components.TopBar
import com.palaziks.sideloader.ui.screen.Destinations

@Composable
fun LibrariesScreen(
    navigate: (String) -> Unit,
) {
    val libs = remember { mutableStateOf<Libs?>(null) }
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current
    libs.value = Libs.Builder().withContext(context).build()
    val libraries = libs.value!!.libraries

    ApplicationScreen(
        enableDefaultScrollBehavior = false,
        columnContent = false,
        modifier = Modifier.padding(start = 10.dp, end = 10.dp),
        topBar = { scrollBehavior ->
            TopBar(
                barTitle = stringResource(id = R.string.libraries_title),
                scrollBehavior = scrollBehavior,
                onClickBackButton = { navigate(Destinations.Up) },
            )
        },
    ) {
        LazyColumn(modifier = Modifier.fillMaxSize()) {
            items(libraries.size) {
                val thisLibrary = libraries[it]
                val name = thisLibrary.name
                var licenses = ""
                for (license in thisLibrary.licenses) {
                    licenses += license.name
                }
                val urlToOpen = thisLibrary.website ?: ""
                DynamicListItem(listLength = libraries.size - 1, currentValue = it) {
                    PreferenceItem(
                        title = name,
                        description = licenses,
                        onClick = {
                            if (urlToOpen.isNotEmpty()) {
                                uriHandler.openUri(urlToOpen)
                            }
                        },
                    )
                }
            }
            item { Spacer(modifier = Modifier.padding(26.dp)) }
        }
    }
}
