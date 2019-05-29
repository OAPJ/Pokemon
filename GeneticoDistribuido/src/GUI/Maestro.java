/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package GUI;

import Conexiones.Enviar;
import Conexiones.RecibirMaestro;
import Genetico.Configuracion;
import Genetico.GeneticoDistribuidoImagenes;
import Genetico.Individuo;
import HerramientasGenetico.Cruza;
import HerramientasGenetico.Seleccion;
import HerramientasImagenes.Almacenamiento;
import HerramientasImagenes.Conversion;
import HerramientasImagenes.Conversion.CanalColor;
import io.ImageManager;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.IOException;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.text.DefaultCaret;

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
public class Maestro extends javax.swing.JFrame implements Runnable {

    private RecibirMaestro recibirMaestro;
    private Configuracion configuracion;
    private GeneticoDistribuidoImagenes genetico;
    private Image imagen;
    private Icon start;
    private CanalColor canalColor;
    private Individuo verde;
    private Individuo azul;

    /**
     * Creates new form Maestro
     * @param porto
     * @param img
     */
    public Maestro(int porto, Image img) {
        setUndecorated(true);
        initComponents();
        this.setLocationRelativeTo(null);
        this.historial.setEditable(false);
        this.imagen = img;
        this.canalColor = CanalColor.ROJO;
        this.azul = null;
        this.verde = null;
        this.jLabel8.setText(porto + "");
        this.dispAzul.setText("No disponible");
        this.dispVerde.setText("No disponible");
        this.genetico = null;
        DefaultCaret caret = (DefaultCaret)historial.getCaret();
        caret.setUpdatePolicy(DefaultCaret.OUT_BOTTOM);
        
        Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagen/Fondo.png"));
        Icon fond = new ImageIcon(icon.getScaledInstance(fondo.getWidth(), fondo.getHeight(), Image.SCALE_DEFAULT));
        fondo.setIcon(fond);
        
        icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagen/barra.png"));
        Icon ba = new ImageIcon(icon.getScaledInstance(barra.getWidth(), barra.getHeight(), Image.SCALE_DEFAULT));
        mover mml = new mover(barra);
        barra.addMouseListener(mml);
        barra.addMouseMotionListener(mml);
        barra.setIcon(ba);
        barra.setOpaque(true);
        barra.setSize(780, 20);
        
        icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagen/close.png"));
        Icon clos = new ImageIcon(icon.getScaledInstance(this.close.getWidth(), this.close.getHeight(), Image.SCALE_DEFAULT));
        close.setIcon(clos);
        
        icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagen/play2.jpg"));
        start = new ImageIcon(icon.getScaledInstance(jButton1.getWidth(), jButton1.getHeight(), Image.SCALE_DEFAULT));
        jButton1.setIcon(start);
        
        icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagen/cargar2.png"));
        Icon cargar = new ImageIcon(icon.getScaledInstance(jButton5.getWidth(), jButton5.getHeight(), Image.SCALE_DEFAULT));
        jButton5.setIcon(cargar);
        
        icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagen/enviar2.jpg"));
        Icon enviar = new ImageIcon(icon.getScaledInstance(jButton2.getWidth(), jButton2.getHeight(), Image.SCALE_DEFAULT));
        jButton2.setIcon(enviar);
        
        icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagen/guardar2.png"));
        Icon guardar = new ImageIcon(icon.getScaledInstance(jButton9.getWidth(), jButton9.getHeight(), Image.SCALE_DEFAULT));
        jButton9.setIcon(guardar);
        
        icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagen/save2.png"));
        Icon save = new ImageIcon(icon.getScaledInstance(jButton4.getWidth(), jButton4.getHeight(), Image.SCALE_DEFAULT));
        jButton4.setIcon(save);
        
        icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagen/construir2.png"));
        Icon construir = new ImageIcon(icon.getScaledInstance(jButton10.getWidth(), jButton10.getHeight(), Image.SCALE_DEFAULT));
        jButton10.setIcon(construir);
    }

    public void setDispAzul(JLabel dispAzul) {
        this.dispAzul = dispAzul;
    }

    public void setDispVerde(JLabel dispVerde) {
        this.dispVerde = dispVerde;
    }

    public Individuo getVerde() {
        return verde;
    }

    public void setVerde(Individuo verde) {
        this.dispVerde.setText("disponible");
        this.verde = verde;
    }

    public Individuo getAzul() {
        return azul;
    }

    public void setAzul(Individuo azul) {
        this.dispAzul.setText("disponible");
        this.azul = azul;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        generaciones = new javax.swing.JTextField();
        sizeP = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel11 = new javax.swing.JLabel();
        jLabel12 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        dispVerde = new javax.swing.JLabel();
        dispAzul = new javax.swing.JLabel();
        mejorG = new javax.swing.JLabel();
        resultado = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        muta = new javax.swing.JTextField();
        cruza = new javax.swing.JComboBox<>();
        seleccionPadre = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        historial = new javax.swing.JTextArea();
        ip = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jButton4 = new javax.swing.JButton();
        nombreImagenJunta = new javax.swing.JTextField();
        jButton5 = new javax.swing.JButton();
        jButton6 = new javax.swing.JButton();
        jButton7 = new javax.swing.JButton();
        jButton8 = new javax.swing.JButton();
        nombre = new javax.swing.JTextField();
        jButton9 = new javax.swing.JButton();
        seleccionMadre = new javax.swing.JComboBox<>();
        port = new javax.swing.JTextField();
        jButton10 = new javax.swing.JButton();
        close = new javax.swing.JButton();
        individuoInicial = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        fondo = new javax.swing.JLabel();
        barra = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        generaciones.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                generacionesActionPerformed(evt);
            }
        });
        getContentPane().add(generaciones, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 250, 111, -1));
        getContentPane().add(sizeP, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 280, 111, -1));

        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("Numero de Generaciones");
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 250, -1, 30));

        jLabel2.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("Rojo");
        getContentPane().add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(108, 0, -1, -1));

        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Numero de Indivduos");
        getContentPane().add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 280, -1, 30));

        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Probabilidad de muta");
        getContentPane().add(jLabel4, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 310, -1, 30));

        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Tipo de Cruza");
        getContentPane().add(jLabel5, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 340, -1, 30));

        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Puerto:");
        getContentPane().add(jLabel7, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 330, -1, 30));

        jLabel6.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Tipo de Seleccion");
        getContentPane().add(jLabel6, new org.netbeans.lib.awtextra.AbsoluteConstraints(140, 370, -1, 50));

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setForeground(new java.awt.Color(255, 255, 255));
        jLabel8.setText("Port");
        getContentPane().add(jLabel8, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 0, -1, -1));

        jLabel9.setForeground(new java.awt.Color(255, 255, 255));
        jLabel9.setText("IP:");
        getContentPane().add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 330, -1, 30));

        jLabel10.setForeground(new java.awt.Color(0, 255, 0));
        jLabel10.setText("Verde:");
        getContentPane().add(jLabel10, new org.netbeans.lib.awtextra.AbsoluteConstraints(310, 250, -1, -1));

        jLabel11.setForeground(new java.awt.Color(0, 170, 255));
        jLabel11.setText("Azul:");
        getContentPane().add(jLabel11, new org.netbeans.lib.awtextra.AbsoluteConstraints(450, 250, -1, -1));

        jLabel12.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel12.setForeground(new java.awt.Color(255, 255, 255));
        jLabel12.setText("Puerto:");
        getContentPane().add(jLabel12, new org.netbeans.lib.awtextra.AbsoluteConstraints(178, 0, -1, -1));

        jLabel15.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel15.setForeground(new java.awt.Color(255, 255, 255));
        jLabel15.setText("Resultado:");
        getContentPane().add(jLabel15, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 240, -1, -1));

        jLabel16.setForeground(new java.awt.Color(255, 255, 255));
        jLabel16.setText("Cambiar mascara");
        getContentPane().add(jLabel16, new org.netbeans.lib.awtextra.AbsoluteConstraints(300, 280, -1, 30));

        dispVerde.setForeground(new java.awt.Color(0, 255, 0));
        dispVerde.setText("disponibilidad");
        getContentPane().add(dispVerde, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 250, -1, -1));

        dispAzul.setForeground(new java.awt.Color(0, 170, 255));
        dispAzul.setText("disponibilidad");
        getContentPane().add(dispAzul, new org.netbeans.lib.awtextra.AbsoluteConstraints(480, 250, -1, -1));
        getContentPane().add(mejorG, new org.netbeans.lib.awtextra.AbsoluteConstraints(220, 30, 200, 200));
        getContentPane().add(resultado, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 30, 200, 200));

        jButton1.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 440, 80, 80));
        getContentPane().add(muta, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 310, 111, -1));

        cruza.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Pixel", "Fila", "Columna" }));
        getContentPane().add(cruza, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 340, 110, -1));

        seleccionPadre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Torneo", "Aleatorio", "Ruleta" }));
        getContentPane().add(seleccionPadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 370, 110, -1));

        historial.setEditable(false);
        historial.setBackground(new java.awt.Color(0, 0, 0));
        historial.setColumns(20);
        historial.setForeground(new java.awt.Color(204, 204, 204));
        historial.setLineWrap(true);
        historial.setRows(5);
        historial.setDragEnabled(true);
        historial.setMinimumSize(new java.awt.Dimension(104, 22));
        historial.setSelectedTextColor(new java.awt.Color(255, 0, 0));
        historial.setSelectionColor(new java.awt.Color(0, 0, 0));
        jScrollPane1.setViewportView(historial);

        getContentPane().add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(430, 30, 224, 200));
        getContentPane().add(ip, new org.netbeans.lib.awtextra.AbsoluteConstraints(320, 330, 113, -1));

        jButton2.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton2, new org.netbeans.lib.awtextra.AbsoluteConstraints(530, 440, 80, 80));

        jButton4.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton4ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton4, new org.netbeans.lib.awtextra.AbsoluteConstraints(780, 320, 80, 80));
        getContentPane().add(nombreImagenJunta, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 270, 200, -1));

        jButton5.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton5ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton5, new org.netbeans.lib.awtextra.AbsoluteConstraints(330, 440, 80, 80));

        jButton6.setBackground(new java.awt.Color(0, 0, 255));
        jButton6.setForeground(new java.awt.Color(255, 255, 255));
        jButton6.setText("Fila");
        jButton6.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton6ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton6, new org.netbeans.lib.awtextra.AbsoluteConstraints(560, 280, 55, -1));

        jButton7.setBackground(new java.awt.Color(0, 255, 0));
        jButton7.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        jButton7.setText("Columna");
        jButton7.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton7ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton7, new org.netbeans.lib.awtextra.AbsoluteConstraints(470, 280, -1, -1));

        jButton8.setBackground(new java.awt.Color(255, 0, 0));
        jButton8.setForeground(new java.awt.Color(255, 255, 255));
        jButton8.setText("Pixel");
        jButton8.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton8ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton8, new org.netbeans.lib.awtextra.AbsoluteConstraints(410, 280, -1, -1));
        getContentPane().add(nombre, new org.netbeans.lib.awtextra.AbsoluteConstraints(390, 400, 216, -1));

        jButton9.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton9ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton9, new org.netbeans.lib.awtextra.AbsoluteConstraints(710, 440, 80, 80));

        seleccionMadre.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Torneo", "Aleatorio", "Ruleta" }));
        getContentPane().add(seleccionMadre, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 400, 110, -1));
        getContentPane().add(port, new org.netbeans.lib.awtextra.AbsoluteConstraints(490, 330, 112, -1));

        jButton10.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        jButton10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton10ActionPerformed(evt);
            }
        });
        getContentPane().add(jButton10, new org.netbeans.lib.awtextra.AbsoluteConstraints(670, 320, 80, 80));

        close.setContentAreaFilled(false);
        close.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        close.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                closeActionPerformed(evt);
            }
        });
        getContentPane().add(close, new org.netbeans.lib.awtextra.AbsoluteConstraints(860, 0, 30, 30));
        getContentPane().add(individuoInicial, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 30, 200, 200));

        jLabel13.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel13.setForeground(new java.awt.Color(255, 255, 255));
        jLabel13.setText("Individuo:");
        getContentPane().add(jLabel13, new org.netbeans.lib.awtextra.AbsoluteConstraints(313, 400, 70, 30));
        getContentPane().add(fondo, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 0, 900, 540));

        barra.setBackground(new java.awt.Color(255, 255, 255));
        barra.setForeground(new java.awt.Color(255, 255, 255));
        getContentPane().add(barra, new org.netbeans.lib.awtextra.AbsoluteConstraints(0, 0, 900, 30));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void generacionesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_generacionesActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_generacionesActionPerformed

    private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
        if (!this.nombreImagenJunta.getText().isEmpty() && verde!=null && azul!=null) {
            int imate[][] = this.genetico.getDefinitivo().getGenotipo();
            Almacenamiento.guardadIndividuo(Conversion.matrizAImagenCompleta(imate, verde.getGenotipo(), this.azul.getGenotipo()), this.nombreImagenJunta.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Escriba un nombre");
        }
    }//GEN-LAST:event_jButton4ActionPerformed

    private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
        if (!this.nombre.getText().isEmpty()) {
            int imate[][] = this.genetico.getDefinitivo().getGenotipo();
            Almacenamiento.guardadIndividuo(Conversion.matrizAImagenCompleta(imate, imate, imate), this.nombre.getText());
        } else {
            JOptionPane.showMessageDialog(null, "Escriba un nombre");
        }
    }//GEN-LAST:event_jButton9ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        if (this.imagen != null) {
            if(this.jButton1.getIcon().equals(start)){//Si aun no esta en ejecucion el genetico
                try {
                    long gen = Integer.parseInt(this.generaciones.getText());
                    int indi = Integer.parseInt(this.sizeP.getText());
                    double muta = Double.parseDouble(this.muta.getText());
                    Image icon = Toolkit.getDefaultToolkit().getImage(ClassLoader.getSystemResource("Imagen/editar.jpg"));
                    Icon mod = new ImageIcon(icon.getScaledInstance(jButton1.getWidth(), jButton1.getHeight(), Image.SCALE_DEFAULT));
                    jButton1.setIcon(mod);
                    Cruza.TipoCruza tp;
                    switch (this.cruza.getSelectedIndex()) {
                        case 0:
                            tp = Cruza.TipoCruza.CRUZA_PIXEL;
                            break;
                        case 1:
                            tp = Cruza.TipoCruza.CRUZA_FILA;
                            break;
                        case 2:
                            tp = Cruza.TipoCruza.CRUZA_COLUMNA;
                            break;
                        case 3:
                            tp = Cruza.TipoCruza.CRUZA_ALEATORIA;
                            break;
                        default:
                            tp = Cruza.TipoCruza.CRUZA_ALEATORIA;
                            break;
                    }
                    Seleccion.TipoSeleccion[] tipoS = new Seleccion.TipoSeleccion[2];
                    switch (this.seleccionPadre.getSelectedIndex()) {
                        case 0:
                            tipoS[0] = Seleccion.TipoSeleccion.TORNEO;
                            break;
                        case 1:
                            tipoS[0] = Seleccion.TipoSeleccion.RANDOM;
                            break;
                        case 2:
                            tipoS[0] = Seleccion.TipoSeleccion.RULETA;
                            break;
                        default:
                            break;
                    }

                    switch (this.seleccionMadre.getSelectedIndex()) {
                        case 0:
                            tipoS[1] = Seleccion.TipoSeleccion.TORNEO;
                            break;
                        case 1:
                            tipoS[1] = Seleccion.TipoSeleccion.RANDOM;
                            break;
                        case 2:
                            tipoS[1] = Seleccion.TipoSeleccion.RULETA;
                            break;
                        default:
                            break;
                    }
                    this.configuracion = new Configuracion(gen, indi, muta, tipoS, tp, this.canalColor);
                    this.genetico = new GeneticoDistribuidoImagenes(configuracion, this.historial, this.mejorG);
                    this.individuoInicial.setIcon(new ImageIcon(Conversion.matrizAImagenParcial(this.genetico.getPoblacion().getMejor().getGenotipo(), this.configuracion.getCanalColor()).getScaledInstance(200, 200, BufferedImage.TYPE_INT_RGB)));
                    this.genetico.start();
                    try {
                        //Aqui va el de recibir individuos
                        this.recibirMaestro= new RecibirMaestro(Integer.parseInt(this.jLabel8.getText()),this.configuracion, this);
                        this.recibirMaestro.start();
//                        this.recibirIguales= new RecibirIguales(this.genetico,Integer.parseInt(this.jLabel8.getText()));
//                        this.recibirIguales.start();
                    } catch (Exception e) {
                        JOptionPane.showMessageDialog(null, "Introduzca el puerto de manera adecuada");
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduzca los datos de manera adecuada");
                }
            } else {
                try {
                    int gen = Integer.parseInt(this.generaciones.getText());
                    int indi = Integer.parseInt(this.sizeP.getText());
                    double muta = Double.parseDouble(this.muta.getText());
                    Cruza.TipoCruza tp = Cruza.TipoCruza.CRUZA_PIXEL;
                    switch (this.cruza.getSelectedIndex()) {
                        case 0:
                            tp = Cruza.TipoCruza.CRUZA_PIXEL;
                            break;
                        case 1:
                            tp = Cruza.TipoCruza.CRUZA_FILA;
                            break;
                        case 2:
                            tp = Cruza.TipoCruza.CRUZA_COLUMNA;
                            break;
                        case 3:
                            tp = Cruza.TipoCruza.CRUZA_ALEATORIA;
                            break;
                        default:
                            break;
                    }
                    Seleccion.TipoSeleccion[] tipoS = new Seleccion.TipoSeleccion[2];
                    switch (this.seleccionPadre.getSelectedIndex()) {
                        case 0:
                            tipoS[0] = Seleccion.TipoSeleccion.TORNEO;
                            break;
                        case 1:
                            tipoS[0] = Seleccion.TipoSeleccion.RANDOM;
                            break;
                        case 2:
                            tipoS[0] = Seleccion.TipoSeleccion.RULETA;
                            break;
                        default:
                            break;
                    }

                    switch (this.seleccionMadre.getSelectedIndex()) {
                        case 0:
                            tipoS[1] = Seleccion.TipoSeleccion.TORNEO;
                            break;
                        case 1:
                            tipoS[1] = Seleccion.TipoSeleccion.RANDOM;
                            break;
                        case 2:
                            tipoS[1] = Seleccion.TipoSeleccion.RULETA;
                            break;
                        default:
                            break;
                    }
                    //Aqui se modifican todos los parametros
                    this.configuracion.setNumGeneraciones(gen);
                    this.configuracion.setTamPoblaciobn(indi);
                    this.configuracion.setProbabilidadMuta(muta);
                    this.configuracion.setTipoCruza(tp);
                    this.configuracion.setTipoSeleccion(tipoS);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Introduzca los datos de manera adecuada");
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Abra una imagen primero");
        }
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
        if (this.imagen != null && (this.genetico != null)) {
            Image individuo = ImageManager.openImage();
            try {
                Individuo cargado = new Individuo(Conversion.imagenAGenotipo(individuo, this.canalColor), this.canalColor);
                System.out.println(cargado.getFitness());
                this.genetico.getPoblacion().addIndividuo(cargado);
            } catch (Exception e) {

            }
        } else {
            JOptionPane.showMessageDialog(null, "Abra una imagen primero");
        }
    }//GEN-LAST:event_jButton5ActionPerformed

    private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
        if (this.genetico != null) {
            this.configuracion.changeMascaraPixeles();
        }
    }//GEN-LAST:event_jButton8ActionPerformed

    private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
        if (this.genetico != null) {
            this.configuracion.changeMascaraColumnas();
        }
    }//GEN-LAST:event_jButton7ActionPerformed

    private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
        if (this.genetico != null) {
            this.configuracion.changeMascaraFilas();
        }
    }//GEN-LAST:event_jButton6ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        if (this.genetico != null) {
            try {
                Enviar.enviarIndididuo(this.ip.getText(), Integer.parseInt(this.port.getText()), this.genetico.getDefinitivo());
            } catch (IOException ex) {
                JOptionPane.showMessageDialog(null, "Inicie el genetico");
            }catch(NumberFormatException e){
                
            }
        }
    }//GEN-LAST:event_jButton2ActionPerformed

    private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
        if(this.genetico!=null && this.verde!=null && this.azul!=null){
            new Thread(this).start();
        }
    }//GEN-LAST:event_jButton10ActionPerformed

    private void closeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_closeActionPerformed
        //CLOSE
        System.exit(0);
    }//GEN-LAST:event_closeActionPerformed

    @Override
    public void run(){
        while(true){
            this.resultado.setIcon(new  ImageIcon(Conversion.matrizAImagenCompleta(this.genetico.getDefinitivo().getGenotipo(), this.verde.getGenotipo(),this.azul.getGenotipo()).getScaledInstance(200, 200, BufferedImage.TYPE_INT_RGB)));
        }
    }
    
    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(Maestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Maestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Maestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Maestro.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Maestro(1890, null).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel barra;
    private javax.swing.JButton close;
    private javax.swing.JComboBox<String> cruza;
    private javax.swing.JLabel dispAzul;
    private javax.swing.JLabel dispVerde;
    private javax.swing.JLabel fondo;
    private javax.swing.JTextField generaciones;
    private javax.swing.JTextArea historial;
    private javax.swing.JLabel individuoInicial;
    private javax.swing.JTextField ip;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton10;
    private javax.swing.JButton jButton2;
    private javax.swing.JButton jButton4;
    private javax.swing.JButton jButton5;
    private javax.swing.JButton jButton6;
    private javax.swing.JButton jButton7;
    private javax.swing.JButton jButton8;
    private javax.swing.JButton jButton9;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel mejorG;
    private javax.swing.JTextField muta;
    private javax.swing.JTextField nombre;
    private javax.swing.JTextField nombreImagenJunta;
    private javax.swing.JTextField port;
    private javax.swing.JLabel resultado;
    private javax.swing.JComboBox<String> seleccionMadre;
    private javax.swing.JComboBox<String> seleccionPadre;
    private javax.swing.JTextField sizeP;
    // End of variables declaration//GEN-END:variables
}
