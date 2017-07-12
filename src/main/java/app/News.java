package app;

public class News {

    public News(String newsItemId, String headLine, String byLine, String agency, String dateLine, String webURL, String caption, String image,
                String photoCaption, String keywords, String story, String commentCountUrl, String commentFeedUrl, String related) {
        this.newsItemId = newsItemId;
        this.headLine = headLine;
        this.byLine = byLine;
        this.agency = agency;
        this.dateLine = dateLine;
        this.webURL = webURL;
        this.caption = caption;
        this.image = image;
        this.photoCaption = photoCaption;
        this.keywords = keywords;
        this.story = story;
        this.commentCountUrl = commentCountUrl;
        this.commentFeedUrl = commentFeedUrl;
        this.related = related;
    }

    private String newsItemId;
    private String headLine;
    private String byLine;
    private String agency;
    private String dateLine;
    private String webURL;
    private String caption;
    private String image;
    private String photoCaption;
    private String keywords;
    private String story;
    private String commentCountUrl;
    private String commentFeedUrl;
    private String related;

}
