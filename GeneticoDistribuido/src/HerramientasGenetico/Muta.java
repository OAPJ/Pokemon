/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HerramientasGenetico;

import Genetico.Individuo;
import java.util.Random;
/**
 *
 * Nombres: Miguel Angel Cervantes Garcia, Juan Antonio Ovalle Patiño
 * Matriculas: 2017670201, 2017670891
 * Tema del programa: Algortimo Genetico Distribuido
 * Descripcion: Es un algorutmo genetico que trata de recrear la imagen que se escogio, y diferentes computadoras
 *              van a resolver un cal¿nal en especial y al final se manda al maestro para crear la imagen resultante.
 * Fecha: 3 / Junio / 2019
 * Programa Academico: Ingenieria en Sistemas Computacionales
 * Aprendizaje: Aplicaciones para Comunicaciones de Red & Algoritmos Geneticos
 * 
 */
public class Muta {
    private static void mutarFila(Individuo sujeto){
        Random r= new Random();
        int indice= r.nextInt(sujeto.getGenotipo().length);
        for(int i=0;i<sujeto.getGenotipo()[0].length;i++)
            sujeto.getGenotipo()[indice][i]=(sujeto.getGenotipo()[indice][i]+r.nextInt(254)+1)%256;
        sujeto.actualizarIndividuo();
    }
    
    private static void mutarColumna(Individuo sujeto){
        Random r= new Random();
        int indice= r.nextInt(sujeto.getGenotipo()[0].length);
        for(int i=0;i<sujeto.getGenotipo().length;i++){
            sujeto.getGenotipo()[i][indice]=(sujeto.getGenotipo()[i][indice]+r.nextInt(254)+1)%256;
        }
        sujeto.actualizarIndividuo();
    }
    
    private static void mutarConjuntoPixeles(Individuo sujeto){
        Random r= new Random();
        int numPixeles= r.nextInt(sujeto.getGenotipo().length*sujeto.getGenotipo()[0].length-10);
        for(int i=0;i<numPixeles;i++){
            int x= r.nextInt(sujeto.getGenotipo().length),y=r.nextInt(sujeto.getGenotipo()[0].length);
            sujeto.getGenotipo()[x][y]= (sujeto.getGenotipo()[x][y]+r.nextInt(254)+1)%256;
        }
        sujeto.actualizarIndividuo();
    }
    
    public static void mutar(double probabilidad, Individuo sujeto){
        Random r= new Random();
        int opc= r.nextInt(3);
        if(probabilidad>=r.nextDouble()){
        switch(opc){
            case 0:
                mutarFila(sujeto);
                break;
            case 1:
                mutarColumna(sujeto);
                break;
            case 2:
                mutarConjuntoPixeles(sujeto);
                break;
            default:
                break;
        }
    }
    }
}
