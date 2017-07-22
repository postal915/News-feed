package app;

import com.google.gson.JsonArray;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;
import javafx.application.Platform;
import javafx.scene.image.Image;
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
    private final String NO_PHOTO_AVAILABLE_URL = "http://pm1.narvii.com/6507/2d99280070544e83762e96a15409d7651e32094d_128.jpg";
    private String json = "";

    public void start() {
        Platform.runLater(() -> {
            request();
            parser();
        });

//        new Thread(() -> {
//            request();
//            parser();
//        }).start();

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
        if (s.length() == 53) {
            news.setPhotoImage(new Image(NO_PHOTO_AVAILABLE_URL));
        } else {
            news.setPhotoImage(new Image(s));
        }

        firstIndex = temp.indexOf("\"Thumb\":\"");
        lastIndex = temp.lastIndexOf("\",\"");
        temp = temp.substring(firstIndex + 9, lastIndex);
        if (temp.length() == 53) {
            news.setThumbImage(new Image(NO_PHOTO_AVAILABLE_URL));
        } else {
            news.setThumbImage(new Image(temp));
        }

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
