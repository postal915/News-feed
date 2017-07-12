package app;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class News {

    public News(){
        headLine = "Тестовый заголовок";
    }

    private String newsItemId;
    private String headLine;
    private String agency;
    private String dateLine;
    private String webURL;
    private String caption;
    private String image;
    private String keywords;
    private String story;
    private String commentCountUrl;
    private String commentFeedUrl;
    private String related;

    public StringProperty nameProperty() {
        return new SimpleStringProperty(headLine);
    }

    public void setNewsItemId(String newsItemId) {
        this.newsItemId = newsItemId;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public void setAgency(String agency) {
        this.agency = agency;
    }

    public void setDateLine(String dateLine) {
        this.dateLine = dateLine;
    }

    public void setWebURL(String webURL) {
        this.webURL = webURL;
    }

    public void setCaption(String caption) {
        this.caption = caption;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void setKeywords(String keywords) {
        this.keywords = keywords;
    }

    public void setStory(String story) {
        this.story = story;
    }

    public void setCommentCountUrl(String commentCountUrl) {
        this.commentCountUrl = commentCountUrl;
    }

    public void setCommentFeedUrl(String commentFeedUrl) {
        this.commentFeedUrl = commentFeedUrl;
    }

    public void setRelated(String related) {
        this.related = related;
    }

}
