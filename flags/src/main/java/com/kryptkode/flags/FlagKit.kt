package com.kryptkode.flags

import android.content.Context
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.appcompat.content.res.AppCompatResources
import java.util.*


/**
 * Created by kryptkode on 2/4/2020.
 */
class FlagKit (private val context: Context) {

    fun getFlagForCountry(countryCode:String):Drawable?{
        return getDrawableWithCountryCode(countryCode)
    }

    fun getFlagForLocale(locale: Locale): Drawable? {
        return getDrawableWithCountryCode(locale.country)
    }

    fun getFlagForDefaultLocale(): Drawable? {
        return getFlagForLocale(Locale.getDefault())
    }

    private fun getDrawableWithCountryCode(countryCode: String):Drawable? {
        val resources = context.resources
        val resName = "flag_${countryCode.toLowerCase(Locale.US)}"
        return try {
            val resourceId: Int = resources.getIdentifier(resName, "drawable", context.packageName)
            AppCompatResources.getDrawable(context, resourceId)
        }catch (e: Resources.NotFoundException){
            null
        }
    }

}