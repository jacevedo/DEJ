/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.duoc.select;

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
@WebServlet(name = "ServletSelect", urlPatterns = {"/ServletSelect"})
public class ServletSelect extends HttpServlet {

  
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

    
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
        String idString = request.getParameter("id");
        int id = Integer.parseInt(idString);
        String opciones = "";
        switch(id)
        {
            case -1:
                opciones = "<option value='-1'>Seleccione tipo de mascota</option>";
                break;
            case 0:
                opciones = "<option value='-1'>Seleccione tipo de mascota</option>" +
                        "<option value='0'>Kilterrier</option>" +
                        "<option value='1'>Pastor Aleman</option>" +
                        "<option value='2'>Poodle</option>" +
                        "<option value='3'>Pug</option>";
                break;
            case 1:
                 opciones = "<option value='-1'>Seleccione tipo de mascota</option>" +
                        "<option value='0'>Siames</option>" +
                        "<option value='1'>Persa</option>" +
                        "<option value='2'>Angora</option>" +
                        "<option value='3'>Gato Montañes</option>";
                break;
            case 2:
                 opciones = "<option value='-1'>Seleccione tipo de mascota</option>" +
                        "<option value='0'>Mustang</option>" +
                        "<option value='1'>Australiano</option>" +
                        "<option value='2'>Ponny</option>" +
                        "<option value='3'>Arabe</option>";
                break;
        }
        response.setContentType("text/html;charset=UTF-8");
        try (PrintWriter out = response.getWriter()) {
            out.print(opciones);
        }
        catch(Exception ex)
        {
            
        }
    }

   
}
