package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.KotlinTestDataBuilder.Companion.oneBuilderOf
import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueEnum

internal class MockBeanRandomAny(configurations: List<ConfigurationEnum>) : MockBeanRandomValueAbstract<Any>(configurations) {

    override fun getRandomValue(clazz: Class<*>): Any? {
        return try {
            oneBuilderOf(clazz)
                .apply { configurations.forEach(this::configure) }
                .build()
        } catch (exception: Exception) {
            null
        }
    }

    override fun isInstanceOf(fieldClass: Class<*>): Boolean {
        return MockBeanRandomValueEnum.values()
            .filter { it.name  != "ANY" }
            .map(MockBeanRandomValueEnum::generator)
            .none { it(configurations).isInstanceOf(fieldClass) }
    }

    override val classJava: Class<*> = java.lang.Object::class.java
}