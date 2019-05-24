/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import Genetico.GeneticoDistribuidoImagenes;
import Genetico.Individuo;
import java.io.IOException;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;

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
public class RecibirIguales extends Thread {
    private GeneticoDistribuidoImagenes genetico;
    private ServerSocket servidor;
    private Socket cliente;
    private int port;
    
    public RecibirIguales(GeneticoDistribuidoImagenes gen, int port){
        this.port=port;
        this.genetico=gen;
    }
    
    @Override
    public void run(){
        try {
            servidor= new ServerSocket(this.port);
        } catch (IOException ex) {
            Logger.getLogger(RecibirIguales.class.getName()).log(Level.SEVERE, null, ex);
        }
        while(true){
            try {
                cliente = servidor.accept();
                ObjectInputStream ois= new ObjectInputStream(cliente.getInputStream());
                Individuo i = (Individuo)ois.readObject();
                ois.close();
                cliente.close();
                this.genetico.getPoblacion().addIndividuo(i);
            } catch (IOException ex) {
                Logger.getLogger(RecibirIguales.class.getName()).log(Level.SEVERE, null, ex);
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(RecibirIguales.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }
}
