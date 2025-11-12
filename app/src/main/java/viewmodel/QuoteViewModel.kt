package viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import model.QuoteModel
import model.QuoteProvider

class QuoteViewModel : ViewModel() {
    val quoteModel = MutableLiveData<QuoteModel>()

    fun nextQuote() {
        val currentQuote = QuoteProvider.next()
        quoteModel.postValue(currentQuote)
    }
}