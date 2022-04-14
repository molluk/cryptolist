package bomond.cryptolist

import android.app.Application
import android.content.SharedPreferences
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class CryptolistApplication : Application(){

    companion object {
        lateinit var instance: CryptolistApplication
            private set
    }

    private lateinit var sharedPreferences: SharedPreferences

    override fun onCreate() {
        super.onCreate()
        instance = this
        sharedPreferences =
            getSharedPreferences(packageName, MODE_PRIVATE)
    }

}