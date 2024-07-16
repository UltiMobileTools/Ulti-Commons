package com.ultimobiletools.commons.adapters

import android.app.Activity
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.ultimobiletools.commons.extensions.*
import com.ultimobiletools.commons.models.UltiListItem
import com.ultimobiletools.commons.R
import com.ultimobiletools.commons.databinding.ItemUltiListBinding

open class UltiListItemAdapter(val activity: Activity, val onItemClicked: (UltiListItem) -> Unit) :
    ListAdapter<UltiListItem, UltiListItemAdapter.UltiItemViewHolder>(UltiListItemDiffCallback()) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UltiItemViewHolder {
        val view = activity.layoutInflater.inflate(R.layout.item_ulti_list, parent, false)
        return UltiItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: UltiItemViewHolder, position: Int) {
        val route = getItem(position)
        holder.bindView(route)
    }

    open inner class UltiItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val binding = ItemUltiListBinding.bind(itemView)
        fun bindView(item: UltiListItem) {
            setupUltiListItem(binding, item, onItemClicked)
        }
    }

    private class UltiListItemDiffCallback : DiffUtil.ItemCallback<UltiListItem>() {
        override fun areItemsTheSame(oldItem: UltiListItem, newItem: UltiListItem): Boolean {
            return UltiListItem.areItemsTheSame(oldItem, newItem)
        }

        override fun areContentsTheSame(oldItem: UltiListItem, newItem: UltiListItem): Boolean {
            return UltiListItem.areContentsTheSame(oldItem, newItem)
        }
    }
}

fun setupUltiListItem(view: ItemUltiListBinding, item: UltiListItem, onItemClicked: (UltiListItem) -> Unit) {
    view.apply {
        val color = if (item.selected) {
            root.context.getProperPrimaryColor()
        } else {
            root.context.getProperTextColor()
        }

        bottomSheetItemTitle.setText(item.textRes)
        bottomSheetItemTitle.setTextColor(color)
        bottomSheetItemIcon.setImageResourceOrBeGone(item.imageRes)
        bottomSheetItemIcon.applyColorFilter(color)
        bottomSheetSelectedIcon.beVisibleIf(item.selected)
        bottomSheetSelectedIcon.applyColorFilter(color)

        root.setOnClickListener {
            onItemClicked(item)
        }
    }
}
