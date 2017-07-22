package app;

import javafx.scene.image.Image;

public class News {

    private String headLine;
    private String story;
    private Image thumbImage;
    private Image photoImage;

    public Image getThumbImage() {
        return thumbImage;
    }

    public void setThumbImage(Image thumbImage) {
        this.thumbImage = thumbImage;
    }

    public Image getPhotoImage() {
        return photoImage;
    }

    public void setPhotoImage(Image photoImage) {
        this.photoImage = photoImage;
    }

    public String getHeadLine() {
        return headLine;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public String getStory() {
        return story;
    }

    public void setStory(String story) {
        this.story = story;
    }
}
