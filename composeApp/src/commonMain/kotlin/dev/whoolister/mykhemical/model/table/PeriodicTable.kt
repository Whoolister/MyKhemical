package dev.whoolister.mykhemical.model.table

import co.touchlab.kermit.Logger
import dev.whoolister.mykhemical.model.elements.Actinium
import dev.whoolister.mykhemical.model.elements.Aluminum
import dev.whoolister.mykhemical.model.elements.Americium
import dev.whoolister.mykhemical.model.elements.Antimony
import dev.whoolister.mykhemical.model.elements.Argon
import dev.whoolister.mykhemical.model.elements.Arsenic
import dev.whoolister.mykhemical.model.elements.Astatine
import dev.whoolister.mykhemical.model.elements.AtomicNumber
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
import dev.whoolister.mykhemical.model.elements.ElementCategory
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
import dev.whoolister.mykhemical.model.elements.Group
import dev.whoolister.mykhemical.model.elements.GroupProgression
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
import dev.whoolister.mykhemical.model.elements.Period
import dev.whoolister.mykhemical.model.elements.PeriodProgression
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
import dev.whoolister.mykhemical.model.elements.rangeTo

object PeriodicTable: Iterable<List<PeriodicTable.PeriodicTableItem>> {
    private val logger: Logger = Logger.withTag("PeriodicTable")

    val elements: List<Element> by lazy {
        logger.i { "Initializing elements list..." }
        listOf(
            Hydrogen,
            Helium,
            Lithium,
            Beryllium,
            Boron,
            Carbon,
            Nitrogen,
            Oxygen,
            Fluorine,
            Neon,
            Sodium,
            Magnesium,
            Aluminum,
            Silicon,
            Phosphorus,
            Sulfur,
            Chlorine,
            Argon,
            Potassium,
            Calcium,
            Scandium,
            Titanium,
            Vanadium,
            Chromium,
            Manganese,
            Iron,
            Cobalt,
            Nickel,
            Copper,
            Zinc,
            Gallium,
            Germanium,
            Arsenic,
            Selenium,
            Bromine,
            Krypton,
            Rubidium,
            Strontium,
            Yttrium,
            Zirconium,
            Niobium,
            Molybdenum,
            Technetium,
            Ruthenium,
            Rhodium,
            Palladium,
            Silver,
            Cadmium,
            Indium,
            Tin,
            Antimony,
            Tellurium,
            Iodine,
            Xenon,
            Cesium,
            Barium,
            Lanthanum,
            Cerium,
            Praseodymium,
            Neodymium,
            Promethium,
            Samarium,
            Europium,
            Gadolinium,
            Terbium,
            Dysprosium,
            Holmium,
            Erbium,
            Thulium,
            Ytterbium,
            Lutetium,
            Hafnium,
            Tantalum,
            Tungsten,
            Rhenium,
            Osmium,
            Iridium,
            Platinum,
            Gold,
            Mercury,
            Thallium,
            Lead,
            Bismuth,
            Polonium,
            Astatine,
            Radon,
            Francium,
            Radium,
            Actinium,
            Thorium,
            Protactinium,
            Uranium,
            Neptunium,
            Plutonium,
            Americium,
            Curium,
            Berkelium,
            Californium,
            Einsteinium,
            Fermium,
            Mendelevium,
            Nobelium,
            Lawrencium,
            Rutherfordium,
            Dubnium,
            Seaborgium,
            Bohrium,
            Hassium,
            Meitnerium,
            Darmstadtium,
            Roentgenium,
            Copernicium,
            Nihonium,
            Flerovium,
            Moscovium,
            Livermorium,
            Tennessine,
            Oganesson,
        )
    }

    private val lanthanideIndex = Period(6) to Group(3)
    private val actinideIndex = Period(7) to Group(3)

    operator fun get(period: Period, group: Group): PeriodicTableItem {
        logger.i { "Looking up element at period $period, group $group" }

        if ((period to group) == actinideIndex) return ActinideGroupItem

        if ((period to group) == lanthanideIndex) return LanthanideGroupItem

        val element = elements.find { it.period == period && it.group == group }

        if (element == null) return BlankItem

        return ElementItem(element)
    }

    operator fun get(atomicNumber: AtomicNumber): PeriodicTableItem {
        logger.i { "Looking up element at atomic number $atomicNumber" }

        val element = elements.find { it.atomicNumber == atomicNumber }

        if (element == null) return BlankItem

        return ElementItem(element)
    }

    override fun iterator(): Iterator<List<PeriodicTableItem>> {
        logger.i { "Iterating over periodic table" }

        val periods: PeriodProgression = (elements.minOf { it.period }..elements.maxOf { it.period })
        val groups: GroupProgression = (elements.minOf { it.group }..elements.maxOf { it.group })

        logger.i { "Periods: $periods, Groups: $groups" }

        // Create main table rows (periods 1-7)
        val mainRows = periods.map { period ->
            groups.map { group ->
                this[period, group]
            }
        }.toMutableList()

        // Add a gap row between main table and lanthanides/actinides
        val gapRow = buildList {
            repeat(groups.count()) {
                add(GapRowItem)
            }
        }

        mainRows.add(gapRow)

        // Add lanthanides row (period 8 - display only)
        // Start with blank spaces (groups 1-2), then add lanthanides
        val lanthanidesRow = buildList {
            // Add 2 blank spaces to align with the table
            add(BlankItem)
            add(BlankItem)

            // Add all lanthanides (atomic numbers 57-71)
            elements
                .filter { it.category == ElementCategory.LANTHANIDES }
                .sorted()
                .forEach { add(ElementItem(it)) }

            // Fill remaining spaces to match the table width (18 groups total)
            // We have 2 blanks + 15 lanthanides = 17, need 1 more blank
            add(BlankItem)
        }

        // Add actinides row (period 9 - display only)
        // Start with blank spaces (groups 1-2), then add actinides
        val actinidesRow = buildList {
            // Add 2 blank spaces to align with the table
            add(BlankItem)
            add(BlankItem)

            // Add all actinides (atomic numbers 89-103)
            elements
                .filter { it.category == ElementCategory.ACTINIDES }
                .sorted()
                .forEach { add(ElementItem(it)) }

            // Fill remaining spaces to match the table width (18 groups total)
            // We have 2 blanks + 15 actinides = 17, need 1 more blank
            add(BlankItem)
        }

        // Add the lanthanides and actinides rows to the main table
        mainRows.add(lanthanidesRow)
        mainRows.add(actinidesRow)

        return mainRows.iterator()
    }

    sealed class PeriodicTableItem

    data class ElementItem(val element: Element) : PeriodicTableItem()
    data object BlankItem : PeriodicTableItem()
    data object LanthanideGroupItem : PeriodicTableItem()
    data object ActinideGroupItem : PeriodicTableItem()
    data object GapRowItem : PeriodicTableItem()
}
