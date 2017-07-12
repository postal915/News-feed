package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    public static ObservableList<News> fxCollections = FXCollections.observableArrayList();
    @FXML
    public TableView newsTV;
    @FXML
    public TableColumn<News, String> newsTC;
    Request request = new Request();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        newsTC.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        request.start();
        newsTV.setItems(fxCollections);
    }
}


