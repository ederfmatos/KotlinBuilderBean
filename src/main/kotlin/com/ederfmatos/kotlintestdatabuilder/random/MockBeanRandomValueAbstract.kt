package com.ederfmatos.kotlintestdatabuilder.random

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import java.lang.reflect.Field
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.stream.Stream

internal abstract class MockBeanRandomValueAbstract<T : Any>(protected val configurations: List<ConfigurationEnum>) {

    open fun getRandomValue(clazz: Class<*>): Any? = Unit

    open fun getRandomValue(field: Field?): Any? {
        return field?.let { getRandomValue(it.type) }
    }

    abstract val classJava: Class<*>

    open val defaultValue : Any? = null

    open fun isInstanceOf(fieldClass: Class<*>): Boolean {
        val refClass: Type = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return refClass == fieldClass || classJava == fieldClass || fieldClass.name.equals(classJava.simpleName, ignoreCase = true)
    }

    protected fun getValueFor(clazz: Class<*>): Any? {
        return Stream.of(*MockBeanRandomValueEnum.values())
            .filter { it.name != MockBeanRandomValueEnum.ANY.name }
            .map { it.generator }
            .filter { it(configurations).isInstanceOf(clazz) }
            .findFirst()
            .orElse(MockBeanRandomValueEnum.ANY.generator)
            .let { it(configurations).getRandomValue(clazz) }
    }

}