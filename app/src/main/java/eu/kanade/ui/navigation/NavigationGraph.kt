package eu.kanade.ui.navigation

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import eu.kanade.presentation.browse.BrowseRoute
import eu.kanade.presentation.history.HistoryRoute
import eu.kanade.presentation.library.LibraryRoute

@Composable
fun NavigationGraph(
    modifier: Modifier = Modifier,
    navController: NavHostController = rememberNavController(),
    startDestination: String = Tabs.LIBRARY_ROUTE,
) {
    NavHost(
        navController = navController,
        startDestination = startDestination,
        modifier = modifier
    ) {
        composable(route = Tabs.LIBRARY_ROUTE) {
            LibraryRoute()
        }
        composable(route = Tabs.HISTORY_ROUTE) {
            HistoryRoute()
        }
        composable(route = Tabs.BROWSE_ROUTE) {
            BrowseRoute()
        }
    }
}
