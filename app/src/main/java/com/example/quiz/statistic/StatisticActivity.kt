package com.example.quiz.statistic

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.quiz.R
import com.example.quiz.statistic.recyclerViewElements.ResultOfGameAdapter
import kotlinx.android.synthetic.main.activity_statistic.*

class StatisticActivity : AppCompatActivity(), StatisticActivityInterface {

    private var statisticActivityPresenter: StatisticActivityPresenter = StatisticActivityPresenter(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_statistic)
        connectRecyclerView()
    }

    private fun connectRecyclerView(){
        rvStatistic.layoutManager = LinearLayoutManager(this)
        val myAdapter = ResultOfGameAdapter(statisticActivityPresenter.getAllResults())
        rvStatistic.adapter = myAdapter
    }

    override fun getContext() = this
}
