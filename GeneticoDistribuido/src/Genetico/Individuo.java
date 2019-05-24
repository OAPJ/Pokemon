/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetico;

import HerramientasImagenes.Conversion;
import HerramientasImagenes.Conversion.CanalColor;
import java.awt.Color;
import java.io.Serializable;
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
public class Individuo implements Serializable{
    private int genotipo[][];
    private long fitness;
    private CanalColor canalColor;

    public CanalColor getCanalColor() {
        return canalColor;
    }
    public Individuo(CanalColor cc) {
        generarGenotipoAleatorio();
        this.canalColor=cc;
        calcularFitness();
    }

    public Individuo(int[][] genotipo, CanalColor cc) {
        this.genotipo = (int[][])genotipo.clone();
        this.canalColor=cc;
        calcularFitness();
    }

    private void generarGenotipoAleatorio() {
        Random r= new Random();
        this.genotipo= new int[Conversion.matrixR.length][Conversion.matrixR[0].length];
        for(int fila[] : this.genotipo){
            for(int i=0;i< fila.length;i++){
                fila[i]=r.nextInt(256);
            }
        }
    }

    public int[][] getGenotipo() {
        return genotipo;
    }

    public long getFitness() {
        return fitness;
    }

    private void calcularFitness() {
        this.fitness=0;
        switch(this.canalColor){
            case ROJO:
                calcularFitnessRojo();
                break;
            case VERDE:
                calcularFitneesVerde();
                break;
            case AZUL:
                calcularFitneesAzul();
                break;
            default:
                break;
        }
    }

    public void actualizarIndividuo(){
        calcularFitness();
    }

    private void calcularFitnessRojo() {
        this.fitness=0;
        for (int x = 0; x < genotipo.length; x++) {
            for (int y = 0; y < genotipo[0].length; y++) {
                this.fitness+=Math.abs(this.genotipo[x][y]- Conversion.matrixR[x][y]);
            }
        }
    }

    private void calcularFitneesVerde() {
        this.fitness=0;
        for (int x = 0; x < genotipo.length; x++) {
            for (int y = 0; y < genotipo[0].length; y++) {
                this.fitness+=Math.abs(this.genotipo[x][y]- Conversion.matrixG[x][y]);
            }
        }
    }

    private void calcularFitneesAzul() {
        this.fitness=0;
        for (int x = 0; x < genotipo.length; x++) {
            for (int y = 0; y < genotipo[0].length; y++) {
                this.fitness+=Math.abs(this.genotipo[x][y]- Conversion.matrixB[x][y]);
            }
        }
    }
}
