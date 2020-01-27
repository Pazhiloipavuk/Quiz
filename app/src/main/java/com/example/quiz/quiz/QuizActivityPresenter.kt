package com.example.quiz.quiz

import com.example.quiz.databases.ServiceDBRealm
import com.example.quiz.databases.ServiceDBSql
import com.example.quiz.databases.model.ChemicalElement
import com.example.quiz.databases.model.ResultOfGame
import kotlin.random.Random

class QuizActivityPresenter {
    private var quizActivity: QuizActivity

    private var serviceDBRealm = ServiceDBRealm()

    private lateinit var chemicalElement: ChemicalElement

    private var chemicalElements: List<ChemicalElement>

    private var chemicalElementsInQuiz: MutableList<ChemicalElement>

    private var counterOfCorrectAnswers: Int

    private var serviceDBSql: ServiceDBSql

    constructor(quizActivity: QuizActivity){
        this.quizActivity = quizActivity
        serviceDBSql = ServiceDBSql(quizActivity.getContext())
        chemicalElements = serviceDBRealm.getAllChemicalElements()
        chemicalElementsInQuiz = chemicalElements.toMutableList()
        counterOfCorrectAnswers = 0
    }

    fun fillDB(){
        chemicalElement = ChemicalElement("Hydrogen", "H", 1, 1.008)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Helium", "He", 2, 4.003)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Lithium", "Li", 3, 6.941)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Beryllium", "Be", 4, 9.0122)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Boron", "B", 5, 10.811)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Carbon", "C", 6,12.011)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Nitrogen", "N", 7, 14.007)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Oxygen", "O", 8, 15.999)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Fluorine", "F", 9, 18.998)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Neon", "Ne", 10, 20.179)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Sodium", "Na", 11, 22.99)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Magnesium", "Mg", 12, 24.305)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Aluminum", "Al", 13, 26.982)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Silicon", "Si", 14, 28.086)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Phosphorus", "P", 15, 30.974)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Sulfur", "S", 16, 32.065)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Chlorine", "Cl", 17, 35.453)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Argon", "Ar", 18, 39.948)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Potassium", "K", 19, 39.098)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Scandium", "Sc", 21, 44.956)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Titanium", "Ti",22, 47.867)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Vanadium", "V", 23, 50.942)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Chromium", "Cr", 24, 51.996)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Manganese", "Mn", 25, 54.938)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Iron", "Fe", 26, 55.845)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Cobalt", "Co", 27, 58.933)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Nickel", "Ni", 28, 58.693)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Copper", "Cu", 29, 63.546)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Zinc", "Zn", 30, 65.39)
        serviceDBRealm.addChemicalElement(chemicalElement)






        chemicalElement = ChemicalElement("Gallium", "Ga", 31, 69.973)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Germanium", "Ge", 32, 72.64)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Arsenic", "As", 33, 74.992)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Selenium", "Se", 34, 78.96)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Bromine", "Br", 35, 79.904)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Krypton", "Kr", 36, 83.8)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Rubidium", "Rb", 37, 85.468)
        serviceDBRealm.addChemicalElement(chemicalElement)




        chemicalElement = ChemicalElement("Strontium", "Sr", 38, 87.62)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Yttrium", "Y", 39, 88.906)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Zirconium", "Zr", 40, 91.224)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Niobium", "Nb", 41, 92.906)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Molybdenum", "Mo", 42, 95.94)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Technetium", "Tc", 43, 98.0)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Ruthenium", "Ru", 44, 101.07)
        serviceDBRealm.addChemicalElement(chemicalElement)





        chemicalElement = ChemicalElement("Rhodium", "Rh", 45, 102.91)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Palladium", "Pd", 46, 106.42)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Silver", "Ag", 47, 107.87)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Cadmium", "Cd", 48, 112.41)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Indium", "In", 49, 114.82)
        serviceDBRealm.addChemicalElement(chemicalElement)

        chemicalElement = ChemicalElement("Tin", "Sn", 50, 118.71)
        serviceDBRealm.addChemicalElement(chemicalElement)

    }

    fun setChemicalElementAndVariants(){
        val indexOfChemicalElement = getRandomChemicalElement()

        chemicalElement = chemicalElementsInQuiz[indexOfChemicalElement]

        val indexOfButton = getRandomButtonWithCorrectAnswer()

        var variants: MutableList<ChemicalElement> = mutableListOf()

        when(indexOfButton){
            0 -> {
                variants.add(chemicalElement)
                variants.add(chemicalElements[getRandomVariant()])
                variants.add(chemicalElements[getRandomVariant()])
                variants.add(chemicalElements[getRandomVariant()])
            }
            1 -> {
                variants.add(chemicalElements[getRandomVariant()])
                variants.add(chemicalElement)
                variants.add(chemicalElements[getRandomVariant()])
                variants.add(chemicalElements[getRandomVariant()])
            }
            2 -> {
                variants.add(chemicalElements[getRandomVariant()])
                variants.add(chemicalElements[getRandomVariant()])
                variants.add(chemicalElement)
                variants.add(chemicalElements[getRandomVariant()])
            }
            3 -> {
                variants.add(chemicalElements[getRandomVariant()])
                variants.add(chemicalElements[getRandomVariant()])
                variants.add(chemicalElements[getRandomVariant()])
                variants.add(chemicalElement)
            }
        }

        quizActivity.setInfAboutChemicalElement(chemicalElement)
        chemicalElementsInQuiz.remove(chemicalElement)
        quizActivity.setVariants(variants)
    }

    private fun getRandomChemicalElement() = Random.nextInt(0, chemicalElementsInQuiz.size)

    private fun getRandomVariant() = (chemicalElements.indices).random()

    private fun getRandomButtonWithCorrectAnswer() = Random.nextInt(0, 4)

    fun checkAnswerName(answer: String){
        if (answer == chemicalElement.name) refreshUI()
        else quizActivity.showMessageOfLosing()
    }

    fun checkAnswerAtomicWeight(answer: String){
        if (chemicalElement.atomicWeight == answer.toDouble()) refreshUI()
        else quizActivity.showMessageOfLosing()
    }

    private fun refreshUI(){
        counterOfCorrectAnswers++
        quizActivity.setCounterOfCorrectAnswers(counterOfCorrectAnswers.toString())
        if (counterOfCorrectAnswers == chemicalElements.size) quizActivity.showMessageOfWinning()
        else setChemicalElementAndVariants()
    }

    fun addResultToDB(nameOfGamer: String){
        val resultOfGame = ResultOfGame(nameOfGamer, counterOfCorrectAnswers.toString(),
                                        quizActivity.getNameOfRegime())
        serviceDBSql.addResult(resultOfGame)
    }

    fun closeDB(){
        serviceDBRealm.closeDB()
    }
}