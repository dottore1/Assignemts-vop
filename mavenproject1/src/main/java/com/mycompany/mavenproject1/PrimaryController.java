/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mavenproject1;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;
import javafx.scene.control.RadioButton;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleGroup;
/**
 * FXML Controller class
 *
 * @author Nichlas
 */
public class PrimaryController implements Initializable {


    @FXML
    private RadioButton rbEllipse;
    @FXML
    private ToggleGroup buttons;
    @FXML
    private RadioButton rbRectangle;
    @FXML
    private RadioButton rbCircle;
    @FXML
    private RadioButton rbSquare;
    @FXML
    private TextField txtOne;
    @FXML
    private TextField txtTwo;
    @FXML
    private Button btnInfo;
    @FXML
    private TextArea txtArea;
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
    @FXML
    private void EllipseHandler(ActionEvent event) {
        txtTwo.setVisible(true);
    }

    @FXML
    private void rectangleHandler(ActionEvent event) {
        txtTwo.setVisible(true);
    }

    @FXML
    private void circleHandler(ActionEvent event) {
         txtTwo.setVisible(false);
    }

    @FXML
    private void squareHandler(ActionEvent event) {
        txtTwo.setVisible(false);
    }

    @FXML
    private void infoHandler(ActionEvent event) {
        if(rbEllipse.isSelected()){
            double num1; 
            double num2;
            num1 = Double.parseDouble(txtOne.getText());
            num2 = Double.parseDouble(txtTwo.getText());
            String txt = ShapeFacade.getInstance().getShapeInfo(ShapeFacade.SHAPES.ELLIPSE, new double[]{num1, num2});
            txtArea.setText(txt);
            
        } else if(rbRectangle.isSelected()){
            double num1;
            double num2;
            num1 = Double.parseDouble(txtOne.getText());
            num2 = Double.parseDouble(txtTwo.getText());
            String txt = ShapeFacade.getInstance().getShapeInfo(ShapeFacade.SHAPES.RECTANGLE, new double[]{num1,num2});
            txtArea.setText(txt);
         } else if(rbCircle.isSelected()){
             double num1; 
             num1 = Double.parseDouble(txtOne.getText());
             String txt = ShapeFacade.getInstance().getShapeInfo(ShapeFacade.SHAPES.CIRCLE, num1);
             txtArea.setText(txt);
         } else{
             double num1; 
             num1 = Double.parseDouble(txtOne.getText());
             String txt = ShapeFacade.getInstance().getShapeInfo(ShapeFacade.SHAPES.SQUARE, num1);
             txtArea.setText(txt);
         }
        
        
        
        
        
    }

}
