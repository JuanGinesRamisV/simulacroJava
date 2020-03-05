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
public abstract class Tarjeta {

    private String nifCliente;
    private String pinCliente;
    private String nombreCliente;
    private String apellidoCliente;

    public Tarjeta() {
    }

    public Tarjeta(String nifCliente, String pinCliente, String nombreCliente, String apellidoCliente) {
        this.nifCliente = nifCliente;
        this.pinCliente = pinCliente;
        this.nombreCliente = nombreCliente;
        this.apellidoCliente = apellidoCliente;
    }

    public Tarjeta(Tarjeta c1) {
        this.nifCliente = c1.nifCliente;
        this.pinCliente = c1.pinCliente;
        this.nombreCliente = c1.nombreCliente;
        this.apellidoCliente = c1.apellidoCliente;
    }

    public String getNifCliente() {
        return nifCliente;
    }

    public void setNifCliente(String nifCliente) {
        this.nifCliente = nifCliente;
    }

    public String getPinCliente() {
        return pinCliente;
    }

    public void setPinCliente(String pinCliente) {
        this.pinCliente = pinCliente;
    }

    public String getNombreCliente() {
        return nombreCliente;
    }

    public void setNombreCliente(String nombreCliente) {
        this.nombreCliente = nombreCliente;
    }

    public String getApellidoCliente() {
        return apellidoCliente;
    }

    public void setApellidoCliente(String apellidoCliente) {
        this.apellidoCliente = apellidoCliente;
    }

    public void mostrarTarjeta() {
        System.out.println("nif: " + this.getNifCliente());
        System.out.println("pin: " + this.getPinCliente());
        System.out.println("nombre: " + this.getNombreCliente());
        System.out.println("apellido: " + this.getApellidoCliente());
    }

    public abstract boolean SaldoDisponible(int retirar);

    public abstract void disminuirSaldo(int retirar);
}
