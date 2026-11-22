package com.example.anketa.controller

import androidx.compose.runtime.mutableStateListOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import com.example.anketa.model.Person
import com.example.anketa.model.PersonFields
import kotlin.random.Random
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
class PersonController {
    var personsModel = mutableStateListOf<Person>()
    var personFieldsModel by mutableStateOf(PersonFields())
    private  fun generateNewId(): Int{
        val newId: Int= Random.nextInt(0,10000000)
        while (true){
            var isIdExists: Boolean=false
            for ((id) in personsModel){
                if (id ==newId){
                    isIdExists=true
                    break
                }
            }
            if (!isIdExists){
                return newId;
            }
        }
    }
    fun addPerson(){
        val newId=generateNewId()
        personsModel.add(Person(newId))
    }
    fun updatePerson() {
        val index: Int = getPersonIndexById(personFieldsModel.id)




        if (index != -1) {
            personsModel[index] = personsModel[index].copy(
                name = personFieldsModel.name,
                lastName = personFieldsModel.lastName,
                age = personFieldsModel.age,
                address = personFieldsModel.address,
                email = personFieldsModel.email,
                phoneNumber = personFieldsModel.phoneNumber,

            )
        }
    }
    private fun getPersonIndexById(id: Int): Int{
        var index: Int = -1


        for ((i, person) in personsModel.withIndex()) {
            if (person.id == personFieldsModel.id) {
                index = i
                break
            }
        }
        return index
    }
    fun initPersonFields(id: Int){
        val index=getPersonIndexById(id)
        personFieldsModel=personFieldsModel.copy(
            id = personsModel[index].id,
            name = personsModel[index].name,
            lastName = personsModel[index].lastName,
            age = personsModel[index].age,
            address = personsModel[index].address,
            phoneNumber = personsModel[index].phoneNumber,
            email = personsModel[index].email
        )
    }
    fun setNameField(name: String){
        personFieldsModel = personFieldsModel.copy(name = name)
    }

    fun setLastNameField(lastName: String){
        personFieldsModel = personFieldsModel.copy(lastName = lastName)
    }

    fun setAgeField(age: String){
        val num = age.toIntOrNull() ?: return
        personFieldsModel = personFieldsModel.copy(age = num)
    }

    fun setAddressField(address: String){
        personFieldsModel = personFieldsModel.copy(address = address)
    }

    fun setPhoneNumberField(phoneNumber: String){
        val num = phoneNumber.toIntOrNull() ?: return
        personFieldsModel = personFieldsModel.copy(phoneNumber = num)
    }

    fun setEmailField(email: String){
        personFieldsModel = personFieldsModel.copy(email = email)
    }

}