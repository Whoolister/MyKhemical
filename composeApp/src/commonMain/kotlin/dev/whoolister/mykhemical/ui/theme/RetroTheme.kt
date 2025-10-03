package dev.whoolister.mykhemical.ui.theme

import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Typography
import androidx.compose.material3.darkColorScheme
import androidx.compose.material3.lightColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.runtime.compositionLocalOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import org.jetbrains.compose.ui.tooling.preview.Preview

// Retro Color Palette
object RetroColors {
    // Primary neon colors - brighter and more vibrant
    val CrtGreen = Color(0xFF00FF00)  // Pure neon green
    val CrtAmber = Color(0xFFFFB000)
    val CrtCyan = Color(0xFF00FFFF)
    val CrtMagenta = Color(0xFFFF00FF)
    val CrtYellow = Color(0xFFFFFF00)
    val CrtRed = Color(0xFFFF0055)
    val CrtBlue = Color(0xFF0099FF)
    val CrtPurple = Color(0xFF9D00FF)

    // Darker backgrounds for true retro terminal feel
    val DarkBackground = Color(0xFF0A0A0A)  // Nearly pure black
    val DarkSurface = Color(0xFF121212)
    val DarkSurfaceVariant = Color(0xFF1A1A1A)
    val LightText = Color(0xFFE8E8E8)
    val ShadowColor = Color(0xFF000000)
    val BorderColor = Color(0xFF00FF00)  // Neon green borders

    // Glow colors for effects
    val GlowGreen = Color(0xFF00FF00)
    val GlowAmber = Color(0xFFFFB000)
}

@Preview
@Composable
fun PreviewRetroThemeDark() {
    RetroTheme(isDarkTheme = true) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "RetroTheme Dark",
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Sample text using theme colors.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Secondary accent",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

@Preview
@Composable
fun PreviewRetroThemeLight() {
    RetroTheme(isDarkTheme = false) {
        Surface(
            modifier = Modifier.fillMaxSize()
        ) {
            Column(
                modifier = Modifier.fillMaxSize().padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {
                Text(
                    text = "RetroTheme Light",
                    style = MaterialTheme.typography.displayLarge,
                    color = MaterialTheme.colorScheme.primary
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Sample text using theme colors.",
                    style = MaterialTheme.typography.bodyLarge,
                    color = MaterialTheme.colorScheme.onBackground
                )
                Spacer(modifier = Modifier.height(12.dp))
                Text(
                    text = "Secondary accent",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.secondary
                )
            }
        }
    }
}

// Element Category Colors
object ElementColors {
    val AlkaliMetals = Color(0xFFCC0033)  // Deep red
    val AlkalineEarthMetals = Color(0xFFCC6600)  // Deep orange
    val TransitionMetals = Color(0xFF006666)  // Dark teal
    val PostTransitionMetals = Color(0xFF0033CC)  // Deep blue
    val Metalloids = Color(0xFF339900)  // Dark green
    val NonMetals = Color(0xFF996600)  // Brown
    val Halogens = Color(0xFF993366)  // Dark magenta
    val NobleGases = Color(0xFF663399)  // Dark purple
    val Lanthanides = Color(0xFF660066)  // Deep purple
    val Actinides = Color(0xFF009933)  // Forest green
    val Unknown = Color(0xFF666666)  // Dark gray
}

private val RetroLightColorScheme = lightColorScheme(
    primary = Color(0xFF00AA00),  // Darker green for light mode
    onPrimary = Color(0xFFFFFFFF),
    primaryContainer = Color(0xFFE8E8E0),
    onPrimaryContainer = Color(0xFF003300),
    secondary = Color(0xFFCC8800),  // Darker amber
    onSecondary = Color(0xFFFFFFFF),
    background = Color(0xFFFAFAF0),  // Cream/beige terminal color
    onBackground = Color(0xFF0A0A0A),
    surface = Color(0xFFFFFFFF),
    onSurface = Color(0xFF0A0A0A),
    surfaceVariant = Color(0xFFE8E8E0),
    onSurfaceVariant = Color(0xFF1A1A1A),
    outline = Color(0xFF00AA00)
)

private val RetroDarkColorScheme = darkColorScheme(
    primary = RetroColors.CrtGreen,
    onPrimary = Color(0xFF000000),
    primaryContainer = RetroColors.DarkSurface,
    onPrimaryContainer = RetroColors.CrtGreen,
    secondary = RetroColors.CrtAmber,
    onSecondary = Color(0xFF000000),
    tertiary = RetroColors.CrtCyan,
    onTertiary = Color(0xFF000000),
    background = RetroColors.DarkBackground,
    onBackground = RetroColors.LightText,
    surface = RetroColors.DarkSurface,
    onSurface = RetroColors.LightText,
    surfaceVariant = RetroColors.DarkSurfaceVariant,
    onSurfaceVariant = RetroColors.LightText,
    outline = RetroColors.BorderColor,
    error = RetroColors.CrtRed,
    onError = Color(0xFF000000)
)

private val RetroTypography = Typography(
    displayLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 28.sp,
        letterSpacing = 1.5.sp
    ),
    displayMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp,
        letterSpacing = 1.2.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp,
        letterSpacing = 1.0.sp
    ),
    titleLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Bold,
        fontSize = 18.sp,
        letterSpacing = 0.8.sp
    ),
    titleMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 16.sp,
        letterSpacing = 0.5.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp,
        letterSpacing = 0.25.sp
    ),
    bodyMedium = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp,
        letterSpacing = 0.25.sp
    ),
    labelLarge = TextStyle(
        fontFamily = FontFamily.Monospace,
        fontWeight = FontWeight.Medium,
        fontSize = 10.sp,
        letterSpacing = 0.1.sp
    )
)

object RetroShapes {
    val None = RoundedCornerShape(0.dp)
    val Small = RoundedCornerShape(1.dp)
    val Medium = RoundedCornerShape(2.dp)
}

@Composable
fun RetroTheme(
    isDarkTheme: Boolean = true,
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colorScheme = if (isDarkTheme) RetroDarkColorScheme else RetroLightColorScheme,
        typography = RetroTypography,
        content = content
    )
}

// Theme Mode Management
enum class ThemeMode {
    LIGHT,
    DARK,
    SYSTEM
}

data class ThemeState(
    val themeMode: ThemeMode,
    val setThemeMode: (ThemeMode) -> Unit
)

val LocalThemeMode = compositionLocalOf { ThemeMode.DARK }
val LocalThemeState = compositionLocalOf<ThemeState?> { null }

@Composable
fun ThemeProvider(
    initialThemeMode: ThemeMode = ThemeMode.DARK,
    content: @Composable () -> Unit
) {
    var currentThemeMode by remember { mutableStateOf(initialThemeMode) }

    val themeState = remember {
        ThemeState(
            themeMode = currentThemeMode,
            setThemeMode = { newTheme -> currentThemeMode = newTheme }
        )
    }

    val isDarkTheme = when (currentThemeMode) {
        ThemeMode.DARK -> true
        ThemeMode.LIGHT -> false
        ThemeMode.SYSTEM -> true // Default to dark for system
    }

    CompositionLocalProvider(
        LocalThemeMode provides currentThemeMode,
        LocalThemeState provides themeState.copy(themeMode = currentThemeMode)
    ) {
        RetroTheme(isDarkTheme = isDarkTheme) {
            content()
        }
    }
}