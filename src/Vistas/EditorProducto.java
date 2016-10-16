/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controller.ActualizarLoginCon;
import DAO.ImagenDAO;
import DAO.MedidaDAO;
import DAO.ProductoDAO;
import DAO.TipoCultivoDAO;
import DAO.TipoProductoDAO;
import DTO.Imagen;
import DTO.Medida;
import DTO.Producto;
import DTO.TipoCultivo;
import DTO.TipoProducto;
import DTO.Usuario;
import DTO.UsuarioLogin;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URLConnection;
import java.util.ArrayList;
import java.util.Date;
import javax.activation.MimetypesFileTypeMap;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;

/**
 *
 * @author Francisco
 */
public class EditorProducto extends javax.swing.JFrame {

    TipoCultivoDAO tcudao = new TipoCultivoDAO();
    MedidaDAO meddao = new MedidaDAO();
    TipoProductoDAO tprdao = new TipoProductoDAO();
    ProductoDAO pdao = new ProductoDAO();
    ImagenDAO idao = new ImagenDAO();
    ArrayList<TipoCultivo> arrtcu = tcudao.listaTipoCultivo();
    ArrayList<Medida> arrmed = meddao.listaMedidas();
    ArrayList<TipoProducto> arrtpr = tprdao.listaTipoProducto();
    Producto prod = new Producto();
    ImagenDAO imdao = new ImagenDAO();
    ActualizarLoginCon alc = new ActualizarLoginCon();
    UsuarioLogin ulog = new UsuarioLogin();

    /**
     * Creates new form EditorProducto
     *
     * @param producto
     */
    public EditorProducto(Producto producto, UsuarioLogin log) {
        ulog = log;
        alc.actualizarLogin(ulog);
        initComponents();
        for (int i = 0; i < arrmed.size(); i++) {
            cbMedida.addItem(arrmed.get(i));
        }

        for (int i = 0; i < arrtpr.size(); i++) {
            cbTipoProducto.addItem(arrtpr.get(i));
        }

        for (int i = 0; i < arrtcu.size(); i++) {
            cbTipoCultivo.addItem(arrtcu.get(i));
        }
        prod = producto;
        this.setTitle("Detalles del producto");
        if (prod.getId_producto() != 0) {
            if (imdao.getImagen(prod.getId_producto()).getUbicacion() != null) {
                Imagen img = imdao.getImagen(prod.getId_producto());
                ImageIcon ico = new ImageIcon(idao.ObtenerImagen(img.getUbicacion()));
                Image ima = ico.getImage().getScaledInstance(250, 150, java.awt.Image.SCALE_SMOOTH);
                jLabel12.setIcon(new ImageIcon(ima));
            }
            txtId_Producto.setText(Integer.toString(prod.getId_producto()));
            txtRut_Productor.setText(Integer.toString(prod.getRut_productor()));
            if (prod.getOferta() == 1) {
                rbOfertaSi.setSelected(true);
            } else {
                rbOfertaNo.setSelected(true);
            }
            if (prod.getActivo() == 1) {
                rbActivoSi.setSelected(true);
            } else {
                rbActivoNo.setSelected(true);
            }
            txtDescripcion.setText(prod.getDescripcion());
            txtZonaDeCultivo.setText(prod.getZona_cultivo());
            spStock.setValue(Integer.valueOf(prod.getStock()));
            txtPrecioUnitario.setText(Integer.toString(prod.getPrecio()));
            txtRut_Productor.setEditable(false);
            txtId_Producto.setEditable(false);
            TipoCultivo tc = new TipoCultivo();
            tc.setId_tipo_cultivo(prod.getId_tipo_cultivo());

            cbTipoCultivo.setSelectedItem(tc);
            TipoProducto tp = new TipoProducto();
            tp.setId_tipo_producto(prod.getId_tipo_producto());
            cbTipoProducto.setSelectedItem(tp);
            Medida me = new Medida();
            me.setId_medida(prod.getId_medida());
            cbMedida.setSelectedItem(me);
            //Bloquear campos restantes 
            txtDescripcion.setEditable(false);
            txtZonaDeCultivo.setEditable(false);
            txtPrecioUnitario.setEditable(false);
        } else {
            btnImagen.setVisible(false);
            txtId_Producto.setEditable(false);
            txtRut_Productor.setEditable(false);
            txtRut_Productor.setText(Integer.toString(prod.getRut_productor()));
            txtDescripcion.setEditable(true);
            txtZonaDeCultivo.setEditable(true);
            txtPrecioUnitario.setEditable(true);
            btnModificar.setText("Guardar");
        }
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
        fileChooser = new javax.swing.JFileChooser();
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
        txtZonaDeCultivo = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        spStock = new javax.swing.JSpinner();
        jLabel7 = new javax.swing.JLabel();
        cbMedida = new javax.swing.JComboBox();
        jLabel8 = new javax.swing.JLabel();
        txtPrecioUnitario = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        rbActivoSi = new javax.swing.JRadioButton();
        jLabel10 = new javax.swing.JLabel();
        rbActivoNo = new javax.swing.JRadioButton();
        btnModificar = new javax.swing.JButton();
        btnVolver = new javax.swing.JButton();
        cbTipoCultivo = new javax.swing.JComboBox();
        jLabel11 = new javax.swing.JLabel();
        btnImagen = new javax.swing.JButton();
        jLabel12 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        cbTipoProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));

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

        cbMedida.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));

        jLabel8.setText("Medida");

        txtPrecioUnitario.setText(" ");
        txtPrecioUnitario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPrecioUnitarioKeyReleased(evt);
            }
        });

        jLabel9.setText("Precio Unitario");

        bgActivo.add(rbActivoSi);
        rbActivoSi.setText("Sí");

        jLabel10.setText("Activo");

        bgActivo.add(rbActivoNo);
        rbActivoNo.setText("No");

        btnModificar.setText("Modificar");
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnVolver.setText("Volver");
        btnVolver.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnVolverActionPerformed(evt);
            }
        });

        cbTipoCultivo.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Seleccione" }));

        jLabel11.setText("Tipo de cultivo");

        btnImagen.setText("Sel Imagen");
        btnImagen.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnImagenActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(jLabel5)
                                .addGap(60, 60, 60)
                                .addComponent(txtDescripcion, javax.swing.GroupLayout.PREFERRED_SIZE, 277, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
                                .addGap(379, 379, 379)
                                .addComponent(cbTipoCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(57, 57, 57))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(69, 69, 69)
                                        .addComponent(btnVolver, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(jLabel8)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(cbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, 91, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(45, 45, 45)
                                                .addComponent(jLabel9)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, 86, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 290, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(48, 48, 48)
                                        .addComponent(jLabel10)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rbActivoSi)
                                        .addGap(18, 18, 18)
                                        .addComponent(rbActivoNo))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(btnImagen, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 3, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel6)
                                .addGap(41, 41, 41)
                                .addComponent(txtZonaDeCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(63, 63, 63)
                                .addComponent(jLabel11)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel7)
                                .addGap(18, 18, 18)
                                .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(layout.createSequentialGroup()
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
                                .addComponent(cbTipoProducto, 0, 98, Short.MAX_VALUE)
                                .addGap(46, 46, 46)
                                .addComponent(jLabel1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(rbOfertaNo)
                                    .addComponent(rbOfertaSi))))))
                .addGap(40, 40, 40))
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
                    .addComponent(txtZonaDeCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6)
                    .addComponent(spStock, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7)
                    .addComponent(cbTipoCultivo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(26, 26, 26)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cbMedida, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(txtPrecioUnitario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel9)
                    .addComponent(rbActivoSi)
                    .addComponent(jLabel10)
                    .addComponent(rbActivoNo))
                .addGap(74, 74, 74)
                .addComponent(jLabel12, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 60, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnModificar)
                    .addComponent(btnVolver)
                    .addComponent(btnImagen))
                .addGap(57, 57, 57))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtDescripcionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtDescripcionActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtDescripcionActionPerformed

    private void btnVolverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnVolverActionPerformed
        // TODO add your handling code here:

//        Usuario usu = new Usuario();
//        usu.setRut(txtRut_Productor.getText());
//        ManProductosProductor man = new ManProductosProductor(usu);
//        man.setVisible(true);
//        man.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnVolverActionPerformed

    private void txtPrecioUnitarioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPrecioUnitarioKeyReleased
        // Validación para evitar que se inserten valores no numéricos:
        int x;
        try {
            x = Integer.parseInt(txtPrecioUnitario.getText());
        } catch (NumberFormatException nfe) {
            txtPrecioUnitario.setText("");
        }
    }//GEN-LAST:event_txtPrecioUnitarioKeyReleased

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        // TODO add your handling code here:
        alc.actualizarLogin(ulog);
        if (btnModificar.getText() == "Modificar") {
            txtDescripcion.setEditable(true);
            txtZonaDeCultivo.setEditable(true);
            txtPrecioUnitario.setEditable(true);
            btnModificar.setText("Guardar");
        } else {
            if (btnModificar.getText() == "Guardar") {
                if (!txtDescripcion.getText().isEmpty()
                        && !txtZonaDeCultivo.getText().isEmpty()
                        && !txtPrecioUnitario.getText().isEmpty()
                        && cbMedida.getSelectedIndex() != 0
                        && cbTipoCultivo.getSelectedIndex() != 0
                        && cbTipoProducto.getSelectedIndex() != 0) {
                    if (!txtId_Producto.getText().isEmpty()) {
                        prod.setId_producto(Integer.parseInt(txtId_Producto.getText()));
                    }
                    prod.setRut_productor(Integer.parseInt(txtRut_Productor.getText()));
                    prod.setDescripcion(txtDescripcion.getText());
                    prod.setZona_cultivo(txtZonaDeCultivo.getText());
                    prod.setPrecio(Integer.parseInt(txtPrecioUnitario.getText()));
                    if (cbTipoProducto.getSelectedIndex() != 0) {
                        prod.setId_tipo_producto(((TipoProducto) cbTipoProducto.getSelectedItem()).getId_tipo_producto());
                    }
                    if (cbMedida.getSelectedIndex() != 0) {
                        prod.setId_medida(((Medida) cbMedida.getSelectedItem()).getId_medida());
                    }
                    if (cbTipoCultivo.getSelectedIndex() != 0) {
                        prod.setId_tipo_cultivo(((TipoCultivo) cbTipoCultivo.getSelectedItem()).getId_tipo_cultivo());
                    }
                    int stock = (Integer) spStock.getValue();
                    prod.setStock(stock);
                    if (rbOfertaSi.isSelected()) {
                        prod.setOferta(1);
                    } else if (rbOfertaNo.isSelected()) {
                        prod.setOferta(0);
                    } else {
                        return;
                    }
                    if (rbActivoSi.isSelected()) {
                        prod.setActivo(1);
                    } else if (rbOfertaNo.isSelected()) {
                        prod.setActivo(0);
                    } else {
                        return;
                    }

                    if (txtId_Producto.getText().isEmpty()) {
                        int id_producto=pdao.agregar(prod);
                        if(id_producto!=0){
                        txtId_Producto.setText(Integer.toString(id_producto));
                        JOptionPane.showMessageDialog(null, "PRODUCTO AGREGADO EXITOSAMENTE");
                        btnImagen.setVisible(true);
                        }else{
                            JOptionPane.showMessageDialog(null, "HUBO UN PROBLEMA AL REALIZAR LA OPERACIÓN");
                        }
                    } else {
                        if (pdao.Update(prod)) {
                            JOptionPane.showMessageDialog(null, "DATOS MODIFICADOS EXITOSAMENTE");
                        } else {
                            JOptionPane.showMessageDialog(null, "HUBO UN PROBLEMA AL REALIZAR LA OPERACIÓN");
                        }
                    }
                } else {
                    return;
                }

            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnImagenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnImagenActionPerformed
        // TODO add your handling code here:
        OpenActionPerformed(evt);
    }//GEN-LAST:event_btnImagenActionPerformed

    private void OpenActionPerformed(java.awt.event.ActionEvent evt) {
        alc.actualizarLogin(ulog);
        int returnVal = fileChooser.showOpenDialog(this);
        if (returnVal == JFileChooser.APPROVE_OPTION) {
            File file = fileChooser.getSelectedFile();
            try {
                // What to do with the file, e.g. display it in a TextArea
//          String mimetype= new MimetypesFileTypeMap().getContentType(file);
                String mimetype = URLConnection.guessContentTypeFromName(file.getPath());
                String type = mimetype.split("/")[0];
                String ext = "." + this.getFileExtension(file);
                if (type.equals("image")) {
                    Imagen im = new Imagen();
                    im.setNombre(file.getName());
                    im.setDescripcion(txtDescripcion.getText());
                    im.setOrden(1);
                    if(!txtId_Producto.getText().isEmpty()){
                    im.setId_producto(Integer.parseInt(txtId_Producto.getText()));
                    }
                    im.setFecha(new Date());
                    String filename = java.util.UUID.randomUUID().toString() + ext;
                    im.setUbicacion(filename);
                    if (idao.SubirImagen(file, im.getUbicacion())) {
                        if (idao.getImagen(prod.getId_producto()) != null) {
                            if (idao.create(im)) {
                                System.out.println("Imagen " + im.getUbicacion() + " guardada.");
                            }
                        } else {
                            if (idao.Update(im)) {
                                System.out.println("Imagen " + im.getUbicacion() + " guardada.");
                            }
                        };

                    }
                } else {
                    JOptionPane.showMessageDialog(this, "Este archivo no se reconoce como una imagen.");
                }

            } catch (Exception ex) {
                System.out.println("Problema accediendo al archivo " + file.getAbsolutePath());
            }

        }
    }

    private String getFileExtension(File file) {
        String name = file.getName();
        try {
            return name.substring(name.lastIndexOf(".") + 1);
        } catch (Exception e) {
            return "";
        }

    }
    /**
     * @param args the command line arguments
     */

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bgActivo;
    private javax.swing.ButtonGroup bgOferta;
    private javax.swing.JButton btnImagen;
    private javax.swing.JButton btnModificar;
    private javax.swing.JButton btnVolver;
    private javax.swing.JComboBox cbMedida;
    private javax.swing.JComboBox cbTipoCultivo;
    private javax.swing.JComboBox cbTipoProducto;
    private javax.swing.JFileChooser fileChooser;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JRadioButton rbActivoNo;
    private javax.swing.JRadioButton rbActivoSi;
    private javax.swing.JRadioButton rbOfertaNo;
    private javax.swing.JRadioButton rbOfertaSi;
    private javax.swing.JSpinner spStock;
    private javax.swing.JTextField txtDescripcion;
    private javax.swing.JTextField txtId_Producto;
    private javax.swing.JTextField txtPrecioUnitario;
    private javax.swing.JTextField txtRut_Productor;
    private javax.swing.JTextField txtZonaDeCultivo;
    // End of variables declaration//GEN-END:variables
}
