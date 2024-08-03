package com.example.exoplayersample.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.navigation.NavController

@ExperimentalMaterial3Api
@Composable
fun SinglePlayerScreen(modifier: Modifier = Modifier,
                       navController: NavController
                       ) {
    Scaffold ( modifier = modifier,
        topBar = {
            TopAppBar(
                title = { Text("Single player screen") },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color.Magenta),
                navigationIcon = {
                    IconButton(onClick = {
                        navController.popBackStack()
                    }) {
                        Icon(imageVector = Icons.AutoMirrored.Outlined.ArrowBack,
                            contentDescription = "Back icon")
                    }
                }
            )
        }

    ) { innerPadding ->
        Box(modifier = Modifier.padding(innerPadding)) {
            Text("Single player screen")
        }
    }
}

class SinglePlayerScreenMetaData {
    companion object {
        const val SCREEN_NAME = "SinglePlayerScreen"
    }
}

