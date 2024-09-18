import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.example.lab1.models.News

@Composable
fun NewsScreen(newsViewModel: NewsViewModel = viewModel()) {
    val newsList = newsViewModel.newsList

    Column(modifier = Modifier.fillMaxSize()) {
        Row(modifier = Modifier.weight(1f)) {
            NewsCard(news = newsList[0], onLike = {}, Modifier.weight(1f))
            NewsCard(news = newsList[1], onLike = {}, Modifier.weight(1f))
        }
        Row(modifier = Modifier.weight(1f)) {
            NewsCard(news = newsList[2], onLike = {}, Modifier.weight(1f))
            NewsCard(news = newsList[3], onLike = {}, Modifier.weight(1f))
        }
    }
}

@Composable
fun NewsCard(news: News, onLike: (News) -> Unit, modifier: Modifier = Modifier) {
    Box(
        modifier = modifier.padding(8.dp)
    ) {
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.SpaceBetween
        ) {
            Text(text = news.title, modifier = Modifier.weight(0.9f))
            Text(
                text = "${news.likes}",
                modifier = Modifier
                    .weight(0.1f)
                    .clickable { onLike(news) }
            )
        }
    }
}

@Preview(showBackground = true)
@Composable
fun NewsScreenPreview() {
    NewsScreen()
}
