package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.random.singleton.RandomObject
import java.lang.reflect.Field
import kotlin.reflect.KClass

class BuilderBeanRandomChar : MockBeanRandomValueAbstract<Char>() {

    private val ALPHABET = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ"

    override fun getRandomValue(clazz: Class<*>) = ALPHABET[RandomObject.randomInt(ALPHABET.length)]

    override val classJava: Class<*> = Character::class.java

    override fun isInstanceOf(fieldClass: Class<*>): Boolean {
        return super.isInstanceOf(fieldClass) || fieldClass.simpleName.equals(Char::class.simpleName, ignoreCase = true)
    }

}