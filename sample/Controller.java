package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {

    @FXML
    public Button addBtn;

    @FXML
    public Button showBtn;


    public void initialize() {

    }


    @FXML
    public void onAdd() {
        LoadScreen screen = new LoadScreen();
        screen.Load("AddScene.fxml", addBtn);
    }




    /**
     * Create an epic layout that layouts everything from
     */
    @FXML
    public void onShow() {

        LoadScreen screen = new LoadScreen();
        screen.Load("ShowScene.fxml", addBtn);

    }


    @FXML
    public void onReport() {
        //Go to the next screen.

    }
}
