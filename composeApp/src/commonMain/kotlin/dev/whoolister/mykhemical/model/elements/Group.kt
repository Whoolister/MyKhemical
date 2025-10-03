package dev.whoolister.mykhemical.model.elements

import kotlin.jvm.JvmInline

@JvmInline
value class Group(val number: Int) : Comparable<Group> {

    companion object {
        const val GROUP_LIMIT = 18
    }

    init {
        check(number in 1..GROUP_LIMIT) { "Group number must be between 1 and $GROUP_LIMIT" }
    }

    override fun compareTo(other: Group): Int {
        return number.compareTo(other.number)
    }
}

class GroupIterator(start: Group, val end: Group): Iterator<Group> {
    private var current: Group? = start

    override fun hasNext(): Boolean = current != null && current!! <= end

    override fun next(): Group {
        if (!hasNext()) throw NoSuchElementException("No more elements in group iterator")

        val result = current!!

        // Calculate next group, or set to null if we've reached the end
        current = if (result < end) {
            Group(result.number + 1)
        } else {
            null // result == end, so this is the last element
        }

        return result
    }
}

class GroupProgression(
    override val start: Group,
    override val endInclusive: Group
): ClosedRange<Group>, Iterable<Group> {
    override fun iterator(): Iterator<Group> = GroupIterator(start, endInclusive)

    override fun toString(): String = "$start..$endInclusive"
}

operator fun Group.rangeTo(that: Group): GroupProgression = GroupProgression(this, that)
