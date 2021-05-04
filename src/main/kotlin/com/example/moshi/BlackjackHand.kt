package com.example.moshi

import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class BlackjackHand(val hiddenCard: Card, val visibleCards: List<Card>)
