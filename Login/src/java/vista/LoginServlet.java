/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package vista;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author jaime
 */
@WebServlet(name = "LoginServlet", urlPatterns = {"/LoginServlet"})
public class LoginServlet extends HttpServlet {

   
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    /**
     * Handles the HTTP <code>POST</code> method.
     *
     * @param request servlet request
     * @param response servlet response
     * @throws ServletException if a servlet-specific error occurs
     * @throws IOException if an I/O error occurs
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String usuario = request.getParameter("usuario");
        String contrasena = request.getParameter("password");
        
        if(usuario.compareToIgnoreCase("jaime") == 0 && contrasena.compareToIgnoreCase("jaime")==0)
        {
            request.getSession().setAttribute("usuario", usuario);
            request.setAttribute("usuario", usuario);
            request.getRequestDispatcher("/pagina2.jsp").forward(request, response);
        }
        else
        {
            request.setAttribute("usuario", usuario);
            request.setAttribute("error", "Nombre de usuario o contraseña incorrecta");
            request.getRequestDispatcher("/index.jsp").forward(request, response);
        }
        
    }

   
}
