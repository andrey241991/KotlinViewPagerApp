package com.example.home_pc.kotlinviewpagerapp.days.view.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.example.home_pc.kotlinviewpagerapp.R
import com.example.home_pc.kotlinviewpagerapp.zodiac.presenter.ZodiacPresenter
import com.example.home_pc.kotlinviewpagerapp.zodiac.view.adapter.ZodiacRowView


class ZodiacAdapter : RecyclerView.Adapter<ZodiacAdapter.ViewHolder>() {

    lateinit var zodiacPresenter: ZodiacPresenter

    override fun onCreateViewHolder(viewGroup: ViewGroup, position: Int): ViewHolder {
        var view = LayoutInflater.from(viewGroup.context).inflate(R.layout.zodiac_item, viewGroup, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return zodiacPresenter.getZodiacRowsCount()
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        zodiacPresenter.onBindRepositoryRowViewAtPosition(position, holder);
    }

    fun setPresenter(zodiacPresenter: ZodiacPresenter){
        this.zodiacPresenter = zodiacPresenter
    }

    class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView), ZodiacRowView {

        override fun setTitle(title: String) {
            var textView = itemView.findViewById<TextView>(R.id.text_view)
            textView.text = title
        }

        override fun setImage(image: Int) {
            var imageView = itemView.findViewById<ImageView>(R.id.image_view)
            imageView.setImageResource(image)
        }

    }
}