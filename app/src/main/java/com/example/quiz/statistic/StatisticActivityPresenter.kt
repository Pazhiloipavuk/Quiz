package com.example.quiz.statistic

import com.example.quiz.databases.ServiceDBSql

class StatisticActivityPresenter {
    private var statisticActivity: StatisticActivityInterface

    private var serviceDBSql: ServiceDBSql

    constructor(statisticActivity: StatisticActivityInterface){
        this.statisticActivity = statisticActivity
        serviceDBSql = ServiceDBSql(statisticActivity.getContext())
    }

    fun getAllResults() = serviceDBSql.viewResults()
}