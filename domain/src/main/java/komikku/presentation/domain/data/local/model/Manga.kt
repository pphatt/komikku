package komikku.presentation.domain.data.local.model

data class Manga(
    val id: Long,
    val title: String,
    val source: Long,
    val favorite: Boolean,
    val thumbnailUrl: String,
)

data class MangaCover(
    val mangaId: Long,
    val sourceId: Long,
    val isMangaFavorite: Boolean,
    val url: String?,
    val lastModified: Long,
)

