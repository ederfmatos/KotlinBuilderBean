package com.ederfmatos.kotlintestdatabuilder.random.types

import kotlin.reflect.KClass

class MockBeanRandomSet : MockBeanRandomIterable<Set<*>>() {

    override val collectionClass: KClass<Set<*>> = Set::class

}