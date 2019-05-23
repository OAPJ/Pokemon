/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package HerramientasImagenes;

import io.ImageManager;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;

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
public class Almacenamiento {
    public static void guardadIndividuo(Image imagen, String nombre){
        try {
            String formato= "png";
            File linea = new File(nombre+".png");
            ImageIO.write(ImageManager.toBufferedImage(imagen), formato, linea);
        } catch (IOException ex) {
            Logger.getLogger(Almacenamiento.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
}
