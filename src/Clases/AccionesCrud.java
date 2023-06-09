package Clases;

import app.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class AccionesCrud {

    //Funcion para Validar campos
    public boolean Validar(JTextField campo, String elemento) {
        if (campo.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(null, elemento + " no puede estar en blanco", "Advertencia", JOptionPane.WARNING_MESSAGE);
            return false;
        }
        return true;
    }
    //Modificar datos a la BD por medio de Procedimientos Almacenados
    public boolean Modificar(JTextField txtdato, JTextField txtID, String exec) {
        String dato = txtdato.getText();
        String id = txtID.getText();

        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(exec);
            ps.setString(1, id);
            ps.setString(2, dato);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Actualizado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ups! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    //Agregar datos a la BD por medio de Procedimientos Almacenados
    public boolean Guardar(JTextField txtdato, String exec) {
        String dato = txtdato.getText();
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(exec);
            ps.setString(1, dato);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro guardado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Ups! " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            return false;
        }
    }
    //Eliminar datos a la BD por medio de Procedimientos Almacenados
    public boolean Eliminar(JTextField txtID,String exec,String AsignadoA){
    String id = txtID.getText();
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps = con.prepareStatement(exec);
            ps.setString(1, id);
            ps.executeUpdate();
            JOptionPane.showMessageDialog(null, "Registro Eliminado", "Informacion", JOptionPane.INFORMATION_MESSAGE);
            return true;
        } catch (SQLException e) {
            int error = e.getErrorCode();
            if (error == 547) {
                JOptionPane.showMessageDialog(null, "NO se puede Eliminar por que esta asignado a un "+AsignadoA, "Error", JOptionPane.ERROR_MESSAGE);
            } else {
                JOptionPane.showMessageDialog(null, e.toString());
            }
            return false;
        }
    }
    //Cargar datos al textfield cuando se preciona click en una celda
    public boolean CargarDatoClick(JTable tblCentro,String exec,String ExecCampo,String ExecId,JTextField campo,JTextField ID){
     try {
            int fila = tblCentro.getSelectedRow();
            String dato = tblCentro.getValueAt(fila, 0).toString();
            PreparedStatement ps;
            ResultSet rs;
            Connection con = Conexion.getConexion();
            ps = con.prepareStatement(exec);
            ps.setString(1, dato);
            rs = ps.executeQuery();
            while (rs.next()) {
                campo.setText(rs.getString(ExecCampo));
                ID.setText(rs.getString(ExecId));
            }
            return true;
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
            return false;
        }
    
    }
}
