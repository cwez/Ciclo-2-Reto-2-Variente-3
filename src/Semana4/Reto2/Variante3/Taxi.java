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
        super.setEnMarcha(false);
        this.segurosActivados = false;
        dejarPasajero();
        super.setCantidadDinero(super.getCantidadDinero() - this.calcularPasaje());
    }
    
    @Override
    public void dejarPasajero(){
        if(super.getnPasajeros() > 0 && super.isEnMarcha() == false && segurosActivados == false){
            super.setCantidadDinero(super.getCantidadDinero() + this.calcularPasaje());
            super.setnPasajeros(super.getnPasajeros() - 1);
            reiniciarTaximetro();
            
        }
    }
    
    public void recogerPasajero(){
        if(super.isEnMarcha() && this.segurosActivados && super.getnPasajeros() < super.getnMaximoPasajeros()){
            super.setnPasajeros(super.getnPasajeros() + 1);
        }
    }
    
    @Override
    public void gestionarMarcha() {
        if(super.isEnMarcha() == false && this.segurosActivados == true){
            super.setEnMarcha(true);
        }
        else{
            super.setEnMarcha(false);
        }
    }
    
    @Override
    public void moverDerecha(double d){
        if(super.isEnMarcha() == true ){ // colocar en IDE && this.segurosActivados == true
            super.setLocalizacionX(super.getLocalizacionX() + d);
            if(super.getnPasajeros() > 0){
                this.distanciaRecorrida += d;
            }
        }
    }
    
    @Override
    public void moverIzquierda(double d){
        if(super.isEnMarcha() == true){ //colocar en IDE  && this.segurosActivados == true
            super.setLocalizacionX(super.getLocalizacionX() - d);
            if(super.getnPasajeros() > 0){
                this.distanciaRecorrida += d;
            }
        }
    }
    
    @Override
    public void moverArriba(double d){
        if(super.isEnMarcha() == true){ // colocar en IDE && this.segurosActivados == true
            super.setLocalizacionY(super.getLocalizacionY() + d);
            if(super.getnPasajeros() > 0){
                this.distanciaRecorrida += d;
            }
        }
    }
    
    @Override
    public void moverAbajo(double d){
        if(super.isEnMarcha()){// colocar en IDE  && this.segurosActivados == true
            super.setLocalizacionY(super.getLocalizacionY() - d);
            if(super.getnPasajeros() > 0){
                this.distanciaRecorrida += d;
            }
        }
    }
    
    public double calcularPasaje(){
        double vPasaje = 0;
        vPasaje = 3000 + (2300 * this.getDistanciaRecorrida());
        return vPasaje;
    }
    
    public void gestionarSeguros(){
        if(super.isEnMarcha() == false && this.segurosActivados == true){
            this.segurosActivados = false; 
        }
        else{
            this.segurosActivados = true; 
        }
    }
} // terminado :')
