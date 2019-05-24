/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HerramientasGenetico;

import Genetico.Individuo;
import HerramientasImagenes.Conversion;
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
public class Cruza {

    public static Individuo cruzaAleatoria(boolean[][] mascaraPixeles, boolean[] mascaraColumnas, boolean[] mascaraFilas, Individuo madre, Individuo padre) {
        int opc= new Random().nextInt(3);
        switch(opc){
            case 0:
                return cruzaFilaXFila(mascaraFilas, madre, padre);
            case 1:
                return cruzaPixelXPixel(mascaraPixeles, padre, madre);
            default:
                return cruzaColumnaXColumna(mascaraColumnas, madre, padre);
        }
    }
    public enum TipoCruza{CRUZA_PIXEL,CRUZA_COLUMNA,CRUZA_FILA,CRUZA_ALEATORIA}
    public static boolean[][] generarMascaraPixelXPixel(){
        Random r= new Random();
        boolean mask[][] = new boolean[Conversion.matrixB.length][Conversion.matrixB[0].length];
        for(int x=0;x<mask.length;x++){
            for(int y=0;y<mask[0].length;y++){
                mask[x][y]= r.nextBoolean();
            }
        }
        return mask;
    }
    public static boolean[] generarMascaraFilaXFila(){
        Random r= new Random();
        boolean mask[]= new boolean[Conversion.matrixB.length];
        for(int i =0; i<mask.length;i++){
            mask[i]= r.nextBoolean();
        }
        return mask;
    }
    
    public static boolean[] generarMascaraColumnaXColumna(){
        Random r= new Random();
        boolean mask[]= new boolean[Conversion.matrixB[0].length];
        for(int i =0; i<mask.length;i++){
            mask[i]= r.nextBoolean();
        }
        return mask;
    }
    
    public static Individuo cruzaPixelXPixel(boolean mascara [][],Individuo padre, Individuo madre){
        Individuo hijo, hija;
        int geno1[][]= new int[padre.getGenotipo().length][padre.getGenotipo()[0].length];
        int geno2[][]= new int[madre.getGenotipo().length][madre.getGenotipo()[0].length];
        for(int x=0;x<geno1.length;x++){
            for(int y=0;y<geno2[0].length;y++){//preguntar a Juanito
                geno1[x][y]=(mascara[x][y]==true)? madre.getGenotipo()[x][y] : padre.getGenotipo()[x][y];
                geno2[x][y]=(mascara[x][y]==false)? madre.getGenotipo()[x][y] : padre.getGenotipo()[x][y];
            }
        }
        hijo= new Individuo(geno1, padre.getCanalColor());
        hija= new Individuo(geno2, madre.getCanalColor());
        return (hijo.getFitness()<hija.getFitness())? hijo : hija; //Preguntar Tambien
    }
    
    public static Individuo cruzaFilaXFila(boolean mascara[], Individuo madre, Individuo padre){
        Individuo hijo, hija;
        int geno1[][]= new int[padre.getGenotipo().length][padre.getGenotipo()[0].length];
        int geno2[][]= new int[madre.getGenotipo().length][madre.getGenotipo()[0].length];
        for(int i=0;i<mascara.length;i++){
            if(mascara[i]==true)
                for(int j=0;j<madre.getGenotipo()[i].length;j++){
                    geno1[i][j]=madre.getGenotipo()[i][j];
                    geno2[i][j]=padre.getGenotipo()[i][j];
                }
            else
                for(int j=0;j<madre.getGenotipo()[i].length;j++){
                    geno1[i][j]=padre.getGenotipo()[i][j];
                    geno2[i][j]=madre.getGenotipo()[i][j];
                }
        }
        hijo= new Individuo(geno1, padre.getCanalColor());
        hija= new Individuo(geno2, madre.getCanalColor());
        return (hijo.getFitness()<hija.getFitness())? hijo : hija; //Preguntar Tambien
    }
    
    public static Individuo cruzaColumnaXColumna(boolean mascara[], Individuo madre, Individuo padre){
        Individuo hijo, hija;
        int geno1[][]= new int[padre.getGenotipo().length][padre.getGenotipo()[0].length];
        int geno2[][]= new int[madre.getGenotipo().length][madre.getGenotipo()[0].length];
        for(int i=0;i<mascara.length;i++){
            if(mascara[i]==true)
                for(int j=0;j<madre.getGenotipo().length;j++){
                    geno1[j][i]=madre.getGenotipo()[i][j];
                    geno2[j][i]=padre.getGenotipo()[i][j];
                }
            else
                for(int j=0;j<madre.getGenotipo()[i].length;j++){
                    geno1[j][i]=padre.getGenotipo()[i][j];
                    geno2[j][i]=madre.getGenotipo()[i][j];
                }
        }
        hijo= new Individuo(geno1, padre.getCanalColor());
        hija= new Individuo(geno2, madre.getCanalColor());
        return (hijo.getFitness()<hija.getFitness())? hijo : hija; //Preguntar Tambien
    }
}
