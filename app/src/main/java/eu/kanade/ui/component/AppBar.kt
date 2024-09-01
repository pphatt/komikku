package eu.kanade.ui.component

import androidx.compose.foundation.layout.Column
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarScrollBehavior
import androidx.compose.material3.surfaceColorAtElevation
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.dp

@Composable
fun AppBar(
    // Title content
    titleContent: @Composable () -> Unit,

    // Config
    modifier: Modifier = Modifier,
    backgroundColor: Color? = null,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    Column(modifier = modifier) {
        TopAppBar(
            title = titleContent,
            colors = TopAppBarDefaults.topAppBarColors(
                containerColor = backgroundColor
                    ?: MaterialTheme.colorScheme.surfaceColorAtElevation(elevation = 0.dp),
            ),
            scrollBehavior = scrollBehavior
        )
    }
}

@Composable
fun AppBarTitle(
    title: String?,
    modifier: Modifier = Modifier
) {
    Column(modifier = modifier) {
        title?.let {
            Text(
                text = it,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        }
    }
}

@Composable
fun SearchToolBar(
    // Query
    searchQuery: String?,
    onChangeSearchQuery: (String?) -> Unit,

    // Ui
    titleContent: @Composable () -> Unit = {},

    //Config
    modifier: Modifier = Modifier,
    scrollBehavior: TopAppBarScrollBehavior? = null,
) {
    AppBar(
        titleContent = {
            /*
            * return@AppBar titleContent(): Returns from the lambda passed to AppBar without exiting the SearchToolBar function.
            * It’s like saying, "Execute titleContent() and finish this lambda block."
            * return titleContent(): Attempts to return from the entire SearchToolBar function, which is not intended in a @Composable context.
            * Using labeled returns like return@AppBar is helpful when working with nested lambdas or functions to control the flow explicitly
            * and avoid confusion about which scope you're exiting.
            * */
            if (searchQuery == null) return@AppBar titleContent()
        },
        modifier = modifier,
        scrollBehavior = scrollBehavior,
    )
}
