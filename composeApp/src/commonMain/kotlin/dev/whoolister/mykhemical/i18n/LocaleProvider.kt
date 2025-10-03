package dev.whoolister.mykhemical.i18n

import androidx.compose.runtime.Composable
import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.staticCompositionLocalOf
import cafe.adriel.lyricist.Lyricist
import cafe.adriel.lyricist.ProvideStrings
import dev.whoolister.mykhemical.model.elements.Actinium
import dev.whoolister.mykhemical.model.elements.Aluminum
import dev.whoolister.mykhemical.model.elements.Americium
import dev.whoolister.mykhemical.model.elements.Antimony
import dev.whoolister.mykhemical.model.elements.Argon
import dev.whoolister.mykhemical.model.elements.Arsenic
import dev.whoolister.mykhemical.model.elements.Astatine
import dev.whoolister.mykhemical.model.elements.Barium
import dev.whoolister.mykhemical.model.elements.Berkelium
import dev.whoolister.mykhemical.model.elements.Beryllium
import dev.whoolister.mykhemical.model.elements.Bismuth
import dev.whoolister.mykhemical.model.elements.Bohrium
import dev.whoolister.mykhemical.model.elements.Boron
import dev.whoolister.mykhemical.model.elements.Bromine
import dev.whoolister.mykhemical.model.elements.Cadmium
import dev.whoolister.mykhemical.model.elements.Calcium
import dev.whoolister.mykhemical.model.elements.Californium
import dev.whoolister.mykhemical.model.elements.Carbon
import dev.whoolister.mykhemical.model.elements.Cerium
import dev.whoolister.mykhemical.model.elements.Cesium
import dev.whoolister.mykhemical.model.elements.Chlorine
import dev.whoolister.mykhemical.model.elements.Chromium
import dev.whoolister.mykhemical.model.elements.Cobalt
import dev.whoolister.mykhemical.model.elements.Copernicium
import dev.whoolister.mykhemical.model.elements.Copper
import dev.whoolister.mykhemical.model.elements.Curium
import dev.whoolister.mykhemical.model.elements.Darmstadtium
import dev.whoolister.mykhemical.model.elements.Dubnium
import dev.whoolister.mykhemical.model.elements.Dysprosium
import dev.whoolister.mykhemical.model.elements.Einsteinium
import dev.whoolister.mykhemical.model.elements.Element
import dev.whoolister.mykhemical.model.elements.Erbium
import dev.whoolister.mykhemical.model.elements.Europium
import dev.whoolister.mykhemical.model.elements.Fermium
import dev.whoolister.mykhemical.model.elements.Flerovium
import dev.whoolister.mykhemical.model.elements.Fluorine
import dev.whoolister.mykhemical.model.elements.Francium
import dev.whoolister.mykhemical.model.elements.Gadolinium
import dev.whoolister.mykhemical.model.elements.Gallium
import dev.whoolister.mykhemical.model.elements.Germanium
import dev.whoolister.mykhemical.model.elements.Gold
import dev.whoolister.mykhemical.model.elements.Hafnium
import dev.whoolister.mykhemical.model.elements.Hassium
import dev.whoolister.mykhemical.model.elements.Helium
import dev.whoolister.mykhemical.model.elements.Holmium
import dev.whoolister.mykhemical.model.elements.Hydrogen
import dev.whoolister.mykhemical.model.elements.Indium
import dev.whoolister.mykhemical.model.elements.Iodine
import dev.whoolister.mykhemical.model.elements.Iridium
import dev.whoolister.mykhemical.model.elements.Iron
import dev.whoolister.mykhemical.model.elements.Krypton
import dev.whoolister.mykhemical.model.elements.Lanthanum
import dev.whoolister.mykhemical.model.elements.Lawrencium
import dev.whoolister.mykhemical.model.elements.Lead
import dev.whoolister.mykhemical.model.elements.Lithium
import dev.whoolister.mykhemical.model.elements.Livermorium
import dev.whoolister.mykhemical.model.elements.Lutetium
import dev.whoolister.mykhemical.model.elements.Magnesium
import dev.whoolister.mykhemical.model.elements.Manganese
import dev.whoolister.mykhemical.model.elements.Meitnerium
import dev.whoolister.mykhemical.model.elements.Mendelevium
import dev.whoolister.mykhemical.model.elements.Mercury
import dev.whoolister.mykhemical.model.elements.Molybdenum
import dev.whoolister.mykhemical.model.elements.Moscovium
import dev.whoolister.mykhemical.model.elements.Neodymium
import dev.whoolister.mykhemical.model.elements.Neon
import dev.whoolister.mykhemical.model.elements.Neptunium
import dev.whoolister.mykhemical.model.elements.Nickel
import dev.whoolister.mykhemical.model.elements.Nihonium
import dev.whoolister.mykhemical.model.elements.Niobium
import dev.whoolister.mykhemical.model.elements.Nitrogen
import dev.whoolister.mykhemical.model.elements.Nobelium
import dev.whoolister.mykhemical.model.elements.Oganesson
import dev.whoolister.mykhemical.model.elements.Osmium
import dev.whoolister.mykhemical.model.elements.Oxygen
import dev.whoolister.mykhemical.model.elements.Palladium
import dev.whoolister.mykhemical.model.elements.Phosphorus
import dev.whoolister.mykhemical.model.elements.Platinum
import dev.whoolister.mykhemical.model.elements.Plutonium
import dev.whoolister.mykhemical.model.elements.Polonium
import dev.whoolister.mykhemical.model.elements.Potassium
import dev.whoolister.mykhemical.model.elements.Praseodymium
import dev.whoolister.mykhemical.model.elements.Promethium
import dev.whoolister.mykhemical.model.elements.Protactinium
import dev.whoolister.mykhemical.model.elements.Radium
import dev.whoolister.mykhemical.model.elements.Radon
import dev.whoolister.mykhemical.model.elements.Rhenium
import dev.whoolister.mykhemical.model.elements.Rhodium
import dev.whoolister.mykhemical.model.elements.Roentgenium
import dev.whoolister.mykhemical.model.elements.Rubidium
import dev.whoolister.mykhemical.model.elements.Ruthenium
import dev.whoolister.mykhemical.model.elements.Rutherfordium
import dev.whoolister.mykhemical.model.elements.Samarium
import dev.whoolister.mykhemical.model.elements.Scandium
import dev.whoolister.mykhemical.model.elements.Seaborgium
import dev.whoolister.mykhemical.model.elements.Selenium
import dev.whoolister.mykhemical.model.elements.Silicon
import dev.whoolister.mykhemical.model.elements.Silver
import dev.whoolister.mykhemical.model.elements.Sodium
import dev.whoolister.mykhemical.model.elements.Strontium
import dev.whoolister.mykhemical.model.elements.Sulfur
import dev.whoolister.mykhemical.model.elements.Tantalum
import dev.whoolister.mykhemical.model.elements.Technetium
import dev.whoolister.mykhemical.model.elements.Tellurium
import dev.whoolister.mykhemical.model.elements.Tennessine
import dev.whoolister.mykhemical.model.elements.Terbium
import dev.whoolister.mykhemical.model.elements.Thallium
import dev.whoolister.mykhemical.model.elements.Thorium
import dev.whoolister.mykhemical.model.elements.Thulium
import dev.whoolister.mykhemical.model.elements.Tin
import dev.whoolister.mykhemical.model.elements.Titanium
import dev.whoolister.mykhemical.model.elements.Tungsten
import dev.whoolister.mykhemical.model.elements.Uranium
import dev.whoolister.mykhemical.model.elements.Vanadium
import dev.whoolister.mykhemical.model.elements.Xenon
import dev.whoolister.mykhemical.model.elements.Ytterbium
import dev.whoolister.mykhemical.model.elements.Yttrium
import dev.whoolister.mykhemical.model.elements.Zinc
import dev.whoolister.mykhemical.model.elements.Zirconium

object Locales {
    const val EN = "en"
    const val ES = "es"
}

val lyricistStrings = mapOf(
    Locales.EN to EnglishStrings,
    Locales.ES to SpanishStrings
)

val LocalStrings: ProvidableCompositionLocal<Strings> = staticCompositionLocalOf { SpanishStrings }
val LocalLyricist = Lyricist(Locales.ES, lyricistStrings)

@Composable
fun LocaleProvider(
    content: @Composable () -> Unit
) {
    ProvideStrings(LocalLyricist, LocalStrings) {
        content()
    }
}

@Composable
fun strings(): Strings {
    return LocalStrings.current
}


val Element.name: String @Composable get() {
    val strings = strings()

    return when (this) {
        Hydrogen -> strings.hydrogen
        Helium -> strings.helium
        Lithium -> strings.lithium
        Beryllium -> strings.beryllium
        Boron -> strings.boron
        Carbon -> strings.carbon
        Nitrogen -> strings.nitrogen
        Oxygen -> strings.oxygen
        Fluorine -> strings.fluorine
        Neon -> strings.neon
        Sodium -> strings.sodium
        Magnesium -> strings.magnesium
        Aluminum -> strings.aluminum
        Silicon -> strings.silicon
        Phosphorus -> strings.phosphorus
        Sulfur -> strings.sulfur
        Chlorine -> strings.chlorine
        Argon -> strings.argon
        Potassium -> strings.potassium
        Calcium -> strings.calcium
        Scandium -> strings.scandium
        Titanium -> strings.titanium
        Vanadium -> strings.vanadium
        Chromium -> strings.chromium
        Manganese -> strings.manganese
        Iron -> strings.iron
        Cobalt -> strings.cobalt
        Nickel -> strings.nickel
        Copper -> strings.copper
        Zinc -> strings.zinc
        Gallium -> strings.gallium
        Germanium -> strings.germanium
        Arsenic -> strings.arsenic
        Selenium -> strings.selenium
        Bromine -> strings.bromine
        Krypton -> strings.krypton
        Rubidium -> strings.rubidium
        Strontium -> strings.strontium
        Yttrium -> strings.yttrium
        Zirconium -> strings.zirconium
        Niobium -> strings.niobium
        Molybdenum -> strings.molybdenum
        Technetium -> strings.technetium
        Ruthenium -> strings.ruthenium
        Rhodium -> strings.rhodium
        Palladium -> strings.palladium
        Silver -> strings.silver
        Cadmium -> strings.cadmium
        Indium -> strings.indium
        Tin -> strings.tin
        Antimony -> strings.antimony
        Tellurium -> strings.tellurium
        Iodine -> strings.iodine
        Xenon -> strings.xenon
        Cesium -> strings.cesium
        Barium -> strings.barium
        Lanthanum -> strings.lanthanum
        Cerium -> strings.cerium
        Praseodymium -> strings.praseodymium
        Neodymium -> strings.neodymium
        Promethium -> strings.promethium
        Samarium -> strings.samarium
        Europium -> strings.europium
        Gadolinium -> strings.gadolinium
        Terbium -> strings.terbium
        Dysprosium -> strings.dysprosium
        Holmium -> strings.holmium
        Erbium -> strings.erbium
        Thulium -> strings.thulium
        Ytterbium -> strings.ytterbium
        Lutetium -> strings.lutetium
        Hafnium -> strings.hafnium
        Tantalum -> strings.tantalum
        Tungsten -> strings.tungsten
        Rhenium -> strings.rhenium
        Osmium -> strings.osmium
        Iridium -> strings.iridium
        Platinum -> strings.platinum
        Gold -> strings.gold
        Mercury -> strings.mercury
        Thallium -> strings.thallium
        Lead -> strings.lead
        Bismuth -> strings.bismuth
        Polonium -> strings.polonium
        Astatine -> strings.astatine
        Radon -> strings.radon
        Francium -> strings.francium
        Radium -> strings.radium
        Actinium -> strings.actinium
        Thorium -> strings.thorium
        Protactinium -> strings.protactinium
        Uranium -> strings.uranium
        Neptunium -> strings.neptunium
        Plutonium -> strings.plutonium
        Americium -> strings.americium
        Curium -> strings.curium
        Berkelium -> strings.berkelium
        Californium -> strings.californium
        Einsteinium -> strings.einsteinium
        Fermium -> strings.fermium
        Mendelevium -> strings.mendelevium
        Nobelium -> strings.nobelium
        Lawrencium -> strings.lawrencium
        Rutherfordium -> strings.rutherfordium
        Dubnium -> strings.dubnium
        Seaborgium -> strings.seaborgium
        Bohrium -> strings.bohrium
        Hassium -> strings.hassium
        Meitnerium -> strings.meitnerium
        Darmstadtium -> strings.darmstadtium
        Roentgenium -> strings.roentgenium
        Copernicium -> strings.copernicium
        Nihonium -> strings.nihonium
        Flerovium -> strings.flerovium
        Moscovium -> strings.moscovium
        Livermorium -> strings.livermorium
        Tennessine -> strings.tennessine
        Oganesson -> strings.oganesson
        else -> throw IllegalArgumentException("Unknown element: $this")
    }
}
