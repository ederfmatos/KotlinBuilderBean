package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.random.singleton.RandomObject
import java.lang.reflect.Field
import java.time.LocalDate
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import kotlin.reflect.KClass

class BuilderBeanRandomEnum : MockBeanRandomValueAbstract<Enum<*>>() {

    override fun getRandomValue(clazz: Class<*>): Any? {
        return clazz.enumConstants.let { it[RandomObject.randomInt(it.size - 1)]}
    }

    override fun isInstanceOf(fieldClass: Class<*>): Boolean {
        return fieldClass.isEnum
    }

    override val classJava: Class<*> = Enum::class.java
}
