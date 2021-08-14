package Semana4.Reto2.Variante3;

/**
 *
 * @author Cristian S Wez
 */
public abstract class Vehiculo {

    //Atributos
    private String nombreConductor;
    private int nPasajeros;
    private int nMaximoPasajeros;
    private double cantidadDinero;
    private double localizacionX;
    private double localizacionY;
    private boolean aireAcondicionadoActivado;
    private boolean motorEncendido;
    private boolean wifiEncendido;
    private boolean enMarcha;

    //Constructor
    public Vehiculo(String nombreConductor, int nMaximoPasajeros) {
        this.nombreConductor = nombreConductor;
        this.nMaximoPasajeros = nMaximoPasajeros;

        this.nPasajeros = 0;
        this.cantidadDinero = 0;
        this.localizacionX = 0;
        this.localizacionY = 0;
        this.aireAcondicionadoActivado = false;
        this.motorEncendido = false;
        this.wifiEncendido = false;
        this.enMarcha = false;
    }
    
    //getters y setters
    
    public String getNombreConductor() {
        return this.nombreConductor;
    }

    public void setNombreConductor(String nombreConductor) {
        this.nombreConductor = nombreConductor;
    }

    public int getnPasajeros() {
        return this.nPasajeros;
    }

    public void setnPasajeros(int nPasajeros) {
        this.nPasajeros = nPasajeros;
    }

    public int getnMaximoPasajeros() {
        return this.nMaximoPasajeros;
    }

    public void setnMaximoPasajeros(int nMaximoPasajeros) {
        this.nMaximoPasajeros = nMaximoPasajeros;
    }

    public double getCantidadDinero() {
        return this.cantidadDinero;
    }

    public void setCantidadDinero(double cantidadDinero) {
        this.cantidadDinero = cantidadDinero;
    }

    public double getLocalizacionX() {
        return this.localizacionX;
    }

    public void setLocalizacionX(double localizacionX) {
        this.localizacionX = localizacionX;
    }

    public double getLocalizacionY() {
        return this.localizacionY;
    }

    public void setLocalizacionY(double localizacionY) {
        this.localizacionY = localizacionY;
    }

    public boolean isAireAcondicionadoActivado() {
        return this.aireAcondicionadoActivado;
    }

    public void setAireAcondicionadoActivado(boolean aireAcondicionadoActivado) {
        this.aireAcondicionadoActivado = aireAcondicionadoActivado;
    }

    public boolean isMotorEncendido() {
        return this.motorEncendido;
    }

    public void setMotorEncendido(boolean motorEncendido) {
        this.motorEncendido = motorEncendido;
    }

    public boolean isWifiEncendido() {
        return this.wifiEncendido;
    }

    public void setWifiEncendido(boolean wifiEncendido) {
        this.wifiEncendido = wifiEncendido;
    }

    public boolean isEnMarcha() {
        return this.enMarcha;
    }

    public void setEnMarcha(boolean enMarcha) {
        this.enMarcha = enMarcha;
    }

    //Metodos
    public void dejarPasajero() {
        this.nPasajeros--;
    }

    public double calcularDistanciaAcopio() {
        return Math.sqrt(Math.pow(this.localizacionX, 2) + Math.pow(this.localizacionY, 2));
    }

    public void gestionarAireAcondicionado() {
        if (this.motorEncendido == true && this.aireAcondicionadoActivado == false) {
            this.aireAcondicionadoActivado = true;
        }
        
        else{
            this.aireAcondicionadoActivado = false;
        }
    }

    public void gestionarMotor() {
        if (this.motorEncendido == false) {
            this.motorEncendido = true;
        } 
        
        else {
            this.motorEncendido = false;
            this.aireAcondicionadoActivado = false;
            this.wifiEncendido = false;
            this.enMarcha = false;
        }
        
    }
    
    public void gestionarWifi(){
        if(this.motorEncendido == true && this.wifiEncendido == false){
            this.wifiEncendido = true;
        }
        
        else{
            this.wifiEncendido = false;
        }
    }
    
    public abstract void gestionarMarcha(); 
    
    public void moverDerecha (double d){
        if(this.enMarcha == true){
            this.localizacionX = this.localizacionX + d;
        }
    }
    
    public void moverIzquierda (double d){
        if(this.enMarcha == true){
            this.localizacionX = this.localizacionX - d;
        }
    }
    
    public void moverArriba (double d){
        if(this.enMarcha == true){
            this.localizacionY = this.localizacionY + d;
        }
    }
    
    public void moverAbajo (double d){
        if(this.enMarcha == true){
            this.localizacionY = this.localizacionY - d;
        }
    }
}// terminado :')
