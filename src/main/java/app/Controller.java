package app;

import app.dto.NewsItem;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public ListView<NewsItem> listView;
    @FXML
    public Button refreshButton;
    @FXML
    public ImageView imageView;
    @FXML
    public TextFlow headTextFlow;
    @FXML
    public TextFlow newsTextFlow;

    ObservableList<NewsItem> newsObservableList = FXCollections.observableArrayList();
    private Request request = new Request();

    Text headText = new Text();
    Text storyText = new Text();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        headTextFlow.getChildren().add(headText);
        newsTextFlow.getChildren().add(storyText);
        headText.setY(10);
        addListView();
        viewNews();
        listView.setItems(newsObservableList);
        updateNews();
    }

    public void refresh(ActionEvent event) {
        newsObservableList.clear();
        updateNews();
    }

    private void updateNews() {
        request.getNews(newsList -> newsObservableList.setAll(newsList));
    }

    private void addListView() {
        listView.setCellFactory(param -> new ListCell<NewsItem>() {
            private ImageView pImageView = new ImageView();

            @Override
            protected void updateItem(NewsItem item, boolean empty) {
                super.updateItem(item, empty);
                if (empty) {
                    setText(null);
                    setGraphic(null);
                } else {
                    setText(item.getHeadLine());
                    pImageView.setImage(new Image(item.getImage().getThumb()));
                    setGraphic(pImageView);
                }
            }
        });
    }

    private void viewNews() {
        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null) {
                headText.setText("");
                imageView.setImage(null);
                storyText.setText("");
            } else {
                headText.setText(newValue.getHeadLine());
                imageView.setImage(new Image(newValue.getImage().getPhoto()));
                storyText.setText(newValue.getStory());
            }
        });
    }
}