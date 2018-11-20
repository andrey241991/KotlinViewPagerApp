package com.example.home_pc.kotlinviewpagerapp.zodiac.presenter

import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.home_pc.kotlinviewpagerapp.R
import com.example.home_pc.kotlinviewpagerapp.repository.DataRepository
import com.example.home_pc.kotlinviewpagerapp.zodiac.view.ZodiacView
import com.example.home_pc.kotlinviewpagerapp.zodiac.view.adapter.ZodiacRowView

@InjectViewState
class ZodiacPresenter(var dataRepository: DataRepository) : MvpPresenter<ZodiacView>() {

   lateinit var items: Array<String>
   lateinit var pictures: Array<Int>

    override fun attachView(view: ZodiacView?) {
        super.attachView(view)
        items = dataRepository.getArrayOfZodiacNames()
        pictures = dataRepository.getArrayOfZodiacPictures()
        viewState.showData()
    }

    fun getZodiacRowsCount(): Int {
       return items.size
    }

    fun onBindRepositoryRowViewAtPosition(position: Int, zodiacRowView: ZodiacRowView) {
        zodiacRowView.setImage(pictures[position])
        zodiacRowView.setTitle(items[position])
    }
}