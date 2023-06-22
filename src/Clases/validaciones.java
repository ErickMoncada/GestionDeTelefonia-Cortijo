package Clases;

import java.awt.Color;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextField;

/**
 *
 * @ErickMoncada clase para mostrar y cambiar estilo de campos cuando aparece un error
 */
public class validaciones {

    //se establece que un textfield esta correcto se recive el TextField para el color de fuente y el Label del error para ponerlo invisible
    public void TXTcorrecto(JTextField campo,JLabel msj) {
        campo.setForeground(Color.BLACK);
        msj.setVisible(false);
    }

    //establece que un textfield esta incorrecto se recive el TextField, el Label del error y un String para el mensaje del error
    public void TXTincorrecto(JTextField campo,JLabel msj,String MsjError) {
        campo.setForeground(Color.RED);
        msj.setText(MsjError);
        msj.setVisible(true);
    }

    //se establece un combobox correcto se recive el JComboBox que se esta validando y el Label del error
    public void CMBcorrecto(JComboBox campo,JLabel msj) {
        campo.setForeground(Color.BLACK);
        msj.setVisible(false);
    }

    //se establece que un combobox esta incorrecto se recive el JComboBox que se esta validando y el Label del error
    public void CMBincorrecto(JComboBox campo,JLabel msj,String MsjError) {
            campo.setForeground(Color.RED);
            msj.setText(MsjError);
            msj.setVisible(true);
    }
    
    // (general) se establece que un campo diferente a textbox o a label esta incorrecto manipulando solo su label de error
    public void GENIncorrecto(JLabel msj,String MsjError) {
            msj.setText(MsjError);
            msj.setVisible(true);
    }
    //se establece que un campo diferente a textbox o a label esta correcto manipulando solo su label de error
     public void GENcorrecto(JLabel msj) {
            msj.setVisible(false);
    }

}
