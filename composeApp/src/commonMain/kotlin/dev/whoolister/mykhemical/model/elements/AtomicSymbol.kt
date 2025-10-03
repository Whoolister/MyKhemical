package dev.whoolister.mykhemical.model.elements

import androidx.compose.ui.text.capitalize
import androidx.compose.ui.text.intl.Locale
import kotlin.jvm.JvmInline

@JvmInline
value class AtomicSymbol private constructor(val value: String) {
    init {
        check(value.length <= 2) { "Atomic symbol must be 1 or 2 characters" }
        check(value.matches(regex)) {
            "Atomic symbol must be comprised of one uppercase letter, and optionally one/two lowercase letters"
        }
    }

    companion object {
        private val regex = Regex("""^[A-Z][a-z]{0,2}$""")

        operator fun invoke(value: String) = AtomicSymbol(value.capitalize(Locale.current))
    }
}
