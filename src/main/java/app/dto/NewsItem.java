package app.dto;

/**
 * Created with Android Studio.
 * User: Sasha Shcherbinin
 * Date: 7/26/17
 * Time: 12:15 AM
 */
public class NewsItem {

    private String NewsItemId;
    private String HeadLine;
    private String ByLine;
    private String Agency;
    private String DateLine;
    private String WebURL;
    private String Caption;
    private Image Image;
    private String Keywords;
    private String Story;
    private String CommentCountUrl;
    private String CommentFeedUrl;
    private String Related;

    public String getNewsItemId() {
        return NewsItemId;
    }

    public void setNewsItemId(String NewsItemId) {
        this.NewsItemId = NewsItemId;
    }

    public String getHeadLine() {
        return HeadLine;
    }

    public void setHeadLine(String HeadLine) {
        this.HeadLine = HeadLine;
    }

    public String getByLine() {
        return ByLine;
    }

    public void setByLine(String ByLine) {
        this.ByLine = ByLine;
    }

    public String getAgency() {
        return Agency;
    }

    public void setAgency(String Agency) {
        this.Agency = Agency;
    }

    public String getDateLine() {
        return DateLine;
    }

    public void setDateLine(String DateLine) {
        this.DateLine = DateLine;
    }

    public String getWebURL() {
        return WebURL;
    }

    public void setWebURL(String WebURL) {
        this.WebURL = WebURL;
    }

    public String getCaption() {
        return Caption;
    }

    public void setCaption(String Caption) {
        this.Caption = Caption;
    }

    public Image getImage() {
        return Image;
    }

    public void setImage(Image Image) {
        this.Image = Image;
    }

    public String getKeywords() {
        return Keywords;
    }

    public void setKeywords(String Keywords) {
        this.Keywords = Keywords;
    }

    public String getStory() {
        return Story;
    }

    public void setStory(String Story) {
        this.Story = Story;
    }

    public String getCommentCountUrl() {
        return CommentCountUrl;
    }

    public void setCommentCountUrl(String CommentCountUrl) {
        this.CommentCountUrl = CommentCountUrl;
    }

    public String getCommentFeedUrl() {
        return CommentFeedUrl;
    }

    public void setCommentFeedUrl(String CommentFeedUrl) {
        this.CommentFeedUrl = CommentFeedUrl;
    }

    public String getRelated() {
        return Related;
    }

    public void setRelated(String Related) {
        this.Related = Related;
    }

}
