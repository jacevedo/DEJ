/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladoras.ControladoraComanda;
import entidades.Comanda;
import excepciones.NoEncontroException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;

/**
 *
 * @author jaime
 */
@WebServlet(name = "ListarComanda", urlPatterns = {"/ListarComanda"})
public class ListarComanda extends HttpServlet {
    @Resource(mappedName = "jdbc/comanda")
    private DataSource ds;
 
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try (Connection conexion = ds.getConnection())
        {
            ControladoraComanda controladora = new ControladoraComanda(conexion);
            ArrayList<Comanda> listComanda =  controladora.buscarTodas();
            request.setAttribute("todas", listComanda);
        } 
        catch (SQLException ex) 
        {
            Logger.getLogger(ListarComanda.class.getName()).log(Level.SEVERE, null, ex);
        } 
        catch (NoEncontroException ex) 
        {
         Logger.getLogger(ListarComanda.class.getName()).log(Level.SEVERE, null, ex);
        }
        request.getRequestDispatcher("/listaComanda.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
}
