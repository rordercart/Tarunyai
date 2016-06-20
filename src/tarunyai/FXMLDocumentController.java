/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package tarunyai;

import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.List;
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
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;

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
        Parent main_ui = FXMLLoader.load(getClass().getResource("TarunyaiUI.fxml"));
        Scene main_scene = new Scene(main_ui);
        Stage main_stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        main_stage.setScene(main_scene);
        main_stage.show();
    }

    @FXML
    private void exitApplication(ActionEvent event) {
        System.exit(1);
        //label.setText("Hello World!");
    }

    @FXML
    public void TestConnection(ActionEvent event) throws Exception {
        System.out.println("it is a test connection ");
        System.out.println(ConnectionName.getText());
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = docFactory.newDocumentBuilder();
        Document doc = docBuilder.newDocument();
        Element rootElement = doc.createElement("DBConnection");
        doc.appendChild(rootElement);
        Element firstname = doc.createElement("connectionName");
        firstname.appendChild(doc.createTextNode(ConnectionName.getText()));
        rootElement.appendChild(firstname);
        // write the content into xml file
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(doc);
        StreamResult result = new StreamResult(new File("C:\\Users\\Dhairya\\Documents\\file.xml"));

        // Output to console for testing
        // StreamResult result = new StreamResult(System.out);
        transformer.transform(source, result);

        System.out.println("File saved!");
        //public DBConnection<db> unmarshall(){
        File file = new File("C:\\Users\\Dhairya\\Documents\\file.xml");
        System.out.println(file);
        JAXBContext jaxbContext = JAXBContext.newInstance(DBConnection.class);
       System.out.println(jaxbContext);
       Unmarshaller jaxbUnmarshaller = jaxbContext.createUnmarshaller();
       System.out.println(jaxbUnmarshaller);
       DBConnection conn = (DBConnection) jaxbUnmarshaller.unmarshal(file);
       System.out.println(conn);
       //System.out.println(conn.getConnectionName().toString());
       //conn.setConnectionName(conn.getConnectionName().toString());
       //DatabaseConnectivity dbconnectivity = new DatabaseConnectivity();
       //System.out.println(dbconnectivity.setConnectionName(conn.getConnectionName()));
      // dbconnectivity.setConnectionName(conn.getConnectionName().toString());
       //System.out.println(dbconnectivity.getConnectionName());
       
       Maindb mdb = new Maindb();
       mdb.connection(conn);

    //}
    }
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

}
