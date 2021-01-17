package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import java.lang.reflect.Field
import java.time.LocalDate
import java.util.concurrent.ThreadLocalRandom
import kotlin.reflect.KClass

internal class MockBeanRandomLocalDate(configurations: List<ConfigurationEnum>) : MockBeanRandomValueAbstract<LocalDate>(configurations) {

    companion object {
        private val MIN_DAY = LocalDate.of(1970, 1, 1).toEpochDay()
    }

    override fun getRandomValue(clazz: Class<*>): LocalDate = LocalDate.ofEpochDay(ThreadLocalRandom.current().nextLong(MIN_DAY, LocalDate.now().toEpochDay()))

    override val classJava: Class<*> = LocalDate::class.java

}