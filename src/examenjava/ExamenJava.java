/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenjava;

import java.util.Scanner;

/**
 *
 * @author juang
 */
public class ExamenJava {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        int[][] cargaBilletes = {{500, 10}, {200, 0}, {100, 0}, {50, 27},
        {20, 0}, {10, 18}, {5, 25}};
        Cajero micajero = new Cajero();
        micajero.setListaBilletes(cargaBilletes);
        TarjetaDebito mitarj1 = new TarjetaDebito(200000, "43476294", "1234", "juan", "Ramis");
        TarjetaCredito mitarj2 = new TarjetaCredito(200, 443, "80", "1234", "ana", "Vera");
        micajero.añadirTarjeta(mitarj1);
        micajero.añadirTarjeta(mitarj2);
        Scanner lector = new Scanner(System.in);
        boolean salir = false;

        
        while (salir == false) {
            int opcion = 0;
            int dinero;
            System.out.println("++++++++++++++++++");
            System.out.println("+++++++++++++++++++");
            micajero.mostrarCajero();
            int indiceCliente = -1;
            System.out.println("----------");
            System.out.println("1)sacar dinero");
            System.out.println("2)salir");
            System.out.println("---------------");
            opcion = lector.nextInt();
            switch (opcion) {
                case 1:
                    /*
                    indiceCliente = micajero.iniciarSesion();
                    if (indiceCliente != -1) {

                        System.out.println("Introduce el dinero a retirar");
                        dinero = lector.nextInt();
                        //if(micajero.getListaTarjetas().get(indiceCliente).)
                        micajero.retirarDinero(dinero);
                    }
*/
                    retirarDinero(micajero);
            }
        }

    }

    public static void retirarDinero(Cajero micajero) {
        Scanner lector = new Scanner(System.in);

        int indiceCliente = micajero.iniciarSesion();
        if (indiceCliente != -1) {
            System.out.println("Introduce el dinero a retirar");
            int dinero = lector.nextInt();
            //se comprueba que el cliente tenga salgo disponible y que el dinero 
            //sea divisor de 5 y sea mayor que 0
            if(micajero.getListaTarjetas().get(indiceCliente).SaldoDisponible(dinero)==true
                    && dinero%5==0 && dinero>0){
                
            if(micajero.retirarDinero(dinero)==true){
                System.out.println("Aqui tiens tu dinero");
                micajero.getListaTarjetas().get(indiceCliente).disminuirSaldo(dinero);
                System.out.println("");
                System.out.println("+-+-+-+-+-+-+-+--+");
            }
                
            }else{
                System.out.println("Se ha producido un error");
            }
        }

    }

}
