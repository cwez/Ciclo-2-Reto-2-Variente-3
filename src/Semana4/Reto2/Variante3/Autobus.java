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
public class Autobus extends Vehiculo {
    //Atributos
    private boolean puertaAbierta; 
    
    //Constructor especial
    public Autobus(String nombreConductor, int nMaximoPasajeros){
        
        super(nombreConductor, nMaximoPasajeros);
        this.puertaAbierta = false;
    }

    //getters y setters
    
    public boolean isPuertaAbierta() {
        return this.puertaAbierta;
    }

    public void setPuertaAbierta(boolean puertaAbierta) {
        this.puertaAbierta = puertaAbierta;
    }
    
    
    
    //metodos
    
    public void recogerPasajero(int estrato){
        //analizar logica y sintaxis
        if(this.puertaAbierta == true && super.isEnMarcha() == false && super.getnPasajeros() < super.getnMaximoPasajeros()){
            super.setCantidadDinero(super.getCantidadDinero() + this.calcularPasaje(estrato));
            super.setnPasajeros(super.getnPasajeros() + 1);
        }
        
    }
    
    public void gestionarPuerta(){
        if(this.puertaAbierta == false && super.isEnMarcha() == false){
            this.puertaAbierta = true;
        }
        else{
            this.puertaAbierta = false;
        }
        
    }
    
    @Override
    public void gestionarMarcha(){
        if(super.isEnMarcha() == true && this.puertaAbierta == false){ // colocar en netbeans "&& super.isMotorEncendido() == true"
            super.setEnMarcha(true);
        }
        else{
            super.setEnMarcha(false);
        }
    }
    
    public static double calcularPasaje(int estrato){
        double valorPasaje = 0;
        if(estrato == 0 || estrato == 1 || estrato == 2){
            valorPasaje = 1500;
        }
        else if(estrato == 3 || estrato == 4 ){
            valorPasaje = 2600;
        }
        else if(estrato == 5 || estrato == 6){
            valorPasaje = 3000;
        }
        return valorPasaje;
    }
    
    
}