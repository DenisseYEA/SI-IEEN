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
public class ManejadorInventario {
    private Connection conexion;
    private Conexion db;
    
    public ManejadorInventario(){
        db = new Conexion();
    }//constructor
    
    public DefaultTableModel getInventarioG() {
        
        DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Clave");
            table.addColumn("Producto");
            table.addColumn("Descripción");
            table.addColumn("Almacén");
            table.addColumn("Marca");
            table.addColumn("Observaciones");
            table.addColumn("Stock");
            
            
            //Consulta de los empleados
            String sql = "select id_productoGranel,nombre_prod,descripcion,almacen,marca,observaciones,stock from Inventario_granel where estatus = 'DISPONIBLE';";
            conexion = db.getConexion();
            Statement st = conexion.createStatement();
            Object datos[] = new Object[7];
            ResultSet rs = st.executeQuery(sql);

            //Llenar tabla
            while (rs.next()) {

                for(int i = 0;i<7;i++){
                    datos[i] = rs.getObject(i+1);
                }//Llenamos las columnas por registro

                table.addRow(datos);//Añadimos la fila
           }//while
            conexion.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla Inventario SQL");
            Logger.getLogger(ManagerUsers.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

    }//getInventarioG

    public DefaultTableModel getInventario() {
        String orden = "";
        DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Clave");
            table.addColumn("Producto");
            table.addColumn("Descripción");
            table.addColumn("Almacén");
            table.addColumn("Marca");
            table.addColumn("No. Serie");
            table.addColumn("Observaciones");
            table.addColumn("Modelo");
            table.addColumn("Color");
            //Consulta de los empleados
            String sql = "select id_producto,nombre_prod,descripcion,almacen,marca,no_serie,observaciones,modelo,color from inventario where estatus = 'DISPONIBLE';";
            conexion = db.getConexion();
            Statement st = conexion.createStatement();
            Object datos[] = new Object[9];
            ResultSet rs = st.executeQuery(sql);

            //Llenar tabla
            while (rs.next()) {

                for(int i = 0;i<9;i++){
                    datos[i] = rs.getObject(i+1);
                }//Llenamos las columnas por registro

                table.addRow(datos);//Añadimos la fila
           }//while
            conexion.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla Inventario SQL");
            Logger.getLogger(ManagerUsers.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

    }//getInventario
    
    public int cantidadInventarioG(String id_producto) {

        int cantidad;
        
        try {
            //Consulta para saber si existe o no dicho producto
            String sql = "select stock from inventario_Granel where id_productoGranel = '"+id_producto+"';";
            conexion = db.getConexion();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            rs.next();//Guardamos el resultado para retornar la respuesta.
            cantidad = rs.getInt(1);
            conexion.close();
            return cantidad;
        } catch (SQLException ex) {
            System.out.printf("Error al consultar el inventario en SQL");
            Logger.getLogger(ManagerUsers.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        } 

    }//cantidadInventarioG
    
    public int productosSuficientesInventarioG(String id_producto,int cantidad) {
        int stock = 0;
        try {
            //Hacemos el update de la resta del inventario
            String sql = "update inventario_Granel set stock = stock - "+cantidad+" where id_productoGranel = '"+id_producto+"' and stock > "+cantidad+";";
            conexion = db.getConexion();
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            //Obtenemos el stock del producto para saber si se realizo o no el update
            sql = "select stock from inventario_Granel where id_productoGranel = '"+id_producto+"';";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            stock = rs.getInt(1);
            conexion.close();
            return stock;
        } catch (SQLException ex) {
            System.out.printf("Error al consultar el inventario en SQL");
            Logger.getLogger(ManagerUsers.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }//productosSuficientesInventarioG
    
    public int productosIgualesInventarioG(String id_producto,int cantidad) {
        int stock = 0;
        try {
            //Hacemos el update de la resta del inventario
            String sql = "update inventario_Granel set stock = 0,estatus = 'AGOTADO' where id_productoGranel = '"+id_producto+"' and stock = "+cantidad+";";
            conexion = db.getConexion();
            Statement st = conexion.createStatement();
            st.executeUpdate(sql);
            //Obtenemos el stock del producto para saber si se realizo o no el update
            sql = "select stock from inventario_Granel where id_productoGranel = '"+id_producto+"';";
            ResultSet rs = st.executeQuery(sql);
            rs.next();
            stock = rs.getInt(1);
            conexion.close();
            return stock;
        } catch (SQLException ex) {
            System.out.printf("Error al consultar el inventario en SQL");
            Logger.getLogger(ManagerUsers.class.getName()).log(Level.SEVERE, null, ex);
            return -1;
        }
    }//productosIgualesInventarioG
    
    public boolean regresarInventario(String[] Claves,int[] Cantidad){
        
        try{
                String sql = "";
                conexion = db.getConexion();
                Statement st = conexion.createStatement();
                ResultSet rs;
                for(int i = 0; i < Claves.length; i++){
                    //Buscamos si es de inventario o de granel
                    sql = "select * from inventario where id_producto = '"+Claves[i]+"';";
                    rs = st.executeQuery(sql);
                    System.out.println("Hicimos la consulta para ver si es inventario o granel");
                    //Si entra es a inventario
                    if(rs.next()){
                        sql = "update inventario set estatus = 'DISPONIBLE' where id_producto = '"+Claves[i]+"';";
                        st.executeUpdate(sql);
                        System.out.println("Es a granel y cambio el estatus a disponible");
                    }
                    //Si no entra es a granel
                    else{
                        sql = "update inventario_granel set stock = stock + "+Cantidad[i]+" where id_productoGranel = '"+Claves[i]+"' and stock > 0;";
                        st.executeUpdate(sql);
                        System.out.println("Llego a querer hacer el update para sumarle la cantidad que se le quito");
                        
                        sql = "update inventario_granel set estatus = 'DISPONIBLE', stock = "+Cantidad[i]+" where id_productoGranel = '"+Claves[i]+"' and stock = 0;";
                        st.executeUpdate(sql);
                        System.out.println("Llego a querer hacer el update para ponerlo disponible si el stock es 0");
                    }
                }//for
                conexion.close();
        } //try  
        catch (SQLException ex) {
            Logger.getLogger(ManagerAsignarEquipo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true; //Da una respuesta positiva del incremento del inventario de ese producto 
        
    }//Regresa los productos a su estado orignal (estatus y/o cantidad)
    
    public boolean asignarInventario(String[] Claves,int[] Cantidad,String empleado){
        
        try{
                String sql = "";
                conexion = db.getConexion();
                Statement st = conexion.createStatement();
                ResultSet rs;
                
                //Obtenemos la fecha y hora exacta del sistema
                sql = "select now();";
                rs = st.executeQuery(sql);
                rs.next();
                String fecha = rs.getString(1);
                
                //Obtenemos el id del empleado para encontrar el usuario
                sql = "select u.id_user from user u inner join empleados e on(e.id_empleado = u.id_empleado) "
                    + "where concat(e.nombres,' ',e.apellido_p,' ',e.apellido_m) = '"+empleado+"';";
                rs = st.executeQuery(sql);
                rs.next();
                String usuario = rs.getString(1);
                
                //Insertamos el registro del vale de asignación
                sql = "insert into vales (tipo_vale,fecha_vale,id_user) values('Vale de asignación','"+fecha+"','"+usuario+"');";
                st.executeUpdate(sql);
                
                //Obtenemos el id del vale que se acaba de crear
                sql = "select id_vale from vales where fecha_vale = '"+fecha+"';";
                rs = st.executeQuery(sql);
                rs.next();
                int idVale = rs.getInt(1);
                
                for(int i = 0; i < Claves.length; i++){
                    //Insertamos los datos en la tabla "detalle_vale"
                    sql = "insert into detalle_vale (id_vale,id_producto,cantidad)values("+idVale+",'"+Claves[i]+"',"+Cantidad[i]+");";
                    st.executeUpdate(sql);
                    
                }//for
                conexion.close();
                return true;
        } //try  
        catch (SQLException ex) {
            Logger.getLogger(ManagerAsignarEquipo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
    }//Regresa los productos a su estado orignal (estatus y/o cantidad)
    
    public void getEmpleadosAsignacion(JComboBox combo) {
        try{
           
            String sql = "select concat(e.nombres,' ',e.apellido_p,' ',e.apellido_m) as Empleado from empleados e inner join user u on (e.id_empleado = u.id_empleado) where u.id_user in (select v.id_user from vales v inner join user u on (u.id_user = v.id_user) inner join empleados e on (e.id_empleado = u.id_empleado) inner join detalle_vale dv on (dv.id_vale = v.id_vale) inner join inventario_granel ig on (dv.id_producto = ig.id_productoGranel) group by v.id_user);";
            conexion = db.getConexion();
            Statement st = conexion.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while(rs.next()){
                combo.addItem(rs.getObject(1).toString());
            }
            
            conexion.close();
        } catch (SQLException ex) {
            System.out.printf("Error al obtener los nombres de los empleados para ingresarlos al combo SQL");
            Logger.getLogger(ManagerUsers.class.getName()).log(Level.SEVERE, null, ex);
        } 
        
    }//Obtiene todas los nombres de los empleados que tienen productos asignados
    
    public DefaultTableModel getInventarioEmpleadoAsignaciones(String empleado) {
            DefaultTableModel table = new DefaultTableModel();

        try {
            table.addColumn("Vale");
            table.addColumn("Clave");
            table.addColumn("Producto");
            table.addColumn("Descripción");
            table.addColumn("Observaciones");
            table.addColumn("Cantidad");
            
            //Obtiene los productos asignados de acuerdo al empleado (Inventario)
            String sql = "select v.id_vale, dv.id_producto, ig.nombre_prod,ig.descripcion,ig.observaciones,dv.cantidad from vales v inner join detalle_vale dv on (dv.id_vale = v.id_vale) inner join inventario ig on (dv.id_producto = ig.id_producto) inner join user u on (u.id_user = v.id_user) inner join empleados e on (e.id_empleado = u.id_empleado) where concat(e.nombres,' ',e.apellido_p,' ',e.apellido_m)= '"+empleado+"';";
            conexion = db.getConexion();
            Statement st = conexion.createStatement();
            Object datos[] = new Object[6];
            ResultSet rs = st.executeQuery(sql);

            //Llenar tabla
            while (rs.next()) {

                for(int i = 0;i<6;i++){
                    datos[i] = rs.getObject(i+1);
                }//Llenamos las columnas por registro

                table.addRow(datos);//Añadimos la fila
            }//while
            
            //Obtiene los productos asignados de acuerdo al empleado (Inventario a granel)
            sql = "select v.id_vale, dv.id_producto, ig.nombre_prod,ig.descripcion,ig.observaciones,dv.cantidad from vales v inner join detalle_vale dv on (dv.id_vale = v.id_vale) inner join inventario_granel ig on (dv.id_producto = ig.id_productoGranel) inner join user u on (u.id_user = v.id_user) inner join empleados e on (e.id_empleado = u.id_empleado) where concat(e.nombres,' ',e.apellido_p,' ',e.apellido_m)= '"+empleado+"';";
            conexion = db.getConexion();
            rs = st.executeQuery(sql);

            //Llenar tabla
            while (rs.next()) {

                for(int i = 0;i<6;i++){
                    datos[i] = rs.getObject(i+1);
                }//Llenamos las columnas por registro

                table.addRow(datos);//Añadimos la fila
           }//while
            
            conexion.close();
        } catch (SQLException ex) {
            System.out.printf("Error getTabla Inventario SQL");
            Logger.getLogger(ManagerUsers.class.getName()).log(Level.SEVERE, null, ex);
        } finally {

            return table;
        }

    }//getInventarioEmpleadoAsignaciones
    
    public boolean recoleccionInventario(int idVale,String idProducto,int cantidad, int restantes){
        
        try{
                String sql = "";
                conexion = db.getConexion();
                Statement st = conexion.createStatement();
                ResultSet rs;
                
                //Regresamos el producto (Ya sea a inventario o inventario a granel)
                sql = "select * from inventario where id_producto = '"+idProducto+"';";
                rs = st.executeQuery(sql);
                //Si entra es a inventario
                if(rs.next()){
                    sql = "update inventario set estatus = 'DISPONIBLE' where id_producto = '"+idProducto+"';";
                    st.executeUpdate(sql);
                }
                //Si no entra es a granel
                else{
                    sql = "update inventario_granel set stock = stock + "+cantidad+" where id_productoGranel = '"+idProducto+"' and stock > 0;";
                    st.executeUpdate(sql);

                    sql = "update inventario_granel set estatus = 'DISPONIBLE', stock = "+cantidad+" where id_productoGranel = '"+idProducto+"' and stock = 0;";
                    st.executeUpdate(sql);
                }
                
                sql = "select * from productosEntregados where id_vale = "+idVale+" and id_producto = '"+idProducto+"';";
                rs = st.executeQuery(sql);
                //Si el registro existe entonces solo sumamos la cantidad entregada
                if(rs.next()){
                    sql = "update productosEntregados set cantidad = cantidad + "+cantidad+" where id_vale = "+idVale+" and id_producto = '"+idProducto+"';";
                    st.executeUpdate(sql);
                }
                //Si el registro no existe entonces hacemos el nuevo registro en la tabla "productosEntregados"
                else{
                    sql = "insert into productosEntregados values("+idVale+",'"+idProducto+"',"+cantidad+");";
                    st.executeUpdate(sql);
                }
                
                //Actualizamos o eliminamos el registro segun corresponda en la tabla "detalle_vale" 
                //Si es 0 entonces ya no quedan mas producto por entregar, se elimina de la tabla
                if(restantes == 0){
                    sql = "delete from detalle_vale where id_vale = "+idVale+" and id_producto = '"+idProducto+"';";
                    st.executeUpdate(sql);
                }
                //Si es mas de 0 entocnes solo actualizamos la cantidad que le falta
                else{
                    sql = "update detalle_vale set cantidad = "+restantes+" where id_vale = "+idVale+" and id_producto = '"+idProducto+"';";
                    st.executeUpdate(sql);
                }
                conexion.close();
        } //try  
        catch (SQLException ex) {
            Logger.getLogger(ManagerAsignarEquipo.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        
        return true;
        
    }//Regresa los productos a su estado orignal (estatus y/o cantidad)
    
}//class