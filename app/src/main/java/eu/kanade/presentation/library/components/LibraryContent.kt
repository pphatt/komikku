package eu.kanade.presentation.library.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.calculateEndPadding
import androidx.compose.foundation.layout.calculateStartPadding
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalLayoutDirection
import komikku.presentation.core.components.material.PullRefresh

@Composable
fun LibraryContent(
    contentPadding: PaddingValues,
) {
    Column(
        modifier = Modifier.padding(
            top = contentPadding.calculateTopPadding(),
            start = contentPadding.calculateStartPadding(LocalLayoutDirection.current),
            end = contentPadding.calculateEndPadding(LocalLayoutDirection.current)
        )
    ) {
        val coercedCurrentPage = remember { 100.coerceAtMost(100) }
        val pagerState = rememberPagerState(coercedCurrentPage) { 100 }

        val scope = rememberCoroutineScope()

        PullRefresh(refreshing = false, enabled = true, onRefresh = { /*TODO*/ }) {
            LibraryPager(
                state = pagerState,
                contentPadding = PaddingValues(bottom = contentPadding.calculateBottomPadding())
            )
        }
    }
}
