package com.ederfmatos.kotlintestdatabuilder.random.types

import kotlin.reflect.KClass

class MockBeanRandomMutableSet : MockBeanRandomIterable<MutableSet<*>>() {

    override val collectionClass: KClass<MutableSet<*>> = MutableSet::class

}