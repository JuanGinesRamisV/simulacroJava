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
public class TarjetaDebito extends Tarjeta {

    private double saldo;

    public TarjetaDebito() {
    }

    public TarjetaDebito(double saldo, String nifCliente, String pinCliente, String nombreCliente, String apellidoCliente) {
        super(nifCliente, pinCliente, nombreCliente, apellidoCliente);
        this.saldo = saldo;
    }

    public TarjetaDebito(TarjetaDebito c1) {
        this.setNifCliente(c1.getNifCliente());
        this.setPinCliente(c1.getPinCliente());
        this.setNombreCliente(c1.getNombreCliente());
        this.setApellidoCliente(c1.getApellidoCliente());
        this.setSaldo(c1.getSaldo());
    }

    public double getSaldo() {
        return saldo;
    }

    public void setSaldo(double saldo) {
        this.saldo = saldo;
    }
    
    public boolean SaldoDisponible(int retirar){
        boolean dineroDisponible;
        if(this.getSaldo()-retirar>=0){
            dineroDisponible=true;
        }else{
            dineroDisponible=false;
        }
        return dineroDisponible;
    }
    
    public void disminuirSaldo(int retirar){
        System.out.println(saldo);
        this.setSaldo(this.getSaldo()-retirar);
        System.out.println(saldo);
    }
    
    @Override
    public void mostrarTarjeta(){
        super.mostrarTarjeta();
        System.out.println("saldo: "+this.getSaldo());
    }
}
