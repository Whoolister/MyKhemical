package dev.whoolister.mykhemical

import androidx.compose.runtime.Composable
import dev.whoolister.mykhemical.i18n.LocaleProvider
import dev.whoolister.mykhemical.ui.screen.PeriodicTableScreen
import dev.whoolister.mykhemical.ui.theme.ThemeProvider
import org.jetbrains.compose.ui.tooling.preview.Preview

@Composable
@Preview
fun App() {
    ThemeProvider {
        LocaleProvider {
            PeriodicTableScreen()
        }
    }
}