package com.example.moshi

import com.squareup.moshi.Moshi
import org.json.JSONArray
import org.json.JSONObject
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication


@SpringBootApplication
class MoshiApplication

fun main(args: Array<String>) {
    runApplication<MoshiApplication>(*args)
    val blackjackHand = BlackjackHand(
        Card('6', "SPADES"),
        listOf(Card('4', "CLUBS"), Card('A', "HEARTS"))
    )

    val moshi = Moshi.Builder().build()
    val jsonAdapter = moshi.adapter(BlackjackHand::class.java)

    val json = jsonAdapter.toJson(blackjackHand)
    iterateJson(json)
}

private fun iterateJson(json: String) {

    val jsonObject = JSONObject(json.trim())
    val keys = jsonObject.keys()

    while (keys.hasNext()) {
        val key = keys.next()
        if (jsonObject[key] is JSONObject) {
            println("found: ${jsonObject[key]}")
        } else if (jsonObject[key] is JSONArray) {
            println("found: ${jsonObject[key]}")
            jsonObject[key]
           // iterateJson(jsonObject[key].toString())
        }
    }
}
