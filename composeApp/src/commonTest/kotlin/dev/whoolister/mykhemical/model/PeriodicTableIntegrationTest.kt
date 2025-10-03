package dev.whoolister.mykhemical.model

import dev.whoolister.mykhemical.model.elements.*
import dev.whoolister.mykhemical.model.table.PeriodicTable
import dev.whoolister.mykhemical.model.table.PeriodicTable.ElementItem
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

/**
 * Integration tests that verify the periodic table structure matches
 * the real-world organization of chemical elements
 */
class PeriodicTableIntegrationTest {

    @Test
    fun testWaterComposition() {
        // Water is H2O - verify we have both elements
        val hydrogen = PeriodicTable[AtomicNumber(1)] as ElementItem
        val oxygen = PeriodicTable[AtomicNumber(8)] as ElementItem

        assertEquals(Hydrogen, hydrogen.element)
        assertEquals(Oxygen, oxygen.element)

        // Both should be non-metals
        assertEquals(ElementCategory.NON_METALS, hydrogen.element.category)
        assertEquals(ElementCategory.NON_METALS, oxygen.element.category)
    }

    @Test
    fun testTableSaltComposition() {
        // Table salt is NaCl
        val sodium = PeriodicTable[AtomicNumber(11)] as ElementItem
        val chlorine = PeriodicTable[AtomicNumber(17)] as ElementItem

        assertEquals(Sodium, sodium.element)
        assertEquals(Chlorine, chlorine.element)

        // Sodium is an alkali metal, Chlorine is a halogen
        assertEquals(ElementCategory.ALKALI_METALS, sodium.element.category)
        assertEquals(ElementCategory.HALOGENS, chlorine.element.category)
    }

    @Test
    fun testCommonMetals() {
        // Test some common metals
        val iron = PeriodicTable[AtomicNumber(26)] as ElementItem
        val copper = PeriodicTable[AtomicNumber(29)] as ElementItem
        val gold = PeriodicTable[AtomicNumber(79)] as ElementItem
        val silver = PeriodicTable[AtomicNumber(47)] as ElementItem

        assertEquals(Iron, iron.element)
        assertEquals(Copper, copper.element)
        assertEquals(Gold, gold.element)
        assertEquals(Silver, silver.element)

        // All should be transition metals
        assertEquals(ElementCategory.TRANSITION_METALS, iron.element.category)
        assertEquals(ElementCategory.TRANSITION_METALS, copper.element.category)
        assertEquals(ElementCategory.TRANSITION_METALS, gold.element.category)
        assertEquals(ElementCategory.TRANSITION_METALS, silver.element.category)
    }

    @Test
    fun testAtmosphericGases() {
        // Major components of Earth's atmosphere
        val nitrogen = PeriodicTable[AtomicNumber(7)] as ElementItem
        val oxygen = PeriodicTable[AtomicNumber(8)] as ElementItem
        val argon = PeriodicTable[AtomicNumber(18)] as ElementItem

        assertEquals(Nitrogen, nitrogen.element)
        assertEquals(Oxygen, oxygen.element)
        assertEquals(Argon, argon.element)

        // Nitrogen and Oxygen are non-metals, Argon is a noble gas
        assertEquals(ElementCategory.NON_METALS, nitrogen.element.category)
        assertEquals(ElementCategory.NON_METALS, oxygen.element.category)
        assertEquals(ElementCategory.NOBLE_GASES, argon.element.category)
    }

    @Test
    fun testOrganicChemistryElements() {
        // Main elements in organic chemistry (CHNOPS)
        val carbon = PeriodicTable[AtomicNumber(6)] as ElementItem
        val hydrogen = PeriodicTable[AtomicNumber(1)] as ElementItem
        val nitrogen = PeriodicTable[AtomicNumber(7)] as ElementItem
        val oxygen = PeriodicTable[AtomicNumber(8)] as ElementItem
        val phosphorus = PeriodicTable[AtomicNumber(15)] as ElementItem
        val sulfur = PeriodicTable[AtomicNumber(16)] as ElementItem

        // Verify symbols
        assertEquals("C", carbon.element.symbol.value)
        assertEquals("H", hydrogen.element.symbol.value)
        assertEquals("N", nitrogen.element.symbol.value)
        assertEquals("O", oxygen.element.symbol.value)
        assertEquals("P", phosphorus.element.symbol.value)
        assertEquals("S", sulfur.element.symbol.value)
    }

    @Test
    fun testRadioactiveElements() {
        // Common radioactive elements
        val uranium = PeriodicTable[AtomicNumber(92)] as ElementItem
        val plutonium = PeriodicTable[AtomicNumber(94)] as ElementItem
        val radium = PeriodicTable[AtomicNumber(88)] as ElementItem

        assertEquals(Uranium, uranium.element)
        assertEquals(Plutonium, plutonium.element)
        assertEquals(Radium, radium.element)

        // Uranium and Plutonium are actinides
        assertEquals(ElementCategory.ACTINIDES, uranium.element.category)
        assertEquals(ElementCategory.ACTINIDES, plutonium.element.category)

        // Radium is alkaline earth metal
        assertEquals(ElementCategory.ALKALINE_EARTH_METALS, radium.element.category)
    }

    @Test
    fun testPreciousMetals() {
        // Precious metals used in jewelry
        val gold = PeriodicTable[AtomicNumber(79)] as ElementItem
        val silver = PeriodicTable[AtomicNumber(47)] as ElementItem
        val platinum = PeriodicTable[AtomicNumber(78)] as ElementItem

        assertEquals("Au", gold.element.symbol.value)
        assertEquals("Ag", silver.element.symbol.value)
        assertEquals("Pt", platinum.element.symbol.value)

        // All are transition metals
        assertEquals(ElementCategory.TRANSITION_METALS, gold.element.category)
        assertEquals(ElementCategory.TRANSITION_METALS, silver.element.category)
        assertEquals(ElementCategory.TRANSITION_METALS, platinum.element.category)
    }

    @Test
    fun testSemiconductorElements() {
        // Common semiconductor materials
        val silicon = PeriodicTable[AtomicNumber(14)] as ElementItem
        val germanium = PeriodicTable[AtomicNumber(32)] as ElementItem

        assertEquals(Silicon, silicon.element)
        assertEquals(Germanium, germanium.element)

        // Both are metalloids
        assertEquals(ElementCategory.METALLOIDS, silicon.element.category)
        assertEquals(ElementCategory.METALLOIDS, germanium.element.category)
    }

    @Test
    fun testIsotopesShareAtomicNumber() {
        // Different isotopes of an element share the same atomic number
        // Carbon-12, Carbon-13, and Carbon-14 all have atomic number 6
        val carbon = PeriodicTable[AtomicNumber(6)] as ElementItem

        assertEquals(6, carbon.element.atomicNumber.value)
        assertEquals("C", carbon.element.symbol.value)
    }

    @Test
    fun testFirstTenElements() {
        // Test the first 10 elements in order
        val expectedSymbols = listOf("H", "He", "Li", "Be", "B", "C", "N", "O", "F", "Ne")

        for (i in 1..10) {
            val item = PeriodicTable[AtomicNumber(i)] as ElementItem
            assertEquals(expectedSymbols[i - 1], item.element.symbol.value)
        }
    }

    @Test
    fun testMolarWeightsAreReasonable() {
        // Test that molar weights are in reasonable ranges
        val hydrogen = PeriodicTable[AtomicNumber(1)] as ElementItem
        val uranium = PeriodicTable[AtomicNumber(92)] as ElementItem

        // Hydrogen is the lightest
        assertTrue(hydrogen.element.molarWeight.value < 2.0)

        // Uranium is heavy
        assertTrue(uranium.element.molarWeight.value > 230.0)

        // Molar weight generally increases with atomic number
        assertTrue(hydrogen.element.molarWeight.value < uranium.element.molarWeight.value)
    }

    @Test
    fun testPeriodicLawTrends() {
        // Test periodic trends across a period (e.g., Period 2)
        val period2Elements = listOf(
            Lithium, Beryllium, Boron, Carbon, Nitrogen, Oxygen, Fluorine, Neon
        )

        // All should be in period 2
        period2Elements.forEach { element ->
            assertEquals(2, element.period.value)
        }

        // Groups should increase from 1 to 18 (with gaps)
        assertEquals(1, Lithium.group.number)
        assertEquals(2, Beryllium.group.number)
        assertEquals(13, Boron.group.number)
        assertEquals(14, Carbon.group.number)
        assertEquals(15, Nitrogen.group.number)
        assertEquals(16, Oxygen.group.number)
        assertEquals(17, Fluorine.group.number)
        assertEquals(18, Neon.group.number)
    }

    @Test
    fun testElementAccessByPositionConsistency() {
        // Test that accessing by atomic number and by period/group yields same element
        val hydrogen1 = PeriodicTable[AtomicNumber(1)] as ElementItem
        val hydrogen2 = PeriodicTable[Period(1), Group(1)] as ElementItem

        assertEquals(hydrogen1.element, hydrogen2.element)

        val helium1 = PeriodicTable[AtomicNumber(2)] as ElementItem
        val helium2 = PeriodicTable[Period(1), Group(18)] as ElementItem

        assertEquals(helium1.element, helium2.element)
    }

    @Test
    fun testAllElementsHaveValidProperties() {
        // Comprehensive test that all elements have valid properties
        PeriodicTable.elements.forEach { element ->
            // Atomic number should be positive
            assertTrue(element.atomicNumber.value > 0)

            // Symbol should not be empty
            assertTrue(element.symbol.value.isNotEmpty())

            // Molar weight should be positive
            assertTrue(element.molarWeight.value > 0)

            // Period should be between 1 and 7
            assertTrue(element.period.value in 1..7)

            // Group should be between 1 and 18
            assertTrue(element.group.number in 1..18)
        }
    }
}
