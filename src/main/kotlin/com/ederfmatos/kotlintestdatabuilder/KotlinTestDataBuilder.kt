package com.ederfmatos.kotlintestdatabuilder

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.MockBeanRandomValueEnum.Companion.getRandomValueFromField
import com.ederfmatos.kotlintestdatabuilder.singleton.GsonObject
import java.util.*
import kotlin.reflect.KClass

class KotlinTestDataBuilder<C : Any>(private val builderClass: Class<C>) {

    private val fieldValueMap: MutableMap<String?, Any?> = HashMap()
    private val configurations: MutableList<ConfigurationEnum> = mutableListOf()

    companion object {
        fun <C : Any> oneBuilderOf(builderClass: KClass<C>) = KotlinTestDataBuilder(builderClass.java)

        fun <C : Any> oneBuilderOf(builderClass: Class<C>) = KotlinTestDataBuilder(builderClass)
    }

    fun without(vararg names: String): KotlinTestDataBuilder<C> {
        names.forEach { with(it, null) }
        return this
    }

    fun configure(config: ConfigurationEnum): KotlinTestDataBuilder<C> {
        return configurations.add(config).let { this }
    }

    fun with(name: String, value: Any?): KotlinTestDataBuilder<C> {
        return try {
            builderClass.getDeclaredField(name)
            fieldValueMap[name] = value
            this
        } catch (e: NoSuchFieldException) {
            throw NoSuchFieldException(String.format("Field \"%s\" not found", name))
        }
    }

    fun build() = create()

    fun buildList(size: Int) = 1.rangeTo(size).map { this.create() }

    fun json(): String = GsonObject.toJson(build())

    fun jsonList(size: Int) = GsonObject.toJson(buildList(size))

    fun optional() = Optional.ofNullable(create())

    private fun create(): C {
        val bean = builderClass.declaredFields
            .map {
            it.name to if (fieldValueMap.containsKey(it.name)) fieldValueMap[it.name]
            else getRandomValueFromField(it, configurations)
        }
            .filter { it.second != null }
            .fold(mutableMapOf<String, Any?>()) { accum, item ->
                accum[item.first] = item.second
                accum
            }

        return GsonObject.fromJson(GsonObject.toJson(bean), builderClass)
    }


}