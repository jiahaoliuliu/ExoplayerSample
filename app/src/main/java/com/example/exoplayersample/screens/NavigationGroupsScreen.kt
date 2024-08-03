package com.example.exoplayersample.screens

import android.content.Intent
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController

@ExperimentalFoundationApi
@Composable
fun NavigationGroupsScreen(
    modifier: Modifier = Modifier,
    navController: NavController
) {
    val context = LocalContext.current
    LazyColumn (modifier = modifier.fillMaxSize()) {
        navigationItemsList.forEach { navigationGroup ->
            stickyHeader {
                NavigationGroupHeaderView(category = navigationGroup.category)
            }
            items(navigationGroup.navigationItemsList) { navigationItem ->
                NavigationGroupItemView(navigationItem, openNativeScreen = { jClass ->
                    context.startActivity(Intent(context, jClass))
                }) { route ->
                    navController.navigate(route)
                }
            }
        }
    }
}

class NavigationGroupsScreenMetaData {
    companion object {
        const val SCREEN_NAME = "Navigation List"
    }
}

enum class Category {
    XML,
    Compose
}

sealed class NavigationItem(
    open val category: Category,
    open val name: String,
) {
    class NavigationItemCompose(
        override val category: Category,
        override val name: String,
        val route: String
    ) : NavigationItem(category, name)

    class NavigationItemNative(
        override val category: Category,
        override val name: String,
        val jClass: Class<*>
    ): NavigationItem(category, name)
}

data class NavigationGroup(
    val category: Category,
    val navigationItemsList: List<NavigationItem>
)

@Composable
private fun NavigationGroupHeaderView(
    category: Category,
    modifier: Modifier = Modifier
) {
    Text(
        text = category.name,
        fontSize = 16.sp,
        fontWeight = FontWeight.Bold,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.primaryContainer)
            .padding(16.dp)
    )
}

@Composable
private fun NavigationGroupItemView(
    navigationItem: NavigationItem,
    modifier: Modifier = Modifier,
    openNativeScreen: (Class<*>) -> Unit,
    openComposeScreen: (String) -> Unit
) {
    Text(
        text = navigationItem.name,
        fontSize = 14.sp,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .clickable {
                when(navigationItem) {
                    is NavigationItem.NavigationItemCompose -> openComposeScreen(navigationItem.route)
                    is NavigationItem.NavigationItemNative-> openNativeScreen(navigationItem.jClass)
                }
            }
    )
}

val navigationItemsList = listOf (
    NavigationItem.NavigationItemNative(Category.XML, "Single player screen",
        SinglePlayerActivity::class.java),
    NavigationItem.NavigationItemCompose(Category.Compose, "Single player on compose",
        SinglePlayerScreenMetaData.SCREEN_NAME),
).groupBy {
    it.category
}.map {
    NavigationGroup(
        category = it.key,
        navigationItemsList = it.value
    )
}