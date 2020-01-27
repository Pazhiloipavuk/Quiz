package com.example.quiz.quiz

import android.content.Context
import com.example.quiz.databases.model.ChemicalElement

interface QuizActivity {
    fun setInfAboutChemicalElement(chemicalElement: ChemicalElement)
    fun setVariants(variants: List<ChemicalElement>)
    fun showMessageOfWinning()
    fun showMessageOfLosing()
    fun setCounterOfCorrectAnswers(counter: String)
    fun getContext() : Context
    fun getNameOfRegime() : String
}