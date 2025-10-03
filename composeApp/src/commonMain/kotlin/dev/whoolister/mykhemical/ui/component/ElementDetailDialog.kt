package dev.whoolister.mykhemical.ui.component

import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.ui.window.Dialog
import dev.whoolister.mykhemical.i18n.name
import dev.whoolister.mykhemical.i18n.strings
import dev.whoolister.mykhemical.model.elements.Element
import dev.whoolister.mykhemical.model.elements.ElementCategory
import dev.whoolister.mykhemical.ui.theme.ElementColors
import dev.whoolister.mykhemical.ui.theme.RetroShapes
import kotlin.math.round

@Composable
fun ElementDetailDialog(
    element: Element,
    onDismiss: () -> Unit,
    modifier: Modifier = Modifier,
) {
    val strings = strings()

    Dialog(onDismissRequest = onDismiss) {
        Card(
            modifier = modifier
                .fillMaxWidth()
                .padding(16.dp),
            shape = RetroShapes.Small,
            border = BorderStroke(2.dp, MaterialTheme.colorScheme.outline),
            colors = CardDefaults.cardColors(
                containerColor = MaterialTheme.colorScheme.surface
            ),
            elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
        ) {
            Column(
                modifier = Modifier
                    .fillMaxWidth()
                    .verticalScroll(rememberScrollState())
                    .padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.spacedBy(16.dp)
            ) {
                // Title
                Text(
                    text = strings.elementDetails,
                    style = MaterialTheme.typography.headlineLarge.copy(
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.primary,
                    textAlign = TextAlign.Center
                )

                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                )

                // Large Element Symbol with Category Color Background
                Box(
                    modifier = Modifier
                        .size(150.dp)
                        .background(
                            color = getElementColor(element.category).copy(alpha = 0.9f),
                            shape = RetroShapes.None  // Square corners for terminal look
                        )
                        .padding(2.dp)  // Space for border effect
                        .background(
                            color = getElementColor(element.category),
                            shape = RetroShapes.None
                        ),
                    contentAlignment = Alignment.Center
                ) {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                        verticalArrangement = Arrangement.Center
                    ) {
                        Text(
                            text = element.atomicNumber.value.toString(),
                            style = MaterialTheme.typography.titleMedium.copy(
                                fontSize = 16.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                        Text(
                            text = element.symbol.value,
                            style = MaterialTheme.typography.displayLarge.copy(
                                fontSize = 64.sp,
                                fontWeight = FontWeight.Bold
                            ),
                            color = MaterialTheme.colorScheme.onSurface
                        )
                    }
                }

                // Element Name (Localized)
                Text(
                    text = element.name,
                    style = MaterialTheme.typography.displayMedium.copy(
                        fontSize = 28.sp,
                        fontWeight = FontWeight.Bold
                    ),
                    color = MaterialTheme.colorScheme.onSurface,
                    textAlign = TextAlign.Center
                )

                HorizontalDivider(
                    modifier = Modifier.fillMaxWidth(),
                    color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.2f)
                )

                // Properties List
                Column(
                    modifier = Modifier.fillMaxWidth(),
                    verticalArrangement = Arrangement.spacedBy(12.dp)
                ) {
                    PropertyRow(
                        label = strings.atomicNumber,
                        value = element.atomicNumber.value.toString()
                    )

                    PropertyRow(
                        label = strings.symbol,
                        value = element.symbol.value
                    )

                    PropertyRow(
                        label = strings.molarWeight,
                        value = "${round(element.molarWeight.value * 1000) / 1000} g/mol"
                    )

                    PropertyRow(
                        label = strings.period,
                        value = element.period.value.toString()
                    )

                    PropertyRow(
                        label = strings.group,
                        value = element.group.number.toString()
                    )

                    PropertyRow(
                        label = strings.category,
                        value = getCategoryString(element.category)
                    )
                }

                Spacer(modifier = Modifier.height(8.dp))

                // Close Button
                Button(
                    onClick = onDismiss,
                    modifier = Modifier.fillMaxWidth(),
                    colors = ButtonDefaults.buttonColors(
                        containerColor = MaterialTheme.colorScheme.primary,
                        contentColor = MaterialTheme.colorScheme.onPrimary
                    ),
                    shape = RetroShapes.Small
                ) {
                    Text(
                        text = strings.close,
                        style = MaterialTheme.typography.titleMedium.copy(
                            fontWeight = FontWeight.Bold
                        )
                    )
                }
            }
        }
    }
}

@Composable
private fun PropertyRow(
    label: String,
    value: String,
    modifier: Modifier = Modifier,
) {
    Row(
        modifier = modifier.fillMaxWidth(),
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "$label:",
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Medium
            ),
            color = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.7f)
        )
        Text(
            text = value,
            style = MaterialTheme.typography.bodyLarge.copy(
                fontWeight = FontWeight.Bold
            ),
            color = MaterialTheme.colorScheme.onSurface
        )
    }
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

@Composable
private fun getCategoryString(category: ElementCategory): String {
    val strings = strings()
    return when (category) {
        ElementCategory.ALKALI_METALS -> strings.alkaliMetals
        ElementCategory.ALKALINE_EARTH_METALS -> strings.alkalineEarthMetals
        ElementCategory.TRANSITION_METALS -> strings.transitionMetals
        ElementCategory.POST_TRANSITION_METALS -> strings.postTransitionMetals
        ElementCategory.METALLOIDS -> strings.metalloids
        ElementCategory.NON_METALS -> strings.nonMetals
        ElementCategory.HALOGENS -> strings.halogens
        ElementCategory.NOBLE_GASES -> strings.nobleGases
        ElementCategory.LANTHANIDES -> strings.lanthanides
        ElementCategory.ACTINIDES -> strings.actinides
        ElementCategory.UNKNOWN -> "Unknown"
    }
}
