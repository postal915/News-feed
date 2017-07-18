package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.FlowPane;
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
    public TextField headTextField;
    @FXML
    public ImageView imageView;
    @FXML
    public TextArea textArea;

    public static ObservableList<News> newsObservableList = FXCollections.observableArrayList();


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        listView.setItems(newsObservableList);

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
                            pImageView.setImage(new Image(item.getImage()));
                            imageView.setFitHeight(100);
                            imageView.setFitWidth(100);
                            setGraphic(pImageView);
                        }
                    }
                };
            }
        });

        listView.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            if (newValue == null){
                headTextField.setText("");
                imageView.setImage(new Image(""));
                textArea.setText("");
            }else {
                headTextField.setText(newValue.getHeadLine());
                imageView.setImage(new Image(newValue.getImage()));
                textArea.setText(newValue.getStory());
            }
        });
    }

    public void refresh(ActionEvent event){
        newsObservableList.clear();
    }

}