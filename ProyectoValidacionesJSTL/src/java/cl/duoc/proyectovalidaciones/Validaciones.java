package cl.duoc.proyectovalidaciones;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 *
 * @author Jaime Acevedo
 * Clase que extiende de HttpServlet, la cual es llamada por el 
 * servidor. El name es el nombre del servlet y el urlPatterns
 * es el nombre en la url, podemos agregar cuantos nombres de url queramos 
 * y podremos llamar al servlet por cualquiera de esos nombres
 */
@WebServlet(name = "Validaciones", urlPatterns = {"/Validaciones"})
public class Validaciones extends HttpServlet {

    /**
     * Metodo ejecutado cuando el servlet es llamado por GET
     * Recuerden que se utiliza el metodo GET cuando queremos
     * restaurar el estado de un servlet
     * @param request parametro con el cual recibimos la informacion
     * del llamdado
     * @param response parametro con la informacion de respuesta 
     * @throws ServletException Excepcion controlada por el servidor
     * @throws IOException Exepcion controladoa por el servidor
     */
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        
    }

   /**
     * Metodo ejecutado cuando el servlet es llamado por POST
     * Recuerden que se utiliza el metodo POST cuando queremos
     * hacer cambios importantes en los datos
     * @param request parametro con el cual recibimos la informacion
     * del llamdado
     * @param response parametro con la informacion de respuesta 
     * @throws ServletException Excepcion controlada por el servidor
     * @throws IOException Exepcion controladoa por el servidor
     */
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException
    {
        
        //Creamos un map que contendra todos los mensajes  
        //de error a enviar
        Map<String, String> mapMensajes = new HashMap<>();
        //Obtenemos los valores del formulario, recordar que todos los 
        //parametros llegan en formato String
        //Obtenemos el parametro nombre del formulario
        String nombre = request.getParameter("nombre");
        //Obtenemos el parametro apellido1 del formulario
        String apellido1 = request.getParameter("apellido1");
        //Obtenemos el parametro apellido2 del formulario
        String apellido2 = request.getParameter("apellido2");
        //Obtenemos el parametro rut del formulario
        String rut = request.getParameter("rut");
        //Obtenemos el parametro dv del formulario
        String dv = request.getParameter("dv");
        //Obtenemos el parametro mail del formulario
        String mail = request.getParameter("mail");
        //Obtenemos el parametro telefono del formulario
        String telefono = request.getParameter("telefono");
        
        //todos los elementos recibidos son colocados en variables 
        //tipo atributos para re crear el estado del formulario
        request.setAttribute("nombre", nombre);
        request.setAttribute("apellido1", apellido1);
        request.setAttribute("apellido2", apellido2);
        request.setAttribute("rut", rut);
        request.setAttribute("dv", dv);
        request.setAttribute("mail", mail);
        request.setAttribute("telefono", telefono);
        
        //si el nombre es null o esta vacio enviamos un mensaje
        if(nombre == null || nombre.compareToIgnoreCase("")==0)
        {
            //Agregamos el nombre al map que almacenará los mensajes de 
            //error
            mapMensajes.put("nombre", "Debe tener al menos un campo");
        }
        //si el apellido1 es null o esta vacio enviamos un mensaje
        if(apellido1 == null || apellido1.compareToIgnoreCase("")==0)
        {
            //Agregamos el apellido1 al map que almacenará los mensajes de 
            //error
            mapMensajes.put("apellido1", "Debe tener al menos un campo");
        }
        //si el apellido2 es null o esta vacio enviamos un mensaje
        if(apellido2 == null || apellido2.compareToIgnoreCase("")==0)
        {
           //Agregamos el apellido2 al request para mostrar el mensaje en el formulario
           mapMensajes.put("apellido2", "Debe tener al menos un campo");
        }
        //si el rut o el digito verificador son null o estan vacios, si es así enviamos un mensaje al formulario
        if(rut == null || dv == null || rut.compareToIgnoreCase("")==0 || 
                dv.compareToIgnoreCase("")==0)
        {
            //Agregamos el rut al map que almacenará los mensajes de 
            //error
            mapMensajes.put("rut", "Debe ingresar datos tanto en el rut como en"
                    + " el digito verificador");
        }
        //llamamos al metodo de validacion del rut y colocamos el signo de
        //exclamacion al inicio para que entre al if solo si es false
        //esto equivale a rutValido(rut, dv) == false
        if(!rutValido(rut, dv))
        { 
            
           //Agregamos el rut al map que almacenará los mensajes de 
            //error
           mapMensajes.put("rut", "Rut invalido");
        }
        //llamamos al metodo de validacion de mail y colocamos el signo de
        //exclamacion al inicio para que entre al if solo si es false
        //esto equivale a mailValido(mail) == false
        if(!mailValido(mail))
        {
            //Agregamos el mail al map que almacenará los mensajes de 
            //error
           mapMensajes.put("mail", "Mail no es valido");
        }
        //consultamos si el telefono es igual a null o si no esta vacio, si no es así
        //llamamos al metodo de validacion de solo numeros
        //y colocamos el signo de exclamacion al inicio para que entre  
        //al if solo si es false
        //esto equivale a mailValido(mail) == false
        if(telefono == null || telefono.compareToIgnoreCase("") == 0 || !soloNumeros(telefono))
        {
           //Agregamos el telefono al map que almacenará los mensajes de 
            //error
           mapMensajes.put("telefono", "El numero de teléfono debe contener "
                                                + "solo numeros");
        }
        //Agregamos el map con los mensajes a los atributos enviados a la
        //vista
        request.setAttribute("mensajes", mapMensajes);
        //con el metodo request.getRequestDispatcher 
        //redirigimos a la pagina index.jsp y con el 
        //metodo forward re - enviamos los datos que nos llegaron por el 
        //formulario junto con los atributos que ingresamos en los if
        request.getRequestDispatcher("/index.jsp").forward(request, response);
    }
    /**
     * Metodo que nos indica si el digito verificador del rut es valido
     * @param rutString rut en formato String
     * @param dvString digito verificador en formato String
     * @return true si el rut es valido, false en caso contrario
     */
    private boolean rutValido(String rutString, String dvString)
    {
        //Creamos un try en el caso que la conversion del rut de string a
        //int contenga un error, esto puede pasar en el caso que los numeros
        //no esten dentro de los limites o contengan un caracter 
        //de tipo String
        try
        {
            //transformamamos el rut a String
            int rut = Integer.parseInt(rutString);
            //creamos una variable de tipo int llamada suma, en la cual
            //ingresaremos la suma de los digitos multiplicados por el factor
            int suma = 0;
            //creamos un for con el factor el cual se multiplicara con el 
            //resto, recordar que este numero llega a 7 y debe partir denuevo 
            //en dos, por otra parte la condicion del for es que el rut sea 
            //diferente de 0
            for(int factor = 2; rut > 0 ; factor++)
            {
                //obtenemos el ultimo digito del rut
                int digito = rut % 10;
                //eliminamos el utimo digito del rut
                rut = rut / 10;
                //sumamos a la variable suma el producto del digito con el factor
                suma += digito * factor;
                //si el factor es igual a 7, le cambiamos el valor
                // a uno debido a que en el siguiente ciclo este valor
                //se incrementa en uno quedando con valor 2
                if(factor == 7)
                {
                    factor = 1;
                }
            }
            //sacamos el resto de la suma y la incluimos en una variable
            int resto = suma % 11;
            //finalmente sacamos el calculo del digito verificador el cual
            //es 11 menos el resto
            int dv = 11 - resto;
            //si el digito verificador es 10 se reemplaza por una K
            //comparamos el valor con el digito obtenido, si concuerdan 
            //retornamos que el digito es correcto
            if(dv == 10 && dvString.compareToIgnoreCase("k")==0)
            {
                return true;
            }
            //En caso contrario transformamos el digito calculado a string
            //y lo comparamos con el que nos llega por parametro, si concuerdan
            //retornamos que el digito verificador es correcto
            else if((dv+"").compareToIgnoreCase(dvString)==0)
            {
                return true;
            }
            //si las condiciones anteriores son incorrecta quiere decir
            //que el digito verificador ingresado es erroneo por lo cual
            //devolvemos un false
            else
            {
                return false;
            }
        }
        //en el caso que el rut contenga datos de tipo String arrogara un 
        //NumberFormatException, cuando pase esto quiere decir que el rut
        //no es valido por lo cual retornaremos un false
        catch(NumberFormatException ne)
        {
            return false;
        }
    }
    /**
     * Metodo que valida el formato del rut por medio de una expresion regular
     * @param mail mail a validar
     * @return true si el formato es correcto, false en caso contrario
     */
    private boolean mailValido(String mail)
    {
        //Expresion regular de mail, puede ser encontrada en internet
        //en conjunto con otras expresiones regulares
        String expresionMail = 
        "^[_a-z0-9-]+(.[_a-z0-9-]+)*@[a-z0-9-]+(.[a-z0-9-]+)*(.[a-z]{2,4})$";
        
        //La clase Pattern compila la expresion para ser comparada con 
        //otro texto
        Pattern pattern = Pattern.compile(expresionMail);
        //La clase Matcher toma el patron del mail y lo compara con
        //el texto recibido por parametro
        Matcher matcher = pattern.matcher(mail);
        //Compara el texto con el patron, y retorna si el formato es correcto
        return matcher.matches();
    }
    /**
     * Metodo que valida si contiene solo numeros por medio de una expresion regular
     * @param telefono texto a validar
     * @return true si solo contiene numeros, false en caso contrario
     */
    private boolean soloNumeros(String telefono)
    {
        //Expresion regular que indica si solo existen numeros
        String expresionSoloNumeros = "[0-9]*";
        //La clase Pattern compila la expresion para ser comparada con 
        //otro texto
        Pattern pattern = Pattern.compile(expresionSoloNumeros);
        //La clase Matcher toma el patron solo numeros y lo compara con
        //el texto recibido por parametro
        Matcher matcher = pattern.matcher(telefono);
        //Compara el texto con el patron, y retorna si el formato es correcto
        return matcher.matches();
    }
}
