package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

import java.sql.*;
import java.util.ArrayList;

public class ShowScene {


    @FXML
    public TextField searchToDelete;

    @FXML
    public GridPane grid;

    //Used to connect to a database.
    private Database db;

    private ArrayList<Node> list;

    //Reloads the page.
    private void ReloadPage() {
        LoadScreen loadScreen = new LoadScreen();
        loadScreen.Load("ShowScene.fxml", grid);
    }





    public void initialize() {
        db = new Database();

        PrintScreen();
    }


    private void PrintScreen() {

        list = db.GetVector();

        final int column = list.size();
        int gC = 0;
        int row;

        for (int i = 0; i < column; i++) {
            row = i + 2;
            Label l1 = new Label(list.get(i).GetWebsiteName());
            Label l2 = new Label(list.get(i).GetWebsiteUsername());
            Label l3 = new Label(list.get(i).GetWebsitePassword());
            Label l4 = new Label(list.get(i).GetWebsiteEmail());
            Label l5 = new Label(list.get(i).GetWebsiteURL());
            Label l6 = new Label(list.get(i).GetWebsiteInformation());

            grid.add(l1, gC, row);
            grid.add(l2, gC + 1, row);
            grid.add(l3, gC + 2, row);
            grid.add(l4, gC + 3, row);
            grid.add(l5, gC + 4, row);
            grid.add(l6, gC + 5, row);


        }
    }

    @FXML
    public void onBack()  {
        //Go back into the main screen.
        LoadScreen screen = new LoadScreen();
        screen.Load("sample.fxml", grid);
    }




    @FXML
    public void Delete() {
        String sql = "DELETE FROM info WHERE wName = ?;";


        //Get connection and create preparedstatement to delete name from textedit.
        db.Delete(sql , searchToDelete.getText());


        //Reload the page.
        try {
            ReloadPage();
        }catch (Exception e) {
            e.printStackTrace();
        }

    }


    @FXML
    public void onAdd() {
        LoadScreen loadScreen = new LoadScreen();
        loadScreen.Load("AddScene.fxml", grid);
    }





}
