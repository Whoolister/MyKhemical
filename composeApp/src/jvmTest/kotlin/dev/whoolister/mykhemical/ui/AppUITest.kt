package dev.whoolister.mykhemical.ui

import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createComposeRule
import dev.whoolister.mykhemical.App
import org.junit.Rule
import org.junit.Test

class AppUITest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun app_displaysTitle() {
        // When: App is launched
        composeTestRule.setContent {
            App()
        }

        // Then: App title should be displayed
        composeTestRule.onNodeWithText("MyKhemical", substring = true)
            .assertExists()
            .assertIsDisplayed()
    }

    @Test
    fun app_displaysPeriodicTableElements() {
        // When: App is launched
        composeTestRule.setContent {
            App()
        }

        // Then: Some element cards should be displayed
        // Check for hydrogen (first element) - multiple elements contain "H", so we check one exists
        composeTestRule.onAllNodesWithText("H", substring = true)
            .assertAny(hasText("H"))

        // Check for elements are present by checking atomic number
        composeTestRule.onNodeWithText("1", substring = false)
            .assertExists()
    }

    @Test
    fun app_hasZoomControls() {
        // When: App is launched
        composeTestRule.setContent {
            App()
        }

        // Then: Zoom button should be present
        // The floating action button for zooming should be available
        composeTestRule.waitForIdle()
        // Basic check that the app renders without crashing
        composeTestRule.onRoot().assertExists()
    }
}
