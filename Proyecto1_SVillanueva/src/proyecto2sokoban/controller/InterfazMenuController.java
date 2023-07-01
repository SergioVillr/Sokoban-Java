/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2sokoban.controller;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.StackPane;
import javafx.scene.media.AudioClip;
import javafx.stage.Stage;
import proyecto2sokoban.clases.Jugador;

/**
 * FXML Controller class
 *
 * @author expz
 */
public class InterfazMenuController extends  Controller implements Initializable {

    @FXML
    private JFXTextField txtFnombreJ;
    @FXML
    private JFXButton btnInciargame;
    
   
    
    Jugador jugador=new Jugador();
    @FXML
    private StackPane stackpane;
    @FXML
    private AnchorPane anchorpane;
    @FXML
    private JFXButton btnAcerca;
    
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        musicaIntroduc(1);
    }    

    @Override
    public void initialize() {
        
    }

    @FXML
    private void btnregistNombre(ActionEvent event) {
        
        if(txtFnombreJ.getText().equals("")){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Espacio en blanco");
            alert.setContentText("Debe de llenar ambos espacios");
            alert.showAndWait();
        }else{
            String nombre = txtFnombreJ.getText();
            System.out.println("entrada "+nombre);
            jugador.setNombre(nombre);
            jugador.Imprimir();
        }    
        btnInciargame.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                musicaIntroduc(2);
                try {
                    ((Node) (event.getSource())).getScene().getWindow().hide();
                    Parent root = FXMLLoader.load(getClass().getResource("/proyecto2sokoban/view/Bodygame.fxml"));
                    Stage stage = new Stage();
                    Scene scene = new Scene(root);
                    stage.setScene(scene);
                    stage.getIcons().add(new Image("/proyecto2sokoban/resource/Mario.png"));
                    stage.setTitle("PROYECTO #1 Sokoban");
                    stage.show();
                } catch (IOException ex) {
                    Logger.getLogger(InterfazMenuController.class.getName()).log(Level.SEVERE, null, ex);
                }
                
            }
        });
    }
    public void musicaIntroduc(int OnorOff){
        if(OnorOff==1){
            AudioClip mus = new AudioClip(this.getClass().getResource("/proyecto2sokoban/resource/videojuegos-.mp3").toString());
            mus.play();
        }else{
            AudioClip mus = new AudioClip(this.getClass().getResource("/proyecto2sokoban/resource/videojuegos-.mp3").toString());
            mus.stop();
        }
    }

    @FXML
    private void Acercade(ActionEvent event) {
         try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("/proyecto2sokoban/view/Acercade.fxml"));
            Parent root = loader.load();
            AcercadeController controlador = loader.getController();
            
            Scene scene = new Scene(root);
            Stage stage = new Stage();
            stage.setScene(scene);
            stage.show();
            
            stage.setOnCloseRequest(e ->controlador.closeWin());
            
            Stage mystage= (Stage) this.btnAcerca.getScene().getWindow();
//            mystage.close();
//            
        } catch (IOException ex) {
            Logger.getLogger(InterfazMenuController.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    
}
