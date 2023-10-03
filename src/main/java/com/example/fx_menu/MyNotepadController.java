package com.example.fx_menu;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert.*;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.*;
import java.io.*;
import java.util.*;


public class MyNotepadController {

    @FXML       //cái này tạo mới, ban đầu tạo trong scenebuilder k có
    private TextArea txtContent;
    @FXML
    void about(ActionEvent event) {
        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("About MyNotepad");
        alert.setHeaderText("MyNotepad v1.0");
        alert.setContentText("Text file editing tool");
        alert.showAndWait();

    }

    @FXML                           //k có access to Stage nên
    void exit(ActionEvent event) {  //tạo 1 cái text ngoài primarystage, get window của nó close, rồi cast sang Stage
        ((Stage) txtContent.getScene().getWindow()).close();
    }


    File textfile = new File("textfile.txt");
    @FXML
    void open(ActionEvent event) {  //read whole file
        Scanner scan = null;
        try{
            scan = new Scanner(textfile);
            String text = "";
            while(scan.hasNext()){
                text += scan.nextLine()+"\n";  //xuống dòng mỗi lần kết thúc 1 dòng nên add \n
            }
            txtContent.setText(text);
        }catch(Exception e){
            System.out.println("Error reading file");
        }finally{
            if(scan!=null) scan.close();
        }
    }

    @FXML
    void save(ActionEvent event) {
        PrintWriter pw = null;
        try{
            pw = new PrintWriter(textfile);
            pw.println(txtContent.getText());
        }catch(Exception e){
            System.out.println("Error writing file");
        }finally{
            if(pw!=null) pw.close();
        }
    }

    @FXML
    void txtContent(MouseEvent event) {

    }

}
