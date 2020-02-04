package com.kryptkode.flags

import android.content.Context


/**
 * Created by kryptkode on 2/4/2020.
 */
object DataFactory {
    fun provideCountryCodes(context: Context): List<String> {
        return context.resources.getStringArray(R.array.country_codes_a_z).toList()
    }
}