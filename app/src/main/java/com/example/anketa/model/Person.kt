package com.example.anketa.model

data class Person(
    val id: Int,
    val name: String="Иван",
    val lastName: String="Иванов",
    val age: Number=25,
    val address: String="Санкт-Петербург, Кирочная улица, дом 64",
    val phoneNumber: Number=88005553535,
    val email: String="yandex.ru",

)
