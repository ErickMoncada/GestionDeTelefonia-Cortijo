package paneles;

import Clases.AccionesCrud;
import Clases.DatosTablas;
import Clases.validaciones;
import app.Conexion;
import java.awt.Component;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.DefaultTableModel;
import paneles.ExtraEquipos.Categoria;
import paneles.ExtraEquipos.Estado;
import paneles.ExtraEquipos.LugarCompra;
import paneles.ExtraEquipos.Marca;
import paneles.ExtraEquipos.Tipo;

public class pnlEquipos extends javax.swing.JPanel {

    public pnlEquipos(String NIVEL) {
        initComponents();
        CargarDatosPrincipal();
        Limpiar();
        asignarEventos();
        if ("Lector".equals(NIVEL)) {
            jPanel1.setVisible(false);
        }
        NivelAcceso = NIVEL;
    }
    //se inicializa para la busqueda por medio de Imei
    String Busqueda = "Imei";
    //se Inicializa la variabl del nivel para tneerlo en el Jframe
    String NivelAcceso;
    //se inicializa la clase de validaciones
    validaciones val = new validaciones();

    private void Limpiar() {
        //funcion para reiniciar todos los valores de la pantalla
        btnCancelar.setVisible(false);
        btnModificar.setVisible(false);
        btnEliminar.setVisible(false);
        btnGuardar.setVisible(true);
        txtNumIMEI.enable(true);

        txtNumIMEI.setText("");
        txtNumExpediente.setText("");
        cmbEstado.setSelectedIndex(-1);
        cmbTipo.setSelectedIndex(-1);
        cmbCategoria.setSelectedIndex(-1);
        cmbMarca.setSelectedIndex(-1);
        cmbLugar.setSelectedIndex(-1);
        txtAccesorio.setText("");
        txtModelo.setText("");
        txtCosto.setText("");
        txtNumFactura.setText("");
        txtComentario.setText("");
        dtpPrestamo.setDate(null);
        dtpCompra.setDate(null);
        LimpiarErrores();
    }

    private void asignarEventos() {
        //funcion para asignar los eventos a los mensajes de obligatorio con la clase de validaciones
        val.asignarEventosMouse(lblObligatorio);
        val.asignarEventosMouse(lblObligatorio1);
        val.asignarEventosMouse(lblObligatorio2);
        val.asignarEventosMouse(lblObligatorio3);
        val.asignarEventosMouse(lblObligatorio4);
        val.asignarEventosMouse(lblObligatorio5);
        val.asignarEventosMouse(lblObligatorio6);
        val.asignarEventosMouse(lblObligatorio7);
        val.asignarEventosMouse(lblObligatorio8);
    }

    //funcion para reducir la repeticion del select
    private void CargarDatosTabla(){
     //rellenar datos de la tabla
        DatosTablas Datos = new DatosTablas();
        Datos.CargarTabla(tblEquipos, "select [UsuarioDeLinea]\n"
                + "      ,[CentroCosto]\n"
                + "      ,[NumeroExpediente]\n"
                + "      ,[FechaPrestamo]\n"
                + "      ,[Tipo]\n"
                + "      ,[Codigo]\n"
                + "      ,[Categoria]\n"
                + "      ,[Marca]\n"
                + "      ,[Modelo]\n"
                + "      ,[Imei]\n"
                + "      ,[Accesorio]\n"
                + "      ,[Estado del Equipo]\n"
                + "      ,[Lugar]\n"
                + "      ,[FechaCompra]\n"
                + "      ,[CostoEquipo]\n"
                + "      ,[NumDoc]\n"
                + "      ,[Comentario]\n"
                + "       from [VistaEquipos] where " + Busqueda + " LIKE '%" + txtBuscar.getText().trim() + "%'");
    }
    private void CargarDatosPrincipal() {
       CargarDatosTabla();
        //llenar los datos de los combobox
        CargarListas();
        //obtener la hora del ser5vidor para poner de limite
        try {
            Connection con = Conexion.getConexion();
            PreparedStatement ps;
            ps = con.prepareStatement("SELECT GETDATE() AS HoraActual");
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                Timestamp serverTime = rs.getTimestamp("HoraActual");
                Date maxDate = new Date(serverTime.getTime());
                dtpPrestamo.setMaxSelectableDate(maxDate);
                dtpCompra.setMaxSelectableDate(maxDate);
            }
        } catch (SQLException ex) {
            Logger.getLogger(pnlEquipos.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void LimpiarErrores() {
        //usando la clase de validaciones se establecen los valores en correcto
        val.TXTcorrecto(txtNumIMEI, lblErImei);
        val.TXTcorrecto(txtNumExpediente, lblErExpediente);
        val.CMBcorrecto(cmbEstado, lblErEstado);
        val.CMBcorrecto(cmbTipo, lblErTipo);
        val.GENcorrecto(lblErDatePrestamo);
        val.CMBcorrecto(cmbCategoria, lblErCategoria);
        val.CMBcorrecto(cmbMarca, lblErMarca);
        val.TXTcorrecto(txtModelo, lblErModelo);
        val.CMBcorrecto(cmbLugar, lblErLugar);
    }

    private boolean ValidarCampos() {

        int valor1 = 1;
        String error;
        //validar que no este vacio u otro parametro mas
        if (txtNumIMEI.getText().isEmpty() || !txtNumIMEI.getText().matches("\\d{15}")) {
            //asignar 0 al valor para devolver falso en la validacion
            valor1 = 0;
            //mensaje de error para el respectivo campo de texto
            error = "Debe llenar los 15 caracteres del IMEI";
            //asignar colores de error a cada campo
            val.TXTincorrecto(txtNumIMEI, lblErImei, error);
        }
        if (txtNumExpediente.getText().isEmpty()) {
            valor1 = 0;
            error = "Debe escribir un expediente";
            val.TXTincorrecto(txtNumExpediente, lblErExpediente, error);
        }
        if (cmbEstado.getSelectedItem() == null || cmbEstado.getSelectedItem() == "") {
            valor1 = 0;
            error = "Debe seleccionar un Estado";
            val.CMBincorrecto(cmbEstado, lblErEstado, error);
        }
        if (cmbTipo.getSelectedItem() == null || cmbTipo.getSelectedItem() == "") {
            valor1 = 0;
            error = "Debe seleccionar un Tipo de equipo";
            val.CMBincorrecto(cmbTipo, lblErTipo, error);
        }
        //se trata de obtener la fecha y si no se puede genera un error
        if (dtpPrestamo.getDate() != null && dtpPrestamo.isValid()) {
            Date date = dtpPrestamo.getDate();
            long d = date.getTime();
        } else {
            error = "La fecha seleccionada no es válida o no esta en el rango permitido.";
            val.GENIncorrecto(lblErDatePrestamo, error);
            valor1 = 0;
        }

        if (cmbCategoria.getSelectedItem() == null || cmbCategoria.getSelectedItem() == "") {
            valor1 = 0;
            error = "Debe seleccionar una Categoria de equipo";
            val.CMBincorrecto(cmbCategoria, lblErCategoria, error);
        }
        if (cmbMarca.getSelectedItem() == null || cmbMarca.getSelectedItem() == "") {
            valor1 = 0;
            error = "Debe seleccionar una Marca de equipo";
            val.CMBincorrecto(cmbMarca, lblErMarca, error);
        }
        if (txtModelo.getText().isEmpty()) {
            valor1 = 0;
            error = "Debe ecribir un modelo de equipo";
            val.TXTincorrecto(txtModelo, lblErModelo, error);
        }
        if (cmbLugar.getSelectedItem() == null || cmbLugar.getSelectedItem() == "") {
            valor1 = 0;
            error = "Debe seleccionar un lugar de compra del equipo";
            val.CMBincorrecto(cmbLugar, lblErLugar, error);
        }

        return valor1 == 1; //Expreciones regulares de los campos
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        btnModificar = new rsbuttom.RSButtonMetro();
        btnGuardar = new rsbuttom.RSButtonMetro();
        btnEliminar = new rsbuttom.RSButtonMetro();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        btnCategoria = new javax.swing.JButton();
        lblErCategoria = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        cmbMarca = new javax.swing.JComboBox<>();
        btnMarca = new javax.swing.JButton();
        lblErMarca = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAccesorio = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbLugar = new javax.swing.JComboBox<>();
        btnLugar = new javax.swing.JButton();
        lblErModelo = new javax.swing.JLabel();
        lblErLugar = new javax.swing.JLabel();
        lblObligatorio5 = new javax.swing.JLabel();
        lblObligatorio6 = new javax.swing.JLabel();
        lblObligatorio7 = new javax.swing.JLabel();
        lblObligatorio8 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblObligatorio = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        txtNumIMEI = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtNumExpediente = new javax.swing.JTextField();
        lblErExpediente = new javax.swing.JLabel();
        btnCancelar = new rsbuttom.RSButtonMetro();
        lblErImei = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        cmbEstado = new javax.swing.JComboBox<>();
        lblErEstado = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        lblErTipo = new javax.swing.JLabel();
        btnTipo = new javax.swing.JButton();
        btnEstado = new javax.swing.JButton();
        jLabel17 = new javax.swing.JLabel();
        dtpPrestamo = new com.toedter.calendar.JDateChooser();
        lblErDatePrestamo = new javax.swing.JLabel();
        lblObligatorio1 = new javax.swing.JLabel();
        lblObligatorio2 = new javax.swing.JLabel();
        lblObligatorio3 = new javax.swing.JLabel();
        lblObligatorio4 = new javax.swing.JLabel();
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNumFactura = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtComentario = new javax.swing.JTextField();
        dtpCompra = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jLabel18 = new javax.swing.JLabel();
        txtCodigo = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEquipos = new javax.swing.JTable();
        jLabel2 = new javax.swing.JLabel();
        cmbBuscar = new javax.swing.JComboBox<>();
        txtBuscar = new javax.swing.JTextField();

        jMenuItem1.setText("Actualizar datos desplegables");
        jMenuItem1.setName("actualizarTabla"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setText("Limpiar Campos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setComponentPopupMenu(jPopupMenu1);
        jPanel1.setNextFocusableComponent(txtNumIMEI);

        btnModificar.setBackground(new java.awt.Color(114, 191, 68));
        btnModificar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificar.setText("Modificar");
        btnModificar.setColorBorde(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnModificar.setColorHover(new java.awt.Color(0, 191, 68));
        btnModificar.setColorNormal(new java.awt.Color(114, 191, 68));
        btnModificar.setColorPressed(new java.awt.Color(0, 49, 30));
        btnModificar.setColorTextHover(new java.awt.Color(51, 51, 51));
        btnModificar.setColorTextNormal(new java.awt.Color(51, 51, 51));
        btnModificar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnModificar.setMaximumSize(new java.awt.Dimension(55, 20));
        btnModificar.setMinimumSize(new java.awt.Dimension(55, 20));
        btnModificar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnModificarActionPerformed(evt);
            }
        });

        btnGuardar.setBackground(new java.awt.Color(114, 191, 68));
        btnGuardar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setText("Guardar");
        btnGuardar.setColorBorde(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnGuardar.setColorHover(new java.awt.Color(0, 191, 68));
        btnGuardar.setColorNormal(new java.awt.Color(114, 191, 68));
        btnGuardar.setColorPressed(new java.awt.Color(0, 49, 30));
        btnGuardar.setColorTextHover(new java.awt.Color(51, 51, 51));
        btnGuardar.setColorTextNormal(new java.awt.Color(51, 51, 51));
        btnGuardar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnGuardar.setMaximumSize(new java.awt.Dimension(55, 20));
        btnGuardar.setMinimumSize(new java.awt.Dimension(55, 20));
        btnGuardar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnGuardarActionPerformed(evt);
            }
        });

        btnEliminar.setBackground(new java.awt.Color(114, 191, 68));
        btnEliminar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.setText("Remover");
        btnEliminar.setColorBorde(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnEliminar.setColorHover(new java.awt.Color(0, 191, 68));
        btnEliminar.setColorNormal(new java.awt.Color(114, 191, 68));
        btnEliminar.setColorPressed(new java.awt.Color(0, 49, 30));
        btnEliminar.setColorTextHover(new java.awt.Color(51, 51, 51));
        btnEliminar.setColorTextNormal(new java.awt.Color(51, 51, 51));
        btnEliminar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnEliminar.setMaximumSize(new java.awt.Dimension(55, 20));
        btnEliminar.setMinimumSize(new java.awt.Dimension(55, 20));
        btnEliminar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEliminarActionPerformed(evt);
            }
        });

        jPanel2.setNextFocusableComponent(txtNumIMEI);
        jPanel2.setOpaque(false);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Categoría del Equipo:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbCategoria.setNextFocusableComponent(cmbMarca);
        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });

        btnCategoria.setText("+");
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        lblErCategoria.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErCategoria.setForeground(new java.awt.Color(255, 0, 0));
        lblErCategoria.setText("Error");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Marca:");

        cmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbMarca.setNextFocusableComponent(txtAccesorio);
        cmbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMarcaItemStateChanged(evt);
            }
        });

        btnMarca.setText("+");
        btnMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcaActionPerformed(evt);
            }
        });

        lblErMarca.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErMarca.setForeground(new java.awt.Color(255, 0, 0));
        lblErMarca.setText("Error");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Accesorio:");

        txtAccesorio.setNextFocusableComponent(txtModelo);
        txtAccesorio.setPreferredSize(new java.awt.Dimension(65, 26));
        txtAccesorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAccesorioKeyTyped(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Modelo:");

        txtModelo.setNextFocusableComponent(cmbLugar);
        txtModelo.setPreferredSize(new java.awt.Dimension(65, 26));
        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtModeloKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloKeyTyped(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Lugar de Compra:");

        cmbLugar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbLugar.setNextFocusableComponent(txtCosto);
        cmbLugar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLugarItemStateChanged(evt);
            }
        });

        btnLugar.setText("+");
        btnLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLugarActionPerformed(evt);
            }
        });

        lblErModelo.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErModelo.setForeground(new java.awt.Color(255, 0, 0));
        lblErModelo.setText("Error");

        lblErLugar.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErLugar.setForeground(new java.awt.Color(255, 0, 0));
        lblErLugar.setText("Error");

        lblObligatorio5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio5.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio5.setText("*");
        lblObligatorio5.setToolTipText("");

        lblObligatorio6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio6.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio6.setText("*");
        lblObligatorio6.setToolTipText("");

        lblObligatorio7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio7.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio7.setText("*");
        lblObligatorio7.setToolTipText("");

        lblObligatorio8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio8.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio8.setText("*");
        lblObligatorio8.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(16, 16, 16)
                        .addComponent(jLabel8)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErLugar)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblObligatorio8)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnLugar))))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblObligatorio5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCategoria))
                            .addComponent(lblErModelo)
                            .addComponent(lblErMarca)
                            .addComponent(lblErCategoria)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtModelo, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 244, Short.MAX_VALUE)
                                    .addComponent(txtAccesorio, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(cmbMarca, javax.swing.GroupLayout.Alignment.LEADING, 0, 244, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblObligatorio7)
                                    .addGroup(jPanel2Layout.createSequentialGroup()
                                        .addComponent(lblObligatorio6)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnMarca)))))))
                .addContainerGap())
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObligatorio5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblObligatorio6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAccesorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(13, 13, 13)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObligatorio7, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErModelo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObligatorio8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErLugar)
                .addGap(13, 13, 13))
        );

        jPanel3.setNextFocusableComponent(txtNumIMEI);
        jPanel3.setOpaque(false);

        lblObligatorio.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio.setText("*");
        lblObligatorio.setToolTipText("");

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Número de IMEI:");

        txtNumIMEI.setNextFocusableComponent(txtNumExpediente);
        txtNumIMEI.setPreferredSize(new java.awt.Dimension(65, 26));
        txtNumIMEI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumIMEIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumIMEIKeyTyped(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Número de Expediente:");

        txtNumExpediente.setNextFocusableComponent(cmbEstado);
        txtNumExpediente.setPreferredSize(new java.awt.Dimension(65, 26));
        txtNumExpediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumExpedienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumExpedienteKeyTyped(evt);
            }
        });

        lblErExpediente.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErExpediente.setForeground(new java.awt.Color(255, 0, 0));
        lblErExpediente.setText("Error");

        btnCancelar.setBackground(new java.awt.Color(114, 191, 68));
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setText("Cancelar Selección");
        btnCancelar.setColorBorde(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setColorHover(new java.awt.Color(0, 191, 68));
        btnCancelar.setColorNormal(new java.awt.Color(114, 191, 68));
        btnCancelar.setColorPressed(new java.awt.Color(0, 49, 30));
        btnCancelar.setColorTextHover(new java.awt.Color(51, 51, 51));
        btnCancelar.setColorTextNormal(new java.awt.Color(51, 51, 51));
        btnCancelar.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        btnCancelar.setMaximumSize(new java.awt.Dimension(55, 20));
        btnCancelar.setMinimumSize(new java.awt.Dimension(55, 20));
        btnCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCancelarActionPerformed(evt);
            }
        });

        lblErImei.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErImei.setForeground(new java.awt.Color(255, 0, 0));
        lblErImei.setText("Error");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Estado del equipo:");

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbEstado.setNextFocusableComponent(cmbTipo);
        cmbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoItemStateChanged(evt);
            }
        });

        lblErEstado.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErEstado.setForeground(new java.awt.Color(255, 0, 0));
        lblErEstado.setText("Error");

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Tipo de Equipo:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbTipo.setNextFocusableComponent(dtpPrestamo);
        cmbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoItemStateChanged(evt);
            }
        });

        lblErTipo.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErTipo.setForeground(new java.awt.Color(255, 0, 0));
        lblErTipo.setText("Error");

        btnTipo.setText("+");
        btnTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoActionPerformed(evt);
            }
        });

        btnEstado.setText("+");
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Fecha de Prestamo:");
        jLabel17.setNextFocusableComponent(cmbCategoria);

        dtpPrestamo.setMaxSelectableDate(new java.util.Date(253370790075000L));
        dtpPrestamo.setMinSelectableDate(new java.util.Date(1262329275000L));
        dtpPrestamo.setNextFocusableComponent(cmbCategoria);

        lblErDatePrestamo.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErDatePrestamo.setForeground(new java.awt.Color(255, 0, 0));
        lblErDatePrestamo.setText("Error");

        lblObligatorio1.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio1.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio1.setText("*");
        lblObligatorio1.setToolTipText("");

        lblObligatorio2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio2.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio2.setText("*");
        lblObligatorio2.setToolTipText("");

        lblObligatorio3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio3.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio3.setText("*");
        lblObligatorio3.setToolTipText("");

        lblObligatorio4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio4.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio4.setText("*");
        lblObligatorio4.setToolTipText("");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel17)
                    .addComponent(jLabel13)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErDatePrestamo)
                    .addComponent(lblErTipo)
                    .addComponent(lblErEstado)
                    .addComponent(lblErImei)
                    .addComponent(lblErExpediente)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNumExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblObligatorio1))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(dtpPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblObligatorio4))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(txtNumIMEI, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblObligatorio)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(cmbTipo, 0, 244, Short.MAX_VALUE)
                            .addComponent(cmbEstado, 0, 244, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblObligatorio3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnTipo))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(lblObligatorio2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnEstado)))))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumIMEI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObligatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErImei, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObligatorio1, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErExpediente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObligatorio2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObligatorio3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel17, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(dtpPrestamo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblObligatorio4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErDatePrestamo)
                .addContainerGap())
        );

        jPanel4.setNextFocusableComponent(txtNumIMEI);
        jPanel4.setOpaque(false);

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Fecha de Compra:");

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Número de Factura:");

        txtNumFactura.setNextFocusableComponent(txtComentario);
        txtNumFactura.setPreferredSize(new java.awt.Dimension(65, 26));
        txtNumFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumFacturaKeyTyped(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Comentario:");

        txtComentario.setNextFocusableComponent(dtpCompra);
        txtComentario.setPreferredSize(new java.awt.Dimension(65, 26));
        txtComentario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtComentarioKeyTyped(evt);
            }
        });

        dtpCompra.setNextFocusableComponent(btnGuardar);

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Costo del Equipo:    $ ");

        txtCosto.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtCosto.setNextFocusableComponent(txtNumFactura);
        txtCosto.setPreferredSize(new java.awt.Dimension(65, 26));
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Código:");

        txtCodigo.setNextFocusableComponent(dtpCompra);
        txtCodigo.setPreferredSize(new java.awt.Dimension(65, 26));
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel9)
                            .addGap(0, 0, 0)
                            .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(112, 112, 112))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addComponent(jLabel15)
                            .addGap(18, 18, 18)
                            .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel14)
                                .addComponent(jLabel16))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(txtComentario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dtpCompra, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(69, 69, 69)
                        .addComponent(jLabel18)
                        .addGap(18, 18, 18)
                        .addComponent(txtCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel15)
                            .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel9)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel16)
                    .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel18)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(50, 50, 50)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 105, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(106, 106, 106))))
        );

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 403));

        tblEquipos.setBackground(new java.awt.Color(204, 255, 204));
        tblEquipos.setFont(new java.awt.Font("SansSerif", 1, 12)); // NOI18N
        tblEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "¿Quién lo posee? ", "Área", "Expediente", "Fecha de Prestamo", "Tipo", "Código", "Categoría", "Marca", "Modelo", "IMEI", "Accesorio", "Estado", "Lugar", "Fecha de Compra", "Costo $", "Num. Factura", "Comentario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEquipos.setGridColor(new java.awt.Color(0, 0, 0));
        tblEquipos.setSelectionBackground(new java.awt.Color(51, 153, 0));
        tblEquipos.getTableHeader().setReorderingAllowed(false);
        tblEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEquiposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEquipos);
        if (tblEquipos.getColumnModel().getColumnCount() > 0) {
            tblEquipos.getColumnModel().getColumn(0).setMinWidth(100);
            tblEquipos.getColumnModel().getColumn(0).setPreferredWidth(200);
            tblEquipos.getColumnModel().getColumn(0).setMaxWidth(300);
            tblEquipos.getColumnModel().getColumn(1).setMinWidth(100);
            tblEquipos.getColumnModel().getColumn(1).setPreferredWidth(200);
            tblEquipos.getColumnModel().getColumn(1).setMaxWidth(300);
            tblEquipos.getColumnModel().getColumn(2).setMinWidth(50);
            tblEquipos.getColumnModel().getColumn(2).setPreferredWidth(60);
            tblEquipos.getColumnModel().getColumn(2).setMaxWidth(70);
            tblEquipos.getColumnModel().getColumn(3).setMinWidth(90);
            tblEquipos.getColumnModel().getColumn(3).setPreferredWidth(150);
            tblEquipos.getColumnModel().getColumn(3).setMaxWidth(160);
            tblEquipos.getColumnModel().getColumn(4).setMinWidth(50);
            tblEquipos.getColumnModel().getColumn(4).setPreferredWidth(150);
            tblEquipos.getColumnModel().getColumn(4).setMaxWidth(170);
            tblEquipos.getColumnModel().getColumn(5).setMinWidth(50);
            tblEquipos.getColumnModel().getColumn(5).setPreferredWidth(150);
            tblEquipos.getColumnModel().getColumn(5).setMaxWidth(170);
            tblEquipos.getColumnModel().getColumn(6).setMinWidth(50);
            tblEquipos.getColumnModel().getColumn(6).setPreferredWidth(150);
            tblEquipos.getColumnModel().getColumn(6).setMaxWidth(170);
            tblEquipos.getColumnModel().getColumn(7).setMinWidth(50);
            tblEquipos.getColumnModel().getColumn(7).setPreferredWidth(150);
            tblEquipos.getColumnModel().getColumn(7).setMaxWidth(170);
            tblEquipos.getColumnModel().getColumn(8).setMinWidth(50);
            tblEquipos.getColumnModel().getColumn(8).setPreferredWidth(150);
            tblEquipos.getColumnModel().getColumn(8).setMaxWidth(170);
            tblEquipos.getColumnModel().getColumn(9).setMinWidth(130);
            tblEquipos.getColumnModel().getColumn(9).setPreferredWidth(130);
            tblEquipos.getColumnModel().getColumn(9).setMaxWidth(130);
            tblEquipos.getColumnModel().getColumn(10).setMinWidth(60);
            tblEquipos.getColumnModel().getColumn(10).setPreferredWidth(120);
            tblEquipos.getColumnModel().getColumn(10).setMaxWidth(150);
            tblEquipos.getColumnModel().getColumn(11).setMinWidth(50);
            tblEquipos.getColumnModel().getColumn(11).setPreferredWidth(80);
            tblEquipos.getColumnModel().getColumn(11).setMaxWidth(100);
            tblEquipos.getColumnModel().getColumn(12).setMinWidth(50);
            tblEquipos.getColumnModel().getColumn(12).setPreferredWidth(75);
            tblEquipos.getColumnModel().getColumn(12).setMaxWidth(90);
            tblEquipos.getColumnModel().getColumn(13).setMinWidth(90);
            tblEquipos.getColumnModel().getColumn(13).setPreferredWidth(120);
            tblEquipos.getColumnModel().getColumn(13).setMaxWidth(150);
            tblEquipos.getColumnModel().getColumn(14).setMinWidth(40);
            tblEquipos.getColumnModel().getColumn(14).setPreferredWidth(75);
            tblEquipos.getColumnModel().getColumn(14).setMaxWidth(90);
            tblEquipos.getColumnModel().getColumn(15).setMinWidth(80);
            tblEquipos.getColumnModel().getColumn(15).setPreferredWidth(120);
            tblEquipos.getColumnModel().getColumn(15).setMaxWidth(280);
            tblEquipos.getColumnModel().getColumn(16).setMinWidth(80);
            tblEquipos.getColumnModel().getColumn(16).setPreferredWidth(120);
            tblEquipos.getColumnModel().getColumn(16).setMaxWidth(350);
        }

        jLabel2.setText("Buscar por:");

        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoría", "Comentario", "Estado", "IMEI", "Marca", "N. Expediente", "Tipo", "Código" }));
        cmbBuscar.setSelectedItem("IMEI");
        cmbBuscar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbBuscarItemStateChanged(evt);
            }
        });

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 772, Short.MAX_VALUE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquiposMouseClicked
        if (!"Lector".equals(NivelAcceso)) {
            LimpiarErrores();
            CargarListas();
            //se trata de obtener los datos de la tabla para mostrarlos en las casillas respectivas con ayuda de sql
            try {
                AccionesCrud classcrud = new AccionesCrud();
                ResultSet rs = classcrud.Seleccion(tblEquipos, "select * from [VistaEquipos] where [IMEI]=?", "IMEI");
                while (rs.next()) {
                    txtNumIMEI.setText(rs.getString("IMEI"));
                    txtNumExpediente.setText(rs.getString("NumeroExpediente"));
                    cmbEstado.setSelectedItem(rs.getString("Estado del Equipo"));
                    cmbTipo.setSelectedItem(rs.getString("Tipo"));

                    //formato para mostrar la fecha en el JDateChooser
                    SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
                    Date fecha;
                    try {
                        fecha = formatofecha.parse(rs.getString("FechaPrestamo"));
                        dtpPrestamo.setDate(fecha);
                    } catch (ParseException ex) {
                        Logger.getLogger(pnlEquipos.class.getName()).log(Level.SEVERE, null, ex);
                    }
                    cmbCategoria.setSelectedItem(rs.getString("Categoria"));
                    cmbMarca.setSelectedItem(rs.getString("Marca"));
                    txtModelo.setText(rs.getString("Modelo"));
                    txtAccesorio.setText(rs.getString("Accesorio"));
                    cmbLugar.setSelectedItem(rs.getString("Lugar"));

                    //formato para mostrar la fecha en el JDateChooser
                    try {
                        fecha = formatofecha.parse(rs.getString("FechaCompra"));
                        dtpCompra.setDate(fecha);
                    } catch (ParseException ex) {
                        Logger.getLogger(pnlEquipos.class.getName()).log(Level.SEVERE, null, ex);
                    }

                    txtCosto.setText(rs.getString("CostoEquipo"));
                    txtComentario.setText(rs.getString("Comentario"));
                    txtNumFactura.setText(rs.getString("NumDoc"));
                    txtCodigo.setText(rs.getString("Codigo"));

                }
                txtNumIMEI.enable(false);
                btnModificar.setVisible(true);
                btnEliminar.setVisible(true);
                btnCancelar.setVisible(true);
                btnGuardar.setVisible(false);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }//GEN-LAST:event_tblEquiposMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CargarListas();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void CargarListas() {
        // Lista de JComboBox para actualizar datos
        JComboBox[] comboBoxes = {cmbEstado, cmbTipo, cmbCategoria, cmbMarca, cmbLugar};

        // Recorrer cada JComboBox y eliminar los elementos
        for (JComboBox comboBox : comboBoxes) {
            DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
            model.removeAllElements();
            model.addElement("");
        }
        //cargar los datos de los combobox
        DatosTablas Datos = new DatosTablas();
        Datos.cargarComboBox("select Categoria from VistaCategoriaEquipo", "Categoria", cmbCategoria);
        Datos.cargarComboBox("select Marca from VistaMarcaEquipos", "Marca", cmbMarca);
        Datos.cargarComboBox("select Lugar from VistaLugarCompra", "Lugar", cmbLugar);
        Datos.cargarComboBox("select Estado from VistaEstadoEquipos", "Estado", cmbEstado);
        Datos.cargarComboBox("select Tipo from VistaTipoEquipos", "Tipo", cmbTipo);
    }
    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Limpiar();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private Object[] ArregloDatos() {
        //se crea un arreglo de objetos para enviar a la clase de AccionesCrud y la funcion de Guardar_Modificar
        Object[] datos = new Object[15];
        datos[0] = txtNumIMEI.getText();
        datos[1] = cmbEstado.getSelectedItem().toString();
        datos[2] = Integer.parseInt(txtNumExpediente.getText());
        try {
            Date date2 = dtpPrestamo.getDate();
            long d2 = date2.getTime();
            java.sql.Date fecha2 = new java.sql.Date(d2);
            datos[3] = fecha2.toString();
        } catch (Exception e) {
            datos[3] = "";
        }
        datos[4] = cmbTipo.getSelectedItem().toString();
        datos[5] = cmbCategoria.getSelectedItem().toString();
        datos[6] = cmbMarca.getSelectedItem().toString();
        datos[7] = txtModelo.getText().trim();
        datos[8] = txtAccesorio.getText().trim();
        datos[9] = cmbLugar.getSelectedItem().toString();
        try {
            Date date = dtpCompra.getDate();
            long d = date.getTime();
            java.sql.Date fecha = new java.sql.Date(d);
            datos[10] = fecha.toString();
        } catch (Exception e) {
            datos[10] = "";
        }
        datos[11] = txtComentario.getText().trim();
        try {
            datos[12] = Double.parseDouble(txtCosto.getText());
        } catch (NumberFormatException e) {
            datos[12] = "";
        }
        datos[13] = txtNumFactura.getText().trim();
        datos[14] = txtCodigo.getText().trim();
        return datos;
    }

    //Funicon para asignar el tipo de busqueda que se va hacer por medio de un switc y los valores de la vista de la BD
    private void cmbBuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBuscarItemStateChanged
        //Cada vez que se cambia el estado del combobox se cambia el filtro de busqueda global para la funcion de busqueda
        String elementoSeleccionado = (String) cmbBuscar.getSelectedItem();
        switch (elementoSeleccionado) {
            case "Categoría":
                Busqueda = "Categoria";
                break;
            case "Comentario":
                Busqueda = "Comentario";
                break;
            case "Estado":
                Busqueda = "Estado del Equipo";
                break;
            case "IMEI":
                Busqueda = "Imei";
                break;
            case "Marca":
                Busqueda = "Marca";
                break;
            case "N. Expediente":
                Busqueda = "NumeroExpediente";
                break;
            case "Tipo":
                Busqueda = "Tipo";
                break;
            case "Código":
                Busqueda = "Codigo";
                break;
            default:
                break;
        }
        txtBuscar.setText("");
    }//GEN-LAST:event_cmbBuscarItemStateChanged

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        //cada vez que se precione una tecla se va a buscar junto al filtro de busqueda en la vista correspondiente
        //se limpia la tabla
        DefaultTableModel modelo = (DefaultTableModel) tblEquipos.getModel();
        modelo.setRowCount(0);
        //se muestra los resultados de la busqueda
        CargarDatosTabla();
       
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        //switch para decidir que validacion establecer cada ves que se preciona una tecla en buscar
        switch (Busqueda) {
            case "Categoria":
                val.EntradaTextoNormal(txtBuscar, evt, 50);
                break;
            case "Comentario":
                val.EntradaTextoNormal(txtBuscar, evt, 50);
                break;
            case "Estado del Equipo":
                val.EntradaTextoNormal(txtBuscar, evt, 50);
                break;
            case "Imei":
                val.EntradaNumeros(txtBuscar, evt, 15);
                break;
            case "Marca":
                val.EntradaTextoNormal(txtBuscar, evt, 50);
                break;
            case "NumeroExpediente":
                val.EntradaNumeros(txtBuscar, evt, 4);
                break;
            case "Tipo":
                val.EntradaTextoNormal(txtBuscar, evt, 50);
                break;
            case "Codigo":
                val.EntradaLetrasNumeroGuion(txtBuscar, evt, 20);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_txtBuscarKeyTyped

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        val.EntradaDinero(txtCosto, evt);
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtComentarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComentarioKeyTyped
        //validacion para un campo de tipo normal
        val.EntradaTextoNormal(txtComentario, evt, 50);
    }//GEN-LAST:event_txtComentarioKeyTyped

    private void txtNumFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumFacturaKeyTyped
        //validadcion para un campo tipo normal
        val.EntradaNumeroGuion(txtNumFactura, evt, 30);
    }//GEN-LAST:event_txtNumFacturaKeyTyped

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        //Abrir Formulario de Estado
        Estado CrudEstado = new Estado();
        CrudEstado.setVisible(true);
        CrudEstado.pack();
        CrudEstado.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void btnTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoActionPerformed
        //Abrir Formulario de Tipo
        Tipo CrudTipo = new Tipo();
        CrudTipo.setVisible(true);
        CrudTipo.pack();
        CrudTipo.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnTipoActionPerformed

    private void cmbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoItemStateChanged
        //al seleccionar un item se quita el estado de error
        val.CMBcorrecto(cmbTipo, lblErTipo);
    }//GEN-LAST:event_cmbTipoItemStateChanged

    private void cmbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoItemStateChanged
        //al seleccionar un item se quita el estado de error
        val.CMBcorrecto(cmbEstado, lblErEstado);
    }//GEN-LAST:event_cmbEstadoItemStateChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNumExpedienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExpedienteKeyTyped
        //validado para el tipo de entrada Expediente
        val.EntradaNumeros(txtNumExpediente, evt, 4);
    }//GEN-LAST:event_txtNumExpedienteKeyTyped

    private void txtNumExpedienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExpedienteKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtNumExpediente, lblErExpediente);
    }//GEN-LAST:event_txtNumExpedienteKeyReleased

    private void txtNumIMEIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumIMEIKeyTyped
        //validado para el tipo de campo IMEI
        val.EntradaNumeros(txtNumIMEI, evt, 15);
    }//GEN-LAST:event_txtNumIMEIKeyTyped

    private void txtNumIMEIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumIMEIKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtNumIMEI, lblErImei);
    }//GEN-LAST:event_txtNumIMEIKeyReleased

    private void btnLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLugarActionPerformed
        //Abrir Formulario de Lugar de compra
        LugarCompra LugarCompra = new LugarCompra();
        LugarCompra.setVisible(true);
        LugarCompra.pack();
        LugarCompra.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnLugarActionPerformed

    private void cmbLugarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLugarItemStateChanged
        //al seleccionar un item se quita el estado de error
        val.CMBcorrecto(cmbLugar, lblErLugar);
    }//GEN-LAST:event_cmbLugarItemStateChanged

    private void txtModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyTyped
        // validado para un campo de tipo normal
        val.EntradaTextoNormal(txtModelo, evt, 50);
    }//GEN-LAST:event_txtModeloKeyTyped

    private void txtModeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtModelo, lblErModelo);
    }//GEN-LAST:event_txtModeloKeyReleased

    private void txtAccesorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccesorioKeyTyped
        // validado para un campo de tipo normal
        val.EntradaTextoNormal(txtAccesorio, evt, 30);
    }//GEN-LAST:event_txtAccesorioKeyTyped

    private void btnMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcaActionPerformed
        //Abrir Formulario de CentroCosto
        Marca CrudMarca = new Marca();
        CrudMarca.setVisible(true);
        CrudMarca.pack();
        CrudMarca.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMarcaActionPerformed

    private void cmbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMarcaItemStateChanged
        //al seleccionar un item se quita el estado de error
        val.CMBcorrecto(cmbMarca, lblErMarca);
    }//GEN-LAST:event_cmbMarcaItemStateChanged

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        //Abrir Formulario de CentroCosto
        Categoria CrudCategoria = new Categoria();
        CrudCategoria.setVisible(true);
        CrudCategoria.pack();
        CrudCategoria.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        //al seleccionar un item se quita el estado de error
        val.CMBcorrecto(cmbCategoria, lblErCategoria);
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //se utiliza la funcion Eliminar de la clase AccionesCrud enviando el ID
        AccionesCrud classcrud = new AccionesCrud();
        if (classcrud.Eliminar(txtNumIMEI, "exec EliminarEquipo ?")) {
           CargarDatosTabla();
            Limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        LimpiarErrores();
        if (ValidarCampos()) {
            AccionesCrud classcrud = new AccionesCrud();
            if (classcrud.Guardar_Modificar(ArregloDatos(), "exec [AgregarEquipo] ?, ? ,?  ,? ,? ,? ,? ,? ,? ,?,?,?,?,?,?")) {
                CargarDatosTabla();
                Limpiar();
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        LimpiarErrores();
        if (ValidarCampos()) {
            AccionesCrud classcrud = new AccionesCrud();
            if (classcrud.Guardar_Modificar(ArregloDatos(), "exec [UpdateEquipo] ?, ? ,?  ,? ,? ,? ,? ,? ,? ,?,?,?,?,?,?")) {
                CargarDatosTabla();
                Limpiar();
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        val.EntradaLetrasNumeroGuion(txtCodigo, evt, 20);
    }//GEN-LAST:event_txtCodigoKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro btnCancelar;
    private javax.swing.JButton btnCategoria;
    private rsbuttom.RSButtonMetro btnEliminar;
    private javax.swing.JButton btnEstado;
    private rsbuttom.RSButtonMetro btnGuardar;
    private javax.swing.JButton btnLugar;
    private javax.swing.JButton btnMarca;
    private rsbuttom.RSButtonMetro btnModificar;
    private javax.swing.JButton btnTipo;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbEstado;
    private javax.swing.JComboBox<String> cmbLugar;
    private javax.swing.JComboBox<String> cmbMarca;
    private javax.swing.JComboBox<String> cmbTipo;
    private com.toedter.calendar.JDateChooser dtpCompra;
    private com.toedter.calendar.JDateChooser dtpPrestamo;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel16;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErCategoria;
    private javax.swing.JLabel lblErDatePrestamo;
    private javax.swing.JLabel lblErEstado;
    private javax.swing.JLabel lblErExpediente;
    private javax.swing.JLabel lblErImei;
    private javax.swing.JLabel lblErLugar;
    private javax.swing.JLabel lblErMarca;
    private javax.swing.JLabel lblErModelo;
    private javax.swing.JLabel lblErTipo;
    private javax.swing.JLabel lblObligatorio;
    private javax.swing.JLabel lblObligatorio1;
    private javax.swing.JLabel lblObligatorio2;
    private javax.swing.JLabel lblObligatorio3;
    private javax.swing.JLabel lblObligatorio4;
    private javax.swing.JLabel lblObligatorio5;
    private javax.swing.JLabel lblObligatorio6;
    private javax.swing.JLabel lblObligatorio7;
    private javax.swing.JLabel lblObligatorio8;
    private javax.swing.JTable tblEquipos;
    private javax.swing.JTextField txtAccesorio;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtComentario;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumExpediente;
    private javax.swing.JTextField txtNumFactura;
    private javax.swing.JTextField txtNumIMEI;
    // End of variables declaration//GEN-END:variables
}
