package com.ederfmatos.kotlintestdatabuilder.random

import java.lang.reflect.Field
import java.lang.reflect.ParameterizedType
import java.lang.reflect.Type
import java.util.stream.Stream

abstract class MockBeanRandomValueAbstract<T : Any> {

    open fun getRandomValue(clazz: Class<*>): Any? = Unit

    open fun getRandomValue(field: Field?): Any? {
        return field?.let { getRandomValue(it.type) }
    }

    abstract val classJava: Class<*>

    open fun isInstanceOf(fieldClass: Class<*>): Boolean {
        val refClass: Type = (this.javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0]
        return refClass == fieldClass || classJava == fieldClass || fieldClass.name.equals(classJava.simpleName, ignoreCase = true)
    }

    protected fun getValueFor(clazz: Class<*>): Any {
        return Stream.of(*MockBeanRandomValueEnum.values())
            .filter { it != MockBeanRandomValueEnum.ANY }
            .map { it.generator }
            .filter { it.isInstanceOf(clazz) }
            .findFirst()
            .orElse(MockBeanRandomValueEnum.ANY.generator)
            .getRandomValue(clazz) ?: Unit
    }

}