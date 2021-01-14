package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.random.singleton.RandomObject.randomInt
import java.lang.reflect.Field

class MockBeanRandomString : MockBeanRandomValueAbstract<String>() {

    override fun getRandomValue(clazz: Class<*>): Any? {
        return 1.rangeTo(randomInt(25) + 10)
            .map { ALPHABET[randomInt(ALPHABET.length - 1)].toString() }
            .joinToString("") { it }
    }

    companion object {
        private const val ALPHABET = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ-_"
    }

    override val classJava: Class<*> = java.lang.String::class.java
}