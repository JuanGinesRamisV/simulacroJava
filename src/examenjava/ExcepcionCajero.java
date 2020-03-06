/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenjava;

/**
 *
 * @author juang
 */
public class ExcepcionCajero extends Exception {

    public ExcepcionCajero() {
    }
    
    
    public  ExcepcionCajero(String dinero){
        super("no tenemos la cantidad de "+dinero+" euros en estos momentos en este "
                + "cajero");
        //System.out.println("hola");
    }
    
}
