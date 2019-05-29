/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HerramientasImagenes;

import io.ImageManager;
import java.awt.Color;
import java.awt.Image;
import java.awt.image.BufferedImage;

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
public class Conversion {
    public static int[][] matrixR;
    public static int[][] matrixG;
    public static int[][] matrixB;
    
    public enum CanalColor{ 
        ROJO(2), VERDE(1), AZUL(0);
        int index;
        CanalColor(int index){
            this.index= index;
        }
        int getIndex(){
            return this.index;
        }
    }
    
    
    public static void imagenAMatriz(Image imagen){
        BufferedImage imagenBF = ImageManager.toBufferedImage(imagen);
        matrixR= new int[imagenBF.getWidth()][imagenBF.getHeight()];
        matrixG= new int[imagenBF.getWidth()][imagenBF.getHeight()];
        matrixB= new int[imagenBF.getWidth()][imagenBF.getHeight()];
        for(int x=0;x<imagenBF.getWidth();x++){
            for(int y =0; y < imagenBF.getHeight();y++){
                Color color= new Color(imagenBF.getRGB(x, y));
                matrixR[x][y]= color.getRed();
                matrixG[x][y]= color.getGreen();
                matrixB[x][y]= color.getBlue();
            }
        }
        
    }
    
    public static int[][] imagenAGenotipo(Image imagen, CanalColor cc){
        BufferedImage imagenBF = ImageManager.toBufferedImage(imagen);
        int[][] matrixResultante= new int[imagenBF.getWidth()][imagenBF.getHeight()];
        if(null!= cc)switch (cc) {
            case ROJO:
                for(int x=0;x<imagenBF.getWidth();x++){
                    for(int y =0; y < imagenBF.getHeight();y++){
                        Color color= new Color(imagenBF.getRGB(x, y));
                        matrixResultante[x][y]= color.getRed();
                    }
                }       break;
            case VERDE:
                for(int x=0;x<imagenBF.getWidth();x++){
                    for(int y =0; y < imagenBF.getHeight();y++){
                        Color color= new Color(imagenBF.getRGB(x, y));
                        matrixResultante[x][y]= color.getGreen();
                    }
                }   break;
            case AZUL:
                for(int x=0;x<imagenBF.getWidth();x++){
                    for(int y =0; y < imagenBF.getHeight();y++){
                        Color color= new Color(imagenBF.getRGB(x, y));
                        matrixResultante[x][y]= color.getBlue();
                    }
                }       break;
            default:
                break;
        }
        return matrixResultante;
    }
    
    public static Image matrizAImagenCompleta(int matrizR[][], int matrizG[][],int matrizB[][]){
        BufferedImage imagenBF = new BufferedImage(matrizR[0].length, matrizR.length, BufferedImage.TYPE_INT_RGB);
        for(int x=0;x<imagenBF.getWidth();x++){
            for(int y =0; y < imagenBF.getHeight();y++){
                Color c= new Color(matrizR[x][y],matrizG[x][y],matrizB[x][y]);
                imagenBF.setRGB(x, y,c.getRGB());
            }
        }
        return ImageManager.toImage(imagenBF);
    }
    
    public static Image matrizAImagenParcial(int matriz[][], CanalColor cc){
        BufferedImage imagenBF = new BufferedImage(matriz[0].length, matriz.length, BufferedImage.TYPE_INT_RGB);
        for(int x=0;x<imagenBF.getWidth();x++){
            for(int y =0; y < imagenBF.getHeight();y++){
                Color color;
                switch(cc){
                    case ROJO:
                        color= new Color(matriz[x][y],0,0);
                        break;
                    case AZUL:
                        color= new Color(0,0,matriz[x][y]);
                        break;
                    case VERDE:
                        color= new Color(0,matriz[x][y],0);
                        break;
                    default:
                        color= new Color(0,0,0);
                        break;
                }
                imagenBF.setRGB(x, y,color.getRGB());
            }
        }
        return ImageManager.toImage(imagenBF);
    }
}
