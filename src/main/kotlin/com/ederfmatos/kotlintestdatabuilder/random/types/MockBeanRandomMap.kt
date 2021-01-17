package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import com.ederfmatos.kotlintestdatabuilder.singleton.RandomObject
import java.lang.reflect.Field
import java.lang.reflect.ParameterizedType

internal class MockBeanRandomMap(configurations: List<ConfigurationEnum>) :
    MockBeanRandomValueAbstract<Map<*, *>>(configurations) {

    override fun getRandomValue(field: Field?): Any {
        val size: Int = RandomObject.randomInt(15) + 1
        val type = field?.genericType as ParameterizedType

        val keyClass = type.actualTypeArguments[0] as Class<*>
        val valueClass = type.actualTypeArguments[1] as Class<*>
        val resultMap: MutableMap<Any, Any?> = HashMap()

        for (i in 0 until size) {
            val key: Any = getValueFor(keyClass)!!
            resultMap[key] = getValueFor(valueClass)
        }

        return resultMap
    }

    override val classJava: Class<*> = java.util.Map::class.java

}