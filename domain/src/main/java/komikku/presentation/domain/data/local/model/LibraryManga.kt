package komikku.presentation.domain.data.local.model

data class LibraryManga(
    val manga: Manga,
    val totalChapters: Long
) {
    val id: Long = manga.id
}
