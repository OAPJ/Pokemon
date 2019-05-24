/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Genetico;

import GUI.Secundario;
import HerramientasGenetico.Cruza;
import HerramientasGenetico.Muta;
import HerramientasImagenes.Conversion;
import java.awt.image.BufferedImage;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JTextArea;

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
public class GeneticoDistribuidoImagenes extends Thread{
    private Individuo definitivo;
    private Configuracion configuracion;
    private Poblacion poblacion;
    private String info;
    private JTextArea textArea;
    private JLabel label;
    public GeneticoDistribuidoImagenes(Configuracion configuracion, JTextArea texA, JLabel jl){
        this.configuracion= configuracion;
        this.label=jl;
        this.textArea= texA;
        this.poblacion=new Poblacion(this.configuracion.getCanalColor(), this.configuracion.getTamPoblaciobn());
    }

    
    public void evolucionar() {
        for(long g=0;g<this.configuracion.getNumGeneraciones();g++){
            ArrayList<Individuo> individuos= new ArrayList<>();
            individuos.add(this.poblacion.getMejor());
            for(long j=1;j<this.configuracion.getTamPoblaciobn();j++){
                Individuo madre=this.configuracion.aplicarSeleccion(this.poblacion, 0);
                Individuo padre=this.configuracion.aplicarSeleccion(this.poblacion, 1);
                Individuo hijo;
                switch(configuracion.getTipoCruza()){
                    case CRUZA_PIXEL:
                        hijo= Cruza.cruzaPixelXPixel(this.configuracion.getMascaraPixeles(), madre, padre);
                        break;
                    case CRUZA_COLUMNA:
                        hijo= Cruza.cruzaColumnaXColumna(this.configuracion.getMascaraColumnas(), madre, padre);
                        break;
                    case CRUZA_FILA:
                        hijo= Cruza.cruzaFilaXFila(this.configuracion.getMascaraFilas(), madre, padre);
                        break;
                    default://Cruza aleatoria
                        hijo= Cruza.cruzaAleatoria(this.configuracion.getMascaraPixeles(),this.configuracion.getMascaraColumnas(),this.configuracion.getMascaraFilas(), madre, padre);
                        break;
                }
                Muta.mutar(this.configuracion.getProbabilidadMuta(), hijo);
                individuos.add(hijo);
            }
            this.poblacion=new Poblacion(individuos);
            this.definitivo = this.poblacion.getMejor();
            this.info=g+ "-fitness;"+ this.definitivo.getFitness();
            this.textArea.append(info+"\n");
            //System.out.println(info);
            this.label.setIcon(new  ImageIcon(Conversion.matrizAImagenParcial(this.definitivo.getGenotipo(), this.configuracion.getCanalColor()).getScaledInstance(200, 200, BufferedImage.TYPE_INT_RGB)));
            
        }
        this.definitivo= this.poblacion.getMejor();
    }

    public Individuo getDefinitivo() {
        return definitivo;
    }
    
    public int[][] mejor(){
        return this.poblacion.getMejor().getGenotipo();
    }
    
    public Configuracion getConfiguracion() {
        return configuracion;
    }

    public Poblacion getPoblacion() {
        return poblacion;
    }
    
    @Override
    public void run() {
        evolucionar();
    }
    
}
