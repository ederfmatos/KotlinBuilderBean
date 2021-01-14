package com.ederfmatos.kotlintestdatabuilder.random


import com.ederfmatos.kotlintestdatabuilder.random.singleton.RandomObject
import com.ederfmatos.kotlintestdatabuilder.random.types.*
import java.lang.reflect.Field
import java.util.stream.Stream

enum class MockBeanRandomValueEnum(val generator: MockBeanRandomValueAbstract<*>) {

    STRING(MockBeanRandomString()),
    INTEGER(MockBeanRandomInteger()),
    LOCAL_DATE(MockBeanRandomLocalDate()),
    BOOLEAN(BuilderBeanRandomBoolean()),
    DOUBLE(MockBeanRandomDouble()),
    FLOAT(MockBeanRandomFloat()),
    LONG(MockBeanRandomLong()),
    DATE(BuilderBeanRandomDate()),
    CHAR(BuilderBeanRandomChar()),
    LIST(MockBeanRandomList()),
    SET(MockBeanRandomSet()),
    MAP(MockBeanRandomMap()),
    MUTABLE_SET(MockBeanRandomMutableSet()),
    MUTABLE_LIST(MockBeanRandomMutableList()),
    LOCAL_DATE_TIME(MockBeanRandomLocalDateTime()),
    BIG_DECIMAL(BuilderBeanRandomBigDecimal()),
    ENUM(BuilderBeanRandomEnum()),
    ANY(MockBeanRandomAny()),
    ;

    companion object {
        fun getRandomValueFromField(field: Field): Any? {
            if (field.type.isEnum) {
                return field.type.enumConstants.let { it[RandomObject.randomInt(it.size - 1)] }
            }

            return Stream.of(*values())
                .filter { it != ANY }
                .map { it.generator }
                .filter { it.isInstanceOf(field.type) }
                .findFirst()
                .orElse(ANY.generator)
                .getRandomValue(field)
        }
    }

}
