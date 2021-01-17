package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.singleton.RandomObject.randomInt

internal class MockBeanRandomString(configurations: List<ConfigurationEnum>) : MockBeanRandomValueAbstract<String>(configurations) {

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