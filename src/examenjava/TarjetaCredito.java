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
public class TarjetaCredito extends Tarjeta {

    private double saldo;
    private double credito;

    public TarjetaCredito() {
    }

    public TarjetaCredito(double saldo, double credito, String nifCliente, String pinCliente, String nombreCliente, String apellidoCliente) {
        super(nifCliente, pinCliente, nombreCliente, apellidoCliente);
        this.saldo = saldo;
        this.credito = credito;
    }

    public TarjetaCredito(TarjetaCredito c1) {
        this.setNifCliente(c1.getNifCliente());
        this.setPinCliente(c1.getPinCliente());
        this.setNombreCliente(c1.getNombreCliente());
        this.setApellidoCliente(c1.getApellidoCliente());
        this.setSaldo(c1.getSaldo());
        this.setCredito(c1.getCredito());
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }

    public double getCredito() {
        return credito;
    }

    public void setCredito(double credito) {
        this.credito = credito;
    }

    public void mostrarTarjeta() {
        super.mostrarTarjeta();
        System.out.println("Saldo: " + this.getSaldo());
        System.out.println("Credito: " + this.getCredito());
    }

    @Override
    public boolean SaldoDisponible(int retirar) {
        boolean dineroDisponible;
        if ((this.getSaldo() + this.getCredito()) - retirar >= 0) {
            dineroDisponible = true;
        } else {
            dineroDisponible = false;
        }
        return dineroDisponible;

    }

    @Override
    public void disminuirSaldo(int retirar) {
        //primero se retira el saldo y se comprueba si este menos el dinero a retirar
        //es mayor que cero se resta al saldo si no se pone el saldo a cero y se resta el 
        //saldo a la variable retirar
        if(this.getSaldo()-retirar>=0){
            this.setSaldo(this.getSaldo()-retirar);
            retirar=0;
        }else{
            retirar-=this.getSaldo();
            this.setSaldo(0);
        }
        
        if(retirar!=0){
            this.setCredito(this.getCredito()-retirar);
        }
    }

}
