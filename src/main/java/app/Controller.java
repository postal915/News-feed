package app;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.util.Callback;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public ListView<News> listView;
    @FXML
    public Button refreshButton;
    @FXML
    public ImageView imageView;
    @FXML
    public TextFlow headTextFlow;
    @FXML
    public TextFlow newsTextFlow;

    public static ObservableList<News> newsObservableList = FXCollections.observableArrayList();
    Text headText = new Text();
    Text storyText = new Text();

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        new Request().start();
        headTextFlow.getChildren().add(headText);
        newsTextFlow.getChildren().add(storyText);
        headText.setY(10);
        addListView();
        viewNews();
        listView.setItems(newsObservableList);

    }

    public void refresh(ActionEvent event){
        newsObservableList.clear();
        new Request().start();
    }

    private void addListView(){
        listView.setCellFactory(new Callback<ListView<News>, ListCell<News>>() {
            @Override
            public ListCell<News> call(ListView<News> param) {
                return new ListCell<News>(){
                    private ImageView pImageView = new ImageView();

                    @Override
                    protected void updateItem(News item, boolean empty) {
                        super.updateItem(item, empty);
                        if (empty){
                            setText(null);
                            setGraphic(null);
                        } else {
                            setText(item.getHeadLine());
                            pImageView.setImage(item.getThumbImage());
                            setGraphic(pImageView);
                        }
                    }
                };
            }
        });
    }

    private void viewNews(){
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null){
                headText.setText("");
                imageView.setImage(null);
                storyText.setText("");
            }else {
                headText.setText(newValue.getHeadLine());
                imageView.setImage(newValue.getPhotoImage());
                storyText.setText(newValue.getStory());
            }
        });
    }
}