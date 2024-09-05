package eu.kanade.presentation.library.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import komikku.presentation.domain.data.local.model.LibraryItem
import androidx.compose.foundation.lazy.grid.items
import eu.kanade.presentation.library.MangaCompactGridItem
import komikku.presentation.domain.data.local.model.MangaCover

@Composable
internal fun LibraryCompactGrid(
    items: List<LibraryItem>,
    showTitle: Boolean,
    columns: Int,
    contentPadding: PaddingValues,
) {
    LazyLibraryGrid(
        modifier = Modifier.fillMaxSize(),
        columns = columns,
        contentPadding = contentPadding,
    ) {
        items(
            items = items,
            contentType = { "library_compact_grid_item" },
        ) { libraryItem ->
            val manga = libraryItem.libraryManga.manga

            MangaCompactGridItem(
                title = manga.title.takeIf { showTitle },
                coverData = MangaCover(
                    mangaId = manga.id,
                    sourceId = manga.source,
                    isMangaFavorite = manga.favorite,
                    url = manga.thumbnailUrl,
                    // temp
                    lastModified = 0,
                ),
            )
        }
    }
}
