package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import kotlin.reflect.KClass

internal class MockBeanRandomMutableSet(configurations: List<ConfigurationEnum>) : MockBeanRandomIterable<MutableSet<*>>(configurations) {

    override val collectionClass: KClass<MutableSet<*>> = MutableSet::class

}