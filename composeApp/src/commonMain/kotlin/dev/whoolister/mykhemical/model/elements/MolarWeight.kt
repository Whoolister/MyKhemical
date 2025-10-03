package dev.whoolister.mykhemical.model.elements

import kotlin.jvm.JvmInline

/**
 * Weight in grams for each mole (6.02214076 × 10^23 atoms) of an element
 */
@JvmInline
value class MolarWeight(val value: Double) {
    init {
        check(value > 0) { "Molar weight must be greater than 0" }
    }
}
