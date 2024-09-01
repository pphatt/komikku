package eu.kanade.presentation.library.components

import androidx.compose.foundation.layout.Row
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.runtime.Immutable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextOverflow
import eu.kanade.ui.component.SearchToolBar

// LibraryToolBar contain not only the top-bar search tool bar,
// but also contain the select manga tool bar
@Composable
fun LibraryToolBar(
    title: LibraryToolbarTitle,

    searchQuery: String? = null,
    onSearchQueryChange: (String?) -> Unit,

    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    // this can be change into such as select manga
    LibraryDefaultToolBar(
        title = title,
        searchQuery = searchQuery,
        onSearchQueryChange = onSearchQueryChange,
        scrollBehavior = scrollBehavior,
    )
}

@Composable
private fun LibraryDefaultToolBar(
    title: LibraryToolbarTitle,

    searchQuery: String? = null,
    onSearchQueryChange: (String?) -> Unit,

    scrollBehavior: TopAppBarScrollBehavior?,
) {
    SearchToolBar(
        titleContent = {
            Row(verticalAlignment = Alignment.CenterVertically) {
                Text(
                    text = title.text,
                    maxLines = 1,
                    modifier = Modifier.weight(1f, false),
                    overflow = TextOverflow.Ellipsis,
                )
            }
        },
        searchQuery = searchQuery,
        onChangeSearchQuery = onSearchQueryChange,
        scrollBehavior = scrollBehavior,
    )
}

@Immutable
data class LibraryToolbarTitle(
    val text: String,
    val numberOfManga: Int? = null,
)
