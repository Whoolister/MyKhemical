package dev.whoolister.mykhemical.ui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import dev.whoolister.mykhemical.i18n.LocaleProvider
import dev.whoolister.mykhemical.model.elements.Hydrogen
import dev.whoolister.mykhemical.model.elements.Oxygen
import dev.whoolister.mykhemical.model.elements.Carbon
import dev.whoolister.mykhemical.ui.component.ElementCard
import dev.whoolister.mykhemical.ui.component.ElementCardSize
import dev.whoolister.mykhemical.ui.theme.RetroTheme
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ElementCardUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun elementCard_displaysHydrogen() {
        // When: ElementCard is displayed with Hydrogen
        composeTestRule.setContent {
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
        composeTestRule.onNodeWithText("H").assertExists().assertIsDisplayed()

        // Then: Atomic number should be displayed
        composeTestRule.onNodeWithText("1").assertExists().assertIsDisplayed()
    }

    @Test
    fun elementCard_displaysOxygen() {
        // When: ElementCard is displayed with Oxygen
        composeTestRule.setContent {
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
        composeTestRule.onNodeWithText("O").assertExists().assertIsDisplayed()
        composeTestRule.onNodeWithText("8").assertExists().assertIsDisplayed()
    }

    @Test
    fun elementCard_isClickable() {
        // Given: A click handler
        var clicked = false

        // When: ElementCard is displayed with click handler
        composeTestRule.setContent {
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
        composeTestRule.onNodeWithText("C").performClick()

        composeTestRule.waitForIdle()

        // Then: Click handler should be invoked
        if (!clicked) throw AssertionError("Element card was not clicked")
    }
}
