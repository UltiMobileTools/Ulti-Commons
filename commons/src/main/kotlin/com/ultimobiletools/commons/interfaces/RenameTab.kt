package com.ultimobiletools.commons.interfaces
import com.ultimobiletools.commons.activities.BaseUltiActivity

interface RenameTab {
    fun initTab(activity: BaseUltiActivity, paths: ArrayList<String>)

    fun dialogConfirmed(useMediaFileExtension: Boolean, callback: (success: Boolean) -> Unit)
}
