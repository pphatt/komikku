package eu.kanade.presentation.browse

import androidx.compose.runtime.Composable
import eu.kanade.presentation.browse.components.BrowseScreen

@Composable
fun BrowseRoute() {
    BrowseScreen(
        searchQuery = null,
        onSearchQueryChange = {}
    )
}
