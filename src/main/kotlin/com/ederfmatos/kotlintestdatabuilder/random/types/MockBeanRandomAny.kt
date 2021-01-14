package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.KotlinTestDataBuilder.Companion.oneBuilderOf
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueEnum
import com.ederfmatos.kotlintestdatabuilder.random.singleton.RandomObject.randomInt
import java.lang.reflect.Field

class MockBeanRandomAny : MockBeanRandomValueAbstract<Any>() {

    override fun getRandomValue(clazz: Class<*>): Any? {
        return try {
            oneBuilderOf(clazz).build()
        } catch (exception: Exception) {
            null
        }
    }

    override fun isInstanceOf(fieldClass: Class<*>): Boolean {
        return MockBeanRandomValueEnum.values()
            .filter { it.name  != "ANY" }
            .map(MockBeanRandomValueEnum::generator)
            .none { it.isInstanceOf(fieldClass) }
    }

    override val classJava: Class<*> = java.lang.Object::class.java
}