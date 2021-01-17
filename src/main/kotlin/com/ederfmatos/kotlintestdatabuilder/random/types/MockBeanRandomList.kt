package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import kotlin.reflect.KClass

internal class MockBeanRandomList(configurations: List<ConfigurationEnum>) : MockBeanRandomIterable<List<*>>(configurations) {

    override val collectionClass: KClass<List<*>> = List::class

    override val defaultValue: List<*> = emptyList<Any>()

}