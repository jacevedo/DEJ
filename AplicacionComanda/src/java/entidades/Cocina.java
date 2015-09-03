/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author jaime
 */
public class Cocina 
{
    private int id;
    private String nombre;
    private String encargado;
    private Comanda[] comandas;

    public Cocina(int id, String nombre, String encargado, Comanda[] comandas) {
        this.id = id;
        this.nombre = nombre;
        this.encargado = encargado;
        this.comandas = comandas;
    }

    public Cocina() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEncargado() {
        return encargado;
    }

    public void setEncargado(String encargado) {
        this.encargado = encargado;
    }

    public Comanda[] getComandas() {
        return comandas;
    }

    public void setComandas(Comanda[] comandas) {
        this.comandas = comandas;
    }
    
    
    
    
}
