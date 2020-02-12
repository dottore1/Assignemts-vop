package com.mycompany.oevelsestime2;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.Scanner;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

public class PrimaryController implements Initializable {

    @FXML
    Button btnDestroyAll;
    @FXML
    Button btnOpen;
    @FXML
    Button btnSaveAs;
    @FXML
    TextField txtSearch;
    @FXML
    TextField txtDestroy;
    @FXML
    TextArea txtArea;

    javafx.stage.FileChooser chooser;
    File file;
    File saveFile;

    @FXML
    private void handleDestroyAll(ActionEvent action) {

        Searcher sc = new Searcher(this.file);
        txtArea.clear();
        System.out.println(txtSearch.getText());
        System.out.println(txtDestroy.getText());
        txtArea.setText(sc.destroyAll(txtSearch.getText(), txtDestroy.getText()));

    }

    @FXML
    private void handleOpen() {

        this.file = chooser.showOpenDialog(btnOpen.getScene().getWindow());
        Scanner sc = null;
        try {
            sc = new Scanner(file);
            String toSend = "";
            while (sc.hasNextLine()) {

                toSend += sc.nextLine() + "\n";

            }
            txtArea.setText(toSend);
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } finally {
            sc.close();
        }

    }

    @FXML
    private void handleSave(ActionEvent event) {
        saveFile = chooser.showOpenDialog(btnDestroyAll.getScene().getWindow());
        PrintWriter pw = null;
        try {
            pw = new PrintWriter(saveFile);
            pw.write(txtArea.getText());
            
            
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        }
        finally{
            pw.close();
        }

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        chooser = new FileChooser();
        chooser.setInitialDirectory(new File("."));

    }

}
