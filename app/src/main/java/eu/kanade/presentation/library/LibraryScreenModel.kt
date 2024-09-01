package eu.kanade.presentation.library

import androidx.compose.runtime.Immutable
import eu.kanade.presentation.library.components.LibraryToolbarTitle

class LibraryScreenModel {
    fun search(query: String? = null) {
        // temporary do nothing
    }

    fun getToolbarTitle(
        defaultTitle: String,
        defaultCategoryTitle: String? = null,
        page: Int? = 0,
    ): LibraryToolbarTitle {
        // defaultCategoryTitle, page temporary null
        val title = defaultTitle
        return LibraryToolbarTitle(title, page)
    }
}