package eu.kanade.ui.navigation

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import eu.kanade.ui.theme.KomikkuTheme

@Composable
fun AppNavigation() {
    KomikkuTheme {
        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            NavigationActions(navController)
        }

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute =
            navBackStackEntry?.destination?.route ?: Tabs.LIBRARY_ROUTE

        print(navigationActions.navigateToBrowse)

        Scaffold(
            bottomBar = {
                AppBottomBar(
                    currentRoute = currentRoute,
                    navigateToLibrary = navigationActions.navigateToLibrary,
                    navigateToHistory = navigationActions.navigateToHistory,
                    navigateToBrowser = navigationActions.navigateToBrowse,
                )
            }
        ) { contentPadding ->
            Box(
                modifier = Modifier.padding(
                    bottom = contentPadding.calculateBottomPadding()
                )
            ) {
                NavigationGraph(navController = navController)
            }
        }
    }
}
