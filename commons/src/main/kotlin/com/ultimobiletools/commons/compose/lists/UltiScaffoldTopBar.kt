package com.ultimobiletools.commons.compose.lists

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.filled.ArrowBack
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.platform.LocalLayoutDirection
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.style.TextOverflow
import com.ultimobiletools.commons.R
import com.ultimobiletools.commons.compose.extensions.MyDevices
import com.ultimobiletools.commons.compose.extensions.rememberMutableInteractionSource
import com.ultimobiletools.commons.compose.theme.AppThemeSurface
import com.ultimobiletools.commons.compose.theme.UltiTheme

@Composable
fun UltiScaffoldTopBar(
    modifier: Modifier = Modifier,
    title: String,
    scrolledColor: Color,
    navigationIconInteractionSource: MutableInteractionSource = rememberMutableInteractionSource(),
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState()),
    statusBarColor: Int,
    colorTransitionFraction: Float,
    contrastColor: Color,
    goBack: () -> Unit,
) {
    TopAppBar(
        title = {
            Text(
                text = title,
                modifier = Modifier
                    .padding(start = UltiTheme.dimens.padding.medium)
                    .fillMaxWidth(),
                color = scrolledColor,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis
            )
        },
        navigationIcon = {
            UltiNavigationIcon(
                goBack = goBack,
                navigationIconInteractionSource = navigationIconInteractionSource,
                iconColor = scrolledColor
            )
        },
        scrollBehavior = scrollBehavior,
        colors = ultiTopAppBarColors(statusBarColor, colorTransitionFraction, contrastColor),
        modifier = modifier.topAppBarPaddings(),
        windowInsets = topAppBarInsets()
    )
}

@Composable
fun UltiScaffoldTopBar(
    modifier: Modifier = Modifier,
    title: @Composable (scrolledColor: Color) -> Unit,
    scrolledColor: Color,
    navigationIconInteractionSource: MutableInteractionSource = rememberMutableInteractionSource(),
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState()),
    statusBarColor: Int,
    colorTransitionFraction: Float,
    contrastColor: Color,
    goBack: () -> Unit,
) {
    TopAppBar(
        title = {
            title(scrolledColor)
        },
        navigationIcon = {
            UltiNavigationIcon(
                goBack = goBack,
                navigationIconInteractionSource = navigationIconInteractionSource,
                iconColor = scrolledColor
            )
        },
        scrollBehavior = scrollBehavior,
        colors = ultiTopAppBarColors(statusBarColor, colorTransitionFraction, contrastColor),
        modifier = modifier.topAppBarPaddings(),
        windowInsets = topAppBarInsets()
    )
}

@Composable
fun UltiScaffoldTopBar(
    modifier: Modifier = Modifier,
    title: @Composable (scrolledColor: Color) -> Unit,
    actions: @Composable RowScope.() -> Unit,
    scrolledColor: Color,
    navigationIconInteractionSource: MutableInteractionSource = rememberMutableInteractionSource(),
    scrollBehavior: TopAppBarScrollBehavior = TopAppBarDefaults.pinnedScrollBehavior(rememberTopAppBarState()),
    statusBarColor: Int,
    colorTransitionFraction: Float,
    contrastColor: Color,
    goBack: () -> Unit,
) {
    TopAppBar(
        title = {
            title(scrolledColor)
        },
        navigationIcon = {
            UltiNavigationIcon(
                goBack = goBack,
                navigationIconInteractionSource = navigationIconInteractionSource,
                iconColor = scrolledColor
            )
        },
        actions = actions,
        scrollBehavior = scrollBehavior,
        colors = ultiTopAppBarColors(statusBarColor, colorTransitionFraction, contrastColor),
        modifier = modifier.topAppBarPaddings(),
        windowInsets = topAppBarInsets()
    )
}

@Composable
fun ultiTopAppBarColors(
    statusBarColor: Int,
    colorTransitionFraction: Float,
    contrastColor: Color
) = TopAppBarDefaults.topAppBarColors(
    scrolledContainerColor = Color(statusBarColor),
    containerColor = if (colorTransitionFraction == 1f) contrastColor else UltiTheme.colorScheme.surface,
    navigationIconContentColor = if (colorTransitionFraction == 1f) contrastColor else UltiTheme.colorScheme.surface
)

@Composable
fun topAppBarInsets() = TopAppBarDefaults.windowInsets.exclude(WindowInsets.navigationBars)

@Composable
fun Modifier.topAppBarPaddings(
    paddingValues: PaddingValues = WindowInsets.navigationBars.asPaddingValues()
): Modifier {
    val layoutDirection = LocalLayoutDirection.current
    return padding(
        top = paddingValues.calculateTopPadding(),
        start = paddingValues.calculateStartPadding(layoutDirection),
        end = paddingValues.calculateEndPadding(layoutDirection)
    )
}

@Composable
fun UltiNavigationIcon(
    modifier: Modifier = Modifier,
    navigationIconInteractionSource: MutableInteractionSource = rememberMutableInteractionSource(),
    goBack: () -> Unit,
    iconColor: Color? = null
) {
    Box(
        modifier
            .padding(start = UltiTheme.dimens.padding.medium)
            .clip(RoundedCornerShape(50))
            .clickable(
                navigationIconInteractionSource, rememberRipple(
                    color = UltiTheme.colorScheme.onSurface,
                    bounded = true
                )
            ) { goBack() }
    ) {
        UltiBackIcon(iconColor)
    }
}

@Composable
fun UltiBackIcon(iconColor: Color?) {
    if (iconColor == null) {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = stringResource(id = R.string.back),
            modifier = Modifier.padding(UltiTheme.dimens.padding.small)
        )
    } else {
        Icon(
            imageVector = Icons.AutoMirrored.Filled.ArrowBack, contentDescription = stringResource(id = R.string.back),
            tint = iconColor,
            modifier = Modifier.padding(UltiTheme.dimens.padding.small)
        )
    }
}


@Composable
@MyDevices
private fun UltiScaffoldTopBarPreview() {
    AppThemeSurface {
        UltiScaffoldTopBar(
            title = "SettingsScaffoldTopBar",
            scrolledColor = Color.Black,
            navigationIconInteractionSource = rememberMutableInteractionSource(),
            goBack = {},
            statusBarColor = Color.Magenta.toArgb(),
            colorTransitionFraction = 1.0f,
            contrastColor = Color.Gray
        )
    }
}
