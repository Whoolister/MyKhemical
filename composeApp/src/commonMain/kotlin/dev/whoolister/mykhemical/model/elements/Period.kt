package dev.whoolister.mykhemical.model.elements

import kotlin.jvm.JvmInline

@JvmInline
value class Period(val value: Int): Comparable<Period> {
    init {
        check(value > 0) { "The period of an element must be greater than 0" }
        check(value <= PERIOD_LIMIT) { "The period of an element must be less than or equal to $PERIOD_LIMIT" }
    }

    override fun compareTo(other: Period): Int {
        return value.compareTo(other.value)
    }

    companion object {
        const val PERIOD_LIMIT = 8
    }
}

class PeriodIterator(start: Period, val endInclusive: Period): Iterator<Period> {
    private var current = start

    override fun hasNext(): Boolean = current <= endInclusive

    override fun next(): Period {
        if (!hasNext()) throw NoSuchElementException()

        val result = current
        current = Period(current.value + 1)

        return result
    }
}

class PeriodProgression(
    override val start: Period,
    override val endInclusive: Period
): ClosedRange<Period>, Iterable<Period> {
    override fun iterator(): Iterator<Period> = PeriodIterator(start, endInclusive)

    override fun toString(): String = "$start..$endInclusive"
}

operator fun Period.rangeTo(that: Period): PeriodProgression = PeriodProgression(this, that)