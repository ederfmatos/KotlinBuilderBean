package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract

import com.ederfmatos.kotlintestdatabuilder.singleton.RandomObject
import java.math.BigDecimal

internal class BuilderBeanRandomBigDecimal(configurations: List<ConfigurationEnum>) : MockBeanRandomValueAbstract<BigDecimal>(configurations) {

    override fun getRandomValue(clazz: Class<*>): BigDecimal {
        return BigDecimal.valueOf(RandomObject.random.nextDouble())
    }

    override val classJava: Class<*> = BigDecimal::class.java

}