package dev.whoolister.mykhemical.model.elements

sealed class Element(
    val atomicNumber: AtomicNumber,
    val symbol: AtomicSymbol,
    val category: ElementCategory,
    val molarWeight: MolarWeight,
    val period: Period,
    val group: Group,
): Comparable<Element> {
    override fun compareTo(other: Element): Int {
        return atomicNumber.compareTo(other.atomicNumber)
    }
}

object Hydrogen :
    Element(
        atomicNumber = AtomicNumber(1),
        symbol = AtomicSymbol("H"),
        category = ElementCategory.NON_METALS,
        molarWeight = MolarWeight(1.008),
        period = Period(1),
        group = Group(1),
    )

object Helium :
    Element(
        atomicNumber = AtomicNumber(2),
        symbol = AtomicSymbol("He"),
        category = ElementCategory.NOBLE_GASES,
        molarWeight = MolarWeight(4.003),
        period = Period(1),
        group = Group(18),
    )

object Lithium :
    Element(
        atomicNumber = AtomicNumber(3),
        symbol = AtomicSymbol("Li"),
        category = ElementCategory.ALKALI_METALS,
        molarWeight = MolarWeight(6.94),
        period = Period(2),
        group = Group(1),
    )

object Beryllium :
    Element(
        atomicNumber = AtomicNumber(4),
        symbol = AtomicSymbol("Be"),
        category = ElementCategory.ALKALINE_EARTH_METALS,
        molarWeight = MolarWeight(9.012),
        period = Period(2),
        group = Group(2),
    )

object Boron :
    Element(
        atomicNumber = AtomicNumber(5),
        symbol = AtomicSymbol("B"),
        category = ElementCategory.METALLOIDS,
        molarWeight = MolarWeight(10.811),
        period = Period(2),
        group = Group(13),
    )

object Carbon :
    Element(
        atomicNumber = AtomicNumber(6),
        symbol = AtomicSymbol("C"),
        category = ElementCategory.NON_METALS,
        molarWeight = MolarWeight(12.011),
        period = Period(2),
        group = Group(14),
    )

object Nitrogen :
    Element(
        atomicNumber = AtomicNumber(7),
        symbol = AtomicSymbol("N"),
        category = ElementCategory.NON_METALS,
        molarWeight = MolarWeight(14.007),
        period = Period(2),
        group = Group(15),
    )

object Oxygen :
    Element(
        atomicNumber = AtomicNumber(8),
        symbol = AtomicSymbol("O"),
        category = ElementCategory.NON_METALS,
        molarWeight = MolarWeight(15.999),
        period = Period(2),
        group = Group(16),
    )

object Fluorine :
    Element(
        atomicNumber = AtomicNumber(9),
        symbol = AtomicSymbol("F"),
        category = ElementCategory.HALOGENS,
        molarWeight = MolarWeight(18.998),
        period = Period(2),
        group = Group(17),
    )

object Neon :
    Element(
        atomicNumber = AtomicNumber(10),
        symbol = AtomicSymbol("Ne"),
        category = ElementCategory.NOBLE_GASES,
        molarWeight = MolarWeight(20.180),
        period = Period(2),
        group = Group(18),
    )

object Sodium :
    Element(
        atomicNumber = AtomicNumber(11),
        symbol = AtomicSymbol("Na"),
        category = ElementCategory.ALKALI_METALS,
        molarWeight = MolarWeight(22.990),
        period = Period(3),
        group = Group(1),
    )

object Magnesium :
    Element(
        atomicNumber = AtomicNumber(12),
        symbol = AtomicSymbol("Mg"),
        category = ElementCategory.ALKALINE_EARTH_METALS,
        molarWeight = MolarWeight(24.305),
        period = Period(3),
        group = Group(2),
    )

object Aluminum :
    Element(
        atomicNumber = AtomicNumber(13),
        symbol = AtomicSymbol("Al"),
        category = ElementCategory.POST_TRANSITION_METALS,
        molarWeight = MolarWeight(26.982),
        period = Period(3),
        group = Group(13),
    )

object Silicon :
    Element(
        atomicNumber = AtomicNumber(14),
        symbol = AtomicSymbol("Si"),
        category = ElementCategory.METALLOIDS,
        molarWeight = MolarWeight(28.085),
        period = Period(3),
        group = Group(14),
    )

object Phosphorus :
    Element(
        atomicNumber = AtomicNumber(15),
        symbol = AtomicSymbol("P"),
        category = ElementCategory.NON_METALS,
        molarWeight = MolarWeight(30.974),
        period = Period(3),
        group = Group(15),
    )

object Sulfur :
    Element(
        atomicNumber = AtomicNumber(16),
        symbol = AtomicSymbol("S"),
        category = ElementCategory.NON_METALS,
        molarWeight = MolarWeight(32.066),
        period = Period(3),
        group = Group(16),
    )

object Chlorine :
    Element(
        atomicNumber = AtomicNumber(17),
        symbol = AtomicSymbol("Cl"),
        category = ElementCategory.HALOGENS,
        molarWeight = MolarWeight(35.453),
        period = Period(3),
        group = Group(17),
    )

object Argon :
    Element(
        atomicNumber = AtomicNumber(18),
        symbol = AtomicSymbol("Ar"),
        category = ElementCategory.NOBLE_GASES,
        molarWeight = MolarWeight(39.948),
        period = Period(3),
        group = Group(18),
    )

object Potassium :
    Element(
        atomicNumber = AtomicNumber(19),
        symbol = AtomicSymbol("K"),
        category = ElementCategory.ALKALI_METALS,
        molarWeight = MolarWeight(39.098),
        period = Period(4),
        group = Group(1),
    )

object Calcium :
    Element(
        atomicNumber = AtomicNumber(20),
        symbol = AtomicSymbol("Ca"),
        category = ElementCategory.ALKALINE_EARTH_METALS,
        molarWeight = MolarWeight(40.078),
        period = Period(4),
        group = Group(2),
    )

object Scandium :
    Element(
        atomicNumber = AtomicNumber(21),
        symbol = AtomicSymbol("Sc"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(44.956),
        period = Period(4),
        group = Group(3),
    )

object Titanium :
    Element(
        atomicNumber = AtomicNumber(22),
        symbol = AtomicSymbol("Ti"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(47.867),
        period = Period(4),
        group = Group(4),
    )

object Vanadium :
    Element(
        atomicNumber = AtomicNumber(23),
        symbol = AtomicSymbol("V"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(50.942),
        period = Period(4),
        group = Group(5),
    )

object Chromium :
    Element(
        atomicNumber = AtomicNumber(24),
        symbol = AtomicSymbol("Cr"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(51.996),
        period = Period(4),
        group = Group(6),
    )

object Manganese :
    Element(
        atomicNumber = AtomicNumber(25),
        symbol = AtomicSymbol("Mn"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(54.938),
        period = Period(4),
        group = Group(7),
    )

object Iron :
    Element(
        atomicNumber = AtomicNumber(26),
        symbol = AtomicSymbol("Fe"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(55.845),
        period = Period(4),
        group = Group(8),
    )

object Cobalt :
    Element(
        atomicNumber = AtomicNumber(27),
        symbol = AtomicSymbol("Co"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(58.933),
        period = Period(4),
        group = Group(9),
    )

object Nickel :
    Element(
        atomicNumber = AtomicNumber(28),
        symbol = AtomicSymbol("Ni"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(58.693),
        period = Period(4),
        group = Group(10),
    )

object Copper :
    Element(
        atomicNumber = AtomicNumber(29),
        symbol = AtomicSymbol("Cu"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(63.546),
        period = Period(4),
        group = Group(11),
    )

object Zinc :
    Element(
        atomicNumber = AtomicNumber(30),
        symbol = AtomicSymbol("Zn"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(65.380),
        period = Period(4),
        group = Group(12),
    )

object Gallium :
    Element(
        atomicNumber = AtomicNumber(31),
        symbol = AtomicSymbol("Ga"),
        category = ElementCategory.POST_TRANSITION_METALS,
        molarWeight = MolarWeight(69.723),
        period = Period(4),
        group = Group(13),
    )

object Germanium :
    Element(
        atomicNumber = AtomicNumber(32),
        symbol = AtomicSymbol("Ge"),
        category = ElementCategory.METALLOIDS,
        molarWeight = MolarWeight(72.630),
        period = Period(4),
        group = Group(14),
    )

object Arsenic :
    Element(
        atomicNumber = AtomicNumber(33),
        symbol = AtomicSymbol("As"),
        category = ElementCategory.METALLOIDS,
        molarWeight = MolarWeight(74.922),
        period = Period(4),
        group = Group(15),
    )

object Selenium :
    Element(
        atomicNumber = AtomicNumber(34),
        symbol = AtomicSymbol("Se"),
        category = ElementCategory.NON_METALS,
        molarWeight = MolarWeight(78.971),
        period = Period(4),
        group = Group(16),
    )

object Bromine :
    Element(
        atomicNumber = AtomicNumber(35),
        symbol = AtomicSymbol("Br"),
        category = ElementCategory.HALOGENS,
        molarWeight = MolarWeight(79.904),
        period = Period(4),
        group = Group(17),
    )

object Krypton :
    Element(
        atomicNumber = AtomicNumber(36),
        symbol = AtomicSymbol("Kr"),
        category = ElementCategory.NOBLE_GASES,
        molarWeight = MolarWeight(83.798),
        period = Period(4),
        group = Group(18),
    )

object Rubidium :
    Element(
        atomicNumber = AtomicNumber(37),
        symbol = AtomicSymbol("Rb"),
        category = ElementCategory.ALKALI_METALS,
        molarWeight = MolarWeight(85.468),
        period = Period(5),
        group = Group(1),
    )

object Strontium :
    Element(
        atomicNumber = AtomicNumber(38),
        symbol = AtomicSymbol("Sr"),
        category = ElementCategory.ALKALINE_EARTH_METALS,
        molarWeight = MolarWeight(87.620),
        period = Period(5),
        group = Group(2),
    )

object Yttrium :
    Element(
        atomicNumber = AtomicNumber(39),
        symbol = AtomicSymbol("Y"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(88.906),
        period = Period(5),
        group = Group(3),
    )

object Zirconium :
    Element(
        atomicNumber = AtomicNumber(40),
        symbol = AtomicSymbol("Zr"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(91.224),
        period = Period(5),
        group = Group(4),
    )

object Niobium :
    Element(
        atomicNumber = AtomicNumber(41),
        symbol = AtomicSymbol("Nb"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(92.906),
        period = Period(5),
        group = Group(5),
    )

object Molybdenum :
    Element(
        atomicNumber = AtomicNumber(42),
        symbol = AtomicSymbol("Mo"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(95.950),
        period = Period(5),
        group = Group(6),
    )

object Technetium :
    Element(
        atomicNumber = AtomicNumber(43),
        symbol = AtomicSymbol("Tc"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(98.000),
        period = Period(5),
        group = Group(7),
    )

object Ruthenium :
    Element(
        atomicNumber = AtomicNumber(44),
        symbol = AtomicSymbol("Ru"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(101.070),
        period = Period(5),
        group = Group(8),
    )

object Rhodium :
    Element(
        atomicNumber = AtomicNumber(45),
        symbol = AtomicSymbol("Rh"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(102.906),
        period = Period(5),
        group = Group(9),
    )

object Palladium :
    Element(
        atomicNumber = AtomicNumber(46),
        symbol = AtomicSymbol("Pd"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(106.420),
        period = Period(5),
        group = Group(10),
    )

object Silver :
    Element(
        atomicNumber = AtomicNumber(47),
        symbol = AtomicSymbol("Ag"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(107.868),
        period = Period(5),
        group = Group(11),
    )

object Cadmium :
    Element(
        atomicNumber = AtomicNumber(48),
        symbol = AtomicSymbol("Cd"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(112.414),
        period = Period(5),
        group = Group(12),
    )

object Indium :
    Element(
        atomicNumber = AtomicNumber(49),
        symbol = AtomicSymbol("In"),
        category = ElementCategory.POST_TRANSITION_METALS,
        molarWeight = MolarWeight(114.818),
        period = Period(5),
        group = Group(13),
    )

object Tin :
    Element(
        atomicNumber = AtomicNumber(50),
        symbol = AtomicSymbol("Sn"),
        category = ElementCategory.POST_TRANSITION_METALS,
        molarWeight = MolarWeight(118.710),
        period = Period(5),
        group = Group(14),
    )

object Antimony :
    Element(
        atomicNumber = AtomicNumber(51),
        symbol = AtomicSymbol("Sb"),
        category = ElementCategory.METALLOIDS,
        molarWeight = MolarWeight(121.760),
        period = Period(5),
        group = Group(15),
    )

object Tellurium :
    Element(
        atomicNumber = AtomicNumber(52),
        symbol = AtomicSymbol("Te"),
        category = ElementCategory.METALLOIDS,
        molarWeight = MolarWeight(127.600),
        period = Period(5),
        group = Group(16),
    )

object Iodine :
    Element(
        atomicNumber = AtomicNumber(53),
        symbol = AtomicSymbol("I"),
        category = ElementCategory.HALOGENS,
        molarWeight = MolarWeight(126.904),
        period = Period(5),
        group = Group(17),
    )

object Xenon :
    Element(
        atomicNumber = AtomicNumber(54),
        symbol = AtomicSymbol("Xe"),
        category = ElementCategory.NOBLE_GASES,
        molarWeight = MolarWeight(131.294),
        period = Period(5),
        group = Group(18),
    )

object Cesium :
    Element(
        atomicNumber = AtomicNumber(55),
        symbol = AtomicSymbol("Cs"),
        category = ElementCategory.ALKALI_METALS,
        molarWeight = MolarWeight(132.905),
        period = Period(6),
        group = Group(1),
    )

object Barium :
    Element(
        atomicNumber = AtomicNumber(56),
        symbol = AtomicSymbol("Ba"),
        category = ElementCategory.ALKALINE_EARTH_METALS,
        molarWeight = MolarWeight(137.327),
        period = Period(6),
        group = Group(2),
    )

object Lanthanum :
    Element(
        atomicNumber = AtomicNumber(57),
        symbol = AtomicSymbol("La"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(138.905),
        period = Period(6),
        group = Group(3),
    )

object Cerium :
    Element(
        atomicNumber = AtomicNumber(58),
        symbol = AtomicSymbol("Ce"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(140.116),
        period = Period(6),
        group = Group(3),
    )

object Praseodymium :
    Element(
        atomicNumber = AtomicNumber(59),
        symbol = AtomicSymbol("Pr"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(140.908),
        period = Period(6),
        group = Group(3),
    )

object Neodymium :
    Element(
        atomicNumber = AtomicNumber(60),
        symbol = AtomicSymbol("Nd"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(144.242),
        period = Period(6),
        group = Group(3),
    )

object Promethium :
    Element(
        atomicNumber = AtomicNumber(61),
        symbol = AtomicSymbol("Pm"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(145.000),
        period = Period(6),
        group = Group(3),
    )

object Samarium :
    Element(
        atomicNumber = AtomicNumber(62),
        symbol = AtomicSymbol("Sm"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(150.360),
        period = Period(6),
        group = Group(3),
    )

object Europium :
    Element(
        atomicNumber = AtomicNumber(63),
        symbol = AtomicSymbol("Eu"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(151.964),
        period = Period(6),
        group = Group(3),
    )

object Gadolinium :
    Element(
        atomicNumber = AtomicNumber(64),
        symbol = AtomicSymbol("Gd"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(157.250),
        period = Period(6),
        group = Group(3),
    )

object Terbium :
    Element(
        atomicNumber = AtomicNumber(65),
        symbol = AtomicSymbol("Tb"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(158.925),
        period = Period(6),
        group = Group(3),
    )

object Dysprosium :
    Element(
        atomicNumber = AtomicNumber(66),
        symbol = AtomicSymbol("Dy"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(162.500),
        period = Period(6),
        group = Group(3),
    )

object Holmium :
    Element(
        atomicNumber = AtomicNumber(67),
        symbol = AtomicSymbol("Ho"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(164.930),
        period = Period(6),
        group = Group(3),
    )

object Erbium :
    Element(
        atomicNumber = AtomicNumber(68),
        symbol = AtomicSymbol("Er"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(167.259),
        period = Period(6),
        group = Group(3),
    )

object Thulium :
    Element(
        atomicNumber = AtomicNumber(69),
        symbol = AtomicSymbol("Tm"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(168.934),
        period = Period(6),
        group = Group(3),
    )

object Ytterbium :
    Element(
        atomicNumber = AtomicNumber(70),
        symbol = AtomicSymbol("Yb"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(173.045),
        period = Period(6),
        group = Group(3),
    )

object Lutetium :
    Element(
        atomicNumber = AtomicNumber(71),
        symbol = AtomicSymbol("Lu"),
        category = ElementCategory.LANTHANIDES,
        molarWeight = MolarWeight(174.967),
        period = Period(6),
        group = Group(3),
    )

object Hafnium :
    Element(
        atomicNumber = AtomicNumber(72),
        symbol = AtomicSymbol("Hf"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(178.490),
        period = Period(6),
        group = Group(4),
    )

object Tantalum :
    Element(
        atomicNumber = AtomicNumber(73),
        symbol = AtomicSymbol("Ta"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(180.948),
        period = Period(6),
        group = Group(5),
    )

object Tungsten :
    Element(
        atomicNumber = AtomicNumber(74),
        symbol = AtomicSymbol("W"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(183.840),
        period = Period(6),
        group = Group(6),
    )

object Rhenium :
    Element(
        atomicNumber = AtomicNumber(75),
        symbol = AtomicSymbol("Re"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(186.207),
        period = Period(6),
        group = Group(7),
    )

object Osmium :
    Element(
        atomicNumber = AtomicNumber(76),
        symbol = AtomicSymbol("Os"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(190.230),
        period = Period(6),
        group = Group(8),
    )

object Iridium :
    Element(
        atomicNumber = AtomicNumber(77),
        symbol = AtomicSymbol("Ir"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(192.217),
        period = Period(6),
        group = Group(9),
    )

object Platinum :
    Element(
        atomicNumber = AtomicNumber(78),
        symbol = AtomicSymbol("Pt"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(195.084),
        period = Period(6),
        group = Group(10),
    )

object Gold :
    Element(
        atomicNumber = AtomicNumber(79),
        symbol = AtomicSymbol("Au"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(196.967),
        period = Period(6),
        group = Group(11),
    )

object Mercury :
    Element(
        atomicNumber = AtomicNumber(80),
        symbol = AtomicSymbol("Hg"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(200.592),
        period = Period(6),
        group = Group(12),
    )

object Thallium :
    Element(
        atomicNumber = AtomicNumber(81),
        symbol = AtomicSymbol("Tl"),
        category = ElementCategory.POST_TRANSITION_METALS,
        molarWeight = MolarWeight(204.383),
        period = Period(6),
        group = Group(13),
    )

object Lead :
    Element(
        atomicNumber = AtomicNumber(82),
        symbol = AtomicSymbol("Pb"),
        category = ElementCategory.POST_TRANSITION_METALS,
        molarWeight = MolarWeight(207.200),
        period = Period(6),
        group = Group(14),
    )

object Bismuth :
    Element(
        atomicNumber = AtomicNumber(83),
        symbol = AtomicSymbol("Bi"),
        category = ElementCategory.POST_TRANSITION_METALS,
        molarWeight = MolarWeight(208.980),
        period = Period(6),
        group = Group(15),
    )

object Polonium :
    Element(
        atomicNumber = AtomicNumber(84),
        symbol = AtomicSymbol("Po"),
        category = ElementCategory.POST_TRANSITION_METALS,
        molarWeight = MolarWeight(209.000),
        period = Period(6),
        group = Group(16),
    )

object Astatine :
    Element(
        atomicNumber = AtomicNumber(85),
        symbol = AtomicSymbol("At"),
        category = ElementCategory.HALOGENS,
        molarWeight = MolarWeight(210.000),
        period = Period(6),
        group = Group(17),
    )

object Radon :
    Element(
        atomicNumber = AtomicNumber(86),
        symbol = AtomicSymbol("Rn"),
        category = ElementCategory.NOBLE_GASES,
        molarWeight = MolarWeight(222.000),
        period = Period(6),
        group = Group(18),
    )

object Francium :
    Element(
        atomicNumber = AtomicNumber(87),
        symbol = AtomicSymbol("Fr"),
        category = ElementCategory.ALKALI_METALS,
        molarWeight = MolarWeight(223.000),
        period = Period(7),
        group = Group(1),
    )

object Radium :
    Element(
        atomicNumber = AtomicNumber(88),
        symbol = AtomicSymbol("Ra"),
        category = ElementCategory.ALKALINE_EARTH_METALS,
        molarWeight = MolarWeight(226.000),
        period = Period(7),
        group = Group(2),
    )

object Actinium :
    Element(
        atomicNumber = AtomicNumber(89),
        symbol = AtomicSymbol("Ac"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(227.000),
        period = Period(7),
        group = Group(3),
    )

object Thorium :
    Element(
        atomicNumber = AtomicNumber(90),
        symbol = AtomicSymbol("Th"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(232.038),
        period = Period(7),
        group = Group(3),
    )

object Protactinium :
    Element(
        atomicNumber = AtomicNumber(91),
        symbol = AtomicSymbol("Pa"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(231.036),
        period = Period(7),
        group = Group(3),
    )

object Uranium :
    Element(
        atomicNumber = AtomicNumber(92),
        symbol = AtomicSymbol("U"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(238.029),
        period = Period(7),
        group = Group(3),
    )

object Neptunium :
    Element(
        atomicNumber = AtomicNumber(93),
        symbol = AtomicSymbol("Np"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(237.000),
        period = Period(7),
        group = Group(3),
    )

object Plutonium :
    Element(
        atomicNumber = AtomicNumber(94),
        symbol = AtomicSymbol("Pu"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(244.000),
        period = Period(7),
        group = Group(3),
    )

object Americium :
    Element(
        atomicNumber = AtomicNumber(95),
        symbol = AtomicSymbol("Am"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(243.000),
        period = Period(7),
        group = Group(3),
    )

object Curium :
    Element(
        atomicNumber = AtomicNumber(96),
        symbol = AtomicSymbol("Cm"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(247.000),
        period = Period(7),
        group = Group(3),
    )

object Berkelium :
    Element(
        atomicNumber = AtomicNumber(97),
        symbol = AtomicSymbol("Bk"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(247.000),
        period = Period(7),
        group = Group(3),
    )

object Californium :
    Element(
        atomicNumber = AtomicNumber(98),
        symbol = AtomicSymbol("Cf"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(251.000),
        period = Period(7),
        group = Group(3),
    )

object Einsteinium :
    Element(
        atomicNumber = AtomicNumber(99),
        symbol = AtomicSymbol("Es"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(252.000),
        period = Period(7),
        group = Group(3),
    )

object Fermium :
    Element(
        atomicNumber = AtomicNumber(100),
        symbol = AtomicSymbol("Fm"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(257.000),
        period = Period(7),
        group = Group(3),
    )

object Mendelevium :
    Element(
        atomicNumber = AtomicNumber(101),
        symbol = AtomicSymbol("Md"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(258.000),
        period = Period(7),
        group = Group(3),
    )

object Nobelium :
    Element(
        atomicNumber = AtomicNumber(102),
        symbol = AtomicSymbol("No"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(259.000),
        period = Period(7),
        group = Group(3),
    )

object Lawrencium :
    Element(
        atomicNumber = AtomicNumber(103),
        symbol = AtomicSymbol("Lr"),
        category = ElementCategory.ACTINIDES,
        molarWeight = MolarWeight(266.000),
        period = Period(7),
        group = Group(3),
    )

object Rutherfordium :
    Element(
        atomicNumber = AtomicNumber(104),
        symbol = AtomicSymbol("Rf"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(267.000),
        period = Period(7),
        group = Group(4),
    )

object Dubnium :
    Element(
        atomicNumber = AtomicNumber(105),
        symbol = AtomicSymbol("Db"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(268.000),
        period = Period(7),
        group = Group(5),
    )

object Seaborgium :
    Element(
        atomicNumber = AtomicNumber(106),
        symbol = AtomicSymbol("Sg"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(269.000),
        period = Period(7),
        group = Group(6),
    )

object Bohrium :
    Element(
        atomicNumber = AtomicNumber(107),
        symbol = AtomicSymbol("Bh"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(270.000),
        period = Period(7),
        group = Group(7),
    )

object Hassium :
    Element(
        atomicNumber = AtomicNumber(108),
        symbol = AtomicSymbol("Hs"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(277.000),
        period = Period(7),
        group = Group(8),
    )

object Meitnerium :
    Element(
        atomicNumber = AtomicNumber(109),
        symbol = AtomicSymbol("Mt"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(278.000),
        period = Period(7),
        group = Group(9),
    )

object Darmstadtium :
    Element(
        atomicNumber = AtomicNumber(110),
        symbol = AtomicSymbol("Ds"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(281.000),
        period = Period(7),
        group = Group(10),
    )

object Roentgenium :
    Element(
        atomicNumber = AtomicNumber(111),
        symbol = AtomicSymbol("Rg"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(282.000),
        period = Period(7),
        group = Group(11),
    )

object Copernicium :
    Element(
        atomicNumber = AtomicNumber(112),
        symbol = AtomicSymbol("Cn"),
        category = ElementCategory.TRANSITION_METALS,
        molarWeight = MolarWeight(285.000),
        period = Period(7),
        group = Group(12),
    )

object Nihonium :
    Element(
        atomicNumber = AtomicNumber(113),
        symbol = AtomicSymbol("Nh"),
        category = ElementCategory.POST_TRANSITION_METALS,
        molarWeight = MolarWeight(286.000),
        period = Period(7),
        group = Group(13),
    )

object Flerovium :
    Element(
        atomicNumber = AtomicNumber(114),
        symbol = AtomicSymbol("Fl"),
        category = ElementCategory.POST_TRANSITION_METALS,
        molarWeight = MolarWeight(289.000),
        period = Period(7),
        group = Group(14),
    )

object Moscovium :
    Element(
        atomicNumber = AtomicNumber(115),
        symbol = AtomicSymbol("Mc"),
        category = ElementCategory.POST_TRANSITION_METALS,
        molarWeight = MolarWeight(290.000),
        period = Period(7),
        group = Group(15),
    )

object Livermorium :
    Element(
        atomicNumber = AtomicNumber(116),
        symbol = AtomicSymbol("Lv"),
        category = ElementCategory.POST_TRANSITION_METALS,
        molarWeight = MolarWeight(293.000),
        period = Period(7),
        group = Group(16),
    )

object Tennessine :
    Element(
        atomicNumber = AtomicNumber(117),
        symbol = AtomicSymbol("Ts"),
        category = ElementCategory.HALOGENS,
        molarWeight = MolarWeight(294.000),
        period = Period(7),
        group = Group(17),
    )

object Oganesson :
    Element(
        atomicNumber = AtomicNumber(118),
        symbol = AtomicSymbol("Og"),
        category = ElementCategory.NOBLE_GASES,
        molarWeight = MolarWeight(294.000),
        period = Period(7),
        group = Group(18),
    )
