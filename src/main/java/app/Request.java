package app;

import app.dto.News;
import app.dto.NewsItem;
import com.google.gson.Gson;
import com.sun.istack.internal.NotNull;
import javafx.application.Platform;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Request {

    private final String URL = "http://timesofindia.indiatimes.com/feeds/newsdefaultfeeds.cms?feedtype=sjson";
    private final String NO_PHOTO_AVAILABLE_URL = "http://pm1.narvii.com/6507/2d99280070544e83762e96a15409d7651e32094d_128.jpg";

    ExecutorService executorService = Executors.newSingleThreadExecutor();

    public void getNews(@NotNull ResultCallback<List<NewsItem>> resultCallback) {
        executorService.submit(() -> {
            try (
                    CloseableHttpClient client = HttpClients.createDefault();
                    CloseableHttpResponse response = client.execute(new HttpGet(URL));
            ) {
                HttpEntity entity = response.getEntity();
                if (entity != null) {
                    News news = new Gson().fromJson(IOUtils.toString(entity.getContent()), News.class);
                    Platform.runLater(() -> resultCallback.onResult(news.getNewsItem()));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    interface ResultCallback<RESULT> {

        void onResult(RESULT newsList);
    }
}
