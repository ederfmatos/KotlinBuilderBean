package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.singleton.RandomObject

internal class MockBeanRandomInteger(configurations: List<ConfigurationEnum>) : MockBeanRandomValueAbstract<Int>(configurations) {

    override fun getRandomValue(clazz: Class<*>): Int = RandomObject.randomInt(100)

    override fun isInstanceOf(fieldClass: Class<*>): Boolean {
        return fieldClass == Int::class.java ||fieldClass == Integer::class.java
    }

    override val classJava: Class<*> = Integer::class.java

}