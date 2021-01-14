package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract

import com.ederfmatos.kotlintestdatabuilder.random.singleton.RandomObject
import java.lang.reflect.Field
import java.math.BigDecimal
import kotlin.reflect.KClass

class BuilderBeanRandomBigDecimal : MockBeanRandomValueAbstract<BigDecimal>() {

    override fun getRandomValue(clazz: Class<*>): BigDecimal {
        return BigDecimal.valueOf(RandomObject.random.nextDouble())
    }

    override val classJava: Class<*> = BigDecimal::class.java

}