package com.example.home_pc.kotlinviewpagerapp.main.view

import android.os.Bundle
import com.arellomobile.mvp.MvpAppCompatActivity
import com.arellomobile.mvp.presenter.InjectPresenter
import com.example.home_pc.kotlinviewpagerapp.R
import com.example.home_pc.kotlinviewpagerapp.main.presenter.MainPresenter
import kotlinx.android.synthetic.main.activity_main.tab_layout as tabLayout
import kotlinx.android.synthetic.main.activity_main.view_pager as viewPager

class MainActivity : MvpAppCompatActivity(), MainView {

    @InjectPresenter
    lateinit var mainPresenter: MainPresenter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun initAdapter() {
        var adapter = TabFragmentPagerAdapter(supportFragmentManager)
        adapter.presenter = mainPresenter
        viewPager.adapter = adapter
        tabLayout.setupWithViewPager(viewPager)
    }
}
