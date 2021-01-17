package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract

import com.ederfmatos.kotlintestdatabuilder.singleton.RandomObject

internal class BuilderBeanRandomBoolean(configurations: List<ConfigurationEnum>) : MockBeanRandomValueAbstract<Boolean>(configurations) {

    override fun getRandomValue(clazz: Class<*>): Boolean {
        return RandomObject.random.nextBoolean()
    }

    override val classJava: Class<*> = java.lang.Boolean::class.java

    override fun isInstanceOf(fieldClass: Class<*>): Boolean {
        return super.isInstanceOf(fieldClass) || fieldClass.name.equals(Boolean::class.simpleName, ignoreCase = true)
    }

}