package com.example.home_pc.kotlinviewpagerapp.main.presenter

import android.os.Bundle
import android.support.v4.app.Fragment
import android.util.Log
import com.arellomobile.mvp.InjectViewState
import com.arellomobile.mvp.MvpPresenter
import com.example.home_pc.kotlinviewpagerapp.days.view.DAYS_CODE
import com.example.home_pc.kotlinviewpagerapp.days.view.DaysFragment
import com.example.home_pc.kotlinviewpagerapp.days.view.MONTHS_CODE
import com.example.home_pc.kotlinviewpagerapp.days.view.TYPE_CODE
import com.example.home_pc.kotlinviewpagerapp.main.view.*
import com.example.home_pc.kotlinviewpagerapp.zodiac.view.ZodiacsFragment

@InjectViewState
class MainPresenter : MvpPresenter<MainView>() {

    override fun onFirstViewAttach() {
        super.onFirstViewAttach()
        viewState.initAdapter()
    }

    fun getFragment(position: Int): Fragment {
        val bundle = Bundle()
        var fragment: Fragment = DaysFragment()

        if (position == TAB_DAYS) {
            bundle.putInt(TYPE_CODE, DAYS_CODE)
            fragment = DaysFragment()
            fragment.arguments = bundle
        }

        if (position == TAB_MONTH) {
            bundle.putInt(TYPE_CODE, MONTHS_CODE)
            fragment = DaysFragment()
            fragment.arguments = bundle
        }

        if (position == TAB_ZODIAC) {
            fragment = ZodiacsFragment()
        }
        return fragment
    }

    fun getFragmentTitle(position: Int): CharSequence? {
        when(position){
            TAB_DAYS -> return TAB_DAYS_TITLE
            TAB_MONTH -> return TAB_MONTH_TITLE
            TAB_ZODIAC -> return TAB_ZODIAC_TITLE
        }
        return TAB_DAYS_TITLE
    }

}