package dev.whoolister.mykhemical.model.elements

import kotlin.jvm.JvmInline

@JvmInline
value class AtomicNumber(val value: Int): Comparable<AtomicNumber> {
    init {
        check(value > 0) { "Atomic number must be greater than 0" }
    }

    override fun compareTo(other: AtomicNumber): Int = value.compareTo(other.value)
}
