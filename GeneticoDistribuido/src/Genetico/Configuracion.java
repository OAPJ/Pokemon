/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetico;

import HerramientasGenetico.Cruza;
import HerramientasGenetico.Cruza.TipoCruza;
import HerramientasGenetico.Seleccion;
import HerramientasGenetico.Seleccion.TipoSeleccion;
import HerramientasImagenes.Conversion.CanalColor;

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
public class Configuracion {
    private long numGeneraciones;
    private int tamPoblaciobn;
    private double probabilidadMuta;
    private boolean[] mascaraFilas;
    private boolean[] mascaraColumnas;
    private boolean[][] mascaraPixeles;
    private TipoSeleccion tipoSeleccion[];
    private TipoCruza tipoCruza;
    private final CanalColor canalColor;

    public CanalColor getCanalColor() {
        return canalColor;
    }
    public Configuracion(long generaciones, int tamPoblacion, double probMuta, Seleccion.TipoSeleccion tipoSeleccion[], Cruza.TipoCruza tipoCruza, CanalColor cc){
        this.numGeneraciones=generaciones;
        this.tamPoblaciobn= tamPoblacion;
        this.probabilidadMuta=probMuta;
        this.tipoSeleccion= tipoSeleccion;
        this.tipoCruza=tipoCruza;
        this.mascaraFilas= Cruza.generarMascaraFilaXFila();
        this.mascaraColumnas= Cruza.generarMascaraColumnaXColumna();
        this.mascaraPixeles= Cruza.generarMascaraPixelXPixel();
        this.canalColor=cc;
    }
    
    public Configuracion(CanalColor cc){
        this.canalColor=cc;
        this.numGeneraciones=10000;
        this.tamPoblaciobn= 50;
        this.probabilidadMuta= 0.6;
        this.tipoSeleccion= new TipoSeleccion[]{TipoSeleccion.TORNEO,TipoSeleccion.RANDOM};
        this.tipoCruza= TipoCruza.CRUZA_ALEATORIA;
        this.mascaraFilas= Cruza.generarMascaraFilaXFila();
        this.mascaraColumnas= Cruza.generarMascaraColumnaXColumna();
        this.mascaraPixeles= Cruza.generarMascaraPixelXPixel();
    }
    
    public Individuo aplicarSeleccion(Poblacion poblacionActu, int i){
       Individuo aux = null; 
       // evaluar i
       switch(getTipoSeleccion()[i]){
           case RANDOM:{
             aux = Seleccion.seleccionAleatoria(poblacionActu);
           break;}
           case TORNEO:{
             aux = Seleccion.seleccionMejor(poblacionActu);
           break;}
           case RULETA:{
               aux= Seleccion.seleccionRuleta(poblacionActu);
               break;
           }
           default: aux = null;
           
       }
   return aux;
   }

    public long getNumGeneraciones() {
        return numGeneraciones;
    }

    public void setNumGeneraciones(long numGeneraciones) {
        this.numGeneraciones = numGeneraciones;
    }

    public int getTamPoblaciobn() {
        return tamPoblaciobn;
    }

    public void setTamPoblaciobn(int tamPoblaciobn) {
        this.tamPoblaciobn = tamPoblaciobn;
    }

    public double getProbabilidadMuta() {
        return probabilidadMuta;
    }

    public void setProbabilidadMuta(double probabilidadMuta) {
        this.probabilidadMuta = probabilidadMuta;
    }

    public boolean[] getMascaraFilas() {
        return mascaraFilas;
    }

    public void changeMascaraFilas() {
        this.mascaraFilas = Cruza.generarMascaraFilaXFila();
    }

    public boolean[] getMascaraColumnas() {
        return mascaraColumnas;
    }

    public void changeMascaraColumnas() {
        this.mascaraColumnas = Cruza.generarMascaraColumnaXColumna();
    }

    public boolean[][] getMascaraPixeles() {
        return mascaraPixeles;
    }

    public void changeMascaraPixeles() {
        this.mascaraPixeles = Cruza.generarMascaraPixelXPixel();
    }

    public TipoSeleccion[] getTipoSeleccion() {
        return tipoSeleccion;
    }

    public void setTipoSeleccion(TipoSeleccion[] tipoSeleccion) {
        this.tipoSeleccion = tipoSeleccion;
    }

    public TipoCruza getTipoCruza() {
        return tipoCruza;
    }

    public void setTipoCruza(TipoCruza tipoCruza) {
        this.tipoCruza = tipoCruza;
    }
        
}
