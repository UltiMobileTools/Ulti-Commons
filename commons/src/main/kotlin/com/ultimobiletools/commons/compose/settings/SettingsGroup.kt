package com.ultimobiletools.commons.compose.settings

import androidx.compose.foundation.layout.*
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.ProvideTextStyle
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.ultimobiletools.commons.compose.extensions.MyDevices
import com.ultimobiletools.commons.compose.theme.UltiTheme

@Composable
fun SettingsGroup(
    modifier: Modifier = Modifier,
    title: @Composable (() -> Unit)? = null,
    content: @Composable ColumnScope.() -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
    ) {
        if (title != null) {
            SettingsGroupTitle(title = title)
        }
        content()
    }
}

@Composable
fun SettingsGroupTitle(
    modifier: Modifier = Modifier,
    title: @Composable () -> Unit
) {
    Box(
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = UltiTheme.dimens.padding.extraLarge),
        contentAlignment = Alignment.CenterStart
    ) {
        val primary = UltiTheme.colorScheme.primary
        val titleStyle = UltiTheme.typography.headlineMedium.copy(color = primary)
        ProvideTextStyle(value = titleStyle) { title() }
    }
}

@MyDevices
@Composable
private fun SettingsGroupPreview() {
    MaterialTheme {
        SettingsGroup(
            title = { Text(text = "Title") }
        ) {
            Box(
                modifier = Modifier
                    .height(64.dp)
                    .fillMaxWidth(),
                contentAlignment = Alignment.Center,
            ) {
                Text(text = "Settings group")
            }
        }
    }
}
