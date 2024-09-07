package eu.kanade.ui.main

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.consumeWindowInsets
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import eu.kanade.ui.navigation.AppBottomBar
import eu.kanade.ui.navigation.NavigationActions
import eu.kanade.ui.navigation.NavigationGraph
import eu.kanade.ui.navigation.Tabs
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun MainActivityScreen(
    viewModel: MainActivityScreenViewModel = viewModel()
) {
    Surface(modifier = Modifier.fillMaxSize()) {
        val state by viewModel.uiState.collectAsState()

        val navController = rememberNavController()
        val navigationActions = remember(navController) {
            NavigationActions(navController)
        }

        val navBackStackEntry by navController.currentBackStackEntryAsState()
        val currentRoute =
            navBackStackEntry?.destination?.route ?: Tabs.LIBRARY_ROUTE

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
            if (state.isInitialized) {
                Box(
                    modifier = Modifier
                        .padding(contentPadding)
                        .consumeWindowInsets(contentPadding),
                ) {
                    NavigationGraph(navController = navController)
                }
            }
        }
    }
}
