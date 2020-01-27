package com.example.quiz.quiz

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.Window
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AlertDialog
import com.example.quiz.R
import com.example.quiz.databases.model.ChemicalElement
import kotlinx.android.synthetic.main.activity_quiz.*

class EasyDifficultyActivity : AppCompatActivity(), QuizActivity {

    companion object{
        private const val NAME_OF_REGIME = "Easy"
    }

    private val quizActivityPresenter: QuizActivityPresenter = QuizActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quiz)
        initFirstVariantButtonListener()
        initSecondVariantListener()
        initThirdVariantListener()
        initFourthVariantListener()

        quizActivityPresenter.setChemicalElementAndVariants()
    }

    private fun initFirstVariantButtonListener(){
        btnFirstVariant.setOnClickListener {
            quizActivityPresenter.checkAnswerName(btnFirstVariant.text.toString())
        }
    }

    private fun initSecondVariantListener(){
        btnSecondVariant.setOnClickListener {
            quizActivityPresenter.checkAnswerName(btnSecondVariant.text.toString())
        }
    }

    private fun initThirdVariantListener(){
        btnThirdVariant.setOnClickListener {
            quizActivityPresenter.checkAnswerName(btnThirdVariant.text.toString())
        }
    }

    private fun initFourthVariantListener(){
        btnFourthVariant.setOnClickListener {
            quizActivityPresenter.checkAnswerName(btnFourthVariant.text.toString())
        }
    }

    override fun setInfAboutChemicalElement(chemicalElement: ChemicalElement){
        txtSymbol.text = chemicalElement.symbol
        txtAtomicNumber.text = chemicalElement.atomicNumber.toString()
        txtAtomicWeight.text = chemicalElement.atomicWeight.toString()
        txtName.text = "???"
    }

    override fun setVariants(variants: List<ChemicalElement>) {
        btnFirstVariant.text = variants[0].name
        btnSecondVariant.text = variants[1].name
        btnThirdVariant.text = variants[2].name
        btnFourthVariant.text = variants[3].name
    }

    override fun showMessageOfWinning(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.my_alert_dialog)
        val resultOfGame = dialog.findViewById(R.id.txtResult) as TextView
        resultOfGame.text = "You won!!!"
        val editNameOfGamer = dialog.findViewById(R.id.edtNameOfGamer) as EditText
        editNameOfGamer.hint = "Input your name"
        val yesBtn = dialog .findViewById(R.id.btnYes) as Button
        yesBtn.setOnClickListener {
            quizActivityPresenter.addResultToDB(editNameOfGamer.text.toString())
            dialog.dismiss()
            finish()
        }
        dialog .show()
    }

    override fun showMessageOfLosing(){
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.my_alert_dialog)
        val resultOfGame = dialog.findViewById(R.id.txtResult) as TextView
        resultOfGame.text = "You lose(("
        val editNameOfGamer = dialog.findViewById(R.id.edtNameOfGamer) as EditText
        editNameOfGamer.hint = "Input your name"
        val yesBtn = dialog .findViewById(R.id.btnYes) as Button
        yesBtn.setOnClickListener {
            quizActivityPresenter.addResultToDB(editNameOfGamer.text.toString())
            dialog.dismiss()
            finish()
        }
        dialog .show()
    }

    override fun setCounterOfCorrectAnswers(counter: String){
        txtCounter.text = counter
    }

    override fun onDestroy() {
        super.onDestroy()
        quizActivityPresenter.closeDB()
    }

    override fun getContext() = this

    override fun getNameOfRegime() = NAME_OF_REGIME
}
