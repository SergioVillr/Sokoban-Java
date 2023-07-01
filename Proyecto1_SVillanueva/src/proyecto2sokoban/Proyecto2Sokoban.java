/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2sokoban;

import javafx.application.Application;
import proyecto2sokoban.util.FlowController;
import javafx.stage.Stage;

/**
 *
 * @author expz
 */
public class Proyecto2Sokoban extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        FlowController.getInstance().InitializeFlow(primaryStage, null);
        FlowController.getInstance().goViewInWindow("InterfazMenu");
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}
