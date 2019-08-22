package sample;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.sql.*;

public class AddScene {

    @FXML
    TextField nameField;
    @FXML
    TextField passwordField;
    @FXML
    TextField websiteField;
    @FXML
    TextArea infoField;
    @FXML
    TextField userName;
    @FXML
    TextField email;

    //Creates a new database.
    public void initialize() { }



    @FXML
    public void addBtn() {
        String text1 = nameField.getText();
        String text2 = passwordField.getText();
        String text3 = userName.getText();

        String text4 = websiteField.getText();
        String text5 = userName.getText();
        String text6 = infoField.getText();


        if (text1.length() >= 3 && text2.length() >= 1) {
            Insert(text1, text2, text3, text4, text5, text6);
        } else {
            System.out.println("Data needs to be entered in.");
        }


    }

    @FXML
    public void clearBtn() {
        String empty = "";
        nameField.setText(empty);
        passwordField.setText(empty);
        websiteField.setText(empty);
        infoField.setText(empty);
        websiteField.setText(empty);
        userName.setText(empty);
    }


    //Send commands that will not return anything.
    private void Insert(String name, String userName, String password, String email, String website, String info) {
        //Create a row and add it using sqlite.

        Database db = new Database();
        String sql = "INSERT INTO info VALUES(?, ?, ?, ?, ?, ?);";
        String list[] = {name, userName, password, email, website, info};

        db.Insert(sql, 6, list);




    }


    @FXML
    public void onBack() {
        LoadScreen screen = new LoadScreen();
        screen.Load("sample.fxml", nameField);

    }


    @FXML
    public void onView() {
        LoadScreen screen = new LoadScreen();
        screen.Load("ShowScene.fxml", nameField);
    }





}
