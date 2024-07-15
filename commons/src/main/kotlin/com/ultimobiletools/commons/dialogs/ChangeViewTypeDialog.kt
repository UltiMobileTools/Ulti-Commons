package com.ultimobiletools.commons.dialogs

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.ultimobiletools.commons.R
import com.ultimobiletools.commons.activities.BaseUltiActivity
import com.ultimobiletools.commons.compose.dialog.AlertDialogState
import com.ultimobiletools.commons.compose.dialog.DialogSurface
import com.ultimobiletools.commons.compose.dialog.rememberAlertDialogState
import com.ultimobiletools.commons.compose.components.RadioGroupDialogComponent
import com.ultimobiletools.commons.compose.extensions.MyDevices
import com.ultimobiletools.commons.compose.theme.AppThemeSurface
import com.ultimobiletools.commons.compose.theme.UltiTheme
import com.ultimobiletools.commons.databinding.DialogChangeViewTypeBinding
import com.ultimobiletools.commons.extensions.baseConfig
import com.ultimobiletools.commons.extensions.getAlertDialogBuilder
import com.ultimobiletools.commons.extensions.setupDialogStuff
import com.ultimobiletools.commons.helpers.VIEW_TYPE_GRID
import com.ultimobiletools.commons.helpers.VIEW_TYPE_LIST
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

class ChangeViewTypeDialog(val activity: BaseUltiActivity, val callback: () -> Unit) {
    private var view: DialogChangeViewTypeBinding
    private var config = activity.baseConfig

    init {
        view = DialogChangeViewTypeBinding.inflate(activity.layoutInflater, null, false).apply {
            val viewToCheck = when (config.viewType) {
                VIEW_TYPE_GRID -> changeViewTypeDialogRadioGrid.id
                else -> changeViewTypeDialogRadioList.id
            }

            changeViewTypeDialogRadio.check(viewToCheck)
        }

        activity.getAlertDialogBuilder()
            .setPositiveButton(R.string.ok) { _, _ -> dialogConfirmed() }
            .setNegativeButton(R.string.cancel, null)
            .apply {
                activity.setupDialogStuff(view.root, this)
            }
    }

    private fun dialogConfirmed() {
        val viewType = if (view.changeViewTypeDialogRadioGrid.isChecked) {
            VIEW_TYPE_GRID
        } else {
            VIEW_TYPE_LIST
        }
        config.viewType = viewType
        callback()
    }
}

@Immutable
data class ViewType(val title: String, val type: Int)

@Composable
fun ChangeViewTypeAlertDialog(
    alertDialogState: AlertDialogState,
    selectedViewType: Int,
    modifier: Modifier = Modifier,
    onTypeChosen: (type: Int) -> Unit
) {
    val context = LocalContext.current
    val items = remember {
        listOf(
            ViewType(title = context.getString(R.string.grid), type = VIEW_TYPE_GRID),
            ViewType(title = context.getString(R.string.list), type = VIEW_TYPE_LIST)
        ).toImmutableList()
    }

    val groupTitles by remember {
        derivedStateOf { items.map { it.title } }
    }
    val (selected, setSelected) = remember { mutableStateOf(items.firstOrNull { it.type == selectedViewType }?.title) }
    AlertDialog(onDismissRequest = alertDialogState::hide) {
        DialogSurface {
            Column(
                modifier = modifier
                    .padding(bottom = 18.dp)
                    .verticalScroll(rememberScrollState())
            ) {
                RadioGroupDialogComponent(
                    items = groupTitles,
                    selected = selected,
                    setSelected = { selectedTitle ->
                        setSelected(selectedTitle)
                    },
                    modifier = Modifier.padding(
                        vertical = UltiTheme.dimens.padding.extraLarge,
                    ),
                    verticalPadding = UltiTheme.dimens.padding.extraLarge,
                )
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.End,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(end = UltiTheme.dimens.padding.extraLarge)
                ) {
                    TextButton(onClick = {
                        alertDialogState.hide()
                    }) {
                        Text(text = stringResource(id = R.string.cancel))
                    }

                    TextButton(onClick = {
                        alertDialogState.hide()
                        onTypeChosen(getSelectedValue(items, selected))
                    }) {
                        Text(text = stringResource(id = R.string.ok))
                    }
                }
            }
        }
    }
}

private fun getSelectedValue(
    items: ImmutableList<ViewType>,
    selected: String?
) = items.first { it.title == selected }.type

@MyDevices
@Composable
private fun ChangeViewTypeAlertDialogPreview() {
    AppThemeSurface {
        ChangeViewTypeAlertDialog(alertDialogState = rememberAlertDialogState(), selectedViewType = VIEW_TYPE_GRID) {}
    }
}
