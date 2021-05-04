package com.example.moshi

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class Card(val value: Char, val type: String)