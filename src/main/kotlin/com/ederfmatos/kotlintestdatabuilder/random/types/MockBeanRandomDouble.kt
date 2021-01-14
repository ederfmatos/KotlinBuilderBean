package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.random.singleton.RandomObject

import java.lang.reflect.Field
import kotlin.reflect.KClass

class MockBeanRandomDouble : MockBeanRandomValueAbstract<Double>() {

    override fun getRandomValue(clazz: Class<*>): Double = RandomObject.random.nextDouble()

    override val classJava: Class<*> = java.lang.Double::class.java

}