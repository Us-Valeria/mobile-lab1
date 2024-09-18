import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab1.models.News
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    val newsList = mutableStateListOf(
        News(1, "Новость 1"),
        News(2, "Новость 2"),
        News(3, "Новость 3"),
        News(4, "Новость 4"),
        News(5, "Новость 5"),
        News(6, "Новость 6"),
        News(7, "Новость 7"),
        News(8, "Новость 8"),
        News(9, "Новость 9"),
        News(10, "Новость 10")
    )

    init {
        viewModelScope.launch {
            while (true) {
                delay(5000)
                replaceRandomNews()
            }
        }
    }
    private fun replaceRandomNews() {
        val randomNews = newsList.random()
        val indexToReplace = (0..3).random()
        newsList[indexToReplace] = randomNews.copy(likes = randomNews.likes)
    }
}


