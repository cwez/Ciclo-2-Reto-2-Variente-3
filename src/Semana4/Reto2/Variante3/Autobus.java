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
        if(isEnMarcha() && !isPuertaAbierta()){
            if(getnPasajeros() <= getnMaximoPasajeros()){
                setnPasajeros(getnPasajeros() + 1);
                setCantidadDinero(getCantidadDinero() + this.calcularPasaje(estrato));
            }
        }
        
        /*this.setCantidadDinero() ++ Autobus.calcularPasaje(estrato); //¿this.?
        if(this.getnPasajeros() <= this.getnMaximoPasajeros()){
            this.getnPasajeros() += 1;
        }*/
    }
    
    public void gestionarPuerta(){
        if(this.puertaAbierta && this.isEnMarcha()){
            this.puertaAbierta = true;
        }
        
    }
    
    @Override
    public void gestionarMarcha(){
        if(this.isEnMarcha() && this.puertaAbierta){
            setEnMarcha(!isEnMarcha());
        }
    }
    
    public static double calcularPasaje(int estrato){
        int valorPasaje = 0;
        if(0 >= estrato && estrato <= 2 ){
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