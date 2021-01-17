package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.singleton.RandomObject

internal class BuilderBeanRandomEnum(configurations: List<ConfigurationEnum>) : MockBeanRandomValueAbstract<Enum<*>>(configurations) {

    override fun getRandomValue(clazz: Class<*>): Any? {
        return clazz.enumConstants.let { it[RandomObject.randomInt(it.size - 1)]}
    }

    override fun isInstanceOf(fieldClass: Class<*>): Boolean {
        return fieldClass.isEnum
    }

    override val classJava: Class<*> = Enum::class.java
}
