/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vistas;

import controladora.ControladoraVideoJuego;
import entidades.VideoJuego;
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
@WebServlet(name = "ModificarVideoJuego", urlPatterns = {"/ModificarVideoJuego"})
public class ModificarVideoJuego extends HttpServlet {

    @Resource(mappedName = "jdbc/videojuego")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        String idString = request.getParameter("id");
        if(idString != null)
        {
            try
            {
                int id = Integer.parseInt(idString);
                try(Connection cnx = ds.getConnection())
                {
                    ControladoraVideoJuego controladora = new ControladoraVideoJuego(cnx);
                    VideoJuego videoJuego = controladora.obtenerVideoJuegoPorId(id);
                    request.setAttribute("videoJuego", videoJuego);
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(BuscarVideoJuego.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            catch(NumberFormatException ex)
            {
                
            }
        }
        request.getRequestDispatcher("/modificar.jsp").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        String idString = request.getParameter("idVideoJuego");
        String nombre = request.getParameter("nombreVideoJuego");
        String precioString = request.getParameter("precioVideoJuego");
        String tipo = request.getParameter("tipoVideoJuego");
        if(idString.compareToIgnoreCase("")!= 0 && precioString.compareToIgnoreCase("")!=0)
        {
            try
            {
                int id = Integer.parseInt(idString);
                int precio = Integer.parseInt(precioString);
                VideoJuego videoJuego = new VideoJuego(id, nombre, precio, tipo);
                try(Connection cnx = ds.getConnection())
                {
                    ControladoraVideoJuego controladora = new ControladoraVideoJuego(cnx);
                    controladora.modificarVideoJuego(videoJuego);
                    request.setAttribute("Resultado", "modificado");
                } 
                catch (SQLException ex) 
                {
                    Logger.getLogger(ModificarVideoJuego.class.getName()).log(Level.SEVERE, null, ex);
                    request.setAttribute("Resultado", "Error");
                }
            }
            catch(NumberFormatException nu)
            {
                request.setAttribute("Resultado", "Error");
            }
                    
        }
        request.getRequestDispatcher("/modificar.jsp").forward(request, response);
        
    }
}
