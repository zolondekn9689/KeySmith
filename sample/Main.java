package sample;

import com.sun.javafx.tk.Toolkit;
import com.sun.tools.classfile.Method;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.awt.*;
import java.net.URL;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        primaryStage.setTitle("Key Smith");
        primaryStage.getIcons().add(new Image("file:LockSmith.jpg"));
        primaryStage.setResizable(false);







        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();

    }



    public static void main(String[] args) {
        launch(args);
    }



}
