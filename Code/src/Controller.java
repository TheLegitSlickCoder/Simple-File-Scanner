package sample;

import java.awt.*;
import java.io.File;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;

public class Controller {

    @FXML
    private ResourceBundle resources;
    @FXML
    private URL location;
    @FXML
    private TextField input;
    @FXML
    private Label output;

    @FXML
    public void initialize() {
        assert input != null : "fx:id=\"input\" was not injected: check your FXML file 'sample.fxml'.";
        assert output != null : "fx:id=\"output\" was not injected: check your FXML file 'sample.fxml'.";
    }

    /*
    * Controller Functions:
    * refresh() - When the text is changed on the input control
    * execute() - When a key is pressed on the input control, launches the file if the key was 'enter'
    * */

    @FXML
    public void refresh(KeyEvent event) {
        String enteredPath = input.getText();

        //Checks if the file exists:
        File path = new File(enteredPath);
        boolean exists = path.exists();

        //Logic for boolean:
        if (exists) {
            output.setText("Path exists: " + enteredPath);
            return;
        }
        if (!exists) {
            output.setText("Path does not exist: " + enteredPath);
        }
    }

    @FXML
    public void execute(KeyEvent event) {
        if (event.getCode() == KeyCode.ENTER) {
            String enteredPath = input.getText();
            File path = new File(enteredPath);

            if (path.exists()) {
                try {
                    Desktop.getDesktop().open(path);
                }
                catch (Exception e) {
                    return;
                }
            }
        }
    }
}