package eu.kanade.presentation.history.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import eu.kanade.presentation.library.components.LibraryToolbarTitle
import eu.kanade.ui.component.AppBarTitle
import eu.kanade.ui.component.SearchToolBar

// History screen is just like library tool bar but it just has one function is the search tool bar
@Composable
fun HistoryScreen(
    searchQuery: String? = null,
    onSearchQueryChange: (String?) -> Unit,

    scrollBehavior: TopAppBarScrollBehavior? = null
) {
    Scaffold(
        topBar = {
            SearchToolBar(
                titleContent = { AppBarTitle(title = "History") },
                searchQuery = searchQuery,
                onChangeSearchQuery = onSearchQueryChange,
                scrollBehavior = scrollBehavior
            )
        }
    ) { contentPadding ->
        Box(
            modifier = Modifier
                .fillMaxSize()
                .padding(
                    top = contentPadding.calculateTopPadding(),
                    bottom = 0.dp
                )
        ) {
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .align(Alignment.Center),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text("History Screen", fontSize = 20.sp)
            }
        }
    }
}
