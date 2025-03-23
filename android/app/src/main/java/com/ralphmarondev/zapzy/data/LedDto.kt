package com.ralphmarondev.zapzy.data

import com.google.gson.annotations.SerializedName

data class LedDto(
    val id: Int,
    val name: String,
    val status: Boolean,
    @SerializedName("created_at") val createdAt: String,
    @SerializedName("updated_at") val updatedAt: String
)