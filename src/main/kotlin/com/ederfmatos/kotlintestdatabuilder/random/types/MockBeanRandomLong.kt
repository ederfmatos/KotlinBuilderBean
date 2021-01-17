package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.singleton.RandomObject

internal class MockBeanRandomLong(configurations: List<ConfigurationEnum>) : MockBeanRandomValueAbstract<Long>(configurations) {

    override fun getRandomValue(clazz: Class<*>): Long = RandomObject.random.nextLong()

    override val classJava: Class<*> = java.lang.Long::class.java

}