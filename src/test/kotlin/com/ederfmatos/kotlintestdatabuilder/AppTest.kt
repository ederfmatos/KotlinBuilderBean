package com.ederfmatos.kotlintestdatabuilder

import com.ederfmatos.kotlintestdatabuilder.KotlinTestDataBuilder.Companion.oneBuilderOf
import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import org.junit.Assert.assertThat
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.math.BigDecimal
import java.time.LocalDate
import java.time.LocalDateTime
import java.util.*
import kotlin.reflect.KClass
import kotlin.test.assertNotNull
import kotlin.test.assertTrue

class AppTest {

    @Test
    fun test() {
        val kClass: KClass<Response> = Response::class
        val mock = oneBuilderOf(kClass)

        val response = mock.build()
        val json = mock.without("name").json()
        val list = mock.buildList(2)
        val jsonList = mock.jsonList(2)
        val optional = mock.optional()

        assertNotNull(response)
        assertNotNull(json)
        assertNotNull(list)
        assertNotNull(jsonList)
        assertTrue { list.size == 2 }
        assertTrue { optional.isPresent }

        println("Response: [$response]")
        response.javaClass.declaredFields.forEach {
            it.trySetAccessible()
            assertNotNull(it.get(response), "O campo ${it.name} nao deve ser nulo")
        }
    }

    @Test
    fun shouldCreateMockWithoutLists() {
        val kClass: KClass<Response> = Response::class

        val response = oneBuilderOf(kClass)
            .configure(ConfigurationEnum.WITHOUT_LISTS)
            .build()

        assertNotNull(response)
        assertTrue(response.list.isEmpty())
    }

    @Test
    fun shouldThrowErrorOnRemoveInexistentAttribute() {
        assertThrows<NoSuchFieldException> {
            oneBuilderOf(Response::class)
                .without("1")
                .build()
        }
    }

}

data class Response(
    val name: String,
    val age: Int,
    val active: Boolean,
    val genre: Char,
    val createdAt: Date,
    val salary: Double,
    val price: Float,
    val list: List<String> = emptyList(),
    val types: List<Type> = emptyList(),
    val values: List<BigDecimal> = emptyList(),
    val valuesSet: Set<BigDecimal>,
    val valuesMutableSet: MutableSet<String>,
    val valuesMutableList: MutableList<String>,
    val birthday: LocalDate,
    val time: Long,
    val map: Map<String, String>,
    val type: Type,
    val datetime: LocalDateTime,
    val secondary: Secondary
)

data class Secondary (val name: String)

enum class Type {
    ACTIVE,
    INACTIVE,
    TEST
}