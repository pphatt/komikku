package eu.kanade.presentation.library.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import komikku.presentation.domain.data.manga.impl.libraryItem

@Composable
fun LibraryPager(
    state: PagerState,
    contentPadding: PaddingValues,
) {
    HorizontalPager(
        modifier = Modifier.fillMaxSize(),
        state = state,
        verticalAlignment = Alignment.Top,
    ) { page ->
        if (page !in ((state.currentPage - 1)..(state.currentPage + 1))) {
            // To make sure only one offscreen page is being composed
            return@HorizontalPager
        }

        val columns by remember { mutableIntStateOf(0) }

        LibraryCompactGrid(
            items = libraryItem,
            showTitle = true,
            columns = columns,
            contentPadding = contentPadding
        )
    }
}
