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
@WebServlet(name = "AgregarJuego", urlPatterns = {"/AgregarJuego"})
public class AgregarJuego extends HttpServlet {

    @Resource(mappedName = "jdbc/videojuego")
    private DataSource ds;
    
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        request.getRequestDispatcher("/ingresar.jsp").forward(request, response);
    }

   
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        try(Connection cnx = ds.getConnection())
        {
            String nombreJuego = request.getParameter("nombreJuego");
            String precioJuego = request.getParameter("precioJuego");
            String generoJuego = request.getParameter("generoJuego");
            int precioJuegoInt = Integer.parseInt(precioJuego);

            VideoJuego videoJuego = new VideoJuego(-1, nombreJuego, precioJuegoInt, generoJuego);
            ControladoraVideoJuego controla = new ControladoraVideoJuego(cnx);
            controla.agregarVideoJuego(videoJuego);
        }
        catch(SQLException sqlex)
        {
            
        }
        request.getRequestDispatcher("/ingresar.jsp").forward(request, response);
    }

   
}
