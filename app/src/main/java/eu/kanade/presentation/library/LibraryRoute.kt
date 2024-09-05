package eu.kanade.presentation.library

import androidx.compose.runtime.Composable
import eu.kanade.presentation.library.components.LibraryContent
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
        LibraryContent(paddingValues)
    }
}
