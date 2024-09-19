import androidx.compose.runtime.mutableStateListOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.lab1.models.News
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

class NewsViewModel : ViewModel() {

    val newsList = mutableStateListOf(
        News(1, "Ученые обнаружили новую экзопланету в зоне обитаемости."),
        News(2, "Космический телескоп Хаббл сделал уникальные снимки туманности Орла."),
        News(3, "NASA объявило о планах на миссию к Европе, луне Юпитера."),
        News(4, "Астрономы нашли следы воды на Марсе."),
        News(5, "Запущен новый спутник для наблюдения за атмосферой Земли."),
        News(6, "Комета, которую можно увидеть невооруженным глазом, приближается к Земле."),
        News(7, "Исследование черных дыр: новые открытия о их вращении."),
        News(8, "Солнечное затмение: когда и где его можно увидеть."),
        News(9, "Астрономы объяснили происхождение гамма-всплесков."),
        News(10, "Запуск нового космического телескопа для изучения экзопланет.")
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
    fun increaseLikes(news: News) {
        val index = newsList.indexOf(news)
        if (index != -1) {
            newsList[index] = news.copy(likes = news.likes + 1)
        }
    }
}


