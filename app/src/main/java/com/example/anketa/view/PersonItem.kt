package com.example.anketa.view

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.anketa.model.Person

@Composable
fun PersonItem(person: Person){
    Card(modifier = Modifier.padding(12.dp).fillMaxWidth()) {
        Text(text = "${person.name} ${person.lastName[0]}.")
    }
}