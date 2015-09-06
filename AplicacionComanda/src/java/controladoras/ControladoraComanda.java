/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controladoras;

import entidades.Comanda;
import excepciones.NoAgregoException;
import excepciones.NoEditoException;
import excepciones.NoEncontroException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author jaime
 * 
 * Clase que se encarga de hacer el CRUD en la base de datos 
 * segun la entidad
 */
public class ControladoraComanda
{
    //Conexion a la base de datos 
    private Connection cnx;

    /**
     * Constructor de la clase que recibe la conexion a la base de
     * datos como parametro
     * @param cnx Conexion a la base de datos
     */
    public ControladoraComanda(Connection cnx) {
        this.cnx = cnx;
    }
    
    /**
     * Metodo que inserta una comanda en la base de datos
     * @param comanda comanda a insertar
     * @throws NoAgregoException exepcion en caso de error en la conexion
     * o en el sql 
     */
    public void agregar(Comanda comanda) throws NoAgregoException
    {
        //SQL a ejecutar
        String sql = "insert into comanda (id, id_cocina ,pedido, mesa) "
                + "values(null, ?, ?, ?)";
        //pre compila la sentencia sql
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            //reemplasa los signos de interrogacion por los datos ingresados
            //solicita el indice (curiosamente inicia en 1)
            stmt.setInt(1, comanda.getIdCocina());
            stmt.setString(2, comanda.getPedido());
            stmt.setInt(3, comanda.getMesa());
            //Ejecuta la sentencia sql
            stmt.executeUpdate();
        } 
        catch (SQLException ex) 
        {
            //Si hubo un error lanzamos una exepcion controlada
           throw new NoAgregoException(ex.getMessage());
        }
    }
    /**
     * Metodo que edita una comanda en la base de datos
     * @param comanda comanda con los datos a modificar
     * @throws NoEditoException exepcion lanzada en caso de que haya error
     * en la base de datos al editar
     */
    public void editar(Comanda comanda) throws NoEditoException
    {
        //SQL para editar la comanda
        String sql = "update comanda set id_cocina = ?,"
                                       + " pedido = ?, "
                                       + " mesa = ?"
                                + " where id = ?";
       //pre compila la sentencia sql
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            //reemplasa los signos de interrogacion por los datos ingresados
            //solicita el indice (curiosamente inicia en 1)
            stmt.setInt(1, comanda.getIdCocina());
            stmt.setString(2, comanda.getPedido());
            stmt.setInt(3, comanda.getMesa());
            stmt.setInt(4, comanda.getId());
            //Ejecuta la sentencia sql
            stmt.executeQuery();
        } 
        catch (SQLException ex) 
        {
            //Si hubo un error lanzamos una exepcion controlada
            throw new NoEditoException(ex.getMessage());
        }
    }
    /**
     * Metodo que busca la comanda segun el id
     * @param id de la comanda a buscar
     * @return la comanda encontrada null en caso de que no exista
     * @throws NoEncontroException  exepcion lanzada en caso de que haya error
     * en la base de datos al buscar
     */
    public Comanda buscarPorId(int id) throws NoEncontroException
    {
        //Objeto que retornaremos, se inicializa en null debido a que si
        //no encuentra nada retorna null
        Comanda comanda = null;
        //SQL para buscar la comanda
        String sql = "select * from comanda where id = ?";
        //pre compila la sentencia sql
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            //reemplasa los signos de interrogacion por los datos ingresados
            //solicita el indice (curiosamente inicia en 1)
            stmt.setInt(1, id);
            //Ejecuta la sentencia y el resultado se la pasa a un objeto 
            //resultset con los resultados de la consulta
            try(ResultSet rs = stmt.executeQuery())
            {
                //consulta si realmente trajo algo
                if(rs.next())
                {
                    //creamos la comanda y guardamos los datos
                    comanda = new Comanda();
                    comanda.setId(rs.getInt("id"));
                    comanda.setIdCocina(rs.getInt("id_cocina"));
                    comanda.setMesa(rs.getInt("mesa"));
                    comanda.setPedido(rs.getString("pedido"));
                }
            }
            
            
        } 
        //Si hubo error en la sentencia o conexion se captura la excepcion
        catch (SQLException ex) 
        {
            //Se lanza una excepcion
            throw new NoEncontroException(ex.getMessage());
            
        }
        //Se retorna el resultado
        return comanda;
    }
    /**
     * Metodo que retorna todas las comandas encontradas
     * @return Lista con todas las comandas
     * @throws NoEncontroException  exepcion lanzada en caso de que haya error
     * en la base de datos al buscar
     */
    public ArrayList<Comanda> buscarTodas() throws NoEncontroException
    {
        //Se inicializa un arraylist donde se guardaran todas las comandas
        //encontradas
        ArrayList<Comanda> listComanda = new ArrayList<>();
        //Sentencias para buscar las comandas
        String sql = "select * from comanda";
         //pre compila la sentencia sql
        try(PreparedStatement stmt = cnx.prepareStatement(sql))
        {
            //Ejecuta la sentencia y el resultado se la pasa a un objeto 
            //resultset con los resultados de la consulta
            try(ResultSet rs = stmt.executeQuery())
            {
                //Recorremos los resultados
                while(rs.next())
                {
                    //creamos la comanda y guardamos los datos
                    Comanda comanda = new Comanda();
                    comanda.setId(rs.getInt("id"));
                    comanda.setIdCocina(rs.getInt("id_cocina"));
                    comanda.setMesa(rs.getInt("mesa"));
                    comanda.setPedido(rs.getString("pedido"));
                    //Agregamos la comanda a la lista
                    listComanda.add(comanda);
                }
            }
            
            
        } 
        catch (SQLException ex) 
        {
            throw new NoEncontroException(ex.getMessage());
            
        }
        //Retornamos la lista de comanda
        return listComanda;
    }
}
