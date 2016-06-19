/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarunyai;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;

import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Dhairya
 */
public class FXMLDocumentController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private TextField ConnectionName;
    
    
    
    
    
    @FXML
    private void handleButtonAction(ActionEvent event) throws IOException {
     Parent main_ui= FXMLLoader.load(getClass().getResource("TarunyaiUI.fxml"));
     Scene main_scene = new Scene(main_ui);
     Stage main_stage = (Stage)((Node) event.getSource()).getScene().getWindow();
     main_stage.setScene(main_scene);
     main_stage.show();
     }
    @FXML
    private void exitApplication(ActionEvent event) {
        System.exit(1);
        //label.setText("Hello World!");
    }
    @FXML
    private void TestConnection(ActionEvent event) {
        System.out.println("it is a test connection ");
       System.out.println(ConnectionName.getText());
    }
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }    
    
}
