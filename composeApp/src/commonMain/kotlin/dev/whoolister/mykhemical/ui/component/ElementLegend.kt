package dev.whoolister.mykhemical.ui.component

import androidx.compose.ui.graphics.Color
import dev.whoolister.mykhemical.model.elements.ElementCategory

private data class LegendItem(
    val category: ElementCategory,
    val displayName: String,
    val color: Color,
)