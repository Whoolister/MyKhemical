package dev.whoolister.mykhemical.ui.screen

import androidx.compose.foundation.layout.*
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import dev.whoolister.mykhemical.i18n.strings
import dev.whoolister.mykhemical.ui.component.PeriodicTableComponent
import dev.whoolister.mykhemical.ui.component.OptionsButton

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PeriodicTableScreen(
    modifier: Modifier = Modifier,
) {
    val strings = strings()

    Scaffold(
        modifier = modifier.fillMaxSize(),
        topBar = {
            CenterAlignedTopAppBar(
                title = {
                    Text(
                        text = strings.appName,
                        style = MaterialTheme.typography.titleLarge
                    )
                },
                actions = {
                    OptionsButton()
                },
                colors = TopAppBarDefaults.centerAlignedTopAppBarColors(
                    containerColor = MaterialTheme.colorScheme.surfaceVariant,
                    titleContentColor = MaterialTheme.colorScheme.primary
                )
            )
        }
    ) { paddingValues ->
        Surface(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues),
        ) {
            PeriodicTableComponent(
                modifier = Modifier.padding(8.dp)
            )
        }
    }
}