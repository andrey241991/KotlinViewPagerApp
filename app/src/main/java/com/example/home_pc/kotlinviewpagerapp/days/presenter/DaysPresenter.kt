package com.example.home_pc.kotlinviewpagerapp.days.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.home_pc.kotlinviewpagerapp.days.view.DAYS_CODE
import com.example.home_pc.kotlinviewpagerapp.days.view.DaysView
import com.example.home_pc.kotlinviewpagerapp.days.view.MONTHS_CODE
import com.example.home_pc.kotlinviewpagerapp.days.view.adapter.MyDaysRepositoryRowView
import com.example.home_pc.kotlinviewpagerapp.repository.DataRepository

@InjectViewState
class DaysPresenter(var dataRepository: DataRepository) : MvpPresenter<DaysView>() {

    lateinit var items: Array<String>
    var dataTypeCode: Int = 0

    override fun attachView(view: DaysView?) {
        super.attachView(view)

        when (dataTypeCode) {
            DAYS_CODE -> items = dataRepository.getArrayOfDays()
            MONTHS_CODE -> items = dataRepository.getArrayOfMonths()
        }
        viewState.showData()
    }

    fun onBindRepositoryRowViewAtPosition(position: Int, myDaysRepositoryRowView: MyDaysRepositoryRowView) {
        myDaysRepositoryRowView.setTitle(items.get(position))
    }

    fun getDaysRowsCount(): Int {
        return items.size
    }

    fun setTypeCode(typeCode: Int) {
        dataTypeCode = typeCode
    }
}