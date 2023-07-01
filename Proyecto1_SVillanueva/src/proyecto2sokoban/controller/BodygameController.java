/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2sokoban.controller;

import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Priority;
import javafx.scene.media.AudioClip;
import proyecto2sokoban.clases.Mapas;

/**
 * FXML Controller class
 *
 * @author expz
 */
public class BodygameController implements Initializable {
    /**
     * Initializes the controller class.
     */
    
    
    @FXML
    private AnchorPane anchorpane;
     @FXML
    private Button btn1;
    @FXML
    private Button btn2;
    @FXML
    private Button btn3;
//    @FXML
//    private Button btnNext;
    @FXML
    private Button btn4;
    @FXML
    private Button btn5;
    @FXML
    private Button btn6;
    
    
    //***   Objetos a manipular    ******
    final ImageView Mario = new ImageView("/proyecto2sokoban/resource/Mario.png");
    
    //Imagenes de las cajas
    public ImageView mgC1 = new ImageView("/proyecto2sokoban/resource/images.png");
    public ImageView mgC2 = new ImageView("/proyecto2sokoban/resource/images.png");
    public ImageView mgC3 = new ImageView("/proyecto2sokoban/resource/images.png");
    
    //Imagenes para acciones
    public Image win=new Image("/proyecto2sokoban/resource/Mariometa.png");
    public Image box=new Image("/proyecto2sokoban/resource/images.png");
    ImageView imagenwinner = new ImageView(win);
    ImageView over = new ImageView("/proyecto2sokoban/resource/Over.png");
    Image cambio1= new Image("/proyecto2sokoban/resource/max.jpg");
    Image cambio2 = new Image("/proyecto2sokoban/resource/screen.jpg");
    Image cambio3 = new Image("/proyecto2sokoban/resource/Fondo3.jpg");
    
    int changeImage=0;
    
    //Array para guardar movimientos
    public  ArrayList<String> input = new ArrayList<String>();
    
    //Variables para estado de objetos
    int winner=0;
    int gameover =0;
    int estadobtn=0;
    
    //MAPAS
    int nummapa=0;
    @FXML
    private Button btnP;
    @FXML
    private Button btnNext;
    @FXML
    private Button btnSilence;
    @FXML
    private Button btncambiar;
    @FXML
    private ImageView ImageFondo;
   
    @Override
    public void initialize(URL url, ResourceBundle rb) {
//        btnNext.setVisible(false);
btncambiar.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        changeImage++;
                        System.out.println("valor de la imagen"+changeImage);
                        if(changeImage==1){
                            ImageFondo.setImage(cambio1);
                        }
                        if(changeImage==2){
                            ImageFondo.setImage(cambio2);
//                            
                        }
                        if(changeImage==3){
                            ImageFondo.setImage(cambio3);
                            changeImage=0;
                        }
                    }
                });
        // TODO
    }    
    
    public void Dibujarmapa(Integer mapa[][],int maps){
//        btnP.setVisible(false);
        
//        btnNext.setVisible(false);
        winner=0;
        gameover=0;
        nummapa=maps;
        //SE INICIAN LAS IMAGENES DE LAS CAJAS
        mgC1.setImage(box);
        mgC2.setImage(box);
        mgC3.setImage(box);
        Mapas map=new Mapas();
        //Cargo la posiciones de los objetos que van a estar en el mapa
        int transferir;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                transferir=mapa[i][j];
                map.cargar(i,j,transferir);
                System.out.print(transferir);
            }System.out.println(" ");
        }
        System.out.println("step1");
        
        map.imprimr();//metodo para comprobar la carga de datos
        
        GridPane escudo = new GridPane();
        escudo.getChildren().clear();
        //  For para cargar la pasicion de las metas
        for(int i = 0;i<8;i++){
            for(int j=0;j<8;j++){
                int c=map.mapa1(i,j);
                if(c==2||c==6||c==10||c==14){//ASIGNA LAS METAS
                    ImageView mgE = new ImageView("/proyecto2sokoban/resource/Estrellameta.png");
                    mgE.setFitHeight(40);
                    mgE.setFitWidth(40);
                    GridPane.setVgrow(mgE, Priority.ALWAYS);
                    GridPane.setHgrow(mgE, Priority.ALWAYS);
                    escudo.add(mgE, j, i);
                }
            }
        }
        for(int i = 0;i<8;i++){
            for(int j=0;j<8;j++){
                    int c=map.mapa1(i,j);
                if(c==1){//ASIGNA LOS MUROS
                    ImageView mgB = new ImageView("/proyecto2sokoban/resource/Bloque.jpg");
                    mgB.setFitHeight(40);
                    mgB.setFitWidth(40);   
                    GridPane.setVgrow(mgB, Priority.ALWAYS);
                    GridPane.setHgrow(mgB, Priority.ALWAYS);
                     escudo.add(mgB, j, i);
                }
                    else if(c==3){//ASIGNA LA CAJA 1
                    mgC1.setFitHeight(40);
                    mgC1.setFitWidth(40);
                    GridPane.setVgrow(mgC1, Priority.ALWAYS);
                    GridPane.setHgrow(mgC1, Priority.ALWAYS);
                    escudo.add(mgC1, j, i);
                }else if(c==5){//ASIGNA LA CAJA 2
                    mgC2.setFitHeight(40);
                    mgC2.setFitWidth(40);
                    GridPane.setVgrow(mgC2, Priority.ALWAYS);
                    GridPane.setHgrow(mgC2, Priority.ALWAYS);
                    escudo.add(mgC2, j, i);
                }else if(c==7){//ASIGNA LA CAJA 3
                    mgC3.setFitHeight(40);
                    mgC3.setFitWidth(40);
                    GridPane.setVgrow(mgC3, Priority.ALWAYS);
                    GridPane.setHgrow(mgC3, Priority.ALWAYS);
                    escudo.add(mgC3, j, i);
                }else if(c==6){
                    mgC1.setImage(win);
                    mgC1.setFitHeight(40);
                    mgC1.setFitWidth(40);
                    GridPane.setVgrow(mgC1, Priority.ALWAYS);
                    GridPane.setHgrow(mgC1, Priority.ALWAYS);
                    escudo.add(mgC1, j, i);
                }else if (c==10){
                    mgC2.setImage(win);
                    mgC2.setFitHeight(40);
                    mgC2.setFitWidth(40);
                    GridPane.setVgrow(mgC2, Priority.ALWAYS);
                    GridPane.setHgrow(mgC2, Priority.ALWAYS);
                    escudo.add(mgC2, j, i);
                }else if(c==14){
                    mgC3.setImage(win);
                    mgC3.setFitHeight(40);
                    mgC3.setFitWidth(40);
                    GridPane.setVgrow(mgC3, Priority.ALWAYS);
                    GridPane.setHgrow(mgC3, Priority.ALWAYS);
                    escudo.add(mgC3, j, i);
                }
                 
            }
        }
        if(maps==1){
            Mario.setFitHeight(40);
            Mario.setFitWidth(40);
            escudo.add(Mario, 5, 5);
            btn1.setVisible(false);btn2.setVisible(false);btn3.setVisible(false);
            btn4.setVisible(false);btn5.setVisible(false);btn6.setVisible(false);//btnNext.setVisible(false);
            anchorpane.getChildren().remove(imagenwinner);
        }else if(maps==2){
            Mario.setFitHeight(40);
            Mario.setFitWidth(40);
            escudo.add(Mario, 1, 1);
            btn1.setVisible(false);btn2.setVisible(false);btn3.setVisible(false);
            btn4.setVisible(false);btn5.setVisible(false);btn6.setVisible(false);
            anchorpane.getChildren().remove(imagenwinner);
        }else if(maps==3){
            Mario.setFitHeight(40);
            Mario.setFitWidth(40);
            escudo.add(Mario, 1, 2);
            btn1.setVisible(false);btn2.setVisible(false);btn3.setVisible(false);
            btn4.setVisible(false);btn5.setVisible(false);btn6.setVisible(false);
            anchorpane.getChildren().remove(imagenwinner);
        }else if(maps==4){
            Mario.setFitHeight(40);
            Mario.setFitWidth(40);
            escudo.add(Mario, 5, 6);
            btn1.setVisible(false);btn2.setVisible(false);btn3.setVisible(false);
            btn4.setVisible(false);btn5.setVisible(false);btn6.setVisible(false);
            anchorpane.getChildren().remove(imagenwinner);
        }else if(maps==5){
            Mario.setFitHeight(40);
            Mario.setFitWidth(40);
            escudo.add(Mario, 1, 3);
            btn1.setVisible(false);btn2.setVisible(false);btn3.setVisible(false);
            btn4.setVisible(false);btn5.setVisible(false);btn6.setVisible(false);
            anchorpane.getChildren().remove(imagenwinner);
        }else if(maps==6){
            Mario.setFitHeight(40);
            Mario.setFitWidth(40);
            escudo.add(Mario, 1, 2);
            btn1.setVisible(false);btn2.setVisible(false);btn3.setVisible(false);
            btn4.setVisible(false);btn5.setVisible(false);btn6.setVisible(false);
            anchorpane.getChildren().remove(imagenwinner);
        }                
        anchorpane.setOnKeyPressed(new EventHandler<KeyEvent>() {
            @Override
            public void handle(KeyEvent event) {
                String code= event.getCode().toString();
                
                if(code=="LEFT"){
                    
                 // 3-6-9: son mumeros que se refieren a la caja #1
                 // 5-10-15: son numeros que se refieren a la caja #2
                 // 7-14-21: son numeros que se refieren a la caja #3
                 // Mario camina libre
                    if(map.mapa1(GridPane.getRowIndex(Mario), GridPane.getColumnIndex(Mario)-1)==0||map.mapa1(GridPane.getRowIndex(Mario), GridPane.getColumnIndex(Mario)-1)==2){
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)-1);
                        System.out.println("Mario <-");//IDENTIFICADOR DE ACCION
                    }
                    
                    //Validaciones para la caja #1
                    //Mario mueve la caja 1 -> left se mantiene el valor 3 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-1)==3 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-2)==0){
                        GridPane.setColumnIndex(mgC1,GridPane.getColumnIndex(mgC1)-1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 3, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-1 <-");//IDENTIFICADOR DE ACCION
                    }
                    //Mario introduce la caja 1 en la meta ---- La caja ahora va a tener el valor de 6 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-1)==3 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-2)==2){
                        mgC1.setImage(win);
                        GridPane.setColumnIndex(mgC1,GridPane.getColumnIndex(mgC1)-1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 6, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-2 <-");//IDENTIFICADOR DE ACCION
                    }
                    //Mario mueve la caja 1 a la meta que esta al lado
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-1)==6 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-2)==2){
//                        mgC1.setImage(win);
                        GridPane.setColumnIndex(mgC1,GridPane.getColumnIndex(mgC1)-1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 12, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-3 <-");//IDENTIFICADOR DE ACCION
                    }
                    //Mario saca de la meta la caja 1---------- Se reconoce el numero 9 y por esto se vuelve al valor inicial de la caja
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-1)==6 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-2)==0){
                        mgC1.setImage(box);
                        GridPane.setColumnIndex(mgC1,GridPane.getColumnIndex(mgC1)-1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)-1);
                        System.out.println("Introducir caja1 a meta");
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 9, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-4 <-");//IDENTIFICADOR DE ACCION
                    }
                    
                    //Validaciones para la caja #2
                    ////Mario mueve la caja 2 -> left se mantiene el valor 5 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-1)==5 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-2)==0){
                        GridPane.setColumnIndex(mgC2,GridPane.getColumnIndex(mgC2)-1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 5, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-1 <-");//IDENTIFICADOR DE ACCION
                    }
                    //Mario introduce la caja 2 en la meta ---- La caja ahora va a tener el valor de 10 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-1)==5 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-2)==2){
                        mgC2.setImage(win);
                        GridPane.setColumnIndex(mgC2,GridPane.getColumnIndex(mgC2)-1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 10, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-2 <-");//IDENTIFICADOR DE ACCION
                    }
                    //Mario mueve la caja 2 a la meta que esta al lado
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-1)==10 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-2)==2){
//                        mgC1.setImage(win);
                        GridPane.setColumnIndex(mgC2,GridPane.getColumnIndex(mgC2)-1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 20, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-3 <-");//IDENTIFICADOR DE ACCION
                    }
                    //Mario saca de la meta la caja 2---------- Se reconoce el numero 15 y por esto se vuelve al valor inicial de la caja
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-1)==10 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-2)==0){
                        mgC2.setImage(box);
                        GridPane.setColumnIndex(mgC2,GridPane.getColumnIndex(mgC2)-1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 15, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-4 <-");//IDENTIFICADOR DE ACCION
                    }
                    
                    //Validaciones para la caja #3
                    ////Mario mueve la caja 3 -> left se mantiene el valor 7 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-1)==7 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-2)==0){
                        GridPane.setColumnIndex(mgC3,GridPane.getColumnIndex(mgC3)-1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 7, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-1 <-");//IDENTIFICADOR DE ACCION
                    }
                    //Mario introduce la caja 3 en la meta ---- La caja ahora va a tener el valor de 14 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-1)==7 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-2)==2){
                        mgC3.setImage(win);
                        GridPane.setColumnIndex(mgC3,GridPane.getColumnIndex(mgC3)-1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 14, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-2 <-");//IDENTIFICADOR DE ACCION
                    }
                    //Mario mueve la caja 3 a la meta que esta al lado
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-1)==14 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-2)==2){
//                        mgC1.setImage(win);
                        GridPane.setColumnIndex(mgC3,GridPane.getColumnIndex(mgC3)-1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 28, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-3 <-");//IDENTIFICADOR DE ACCION
                    }
                    //Mario saca de la meta la caja 3---------- Se reconoce el numero 21 y por esto se vuelve al valor inicial de la caja
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-1)==14 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)-2)==0){
                        mgC3.setImage(box);
                        GridPane.setColumnIndex(mgC3,GridPane.getColumnIndex(mgC3)-1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 21, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-4 <-");//IDENTIFICADOR DE ACCION
                    }
                    //Game Over
//                    else if(map.mapa1(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1)-1)==0 && ){
                        
//                    }
                    
                }else if(code=="UP"){
                    
                 // 3-6-9: son mumeros que se refieren a la caja #1
                 // 5-10-15: son numeros que se refieren a la caja #2
                 // 7-14-21: son numeros que se refieren a la caja #3
                 // Mario camina libre
                    if(map.mapa1(GridPane.getRowIndex(Mario)-1,GridPane.getColumnIndex(Mario))==0||map.mapa1(GridPane.getRowIndex(Mario)-1,GridPane.getColumnIndex(Mario))==2){
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)-1);
                        System.out.println("MARIO ↑");//IDENTIFICADOR DE ACCION
                    
                    //Validaciones para la caja #1
                     ////Mario mueve la caja 1 -> UP↑ se mantiene el valor 3 en la matriz
                    }else if(map.mapa1(GridPane.getRowIndex(Mario)-1,GridPane.getColumnIndex(Mario))==3 && map.mapa1(GridPane.getRowIndex(Mario)-2,GridPane.getColumnIndex(Mario))==0){
                        GridPane.setRowIndex(mgC1,GridPane.getRowIndex(mgC1)-1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 3,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-1 ↑");//IDENTIFICADOR DE ACCION
                    }
                    //Mario introduce la caja 1 en la meta ---- La caja ahora va a tener el valor de 6 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario)-1,GridPane.getColumnIndex(Mario))==3 && map.mapa1(GridPane.getRowIndex(Mario)-2,GridPane.getColumnIndex(Mario))==2){
                        mgC1.setImage(win);
                        GridPane.setRowIndex(mgC1,GridPane.getRowIndex(mgC1)-1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 6,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-2 ↑");//IDENTIFICADOR DE ACCION
                    }
                    //Mario mueve la caja 1 a la meta de al lado
                    else if(map.mapa1(GridPane.getRowIndex(Mario)-1,GridPane.getColumnIndex(Mario))==6 && map.mapa1(GridPane.getRowIndex(Mario)-2,GridPane.getColumnIndex(Mario))==2){
//                        mgC1.setImage(win);
                        GridPane.setRowIndex(mgC1,GridPane.getRowIndex(mgC1)-1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 12,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-3 ↑");//IDENTIFICADOR DE ACCION
                    }
                    //Mario saca de la meta la caja 1---------- Se reconoce el numero 15 y por esto se vuelve al valor inicial de la caja
                    else if(map.mapa1(GridPane.getRowIndex(Mario)-1,GridPane.getColumnIndex(Mario))==6 && map.mapa1(GridPane.getRowIndex(Mario)-2,GridPane.getColumnIndex(Mario))==0){
                        mgC1.setImage(box);
                        GridPane.setRowIndex(mgC1,GridPane.getRowIndex(mgC1)-1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 9, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-3 ↑");//IDENTIFICADOR DE ACCION
                    }
                    
                    //Validaciones para la caja #2
                    ////Mario mueve la caja 2 -> UP↑ se mantiene el valor 5 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario)-1,GridPane.getColumnIndex(Mario))==5 && map.mapa1(GridPane.getRowIndex(Mario)-2,GridPane.getColumnIndex(Mario))==0){
                        GridPane.setRowIndex(mgC2,GridPane.getRowIndex(mgC2)-1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 5,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-1 ↑");//IDENTIFICADOR DE ACCION
                    }
                    //Mario introduce la caja 2 en la meta ---- La caja ahora va a tener el valor de 6 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario)-1,GridPane.getColumnIndex(Mario))== 5 && map.mapa1(GridPane.getRowIndex(Mario)-2,GridPane.getColumnIndex(Mario))==2){
                        mgC2.setImage(win);
                        GridPane.setRowIndex(mgC2,GridPane.getRowIndex(mgC2)-1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 10,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-2 ↑");//IDENTIFICADOR DE ACCION
                    }
                    //Mario mueve la caja 2 a la meta de al lado
                    else if(map.mapa1(GridPane.getRowIndex(Mario)-1,GridPane.getColumnIndex(Mario))== 10 && map.mapa1(GridPane.getRowIndex(Mario)-2,GridPane.getColumnIndex(Mario))==2){
//                        mgC2.setImage(win);
                        GridPane.setRowIndex(mgC2,GridPane.getRowIndex(mgC2)-1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 20,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-3 ↑");//IDENTIFICADOR DE ACCION
                    }
                    //Mario saca de la meta la caja 2---------- Se reconoce el numero 9 y por esto se vuelve al valor inicial de la caja
                    else if(map.mapa1(GridPane.getRowIndex(Mario)-1,GridPane.getColumnIndex(Mario))==10 && map.mapa1(GridPane.getRowIndex(Mario)-2,GridPane.getColumnIndex(Mario))==0){
                        mgC2.setImage(box);
                        GridPane.setRowIndex(mgC2,GridPane.getRowIndex(mgC2)-1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 15, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-4 ↑");//IDENTIFICADOR DE ACCION
                    }
                    //Validaciones para la caja #3
                     ////Mario mueve la caja 3 -> UP↑ se mantiene el valor 7 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario)-1,GridPane.getColumnIndex(Mario))==7 && map.mapa1(GridPane.getRowIndex(Mario)-2,GridPane.getColumnIndex(Mario))==0){
                        GridPane.setRowIndex(mgC3,GridPane.getRowIndex(mgC3)-1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 7,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-1 ↑");//IDENTIFICADOR DE ACCION
                    }
                    //Mario introduce la caja 3 en la meta ---- La caja ahora va a tener el valor de 14 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario)-1,GridPane.getColumnIndex(Mario))==7 && map.mapa1(GridPane.getRowIndex(Mario)-2,GridPane.getColumnIndex(Mario))==2){
                        mgC3.setImage(win);
                        GridPane.setRowIndex(mgC3,GridPane.getRowIndex(mgC3)-1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 14,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-2 ↑");//IDENTIFICADOR DE ACCION
                    }
                    //Mario mueve la caja 3 a la meta de al lado
                    else if(map.mapa1(GridPane.getRowIndex(Mario)-1,GridPane.getColumnIndex(Mario))==14 && map.mapa1(GridPane.getRowIndex(Mario)-2,GridPane.getColumnIndex(Mario))==2){
//                        mgC3.setImage(win);
                        GridPane.setRowIndex(mgC3,GridPane.getRowIndex(mgC3)-1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 28,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-3 ↑");//IDENTIFICADOR DE ACCION
                    }
                    //Mario saca de la meta la caja 3---------- Se reconoce el numero 21 y por esto se vuelve al valor inicial de la caja
                    else if(map.mapa1(GridPane.getRowIndex(Mario)-1,GridPane.getColumnIndex(Mario))==14 && map.mapa1(GridPane.getRowIndex(Mario)-2,GridPane.getColumnIndex(Mario))==0){
                        mgC3.setImage(box);
                        GridPane.setRowIndex(mgC3,GridPane.getRowIndex(mgC3)-1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)-1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 21, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-4 ↑");//IDENTIFICADOR DE ACCION
                    }
                    
                }else if(code=="DOWN"){
                    
                 // 3-6-9: son mumeros que se refieren a la caja #1
                 // 5-10-15: son numeros que se refieren a la caja #2
                 // 7-14-21: son numeros que se refieren a la caja #3
                 // Mario camina libre
                    if(map.mapa1(GridPane.getRowIndex(Mario)+1,GridPane.getColumnIndex(Mario))==0||map.mapa1(GridPane.getRowIndex(Mario)+1,GridPane.getColumnIndex(Mario))==2){
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)+1);
                        System.out.println("MARIO ↓");//IDENTIFICADOR DE ACCION
                    }
                    
                    //Validaciones para la caja #1
                    //Mario mueve la caja 1 -> down se mantiene el valor 3 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario)+1,GridPane.getColumnIndex(Mario))==3 && map.mapa1(GridPane.getRowIndex(Mario)+2,GridPane.getColumnIndex(Mario))==0){
                        GridPane.setRowIndex(mgC1,GridPane.getRowIndex(mgC1)+1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 3, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-1 ↓");//IDENTIFICADOR DE ACCION
                    }
                    //Mario introduce la caja 1 en la meta ---- La caja ahora va a tener el valor de 6 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario)+1,GridPane.getColumnIndex(Mario))==3 && map.mapa1(GridPane.getRowIndex(Mario)+2,GridPane.getColumnIndex(Mario))==2){
                        mgC1.setImage(win);
                        GridPane.setRowIndex(mgC1,GridPane.getRowIndex(mgC1)+1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 6,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-2 ↓");//IDENTIFICADOR DE ACCION
                    }
                     //Mario mueve la caja 1 a la meta de abajo
                    else if(map.mapa1(GridPane.getRowIndex(Mario)+1,GridPane.getColumnIndex(Mario))==6 && map.mapa1(GridPane.getRowIndex(Mario)+2,GridPane.getColumnIndex(Mario))==2){
//                        mgC1.setImage(win);
                        GridPane.setRowIndex(mgC1,GridPane.getRowIndex(mgC1)+1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 12,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-3 ↓");//IDENTIFICADOR DE ACCION
                    }
                    //Mario saca de la meta la caja 1---------- Se reconoce el numero 6 y por esto se vuelve al valor inicial de la caja
                    else if(map.mapa1(GridPane.getRowIndex(Mario)+1,GridPane.getColumnIndex(Mario))==6 && map.mapa1(GridPane.getRowIndex(Mario)+2,GridPane.getColumnIndex(Mario))==0){
                        mgC1.setImage(box);
                        GridPane.setRowIndex(mgC1,GridPane.getRowIndex(mgC1)+1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 9, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-3 ↓");//IDENTIFICADOR DE ACCION
                    }
                    
                    
                    //Validaciones para la caja #2
                    ////Mario mueve la caja 2 -> DOWN↓ se mantiene el valor 5 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario)+1,GridPane.getColumnIndex(Mario))==5 && map.mapa1(GridPane.getRowIndex(Mario)+2,GridPane.getColumnIndex(Mario))==0){
                        GridPane.setRowIndex(mgC2,GridPane.getRowIndex(mgC2)+1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 5, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-1 ↓");//IDENTIFICADOR DE ACCION
                    }
                    //Mario introduce la caja 2 en la meta ---- La caja ahora va a tener el valor de 10 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario)+1,GridPane.getColumnIndex(Mario))==5 && map.mapa1(GridPane.getRowIndex(Mario)+2,GridPane.getColumnIndex(Mario))==2){
                        mgC2.setImage(win);
                        GridPane.setRowIndex(mgC2,GridPane.getRowIndex(mgC2)+1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 10,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-2 ↓");//IDENTIFICADOR DE ACCION
                    }
                    //Mario mueve la caja 1 a la meta de abajo
                    else if(map.mapa1(GridPane.getRowIndex(Mario)+1,GridPane.getColumnIndex(Mario))==10 && map.mapa1(GridPane.getRowIndex(Mario)+2,GridPane.getColumnIndex(Mario))==2){
//                        mgC2.setImage(win);
                        GridPane.setRowIndex(mgC2,GridPane.getRowIndex(mgC2)+1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 20,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-3 ↓");//IDENTIFICADOR DE ACCION
                    }
                    //Mario saca de la meta la caja 1---------- Se reconoce el numero 10 y por esto se vuelve al valor inicial de la caja
                    else if(map.mapa1(GridPane.getRowIndex(Mario)+1,GridPane.getColumnIndex(Mario))==10 && map.mapa1(GridPane.getRowIndex(Mario)+2,GridPane.getColumnIndex(Mario))==0){
                        mgC2.setImage(box);
                        GridPane.setRowIndex(mgC2,GridPane.getRowIndex(mgC2)+1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 15, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-4 ↓");//IDENTIFICADOR DE ACCION
                    }
                    
                    
                    //Validaciones para la caja #3
                    ////Mario mueve la caja 3 -> DOWN↓ se mantiene el valor 7 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario)+1,GridPane.getColumnIndex(Mario))==7 && map.mapa1(GridPane.getRowIndex(Mario)+2,GridPane.getColumnIndex(Mario))==0){
                        GridPane.setRowIndex(mgC3,GridPane.getRowIndex(mgC3)+1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 7, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-1 ↓");//IDENTIFICADOR DE ACCION
                    }
                    //Mario introduce la caja 3 en la meta ---- La caja ahora va a tener el valor de 14 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario)+1,GridPane.getColumnIndex(Mario))==7 && map.mapa1(GridPane.getRowIndex(Mario)+2,GridPane.getColumnIndex(Mario))==2){
                        mgC3.setImage(win);
                        GridPane.setRowIndex(mgC3,GridPane.getRowIndex(mgC3)+1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 14,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-2 ↓");//IDENTIFICADOR DE ACCION
                    }
                    //Mario mueve la caja a la meta de abajo
                    else if(map.mapa1(GridPane.getRowIndex(Mario)+1,GridPane.getColumnIndex(Mario))==14 && map.mapa1(GridPane.getRowIndex(Mario)+2,GridPane.getColumnIndex(Mario))==2){
//                        mgC3.setImage(win);
                        GridPane.setRowIndex(mgC3,GridPane.getRowIndex(mgC3)+1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 28,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-3 ↓");//IDENTIFICADOR DE ACCION
                    }
                    //Mario saca de la meta la caja 3---------- Se reconoce el numero 21 y por esto se vuelve al valor inicial de la caja
                    else if(map.mapa1(GridPane.getRowIndex(Mario)+1,GridPane.getColumnIndex(Mario))==14 && map.mapa1(GridPane.getRowIndex(Mario)+2,GridPane.getColumnIndex(Mario))==0){
                        mgC3.setImage(box);
                        GridPane.setRowIndex(mgC3,GridPane.getRowIndex(mgC3)+1);
                        GridPane.setRowIndex(Mario,GridPane.getRowIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 21, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-4 ↓");//IDENTIFICADOR DE ACCION
                    }
                    
                    
                }else if(code=="RIGHT"){
                    
                    // 3-6-9: son mumeros que se refieren a la caja #1
                    // 5-10-15: son numeros que se refieren a la caja #2
                    // 7-14-21: son numeros que se refieren a la caja #3
                    // Mario camina libre
                    if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+1)==0||map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+1)==2){
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)+1);
                        System.out.println("MARIO ->");//IDENTIFICADOR DE ACCION
                    }
                    
                    //Validaciones para la caja #1
                    //Mario mueve la caja 1 -> left se mantiene el valor 3 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+1)==3 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+2)==0){
                        GridPane.setColumnIndex(mgC1,GridPane.getColumnIndex(mgC1)+1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1),3,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-1 ->");//IDENTIFICADOR DE ACCION
                    }
                    //Mario introduce la caja 1 en la meta ---- La caja ahora va a tener el valor de 6 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+1)==3 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+2)==2){
                        mgC1.setImage(win);
                        GridPane.setColumnIndex(mgC1,GridPane.getColumnIndex(mgC1)+1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 6, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-2 ->");//IDENTIFICADOR DE ACCION
                    }
                    //Mario mueve la caja 1 a la meta que esta al lado
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+1)==6 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+2)==2){
//                        mgC1.setImage(win);
                        GridPane.setColumnIndex(mgC1,GridPane.getColumnIndex(mgC1)+1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 12, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-3 ->");//IDENTIFICADOR DE ACCION
                    }
                    //Mario saca de la meta la caja 1---------- Se reconoce el numero 9 y por esto se vuelve al valor inicial de la caja
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+1)==6 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+2)==0){
                        mgC1.setImage(box);
                        GridPane.setColumnIndex(mgC1,GridPane.getColumnIndex(mgC1)+1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1), 9, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C1-4 ->");//IDENTIFICADOR DE ACCION
                    }
                    
                    //Validaciones para la caja #2
                    ////Mario mueve la caja 2 -> left se mantiene el valor 5 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+1)==5 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+2)==0){
                        GridPane.setColumnIndex(mgC2,GridPane.getColumnIndex(mgC2)+1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2),5,code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-1 ->");//IDENTIFICADOR DE ACCION
                    }
                    //Mario introduce la caja 2 en la meta ---- La caja ahora va a tener el valor de 10 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+1)==5 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+2)==2){
                        mgC2.setImage(win);
                        GridPane.setColumnIndex(mgC2,GridPane.getColumnIndex(mgC2)+1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 10, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-2 ->");//IDENTIFICADOR DE ACCION
                    }
                    //Mario mueve la caja 2 a la meta que esta al lado
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+1)==10 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+2)==2){
//                        mgC1.setImage(win);
                        GridPane.setColumnIndex(mgC2,GridPane.getColumnIndex(mgC2)+1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 20, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-3 ->");//IDENTIFICADOR DE ACCION
                    }
                    //Mario saca de la meta la caja 2---------- Se reconoce el numero 15 y por esto se vuelve al valor inicial de la caja
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+1)==10 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+2)==0){
                        mgC2.setImage(box);
                        GridPane.setColumnIndex(mgC2,GridPane.getColumnIndex(mgC2)+1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2), 15, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C2-4 ->");//IDENTIFICADOR DE ACCION
                    }
                    
                    //Validaciones para la caja #3
                    ////Mario mueve la caja 3 -> left se mantiene el valor 7 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+1)==7 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+2)==0){
                        GridPane.setColumnIndex(mgC3,GridPane.getColumnIndex(mgC3)+1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 7, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-1 ->");//IDENTIFICADOR DE ACCION
                    }
                    //Mario introduce la caja 3 en la meta ---- La caja ahora va a tener el valor de 14 en la matriz
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+1)==7 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+2)==2){
                        mgC3.setImage(win);
                        GridPane.setColumnIndex(mgC3,GridPane.getColumnIndex(mgC3)+1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 14, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-2 ->");//IDENTIFICADOR DE ACCION
                    }
                    //Mario mueve la caja 3 a la meta que esta al lado
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+1)==14 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+2)==2){
//                        mgC1.setImage(win);
                        GridPane.setColumnIndex(mgC3,GridPane.getColumnIndex(mgC3)+1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 28, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-3 ->");//IDENTIFICADOR DE ACCION
                    }
                    //Mario saca de la meta la caja 3---------- Se reconoce el numero 21 y por esto se vuelve al valor inicial de la caja
                    else if(map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+1)==14 && map.mapa1(GridPane.getRowIndex(Mario),GridPane.getColumnIndex(Mario)+2)==0){
                        mgC3.setImage(box);
                        GridPane.setColumnIndex(mgC3,GridPane.getColumnIndex(mgC3)+1);
                        GridPane.setColumnIndex(Mario,GridPane.getColumnIndex(Mario)+1);
                        map.actualizar(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3), 21, code);//SE ACTUALIZAN LAS UBICACIONES DE LAS CAJAS
                        System.out.println("M/C3-4 ->");//IDENTIFICADOR DE ACCION
                    }
                    
                }
                
                //Indica en caso de ganar la partida
                winner=map.Indicador();
                if(map.Indicador()==30){
                    imagenwinner.setFitHeight(400);
                    imagenwinner.setFitWidth(400);
                    imagenwinner.setLayoutX(205);
                    imagenwinner.setLayoutY(100);
                    play_audio(2);
                    audioWin(1);
                    anchorpane.getChildren().add(imagenwinner);
                    escudo.getChildren().clear();
                    btn1.setVisible(true);
                    btn2.setVisible(true);
                    btn3.setVisible(true);
                    btn4.setVisible(true);
                    btn5.setVisible(true);
                    btn6.setVisible(true);
//                    btnNext.setVisible(true);
                }
                
                //***---VALIDACIONES PARA ERRORES---***
                if(map.mapa1(GridPane.getRowIndex(mgC1), GridPane.getColumnIndex(mgC1))!=6 && map.mapa1(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1)-1)==1 && map.mapa1(GridPane.getRowIndex(mgC1)-1,GridPane.getColumnIndex(mgC1))==1 ||
                        map.mapa1(GridPane.getRowIndex(mgC1), GridPane.getColumnIndex(mgC1))!=6 && map.mapa1(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1)+1)==1 && map.mapa1(GridPane.getRowIndex(mgC1)-1,GridPane.getColumnIndex(mgC1))==1||
                        map.mapa1(GridPane.getRowIndex(mgC1), GridPane.getColumnIndex(mgC1))!=6 && map.mapa1(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1)-1)==1 && map.mapa1(GridPane.getRowIndex(mgC1)+1,GridPane.getColumnIndex(mgC1))==1||
                        map.mapa1(GridPane.getRowIndex(mgC1), GridPane.getColumnIndex(mgC1))!=6 && map.mapa1(GridPane.getRowIndex(mgC1),GridPane.getColumnIndex(mgC1)+1)==1 && map.mapa1(GridPane.getRowIndex(mgC1)+1,GridPane.getColumnIndex(mgC1))==1){
                    System.out.println("game over caja 1");
                    over.setFitHeight(493);
                    over.setFitWidth(784);
                    escudo.getChildren().clear();
                    anchorpane.getChildren().add(over);
                    over.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Over();
                        }
                    });
                    play_audio(2);
                    audioover(1);
                    gameover=1;
                }
                if(map.mapa1(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2))!=10 && map.mapa1(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2)-1)==1 && map.mapa1(GridPane.getRowIndex(mgC2)-1,GridPane.getColumnIndex(mgC2))==1 ||
                        map.mapa1(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2))!=10 && map.mapa1(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2)+1)==1 && map.mapa1(GridPane.getRowIndex(mgC2)-1,GridPane.getColumnIndex(mgC2))==1||
                        map.mapa1(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2))!=10 && map.mapa1(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2)-1)==1 && map.mapa1(GridPane.getRowIndex(mgC2)+1,GridPane.getColumnIndex(mgC2))==1||
                        map.mapa1(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2))!=10 && map.mapa1(GridPane.getRowIndex(mgC2),GridPane.getColumnIndex(mgC2)+1)==1 && map.mapa1(GridPane.getRowIndex(mgC2)+1,GridPane.getColumnIndex(mgC2))==1){
                    System.out.println("game over caja2");
                    over.setFitHeight(493);
                    over.setFitWidth(784);
                    escudo.getChildren().clear();
                    anchorpane.getChildren().add(over);
                    over.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Over();
                        }
                    });
                    play_audio(2);
                    audioover(1);
                    gameover=1;
                }
                if(map.mapa1(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3))!=14 && map.mapa1(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3)-1)==1 && map.mapa1(GridPane.getRowIndex(mgC3)-1,GridPane.getColumnIndex(mgC3))==1 ||
                        map.mapa1(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3))!=14 && map.mapa1(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3)+1)==1 && map.mapa1(GridPane.getRowIndex(mgC3)-1,GridPane.getColumnIndex(mgC3))==1||
                        map.mapa1(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3))!=14 && map.mapa1(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3)-1)==1 && map.mapa1(GridPane.getRowIndex(mgC3)+1,GridPane.getColumnIndex(mgC3))==1||
                        map.mapa1(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3))!=14 && map.mapa1(GridPane.getRowIndex(mgC3),GridPane.getColumnIndex(mgC3)+1)==1 && map.mapa1(GridPane.getRowIndex(mgC3)+1,GridPane.getColumnIndex(mgC3))==1){
                    System.out.println("game over caja3");
                    over.setFitHeight(493);
                    over.setFitWidth(784);
                    escudo.getChildren().clear();
                    anchorpane.getChildren().add(over);
                    over.setOnMouseClicked(new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            Over();
                        }
                    });
                    play_audio(2);
                    audioover(1);
                    gameover=1;
                }
                btnP.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        escudo.getChildren().clear();
                        play_audio(2);
                        switch(maps){
                            case 1:
                                iniciar(new ActionEvent());
                                break;
                            case 2:
                                mapa2(new ActionEvent());
                                break;
                            case 3:
                                mapa3(new ActionEvent());
                                break;
                            case 4:
                                mapa4(new ActionEvent());
                                break;
                            case 5:
                                mapa5(new ActionEvent());
                                break;
                            case 6:
                                mapa6(new ActionEvent());
                                break;
                        }
                    }
                });
                btnSilence.setOnMouseClicked(new EventHandler<MouseEvent>() {
                    @Override
                    public void handle(MouseEvent event) {
                        play_audio(2);
                    }
                });
//                btncambiar.setOnMouseClicked(new EventHandler<MouseEvent>() {
//                    @Override
//                    public void handle(MouseEvent event) {
//                        changeImage++;
//                        if(changeImage==1){
//                            ImageFondo.setImage(cambio1);
//                        }
//                    }
//                });
                if(gameover==1){//HABILITAR LOS BOTONES
                    btn1.setVisible(true);
                    btn2.setVisible(true);
                    btn3.setVisible(true);
                    btn4.setVisible(true);
                    btn5.setVisible(true);
                    btn6.setVisible(true);
                    
                }

            }
        });
        
        //REGRESAR A LAS IMAGENES DE LAS CAJAS EN CASO DE GANAR
        if(winner==30){
            mgC1.setImage(box);
            mgC2.setImage(box);
            mgC3.setImage(box);
            map.ClearMatriz();
        }
        if(gameover==1){//REGRESAR A LAS IMAGENES DE LAS CAJAS EN CASO DE PERDER
            mgC1.setImage(box);
            mgC2.setImage(box);
            mgC3.setImage(box);
            map.ClearMatriz();
        }
        
        System.out.println("si pasa por aca");
        escudo.setGridLinesVisible(true);
        escudo.setLayoutX(230);
        escudo.setLayoutY(70);
        anchorpane.getChildren().add(escudo);
    };
    
    
    
    //***---SECCION DE MAPAS---***
    @FXML
    private void iniciar(ActionEvent event) {
        
           Integer [][] mapa1={{1,1,1,1,1,1,1,1},
                               {1,1,1,1,1,1,1,1},
                               {1,0,0,1,1,1,1,1},
                               {1,0,0,0,6,2,1,1},
                               {1,0,0,5,1,0,1,1},
                               {1,0,0,2,7,0,1,1},
                               {1,1,1,1,1,1,1,1},
                               {1,1,1,1,1,1,1,1}};
          Dibujarmapa(mapa1, 1); 
           play_audio(1);
    }

    @FXML
    private void mapa2(ActionEvent event) {
        Integer [][]mapa2=  {{1,1,1,1,1,1,1,1},
                            {1,0,0,2,2,1,1,1},
                            {1,0,1,3,0,1,1,1},
                            {1,0,1,0,0,0,0,1},
                            {1,0,0,5,1,0,0,1},
                            {1,0,0,14,0,1,0,1},
                            {1,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1}};
        System.out.println("mapa2");
        Dibujarmapa(mapa2, 2);
        play_audio(1);
    }

    @FXML
    private void mapa3(ActionEvent event) {
        Integer [][] mapa3={{1,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1},
                            {1,0,0,0,0,0,1,1},
                            {1,0,1,0,1,3,0,1},
                            {1,2,0,7,10,0,0,1},
                            {1,0,0,0,1,0,2,1},
                            {1,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1}};
        Dibujarmapa(mapa3, 3);
        play_audio(1);
    }
    
    @FXML
    private void mapa4(ActionEvent event) {
         Integer [][] mapa4={{1,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1},
                            {1,2,0,0,1,1,1,1},
                            {1,0,1,0,3,0,1,1},
                            {1,0,0,10,0,0,1,1},
                            {1,0,0,1,1,0,1,1},
                            {1,0,14,0,0,0,1,1},
                            {1,1,1,1,1,1,1,1}};
        Dibujarmapa(mapa4, 4);
        play_audio(1);
    }

    @FXML
    private void mapa5(ActionEvent event) {
        Integer [][] mapa= {{1,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1},
                            {1,1,2,0,0,1,1,1},
                            {1,2,3,5,7,0,1,1},
                            {1,0,1,0,0,2,1,1},
                            {1,0,0,0,0,1,1,1},
                            {1,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1}};
        Dibujarmapa(mapa, 5);
        play_audio(1);
    }

    @FXML
    private void mapa6(ActionEvent event) {
        Integer [][] mapa= {{1,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1},
                            {1,0,0,6,0,1,1,1},
                            {1,0,1,0,0,0,0,1},
                            {1,2,5,7,2,1,0,1},
                            {1,0,0,0,0,0,0,1},
                            {1,1,1,1,1,1,1,1},
                            {1,1,1,1,1,1,1,1}};
        Dibujarmapa(mapa, 6);
        play_audio(1);
    }
    
    //***♪♪SECCION DE AUDIO♪♪***
    public void play_audio(int a){
        AudioClip mus = new AudioClip(this.getClass().getResource("/proyecto2sokoban/resource/super-mario.mp3").toString());
        if(a==1){
            
            mus.play();
        }else{
            mus.stop();
        }    
    }
    public void audioWin(int on){
        AudioClip mus = new AudioClip(this.getClass().getResource("/proyecto2sokoban/resource/woo-hoo.mp3").toString());
        if(on==1){
            mus.play();
        }else{
            mus.stop();
        }             
    }
    public void audioover(int on){
        AudioClip mus = new AudioClip(this.getClass().getResource("/proyecto2sokoban/resource/Game over.mp3").toString());
        if(on==1){
            mus.play();
        }else{
            mus.stop();
        }             
    }
    
    //ACCION SI SE PIERDE LA PARTIDA
    public void Over(){
        audioover(2);
        anchorpane.getChildren().remove(over);
    }

//    @FXML
//    private void aa(ActionEvent event) {
//                
//         audioWin(2);
//         audioover(2);
//         play_audio(2);
//       switch(nummapa){
//           case 1:
//               mapa2(new ActionEvent());
//               break;
//           case 2:
//               mapa3(new ActionEvent());
//               break;
//           case 3:
//               mapa4(new ActionEvent());
//               break;
//           case 4:
//               mapa5(new ActionEvent());
//               break;
//           case 5:
//               mapa6(new ActionEvent());
//               break;
//       }
//    }

}
