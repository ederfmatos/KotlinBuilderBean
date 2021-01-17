package com.ederfmatos.kotlintestdatabuilder.random.types

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import kotlin.reflect.KClass

internal class MockBeanRandomMutableList(configurations: List<ConfigurationEnum>) : MockBeanRandomIterable<MutableList<*>>(configurations) {

    override val collectionClass: KClass<MutableList<*>> = MutableList::class

}