/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladoras.ControladoraComanda;
import entidades.Comanda;
import excepciones.NoEditoException;
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
@WebServlet(name = "EditarComanda", urlPatterns = {"/EditarComanda"})
public class EditarComanda extends HttpServlet {
    
    @Resource(mappedName = "jdbc/comanda")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/editarComanda.jsp").forward(request, response);
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        int id = Integer.parseInt(request.getParameter("idComanda"));
        int idCocina = Integer.parseInt(request.getParameter("idCocina"));
        String pedido = request.getParameter("pedido");
        int mesa = Integer.parseInt(request.getParameter("numeroMesa"));
        
        Comanda comanda = new Comanda(id, idCocina, pedido, mesa);
        try(Connection cnx = ds.getConnection())
        {
            ControladoraComanda controladora = new ControladoraComanda(cnx);
            controladora.editar(comanda);
            request.setAttribute("mensaje", "Se edito Correctamente");
            
        } 
        catch (SQLException ex) {
            Logger.getLogger(EditarComanda.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("mensaje", "Error al editar");
        } catch (NoEditoException ex) {
            Logger.getLogger(EditarComanda.class.getName()).log(Level.SEVERE, null, ex);
            request.setAttribute("mensaje", "Error al editar");
        }
       request.getRequestDispatcher("/editarComanda.jsp").forward(request, response);
    }

}
