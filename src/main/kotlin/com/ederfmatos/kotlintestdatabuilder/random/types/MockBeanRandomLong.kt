package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.random.singleton.RandomObject
import java.lang.reflect.Field

class MockBeanRandomLong : MockBeanRandomValueAbstract<Long>() {

    override fun getRandomValue(clazz: Class<*>): Long = RandomObject.random.nextLong()

    override val classJava: Class<*> = java.lang.Long::class.java

}