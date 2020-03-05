/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package examenjava;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author juang
 */
public class Cajero {

    private static int id_cajero_ultimo = 0;
    private int id_cajero;
    private int[][] listaBilletes;
    private ArrayList<Tarjeta> listaTarjetas;

    public Cajero() {
        this.setId_cajero(id_cajero_ultimo);
        id_cajero_ultimo++;
        this.setListaTarjetas(new ArrayList<Tarjeta>());
    }

    public Cajero(int id_cajero, int[][] listaBilletes, ArrayList<Tarjeta> listaTarjetas) {
        this.id_cajero = id_cajero;
        this.listaBilletes = listaBilletes;
        this.listaTarjetas = listaTarjetas;
    }

    public Cajero(Cajero c1) {
        this.id_cajero = c1.id_cajero;
        this.listaBilletes = c1.listaBilletes;
        this.listaTarjetas = c1.listaTarjetas;
    }

    public static int getId_cajero_ultimo() {
        return id_cajero_ultimo;
    }

    public static void setId_cajero_ultimo(int id_cajero_ultimo) {
        Cajero.id_cajero_ultimo = id_cajero_ultimo;
    }

    public int getId_cajero() {
        return id_cajero;
    }

    public void setId_cajero(int id_cajero) {
        this.id_cajero = id_cajero;
    }

    public int[][] getListaBilletes() {
        return listaBilletes;
    }

    public void setListaBilletes(int[][] listaBilletes) {
        this.listaBilletes = listaBilletes;
    }

    public ArrayList<Tarjeta> getListaTarjetas() {
        return listaTarjetas;
    }

    public void setListaTarjetas(ArrayList<Tarjeta> listaTarjetas) {
        this.listaTarjetas = listaTarjetas;
    }

    public void añadirTarjeta(Tarjeta c1) {
        this.getListaTarjetas().add(c1);
    }

    /* El metodó pide al usuario el nif y si lo encuentra pide la contraseña y 
    devuelve el indice del objeto dentro del arrayList si no se encuentra o la contraseña
    es incorrecta el indice devuelto es -1 */
    public int iniciarSesion() {
        //declaración de variables del metodo
        Scanner lector = new Scanner(System.in);
        System.out.println("Introduce el nif");
        boolean nifEncontrado = false;//boleano para almacenar si se ha encontrado o no el nif
        int sesionIniciada = -1;
        String nif = lector.next();
        String pin;
        int indiceNif = 0;

        //inicio de la ejecución
        for (int i = 0; i < this.getListaTarjetas().size(); i++) {
            if (nif.equals(this.getListaTarjetas().get(i).getNifCliente())) {
                nifEncontrado = true;
                indiceNif = i;
            }
        }
        //introducción contraseña 
        if (nifEncontrado == true) {
            System.out.println("Introduce la contraseña");
            pin = lector.next();
            if (pin.equals(this.getListaTarjetas().get(indiceNif).getPinCliente())) {
                sesionIniciada = indiceNif;
            } else {
                System.out.println("la contraseña no es correcta");
            }
        } else {
            System.out.println("no se ha encontrado el nif");
        }
        return sesionIniciada;
    }

    public boolean retirarDinero(int Dinero) {
        //billetes retirados sirve para almacenar el numero de billetes que se 
        //daran al cliente y tiene la misma estructura que el arraylist listaBilletes
        boolean retirar = false;
        int billetesRetirar[] = new int[this.getListaBilletes().length];

        //bucle que recorre todos los billetes
        for (int i = 0; i < this.getListaBilletes().length; i++) {
            //si el importe a retirar dividido el billete seleccionado es mayor que uno significa
            //que podemos usar ese billete para darle al cliente el menor numero de billetes entonces
            //se comprueba eso y ademas que tengamos billetes de ese tipo
            if ((Dinero / this.getListaBilletes()[i][0]) >= 1 && this.getListaBilletes()[i][1] > 0
                    && Dinero != 0) {
                /*si la condicion anterior se cumple se comprueba que disponemos de de la cantidad de
                billetes de ese tipo en caso de que no se diera esa condicion se le dara la cantidad
                disponible en el cajero de ese tipo de billetes
                 */
                System.out.println("necesitamos " + Dinero / this.getListaBilletes()[i][0]
                        + "billetes de " + this.getListaBilletes()[i][0]);
                if (this.getListaBilletes()[i][1] - (Dinero / this.getListaBilletes()[i][0]) >= 0) {
                    billetesRetirar[i] = Dinero / this.getListaBilletes()[i][0];
                    Dinero -= billetesRetirar[i] * this.getListaBilletes()[i][0];
                } else {
                    billetesRetirar[i] = this.getListaBilletes()[i][1];
                    Dinero -= billetesRetirar[i] * this.getListaBilletes()[i][0];
                }

            } else {
                System.out.println("nada");
            }
        }

        if (Dinero == 0) {
            //se retiran los billetes del array si es posible la retirada del dinero
            for (int i = 0; i < billetesRetirar.length; i++) {
                this.getListaBilletes()[i][1] -= billetesRetirar[i];

            }
            retirar = true;
        }
        return retirar;
    }

    public void mostrarCajero() {
        System.out.println("Billetes disponibles en cajero");
        for (int i = 0; i < this.getListaBilletes().length; i++) {
            System.out.println(this.getListaBilletes()[i][1] + " billetes de "
                    + this.getListaBilletes()[i][0]);
        }
    }
}
