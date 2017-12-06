/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Formularios;

import Clases.ManagerInventario;
import Clases.ManagerPermisos;
import Clases.Validaciones;

import Interfaces.Principal;
import javax.swing.JOptionPane;
//import org.jdesktop.swingx.autocomplete.AutoCompleteDecorator;

/**
 *
 * @author kevin
 */
public class addInventario extends javax.swing.JDialog {
    ManagerInventario manager_inventario;
    ManagerPermisos manager_permisos;
    
    String clave,producto,almacen,marca,descripcion,observaciones,noserie,tipo,color,modelo;
    
    /**
     * Creates new form addInventario
     */
    public addInventario(java.awt.Frame parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        //Asginamos memoria al objeto
        manager_inventario = new ManagerInventario();
        manager_permisos = new ManagerPermisos();
        
        comboProducto.setEditable(true);
        //AutoCompleteDecorator.decorate(this.comboProducto);
        this.setLocationRelativeTo(null);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pn_addInventario = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtClave = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        txtMarca = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAreaDescripcion = new javax.swing.JTextArea();
        jScrollPane2 = new javax.swing.JScrollPane();
        txtAreaObservaciones = new javax.swing.JTextArea();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        txtNoSerie = new javax.swing.JTextField();
        lblAviso = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtTipoUso = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtColor = new javax.swing.JTextField();
        comboProducto = new javax.swing.JComboBox<String>();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        cb_almacen = new javax.swing.JComboBox();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        pn_addInventario.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        pn_addInventario.setLayout(null);

        jLabel1.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel1.setText("Clave:");
        pn_addInventario.add(jLabel1);
        jLabel1.setBounds(50, 16, 38, 17);

        txtClave.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtClave.addFocusListener(new java.awt.event.FocusAdapter() {
            public void focusLost(java.awt.event.FocusEvent evt) {
                txtClaveFocusLost(evt);
            }
        });
        pn_addInventario.add(txtClave);
        txtClave.setBounds(106, 13, 215, 23);

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Producto:");
        pn_addInventario.add(jLabel2);
        jLabel2.setBounds(30, 45, 62, 17);

        jLabel3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel3.setText("Descripción:");
        pn_addInventario.add(jLabel3);
        jLabel3.setBounds(388, 16, 75, 17);

        jLabel4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel4.setText("Almacén:");
        pn_addInventario.add(jLabel4);
        jLabel4.setBounds(32, 77, 56, 17);

        jLabel5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel5.setText("Marca:");
        pn_addInventario.add(jLabel5);
        jLabel5.setBounds(47, 106, 41, 17);

        txtMarca.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtMarcaActionPerformed(evt);
            }
        });
        pn_addInventario.add(txtMarca);
        txtMarca.setBounds(106, 100, 215, 23);

        txtAreaDescripcion.setColumns(20);
        txtAreaDescripcion.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAreaDescripcion.setRows(5);
        jScrollPane1.setViewportView(txtAreaDescripcion);

        pn_addInventario.add(jScrollPane1);
        jScrollPane1.setBounds(467, 13, 358, 110);

        txtAreaObservaciones.setColumns(20);
        txtAreaObservaciones.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtAreaObservaciones.setRows(5);
        jScrollPane2.setViewportView(txtAreaObservaciones);

        pn_addInventario.add(jScrollPane2);
        jScrollPane2.setBounds(467, 144, 358, 104);

        jLabel7.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel7.setText("Observaciones:");
        pn_addInventario.add(jLabel7);
        jLabel7.setBounds(369, 144, 94, 17);

        jLabel8.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel8.setText("No serie:");
        pn_addInventario.add(jLabel8);
        jLabel8.setBounds(35, 136, 53, 17);

        txtNoSerie.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtNoSerie.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtNoSerieActionPerformed(evt);
            }
        });
        pn_addInventario.add(txtNoSerie);
        txtNoSerie.setBounds(106, 130, 215, 23);

        lblAviso.setFont(new java.awt.Font("Tahoma", 0, 12)); // NOI18N
        pn_addInventario.add(lblAviso);
        lblAviso.setBounds(48, 261, 0, 0);

        jLabel9.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel9.setText("Tipo de uso:");
        pn_addInventario.add(jLabel9);
        jLabel9.setBounds(12, 162, 76, 17);

        txtTipoUso.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTipoUso.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoUsoActionPerformed(evt);
            }
        });
        pn_addInventario.add(txtTipoUso);
        txtTipoUso.setBounds(106, 159, 215, 23);

        jLabel10.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel10.setText("Modelo:");
        pn_addInventario.add(jLabel10);
        jLabel10.setBounds(40, 194, 48, 17);

        txtModelo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtModelo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtModeloActionPerformed(evt);
            }
        });
        pn_addInventario.add(txtModelo);
        txtModelo.setBounds(106, 188, 215, 23);

        jLabel11.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel11.setText("Color:");
        pn_addInventario.add(jLabel11);
        jLabel11.setBounds(50, 223, 37, 17);

        txtColor.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtColor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtColorActionPerformed(evt);
            }
        });
        pn_addInventario.add(txtColor);
        txtColor.setBounds(105, 217, 215, 23);

        comboProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        comboProducto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "CPU", "Monitor", "Teclado" }));
        pn_addInventario.add(comboProducto);
        comboProducto.setBounds(110, 42, 90, 23);

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        btnAceptar.setText(" Aceptar");
        btnAceptar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        pn_addInventario.add(btnAceptar);
        btnAceptar.setBounds(279, 300, 150, 33);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        btnCancelar.setText(" Cancelar");
        btnCancelar.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pn_addInventario.add(btnCancelar);
        btnCancelar.setBounds(440, 300, 150, 33);

        cb_almacen.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        cb_almacen.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Informatica", "Administracion", "Bodega" }));
        pn_addInventario.add(cb_almacen);
        cb_almacen.setBounds(110, 70, 110, 20);

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/formularios.png"))); // NOI18N
        pn_addInventario.add(jLabel6);
        jLabel6.setBounds(0, 0, 860, 340);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_addInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 845, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_addInventario, javax.swing.GroupLayout.PREFERRED_SIZE, 341, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtMarcaActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtMarcaActionPerformed

    private void txtNoSerieActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtNoSerieActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtNoSerieActionPerformed

    public boolean getInfo(){
        if(Validaciones.validarClave_añadirInventarioNormal(txtClave.getText())){clave = txtClave.getText();}else{JOptionPane.showMessageDialog(null, "Clave no cumple con requerimientos.");return false;}
        producto = comboProducto.getSelectedItem().toString();
        almacen = cb_almacen.getSelectedItem().toString();
        marca = txtMarca.getText();
        if(Validaciones.validarLongitudCadenaAlfanumerica(txtNoSerie.getText(), 8)){noserie = txtNoSerie.getText();}else{JOptionPane.showMessageDialog(null, "No Serie no cumple con requerimientos.");return false;}
        
        descripcion = txtAreaDescripcion.getText();
        observaciones = txtAreaObservaciones.getText();
        tipo = txtTipoUso.getText();
        modelo = txtModelo.getText();
        color = txtColor.getText();
        return true;
    }//getInfo
    
    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        if(getInfo()==false){return;}
        if(manager_permisos.alta_inventario(Principal.Username)){
            
            if(manager_inventario.insertarInventario(clave, producto, almacen, marca, noserie, descripcion, observaciones,tipo,modelo,color)){
                JOptionPane.showMessageDialog(null,"Se inserto correctamente al inventario");
                
                if(manager_permisos.consulta_inventario(Principal.Username)){
                    Principal.tablaInventario.setModel(manager_inventario.getInventario());
                }
                
            }else{
                JOptionPane.showMessageDialog(null,"Verificar con el distribuidor.");
            }
            
        }else{
            JOptionPane.showMessageDialog(null,"Le han revocado los permisos para registrar un producto al inventario.");
        }
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void txtClaveFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_txtClaveFocusLost
        // TODO add your handling code here:
        if(!(txtClave.getText().isEmpty())){
            
            //Comparamos si existe o no
            if(manager_inventario.existeInventario(txtClave.getText())){
                //Existe, entonces pintamos en rojo los TextField
                txtClave.setBackground(java.awt.Color.RED);
                btnAceptar.setEnabled(false);
                lblAviso.setText("La clave ya se encuentra registrada.");
                
            }else{
                //Si no existe, entonces pintamos de verde los TextField
                txtClave.setBackground(java.awt.Color.GREEN);
                btnAceptar.setEnabled(true);
                lblAviso.setText("");
            }
            
        }//Buscar si existe o no
        else{
            txtClave.setBackground(java.awt.Color.WHITE);
            btnAceptar.setEnabled(true);
            lblAviso.setText("");
        }
    }//GEN-LAST:event_txtClaveFocusLost

    private void txtTipoUsoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoUsoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoUsoActionPerformed

    private void txtModeloActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtModeloActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloActionPerformed

    private void txtColorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtColorActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtColorActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
         // TODO add your handling code here:
         this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

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
            java.util.logging.Logger.getLogger(addInventarioGranel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(addInventarioGranel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(addInventarioGranel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(addInventarioGranel.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                addInventarioGranel dialog = new addInventarioGranel(new javax.swing.JFrame(), true);
                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
                    @Override
                    public void windowClosing(java.awt.event.WindowEvent e) {
                        System.exit(0);
                    }
                });
                dialog.setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAceptar;
    private javax.swing.JButton btnCancelar;
    private javax.swing.JComboBox cb_almacen;
    private javax.swing.JComboBox<String> comboProducto;
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
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JLabel lblAviso;
    private javax.swing.JPanel pn_addInventario;
    private javax.swing.JTextArea txtAreaDescripcion;
    private javax.swing.JTextArea txtAreaObservaciones;
    private javax.swing.JTextField txtClave;
    private javax.swing.JTextField txtColor;
    private javax.swing.JTextField txtMarca;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNoSerie;
    private javax.swing.JTextField txtTipoUso;
    // End of variables declaration//GEN-END:variables
}
