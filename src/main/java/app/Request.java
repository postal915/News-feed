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
        request();
        parser();
    }

    private void parser() {
        JsonParser jsonParser = new JsonParser();
        JsonObject jsonObject = jsonParser.parse(json).getAsJsonObject();
        JsonArray jsonArray = jsonObject.getAsJsonArray("NewsItem");
        for (JsonElement jsonElement : jsonArray) {
            JsonObject object = jsonElement.getAsJsonObject();
            News news = new News();

            news.setNewsItemId(object.get("NewsItemId").toString());
            news.setHeadLine(object.get("HeadLine").toString());
            news.setAgency(object.get("Agency").toString());
            news.setDateLine(object.get("DateLine").toString());
            news.setWebURL(object.get("WebURL").toString());
            news.setCaption(object.get("Caption").toString());
            news.setImage(object.get("Image").toString());
            news.setKeywords(object.get("Keywords").toString());
            news.setStory(object.get("Story").toString());
            news.setCommentCountUrl(object.get("CommentCountUrl").toString());
            news.setCommentFeedUrl(object.get("CommentFeedUrl").toString());
            news.setRelated(object.get("Related").toString());

            Controller.fxCollections.add(news);
        }
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
