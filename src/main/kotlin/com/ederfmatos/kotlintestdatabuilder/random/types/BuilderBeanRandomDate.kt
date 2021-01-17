package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import java.lang.reflect.Field
import java.time.LocalDate
import java.util.*
import java.util.concurrent.ThreadLocalRandom
import kotlin.reflect.KClass

internal class BuilderBeanRandomDate(configurations: List<ConfigurationEnum>) : MockBeanRandomValueAbstract<Date>(configurations) {

    override fun getRandomValue(clazz: Class<*>): Date =
        Date(ThreadLocalRandom.current().nextLong(MIN_DAY, LocalDate.now().toEpochDay()))

    companion object {
        private val MIN_DAY = LocalDate.of(1970, 1, 1).toEpochDay()
    }

    override val classJava: Class<*> = Date::class.java
}
