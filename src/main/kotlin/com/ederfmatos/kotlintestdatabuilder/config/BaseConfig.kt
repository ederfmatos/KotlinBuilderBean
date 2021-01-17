package com.ederfmatos.kotlintestdatabuilder.config

import java.lang.reflect.Field

interface BaseConfig {

    fun isConfigured(field: Field): Boolean

}