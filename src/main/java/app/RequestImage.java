package app;

import javafx.scene.image.Image;

public class RequestImage implements Runnable {

    private String photoUrl;
    private String thumbUrl;
    private String type;

    public RequestImage(String photo, String thumb, String type) {
        photoUrl = photo;
        thumbUrl = thumb;
        this.type = type;
    }

    private Image photo;
    private Image thumb;

    private void setPhoto(String photo){
        this.photo = new Image(photo);
    }

    private void setThumb(String thumb){
        this.thumb = new Image(thumb);
    }

    public Image getPhoto() {
        return photo;
    }

    public Image getThumb() {
        return thumb;
    }

    @Override
    public void run() {
        if (type.equals("thumb")){
            setThumb(thumbUrl);
        } else {
            setPhoto(photoUrl);
        }
    }
}
