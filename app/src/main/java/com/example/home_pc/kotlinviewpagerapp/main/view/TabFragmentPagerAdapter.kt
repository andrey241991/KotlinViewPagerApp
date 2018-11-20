package com.example.home_pc.kotlinviewpagerapp.main.view

import android.support.v4.app.Fragment
import android.support.v4.app.FragmentManager
import android.support.v4.app.FragmentPagerAdapter
import com.example.home_pc.kotlinviewpagerapp.main.presenter.MainPresenter

const val TABS_COUNT = 3
const val TAB_DAYS = 0
const val TAB_MONTH = 1
const val TAB_ZODIAC = 2
const val TAB_DAYS_TITLE = "Days"
const val TAB_MONTH_TITLE = "Months"
const val TAB_ZODIAC_TITLE = "Zodiacs"

class TabFragmentPagerAdapter(fm: FragmentManager?) : FragmentPagerAdapter(fm) {

    lateinit var presenter: MainPresenter

    override fun getItem(position: Int): Fragment {
        return presenter.getFragment(position)
    }

    override fun getCount(): Int {
        return TABS_COUNT
    }

    override fun getPageTitle(position: Int): CharSequence? {
        return presenter.getFragmentTitle(position)
    }

}




















