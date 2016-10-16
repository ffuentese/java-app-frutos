/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vistas;

import Controller.LoginControlador;
import DAO.ParametroDAO;
import DAO.UsuarioLoginDAO;
import DTO.Perfil;
import DTO.Usuario;
import DTO.UsuarioLogin;
import java.io.FileInputStream;
import java.io.UnsupportedEncodingException;
import javax.xml.soap.*;
import java.net.*;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import static java.util.Collections.list;
import java.util.Date;
import java.util.Iterator;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.namespace.QName;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.stream.StreamResult;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpression;
import javax.xml.xpath.XPathFactory;
import org.w3._2001.xmlschema.ObjectFactory;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import java.util.List;
import java.util.Properties;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import org.w3c.dom.Element;

/**
 *
 * @author Jorge
 */
public class Login extends javax.swing.JFrame {

    LoginControlador logc = new LoginControlador();
    static MessageFactory messageFactory = null;
    UsuarioLoginDAO ulogdao = new UsuarioLoginDAO();
    ParametroDAO pardao = new ParametroDAO();

    /**
     * Creates new form Login
     */
    public Login() {
        initComponents();
        try {
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(Ventana_Principal_Productor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            Logger.getLogger(Ventana_Principal_Productor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            Logger.getLogger(Ventana_Principal_Productor.class.getName()).log(Level.SEVERE, null, ex);
        } catch (UnsupportedLookAndFeelException ex) {
            Logger.getLogger(Ventana_Principal_Productor.class.getName()).log(Level.SEVERE, null, ex);
        }

        SwingUtilities.updateComponentTreeUI(this);
        txtRut.requestFocus();

        for (int i = 0; i < listaPerfiles().size(); i++) {
            cbPerfil.addItem(listaPerfiles().get(i));
        }
        cbPerfil.setSelectedIndex(0);

    }

    private ArrayList<Perfil> listaPerfiles() {
        // llena los perfiles del combobox
        ArrayList<Perfil> arrperfiles = new ArrayList<>();
        Perfil adm = new Perfil();
        Perfil pro = new Perfil();
        pro.setId_perfil(2);
        pro.setNombre("PRODUCTOR");
        arrperfiles.add(pro);
        adm.setId_perfil(3);
        adm.setNombre("ADMINISTRADOR");
        arrperfiles.add(adm);

        return arrperfiles;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        txtRut = new javax.swing.JTextField();
        pssClave = new javax.swing.JPasswordField();
        btnIngresar = new javax.swing.JButton();
        btnSalir = new javax.swing.JButton();
        lblError = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        cbPerfil = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("FRUTOS FRESCOS");

        jLabel1.setText("USER");

        jLabel2.setText("CLAVE");

        txtRut.setName("txtRut"); // NOI18N
        txtRut.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtRutKeyReleased(evt);
            }
        });

        pssClave.setName("pssClave"); // NOI18N

        btnIngresar.setText("INGRESAR");
        btnIngresar.setName("btnIngresar"); // NOI18N
        btnIngresar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnIngresarActionPerformed(evt);
            }
        });

        btnSalir.setText("SALIR");
        btnSalir.setName("btnSAlir"); // NOI18N
        btnSalir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSalirActionPerformed(evt);
            }
        });

        lblError.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        lblError.setForeground(new java.awt.Color(204, 0, 0));

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        jLabel4.setText("Ingrese el rut sin digito verificador");

        jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/login.jpg"))); // NOI18N
        jLabel5.setText("jLabel5");

        jLabel6.setText("TIPO");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(41, 41, 41)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel6))
                        .addGap(26, 26, 26)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(pssClave, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(44, 44, 44)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(189, 189, 189))))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap(72, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 317, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                    .addComponent(btnIngresar)
                                    .addGap(73, 73, 73)
                                    .addComponent(btnSalir, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(87, 87, 87))))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 208, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(30, 30, 30))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(jLabel3)
                        .addGap(31, 31, 31)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtRut, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(pssClave, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(cbPerfil, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel6))
                        .addGap(27, 27, 27)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnIngresar)
                            .addComponent(btnSalir))
                        .addGap(18, 18, 18)
                        .addComponent(lblError, javax.swing.GroupLayout.PREFERRED_SIZE, 23, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(25, 25, 25)
                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 253, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(40, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnIngresarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnIngresarActionPerformed
        //Toma los datos ingresados y los envía al webservice para la autenticación 
        //y luego abre la ventana correspondiente si el usuario es válido.
        if (!txtRut.getText().isEmpty() && pssClave.getPassword().length > 0) {

            String user = txtRut.getText().trim();
            String password = new String(pssClave.getPassword());
            int perfil = ((Perfil) cbPerfil.getSelectedItem()).getId_perfil();
            try {
                password = logc.hash(password).toUpperCase();
            } catch (NoSuchAlgorithmException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            } catch (UnsupportedEncodingException ex) {
                Logger.getLogger(Login.class.getName()).log(Level.SEVERE, null, ex);
            }

            // Verifica si usuario puede loguearse en sistema 
            if (logc.validarSesiones(user)) {
                Usuario usu = logc.loginUsuario(user, password, perfil);
                //valida el usuario
                if (usu.getRut() != null) {
                    //valida el tipo de usuario y registra el ingreso
                    UsuarioLogin ulog = new UsuarioLogin();
                    ulog.setRut(usu.getRut());
                    ulog.setSistema("2");
                    ulog.setFecha(new Date());
                    ulog.setValor4(java.util.UUID.randomUUID().toString());
                    if (logc.registrarLogin(ulog)) {
                        if (usu.getId_tipo_perfil() == 3) {
                            Ventana_Principal ventana = new Ventana_Principal(usu, ulog);
                            ventana.setVisible(true);
                            ventana.setLocationRelativeTo(null);

                            dispose();
                        } else {
                            if (usu.getId_tipo_perfil() == 2) {
                                Ventana_Principal_Productor ventana_prod = new Ventana_Principal_Productor(usu, ulog);
                                ventana_prod.setVisible(true);
                                ventana_prod.setLocationRelativeTo(null);
                                dispose();
                            } else {
                                lblError.setText("No tiene el perfil para usar la aplicaciòn");
                            }
                        }
                    } else {
                        JOptionPane.showMessageDialog(this, "No se pudo guardar la sesión en el servidor.");
                    }
                } else {
                    //mostrar.setText(password);
                    lblError.setText("La clave es incorrecta");
                }
            } else {
                lblError.setText("Máximo numero de sesiones activas");
            }

        } else {
            // Si el usuario no llenó alguno de los campos
            lblError.setText("No llenó los campos requeridos");
            txtRut.requestFocus();
        }


    }//GEN-LAST:event_btnIngresarActionPerformed


    private void btnSalirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSalirActionPerformed
        System.exit(0);        // Cierra la aplicación:
    }//GEN-LAST:event_btnSalirActionPerformed

    private void txtRutKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRutKeyReleased
        // Valida que campo de RUT sólo contenga números
        int x;
        try {
            x = Integer.parseInt(txtRut.getText());
        } catch (NumberFormatException nfe) {
            txtRut.setText("");
        }
    }//GEN-LAST:event_txtRutKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnIngresar;
    private javax.swing.JButton btnSalir;
    private javax.swing.JComboBox cbPerfil;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel lblError;
    private javax.swing.JPasswordField pssClave;
    private javax.swing.JTextField txtRut;
    // End of variables declaration//GEN-END:variables

}
