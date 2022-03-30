package ViewModels

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.navigationdrawertest.Repository.NewsRepository
import com.example.navigationdrawertest.model.News
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainViewModel(private val repository: NewsRepository):ViewModel(){

//as soon as the mainview model loads, a request is raised i.e., we call our repository to bring the data/news
    init {
    viewModelScope.launch(Dispatchers.IO) {
        //since getN is a suspend unction hence written inside viewModelScope
        //function call made to repository to get the quotes
        repository.getN(1)
    }

    }
    val n:LiveData<News>
    get() = repository.n

}