package dev.whoolister.mykhemical.model.elements

import kotlin.jvm.JvmInline

@JvmInline
value class ElementName private constructor(val key: String) {
    init {
        check(key.matches(regex)) { "Element name key must be a valid identifier" }
    }

    companion object {
        private val regex = Regex("""^[a-z_]+$""")

        operator fun invoke(key: String) = ElementName(key.lowercase())
    }
}
