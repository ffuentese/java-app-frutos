/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controller.DatosProdControlador;
import Controller.VentanaPrincipalControlador;
import DAO.ParametroDAO;
import DTO.InactivityListener;
import DTO.Parametro;
import DTO.Productor;
import DTO.Usuario;
import DTO.UsuarioLogin;
import java.awt.event.ActionEvent;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

/**
 *
 * @author Windows 7
 */
public class Ventana_Principal_Productor extends javax.swing.JFrame {

    Usuario usuario = new Usuario();
    UsuarioLogin ulog = new UsuarioLogin();
    VentanaPrincipalControlador vpc = new VentanaPrincipalControlador();
    InactivityListener listener;
    DatosProdControlador dpc = new DatosProdControlador();
    ParametroDAO pardao = new ParametroDAO();
    Parametro timeout = pardao.getParametro(2);

    /**
     * Creates new form Ventana_Principal_Productor
     * @param usu Datos del usuario
     * @param log Datos de la sesión
     */
    public Ventana_Principal_Productor(Usuario usu, UsuarioLogin log) {
        usuario = usu;
        ulog = log;
        initComponents();
        Productor p = dpc.getProductor(usu.getRut());
        this.setTitle("Menú");
        lblUsuario.setText("Bienvenido " + p.getNombre() + " " + p.getApellido());
        listener = new InactivityListener(this, logout, Integer.parseInt(timeout.getValor1()));
        listener.start();

    }

    Action logout = new AbstractAction() {

        @Override
        public void actionPerformed(ActionEvent ae) {
            JFrame frame = (JFrame) ae.getSource();
            vpc.borrarLogin(ulog);
            System.exit(0);

        }
    };

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        lblUsuario = new javax.swing.JLabel();
        btnVolver = new javax.swing.JButton();
        btnDatos = new javax.swing.JButton();
        btnMantenedorProductos = new javax.swing.JButton();
        btnHistorial = new javax.swing.JButton();
        btnCerrar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("Feria Web Menú");

        btnVolver.setText("Salir");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnDatos.setText("Actualizar datos");
        btnDatos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDatosActionPerformed(evt);
            }
        });

        btnMantenedorProductos.setText("Administrar productos");
        btnMantenedorProductos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMantenedorProductosActionPerformed(evt);
            }
        });

        btnHistorial.setText("Ver historial de ventas");
        btnHistorial.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnHistorialActionPerformed(evt);
            }
        });

        btnCerrar.setText("Cerrar Sesión");
        btnCerrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCerrarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(42, 42, 42)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblUsuario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addGap(0, 199, Short.MAX_VALUE)))
                .addContainerGap())
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(101, 101, 101))
            .addGroup(layout.createSequentialGroup()
                .addGap(104, 104, 104)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnDatos, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnMantenedorProductos, javax.swing.GroupLayout.DEFAULT_SIZE, 146, Short.MAX_VALUE)
                    .addComponent(btnHistorial, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCerrar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(28, 28, 28)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 19, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnDatos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnMantenedorProductos)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnHistorial)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnCerrar)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 20, Short.MAX_VALUE)
                .addComponent(btnVolver)
                .addGap(42, 42, 42))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // Cierra la ventana para volver al inicio de sesión:
        vpc.borrarLogin(ulog);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnDatosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDatosActionPerformed
        // TODO add your handling code here:
        DatosProductor dp = new DatosProductor(usuario, ulog);
        dp.setVisible(true);
        dp.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnDatosActionPerformed

    private void btnMantenedorProductosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMantenedorProductosActionPerformed
        // TODO add your handling code here:
        ManProductosProductor mpp = new ManProductosProductor(usuario, ulog);
        mpp.setVisible(true);
        mpp.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMantenedorProductosActionPerformed

    private void btnHistorialActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnHistorialActionPerformed
        // TODO add your handling code here:
        HistorialVentasProd hv = new HistorialVentasProd(usuario, ulog);
        hv.setVisible(true);
        hv.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnHistorialActionPerformed

    private void btnCerrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCerrarActionPerformed
        // TODO add your handling code here:
        Login login = new Login();
        login.setVisible(true);
        login.setLocationRelativeTo(null);
        vpc.borrarLogin(ulog);
        this.dispose();
    }//GEN-LAST:event_btnCerrarActionPerformed

    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCerrar;
    private javax.swing.JButton btnDatos;
    private javax.swing.JButton btnHistorial;
    private javax.swing.JButton btnMantenedorProductos;
    private javax.swing.JButton btnVolver;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel lblUsuario;
    // End of variables declaration//GEN-END:variables
}
