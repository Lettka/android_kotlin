package com.example.lesson1

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import java.util.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }
}

fun main() {
    println("Hello world!")
    val weather = Weather(
        "Moscow",
        -10,
        "snow"
    )

    when (weather) {
        is Weather -> println("type Weather")
        else -> println("another type")
    }

    val moscowCity = weather.copy(temperature = -15)
    println(moscowCity.city + " : temperature = " + moscowCity.temperature + ", " + moscowCity.precipitation)


    val data: Data = object : Data {
        override val id: String = "test"
    }
    Weather.newInstance()

    var bool = false
    var result = if (bool) {
        "true"
    } else {
        "false"
    }
    println(result)

    val value = Random.nextInt(10)
    println(value)
    when (value) {
        0 -> result = "0"
        in 1..5 -> result = "less than 6"
        in 6..9 -> result = "more than 5"
        else -> "10"
    }
    println(result)

    for (i in 1..10) {
        println(i)
    }

    for (i in 3 downTo -10 step 3) {
        println(i)
    }

    for (i in listOf("one", "two", "three", "four", "five")){
        println(i)
    }

}

object User {
    val name = "Name"
}

data class Weather(
    val city: String,
    val temperature: Int,
    val precipitation: String,
    override val id: String = UUID.randomUUID().toString()
) : Data {

    //static method
    companion object {
        fun newInstance(): Weather {
            return Weather("Rome", 13, "sun")
        }
    }
}

interface Data {
    val id: String?
}
