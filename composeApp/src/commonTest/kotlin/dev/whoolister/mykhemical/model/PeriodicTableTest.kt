package dev.whoolister.mykhemical.model

import dev.whoolister.mykhemical.model.elements.*
import dev.whoolister.mykhemical.model.table.PeriodicTable
import dev.whoolister.mykhemical.model.table.PeriodicTable.ElementItem
import dev.whoolister.mykhemical.model.table.PeriodicTable.BlankItem
import dev.whoolister.mykhemical.model.table.PeriodicTable.LanthanideGroupItem
import dev.whoolister.mykhemical.model.table.PeriodicTable.ActinideGroupItem
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertIs

class PeriodicTableTest {

    @Test
    fun testGetElementByAtomicNumber() {
        // Test retrieving elements by atomic number
        val hydrogen = PeriodicTable[AtomicNumber(1)]
        assertIs<ElementItem>(hydrogen)
        assertEquals(Hydrogen, hydrogen.element)

        val carbon = PeriodicTable[AtomicNumber(6)]
        assertIs<ElementItem>(carbon)
        assertEquals(Carbon, carbon.element)

        val gold = PeriodicTable[AtomicNumber(79)]
        assertIs<ElementItem>(gold)
        assertEquals(Gold, gold.element)
    }

    @Test
    fun testGetElementByPeriodAndGroup() {
        // Test retrieving elements by period and group
        val hydrogen = PeriodicTable[Period(1), Group(1)]
        assertIs<ElementItem>(hydrogen)
        assertEquals(Hydrogen, hydrogen.element)

        val helium = PeriodicTable[Period(1), Group(18)]
        assertIs<ElementItem>(helium)
        assertEquals(Helium, helium.element)

        val carbon = PeriodicTable[Period(2), Group(14)]
        assertIs<ElementItem>(carbon)
        assertEquals(Carbon, carbon.element)
    }

    @Test
    fun testBlankCells() {
        // Test that blank cells exist where expected
        val blank = PeriodicTable[Period(1), Group(2)]
        assertIs<BlankItem>(blank)

        // Period 1, groups 3-17 should be blank
        for (groupNum in 3..17) {
            val item = PeriodicTable[Period(1), Group(groupNum)]
            assertIs<BlankItem>(item)
        }
    }

    @Test
    fun testLanthanideIndicator() {
        // Test that lanthanide indicator appears at period 6, group 3
        val item = PeriodicTable[Period(6), Group(3)]
        assertIs<LanthanideGroupItem>(item)
    }

    @Test
    fun testActinideIndicator() {
        // Test that actinide indicator appears at period 7, group 3
        val item = PeriodicTable[Period(7), Group(3)]
        assertIs<ActinideGroupItem>(item)
    }

    @Test
    fun testPeriodicTableHas118Elements() {
        // Test that the periodic table contains all 118 elements
        assertEquals(118, PeriodicTable.elements.size)
    }

    @Test
    fun testElementsAreSorted() {
        // Test that elements are sorted by atomic number
        val elements = PeriodicTable.elements
        for (i in 0 until elements.size - 1) {
            assertTrue(elements[i].atomicNumber < elements[i + 1].atomicNumber)
        }
    }

    @Test
    fun testPeriodicTableIterator() {
        // Test that we can iterate over the periodic table
        val rows = PeriodicTable.toList()

        // Should have main table rows (7) + gap row (1) + lanthanides (1) + actinides (1) = 10 rows
        assertEquals(10, rows.size)

        // First row should have 18 cells (groups)
        assertEquals(18, rows[0].size)
    }

    @Test
    fun testFirstPeriodStructure() {
        // Test first period has H and He in correct positions
        val firstPeriod = PeriodicTable.toList()[0]

        // Position 0 (Group 1) should be Hydrogen
        val hydrogen = firstPeriod[0]
        assertIs<ElementItem>(hydrogen)
        assertEquals(Hydrogen, hydrogen.element)

        // Position 17 (Group 18) should be Helium
        val helium = firstPeriod[17]
        assertIs<ElementItem>(helium)
        assertEquals(Helium, helium.element)

        // Positions 1-16 should be blank
        for (i in 1..16) {
            assertIs<BlankItem>(firstPeriod[i])
        }
    }

    @Test
    fun testSecondPeriodHasEightElements() {
        // Test second period (Li through Ne)
        val secondPeriod = PeriodicTable.toList()[1]

        var elementCount = 0
        secondPeriod.forEach { item ->
            if (item is ElementItem) {
                elementCount++
            }
        }

        // Second period should have 8 elements (Li through Ne)
        assertEquals(8, elementCount)
    }

    @Test
    fun testAllNobleGasesInGroup18() {
        // Test that all noble gases are in group 18
        val nobleGases = PeriodicTable.elements.filter {
            it.category == ElementCategory.NOBLE_GASES
        }

        nobleGases.forEach { element ->
            assertEquals(18, element.group.number)
        }

        // Should be 7 noble gases
        assertEquals(7, nobleGases.size)
    }

    @Test
    fun testPeriod3Through6TransitionMetals() {
        // Test that periods 4-7 have transition metals
        val transitionMetals = PeriodicTable.elements.filter {
            it.category == ElementCategory.TRANSITION_METALS
        }

        // All transition metals should be in groups 3-12
        transitionMetals.forEach { element ->
            assertTrue(element.group.number in 3..12)
        }
    }

    @Test
    fun testLanthanidesCount() {
        // Test that there are 15 lanthanides
        val lanthanides = PeriodicTable.elements.filter {
            it.category == ElementCategory.LANTHANIDES
        }
        assertEquals(15, lanthanides.size)

        // All should be in period 6
        lanthanides.forEach { element ->
            assertEquals(6, element.period.value)
        }
    }

    @Test
    fun testActinidesCount() {
        // Test that there are 15 actinides
        val actinides = PeriodicTable.elements.filter {
            it.category == ElementCategory.ACTINIDES
        }
        assertEquals(15, actinides.size)

        // All should be in period 7
        actinides.forEach { element ->
            assertEquals(7, element.period.value)
        }
    }

    @Test
    fun testPeriod7IsComplete() {
        // Test that period 7 has all 32 elements
        val period7Elements = PeriodicTable.elements.filter {
            it.period.value == 7
        }
        // Period 7 has 32 elements total (including actinides)
        assertEquals(32, period7Elements.size)
    }
}
