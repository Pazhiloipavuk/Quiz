package com.example.quiz.quiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.quiz.R
import kotlinx.android.synthetic.main.activity_select_difficulty.*

class SelectDifficultyActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select_difficulty)
        initEasyButtonListener()
        initHardButtonListener()
    }

    private fun initEasyButtonListener(){
        btnEasy.setOnClickListener {
            val intentEasyDifficultyActivity = Intent(this, EasyDifficultyActivity::class.java)
            startActivity(intentEasyDifficultyActivity)
        }
    }

    private fun initHardButtonListener(){
        btnHard.setOnClickListener {
            val intentHardDifficultyActivity = Intent(this, HardDifficultyActivity::class.java)
            startActivity(intentHardDifficultyActivity)
        }
    }
}
