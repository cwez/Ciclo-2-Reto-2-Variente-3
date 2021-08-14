/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Semana4.Reto2.Variante3;

/**
 *
 * @author Cristian S Wez
 */
public class Taxi extends Vehiculo{
    //Atributos 
    private double distanciaRecorrida; 
    private boolean segurosActivados;
    
    //Constructor especial
    public Taxi(String nombreConductor){
        
        super(nombreConductor, 1);
        
        
        this.distanciaRecorrida = 0;
        this.segurosActivados = false;
    }
    
    //getters y setters

    public double getDistanciaRecorrida() {
        return this.distanciaRecorrida;
    }

    public void setDistanciaRecorrida(double distanciaRecorrida) {
        this.distanciaRecorrida = distanciaRecorrida;
    }

    public boolean isSegurosActivados() {
        return this.segurosActivados;
    }

    public void setSegurosActivados(boolean segurosActivados) {
        this.segurosActivados = segurosActivados;
    }
    
    //Metodos
    
    public void reiniciarTaximetro(){
        this.distanciaRecorrida = 0;
    }
    
    public void presionarBotonPanico(){
        reiniciarTaximetro();
        setEnMarcha(false);
        segurosActivados = false;
        dejarPasajero();
        setCantidadDinero(getCantidadDinero() - this.calcularPasaje());
    }
    
    @Override
    public void dejarPasajero(){
        if(getnPasajeros() > 0 && isEnMarcha() && segurosActivados){
            setnPasajeros(getnPasajeros() - 1);
            reiniciarTaximetro();
            setCantidadDinero(getCantidadDinero() + this.calcularPasaje());
        }
    }
    
    public void recogerPasajero(){
        //if(isEnMarcha() && this.segurosActivados && getnPasajeros() < getnMaximoPasajeros()){
            setnPasajeros(getnPasajeros() + 1);
        //}
    }
    
    @Override
    public void gestionarMarcha() {
        if(isEnMarcha() && !this.segurosActivados){
            setEnMarcha(true);
        }
        else{
            setEnMarcha(false);
        }
    }
    
    @Override
    public void moverDerecha(double d){
        if(!isEnMarcha() && !this.segurosActivados){
            setLocalizacionX(getLocalizacionX() + d);
            if(getnPasajeros() > 0){
                distanciaRecorrida += d;
            }
        }
    }
    
    @Override
    public void moverIzquierda(double d){
        if(!isEnMarcha() && !this.segurosActivados){
            setLocalizacionX(getLocalizacionX() - d);
            if(getnPasajeros() > 0){
                distanciaRecorrida += d;
            }
        }
    }
    
    @Override
    public void moverArriba(double d){
        if(!isEnMarcha() && !this.segurosActivados){
            setLocalizacionY(getLocalizacionY() + d);
            if(getnPasajeros() > 0){
                distanciaRecorrida += d;
            }
        }
    }
    
    @Override
    public void moverAbajo(double d){
        if(!isEnMarcha() && !this.segurosActivados){
            setLocalizacionY(getLocalizacionY() - d);
            if(getnPasajeros() > 0){
                distanciaRecorrida += d;
            }
        }
    }
    
    public double calcularPasaje(){
        double vPasaje = 0;
        vPasaje = 3000 + (2300 * distanciaRecorrida);
        return vPasaje;
    }
    
    public void gestionarSeguros(){
        if(isEnMarcha() && !this.segurosActivados){
            this.segurosActivados = false; 
        }
        else{
            this.segurosActivados = !this.segurosActivados;
        }
    }
}
