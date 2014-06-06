package Controladores;

import Modelos.Equipo;
import Modelos.Estadio;
import java.lang.Math;

public class ControladorPartido {
    Estadio cancha;
    Equipo equipo1;
    Equipo equipo2;


    public ControladorPartido() {
        this.cancha = new Estadio();
        this.equipo1 = new Equipo();
        this.equipo2 = new Equipo();
    }

    public void simularPartido() {
    }
    
    public void enfrentamiento(int[]posa, int[]posb){
        int eleccion;
        int dis;
        dis=distancia(posa, posb);
        if (dis<50){
            eleccion=(int)Math.random()*2+1;
        }
        else{
            eleccion=(int)Math.random()*3+1;
        }
        switch(eleccion){
            case 1:
                driblear(pos a, posb, equipo1.getDribleo(posa), equipo2.getBloqueo(posb));
                break;
            case 2:
                pasar(equipo1.posicionJCercano(), posa , equipo1.getPase(posa), posb, equipo2.getBloqueo(posb));
                break;
            case 3: 
                disparar();
                break;
        }
    }
    
    public void driblear(int x, int y, int dribleoA, int bloqueoB){
        if(dribleoA==bloqueoB){
            this.cancha.setPosicionBalon=x;
        }
        else if (dribleoA<bloqueoB){
            this.cancha.setPosicionBalon=y;
            luegoDribleo(x,y);
        }
        else if (dribleoA>bloqueoB){
            this.cancha.setPosicionBalon=x;
            luegoDribleo(x,y);
        }
    }
   public void luegoDribleo(int x,int y){
       if (this.equipo1.distanciaArcoRival()>this.equipo2.distanciaArcoRival){
           this.equipo1.setPosicion()=y;
           this.equipo2.setPosicion()=x;
       }
   }
    
    public void pasar(int[] posCercana, int[] posAtacante, int paseA, int[] posDefensor, int bloqueoB ){ 
        int distanciaP;
        distanciaP=paseA-bloqueoB;
        int distanciaJugadorcercano;
        distanciaJugadorcercano=distancia(posCercana, posAtacante);
        if (distanciaP<=0)
        {
            this.cancha.setPosicionBalon=posDefensor;
        }
        else{
            if(distanciaJugadorcercano<distanciaP)
            {
                this.cancha.setPosicionBalon=posCercana;
            }
            else if(distanciaJugadorcercano>distanciaP){
                double pase;
                pase= distanciaJugadorcercano/2;
                if(distanciaP>pase){
                    resultadoPase(posCercana);
            }
                else
                    resultadoPase(posDefensor);
            }
        }
    }
    
    public void resultadoPase(int [] posicion){
        int pos[]=new int[2];
        pos[1]=0;
        pos[0]=0;
        int fila = (int)Math.random()*4;
        int columna=(int)Math.random()*4;
        pos[0]=posicion[0]+fila;
        pos[1]=posicion[1]+columna;
        this.cancha.setPosicionBalon=pos;
    }
    public void disparar(){  
    }
    
    public int distancia(int[] x, int []y){
        int f1 = x[0];
        int c1 = x[1];
        int f2 = y[0];
        int c2 = y[1];
        double res =Math.sqrt((f2-f1)^2+(c2-c1)^2);
        return ((int)res); 
    }
    
    

}
