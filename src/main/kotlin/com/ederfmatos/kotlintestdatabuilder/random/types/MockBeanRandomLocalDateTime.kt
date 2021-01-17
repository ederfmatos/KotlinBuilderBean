package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueAbstract
import java.lang.reflect.Field
import java.time.LocalDate
import java.time.LocalDateTime
import kotlin.reflect.KClass

internal class MockBeanRandomLocalDateTime(configurations: List<ConfigurationEnum>) : MockBeanRandomValueAbstract<LocalDateTime>(configurations) {

    override fun getRandomValue(clazz: Class<*>): LocalDateTime = LocalDateTime.of(
        (1970..LocalDate.now().year).random(),
        (1..12).random(),
        (1..28).random(),
        (0..23).random(),
        (0..59).random(),
        (0..59).random(),
    )

    override val classJava: Class<*> = LocalDateTime::class.java

}