/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Conexiones;

import GUI.Maestro;
import Genetico.Configuracion;
import Genetico.GeneticoDistribuidoImagenes;
import Genetico.Individuo;
import HerramientasGenetico.Cruza;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

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
public class RecibirMaestro extends Thread {
    
    private GeneticoDistribuidoImagenes genetico;
    private ServerSocket servidor;
    private Socket cliente;
    private int port;
    private Configuracion c;
    private Maestro master;

    public RecibirMaestro(int port, Configuracion c, Maestro master) {
        this.port=port;
        this.master=master;
        this.c=c;
    }
    
    @Override
    public void run() {
        try {
            servidor= new ServerSocket(this.port);
        } catch (IOException ex) {
            JOptionPane.showMessageDialog(null, "Fallo de conexion");
        }
        while(true){
            try {
                cliente = servidor.accept();
                ObjectInputStream ois= new ObjectInputStream(cliente.getInputStream());
                Individuo i = (Individuo)ois.readObject();
                ois.close();
                cliente.close();
                //
                    switch(i.getCanalColor()){
                        case ROJO:
                            this.genetico.getPoblacion().addIndividuo(Cruza.cruzaAleatoria(c.getMascaraPixeles(),c.getMascaraColumnas(), this.c.getMascaraFilas(), i, this.genetico.getDefinitivo()));
                            this.genetico.getPoblacion().addIndividuo(i);
                            break;
                        case VERDE:
                            this.master.setVerde(i);
                            break;
                        case AZUL:
                            this.master.setAzul(i);
                            break;
                        default:
                            break;
                    }
                //
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Fallo de conexion");
            } catch (ClassNotFoundException ex) {
                JOptionPane.showMessageDialog(null, "Fallo de conexion");
            }
        }
    }
    
    
}
