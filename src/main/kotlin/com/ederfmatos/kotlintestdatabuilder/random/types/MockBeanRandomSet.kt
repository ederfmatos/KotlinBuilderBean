package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import kotlin.reflect.KClass

internal class MockBeanRandomSet(configurations: List<ConfigurationEnum>) : MockBeanRandomIterable<Set<*>>(configurations) {

    override val collectionClass: KClass<Set<*>> = Set::class

}