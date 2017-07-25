package app.dto;

/**
 * Created with Android Studio.
 * User: Sasha Shcherbinin
 * Date: 7/26/17
 * Time: 12:15 AM
 */
public class Image {

    private String Photo;
    private String Thumb;
    private String PhotoCaption;

    public String getPhoto() {
        return Photo;
    }

    public void setPhoto(String Photo) {
        this.Photo = Photo;
    }

    public String getThumb() {
        return Thumb;
    }

    public void setThumb(String Thumb) {
        this.Thumb = Thumb;
    }

    public String getPhotoCaption() {
        return PhotoCaption;
    }

    public void setPhotoCaption(String PhotoCaption) {
        this.PhotoCaption = PhotoCaption;
    }
}
