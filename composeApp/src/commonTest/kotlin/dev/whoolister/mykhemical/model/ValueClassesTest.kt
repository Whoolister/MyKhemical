package dev.whoolister.mykhemical.model

import dev.whoolister.mykhemical.model.elements.*
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue
import kotlin.test.assertFails

class ValueClassesTest {

    // AtomicNumber tests
    @Test
    fun testAtomicNumberCreation() {
        val atomicNumber = AtomicNumber(1)
        assertEquals(1, atomicNumber.value)
    }

    @Test
    fun testAtomicNumberComparison() {
        val num1 = AtomicNumber(1)
        val num2 = AtomicNumber(2)
        val num3 = AtomicNumber(10)

        assertTrue(num1 < num2)
        assertTrue(num2 < num3)
        assertTrue(num1 < num3)
    }

    @Test
    fun testAtomicNumberValidation() {
        // Valid atomic numbers
        AtomicNumber(1)
        AtomicNumber(118)
        AtomicNumber(50)

        // Invalid atomic number (must be > 0)
        assertFails {
            AtomicNumber(0)
        }

        assertFails {
            AtomicNumber(-1)
        }
    }

    // Period tests
    @Test
    fun testPeriodCreation() {
        val period = Period(1)
        assertEquals(1, period.value)
    }

    @Test
    fun testPeriodComparison() {
        val period1 = Period(1)
        val period2 = Period(2)
        val period7 = Period(7)

        assertTrue(period1 < period2)
        assertTrue(period2 < period7)
        assertTrue(period1 < period7)
    }

    @Test
    fun testPeriodValidation() {
        // Valid periods
        Period(1)
        Period(7)
        Period(4)

        // Invalid periods
        assertFails {
            Period(0)
        }

        assertFails {
            Period(-1)
        }

        assertFails {
            Period(9) // Exceeds PERIOD_LIMIT
        }
    }

    @Test
    fun testPeriodRange() {
        val range = Period(1)..Period(3)
        val periods = range.toList()

        assertEquals(3, periods.size)
        assertEquals(Period(1), periods[0])
        assertEquals(Period(2), periods[1])
        assertEquals(Period(3), periods[2])
    }

    // Group tests
    @Test
    fun testGroupCreation() {
        val group = Group(1)
        assertEquals(1, group.number)
    }

    @Test
    fun testGroupComparison() {
        val group1 = Group(1)
        val group2 = Group(2)
        val group18 = Group(18)

        assertTrue(group1 < group2)
        assertTrue(group2 < group18)
        assertTrue(group1 < group18)
    }

    @Test
    fun testGroupValidation() {
        // Valid groups
        Group(1)
        Group(18)
        Group(10)

        // Invalid groups
        assertFails {
            Group(0)
        }

        assertFails {
            Group(-1)
        }

        assertFails {
            Group(19) // Exceeds GROUP_LIMIT
        }
    }

    @Test
    fun testGroupRange() {
        val range = Group(1)..Group(3)
        val groups = range.toList()

        assertEquals(3, groups.size)
        assertEquals(Group(1), groups[0])
        assertEquals(Group(2), groups[1])
        assertEquals(Group(3), groups[2])
    }

    @Test
    fun testFullGroupRange() {
        val range = Group(1)..Group(18)
        val groups = range.toList()

        assertEquals(18, groups.size)
        assertEquals(Group(1), groups[0])
        assertEquals(Group(18), groups[17])
    }

    // MolarWeight tests
    @Test
    fun testMolarWeightCreation() {
        val molarWeight = MolarWeight(1.008)
        assertEquals(1.008, molarWeight.value, 0.001)
    }

    @Test
    fun testMolarWeightValidation() {
        // Valid molar weights
        MolarWeight(1.0)
        MolarWeight(100.5)
        MolarWeight(238.029)

        // Invalid molar weights
        assertFails {
            MolarWeight(0.0)
        }

        assertFails {
            MolarWeight(-1.0)
        }
    }

    @Test
    fun testMolarWeightPrecision() {
        val weight1 = MolarWeight(15.999)
        val weight2 = MolarWeight(16.0)

        // These should be different values
        assertTrue(weight1.value < weight2.value)
    }

    // AtomicSymbol tests
    @Test
    fun testAtomicSymbolCreation() {
        val symbol = AtomicSymbol("H")
        assertEquals("H", symbol.value)
    }

    @Test
    fun testAtomicSymbolValidation() {
        // Valid symbols (1-2 characters)
        AtomicSymbol("H")
        AtomicSymbol("He")
        AtomicSymbol("Fe")
        AtomicSymbol("Au")

        // Test that symbols can be 1-2 characters
        AtomicSymbol("C")
        AtomicSymbol("Ca")
    }

    @Test
    fun testAtomicSymbolFormatting() {
        // Common elements
        assertEquals("H", AtomicSymbol("H").value)
        assertEquals("He", AtomicSymbol("He").value)
        assertEquals("Fe", AtomicSymbol("Fe").value)
        assertEquals("Au", AtomicSymbol("Au").value)
    }

    // ElementName tests
    @Test
    fun testElementNameCreation() {
        val name = ElementName("Hydrogen")
        assertEquals("hydrogen", name.key)
    }

    @Test
    fun testElementNameForCommonElements() {
        // ElementName converts to lowercase
        assertEquals("hydrogen", ElementName("Hydrogen").key)
        assertEquals("helium", ElementName("Helium").key)
        assertEquals("carbon", ElementName("Carbon").key)
        assertEquals("oxygen", ElementName("Oxygen").key)
        assertEquals("iron", ElementName("Iron").key)
        assertEquals("gold", ElementName("Gold").key)
    }

}
