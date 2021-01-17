package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.singleton.RandomObject

internal class BuilderBeanRandomChar(configurations: List<ConfigurationEnum>) : MockBeanRandomValueAbstract<Char>(configurations) {

    private val ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    override fun getRandomValue(clazz: Class<*>) = ALPHABET[RandomObject.randomInt(ALPHABET.length)]

    override val classJava: Class<*> = Character::class.java

    override fun isInstanceOf(fieldClass: Class<*>): Boolean {
        return super.isInstanceOf(fieldClass) || fieldClass.simpleName.equals(Char::class.simpleName, ignoreCase = true)
    }

}