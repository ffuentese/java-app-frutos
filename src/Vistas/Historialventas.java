/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controller.HistorialVentasControlador;
import Controller.ProductorControlador;
import DTO.Productor;
import java.awt.print.PrinterException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.table.DefaultTableModel;
import DTO.Historial_ventas;
import java.text.MessageFormat;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JTable;


/**
 *
 * @author Windows 7
 */
public class Historialventas extends javax.swing.JFrame {

    ProductorControlador prc = new ProductorControlador();
    HistorialVentasControlador hvc = new HistorialVentasControlador();
    //DefaultComboBoxModel modelListaProductores = new DefaultComboBoxModel(prc.listaProductores().toArray());
    /**DefaultComboBoxModel modelListaProductores = new DefaultComboBoxModel(prc.listaProductores().toArray());
     * Creates new form Historial_ventas
     */
    public Historialventas() {
        initComponents();
        
      ArrayList<Productor> arrpro = prc.listaProductores();
      for(int i =0;i<arrpro.size();i++){
          cmbListarproductores.addItem(arrpro.get(i));
      }
      
        
        tbVentas.setAutoCreateRowSorter(true);
        tbVentas.getTableHeader().setReorderingAllowed(false);
    }   

//    Nombre del producto
//Tipo (Es el tipo de producto)
//Tipo de unidad
//Precio (Es el precio por unidad)
//Cantidad (Es la cantidad comprada)
//Precio Final
//N° de venta
//Cliente

    String col[] = {"Nombre Producto", "Tipo de Producto", "Tipo de Unidad", "Precio Unitario", "Cantidad", "Total", "Nº Venta", "Cliente"};
    DefaultTableModel tablemodel = new DefaultTableModel(col, 0);
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        cmbListarproductores = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbVentas = new javax.swing.JTable();
        btnVolver = new javax.swing.JButton();
        btnImprimir = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cmbListarproductores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));
        cmbListarproductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListarproductoresActionPerformed(evt);
            }
        });

        jLabel2.setText("PRODUCTORES");

        tbVentas.setModel(tablemodel);
        jScrollPane1.setViewportView(tbVentas);

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        btnImprimir.setText("Imprimir");
        btnImprimir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImprimirActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(244, 244, 244)
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(cmbListarproductores, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(204, 204, 204)
                        .addComponent(btnImprimir, javax.swing.GroupLayout.PREFERRED_SIZE, 140, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(61, 61, 61)
                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(252, Short.MAX_VALUE))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 782, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbListarproductores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 418, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnImprimir)
                    .addComponent(btnVolver))
                .addGap(30, 30, 30))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                    .addGap(53, 53, 53)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(81, Short.MAX_VALUE)))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void cmbListarproductoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListarproductoresActionPerformed
        // TODO add your handling code here:
        Productor pro = ((Productor)cmbListarproductores.getSelectedItem());
        this.fillTable(pro.getRut());
       
    }//GEN-LAST:event_cmbListarproductoresActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // Cierra la ventana y vuelve al menú:
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnImprimirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImprimirActionPerformed
       try {
            // Imprime la tabla:
            MessageFormat header = new MessageFormat("Ventas");
            MessageFormat footer = new MessageFormat("Page {0,number,integer}");
            tbVentas.print(JTable.PrintMode.FIT_WIDTH, header, footer);
        } catch (PrinterException ex) {
            Logger.getLogger(ManProductosProductor.class.getName()).log(Level.SEVERE, null, ex);
        }
    
    }//GEN-LAST:event_btnImprimirActionPerformed

    private void fillTable(String rut) {
        // Llena la tabla. Por ahora el contenido no incluye los nombres, sólo IDs.
        if (hvc.listaVentas(rut).size() > 0) {
            for (int i = 0; i < hvc.listaVentas(rut).size(); i++) {
                Historial_ventas vent = hvc.listaVentas(rut).get(i);
                String[] linea = {vent.getNombre_producto(),
                    vent.getTipo_producto(),
                    vent.getTipo_unidad(),
                    vent.getPrecio_unitario(),
                    vent.getCantidad(),
                    vent.getPrecio_final(),
                    vent.getNum_venta(),
                    vent.getNombre_cliente()
                };
                tablemodel.addRow(linea);
            }
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
            java.util.logging.Logger.getLogger(Historialventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Historialventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Historialventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Historialventas.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Historialventas().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnImprimir;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox cmbListarproductores;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbVentas;
    // End of variables declaration//GEN-END:variables
}
