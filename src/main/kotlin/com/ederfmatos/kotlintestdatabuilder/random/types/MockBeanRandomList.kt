package com.ederfmatos.kotlintestdatabuilder.random.types

import kotlin.reflect.KClass

class MockBeanRandomList : MockBeanRandomIterable<List<*>>() {

    override val collectionClass: KClass<List<*>> = List::class

}