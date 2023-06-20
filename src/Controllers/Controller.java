package Controllers;

import java.io.File;
import java.io.FileNotFoundException;
import java.net.URL;
import java.util.ResourceBundle;

import Models.Model;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class Controller {
    Model m;

  @FXML
    private TextArea Texto;

    @FXML
    private ToggleButton bold;

    @FXML
    private ToggleButton italic;

    @FXML
    private MenuBar menu;

    @FXML
    private MenuItem open;

    @FXML
    private MenuItem save;

    @FXML
    private Stage stage;


    @FXML
    void onOpen(ActionEvent event) {
        try {
            File f = m.abrirDoc();
            if(f == null){
                Alert a = new Alert(AlertType.NONE,"Archivo no valido",ButtonType.CLOSE);
                a.setTitle("Error");
                a.show();
                return;
            }
            String s = m.openFile(f);
            Texto.setText(s);
        } catch (FileNotFoundException e) {
            Alert a = new Alert(AlertType.NONE, e.getMessage(), ButtonType.CLOSE);
            a.setTitle("Error");
            a.show();
        }

    }

    @FXML
    void onSave(ActionEvent event) {
        try {
            m.saveDoc(Texto.getText());
        } catch (FileNotFoundException e) {
            Alert a = new Alert(AlertType.NONE, e.getMessage(), ButtonType.CLOSE);
            a.setTitle("Error");
            a.show();
        }
    }

    @FXML
    void initialize() {
        m = new Model();
        stage.sizeToScene();
        stage.centerOnScreen();
    }

    @FXML
    void onChangeTexto(StringProperty sp, String vi, String nu){

    }
}
