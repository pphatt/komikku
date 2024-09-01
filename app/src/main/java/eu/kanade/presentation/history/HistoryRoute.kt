package eu.kanade.presentation.history

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.sp
import eu.kanade.presentation.history.components.HistoryScreen

@Composable
fun HistoryRoute() {
    HistoryScreen(
        searchQuery = null,
        onSearchQueryChange = {}
    )
}
