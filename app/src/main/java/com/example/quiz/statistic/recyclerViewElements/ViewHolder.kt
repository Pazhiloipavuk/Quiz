package com.example.quiz.statistic.recyclerViewElements

import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.quiz.databases.model.ResultOfGame
import kotlinx.android.synthetic.main.statistic_item.view.*

class ViewHolder (view: View) : RecyclerView.ViewHolder(view) {

    fun bind(item: ResultOfGame) {
        showResult(item)
    }

    private fun showResult(item: ResultOfGame) {
        itemView.txtNameOfGamer.text = item.nameOfGamer
        itemView.txtResultOfGame.text = item.points
        itemView.txtRegime.text = item.regime
    }
}