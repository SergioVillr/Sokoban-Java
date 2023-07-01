/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2sokoban.util;

import com.jfoenix.controls.JFXDrawer;
import java.io.IOException;
import java.util.HashMap;
import java.util.ResourceBundle;
import java.util.logging.Level;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import proyecto2sokoban.Proyecto2Sokoban;
import proyecto2sokoban.controller.Controller;

public class FlowController {

    private static FlowController INSTANCE = null;
    private static Stage mainStage;
    private static ResourceBundle idioma;

    private static HashMap<String, FXMLLoader> loaders = new HashMap<>();

    private FlowController() {
    }

    private static void createInstance() {
        if (INSTANCE == null) {
            // Sólo se accede a la zona sincronizada
            // cuando la instancia no está creada
            synchronized (FlowController.class) {
                // En la zona sincronizada sería necesario volver
                // a comprobar que no se ha creado la instancia
                if (INSTANCE == null) {
                    INSTANCE = new FlowController();
                }
            }
        }
    }

    public static FlowController getInstance() {
        if (INSTANCE == null) {
            createInstance();
        }
        return INSTANCE;
    }

    @Override
    public Object clone() throws CloneNotSupportedException {
        throw new CloneNotSupportedException();
    }

    public void InitializeFlow(Stage stage, ResourceBundle idioma) {
        getInstance();
        this.mainStage = stage;
        this.idioma = idioma;
    }

    private FXMLLoader getLoader(String name) {

        FXMLLoader loader = loaders.get(name);
        if (loader == null) {
            synchronized (FlowController.class) {
                // En la zona sincronizada sería necesario volver
                // a comprobar que no se ha creado la instancia
                if (loader == null) {
                    try {
                        loader = new FXMLLoader(Proyecto2Sokoban.class.getResource("view/" + name + ".fxml"), this.idioma);
                        loader.load();
                        loaders.put(name, loader);
                    } catch (Exception ex) {
                        loader = null;
                        java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE, "Creando loader [" + name + "].", ex);
                    }
                }
            }
        }
        return loader;
    }

    public void goMain() {
        try {
            this.mainStage.setScene(new Scene(FXMLLoader.load(Proyecto2Sokoban.class.getResource("view/HomePage.fxml"), this.idioma)));
            this.mainStage.show();
            /*goView("MenuLateral", "Left", "");
            goView("Menu");*/
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE, "Error inicializando la vista base.", ex);
        }
    }

    public void goRegister() {
        try {
            this.mainStage.setScene(new Scene(FXMLLoader.load(Proyecto2Sokoban.class.getResource("view/Register.fxml"), this.idioma)));
            this.mainStage.show();
            /*goView("MenuLateral", "Left", "");
            goView("Menu");*/
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE, "Error inicializando la vista base.", ex);
        }
    }
    
    public void goLogIng() {
        try {
            this.mainStage.setScene(new Scene(FXMLLoader.load(Proyecto2Sokoban.class.getResource("view/LogIng.fxml"), this.idioma)));
            this.mainStage.show();
            /*goView("MenuLateral", "Left", "");
            goView("Menu");*/
        } catch (IOException ex) {
            java.util.logging.Logger.getLogger(FlowController.class.getName()).log(Level.SEVERE, "Error inicializando la vista base.", ex);
        }
    }
    
    public void goView(String viewName) {
        goView(viewName, "Center", null);
    }

    public void goView(String viewName, String accion) {
        goView(viewName, "Center", accion);
    }

    public void goView(String viewName, String location, String accion) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.setAccion(accion);
        controller.initialize();
        Stage stage = controller.getStage();
        if (stage == null) {
            stage = this.mainStage;
            controller.setStage(stage);
        }
        switch (location) {
            case "Center":
                ((VBox) ((BorderPane)  stage.getScene().getRoot()).getCenter()).getChildren().clear();//lipia el vbox
                //((AnchorPane) ((BorderPane) ((AnchorPane) ((StackPane) stage.getScene().getRoot()).getChildren().get(1)).getChildren().get(0)).getCenter()).getChildren().add(loader.getRoot());
                ((VBox) ((BorderPane)  stage.getScene().getRoot()).getCenter()).getChildren().add(loader.getRoot());//trae el primer panel que queremos cargar
                break;
            case "Top":
                ((BorderPane) stage.getScene().getRoot()).setTop(loader.getRoot());
                break;
            case "Bottom":
                ((BorderPane) stage.getScene().getRoot()).setBottom(loader.getRoot());
                break;
            case "Right":
                ((BorderPane) stage.getScene().getRoot()).setRight(loader.getRoot());
                break;
            case "Left":
                ((JFXDrawer) ((AnchorPane) ((StackPane) stage.getScene().getRoot()).getChildren().get(1)).getChildren().get(1)).getSidePane().clear();
                ((JFXDrawer) ((AnchorPane) ((StackPane) stage.getScene().getRoot()).getChildren().get(1)).getChildren().get(1)).setSidePane((VBox) loader.getRoot());
                //((BorderPane) stage.getScene().getRoot()).setLeft(loader.getRoot());
                break;
            default:
                ((BorderPane) stage.getScene().getRoot()).setCenter(loader.getRoot());
        }
    }

    public void goViewInStage(String viewName, Stage stage) {
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.setStage(stage);
        stage.getScene().setRoot(loader.getRoot());
    }

    public void goViewInWindow(String viewName) {
        //VBox panel = new VBox();
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        Stage stage = new Stage();
        stage.getIcons().add(new Image("/proyecto2sokoban/resource/Mario.png"));
        stage.setTitle("PROYECTO#1 Sokoban ");
        //stage.setTitle(idioma.getString("lbl.tituloaplicacion"));
        stage.setOnHidden((WindowEvent event) -> {
            controller.setStage(null);
        });
        controller.setStage(stage);
        //panel.getChildren().add(loader.getRoot());
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    public void goViewInWindowModal(String viewName, Stage parentStage, Boolean resizable) {
        //VBox panel = new VBox();
        FXMLLoader loader = getLoader(viewName);
        Controller controller = loader.getController();
        controller.initialize();
        Stage stage = new Stage();
        stage.getIcons().add(new Image("rest/resources/Restaurant2.png"));
        stage.setTitle(this.idioma.getString("lbl.tituloaplicacion"));
        stage.setResizable(resizable);
        stage.setOnHidden((WindowEvent event) -> {
            controller.setStage(null);
        });
        controller.setStage(stage);
        //panel.getChildren().add(loader.getRoot());
        Parent root = loader.getRoot();
        Scene scene = new Scene(root);
        stage.setScene(scene);
        stage.initModality(Modality.WINDOW_MODAL);
        stage.initOwner(parentStage);
        stage.centerOnScreen();
        stage.showAndWait();

    }

    public Controller getController(String viewName) {
        return getLoader(viewName).getController();
    }

    public void salir() {
        this.mainStage.close();
    }

}
