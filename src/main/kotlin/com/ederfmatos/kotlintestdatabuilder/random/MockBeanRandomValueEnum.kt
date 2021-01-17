package com.ederfmatos.kotlintestdatabuilder.random

import com.ederfmatos.kotlintestdatabuilder.config.ConfigurationEnum
import com.ederfmatos.kotlintestdatabuilder.random.types.*
import com.ederfmatos.kotlintestdatabuilder.singleton.RandomObject
import java.lang.reflect.Field
import java.util.stream.Stream

enum class MockBeanRandomValueEnum(val generator: (List<ConfigurationEnum>) -> MockBeanRandomValueAbstract<*>) {

    STRING({ MockBeanRandomString(it) }),
    INTEGER({ MockBeanRandomInteger(it) }),
    LOCAL_DATE({ MockBeanRandomLocalDate(it) }),
    BOOLEAN({ BuilderBeanRandomBoolean(it) }),
    DOUBLE({ MockBeanRandomDouble(it) }),
    FLOAT({ MockBeanRandomFloat(it) }),
    LONG({ MockBeanRandomLong(it) }),
    DATE({ BuilderBeanRandomDate(it) }),
    CHAR({ BuilderBeanRandomChar(it) }),
    LIST({ MockBeanRandomList(it) }),
    SET({ MockBeanRandomSet(it) }),
    MAP({ MockBeanRandomMap(it) }),
    MUTABLE_SET({ MockBeanRandomMutableSet(it) }),
    MUTABLE_LIST({ MockBeanRandomMutableList(it) }),
    LOCAL_DATE_TIME({ MockBeanRandomLocalDateTime(it) }),
    BIG_DECIMAL({ BuilderBeanRandomBigDecimal(it) }),
    ENUM({ BuilderBeanRandomEnum(it) }),
    ANY({ MockBeanRandomAny(it) })
    ;

    companion object {
        fun getRandomValueFromField(field: Field, configurations: MutableList<ConfigurationEnum>): Any? {
            if (configurations.any { it.config.isConfigured(field) }) {
                return Stream.of(*values())
                    .filter { it.generator(configurations).isInstanceOf(field.type) }
                    .findFirst()
                    .map { it.generator(configurations).defaultValue }
                    .orElse(null)
            }

            if (field.type.isEnum) {
                return field.type.enumConstants.let { it[RandomObject.randomInt(it.size - 1)] }
            }

            return Stream.of(*values())
                .filter { it.name != ANY.name }
                .map { it.generator }
                .filter { it(configurations).isInstanceOf(field.type) }
                .findFirst()
                .orElse(ANY.generator)
                .let { it(configurations).getRandomValue(field) }
        }
    }

}
