package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.random.singleton.RandomObject

import java.lang.reflect.Field
import kotlin.reflect.KClass

class MockBeanRandomFloat : MockBeanRandomValueAbstract<Float>() {

    override fun getRandomValue(clazz: Class<*>): Float = RandomObject.random.nextFloat()

    override val classJava: Class<*> =  Float::class.java
}