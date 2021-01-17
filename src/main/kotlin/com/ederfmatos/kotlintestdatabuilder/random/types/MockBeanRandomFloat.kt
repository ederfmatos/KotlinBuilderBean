package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.singleton.RandomObject

internal class MockBeanRandomFloat(configurations: List<ConfigurationEnum>) : MockBeanRandomValueAbstract<Float>(configurations) {

    override fun getRandomValue(clazz: Class<*>): Float = RandomObject.random.nextFloat()

    override val classJava: Class<*> =  Float::class.java
}