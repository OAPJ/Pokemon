/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package geneticodistribuido;

import HerramientasImagenes.JFrameImagen;
import HerramientasImagenes.Conversion;
import HerramientasImagenes.Conversion.CanalColor;
import com.sun.org.apache.bcel.internal.classfile.Code;
import io.ImageManager;
import java.awt.Image;
import java.awt.image.BufferedImage;
import sun.awt.image.BufImgSurfaceData;

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
public class GeneticoDistribuido {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        /*Image im =ImageManager.openImage();
        new JFrameImagen(im.getScaledInstance(200, 200, BufferedImage.TYPE_INT_RGB));
        Conversion.imagenAMatriz(im);
        Configuracion con = new Configuracion(800000, 50, 1, new TipoSeleccion[]{TipoSeleccion.TORNEO,TipoSeleccion.RULETA}, Cruza.TipoCruza.CRUZA_PIXEL, CanalColor.ROJO);
        GeneticoDistribuidoImagenes gDI= new GeneticoDistribuidoImagenes(con);
        gDI.run();
        Image i= Conversion.matrizAImagenParcial(gDI.getDefinitivo().getGenotipo(), gDI.getConfiguracion().getCanalColor());
        new JFrameImagen(i.getScaledInstance(200, 200, BufferedImage.TYPE_INT_RGB));
        
        Configuracion conG = new Configuracion(800000, 50, 1, new TipoSeleccion[]{TipoSeleccion.TORNEO,TipoSeleccion.RULETA}, Cruza.TipoCruza.CRUZA_FILA, CanalColor.VERDE);
        GeneticoDistribuidoImagenes gDIG= new GeneticoDistribuidoImagenes(conG);
        gDIG.run();
        Image iG= Conversion.matrizAImagenParcial(gDI.getDefinitivo().getGenotipo(), gDIG.getConfiguracion().getCanalColor());
        new JFrameImagen(iG.getScaledInstance(200, 200, BufferedImage.TYPE_INT_RGB));
        //1101390
        Configuracion conB = new Configuracion(800000, 50, 1, new TipoSeleccion[]{TipoSeleccion.TORNEO,TipoSeleccion.RANDOM}, Cruza.TipoCruza.CRUZA_FILA, CanalColor.AZUL);
        GeneticoDistribuidoImagenes gDIB= new GeneticoDistribuidoImagenes(conB);
        gDIB.run();
        Image iB= Conversion.matrizAImagenParcial(gDI.getDefinitivo().getGenotipo(), gDIB.getConfiguracion().getCanalColor());
        new JFrameImagen(iB.getScaledInstance(200, 200, BufferedImage.TYPE_INT_RGB));
        
        Image iT= Conversion.matrizAImagenCompleta(gDI.getDefinitivo().getGenotipo(), gDIG.getDefinitivo().getGenotipo(),gDIB.getDefinitivo().getGenotipo());
        new JFrameImagen(iT.getScaledInstance(200, 200, BufferedImage.TYPE_INT_RGB));
    */
    }
    
}
