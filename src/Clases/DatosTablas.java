package Clases;

import app.Conexion;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author Sebas
 */
public class DatosTablas {

    public void CargarTabla(JTable tabla, int[] anchos, String cmd) {
        DefaultTableModel modeloTabla = (DefaultTableModel) tabla.getModel();
        modeloTabla.setRowCount(0);
        PreparedStatement ps;
        ResultSet rs;
        ResultSetMetaData rsmd;
        int columnas;
        if (anchos != null) {
            for (int i = 0; i < tabla.getColumnCount(); i++) {
                tabla.getColumnModel().getColumn(i).setPreferredWidth(anchos[i]);
            }
        }

        try {
            Connection con = Conexion.getConexion();
            ps = con.prepareStatement(cmd);
            //ps = con.prepareStatement("SELECT id,matricula,nombre,sexo,email from alumnos where activo=1");
            //ps = con.prepareStatement({call nombre_del_procedimiento(?, ?, ?)});
            // String procedimientoAlmacenado = "{call nombre_del_procedimiento(?, ?, ?)}";
            //CallableStatement ps = conexion.prepareCall(procedimientoAlmacenado);
            rs = ps.executeQuery();
            rsmd = rs.getMetaData();
            columnas = rsmd.getColumnCount();
            while (rs.next()) {
                Object[] fila = new Object[columnas];
                for (int indice = 0; indice < columnas; indice++) {
                    fila[indice] = rs.getObject(indice + 1);
                }
                modeloTabla.addRow(fila);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

    //funcion de la clase DatoTablas para asignar datos a los combobox de las distintas pantallas
    public void cargarComboBox(String cmd, String campo, JComboBox cmbDestino) {
        PreparedStatement ps;
        ResultSet rs;
        try {
            Connection con = Conexion.getConexion();
            ps = con.prepareStatement(cmd);
            rs = ps.executeQuery();
            while (rs.next()) {
                String dato = rs.getString(campo);
                cmbDestino.addItem(dato);
            }
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }

}
