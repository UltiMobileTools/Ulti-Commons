package com.ultimobiletools.commons.models

import kotlinx.serialization.Serializable

@Serializable
data class Event(var value: String, var type: Int)
