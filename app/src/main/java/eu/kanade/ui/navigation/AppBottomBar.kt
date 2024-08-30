package eu.kanade.ui.navigation

import android.util.TypedValue
import androidx.compose.animation.graphics.res.animatedVectorResource
import androidx.compose.animation.graphics.res.rememberAnimatedVectorPainter
import androidx.compose.animation.graphics.vector.AnimatedImageVector
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.unit.em
import androidx.compose.ui.unit.sp
import eu.kanade.R

@Composable
fun AppBottomBar(
    currentRoute: String,
    navigateToLibrary: () -> Unit,
    navigateToHistory: () -> Unit,
    navigateToBrowser: () -> Unit,
    modifier: Modifier = Modifier
) {
    NavigationBar(modifier = modifier) {
        NavigationBarItem(
            label = { Text("Library", fontSize = 15.sp) },
            icon = {
                val image =
                    AnimatedImageVector.animatedVectorResource(R.drawable.anim_library_enter)

                Icon(
                    painter = rememberAnimatedVectorPainter(
                        animatedImageVector = image, atEnd = currentRoute == Tabs.LIBRARY_ROUTE
                    ), null
                )
            },
            selected = currentRoute == Tabs.LIBRARY_ROUTE,
            onClick = { navigateToLibrary() }
        )
        NavigationBarItem(
            label = { Text("History", fontSize = 15.sp) },
            icon = {
                val image =
                    AnimatedImageVector.animatedVectorResource(R.drawable.anim_history_enter)
                Icon(
                    painter = rememberAnimatedVectorPainter(
                        animatedImageVector = image, atEnd = currentRoute == Tabs.HISTORY_ROUTE
                    ), null
                )

            },
            selected = currentRoute == Tabs.HISTORY_ROUTE,
            onClick = { navigateToHistory() }
        )
        NavigationBarItem(
            label = { Text("Browse", fontSize = 14.sp) },
            icon = {
                val image =
                    AnimatedImageVector.animatedVectorResource(R.drawable.anim_browse_enter)
                Icon(
                    painter = rememberAnimatedVectorPainter(
                        animatedImageVector = image, atEnd = currentRoute == Tabs.BROWSE_ROUTE
                    ), null
                )
            },
            selected = currentRoute == Tabs.BROWSE_ROUTE,
            onClick = { navigateToBrowser() }
        )
    }
}
