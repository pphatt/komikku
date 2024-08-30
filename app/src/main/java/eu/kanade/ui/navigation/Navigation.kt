package eu.kanade.ui.navigation

import androidx.navigation.NavGraph.Companion.findStartDestination
import androidx.navigation.NavHostController

/**
 * Destinations used in the [AppNavigation].
 */
object Tabs {
    const val LIBRARY_ROUTE = "library"
    const val HISTORY_ROUTE = "history"
    const val BROWSE_ROUTE = "browse"
}

/**
 * Models the navigation actions in the app.
 */
class NavigationActions(navHostController: NavHostController) {
    val navigateToLibrary: () -> Unit = {
        navHostController.navigate(Tabs.LIBRARY_ROUTE) {
            // Pop up to the start destination of the graph to
            // avoid building up a large stack of destinations
            // on the back stack as users select items
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }

            // Avoid multiple copies of the same destination when
            // re-selecting the same item
            launchSingleTop = true

            // Restore state when re-selecting a previously selected item
            restoreState = true
        }
    }
    val navigateToHistory: () -> Unit = {
        navHostController.navigate(Tabs.HISTORY_ROUTE) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
    val navigateToBrowse: () -> Unit = {
        navHostController.navigate(Tabs.BROWSE_ROUTE) {
            popUpTo(navHostController.graph.findStartDestination().id) {
                saveState = true
            }
            launchSingleTop = true
            restoreState = true
        }
    }
}
