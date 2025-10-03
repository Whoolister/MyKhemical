package dev.whoolister.mykhemical.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.whoolister.mykhemical.i18n.name
import dev.whoolister.mykhemical.model.elements.Element
import dev.whoolister.mykhemical.model.elements.ElementCategory
import dev.whoolister.mykhemical.ui.theme.ElementColors
import dev.whoolister.mykhemical.ui.theme.RetroShapes
import dev.whoolister.mykhemical.ui.theme.RetroTheme
import org.jetbrains.compose.ui.tooling.preview.Preview
import kotlin.math.round

@Composable
fun ElementCard(
    element: Element,
    modifier: Modifier = Modifier,
    size: ElementCardSize = ElementCardSize.Medium,
    onClick: () -> Unit = {},
) {
    val backgroundColor = getElementColor(element.category)
    val textColor = MaterialTheme.colorScheme.onSurface
    val localizedName = element.name

    Card(
        onClick = onClick,
        modifier = modifier.size(size.width, size.height),
        shape = RetroShapes.Small,
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor.copy(alpha = 0.9f)  // Slightly more opaque
        ),
        border = BorderStroke(2.dp, backgroundColor),  // Add colored border
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)  // Flat design
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(size.padding),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            // Atomic number (top)
            Text(
                text = element.atomicNumber.value.toString(),
                style = MaterialTheme.typography.labelLarge.copy(
                    fontSize = size.atomicNumberSize,
                    fontWeight = FontWeight.Bold
                ),
                color = textColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.fillMaxWidth()
            )

            // Symbol (center, largest)
            Text(
                text = element.symbol.value,
                style = MaterialTheme.typography.displayMedium.copy(
                    fontSize = size.symbolSize,
                    fontWeight = FontWeight.Bold
                ),
                color = textColor,
                textAlign = TextAlign.Center,
                modifier = Modifier.weight(1f),
                maxLines = 1,
                overflow = TextOverflow.Clip
            )

            // Name and atomic weight (bottom)
            if (size.showDetails) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        text = localizedName,
                        style = MaterialTheme.typography.bodyMedium.copy(
                            fontSize = size.nameSize,
                            fontWeight = FontWeight.Medium
                        ),
                        color = textColor,
                        textAlign = TextAlign.Center,
                        maxLines = 1,
                        overflow = TextOverflow.Ellipsis,
                        modifier = Modifier.fillMaxWidth()
                    )

                    Text(
                        text = "${(round(element.molarWeight.value * 1000) / 1000)}",
                        style = MaterialTheme.typography.bodySmall.copy(
                            fontSize = size.weightSize
                        ),
                        color = textColor.copy(alpha = 0.8f),
                        textAlign = TextAlign.Center,
                        modifier = Modifier.fillMaxWidth()
                    )
                }
            }
        }
    }
}

enum class ElementCardSize(
    val width: Dp,
    val height: Dp,
    val padding: Dp,
    val symbolSize: TextUnit,
    val atomicNumberSize: TextUnit,
    val nameSize: TextUnit,
    val weightSize: TextUnit,
    val showDetails: Boolean,
) {
    Small(
        width = 50.dp,
        height = 50.dp,
        padding = 2.dp,
        symbolSize = 14.sp,
        atomicNumberSize = 8.sp,
        nameSize = 6.sp,
        weightSize = 6.sp,
        showDetails = false
    ),
    Medium(
        width = 80.dp,
        height = 80.dp,
        padding = 4.dp,
        symbolSize = 20.sp,
        atomicNumberSize = 10.sp,
        nameSize = 8.sp,
        weightSize = 7.sp,
        showDetails = true
    ),
    Large(
        width = 120.dp,
        height = 120.dp,
        padding = 8.dp,
        symbolSize = 28.sp,
        atomicNumberSize = 12.sp,
        nameSize = 10.sp,
        weightSize = 8.sp,
        showDetails = true
    )
}

@Composable
private fun getElementColor(category: ElementCategory): Color {
    return when (category) {
        ElementCategory.ALKALI_METALS -> ElementColors.AlkaliMetals
        ElementCategory.ALKALINE_EARTH_METALS -> ElementColors.AlkalineEarthMetals
        ElementCategory.TRANSITION_METALS -> ElementColors.TransitionMetals
        ElementCategory.POST_TRANSITION_METALS -> ElementColors.PostTransitionMetals
        ElementCategory.METALLOIDS -> ElementColors.Metalloids
        ElementCategory.NON_METALS -> ElementColors.NonMetals
        ElementCategory.HALOGENS -> ElementColors.Halogens
        ElementCategory.NOBLE_GASES -> ElementColors.NobleGases
        ElementCategory.LANTHANIDES -> ElementColors.Lanthanides
        ElementCategory.ACTINIDES -> ElementColors.Actinides
        ElementCategory.UNKNOWN -> ElementColors.Unknown
    }
}

// Previews - Showing both Light and Dark modes
@Preview
@Composable
fun PreviewElementCardAlkaliMetal() {
    Row {
        RetroTheme(isDarkTheme = false) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Sodium,
                    size = ElementCardSize.Medium
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        RetroTheme(isDarkTheme = true) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Sodium,
                    size = ElementCardSize.Medium
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewElementCardAlkalineEarthMetal() {
    Row {
        RetroTheme(isDarkTheme = false) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Magnesium,
                    size = ElementCardSize.Medium
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        RetroTheme(isDarkTheme = true) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Magnesium,
                    size = ElementCardSize.Medium
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewElementCardTransitionMetal() {
    Row {
        RetroTheme(isDarkTheme = false) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Iron,
                    size = ElementCardSize.Medium
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        RetroTheme(isDarkTheme = true) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Iron,
                    size = ElementCardSize.Medium
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewElementCardPostTransitionMetal() {
    Row {
        RetroTheme(isDarkTheme = false) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Aluminum,
                    size = ElementCardSize.Medium
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        RetroTheme(isDarkTheme = true) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Aluminum,
                    size = ElementCardSize.Medium
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewElementCardMetalloid() {
    Row {
        RetroTheme(isDarkTheme = false) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Silicon,
                    size = ElementCardSize.Medium
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        RetroTheme(isDarkTheme = true) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Silicon,
                    size = ElementCardSize.Medium
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewElementCardNonMetal() {
    Row {
        RetroTheme(isDarkTheme = false) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Carbon,
                    size = ElementCardSize.Medium
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        RetroTheme(isDarkTheme = true) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Carbon,
                    size = ElementCardSize.Medium
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewElementCardHalogen() {
    Row {
        RetroTheme(isDarkTheme = false) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Chlorine,
                    size = ElementCardSize.Medium
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        RetroTheme(isDarkTheme = true) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Chlorine,
                    size = ElementCardSize.Medium
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewElementCardNobleGas() {
    Row {
        RetroTheme(isDarkTheme = false) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Helium,
                    size = ElementCardSize.Medium
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        RetroTheme(isDarkTheme = true) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Helium,
                    size = ElementCardSize.Medium
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewElementCardLanthanide() {
    Row {
        RetroTheme(isDarkTheme = false) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Cerium,
                    size = ElementCardSize.Medium
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        RetroTheme(isDarkTheme = true) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Cerium,
                    size = ElementCardSize.Medium
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewElementCardActinide() {
    Row {
        RetroTheme(isDarkTheme = false) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Uranium,
                    size = ElementCardSize.Medium
                )
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        RetroTheme(isDarkTheme = true) {
            Surface(modifier = Modifier.padding(16.dp)) {
                ElementCard(
                    element = dev.whoolister.mykhemical.model.elements.Uranium,
                    size = ElementCardSize.Medium
                )
            }
        }
    }
}

// Size Previews - Both Light and Dark
@Preview
@Composable
fun PreviewElementCardSizes() {
    Row {
        RetroTheme(isDarkTheme = false) {
            Surface(modifier = Modifier.padding(16.dp)) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ElementCard(
                        element = dev.whoolister.mykhemical.model.elements.Gold,
                        size = ElementCardSize.Small
                    )
                    ElementCard(
                        element = dev.whoolister.mykhemical.model.elements.Gold,
                        size = ElementCardSize.Medium
                    )
                    ElementCard(
                        element = dev.whoolister.mykhemical.model.elements.Gold,
                        size = ElementCardSize.Large
                    )
                }
            }
        }
        Spacer(modifier = Modifier.width(16.dp))
        RetroTheme(isDarkTheme = true) {
            Surface(modifier = Modifier.padding(16.dp)) {
                Column(
                    horizontalAlignment = Alignment.CenterHorizontally,
                    verticalArrangement = Arrangement.spacedBy(8.dp)
                ) {
                    ElementCard(
                        element = dev.whoolister.mykhemical.model.elements.Gold,
                        size = ElementCardSize.Small
                    )
                    ElementCard(
                        element = dev.whoolister.mykhemical.model.elements.Gold,
                        size = ElementCardSize.Medium
                    )
                    ElementCard(
                        element = dev.whoolister.mykhemical.model.elements.Gold,
                        size = ElementCardSize.Large
                    )
                }
            }
        }
    }
}