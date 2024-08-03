package com.example.exoplayersample

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.exoplayersample.ui.theme.ExoplayerSampleTheme

@ExperimentalFoundationApi
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ExoplayerSampleTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavigationList(
                        navigationGroupsList = navigationItemsList,
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@ExperimentalFoundationApi
@Composable
private fun NavigationList(
    navigationGroupsList: List<NavigationGroup>,
    modifier: Modifier = Modifier) {
    LazyColumn (modifier = modifier) {
        navigationGroupsList.forEach { navigationGroup ->
            stickyHeader {
                NavigationGroupHeaderView(category = navigationGroup.category)
            }
            items(navigationGroup.navigationItemsList) { navigationItem ->
                NavigationGroupItemView(navigationItem)
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
    val name: String
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
    modifier: Modifier = Modifier
) {
    Text(
        text = navigationItem.name,
        fontSize = 14.sp,
        modifier = modifier
            .fillMaxWidth()
            .background(MaterialTheme.colorScheme.background)
            .padding(16.dp)
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
    NavigationItem(Category.Compose, "Single player on compose"),
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