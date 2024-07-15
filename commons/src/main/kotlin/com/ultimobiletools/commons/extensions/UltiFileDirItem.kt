package com.ultimobiletools.commons.extensions

import android.content.Context
import com.ultimobiletools.commons.models.FileDirItem

fun FileDirItem.isRecycleBinPath(context: Context): Boolean {
    return path.startsWith(context.recycleBinPath)
}
