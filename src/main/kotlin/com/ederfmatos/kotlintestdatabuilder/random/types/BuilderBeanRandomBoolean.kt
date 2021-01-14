package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract

import com.ederfmatos.kotlintestdatabuilder.random.singleton.RandomObject
import java.lang.reflect.Field
import kotlin.reflect.KClass

class BuilderBeanRandomBoolean : MockBeanRandomValueAbstract<Boolean>() {

    override fun getRandomValue(clazz: Class<*>): Boolean {
        return RandomObject.random.nextBoolean()
    }

    override val classJava: Class<*> = java.lang.Boolean::class.java

    override fun isInstanceOf(fieldClass: Class<*>): Boolean {
        return super.isInstanceOf(fieldClass) || fieldClass.name.equals(Boolean::class.simpleName, ignoreCase = true)
    }

}