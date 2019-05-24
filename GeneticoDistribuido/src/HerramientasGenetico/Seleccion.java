/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HerramientasGenetico;

import Genetico.Individuo;
import Genetico.Poblacion;
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
public class Seleccion {
    public enum TipoSeleccion{RANDOM,TORNEO,RULETA}
    
    public static Individuo seleccionMejor(Poblacion poblacion){
        return poblacion.getMejor();
    }
    
    public static Individuo seleccionAleatoria(Poblacion poblacion){
        int ind= new Random().nextInt(poblacion.getPoblacion().size());
        return poblacion.getIndividuo(ind);
    }
    public static Individuo seleccionRuleta(Poblacion poblacion){
        double fitnessPromedio=0;
        Random e =new Random();
        int indice;
        for(Individuo i: poblacion.getPoblacion()){
            fitnessPromedio+= i.getFitness();
        }
        fitnessPromedio/= poblacion.getPoblacion().size();
        indice=poblacion.getPoblacion().size()-1;
        while(true){
            if(poblacion.getIndividuo(indice).getFitness()<fitnessPromedio)
                return poblacion.getIndividuo(indice);
            indice= e.nextInt(poblacion.getPoblacion().size());
        }
    }
    
}
