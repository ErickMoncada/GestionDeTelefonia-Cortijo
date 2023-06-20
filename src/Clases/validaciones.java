/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Clases;

import com.toedter.calendar.JDateChooser;
import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @author Sebas
 */
public class validaciones {

    public void TXTcorrecto(JTextField campo,JLabel msj) {
        campo.setForeground(Color.BLACK);
        msj.setVisible(false);
    }

    public void TXTincorrecto(JTextField campo,JLabel msj,String MsjError) {
        campo.setForeground(Color.RED);
        msj.setText(MsjError);
        msj.setVisible(true);
    }

    public void CMBcorrecto(JComboBox campo,JLabel msj) {
        campo.setForeground(Color.BLACK);
        msj.setVisible(false);
    }

    public void CMBincorrecto(JComboBox campo,JLabel msj,String MsjError) {
            campo.setForeground(Color.RED);
            msj.setText(MsjError);
            msj.setVisible(true);
    }
    public void DTPIncorrecto(JLabel msj,String MsjError) {
            msj.setText(MsjError);
            msj.setVisible(true);
    }
     public void DTPcorrecto(JLabel msj) {
            msj.setVisible(false);
    }

}
