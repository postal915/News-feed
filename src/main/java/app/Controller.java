package app;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {

    @FXML
    public TableView newsTV;

    @FXML
    public TableColumn<News, String> newsTC;

    ObservableList<News> fxCollections = FXCollections.observableArrayList();

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        newsTC.setCellValueFactory(cellData -> cellData.getValue().nameProperty());
        newsTV.setItems(fxCollections);
    }

    public void refresh(ActionEvent event) {

    }
}
