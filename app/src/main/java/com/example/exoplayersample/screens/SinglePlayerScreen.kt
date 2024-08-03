package com.example.exoplayersample.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier

@Composable
fun SinglePlayerScreen() {
    Scaffold { innerPadding ->
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

