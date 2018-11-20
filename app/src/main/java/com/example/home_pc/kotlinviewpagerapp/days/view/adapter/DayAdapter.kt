package com.example.home_pc.kotlinviewpagerapp.days.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.home_pc.kotlinviewpagerapp.R
import com.example.home_pc.kotlinviewpagerapp.days.presenter.DaysPresenter


class DayAdapter : RecyclerView.Adapter<DayAdapter.ViewHolder>() {

    lateinit var daysPresenter: DaysPresenter

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        var view = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_element, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return daysPresenter.getDaysRowsCount()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        daysPresenter.onBindRepositoryRowViewAtPosition(position, holder);
    }

    fun setPresenter(daysPresenter: DaysPresenter){
        this.daysPresenter = daysPresenter
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), MyDaysRepositoryRowView{

        override fun setTitle(title: String) {
            var textView = itemView.findViewById<TextView>(R.id.text_view)
            textView.text = title
        }

    }
}