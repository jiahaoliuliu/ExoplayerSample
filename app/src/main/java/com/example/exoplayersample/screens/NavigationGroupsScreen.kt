package com.example.exoplayersample.screens

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    LazyColumn (modifier = modifier) {
        navigationItemsList.forEach { navigationGroup ->
            stickyHeader {
                NavigationGroupHeaderView(category = navigationGroup.category)
            }
            items(navigationGroup.navigationItemsList) { navigationItem ->
                NavigationGroupItemView(navigationItem) { route ->
                    navController.navigate(route)
                }
            }
        }
    }
}

enum class Category {
    XML,
    Compose
}

data class NavigationItem(
    val category: Category,
    val name: String,
    val route: String = ""
)

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
    onClick: (String) -> Unit
) {
    Text(
        text = navigationItem.name,
        fontSize = 14.sp,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
            .clickable { onClick(navigationItem.route) }
    )
}

val navigationItemsList = listOf (
    NavigationItem(Category.XML, "Player on native XML surface"),
    NavigationItem(Category.XML, "Player on native XML surface2"),
    NavigationItem(Category.XML, "Player on native XML surface3"),
    NavigationItem(Category.XML, "Player on native XML surface4"),
    NavigationItem(Category.XML, "Player on native XML surface4"),
    NavigationItem(Category.XML, "Player on native XML surface4"),
    NavigationItem(Category.XML, "Player on native XML surface4"),
    NavigationItem(Category.XML, "Player on native XML surface4"),
    NavigationItem(Category.XML, "Player on native XML surface4"),
    NavigationItem(Category.XML, "Player on native XML surface4"),
    NavigationItem(Category.XML, "Player on native XML surface4"),
    NavigationItem(Category.XML, "Player on native XML surface4"),
    NavigationItem(Category.XML, "Player on native XML surface4"),
    NavigationItem(Category.XML, "Player on native XML surface4"),
    NavigationItem(Category.Compose, "Single player on compose", SinglePlayerScreenMetaData.SCREEN_NAME),
    NavigationItem(Category.Compose, "Playlist on compose"),
    NavigationItem(Category.Compose, "Playlist with vertical view pager"),
    NavigationItem(Category.Compose, "Playlist with vertical view pager"),
    NavigationItem(Category.Compose, "Playlist with vertical view pager"),
    NavigationItem(Category.Compose, "Playlist with vertical view pager"),
    NavigationItem(Category.Compose, "Playlist with vertical view pager"),
    NavigationItem(Category.Compose, "Playlist with vertical view pager"),
    NavigationItem(Category.Compose, "Playlist with vertical view pager"),
    NavigationItem(Category.Compose, "Playlist with vertical view pager"),
    NavigationItem(Category.Compose, "Playlist with vertical view pager"),
    NavigationItem(Category.Compose, "Playlist with vertical view pager"),
    NavigationItem(Category.Compose, "Playlist with vertical view pager"),
    NavigationItem(Category.Compose, "Playlist with vertical view pager"),
    NavigationItem(Category.Compose, "Playlist with vertical view pager"),
    NavigationItem(Category.Compose, "Playlist with vertical view pager")
).groupBy {
    it.category
}.map {
    NavigationGroup(
        category = it.key,
        navigationItemsList = it.value
    )
}