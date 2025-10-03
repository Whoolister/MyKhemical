package dev.whoolister.mykhemical.ui.component

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.spring
import androidx.compose.animation.core.Spring
import androidx.compose.foundation.BorderStroke
import androidx.compose.foundation.gestures.detectDragGestures
import androidx.compose.foundation.gestures.detectTransformGestures
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDownward
import androidx.compose.material.icons.filled.ZoomIn
import androidx.compose.material.icons.filled.ZoomOut
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.Alignment
import androidx.compose.ui.input.pointer.pointerInput
import androidx.compose.ui.layout.Layout
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import dev.whoolister.mykhemical.model.elements.Element
import dev.whoolister.mykhemical.model.elements.ElementCategory
import dev.whoolister.mykhemical.model.table.PeriodicTable
import dev.whoolister.mykhemical.model.table.PeriodicTable.ElementItem
import dev.whoolister.mykhemical.model.table.PeriodicTable.BlankItem
import dev.whoolister.mykhemical.model.table.PeriodicTable.LanthanideGroupItem
import dev.whoolister.mykhemical.model.table.PeriodicTable.ActinideGroupItem
import dev.whoolister.mykhemical.model.table.PeriodicTable.GapRowItem
import dev.whoolister.mykhemical.ui.theme.ElementColors
import dev.whoolister.mykhemical.ui.theme.RetroShapes
import dev.whoolister.mykhemical.i18n.strings
import kotlinx.coroutines.launch
import kotlin.math.round

@Composable
fun PeriodicTableComponent(
    modifier: Modifier = Modifier,
) {
    // State for selected element
    var selectedElement by remember { mutableStateOf<Element?>(null) }

    BoxWithConstraints(modifier = modifier) {
        val screenWidth = maxWidth
        val screenHeight = maxHeight

        // Calculate base card dimensions - fit 2 cards on screen when at default zoom
        val cardSizePercent = 0.45f
        val cardSpacing = 16.dp

        // Make cards square by using the smaller dimension
        val baseCardSize = minOf(screenWidth * cardSizePercent, screenHeight * cardSizePercent)

        PeriodicTableContent(
            baseCardWidth = baseCardSize,
            baseCardHeight = baseCardSize,
            cardSpacing = cardSpacing,
            screenWidth = screenWidth,
            screenHeight = screenHeight,
            onElementClick = { element -> selectedElement = element }
        )

        // Show ElementDetailDialog when an element is selected
        selectedElement?.let { element ->
            ElementDetailDialog(
                element = element,
                onDismiss = { selectedElement = null }
            )
        }
    }
}

@Composable
fun GroupIndicatorCard(
    label: String,
    category: ElementCategory,
    width: Dp,
    height: Dp,
    modifier: Modifier = Modifier
) {
    val backgroundColor = when (category) {
        ElementCategory.LANTHANIDES -> ElementColors.Lanthanides
        ElementCategory.ACTINIDES -> ElementColors.Actinides
        else -> ElementColors.Unknown
    }
    val borderColor = MaterialTheme.colorScheme.outline
    val border = BorderStroke(2.dp, borderColor)

    Card(
        modifier = modifier.size(width, height),
        shape = RetroShapes.Small,
        border = border,
        colors = CardDefaults.cardColors(
            containerColor = backgroundColor
        ),
        elevation = CardDefaults.cardElevation(defaultElevation = 0.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {
            Text(
                text = label,
                style = MaterialTheme.typography.titleMedium.copy(
                    fontSize = 14.sp,
                    fontWeight = FontWeight.Bold
                ),
                color = MaterialTheme.colorScheme.onSurface,
                textAlign = TextAlign.Center
            )
            Spacer(modifier = Modifier.height(4.dp))
            Icon(
                imageVector = Icons.Filled.ArrowDownward,
                contentDescription = "Down arrow",
                tint = MaterialTheme.colorScheme.onSurface.copy(alpha = 0.8f)
            )
        }
    }
}

@Composable
private fun PeriodicTableContent(
    baseCardWidth: Dp,
    baseCardHeight: Dp,
    cardSpacing: Dp,
    screenWidth: Dp,
    screenHeight: Dp,
    onElementClick: (Element) -> Unit
) {
    val strings = strings()

    // Get table structure from PeriodicTable
    val tableRows = remember {
        PeriodicTable.toList()
    }
    val periods = tableRows.size
    val groups = if (tableRows.isNotEmpty()) tableRows[0].size else 0

    // Create animated scroll offsets for smooth snapping
    val horizontalOffset = remember { Animatable(0f) }
    val verticalOffset = remember { Animatable(0f) }

    // Save scroll position before zooming out to restore later
    var savedHorizontalOffset by remember { mutableStateOf(0f) }
    var savedVerticalOffset by remember { mutableStateOf(0f) }

    val density = LocalDensity.current

    // Padding to add when fully zoomed out
    val zoomedOutPadding = 32.dp
    val zoomedOutPaddingPx = with(density) { zoomedOutPadding.toPx() }

    // Calculate minimum scale to fit entire table on screen with padding
    val minScaleX = with(density) {
        (screenWidth.toPx() - zoomedOutPaddingPx * 2) / (baseCardWidth.toPx() * groups + cardSpacing.toPx() * groups)
    }
    val minScaleY = with(density) {
        (screenHeight.toPx() - zoomedOutPaddingPx * 2) / (baseCardHeight.toPx() * periods + cardSpacing.toPx() * periods)
    }
    val minScale = minOf(minScaleX, minScaleY).coerceAtMost(0.3f)

    // Zoom scale state - starts zoomed out to show entire table
    val scale = remember { Animatable(minScale) }
    val coroutineScope = rememberCoroutineScope()

    // Calculate dynamic card size based on zoom level
    val cardWidth = baseCardWidth * scale.value
    val cardHeight = baseCardHeight * scale.value
    val dynamicCardSpacing = cardSpacing * scale.value

    // Cell size for snapping calculation (card size + spacing)
    val cellWidth = cardWidth + dynamicCardSpacing
    val cellHeight = cardHeight + dynamicCardSpacing

    val cellWidthPx = with(density) { cellWidth.toPx() }
    val cellHeightPx = with(density) { cellHeight.toPx() }

    BoxWithConstraints(modifier = Modifier.fillMaxSize()) {
        val viewportWidthPx = with(density) { maxWidth.toPx() }
        val viewportHeightPx = with(density) { maxHeight.toPx() }

        // Calculate max scroll bounds - content size minus viewport size
        val totalContentWidth = with(density) { (cellWidth * groups).toPx() }
        val totalContentHeight = with(density) { (cellHeight * periods).toPx() }

        val maxHorizontalScroll = (totalContentWidth - viewportWidthPx).coerceAtLeast(0f)
        val maxVerticalScroll = (totalContentHeight - viewportHeightPx).coerceAtLeast(0f)

        // Track if we're currently snapping to prevent scroll conflicts
        var isSnapping by remember { mutableStateOf(false) }
        var isZooming by remember { mutableStateOf(false) }

        // Function to snap to nearest cell with smooth animation
        fun snapToNearestCell() {
            if (isSnapping || isZooming) return

            coroutineScope.launch {
                isSnapping = true

                // Calculate nearest horizontal snap position
                val nearestHorizontalCell = round(horizontalOffset.value / cellWidthPx)
                val targetHorizontal = (nearestHorizontalCell * cellWidthPx).coerceIn(0f, maxHorizontalScroll)

                // Calculate nearest vertical snap position
                val nearestVerticalCell = round(verticalOffset.value / cellHeightPx)
                val targetVertical = (nearestVerticalCell * cellHeightPx).coerceIn(0f, maxVerticalScroll)

                // Animate to snap positions with spring animation
                launch {
                    horizontalOffset.animateTo(
                        targetValue = targetHorizontal,
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                }

                launch {
                    verticalOffset.animateTo(
                        targetValue = targetVertical,
                        animationSpec = spring(
                            dampingRatio = Spring.DampingRatioMediumBouncy,
                            stiffness = Spring.StiffnessLow
                        )
                    )
                }

                isSnapping = false
            }
        }

        // Function to toggle between full view and normal view
        fun toggleZoom() {
            coroutineScope.launch {
                isZooming = true

                // If zoomed out, zoom in to default; if zoomed in, zoom out to see all
                val targetScale = if (scale.value < 0.9f) {
                    1f // Zoom to default
                } else {
                    minScale // Zoom to see entire table
                }

                // Save scroll position before zooming out
                if (targetScale < 0.9f) {
                    savedHorizontalOffset = horizontalOffset.value
                    savedVerticalOffset = verticalOffset.value
                }

                // Calculate new max scroll bounds after zoom for target scale
                val newTotalContentWidth =
                    with(density) { (baseCardWidth * targetScale + cardSpacing * targetScale).toPx() * groups }
                val newTotalContentHeight =
                    with(density) { (baseCardHeight * targetScale + cardSpacing * targetScale).toPx() * periods }
                val newMaxHorizontalScroll = (newTotalContentWidth - viewportWidthPx).coerceAtLeast(0f)
                val newMaxVerticalScroll = (newTotalContentHeight - viewportHeightPx).coerceAtLeast(0f)

                if (targetScale >= 0.9f) {
                    // If zooming back in to default, restore the saved scroll position simultaneously with zoom
                    val newHorizontal = savedHorizontalOffset.coerceIn(0f, newMaxHorizontalScroll)
                    val newVertical = savedVerticalOffset.coerceIn(0f, newMaxVerticalScroll)

                    // Animate zoom and scroll position simultaneously
                    launch {
                        scale.animateTo(
                            targetValue = targetScale,
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        )
                        isZooming = false
                    }

                    launch {
                        horizontalOffset.animateTo(
                            targetValue = newHorizontal,
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        )
                    }

                    launch {
                        verticalOffset.animateTo(
                            targetValue = newVertical,
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        )
                    }
                } else {
                    // If zooming out to see all, smoothly animate to center simultaneously with zoom
                    launch {
                        scale.animateTo(
                            targetValue = targetScale,
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        )
                        isZooming = false
                    }

                    launch {
                        horizontalOffset.animateTo(
                            targetValue = 0f,
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        )
                    }

                    launch {
                        verticalOffset.animateTo(
                            targetValue = 0f,
                            animationSpec = spring(
                                dampingRatio = Spring.DampingRatioMediumBouncy,
                                stiffness = Spring.StiffnessMedium
                            )
                        )
                    }
                }
            }
        }

        Box(
            modifier = Modifier.fillMaxSize()
        ) {
            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .pointerInput(maxHorizontalScroll, maxVerticalScroll) {
                        // Handle pinch-to-zoom gestures
                        detectTransformGestures(
                            onGesture = { centroid, pan, zoom, _ ->
                                if (zoom != 1f) {
                                    isZooming = true
                                    coroutineScope.launch {
                                        // Maximum scale (2x zoom in)
                                        val maxScale = 2f

                                        val newScale = (scale.value * zoom).coerceIn(minScale, maxScale)

                                        // Adjust scroll position to zoom towards centroid
                                        val oldScale = scale.value
                                        if (oldScale != newScale) {
                                            // Calculate the position relative to content
                                            val contentX = horizontalOffset.value + centroid.x
                                            val contentY = verticalOffset.value + centroid.y

                                            // Apply new scale
                                            scale.snapTo(newScale)

                                            // Adjust scroll to maintain centroid position
                                            val scaleRatio = newScale / oldScale
                                            val newContentX = contentX * scaleRatio
                                            val newContentY = contentY * scaleRatio

                                            val newHorizontal =
                                                (newContentX - centroid.x).coerceIn(0f, maxHorizontalScroll)
                                            val newVertical = (newContentY - centroid.y).coerceIn(0f, maxVerticalScroll)

                                            horizontalOffset.snapTo(newHorizontal)
                                            verticalOffset.snapTo(newVertical)
                                        }
                                    }
                                } else if ((pan.x != 0f || pan.y != 0f) && !isZooming) {
                                    // Handle panning when not zooming, only if content doesn't fit on screen
                                    coroutineScope.launch {
                                        // Only apply horizontal pan if content is wider than viewport
                                        val newHorizontal = if (maxHorizontalScroll > 0f) {
                                            (horizontalOffset.value - pan.x).coerceIn(0f, maxHorizontalScroll)
                                        } else {
                                            0f // Content fits horizontally, don't scroll
                                        }

                                        // Only apply vertical pan if content is taller than viewport
                                        val newVertical = if (maxVerticalScroll > 0f) {
                                            (verticalOffset.value - pan.y).coerceIn(0f, maxVerticalScroll)
                                        } else {
                                            0f // Content fits vertically, don't scroll
                                        }

                                        horizontalOffset.snapTo(newHorizontal)
                                        verticalOffset.snapTo(newVertical)
                                    }
                                }
                            }
                        )
                    }
                    .pointerInput(scale.value, maxHorizontalScroll, maxVerticalScroll) {
                        // Only enable drag gestures when zoomed in enough AND content doesn't fit on screen
                        if (scale.value >= 0.8f && (maxHorizontalScroll > 0f || maxVerticalScroll > 0f)) {
                            detectDragGestures(
                                onDragEnd = {
                                    if (!isZooming) {
                                        isZooming = false
                                        snapToNearestCell()
                                    }
                                },
                                onDragCancel = {
                                    if (!isZooming) {
                                        isZooming = false
                                        snapToNearestCell()
                                    }
                                }
                            ) { change, dragAmount ->
                                if (!isZooming) {
                                    change.consume()

                                    // Update scroll offsets (negative because drag direction is opposite to scroll)
                                    coroutineScope.launch {
                                        // Only apply horizontal drag if content is wider than viewport
                                        val newHorizontal = if (maxHorizontalScroll > 0f) {
                                            (horizontalOffset.value - dragAmount.x).coerceIn(0f, maxHorizontalScroll)
                                        } else {
                                            0f
                                        }

                                        // Only apply vertical drag if content is taller than viewport
                                        val newVertical = if (maxVerticalScroll > 0f) {
                                            (verticalOffset.value - dragAmount.y).coerceIn(0f, maxVerticalScroll)
                                        } else {
                                            0f
                                        }

                                        horizontalOffset.snapTo(newHorizontal)
                                        verticalOffset.snapTo(newVertical)
                                    }
                                }
                            }
                        }
                    }
            ) {
                Layout(
                    content = {
                        // Create all cells from the periodic table rows
                        for (row in tableRows) {
                            for (item in row) {
                                when (item) {
                                    is ElementItem -> {
                                        // Use different card sizes based on zoom level
                                        val cardSize = when {
                                            scale.value < 0.4f -> ElementCardSize.Small
                                            scale.value < 0.8f -> ElementCardSize.Medium
                                            else -> ElementCardSize.Large
                                        }

                                        ElementCard(
                                            element = item.element,
                                            size = cardSize,
                                            onClick = { onElementClick(item.element) },
                                            modifier = Modifier
                                                .size(cardWidth, cardHeight)
                                        )
                                    }

                                    is BlankItem -> {
                                        Spacer(
                                            modifier = Modifier
                                                .size(cardWidth, cardHeight)
                                        )
                                    }

                                    is LanthanideGroupItem -> {
                                        GroupIndicatorCard(
                                            label = strings.lanthanides,
                                            category = ElementCategory.LANTHANIDES,
                                            width = cardWidth,
                                            height = cardHeight,
                                            modifier = Modifier.size(cardWidth, cardHeight)
                                        )
                                    }

                                    is ActinideGroupItem -> {
                                        GroupIndicatorCard(
                                            label = strings.actinides,
                                            category = ElementCategory.ACTINIDES,
                                            width = cardWidth,
                                            height = cardHeight,
                                            modifier = Modifier.size(cardWidth, cardHeight)
                                        )
                                    }
                                    is GapRowItem -> {
                                        Spacer(
                                            modifier = Modifier
                                                .height(cardHeight / 2)
                                        )
                                    }
                                }
                            }
                        }
                    },
                    modifier = Modifier.fillMaxSize()
                ) { measurables, constraints ->
                    // Measure all children
                    val placeables = measurables.map { measurable ->
                        measurable.measure(constraints.copy(minWidth = 0, minHeight = 0))
                    }

                    val cellWidthPxInt = cellWidthPx.toInt()
                    val cellHeightPxInt = cellHeightPx.toInt()
                    val cardSpacingPxInt = with(density) { dynamicCardSpacing.toPx().toInt() }

                    layout(constraints.maxWidth, constraints.maxHeight) {
                        var index = 0

                        // Calculate centering offset when content fits on screen
                        val totalContentWidthInt = (groups * cellWidthPxInt)
                        val totalContentHeightInt = (periods * cellHeightPxInt)

                        val centerOffsetX = if (maxHorizontalScroll == 0f) {
                            ((constraints.maxWidth - totalContentWidthInt) / 2).coerceAtLeast(0)
                        } else {
                            0
                        }

                        val centerOffsetY = if (maxVerticalScroll == 0f) {
                            ((constraints.maxHeight - totalContentHeightInt) / 2).coerceAtLeast(0)
                        } else {
                            0
                        }

                        // Place all cells using row/column structure
                        var cumulativeY = 0
                        for (periodIndex in tableRows.indices) {
                            val row = tableRows[periodIndex]

                            // Check if this is a gap row to use half height
                            val isGapRow = row.isNotEmpty() && row[0] is GapRowItem
                            val rowHeight = if (isGapRow) cellHeightPxInt / 2 else cellHeightPxInt

                            for (groupIndex in row.indices) {
                                if (index < placeables.size) {
                                    val placeable = placeables[index]

                                    // Calculate position with scroll offset and centering
                                    val x = centerOffsetX +
                                            (groupIndex * cellWidthPxInt + cardSpacingPxInt / 2 - horizontalOffset.value.toInt())
                                    val y = centerOffsetY +
                                            (cumulativeY + cardSpacingPxInt / 2 - verticalOffset.value.toInt())

                                    // Only place if visible
                                    if (x + placeable.width > 0 && x < constraints.maxWidth &&
                                        y + placeable.height > 0 && y < constraints.maxHeight
                                    ) {
                                        placeable.place(x, y)
                                    }

                                    index++
                                }
                            }

                            // Update cumulative Y for next row
                            cumulativeY += rowHeight
                        }
                    }
                }
            }

            // Floating action button to toggle zoom
            FloatingActionButton(
                onClick = { toggleZoom() },
                modifier = Modifier
                    .align(Alignment.BottomEnd)
                    .padding(16.dp),
                containerColor = MaterialTheme.colorScheme.primaryContainer,
                contentColor = MaterialTheme.colorScheme.onPrimaryContainer
            ) {
                Icon(
                    imageVector = if (scale.value < 0.9f) Icons.Filled.ZoomIn else Icons.Filled.ZoomOut,
                    contentDescription = "Zoom toggle"
                )
            }
        }
    }
}