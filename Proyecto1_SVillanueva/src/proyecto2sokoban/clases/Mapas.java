/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyecto2sokoban.clases;


/**
 *
 * @author expz
 */
public class Mapas {
    protected Integer mapas[][] = new Integer[8][8];
    // 1=MUROS  2=METAS  3=CAJA#1  5=CAJA#2  7=CAJA#3  8=CAJA/META
    protected Integer mapa1[][]=new Integer[8][8];
    protected Integer mapa3[][]=new Integer[8][8];
    protected int a;

    public Mapas(int a) {
        this.a = a;
    }
    
    public Mapas(){//Inicializo
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                 mapa3[i][j]=0;
            }
        }
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                 mapa1[i][j]=0;
            }
        }
    }
    
  public void cargar(int fila,int columna,int valor){//Recibo el mapa segun boton
      for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                if(i==fila && j==columna){
                    mapa1[i][j]=valor;
                }
            }
        }
  }
  public void imprimr(){//Imprimir mapa para verificar
      for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                 System.out.print(mapa1[i][j]);
            }System.out.println("");
        }
  }
    
  
    public int mapa1(int fila, int columna){
        int valor=0;
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                 if(i==fila && j==columna){
//                     if(i-1==4){
                     valor=mapa1[i][j];
//                     System.out.println("contiene "+valor);
                 }
            }
        }
        return valor;
    }

    public void actualizar(int fila, int columna,int caja,String direccion){//Metodo para actualizar las posociones de las cajas en la matriz
        switch (direccion){
            case "LEFT":
                    //Mover solo la caja o Introduccirla a la mate
                    if(caja==3||caja==5||caja==7||caja==6||caja==10||caja==14){
                         mapa1[fila][columna]=caja;
                        mapa1[fila][columna+1]=0;
                        for(int i=0;i<8;i++){
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                                
                            }
                            System.out.println(" ");
                        }System.out.println("solo movio la caja");
                    }
                    //Sucede cuando hay otra meta a su derecha, por lo tanto se puede mover
                    else if(caja==12){
                        mapa1[fila][columna]=6;
                        mapa1[fila][columna+1]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("caja1 <-");
                    }
                    //Sucede cuando hay otra meta a su derecha, por lo tanto se puede mover
                    else if(caja==20){
                        mapa1[fila][columna]=10;
                        mapa1[fila][columna+1]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("caja2 <-");
                    }
                    //Sucede cuando hay otra meta a su derecha, por lo tanto se puede mover
                    else if(caja==28){
                        mapa1[fila][columna]=14;
                        mapa1[fila][columna+1]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("caja3 <-");
                    }
                    //Sacar la caja 1 a la meta
                    else if(caja==9){
                        mapa1[fila][columna]=3;
                        mapa1[fila][columna+1]=2;
                        for(int i=0;i<8;i++){
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                                
                            }
                            System.out.println(" ");
                        }System.out.println("saca la caja1");
                    }
                    else if(caja==15){//se introduce la caja1 en la meta
                        mapa1[fila][columna]=5;
                        mapa1[fila][columna+1]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("saca la caja3");
                    }
                    else if(caja==21){//se introduce la caja2 en la meta
                        mapa1[fila][columna]=7;
                        mapa1[fila][columna+1]=2;
                        for(int i=0;i<8;i++){
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("saca la caja3");
                    }
                    break;
            case "UP":
                    //Mover solo la caja o Introduccirla a la mate
                    if(caja==3||caja==5||caja==7||caja==6||caja==10||caja==14){
                         mapa1[fila][columna]=caja;
                        mapa1[fila+1][columna]=0;
                        for(int i=0;i<8;i++){
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                                
                            }
                            System.out.println(" ");
                        }System.out.println("arriba solo movio la caja");
                    }
                    else if(caja==12){
                        mapa1[fila][columna]=6;
                        mapa1[fila][columna-1]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("caja1 ↑");
                    }
                    //Sucede cuando hay otra meta a su derecha, por lo tanto se puede mover
                    else if(caja==20){
                        mapa1[fila][columna]=10;
                        mapa1[fila][columna-1]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("caja2 ↑");
                    }
                    //Sucede cuando hay otra meta a su derecha, por lo tanto se puede mover
                    else if(caja==28){
                        mapa1[fila][columna]=14;
                        mapa1[fila][columna-1]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("caja3 ↑");
                    }
                    //Sacar la caja 1 a la meta
                    else if(caja==9){
                        mapa1[fila][columna]=3;
                        mapa1[fila+1][columna]=2;
                        for(int i=0;i<8;i++){
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                                
                            }
                            System.out.println(" ");
                        }System.out.println(" ↑saco la caja 1");
                    }
                    else if(caja==15){//se introduce la caja1 en la meta
                        mapa1[fila][columna]=5;
                        mapa1[fila+1][columna]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("↑saco la caja 2");
                    }
                    else if(caja==21){//se introduce la caja2 en la meta
                        mapa1[fila][columna]=7;
                        mapa1[fila+1][columna]=2;
                        for(int i=0;i<8;i++){
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("↑saco la caja 3");
                    }
                    break;
            case "RIGHT":
                    //Mover solo la caja o Introduccirla a la mate
                    if(caja==3||caja==5||caja==7||caja==6||caja==10||caja==14){
                         mapa1[fila][columna]=caja;
                        mapa1[fila][columna-1]=0;
                        for(int i=0;i<8;i++){
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                                
                            }
                            System.out.println(" ");
                        }System.out.println("solo movio la caja");
                    }
                    //Sucede cuando hay otra meta a su derecha, por lo tanto se puede mover
                    else if(caja==12){
                        mapa1[fila][columna]=6;
                        mapa1[fila][columna-1]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("-> caja1");
                    }
                    else if(caja==20){
                        mapa1[fila][columna]=10;
                        mapa1[fila][columna-1]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("-> caja2");
                    }
                    //Sucede cuando hay otra meta a su derecha, por lo tanto se puede mover
                    else if(caja==28){
                        mapa1[fila][columna]=14;
                        mapa1[fila][columna-1]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("-> caja3");
                    }
                    //Sacar la caja 1 a la meta
                    else if(caja==9){
                        mapa1[fila][columna]=3;
                        mapa1[fila][columna-1]=2;
                        for(int i=0;i<8;i++){
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                                
                            }
                            System.out.println(" ");
                        }System.out.println("-> saco caja1");
                    }
                    else if(caja==15){//se introduce la caja1 en la meta
                        mapa1[fila][columna]=5;
                        mapa1[fila][columna-1]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("-> saco caja2");
                    }
                    else if(caja==21){//se introduce la caja2 en la meta
                        mapa1[fila][columna]=7;
                        mapa1[fila][columna-1]=2;
                        for(int i=0;i<8;i++){
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("-> saco caja3");
                    }
                    break;
            case "DOWN":
                    //Mover solo la caja o Introduccirla a la meta
                    if(caja==3||caja==5||caja==7||caja==6||caja==10||caja==14){
                         mapa1[fila][columna]=caja;
                        mapa1[fila-1][columna]=0;
                        for(int i=0;i<8;i++){
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                                
                            }
                            System.out.println(" ");
                        }System.out.println("solo movio la caja");
                    }
                    else if(caja==12){
                        mapa1[fila][columna]=6;
                        mapa1[fila][columna+1]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("caja1 ↓");
                    }
                    //Sucede cuando hay otra meta a su derecha, por lo tanto se puede mover
                    else if(caja==20){
                        mapa1[fila][columna]=10;
                        mapa1[fila][columna+1]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("caja2 ↓");
                    }
                    //Sucede cuando hay otra meta a su derecha, por lo tanto se puede mover
                    else if(caja==28){
                        mapa1[fila][columna]=14;
                        mapa1[fila][columna+1]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("caja3 ↓");
                    }
                    //Sacar la caja 1 a la meta
                    else if(caja==9){
                        mapa1[fila][columna]=3;
                        mapa1[fila-1][columna]=2;
                        for(int i=0;i<8;i++){
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                                
                            }
                            System.out.println(" ");
                        }System.out.println("↓ saco caja1");
                    }
                    else if(caja==15){//se introduce la caja1 en la meta
                        mapa1[fila][columna]=5;
                        mapa1[fila-1][columna]=2;
                        for(int i=0;i<8;i++){//for para comprobar la actualizacion
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("↓ saco caja2");
                    }
                    else if(caja==21){//se introduce la caja2 en la meta
                        mapa1[fila][columna]=7;
                        mapa1[fila-1][columna]=2;
                        for(int i=0;i<8;i++){
                            for(int j=0;j<8;j++){
                                System.out.print(mapa1[i][j]);
                            }
                            System.out.println(" ");
                        }System.out.println("↓ saco caja3");
                    }
                    break;
        }
        
        
    }
    
//    
    
    public int Indicador(){
        int estado=0;
        int a=0,b=0,c=0;
       for(int i=0;i<8;i++){
           for(int j =0; j<8;j++){
               if(mapa1[i][j]==6){
                   a=6;
               }
               if(mapa1[i][j]==10){
                   b=10;
               }
               if(mapa1[i][j]==14){
                   c=14;
               }
           }
       }
       if(a==6&&b==10&&c==14){
           estado=a+b+c;
           System.out.println("los si estan");
       }
        
        return estado;
    }
    public void ClearMatriz(){
        for(int i=0;i<8;i++){
            for(int j=0;j<8;j++){
                 mapa1[i][j]=0;
            }
        }
    }
    
}
