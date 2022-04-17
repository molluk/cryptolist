package bomond.cryptolist.ui.home

import androidx.lifecycle.ViewModel
import bomond.cryptolist.di.data.HomeData
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class HomeViewModel @Inject constructor(

) : ViewModel() {

    val coinsList = mutableListOf<HomeData.Element>()

}