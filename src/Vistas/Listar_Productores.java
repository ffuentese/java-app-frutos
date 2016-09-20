/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controller.ProductorControlador;
import DTO.Productor;
import DTO.Usuario;
import DAO.ComunaDAO;
import DAO.DireccionDAO;
import DTO.Comuna;
import DTO.Direccion;
import DTO.Usuario;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Jorge
 */
public class Listar_Productores extends javax.swing.JFrame {

    ProductorControlador prc = new ProductorControlador();
    DireccionDAO dir=new DireccionDAO();
    ComunaDAO comunas = new ComunaDAO();
    ArrayList<Comuna> compart=comunas.listaComunas();
        ArrayList<Comuna> comnego=comunas.listaComunas();
        Usuario usu=new Usuario();
    /**
     * Creates new form Ventana_Principal
     */
    
    public Listar_Productores() {
        initComponents();
        ArrayList<Productor> arrpro = prc.listaProductores();
        
        for(int i=0;i<arrpro.size();i++){
            cmbListarproductores.addItem(arrpro.get(i));
        }
        
        
        
        txtRut.setEnabled(false);
        txtDv.setEnabled(false);
        txtNombre.setEnabled(false);
        txtApellido.setEnabled(false);
        txtCorreo.setEnabled(false);
        txtDireccioncomercial.setEnabled(false);
        txtNumerocomercial.setEnabled(false);
        cmbComunacomercial.setEnabled(false);
        txtDireccionparticular.setEnabled(false);
        txtNumeroparticular.setEnabled(false);
        cmbComunaparticular.setEnabled(false);
        rbnFemenino.setEnabled(false);
        rbnMasculino.setEnabled(false);
        txtTelefono.setEnabled(false);
        txtRegioncomercial.setEnabled(false);
        txtRegionparticular.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        btnVolver = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        cmbListarproductores = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        txtApellido = new javax.swing.JTextField();
        txtNombre = new javax.swing.JTextField();
        txtDireccionparticular = new javax.swing.JTextField();
        txtDireccioncomercial = new javax.swing.JTextField();
        txtTelefono = new javax.swing.JTextField();
        txtCorreo = new javax.swing.JTextField();
        btnEliminar = new javax.swing.JButton();
        btnModificar = new javax.swing.JButton();
        btnVerStock = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        txtDv = new javax.swing.JTextField();
        rbnMasculino = new javax.swing.JRadioButton();
        rbnFemenino = new javax.swing.JRadioButton();
        jLabel12 = new javax.swing.JLabel();
        txtNumeroparticular = new javax.swing.JTextField();
        jLabel13 = new javax.swing.JLabel();
        jLabel14 = new javax.swing.JLabel();
        txtNumerocomercial = new javax.swing.JTextField();
        jLabel15 = new javax.swing.JLabel();
        jLabel16 = new javax.swing.JLabel();
        txtRegionparticular = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        txtRegioncomercial = new javax.swing.JTextField();
        cmbComunaparticular = new javax.swing.JComboBox();
        cmbComunacomercial = new javax.swing.JComboBox();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        btnVolver.setText("VOLVER");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        jLabel1.setText("LISTAR PRODUCTORES");

        cmbListarproductores.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione un productor" }));
        cmbListarproductores.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbListarproductoresActionPerformed(evt);
            }
        });

        jLabel2.setText("PRODUCTORES");

        jLabel3.setText("RUT:");

        jLabel4.setText("NOMBRE:");

        jLabel5.setText("APELLIDO:");

        jLabel6.setText("SEXO:");

        jLabel7.setText("DIRECCIÓN PARTICULAR:");

        jLabel8.setText("TELÉFONO:");

        jLabel9.setText("CORREO:");

        jLabel10.setText("DIRECCIÓN COMERCIAL:");

        btnEliminar.setText("ELIMINAR");
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        btnModificar.setText("MODIFICAR");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnVerStock.setText("VER STOCK");
        btnVerStock.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVerStockActionPerformed(evt);
            }
        });

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
        jLabel11.setText("-");

        buttonGroup1.add(rbnMasculino);
        rbnMasculino.setText("MASCULINO");

        buttonGroup1.add(rbnFemenino);
        rbnFemenino.setText("FEMENINO");

        jLabel12.setText("NÚMERO:");

        jLabel13.setText("COMUNA:");

        jLabel14.setText("NÚMERO:");

        jLabel15.setText("COMUNA:");

        jLabel16.setText("REGION");

        jLabel17.setText("REGION");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(rbnMasculino)
                                .addGap(33, 33, 33)
                                .addComponent(rbnFemenino))
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel11, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(txtDv, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 183, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(33, 33, 33)
                                        .addComponent(jLabel2)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(cmbListarproductores, javax.swing.GroupLayout.PREFERRED_SIZE, 178, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(21, 21, 21)
                                        .addComponent(jLabel5)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, 243, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                        .addGap(0, 44, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnVerStock)
                                .addGap(63, 63, 63)
                                .addComponent(btnModificar)
                                .addGap(68, 68, 68)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 99, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(80, 80, 80)
                                .addComponent(btnVolver))
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel8)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, 88, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(31, 31, 31)
                                    .addComponent(jLabel9)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtCorreo))
                                .addComponent(jLabel1)
                                .addGroup(layout.createSequentialGroup()
                                    .addComponent(jLabel7)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(txtDireccionparticular, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(jLabel12)
                                    .addGap(18, 18, 18)
                                    .addComponent(txtNumeroparticular, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addComponent(jLabel6)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                            .addComponent(jLabel15)
                                            .addGap(18, 18, 18)
                                            .addComponent(cmbComunacomercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel17)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtRegioncomercial))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel13)
                                            .addGap(18, 18, 18)
                                            .addComponent(cmbComunaparticular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addGap(18, 18, 18)
                                            .addComponent(jLabel16)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtRegionparticular))
                                        .addGroup(layout.createSequentialGroup()
                                            .addComponent(jLabel10)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtDireccioncomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 157, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                                            .addComponent(jLabel14)
                                            .addGap(18, 18, 18)
                                            .addComponent(txtNumerocomercial, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                    .addGap(148, 148, 148))))
                        .addContainerGap(44, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(20, 20, 20)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbListarproductores, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11)
                    .addComponent(txtDv, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(10, 10, 10)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5)
                    .addComponent(txtApellido, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(rbnMasculino)
                    .addComponent(rbnFemenino))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8)
                    .addComponent(txtTelefono, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txtDireccionparticular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12)
                    .addComponent(txtNumeroparticular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(jLabel16)
                    .addComponent(txtRegionparticular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbComunaparticular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtDireccioncomercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel14)
                    .addComponent(txtNumerocomercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel17)
                        .addComponent(txtRegioncomercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel15)
                        .addComponent(cmbComunacomercial, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnVerStock)
                    .addComponent(btnModificar)
                    .addComponent(btnEliminar)
                    .addComponent(btnVolver))
                .addGap(23, 23, 23))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        this.dispose();
        
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEliminarActionPerformed

    
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed

        if(btnModificar.getText()=="MODIFICAR"){
            for (int i=0;i<compart.size();i++){
            cmbComunacomercial.addItem(compart.get(i));
            cmbComunaparticular.addItem(comnego.get(i));
        }
        btnModificar.setText("GUARDAR");
        txtNombre.setEnabled(true);
        txtApellido.setEnabled(true);
        txtCorreo.setEnabled(true);
        txtDireccioncomercial.setEnabled(true);
        txtNumerocomercial.setEnabled(true);
        cmbComunacomercial.setEnabled(true);
        txtDireccionparticular.setEnabled(true);
        txtNumeroparticular.setEnabled(true);
        cmbComunaparticular.setEnabled(true);
        rbnFemenino.setEnabled(true);
        rbnMasculino.setEnabled(true);
        txtTelefono.setEnabled(true);
        
        }else{
        if(btnModificar.getText()=="GUARDAR"){
        String rut=txtRut.getText().trim();
        String dv=txtDv.getText().trim();
        String nombre=txtNombre.getText();
        String apellido = txtApellido.getText();
        String correo = txtCorreo.getText();
        String dirComercial=txtDireccioncomercial.getText();
        String numeroComercial=txtNumerocomercial.getText();
        Comuna comcomer=((Comuna)cmbComunacomercial.getSelectedItem());
        String dirParticular=txtDireccionparticular.getText();
        String numeroParticular=txtNumeroparticular.getText();
        Comuna compart=((Comuna)cmbComunaparticular.getSelectedItem());
        String sexo="";
        String mismaDireccion="";
        if (rbnMasculino.isSelected()){
            sexo="M";
        }else{
            if(rbnFemenino.isSelected()){
                sexo="F";
            }else{
                JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR SEXO");
            }
        }
        String telefono = txtTelefono.getText();
        String regionparticular=txtRegionparticular.getText();
        String regioncomercial=txtRegioncomercial.getText();
        if(dirComercial.compareToIgnoreCase(dirParticular)==0&numeroComercial.compareToIgnoreCase(numeroParticular)==0
                &comcomer.getId_comuna()==compart.getId_comuna()){
            mismaDireccion="1";
        }else{
            mismaDireccion="0";
        }
        Productor pro = ((Productor)cmbListarproductores.getSelectedItem());
        Productor produc=new Productor();
        produc.setRut(rut);
        produc.setDv(dv);
        produc.setNombre(nombre);
        produc.setApellido(apellido);
        produc.setComuna_negocio(comcomer.getNombre());
        produc.setComuna_particular(compart.getNombre());
        produc.setCorreo(correo);
        produc.setDireccion_negocio(dirComercial);
        produc.setDireccion_particular(dirParticular);
        produc.setId_comunanegocio(Integer.toString(comcomer.getId_comuna()));
        produc.setId_comunaparticular(Integer.toString(compart.getId_comuna()));
        produc.setId_direccion_negocio(pro.getId_direccion_negocio());
        produc.setId_direccion_particular(pro.getId_direccion_particular());
        produc.setMisma_direccion(mismaDireccion);
        produc.setNumero_negocio(numeroComercial);
        produc.setNumero_particular(numeroParticular);
        produc.setRegioncomercial(regioncomercial);
        produc.setRegionparticular(regionparticular);
        produc.setSexo(sexo);
        produc.setTelefono(telefono);
        
        Direccion direccionparticular=new Direccion();
        direccionparticular.setCoordenadaX("0");
        direccionparticular.setCoordenadaY("0");
        direccionparticular.setId_comuna(compart.getId_comuna());
        direccionparticular.setId_direccion(Integer.parseInt(produc.getId_direccion_particular()));
        direccionparticular.setNombre(dirParticular);
        direccionparticular.setNumero(numeroParticular);
        
        Direccion direccionnegocio = new Direccion();
        direccionnegocio.setCoordenadaX("0");
        direccionnegocio.setCoordenadaY("0");
        direccionnegocio.setId_comuna(comcomer.getId_comuna());
        direccionnegocio.setId_direccion(Integer.parseInt(produc.getId_direccion_negocio()));
        direccionnegocio.setNombre(dirComercial);
        direccionnegocio.setNumero(numeroComercial);
        
        prc.Update(produc);
        dir.Update(direccionnegocio);
        dir.Update(direccionparticular);
     
        JOptionPane.showMessageDialog(null, "DATOS MODIFICADOS EXITOSAMENTE");
        
        }
    }
    
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnVerStockActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVerStockActionPerformed
        ManProductosProductor mpp = new ManProductosProductor(usu);
        mpp.setVisible(true);
        mpp.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnVerStockActionPerformed

    private void cmbListarproductoresActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbListarproductoresActionPerformed
        // TODO add your handling code here:
        Productor pro = ((Productor)cmbListarproductores.getSelectedItem());
        Comuna compart=new Comuna();
        Comuna comneg=new Comuna();
        compart.setId_comuna(Integer.parseInt(pro.getId_comunaparticular()));
        compart.setNombre(pro.getComuna_particular());
        comneg.setId_comuna(Integer.parseInt(pro.getId_comunanegocio()));
        comneg.setNombre(pro.getComuna_negocio());
        txtRut.setText(pro.getRut());
        txtDv.setText(pro.getDv());
        txtNombre.setText(pro.getNombre());
        txtApellido.setText(pro.getApellido());
        try{
        if(pro.getSexo().compareToIgnoreCase("m")==0){
        rbnMasculino.setSelected(true);
        
        }
        else if(pro.getSexo().compareToIgnoreCase("f")==0){
            rbnFemenino.setSelected(true);
        }
       
    }catch(Exception e){
                JOptionPane.showMessageDialog(null, e, "ERROR", JOptionPane.WARNING_MESSAGE);
                }
       
        txtDireccionparticular.setText(pro.getDireccion_particular());
        txtNumeroparticular.setText(pro.getNumero_particular());
        cmbComunaparticular.addItem(compart);
        txtTelefono.setText(pro.getTelefono());
        txtCorreo.setText(pro.getCorreo());
        txtDireccioncomercial.setText(pro.getDireccion_negocio());
        txtNumerocomercial.setText(pro.getNumero_negocio());
        cmbComunacomercial.addItem(comneg);
        txtRegioncomercial.setText(pro.getRegioncomercial());
        txtRegionparticular.setText(pro.getRegionparticular());
        
        usu.setRut(pro.getRut());
    }//GEN-LAST:event_cmbListarproductoresActionPerformed

    /**
     * @param args the command line arguments
     */
  

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEliminar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVerStock;
    private javax.swing.JButton btnVolver;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox cmbComunacomercial;
    private javax.swing.JComboBox cmbComunaparticular;
    private javax.swing.JComboBox cmbListarproductores;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbnFemenino;
    private javax.swing.JRadioButton rbnMasculino;
    private javax.swing.JTextField txtApellido;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JTextField txtDireccioncomercial;
    private javax.swing.JTextField txtDireccionparticular;
    private javax.swing.JTextField txtDv;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumerocomercial;
    private javax.swing.JTextField txtNumeroparticular;
    private javax.swing.JTextField txtRegioncomercial;
    private javax.swing.JTextField txtRegionparticular;
    private javax.swing.JTextField txtRut;
    private javax.swing.JTextField txtTelefono;
    // End of variables declaration//GEN-END:variables
}
