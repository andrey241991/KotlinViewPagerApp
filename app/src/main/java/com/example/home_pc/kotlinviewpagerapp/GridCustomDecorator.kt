package com.example.home_pc.kotlinviewpagerapp

import android.graphics.Rect
import android.support.v7.widget.RecyclerView
import android.view.View

class GridCustomDecorator : RecyclerView.ItemDecoration() {

    override fun getItemOffsets(outRect: Rect, view: View, parent: RecyclerView, state: RecyclerView.State) {
        super.getItemOffsets(outRect, view, parent, state)
        outRect.set(40, 10, 40, 0)
    }

}