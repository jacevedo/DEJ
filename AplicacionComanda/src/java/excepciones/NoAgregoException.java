/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package excepciones;

/**
 *
 * @author jaime
 * 
 * Excepcion customizada en el caso que haya error en el metodo
 * de agregar
 */
public class NoAgregoException extends Exception
{

    public NoAgregoException(String message) 
    {
        super(message);
    }
    
}
