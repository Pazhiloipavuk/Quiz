package com.example.quiz.databases

import com.example.quiz.databases.model.ChemicalElement
import io.realm.Realm

class ServiceDBRealm {
    private var realm: Realm = Realm.getDefaultInstance()

    fun addChemicalElement(chemicalElement: ChemicalElement){
        realm.beginTransaction()
        realm.copyToRealmOrUpdate(chemicalElement)
        realm.commitTransaction()
    }

    fun getAllChemicalElements() = realm.where(ChemicalElement::class.java).findAll()!!


    fun closeDB(){
        realm.close()
    }
}