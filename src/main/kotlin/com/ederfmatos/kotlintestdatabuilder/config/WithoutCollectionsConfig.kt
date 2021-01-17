package com.ederfmatos.kotlintestdatabuilder.config

import java.lang.reflect.Field
import java.util.*

internal class WithoutCollectionsConfig : BaseConfig {

    private val collectionsClass: List<Class<*>> = listOf(
        List::class.java,
        Set::class.java,
        Queue::class.java
    )

    override fun isConfigured(field: Field): Boolean {
        return collectionsClass.any { it.isAssignableFrom(field.type) }
    }

}
