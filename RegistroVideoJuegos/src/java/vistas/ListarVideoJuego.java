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
import java.util.ArrayList;
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
@WebServlet(name = "ListarVideoJuego", urlPatterns = {"/ListarVideoJuego"})
public class ListarVideoJuego extends HttpServlet {
    
    @Resource(mappedName = "jdbc/videojuego")
    private DataSource ds;
   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        try(Connection conexion = ds.getConnection())
        {
            ControladoraVideoJuego controladora = new ControladoraVideoJuego(conexion);
            ArrayList<VideoJuego> listaVideoJuego = controladora.listarVideoJuegos();
            request.setAttribute("videoJuegos", listaVideoJuego);
        }
        catch(SQLException sql)
        {
            
        }
        request.getRequestDispatcher("listarElementos.jsp").forward(request, response);
        
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

 
}
