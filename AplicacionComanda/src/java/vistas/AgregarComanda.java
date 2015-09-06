/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladoras.ControladoraComanda;
import entidades.Comanda;
import excepciones.NoAgregoException;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;
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
@WebServlet(name = "AgregarComanda", urlPatterns = {"/AgregarComanda"})
public class AgregarComanda extends HttpServlet {

    @Resource(mappedName = "jdbc/comanda")
    private DataSource ds;

    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
         request.getRequestDispatcher("/agregarComanda.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        int idCocina = Integer.parseInt(request.getParameter("idCocina"));
        String pedido = request.getParameter("pedido");
        int mesa = Integer.parseInt(request.getParameter("mesa"));
        
        Comanda comanda = new Comanda(0,idCocina, pedido, mesa);
        try (Connection conexion = ds.getConnection())
        {
            ControladoraComanda controladora = new ControladoraComanda(conexion);
            controladora.agregar(comanda);
            request.setAttribute("mensaje", "Agregado Correctamente");
        } 
        catch (NoAgregoException ex)
        {
            Logger.getLogger(AgregarComanda.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("mensaje", "Error al agregar");
        }
        catch (SQLException ex) 
        {
            Logger.getLogger(AgregarComanda.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("mensaje", "Error al agregar");
        } 
        request.getRequestDispatcher("agregarComanda.jsp").forward(request, response);
        
    }
}
