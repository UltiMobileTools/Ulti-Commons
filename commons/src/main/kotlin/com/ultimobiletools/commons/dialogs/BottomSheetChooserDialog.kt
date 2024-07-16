package com.ultimobiletools.commons.dialogs

import android.os.Bundle
import android.view.ViewGroup
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ListItem
import androidx.compose.material3.ListItemDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import androidx.fragment.app.FragmentManager
import com.ultimobiletools.commons.R
import com.ultimobiletools.commons.adapters.setupUltiListItem
import com.ultimobiletools.commons.compose.dialog.dialogContainerColor
import com.ultimobiletools.commons.compose.dialog.dialogTextColor
import com.ultimobiletools.commons.compose.bottom.BottomSheetColumnDialogSurface
import com.ultimobiletools.commons.compose.bottom.BottomSheetDialogState
import com.ultimobiletools.commons.compose.bottom.BottomSheetSpacerEdgeToEdge
import com.ultimobiletools.commons.compose.bottom.rememberBottomSheetDialogState
import com.ultimobiletools.commons.compose.extensions.MyDevices
import com.ultimobiletools.commons.compose.theme.AppThemeSurface
import com.ultimobiletools.commons.compose.theme.UltiTheme
import com.ultimobiletools.commons.databinding.ItemUltiListBinding
import com.ultimobiletools.commons.fragments.BaseBottomSheetDialogFragment
import com.ultimobiletools.commons.models.UltiListItem
import kotlinx.collections.immutable.ImmutableList
import kotlinx.collections.immutable.toImmutableList

open class BottomSheetChooserDialog : BaseBottomSheetDialogFragment() {

    var onItemClick: ((UltiListItem) -> Unit)? = null

    override fun setupContentView(parent: ViewGroup) {
        val listItems = arguments?.getParcelableArray(ITEMS) as Array<UltiListItem>
        listItems.forEach { item ->
            val view = ItemUltiListBinding.inflate(layoutInflater, parent, false)
            setupUltiListItem(view, item) {
                onItemClick?.invoke(it)
            }
            parent.addView(view.root)
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        onItemClick = null
    }

    companion object {
        private const val TAG = "BottomSheetChooserDialog"
        private const val ITEMS = "data"

        fun createChooser(
            fragmentManager: FragmentManager,
            title: Int?,
            items: Array<UltiListItem>,
            callback: (UltiListItem) -> Unit
        ): BottomSheetChooserDialog {
            val extras = Bundle().apply {
                if (title != null) {
                    putInt(BOTTOM_SHEET_TITLE, title)
                }
                putParcelableArray(ITEMS, items)
            }
            return BottomSheetChooserDialog().apply {
                arguments = extras
                onItemClick = callback
                show(fragmentManager, TAG)
            }
        }
    }
}

@Composable
fun ChooserBottomSheetDialog(
    bottomSheetDialogState: BottomSheetDialogState,
    items: ImmutableList<UltiListItem>,
    modifier: Modifier = Modifier,
    onItemClicked: (UltiListItem) -> Unit
) {
    BottomSheetColumnDialogSurface(modifier) {
        Text(
            text = stringResource(id = R.string.please_select_destination),
            color = dialogTextColor,
            fontSize = 21.sp,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(UltiTheme.dimens.padding.extraLarge)
                .padding(top = UltiTheme.dimens.padding.large)
        )
        for (item in items) {
            val color = if (item.selected) UltiTheme.colorScheme.primary else UltiTheme.colorScheme.onSurface
            ListItem(
                modifier = Modifier
                    .clickable {
                        onItemClicked(item)
                        bottomSheetDialogState.close()
                    },
                headlineContent = {
                    Text(stringResource(id = item.textRes), color = color)
                },
                leadingContent = {
                    if (item.imageRes != null) {
                        Image(
                            painter = painterResource(id = item.imageRes),
                            contentDescription = stringResource(id = item.textRes),
                            colorFilter = ColorFilter.tint(color)
                        )
                    }
                },
                trailingContent = {
                    if (item.selected) {
                        Image(
                            painter = painterResource(id = R.drawable.ic_check_circle_vector),
                            contentDescription = null,
                            colorFilter = ColorFilter.tint(color)
                        )
                    }
                },
                colors = ListItemDefaults.colors(containerColor = dialogContainerColor)
            )
        }
        BottomSheetSpacerEdgeToEdge()
    }
}

@MyDevices
@Composable
private fun ChooserBottomSheetDialogPreview() {
    AppThemeSurface {
        val list = remember {
            listOf(
                UltiListItem(1, R.string.record_video, R.drawable.ic_camera_vector),
                UltiListItem(2, R.string.record_audio, R.drawable.ic_microphone_vector, selected = true),
                UltiListItem(4, R.string.choose_contact, R.drawable.ic_add_person_vector)
            ).toImmutableList()
        }
        ChooserBottomSheetDialog(bottomSheetDialogState = rememberBottomSheetDialogState(), items = list, onItemClicked = {})
    }
}
