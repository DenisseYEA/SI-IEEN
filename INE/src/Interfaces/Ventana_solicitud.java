/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Interfaces;

import Clases.ManagerSolicitud;
import Clases.ManagerInventario;
import Interfaces.Principal;
import javax.swing.JOptionPane;
/**
 *
 * @author kevin
 */
public class Ventana_solicitud extends javax.swing.JDialog {
    
    ManagerSolicitud manager_solicitud;
    ManagerInventario manager_inventario;
    
    String producto,motivo,tipo,usuario;
    int cantidad;
    /**
     * Creates new form Ventana_solicitudBaja
     */
    public Ventana_solicitud(java.awt.Dialog parent, boolean modal) {
        super(parent, modal);
        initComponents();
        
        //Asignamos memoria al objeto
        manager_solicitud = new ManagerSolicitud();
        manager_inventario = new ManagerInventario();
        if(Principal.banderaSolicitud == 1){
            txtProducto.setText(tablaDetalleInventario.clave);
        }else{
            txtProducto.setText(Ventana_EquipoComputo.Clave);
        }
        txtUsuario.setText(Principal.Username);
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

        pn_solicitud = new javax.swing.JPanel();
        lblSolicitud = new javax.swing.JLabel();
        txtUsuario = new javax.swing.JTextField();
        lblSolicitud2 = new javax.swing.JLabel();
        lblSolicitud3 = new javax.swing.JLabel();
        txtCantidad = new javax.swing.JTextField();
        lblSolicitud4 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        txtAMotivo = new javax.swing.JTextArea();
        lblSolicitud5 = new javax.swing.JLabel();
        txtProducto = new javax.swing.JTextField();
        btnAceptar = new javax.swing.JButton();
        btnCancelar = new javax.swing.JButton();
        txtTipoSolicitud = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        pn_solicitud.setLayout(null);

        lblSolicitud.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSolicitud.setText("Tipo de solicitud:");
        pn_solicitud.add(lblSolicitud);
        lblSolicitud.setBounds(30, 20, 102, 17);

        txtUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtUsuario.setEnabled(false);
        pn_solicitud.add(txtUsuario);
        txtUsuario.setBounds(140, 80, 200, 23);

        lblSolicitud2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSolicitud2.setText("Usuario que solicita:");
        pn_solicitud.add(lblSolicitud2);
        lblSolicitud2.setBounds(10, 80, 120, 17);

        lblSolicitud3.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSolicitud3.setText("Cantidad:");
        pn_solicitud.add(lblSolicitud3);
        lblSolicitud3.setBounds(70, 110, 59, 17);

        txtCantidad.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCantidad.setText("1");
        txtCantidad.setEnabled(false);
        pn_solicitud.add(txtCantidad);
        txtCantidad.setBounds(140, 110, 200, 23);

        lblSolicitud4.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSolicitud4.setText("Motivo:");
        pn_solicitud.add(lblSolicitud4);
        lblSolicitud4.setBounds(10, 140, 46, 17);

        txtAMotivo.setColumns(20);
        txtAMotivo.setRows(5);
        jScrollPane1.setViewportView(txtAMotivo);

        pn_solicitud.add(jScrollPane1);
        jScrollPane1.setBounds(10, 160, 330, 220);

        lblSolicitud5.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        lblSolicitud5.setText("Clave producto:");
        pn_solicitud.add(lblSolicitud5);
        lblSolicitud5.setBounds(30, 50, 99, 17);

        txtProducto.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtProducto.setEnabled(false);
        pn_solicitud.add(txtProducto);
        txtProducto.setBounds(140, 50, 200, 23);

        btnAceptar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnAceptar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/aceptar.png"))); // NOI18N
        btnAceptar.setText(" Aceptar");
        btnAceptar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAceptarActionPerformed(evt);
            }
        });
        pn_solicitud.add(btnAceptar);
        btnAceptar.setBounds(30, 400, 140, 33);

        btnCancelar.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        btnCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Iconos/cancelar.png"))); // NOI18N
        btnCancelar.setText("Cancelar");
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });
        pn_solicitud.add(btnCancelar);
        btnCancelar.setBounds(190, 400, 140, 33);

        txtTipoSolicitud.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtTipoSolicitud.setEnabled(false);
        txtTipoSolicitud.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtTipoSolicitudActionPerformed(evt);
            }
        });
        pn_solicitud.add(txtTipoSolicitud);
        txtTipoSolicitud.setBounds(140, 20, 200, 23);

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Imagenes/formularios.png"))); // NOI18N
        pn_solicitud.add(jLabel1);
        jLabel1.setBounds(0, 0, 360, 450);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_solicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(pn_solicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 442, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnAceptarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAceptarActionPerformed
        // TODO add your handling code here:
        
        //Obtenemos la info
        getInfo();
        //Registramos la solicitud
        if(manager_solicitud.registro_Solicitud(producto, tipo, usuario, motivo, cantidad)){
            JOptionPane.showMessageDialog(null, "La solicitud ha sido generada");
            tablaDetalleInventario.tablaCoincidencias.setModel(manager_inventario.getInventarioCoincidencias(Principal.prodInventario));
            
            this.dispose();
        }//registro_solicitud
        else{
            JOptionPane.showMessageDialog(null, "Verificar con el distribuidor");
        }
        
    }//GEN-LAST:event_btnAceptarActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        // TODO add your handling code here:
        if(Principal.banderaSolicitud == 1){
            txtTipoSolicitud.setText(tablaDetalleInventario.tipoSolicitud);
        }else{
            txtTipoSolicitud.setText(Ventana_EquipoComputo.tipo_solicitud);
        }
    }//GEN-LAST:event_formWindowOpened

    private void txtTipoSolicitudActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtTipoSolicitudActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtTipoSolicitudActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        // TODO add your handling code here:
        this.dispose();
    }//GEN-LAST:event_btnCancelarActionPerformed

    public void getInfo(){
    
        producto = txtProducto.getText();
        tipo = txtTipoSolicitud.getText();
        usuario = txtUsuario.getText();
        cantidad = Integer.parseInt(txtCantidad.getText());
        motivo = txtAMotivo.getText();
        
    }//getInfo
    
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
            java.util.logging.Logger.getLogger(Ventana_solicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Ventana_solicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Ventana_solicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Ventana_solicitud.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the dialog */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                Ventana_solicitud dialog = new Ventana_solicitud(new javax.swing.JDialog(), true);
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
    private javax.swing.JLabel jLabel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblSolicitud;
    private javax.swing.JLabel lblSolicitud2;
    private javax.swing.JLabel lblSolicitud3;
    private javax.swing.JLabel lblSolicitud4;
    private javax.swing.JLabel lblSolicitud5;
    private javax.swing.JPanel pn_solicitud;
    private javax.swing.JTextArea txtAMotivo;
    private javax.swing.JTextField txtCantidad;
    private javax.swing.JTextField txtProducto;
    private javax.swing.JTextField txtTipoSolicitud;
    private javax.swing.JTextField txtUsuario;
    // End of variables declaration//GEN-END:variables
}
