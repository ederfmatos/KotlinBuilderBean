package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.singleton.RandomObject

internal class MockBeanRandomDouble(configurations: List<ConfigurationEnum>) : MockBeanRandomValueAbstract<Double>(configurations) {

    override fun getRandomValue(clazz: Class<*>): Double = RandomObject.random.nextDouble()

    override val classJava: Class<*> = java.lang.Double::class.java

}