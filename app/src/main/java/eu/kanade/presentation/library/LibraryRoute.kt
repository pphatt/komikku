package eu.kanade.presentation.library

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.kanade.presentation.library.components.LibraryToolBar
import komikku.presentation.core.components.material.Scaffold

@Composable
fun LibraryRoute() {
    val screenModel = LibraryScreenModel()

    // we can make a custom scaffold
    Scaffold(
        topBar = { scrollBehavior ->
            // this can be improved by adding i18n
            val title = screenModel.getToolbarTitle("Library")

            LibraryToolBar(
                title = title,
                searchQuery = null,
                onSearchQueryChange = screenModel::search,
                scrollBehavior = scrollBehavior
            )
        }
    ) { paddingValues ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = paddingValues.calculateTopPadding(), bottom = 0.dp
                )
        ) {
            LazyColumn(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                items(51) {
                    Text(text = it.toString(), fontSize = 20.sp)
                }
            }
        }
    }
}
