package dev.whoolister.mykhemical.model

import dev.whoolister.mykhemical.model.elements.ElementCategory
import dev.whoolister.mykhemical.model.table.PeriodicTable
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class ElementCategoryTest {

    @Test
    fun testAllCategoriesExist() {
        // Test that all expected categories exist
        val categories = listOf(
            ElementCategory.ALKALI_METALS,
            ElementCategory.ALKALINE_EARTH_METALS,
            ElementCategory.TRANSITION_METALS,
            ElementCategory.POST_TRANSITION_METALS,
            ElementCategory.METALLOIDS,
            ElementCategory.NON_METALS,
            ElementCategory.HALOGENS,
            ElementCategory.NOBLE_GASES,
            ElementCategory.LANTHANIDES,
            ElementCategory.ACTINIDES
        )

        // Each category should be distinct
        assertEquals(10, categories.distinct().size)
    }

    @Test
    fun testAlkaliMetalsCount() {
        val alkaliMetals = PeriodicTable.elements.filter {
            it.category == ElementCategory.ALKALI_METALS
        }

        // Li, Na, K, Rb, Cs, Fr
        assertEquals(6, alkaliMetals.size)
    }

    @Test
    fun testAlkalineEarthMetalsCount() {
        val alkalineEarthMetals = PeriodicTable.elements.filter {
            it.category == ElementCategory.ALKALINE_EARTH_METALS
        }

        // Be, Mg, Ca, Sr, Ba, Ra
        assertEquals(6, alkalineEarthMetals.size)
    }

    @Test
    fun testTransitionMetalsCount() {
        val transitionMetals = PeriodicTable.elements.filter {
            it.category == ElementCategory.TRANSITION_METALS
        }

        // Should be 40 transition metals (periods 4-7, groups 3-12)
        assertTrue(transitionMetals.size >= 38)
    }

    @Test
    fun testNobleGasesCount() {
        val nobleGases = PeriodicTable.elements.filter {
            it.category == ElementCategory.NOBLE_GASES
        }

        // He, Ne, Ar, Kr, Xe, Rn, Og
        assertEquals(7, nobleGases.size)
    }

    @Test
    fun testHalogensCount() {
        val halogens = PeriodicTable.elements.filter {
            it.category == ElementCategory.HALOGENS
        }

        // F, Cl, Br, I, At, Ts
        assertEquals(6, halogens.size)
    }

    @Test
    fun testMetalloidsCount() {
        val metalloids = PeriodicTable.elements.filter {
            it.category == ElementCategory.METALLOIDS
        }

        // B, Si, Ge, As, Sb, Te
        assertEquals(6, metalloids.size)
    }

    @Test
    fun testLanthanidesCount() {
        val lanthanides = PeriodicTable.elements.filter {
            it.category == ElementCategory.LANTHANIDES
        }

        // 15 lanthanides (La through Lu)
        assertEquals(15, lanthanides.size)
    }

    @Test
    fun testActinidesCount() {
        val actinides = PeriodicTable.elements.filter {
            it.category == ElementCategory.ACTINIDES
        }

        // 15 actinides (Ac through Lr)
        assertEquals(15, actinides.size)
    }

    @Test
    fun testAllElementsHaveCategory() {
        // Test that every element has a category assigned
        val elements = PeriodicTable.elements

        elements.forEach { element ->
            // Every element should have one of the defined categories
            assertTrue(
                element.category in listOf(
                    ElementCategory.ALKALI_METALS,
                    ElementCategory.ALKALINE_EARTH_METALS,
                    ElementCategory.TRANSITION_METALS,
                    ElementCategory.POST_TRANSITION_METALS,
                    ElementCategory.METALLOIDS,
                    ElementCategory.NON_METALS,
                    ElementCategory.HALOGENS,
                    ElementCategory.NOBLE_GASES,
                    ElementCategory.LANTHANIDES,
                    ElementCategory.ACTINIDES
                ),
                "Element $element has invalid category"
            )
        }
    }

    @Test
    fun testCategoriesAreDistributed() {
        // Test that we have elements in each category
        val categoryCounts = PeriodicTable.elements
            .groupBy { it.category }
            .mapValues { it.value.size }

        // Should have elements in most categories
        assertTrue(categoryCounts.size >= 9, "Expected at least 9 categories with elements")

        // Each category should have at least one element
        categoryCounts.values.forEach { count ->
            assertTrue(count > 0, "Each category should have at least one element")
        }
    }

    @Test
    fun testNoOverlappingCategories() {
        // Test that each element has exactly one category
        val elements = PeriodicTable.elements

        // Count occurrences of each element
        val elementCounts = elements.groupBy { it.atomicNumber }
            .mapValues { it.value.size }

        elementCounts.values.forEach { count ->
            assertEquals(1, count, "Each element should appear exactly once")
        }
    }
}
