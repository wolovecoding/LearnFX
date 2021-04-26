package org.example;

import java.io.*;
import java.net.URL;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;
import javafx.stage.Stage;
import org.example.service.FileHandleService;

public class PrimaryController implements Initializable {

    @FXML
    private Button fileOpen;
    @FXML
    private Button saveFile;
    @FXML
    private TextArea myTextField;
    @FXML
    private TextField fileDir;

    private File file;
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        // TODO (don't really need to do anything here).
    }

    // When user click on myButton
    // this method will be called.
    public void showFileDir(ActionEvent event){
        Stage stage = new Stage();
        stage.setTitle("Choose File");
        FileChooser fileChooser = new FileChooser();
        fileChooser.getExtensionFilters().add(new FileChooser.ExtensionFilter("Text Files","*.txt"));
        this.file = fileChooser.showOpenDialog(stage);
        //文件处理
        FileHandleService fhs = new FileHandleService();

        if (file!=null){
            System.out.println(file.getName());
            System.out.println(file.getAbsolutePath());
            fileDir.setText(file.getAbsolutePath());
            try {
                myTextField.setText(fhs.getText(file));
                myTextField.setWrapText(true);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    public void saveFile(ActionEvent event){


        FileHandleService fhs = new FileHandleService();
        if(this.file==null){
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.setHeaderText("！！文件目录找不到！！");
            alert.setTitle("警告");
            alert.showAndWait();
        }else {
            try {
                fhs.editTextFile(fileDir.getText(),myTextField.getText());
            }
            catch (NullPointerException e){
                Alert alert = new Alert(Alert.AlertType.WARNING);
                alert.setHeaderText("！！文件目录错误！！");
                alert.setTitle("警告");
                alert.showAndWait();
            }
            catch (IOException e) {
                e.printStackTrace();
            }
        }



    }
}
