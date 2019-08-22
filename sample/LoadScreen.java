package sample;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import javafx.stage.Window;

public class LoadScreen {


    //Filename for the type of fxml file.
    private String FileName;

    //Used to relate to any window or stage.
    private Node Node;




    /**
     * Loads up a new window with minimum effort.
     * @param fileName: Filename.fxml
     * @param node
     */
    public void Load(String fileName, Node node) {
        SetDefaults(fileName, node);

        try {
            Scene scene;
            Stage stage;
            Parent root;

            stage = GetStage();
            root = GetLoader(fileName);

            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Invalid fileName or Button. ");
            alert.setContentText(e.getMessage());
            alert.show();
        }

    }




    public void LoadFxmlDefault(String fileNameWithoutFxml, Node node) {
        final String fileName = fileNameWithoutFxml + ".fxml";
        SetDefaults(fileName, node);

        try {
            Scene scene;
            Stage stage;
            Parent root;

            stage = GetStage();
            root = GetLoader(fileName);

            scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        }catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText("Filename or Node error. ");
            alert.setContentText(e.getMessage());
            alert.show();
        }
    }



    public void SetDefaults(String fileName, Node node) {
        SetFileName(fileName);
        SetNode(node);
    }

    public void SetNode(Node nNode) {
        this.Node = nNode;
    }

    public void SetFileName(String fileName) {
        this.FileName = fileName;
    }


    public String GetFileName() {
        return this.FileName;
    }


    public Stage GetStage() {
        return (Stage) GetWindow();
    }



    public Window GetWindow() {
        return (Node.getScene().getWindow());
    }


    //Reloads the load function.
    public void Reload() {
        Load(this.FileName, this.Node);
    }


    private Parent GetLoader(String fileName) throws Exception {
        return FXMLLoader.load(getClass().getResource(fileName));
    }



}
