package com.example.home_pc.kotlinviewpagerapp.repository

import android.content.Context
import com.example.home_pc.kotlinviewpagerapp.R

class DataRepository(context: Context) {

    var context = context

    fun getArrayOfDays(): Array<String> {
        return context.resources.getStringArray(R.array.days)
    }

    fun getArrayOfMonths(): Array<String> {
        return context.resources.getStringArray(R.array.months)
    }

    fun getArrayOfZodiacNames(): Array<String> {
        return  context.resources.getStringArray(R.array.zodiac_names)
    }

    fun getArrayOfZodiacPictures(): Array<Int> {
        return arrayOf(
            R.drawable.oven, R.drawable.telec, R.drawable.rac,
            R.drawable.riba, R.drawable.vodoley, R.drawable.lev, R.drawable.kozerog,
            R.drawable.vesi, R.drawable.deva, R.drawable.scorpion, R.drawable.strelec, R.drawable.blizneci
        )
    }

}
