package com.kryptkode.flags

import android.os.Build
import com.google.common.truth.Truth.assertThat
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.RobolectricTestRunner
import org.robolectric.RuntimeEnvironment
import org.robolectric.annotation.Config
import java.util.*


/**
 * Created by kryptkode on 2/4/2020.
 */

@RunWith(RobolectricTestRunner::class)
@Config(manifest = "AndroidManifest.xml", sdk =[Build.VERSION_CODES.O])
class FlagKitTest{

    private val context = RuntimeEnvironment.application

    @Test
    fun getFlagForCountryCodes(){
        val listOfCountryCodes = DataFactory.provideCountryCodes(context)

        val flagKit = FlagKit(context)
        listOfCountryCodes.forEach {
            val result  = flagKit.getFlagForCountry(it)
            assertThat(result).isNotNull()
        }
    }


    @Test
    fun getFlagForLocale(){
        val flagKit = FlagKit(context)
        val result  = flagKit.getFlagForLocale(Locale.GERMANY)
        assertThat(result).isNotNull()
    }

    @Test
    fun getFlagForDefaultLocale(){
        val flagKit = FlagKit(context)
        val result  = flagKit.getFlagForDefaultLocale()
        assertThat(result).isNotNull()
    }

    @Test
    fun getFlagForWrongCountryCodes(){
        val flagKit = FlagKit(context)
        val result  = flagKit.getFlagForCountry("HELLO")
        assertThat(result).isNull()
    }
}