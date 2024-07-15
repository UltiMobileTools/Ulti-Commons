package com.ultimobiletools.commons.models

import kotlinx.serialization.Serializable

@Serializable
data class UltiAddress(var value: String, var type: Int, var label: String)
