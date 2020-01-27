package com.example.quiz.entry

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quiz.R
import com.example.quiz.quiz.SelectDifficultyActivity
import com.example.quiz.statistic.StatisticActivity
import kotlinx.android.synthetic.main.activity_main_menu.*

class MainMenuActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_menu)
        initQuizButtonListener()
        initStatisticButtonListener()
        initExitButtonListener()
    }

    private fun initQuizButtonListener(){
        btnQuiz.setOnClickListener{
            val intentSelectDifficultyActivity = Intent(this, SelectDifficultyActivity::class.java)
            startActivity(intentSelectDifficultyActivity)
        }
    }

    private fun initStatisticButtonListener(){
        btnStatistic.setOnClickListener {
            val intentStatisticActivity = Intent(this, StatisticActivity::class.java)
            startActivity(intentStatisticActivity)
        }
    }

    private fun initExitButtonListener(){
        btnExit.setOnClickListener {
            finish()
        }
    }
}
