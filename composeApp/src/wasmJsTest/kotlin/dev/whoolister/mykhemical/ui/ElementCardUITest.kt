package dev.whoolister.mykhemical.ui

import androidx.compose.ui.test.*
import dev.whoolister.mykhemical.i18n.LocaleProvider
import dev.whoolister.mykhemical.model.elements.Hydrogen
import dev.whoolister.mykhemical.model.elements.Oxygen
import dev.whoolister.mykhemical.model.elements.Carbon
import dev.whoolister.mykhemical.ui.component.ElementCard
import dev.whoolister.mykhemical.ui.component.ElementCardSize
import dev.whoolister.mykhemical.ui.theme.RetroTheme
import kotlin.test.Test
import kotlin.test.assertTrue

@OptIn(ExperimentalTestApi::class)
class ElementCardUITest {

    @Test
    fun elementCard_displaysHydrogen() = runComposeUiTest {
        // When: ElementCard is displayed with Hydrogen
        setContent {
            RetroTheme {
                LocaleProvider {
                    ElementCard(
                        element = Hydrogen,
                        size = ElementCardSize.Medium
                    )
                }
            }
        }

        // Then: Element symbol should be displayed
        onNodeWithText("H").assertExists().assertIsDisplayed()

        // Then: Atomic number should be displayed
        onNodeWithText("1").assertExists().assertIsDisplayed()
    }

    @Test
    fun elementCard_displaysOxygen() = runComposeUiTest {
        // When: ElementCard is displayed with Oxygen
        setContent {
            RetroTheme {
                LocaleProvider {
                    ElementCard(
                        element = Oxygen,
                        size = ElementCardSize.Large
                    )
                }
            }
        }

        // Then: Element symbol and atomic number should be displayed
        onNodeWithText("O").assertExists().assertIsDisplayed()
        onNodeWithText("8").assertExists().assertIsDisplayed()
    }

    @Test
    fun elementCard_isClickable() = runComposeUiTest {
        // Given: A click handler
        var clicked = false

        // When: ElementCard is displayed with click handler
        setContent {
            RetroTheme {
                LocaleProvider {
                    ElementCard(
                        element = Carbon,
                        size = ElementCardSize.Medium,
                        onClick = { clicked = true }
                    )
                }
            }
        }

        // When: Card is clicked
        onNodeWithText("C").performClick()

        waitForIdle()

        // Then: Click handler should be invoked
        assertTrue(clicked, "Element card was not clicked")
    }
}
