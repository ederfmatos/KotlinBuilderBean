package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import java.lang.reflect.Field
import java.lang.reflect.ParameterizedType
import kotlin.reflect.KClass

abstract class MockBeanRandomIterable<T: Any> : MockBeanRandomValueAbstract<T>() {

    override fun getRandomValue(field: Field?): Iterable<*> {
        val size: Int = com.ederfmatos.kotlintestdatabuilder.random.singleton.RandomObject.randomInt(15) + 2
        val type = field?.genericType as ParameterizedType
        val fieldType = type.actualTypeArguments[0] as Class<*>

        return 1.rangeTo(size).mapNotNull { getValueFor(fieldType) }
    }

    override fun isInstanceOf(fieldClass: Class<*>): Boolean {
        return fieldClass.isInstance(collectionClass.java) || fieldClass.simpleName.equals(
            collectionClass.simpleName,
            ignoreCase = true
        )
    }

    override val classJava: Class<*> = java.lang.Iterable::class.java

    abstract val collectionClass: KClass<T>

}