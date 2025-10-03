package dev.whoolister.mykhemical.i18n

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class StringResourcesTest {

    @Test
    fun testAppNameExistsForBothLocales() {
        // Test that app name exists for all locales
        assertNotNull(EnglishStrings.appName)
        assertNotNull(SpanishStrings.appName)
    }

    @Test
    fun testAppNameValues() {
        // Test that app name has expected values
        assertEquals("MyKhemical", EnglishStrings.appName)
        assertEquals("MyKhemical", SpanishStrings.appName)
    }

    @Test
    fun testElementCategoriesTranslations() {
        // Test element categories translations exist
        assertNotNull(EnglishStrings.elementCategories)
        assertNotNull(SpanishStrings.elementCategories)

        assertEquals("Element Categories", EnglishStrings.elementCategories)
        assertEquals("Categorías de Elementos", SpanishStrings.elementCategories)
    }

    @Test
    fun testAlkaliMetalsTranslations() {
        assertNotNull(EnglishStrings.alkaliMetals)
        assertNotNull(SpanishStrings.alkaliMetals)

        assertEquals("Alkali Metals", EnglishStrings.alkaliMetals)
        assertEquals("Metales Alcalinos", SpanishStrings.alkaliMetals)
    }

    @Test
    fun testAlkalineEarthMetalsTranslations() {
        assertNotNull(EnglishStrings.alkalineEarthMetals)
        assertNotNull(SpanishStrings.alkalineEarthMetals)

        assertEquals("Alkaline Earth Metals", EnglishStrings.alkalineEarthMetals)
        assertEquals("Metales Alcalinotérreos", SpanishStrings.alkalineEarthMetals)
    }

    @Test
    fun testTransitionMetalsTranslations() {
        assertNotNull(EnglishStrings.transitionMetals)
        assertNotNull(SpanishStrings.transitionMetals)

        assertEquals("Transition Metals", EnglishStrings.transitionMetals)
        assertEquals("Metales de Transición", SpanishStrings.transitionMetals)
    }

    @Test
    fun testNonMetalsTranslations() {
        assertNotNull(EnglishStrings.nonMetals)
        assertNotNull(SpanishStrings.nonMetals)

        assertEquals("Non-Metals", EnglishStrings.nonMetals)
        assertEquals("No Metales", SpanishStrings.nonMetals)
    }

    @Test
    fun testNobleGasesTranslations() {
        assertNotNull(EnglishStrings.nobleGases)
        assertNotNull(SpanishStrings.nobleGases)

        assertEquals("Noble Gases", EnglishStrings.nobleGases)
        assertEquals("Gases Nobles", SpanishStrings.nobleGases)
    }

    @Test
    fun testHalogensTranslations() {
        assertNotNull(EnglishStrings.halogens)
        assertNotNull(SpanishStrings.halogens)

        assertEquals("Halogens", EnglishStrings.halogens)
        assertEquals("Halógenos", SpanishStrings.halogens)
    }

    @Test
    fun testLanthanidesTranslations() {
        assertNotNull(EnglishStrings.lanthanides)
        assertNotNull(SpanishStrings.lanthanides)

        assertEquals("Lanthanides", EnglishStrings.lanthanides)
        assertEquals("Lantánidos", SpanishStrings.lanthanides)
    }

    @Test
    fun testActinidesTranslations() {
        assertNotNull(EnglishStrings.actinides)
        assertNotNull(SpanishStrings.actinides)

        assertEquals("Actinides", EnglishStrings.actinides)
        assertEquals("Actínidos", SpanishStrings.actinides)
    }

    @Test
    fun testElementDetailDialogStrings() {
        // Test element detail dialog strings
        assertNotNull(EnglishStrings.elementDetails)
        assertNotNull(SpanishStrings.elementDetails)

        assertNotNull(EnglishStrings.atomicNumber)
        assertNotNull(SpanishStrings.atomicNumber)

        assertNotNull(EnglishStrings.symbol)
        assertNotNull(SpanishStrings.symbol)

        assertNotNull(EnglishStrings.elementName)
        assertNotNull(SpanishStrings.elementName)

        assertNotNull(EnglishStrings.molarWeight)
        assertNotNull(SpanishStrings.molarWeight)

        assertNotNull(EnglishStrings.period)
        assertNotNull(SpanishStrings.period)

        assertNotNull(EnglishStrings.group)
        assertNotNull(SpanishStrings.group)

        assertNotNull(EnglishStrings.category)
        assertNotNull(SpanishStrings.category)
    }

    @Test
    fun testDialogStringsTranslations() {
        assertEquals("Element Details", EnglishStrings.elementDetails)
        assertEquals("Detalles del Elemento", SpanishStrings.elementDetails)

        assertEquals("Atomic Number", EnglishStrings.atomicNumber)
        assertEquals("Número Atómico", SpanishStrings.atomicNumber)

        assertEquals("Symbol", EnglishStrings.symbol)
        assertEquals("Símbolo", SpanishStrings.symbol)

        assertEquals("Close", EnglishStrings.close)
        assertEquals("Cerrar", SpanishStrings.close)
    }

    @Test
    fun testAllStringResourcesAreNotEmpty() {
        // Test that all string resources are not empty for both locales
        assertTrue(EnglishStrings.appName.isNotEmpty())
        assertTrue(EnglishStrings.elementCategories.isNotEmpty())
        assertTrue(EnglishStrings.alkaliMetals.isNotEmpty())
        assertTrue(EnglishStrings.alkalineEarthMetals.isNotEmpty())
        assertTrue(EnglishStrings.transitionMetals.isNotEmpty())
        assertTrue(EnglishStrings.postTransitionMetals.isNotEmpty())
        assertTrue(EnglishStrings.metalloids.isNotEmpty())
        assertTrue(EnglishStrings.nonMetals.isNotEmpty())
        assertTrue(EnglishStrings.halogens.isNotEmpty())
        assertTrue(EnglishStrings.nobleGases.isNotEmpty())
        assertTrue(EnglishStrings.lanthanides.isNotEmpty())
        assertTrue(EnglishStrings.actinides.isNotEmpty())
        assertTrue(EnglishStrings.elementDetails.isNotEmpty())
        assertTrue(EnglishStrings.atomicNumber.isNotEmpty())
        assertTrue(EnglishStrings.symbol.isNotEmpty())
        assertTrue(EnglishStrings.elementName.isNotEmpty())
        assertTrue(EnglishStrings.molarWeight.isNotEmpty())
        assertTrue(EnglishStrings.period.isNotEmpty())
        assertTrue(EnglishStrings.group.isNotEmpty())
        assertTrue(EnglishStrings.category.isNotEmpty())
        assertTrue(EnglishStrings.close.isNotEmpty())

        assertTrue(SpanishStrings.appName.isNotEmpty())
        assertTrue(SpanishStrings.elementCategories.isNotEmpty())
        assertTrue(SpanishStrings.alkaliMetals.isNotEmpty())
        assertTrue(SpanishStrings.alkalineEarthMetals.isNotEmpty())
        assertTrue(SpanishStrings.transitionMetals.isNotEmpty())
        assertTrue(SpanishStrings.postTransitionMetals.isNotEmpty())
        assertTrue(SpanishStrings.metalloids.isNotEmpty())
        assertTrue(SpanishStrings.nonMetals.isNotEmpty())
        assertTrue(SpanishStrings.halogens.isNotEmpty())
        assertTrue(SpanishStrings.nobleGases.isNotEmpty())
        assertTrue(SpanishStrings.lanthanides.isNotEmpty())
        assertTrue(SpanishStrings.actinides.isNotEmpty())
        assertTrue(SpanishStrings.elementDetails.isNotEmpty())
        assertTrue(SpanishStrings.atomicNumber.isNotEmpty())
        assertTrue(SpanishStrings.symbol.isNotEmpty())
        assertTrue(SpanishStrings.elementName.isNotEmpty())
        assertTrue(SpanishStrings.molarWeight.isNotEmpty())
        assertTrue(SpanishStrings.period.isNotEmpty())
        assertTrue(SpanishStrings.group.isNotEmpty())
        assertTrue(SpanishStrings.category.isNotEmpty())
        assertTrue(SpanishStrings.close.isNotEmpty())
    }
}
