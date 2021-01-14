package com.ederfmatos.kotlintestdatabuilder.random.singleton

import java.util.*

object RandomObject {

    val random: Random = Random()

    fun randomInt(limit: Int) = random.nextInt(limit) + 1

}