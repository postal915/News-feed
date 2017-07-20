package app;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

import java.io.IOException;

public class Request {

    private final String URL = "http://timesofindia.indiatimes.com/feeds/newsdefaultfeeds.cms?feedtype=sjson";
    private String json = "";

    public void start() {
        new Thread(() -> {
            request();
            parser();
        }).start();
    }

    private void parser() {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("NewsItem");
        for (JsonElement jsonElement : jsonArray) {
            JsonObject object = jsonElement.getAsJsonObject();
            News news = new News();

            news.setHeadLine(object.get("HeadLine").toString());
            String temp = object.get("Image").toString();
            news = parserPhoto(news, temp);

            news.setStory(object.get("Story").toString());

            Controller.newsObservableList.add(news);
        }
    }

    private News parserPhoto(News news, String temp) {

        int firstIndex = temp.indexOf("\"Photo\":\"");
        int lastIndex = temp.indexOf("\",\"Thumb\":\"");
        String s = temp.substring(firstIndex + 9, lastIndex);
        news.setPhoto(s);

        firstIndex = temp.indexOf("\"Thumb\":\"");
        lastIndex = temp.lastIndexOf("\",\"");
        temp = temp.substring(firstIndex + 9, lastIndex);
        news.setThumb(temp);

        return news;
    }

    private void request() {
        try (
                CloseableHttpClient client = HttpClients.createDefault();
                CloseableHttpResponse response = client.execute(new HttpGet(URL));
        ) {
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                json += IOUtils.toString(entity.getContent());
            }
        } catch (ClientProtocolException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
