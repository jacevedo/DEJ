/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entidades;

/**
 *
 * @author jaime
 * 
 * Clase Comanda entidad identica a la tabla de la base de datos
 * se utilizará para manejar los datos de la misma
 */
public class Comanda {
    
    private int id;
    private int idCocina;
    private String pedido;
    private int mesa;

    public Comanda() {
    }

    public Comanda(int id,int idCocina, String pedido, int mesa) {
        this.id = id;
        this.idCocina = idCocina;
        this.pedido = pedido;
        this.mesa = mesa;
    }

    public int getIdCocina() {
        return idCocina;
    }

    public void setIdCocina(int idCocina) {
        this.idCocina = idCocina;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getPedido() {
        return pedido;
    }

    public void setPedido(String pedido) {
        this.pedido = pedido;
    }

    public int getMesa() {
        return mesa;
    }

    public void setMesa(int mesa) {
        this.mesa = mesa;
    }
    
}
