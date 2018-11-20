package com.example.home_pc.kotlinviewpagerapp.zodiac.view


import android.os.Bundle
import android.support.v7.widget.GridLayoutManager
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.GridLayout
import com.arellomobile.mvp.MvpAppCompatFragment
import com.arellomobile.mvp.presenter.InjectPresenter
import com.arellomobile.mvp.presenter.ProvidePresenter
import com.example.home_pc.kotlinviewpagerapp.CustomItemDecorator
import com.example.home_pc.kotlinviewpagerapp.GridCustomDecorator

import com.example.home_pc.kotlinviewpagerapp.R
import com.example.home_pc.kotlinviewpagerapp.days.view.adapter.ZodiacAdapter
import com.example.home_pc.kotlinviewpagerapp.repository.DataRepository
import com.example.home_pc.kotlinviewpagerapp.zodiac.presenter.ZodiacPresenter
import kotlinx.android.synthetic.main.fragment_days.recycler_view as recyclerView

class ZodiacsFragment : MvpAppCompatFragment(), ZodiacView {

    @InjectPresenter
    lateinit var zodiacPresenter: ZodiacPresenter

    @ProvidePresenter
    fun provideRepositoryPresenter(): ZodiacPresenter {
        var dataRepository = DataRepository(requireActivity())
        return ZodiacPresenter(dataRepository)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_zodiacs, container, false)
    }

    override fun showData() {
        var zodiacAdapter = ZodiacAdapter()
        zodiacAdapter.setPresenter(zodiacPresenter)
        recyclerView.layoutManager = GridLayoutManager(requireActivity(), 3, GridLayout.VERTICAL, false)
        var customDevider = GridCustomDecorator()
        recyclerView.addItemDecoration(customDevider)
        recyclerView.adapter = zodiacAdapter
    }


}
