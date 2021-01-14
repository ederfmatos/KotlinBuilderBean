package com.ederfmatos.kotlintestdatabuilder.random.types

import kotlin.reflect.KClass

class MockBeanRandomMutableList : MockBeanRandomIterable<MutableList<*>>() {

    override val collectionClass: KClass<MutableList<*>> = MutableList::class

}