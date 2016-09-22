/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package Vistas;

import DTO.Producto;
import DAO.MedidaDAO;
import DAO.ProductoDAO;
import DAO.TipoCultivoDAO;
import DAO.TipoProductoDAO;
import DTO.Medida;
import DTO.TipoCultivo;
import DTO.TipoProducto;
import java.util.ArrayList;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco
 */
public class AgregarProducto extends javax.swing.JFrame {

    /**
     * Creates new form EditorProducto
     */
    MedidaDAO arrmedida=new MedidaDAO();
    TipoProductoDAO tprod=new TipoProductoDAO();
    TipoCultivoDAO tcul=new TipoCultivoDAO();
    
    public AgregarProducto(Producto prod) {
        initComponents();
       
        ArrayList<Medida> med=arrmedida.listaMedidas();
        ArrayList<TipoProducto> pro=tprod.listaTipoProducto();
        ArrayList<TipoCultivo> cul=tcul.listaTipoCultivo();
        for(int i=0;i<med.size();i++){
            cbMedida.addItem(med.get(i));
        }
        
        for(int i=0;i<pro.size();i++){
            cbTipoProducto.addItem(pro.get(i));
        }
        
        for(int i =0;i<cul.size();i++){
            cbTipocultivo.addItem(cul.get(i));
        }
        
        this.txtRut_Productor.setEditable(false);
        this.txtId_Producto.setEditable(false);
        btnModificar.setEnabled(false);
        txtRut_Productor.setText(Integer.toString(prod.getRut_productor()));
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bgOferta = new javax.swing.ButtonGroup();
        bgActivo = new javax.swing.ButtonGroup();
        txtId_Producto = new javax.swing.JTextField();
        txtRut_Productor = new javax.swing.JTextField();
        cbTipoProducto = new javax.swing.JComboBox();
        rbOfertaSi = new javax.swing.JRadioButton();
        rbOfertaNo = new javax.swing.JRadioButton();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtDescripcion = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        txtZonacultivo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        spStock = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        cbMedida = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtPreciounitario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rbActivosi = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        rbActivono = new javax.swing.JRadioButton();
        btnModificar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        cbTipocultivo = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        btnGuardar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbTipoProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione tipo Prducto" }));

        bgOferta.add(rbOfertaSi);
        rbOfertaSi.setText("Sí");

        bgOferta.add(rbOfertaNo);
        rbOfertaNo.setText("No");

        jLabel1.setText("Oferta");

        jLabel2.setText("ID");

        jLabel3.setText("Tipo");

        jLabel4.setText("RUT");

        txtDescripcion.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtDescripcionActionPerformed(evt);
            }
        });

        jLabel5.setText("Descripción");

        jLabel6.setText("Zona de cultivo");

        jLabel7.setText("Stock");

        cbMedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione tipo Medida" }));

        jLabel8.setText("Medida");

        txtPreciounitario.setText(" ");

        jLabel9.setText("Precio Unitario");

        bgActivo.add(rbActivosi);
        rbActivosi.setText("Sí");

        jLabel10.setText("Activo");

        bgActivo.add(rbActivono);
        rbActivono.setText("No");

        btnModificar.setText("Modificar");

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        cbTipocultivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione tipo Cultivo" }));

        jLabel11.setText("Tipo de cultivo");

        btnGuardar.setText("Guardar");
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addGap(60, 60, 60)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(369, 369, 369)
                                .addComponent(cbTipocultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel9)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(txtPreciounitario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(48, 48, 48)
                                .addComponent(jLabel10)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(rbActivosi)
                                .addGap(18, 18, 18)
                                .addComponent(rbActivono))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(91, 91, 91))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(29, 29, 29)
                        .addComponent(txtId_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, 96, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(57, 57, 57)
                        .addComponent(jLabel4)
                        .addGap(22, 22, 22)
                        .addComponent(txtRut_Productor, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel3)
                        .addGap(20, 20, 20)
                        .addComponent(cbTipoProducto, 0, 179, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(rbOfertaNo)
                            .addComponent(rbOfertaSi))
                        .addGap(40, 40, 40))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGap(3, 3, 3)
                                .addComponent(jLabel6)
                                .addGap(41, 41, 41)
                                .addComponent(txtZonacultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel11))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(25, 25, 25)
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(87, 87, 87)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(163, 163, 163)
                        .addComponent(jLabel7)
                        .addGap(18, 18, 18)
                        .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtId_Producto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtRut_Productor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel2)
                        .addComponent(jLabel4))
                    .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(cbTipoProducto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(rbOfertaSi)
                            .addComponent(jLabel1))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(rbOfertaNo)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5))
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtZonacultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbTipocultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtPreciounitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(rbActivosi)
                    .addComponent(jLabel10)
                    .addComponent(rbActivono))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 62, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnVolver)
                    .addComponent(btnGuardar))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        // TODO add your handling code here:
        TipoProducto tipoP=((TipoProducto)cbTipoProducto.getSelectedItem());
        TipoCultivo tipoC=((TipoCultivo)cbTipocultivo.getSelectedItem());
        Medida med=((Medida)cbMedida.getSelectedItem());
        int oferta=3;
        if(rbOfertaSi.isSelected()){
            oferta=1;
        }else{
            if(rbOfertaNo.isSelected()){
                oferta=0;
            }else{
                JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA OPCION");
            }
        }
        int activo=3;
        if(rbActivosi.isSelected()){
            oferta=1;
        }else{
            if(rbActivono.isSelected()){
                oferta=0;
            }else{
                JOptionPane.showMessageDialog(null, "DEBE SELECCIONAR UNA OPCION");
            }
        }
        String descripcion=txtDescripcion.getText();
        String zona_cultivo=txtZonacultivo.getText();
        int precio=Integer.parseInt(txtPreciounitario.getText().trim());
        int stock=Integer.parseInt(spStock.getValue().toString());
        ProductoDAO pdao=new ProductoDAO();
        ArrayList<Producto> listp=pdao.listaProductosRUT(Integer.parseInt(txtRut_Productor.getText()));
        int mayor=0;
        int id_direccion=0;
        for(int i=0;i<listp.size();i++){
            if(listp.get(i).getId_producto()>mayor){
                mayor=listp.get(i).getId_producto();
                id_direccion=listp.get(i).getId_direccion();
            }
        }
        int id_producto=mayor+1;
        Producto pr=new Producto();
        
        pr.setActivo(activo);
        pr.setDescripcion(descripcion);
        pr.setId_direccion(id_direccion);
        pr.setId_medida(med.getId_medida());
        pr.setId_producto(id_producto);
        pr.setId_tipo_cultivo(tipoC.getId_tipo_cultivo());
        pr.setId_tipo_producto(tipoP.getId_tipo_producto());
        pr.setOferta(oferta);
        pr.setPrecio(precio);
        pr.setRut_productor(Integer.parseInt(txtRut_Productor.getText()));
        pr.setStock(stock);
        pr.setZona_cultivo(zona_cultivo);
        
        ProductoDAO prod = new ProductoDAO();
        Boolean prueba=prod.agregar(pr);
        if(prueba==true){
        JOptionPane.showMessageDialog(null, "guardado");
        }else{
            JOptionPane.showMessageDialog(null, "error");
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    /**
     * @param args the command line arguments
     */


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgActivo;
    private javax.swing.ButtonGroup bgOferta;
    private javax.swing.JButton btnGuardar;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox cbMedida;
    private javax.swing.JComboBox cbTipoProducto;
    private javax.swing.JComboBox cbTipocultivo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbActivono;
    private javax.swing.JRadioButton rbActivosi;
    private javax.swing.JRadioButton rbOfertaNo;
    private javax.swing.JRadioButton rbOfertaSi;
    private javax.swing.JSpinner spStock;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId_Producto;
    private javax.swing.JTextField txtPreciounitario;
    private javax.swing.JTextField txtRut_Productor;
    private javax.swing.JTextField txtZonacultivo;
    // End of variables declaration//GEN-END:variables
}
