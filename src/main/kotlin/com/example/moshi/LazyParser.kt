package com.example.moshi

import com.squareup.moshi.JsonAdapter
import com.squareup.moshi.JsonReader
import com.squareup.moshi.Moshi

class LazyParser(moshi: Moshi) {
    private val blackjackhandAdapter: JsonAdapter<BlackjackHand> = moshi.adapter(BlackjackHand::class.java)

    fun parse(reader: JsonReader): Sequence<BlackjackHand> {
        return sequence {
            reader.readJsonValue()
//            {
//                yield(blackjackhandAdapter.fromJson(reader)!!)
//            }
        }
    }
}