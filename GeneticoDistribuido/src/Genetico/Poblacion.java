/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetico;

import HerramientasImagenes.Conversion.CanalColor;
import java.util.ArrayList;

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
public class Poblacion {
    private CanalColor canalColor;
    private ArrayList<Individuo> poblacion;

    public Poblacion(CanalColor canalColor, int nIndividuos) {
        this.canalColor = canalColor;
        this.poblacion=new ArrayList<>();
        for(int i=0;i<nIndividuos; i++)
            this.poblacion.add(new Individuo(canalColor));
    }
    
    public Poblacion(ArrayList<Individuo> ind){
        this.poblacion= (ArrayList<Individuo>)ind.clone();
        this.canalColor= ind.get(0).getCanalColor();
    }
    
    
    public Individuo getMejor(){
        int mejor=0;
        for(int i=1;i<this.poblacion.size();i++){
            if(this.poblacion.get(mejor).getFitness()>this.poblacion.get(i).getFitness())
                mejor=i;
        }
        return new Individuo(this.poblacion.get(mejor).getGenotipo(), this.canalColor);
    }
    
    public Individuo getIndividuo(int indice){
        return new Individuo(this.poblacion.get(indice).getGenotipo(),this.canalColor);
    }
    
    public void addIndividuo(Individuo individuo){
        int peor=0;
        for(int i=1;i<this.poblacion.size();i++){
            if(this.poblacion.get(peor).getFitness()<this.poblacion.get(i).getFitness())
                peor=i;
        }
        this.poblacion.remove(peor);
        this.poblacion.add(new Individuo(individuo.getGenotipo(), canalColor));
    }
    
    public ArrayList<Individuo> getPoblacion(){
        return this.poblacion;
    }

}
