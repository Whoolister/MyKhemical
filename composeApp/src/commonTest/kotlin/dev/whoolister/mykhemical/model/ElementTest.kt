package dev.whoolister.mykhemical.model

import dev.whoolister.mykhemical.model.elements.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFalse

class ElementTest {

    @Test
    fun testHydrogenProperties() {
        // Test that Hydrogen has correct basic properties
        assertEquals(1, Hydrogen.atomicNumber.value)
        assertEquals("H", Hydrogen.symbol.value)
        assertEquals(ElementCategory.NON_METALS, Hydrogen.category)
        assertEquals(1.008, Hydrogen.molarWeight.value, 0.001)
        assertEquals(1, Hydrogen.period.value)
        assertEquals(1, Hydrogen.group.number)
    }

    @Test
    fun testHeliumProperties() {
        // Test that Helium has correct basic properties
        assertEquals(2, Helium.atomicNumber.value)
        assertEquals("He", Helium.symbol.value)
        assertEquals(ElementCategory.NOBLE_GASES, Helium.category)
        assertEquals(4.003, Helium.molarWeight.value, 0.001)
        assertEquals(1, Helium.period.value)
        assertEquals(18, Helium.group.number)
    }

    @Test
    fun testTransitionMetalProperties() {
        // Test that Iron is a transition metal
        assertEquals(ElementCategory.TRANSITION_METALS, Iron.category)
        assertEquals(26, Iron.atomicNumber.value)
        assertEquals("Fe", Iron.symbol.value)
    }

    @Test
    fun testNobleGasProperties() {
        // Test noble gas properties
        val nobleGases = listOf(Helium, Neon, Argon, Krypton, Xenon, Radon, Oganesson)
        nobleGases.forEach { element ->
            assertEquals(ElementCategory.NOBLE_GASES, element.category)
            assertEquals(18, element.group.number) // All noble gases are in group 18
        }
    }

    @Test
    fun testAlkaliMetalProperties() {
        // Test alkali metal properties
        val alkaliMetals = listOf(Lithium, Sodium, Potassium, Rubidium, Cesium, Francium)
        alkaliMetals.forEach { element ->
            assertEquals(ElementCategory.ALKALI_METALS, element.category)
            assertEquals(1, element.group.number) // All alkali metals are in group 1
        }
    }

    @Test
    fun testHalogenProperties() {
        // Test halogen properties
        val halogens = listOf(Fluorine, Chlorine, Bromine, Iodine, Astatine, Tennessine)
        halogens.forEach { element ->
            assertEquals(ElementCategory.HALOGENS, element.category)
            assertEquals(17, element.group.number) // All halogens are in group 17
        }
    }

    @Test
    fun testElementComparison() {
        // Test that elements can be compared by atomic number
        assertTrue(Hydrogen < Helium)
        assertTrue(Carbon < Nitrogen)
        assertTrue(Iron < Gold)
        assertFalse(Oxygen < Carbon)
    }

    @Test
    fun testAtomicNumberOrdering() {
        // Test that atomic numbers are sequential for common elements
        assertEquals(1, Hydrogen.atomicNumber.value)
        assertEquals(2, Helium.atomicNumber.value)
        assertEquals(6, Carbon.atomicNumber.value)
        assertEquals(8, Oxygen.atomicNumber.value)
        assertEquals(79, Gold.atomicNumber.value)
        assertEquals(92, Uranium.atomicNumber.value)
    }

    @Test
    fun testLanthanidesSeries() {
        // Test lanthanides have correct category and period
        val lanthanides = listOf(
            Lanthanum, Cerium, Praseodymium, Neodymium, Promethium,
            Samarium, Europium, Gadolinium, Terbium, Dysprosium,
            Holmium, Erbium, Thulium, Ytterbium, Lutetium
        )

        lanthanides.forEach { element ->
            assertEquals(ElementCategory.LANTHANIDES, element.category)
            assertEquals(6, element.period.value)
        }
    }

    @Test
    fun testActinidesSeries() {
        // Test actinides have correct category and period
        val actinides = listOf(
            Actinium, Thorium, Protactinium, Uranium, Neptunium,
            Plutonium, Americium, Curium, Berkelium, Californium,
            Einsteinium, Fermium, Mendelevium, Nobelium, Lawrencium
        )

        actinides.forEach { element ->
            assertEquals(ElementCategory.ACTINIDES, element.category)
            assertEquals(7, element.period.value)
        }
    }

    @Test
    fun testMetalloidProperties() {
        // Test metalloid elements
        val metalloids = listOf(Boron, Silicon, Germanium, Arsenic, Antimony, Tellurium)
        metalloids.forEach { element ->
            assertEquals(ElementCategory.METALLOIDS, element.category)
        }
    }

    @Test
    fun testMolarWeightIncreases() {
        // Generally, molar weight increases with atomic number (with some exceptions)
        assertTrue(Hydrogen.molarWeight.value < Helium.molarWeight.value)
        assertTrue(Carbon.molarWeight.value < Nitrogen.molarWeight.value)
        assertTrue(Nitrogen.molarWeight.value < Oxygen.molarWeight.value)
    }
}
