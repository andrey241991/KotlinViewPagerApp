package com.example.home_pc.kotlinviewpagerapp.days.view


import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.home_pc.kotlinviewpagerapp.CustomItemDecorator

import com.example.home_pc.kotlinviewpagerapp.R
import com.example.home_pc.kotlinviewpagerapp.days.presenter.DaysPresenter
import com.example.home_pc.kotlinviewpagerapp.days.view.adapter.DayAdapter
import com.example.home_pc.kotlinviewpagerapp.days.view.adapter.ZodiacAdapter
import com.example.home_pc.kotlinviewpagerapp.repository.DataRepository
import kotlinx.android.synthetic.main.fragment_days.recycler_view as recyclerView

const val DAYS_CODE = 100
const val MONTHS_CODE = 200
const val ZODIAC_CODE = 300
const val TYPE_CODE = "TYPE_CODE"

open class DaysFragment : MvpAppCompatFragment(), DaysView {

    @InjectPresenter
    lateinit var daysPresenter: DaysPresenter

    @ProvidePresenter
    fun provideRepositoryPresenter(): DaysPresenter {
        var dataRepository = DataRepository(requireActivity())
        return DaysPresenter(dataRepository)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        if(arguments != null){
            var typeCode = arguments!!.getInt(TYPE_CODE)
            daysPresenter.setTypeCode(typeCode)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_days, container, false)
    }

    override fun showData() {
        var dayAdapter = DayAdapter()
        dayAdapter.setPresenter(daysPresenter)
        recyclerView.layoutManager = LinearLayoutManager(requireActivity(), LinearLayoutManager.VERTICAL, false)
        var customDevider = CustomItemDecorator()
        recyclerView.addItemDecoration(customDevider)
        recyclerView.adapter = dayAdapter
    }


}
