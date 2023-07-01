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
public class Jugador {
    protected String nombre;
//    protected int nivel;

    public Jugador() {
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public void Imprimir(){
        System.out.println("salida "+nombre);
    }
    
    
}
