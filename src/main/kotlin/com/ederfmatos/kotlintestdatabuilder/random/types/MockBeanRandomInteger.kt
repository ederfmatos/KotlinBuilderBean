package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.random.singleton.RandomObject

import java.lang.reflect.Field

class MockBeanRandomInteger : MockBeanRandomValueAbstract<Int>() {

    override fun getRandomValue(clazz: Class<*>): Int = RandomObject.randomInt(100)

    override fun isInstanceOf(fieldClass: Class<*>): Boolean {
        return fieldClass == Int::class.java ||fieldClass == Integer::class.java
    }

    override val classJava: Class<*> = Integer::class.java

}