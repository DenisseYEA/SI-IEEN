/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author kevin
 */
public class ManagerComplemento {
    
    private Connection conexion;
    private Conexion db;
    
    public ManagerComplemento(){
        
        db = new Conexion();
        
    }//Constructor
    
    public DefaultTableModel getPuestos() {

        DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Puestos");
            
            //Consulta de los empleados
            String sql = "select * from Puestos;";
            conexion = db.getConexion();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            //Llenar tabla
            while (rs.next()) {
                table.addRow(new Object[]{rs.getObject(1)});//Añadimos la fila
           }//while

            //Cerramos la conexión
            conexion.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla Inventario SQL");
            Logger.getLogger(ManagerUsers.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

    }//getPuestos
    
    public DefaultTableModel getAreas() {

        DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Áreas");
            
            //Consulta de los empleados
            String sql = "select * from Area;";
            conexion = db.getConexion();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);

            //Llenar tabla
            while (rs.next()) {
                table.addRow(new Object[]{rs.getObject(1)});//Añadimos la fila
           }//while

            //Cerramos la conexión
            conexion.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla Inventario SQL");
            Logger.getLogger(ManagerUsers.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

    }//getAreas
    
    public void getComboPuestos(JComboBox combo) {
        try{
           
            String sql = "select * from Puestos;";
            conexion = db.getConexion();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                combo.addItem(rs.getObject(1).toString());
            }
            
            conexion.close();
        } catch (SQLException ex) {
            System.out.printf("Error al obtener los puestos para ingresarlos al combo SQL");
            Logger.getLogger(ManagerUsers.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//Obtiene todas los puestos y las mete al combobox
    
    public void getComboAreas(JComboBox combo) {
        try{
           
            String sql = "select * from Area;";
            conexion = db.getConexion();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                combo.addItem(rs.getObject(1).toString());
            }
            
            conexion.close();
        } catch (SQLException ex) {
            System.out.printf("Error al obtener las áreas para ingresarlos al combo SQL");
            Logger.getLogger(ManagerUsers.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//Obtiene todas los puestos y las mete al combobox
    
    public DefaultTableModel getResguardoPersonal(String usuario) {

        DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Producto");
            table.addColumn("Fecha de ingreso");
            table.addColumn("Observaciones");
            
            //Consulta de los empleados
            String sql = "select nombre_prod,date(fecha_alta),observaciones from resguardo_personal where id_user = '"+usuario+"';";
            conexion = db.getConexion();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            Object[] datos = new Object[3];
            
            //Llenar tabla
            while (rs.next()) {
                
                for(int i = 0;i<3;i++){
                    datos[i] = rs.getString(i+1);
                }
                
                table.addRow(datos);//Añadimos la fila
           
            }//while

            //Cerramos la conexión
            conexion.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla Inventario SQL");
            Logger.getLogger(ManagerUsers.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

    }//getResguardoPersonal
    
    public boolean insertarResguardo(String usuario,String producto,String observaciones) {
        try{
           
            String sql = "insert into resguardo_personal values('"+usuario+"','"+producto+"',now(),'"+observaciones+"');";
            conexion = db.getConexion();
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            
            conexion.close();
            
            return true;
            
        } catch (SQLException ex) {
            System.out.printf("Error al obtener las áreas para ingresarlos al combo SQL");
            Logger.getLogger(ManagerUsers.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        } 
        
    }//Obtiene todas los puestos y las mete al combobox
    
}//class
