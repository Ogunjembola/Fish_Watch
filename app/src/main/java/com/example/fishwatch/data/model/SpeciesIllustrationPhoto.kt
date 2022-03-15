package com.example.fishwatch.data.model

import com.google.gson.annotations.SerializedName

data class SpeciesIllustrationPhoto(
    @SerializedName("alt")
    val alt: String,
    @SerializedName("src")
    val src: String
)