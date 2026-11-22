package com.example.anketa.view

import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.runtime.Composable
import com.example.anketa.model.Person
import androidx.compose.foundation.lazy.items
@Composable
fun PersonsList(persons: List<Person>){
    LazyColumn() {
        items(
            items = persons,
            key = {person->person.id}

        ){
            person->PersonItem(person)
        }
    }
}