package com.example.quiz.databases.model

import io.realm.RealmObject
import io.realm.annotations.PrimaryKey

open class ChemicalElement(@PrimaryKey var name : String =  "",
                   var symbol : String = "",
                   var atomicNumber: Int = 0,
                   var atomicWeight : Double = 0.0) : RealmObject()