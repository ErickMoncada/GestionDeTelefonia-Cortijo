package paneles;

import Clases.AccionesCrud;
import Clases.DatosTablas;
import Clases.validaciones;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import paneles.ExtraDLineasTelefonicas.Disponibilidad;

public class pnlLineasTelefonicas extends javax.swing.JPanel {

    public pnlLineasTelefonicas() {
        initComponents();
        CargarDatosPrincipal();
        lblTotalPlanNuevo.setText("Suma Total de los Plan Nuevos: " + SumarValores(12) + "$");
        lblTotalPresupuesto.setText("Suma Total de los Presupuestos: " + SumarValores(13) + "$");
        Limpiar();
        txtOtro.setVisible(false);
        btgPago.add(rdbSiSeguro);
        btgPago.add(rdbNoSeguro);
        btgFirma.add(rdbSiFirma);
        btgFirma.add(rdbNoFirma);
        btgFirma.add(rdbOtro);
    }
    //se inicializa para la busqueda por medio de Imei
    String Busqueda = "Imei";
    //se inicializa la clase de validaciones
    validaciones val = new validaciones();
    //se crean los grupos de botones para los radioButton
    ButtonGroup btgPago = new ButtonGroup();
    ButtonGroup btgFirma = new ButtonGroup();

    private String SumarValores(int pocision) {
        //funcion para sumar la cantidad que brinda una columna
        double total = 0;
        for (int i = 0; i < tblLineas.getRowCount(); i++) {
            Object value = tblLineas.getValueAt(i, pocision);
            total += ((Number) value).doubleValue();
        }
        return String.valueOf(total);

    }

    private void Limpiar() {
        //funcion para reiniciar todos los valores de la pantalla
        btnCancelar.setVisible(false);
        btnModificar.setVisible(false);
        btnEliminar.setVisible(false);
        btnGuardar.setVisible(true);
        txtLinea.enable(true);

        txtLinea.setText("");
        txtNumExpediente.setText("");
        txtAnterior.setText("");
        txtNuevo.setText("");
        txtPresupuesto.setText("");
        txtMensual.setText("");
        txtOtro.setText("");
        cmbDisponibilidad.setSelectedIndex(-1);
        txtYear.setYear(2023);
        txtCuotas.setValue(0);
        txtImei.setText("");
        dtpAsignacion.setDate(null);
        dtpCambio.setDate(null);
        dtpFacturacion.setDate(null);
        btgFirma.clearSelection();
        btgPago.clearSelection();
        txtOtro.setVisible(false);
        txtLinea.requestFocus();
        LimpiarErrores();
    }

    private void CargarDatosPrincipal() {
        //rellenar datos de la tabla
        DatosTablas Datos = new DatosTablas();
        Datos.CargarTabla(tblLineas, "select * from [VistaLineasTelefonicas]");
        //llenar los datos de los combobox
        CargarListas();

    }

    private void CargarListas() {
        // Lista de JComboBox para actualizar datos
        JComboBox[] comboBoxes = {cmbDisponibilidad};

        // Recorrer cada JComboBox y eliminar los elementos
        for (JComboBox comboBox : comboBoxes) {
            DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
            model.removeAllElements();
            model.addElement("");
        }
        //cargar los datos de los combobox
        DatosTablas Datos = new DatosTablas();
        Datos.cargarComboBox("select Disponible from VistaDisponibilidades", "Disponible", cmbDisponibilidad);
    }

    private void LimpiarErrores() {
        //usando la clase de validaciones se establecen los valores en correcto
        val.TXTcorrecto(txtLinea, lblErLinea);
        val.TXTcorrecto(txtNumExpediente, lblErExpediente);
        val.CMBcorrecto(cmbDisponibilidad, lblErDisponible);
        val.GENcorrecto(lblErCuotas);
        val.TXTcorrecto(txtImei, lblErImei);
        val.GENcorrecto(lblErAsignacion);
        val.GENcorrecto(lblErCambio);
        val.GENcorrecto(lblErFacturacion);
        val.GENcorrecto(lblErPago);
        val.TXTcorrecto(txtOtro, lblErFirma);
        val.TXTcorrecto(txtAnterior, lblErAnterior);
        val.TXTcorrecto(txtNuevo, lblErNuevo);
        val.TXTcorrecto(txtPresupuesto, lblErPresupuesto);
        val.TXTcorrecto(txtMensual, lblErMensual);
    }

    private boolean ValidarCampos() {
        int valor1 = 1;
        String error;
        //validar que no este vacio u otro parametro mas
        if (txtLinea.getText().isEmpty() || !txtLinea.getText().matches("\\d{4}-\\d{4}")) {
            //asignar 0 al valor para devolver falso en la validacion
            valor1 = 0;
            //mensaje de error para el respectivo campo de texto
            error = "Escriba un numero de telefono valido";
            //asignar colores de error a cada campo
            val.TXTincorrecto(txtLinea, lblErLinea, error);
        }
        if (txtNumExpediente.getText().isEmpty()) {
            valor1 = 0;
            error = "Escriba un numero de expediente";
            val.TXTincorrecto(txtNumExpediente, lblErExpediente, error);
        }
        if (cmbDisponibilidad.getSelectedItem() == null || cmbDisponibilidad.getSelectedItem() == "") {
            valor1 = 0;
            error = "Debe seleccionar la disponibilidad";
            val.CMBincorrecto(cmbDisponibilidad, lblErDisponible, error);
        }
        System.out.println((Integer) txtCuotas.getValue());
        if ((Integer) txtCuotas.getValue() <= 0) {
            valor1 = 0;
            error = "Las cuotas no pueden ser menor o igual a 0";
            val.GENIncorrecto(lblErCuotas, error);
        }
        if (txtImei.getText().isEmpty() || !txtImei.getText().matches("\\d{15}")) {
            valor1 = 0;
            error = "Escriba un numero de IMEI valido";
            val.TXTincorrecto(txtImei, lblErImei, error);
        }
        //se trata de obtener la fecha y si no se puede genera un error
        try {
            Date date = dtpAsignacion.getDate();
            long d = date.getTime();
        } catch (Exception e) {
            error = "La fecha de Asignacion tiene que ser valida";
            val.GENIncorrecto(lblErAsignacion, error);
            valor1 = 0;
        }
        try {
            Date date = dtpCambio.getDate();
            long d = date.getTime();
        } catch (Exception e) {
            error = "La fecha de Cambio tiene que ser valida";
            val.GENIncorrecto(lblErCambio, error);
            valor1 = 0;
        }
        try {
            Date date = dtpFacturacion.getDate();
            long d = date.getTime();
        } catch (Exception e) {
            error = "La fecha de Facturacion tiene que ser valida";
            val.GENIncorrecto(lblErFacturacion, error);
            valor1 = 0;
        }
        if (btgPago.getSelection() == null) {
            valor1 = 0;
            error = "Debe seleccionar una opcion de Pago de Seguro";
            val.GENIncorrecto(lblErPago, error);
        }
        if (rdbOtro.isSelected() && txtOtro.getText().isEmpty()) {
            valor1 = 0;
            error = "EL campo de Otro no puede estar en blanco";
            val.TXTincorrecto(txtOtro, lblErFirma, error);
        } else if (btgFirma.getSelection() == null) {
            valor1 = 0;
            error = "Debe seleccionar una opcion de Firma";
            val.GENIncorrecto(lblErFirma, error);
        }
        if (txtAnterior.getText().isEmpty()) {
            valor1 = 0;
            error = "Escriba la cantidad del paln Anterior";
            val.TXTincorrecto(txtAnterior, lblErAnterior, error);
        }
        if (txtNuevo.getText().isEmpty()) {
            valor1 = 0;
            error = "Escriba la cantidad del paln Nuevo";
            val.TXTincorrecto(txtNuevo, lblErNuevo, error);
        }
        if (txtPresupuesto.getText().isEmpty()) {
            valor1 = 0;
            error = "Escriba la cantidad del presupuesto";
            val.TXTincorrecto(txtPresupuesto, lblErPresupuesto, error);
        }
        if (txtMensual.getText().isEmpty()) {
            valor1 = 0;
            error = "Escriba la cantidad del Recocnocimiento Mensual";
            val.TXTincorrecto(txtMensual, lblErMensual, error);
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
        txtBuscar = new javax.swing.JTextField();
        cmbBuscar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnModificar = new rsbuttom.RSButtonMetro();
        btnGuardar = new rsbuttom.RSButtonMetro();
        btnEliminar = new rsbuttom.RSButtonMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblLineas = new javax.swing.JTable();
        jPanel4 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        btnCancelar = new rsbuttom.RSButtonMetro();
        lblErLinea = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNumExpediente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        lblErExpediente = new javax.swing.JLabel();
        cmbDisponibilidad = new javax.swing.JComboBox<>();
        btnDisponibilidad = new javax.swing.JButton();
        lblErDisponible = new javax.swing.JLabel();
        jLabel19 = new javax.swing.JLabel();
        txtYear = new com.toedter.calendar.JYearChooser();
        jLabel18 = new javax.swing.JLabel();
        txtCuotas = new javax.swing.JSpinner();
        lblErCuotas = new javax.swing.JLabel();
        txtImei = new javax.swing.JTextField();
        jLabel17 = new javax.swing.JLabel();
        lblErImei = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        dtpAsignacion = new com.toedter.calendar.JDateChooser();
        lblErAsignacion = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dtpCambio = new com.toedter.calendar.JDateChooser();
        lblErCambio = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dtpFacturacion = new com.toedter.calendar.JDateChooser();
        jPanel2 = new javax.swing.JPanel();
        jLabel9 = new javax.swing.JLabel();
        rdbSiFirma = new javax.swing.JRadioButton();
        rdbNoFirma = new javax.swing.JRadioButton();
        rdbOtro = new javax.swing.JRadioButton();
        txtOtro = new javax.swing.JTextField();
        lblErFirma = new javax.swing.JLabel();
        lblErFacturacion = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jPanel7 = new javax.swing.JPanel();
        rdbSiSeguro = new javax.swing.JRadioButton();
        rdbNoSeguro = new javax.swing.JRadioButton();
        lblErPago = new javax.swing.JLabel();
        jPanel6 = new javax.swing.JPanel();
        jLabel11 = new javax.swing.JLabel();
        txtAnterior = new javax.swing.JTextField();
        txtNuevo = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        lblErAnterior = new javax.swing.JLabel();
        lblErNuevo = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtPresupuesto = new javax.swing.JTextField();
        txtMensual = new javax.swing.JTextField();
        lblErPresupuesto = new javax.swing.JLabel();
        lblErMensual = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        lblTotalPlanNuevo = new javax.swing.JLabel();
        lblTotalPresupuesto = new javax.swing.JLabel();

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
        setNextFocusableComponent(txtLinea);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setComponentPopupMenu(jPopupMenu1);
        jPanel1.setNextFocusableComponent(txtLinea);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "IMEI", "Linea de Telefono", "N. expediente" }));
        cmbBuscar.setSelectedItem("IMEI");
        cmbBuscar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbBuscarItemStateChanged(evt);
            }
        });

        jLabel2.setText("Buscar por:");

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
        btnGuardar.setNextFocusableComponent(txtBuscar);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(923, 923, 923))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(28, 28, 28)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(17, 17, 17))
        );

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 403));

        tblLineas.setBackground(new java.awt.Color(204, 255, 204));
        tblLineas.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tblLineas.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "Linea Telefonica", "N Expediente", "Disponibilidad", "Año de  renovacion", "IMEI", "Cuotas", "Asignado", "Cambio de Equipo", "Facturado", "Firma", "Paga Seguro?", "Plan Anterior", "Plan Nuevo", "Presupuesto", "Reconocido del Plan"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblLineas.setGridColor(new java.awt.Color(0, 0, 0));
        tblLineas.setSelectionBackground(new java.awt.Color(51, 153, 0));
        tblLineas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblLineasMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblLineas);

        jPanel4.setComponentPopupMenu(jPopupMenu1);
        jPanel4.setNextFocusableComponent(txtLinea);
        jPanel4.setOpaque(false);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Linea Telefonica:");

        txtLinea.setNextFocusableComponent(txtNumExpediente);
        txtLinea.setPreferredSize(new java.awt.Dimension(65, 26));
        txtLinea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLineaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLineaKeyTyped(evt);
            }
        });

        btnCancelar.setBackground(new java.awt.Color(114, 191, 68));
        btnCancelar.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCancelar.setText("Cancelar Seleccion");
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

        lblErLinea.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErLinea.setForeground(new java.awt.Color(255, 0, 0));
        lblErLinea.setText("Error");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Numero de Expediente:");

        txtNumExpediente.setNextFocusableComponent(cmbDisponibilidad);
        txtNumExpediente.setPreferredSize(new java.awt.Dimension(65, 26));
        txtNumExpediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumExpedienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumExpedienteKeyTyped(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Disponibilidad:");

        lblErExpediente.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErExpediente.setForeground(new java.awt.Color(255, 0, 0));
        lblErExpediente.setText("Error");

        cmbDisponibilidad.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbDisponibilidad.setNextFocusableComponent(txtYear);
        cmbDisponibilidad.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbDisponibilidadItemStateChanged(evt);
            }
        });

        btnDisponibilidad.setText("+");
        btnDisponibilidad.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDisponibilidadActionPerformed(evt);
            }
        });

        lblErDisponible.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErDisponible.setForeground(new java.awt.Color(255, 0, 0));
        lblErDisponible.setText("Error");

        jLabel19.setForeground(new java.awt.Color(0, 0, 0));
        jLabel19.setText("Año de Renovacion:");

        txtYear.setMaximum(2100);
        txtYear.setMinimum(1980);
        txtYear.setNextFocusableComponent(txtCuotas);

        jLabel18.setForeground(new java.awt.Color(0, 0, 0));
        jLabel18.setText("Cuotas:");

        txtCuotas.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        txtCuotas.setNextFocusableComponent(txtImei);
        txtCuotas.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                txtCuotasStateChanged(evt);
            }
        });

        lblErCuotas.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErCuotas.setForeground(new java.awt.Color(255, 0, 0));
        lblErCuotas.setText("Error");

        txtImei.setNextFocusableComponent(dtpAsignacion);
        txtImei.setPreferredSize(new java.awt.Dimension(65, 26));
        txtImei.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtImeiKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtImeiKeyTyped(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("IMEI:");

        lblErImei.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErImei.setForeground(new java.awt.Color(255, 0, 0));
        lblErImei.setText("Error");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4)
                            .addComponent(jLabel3)
                            .addComponent(jLabel19))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 116, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(txtNumExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblErLinea)
                            .addComponent(lblErExpediente)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(cmbDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnDisponibilidad))
                            .addComponent(lblErDisponible)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel18)
                                .addGap(18, 18, 18)
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErCuotas)
                                    .addComponent(txtCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, 48, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(105, 105, 105)
                        .addComponent(jLabel17)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErImei)
                            .addComponent(txtImei, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(58, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumExpediente, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnDisponibilidad, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErDisponible, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel19, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtYear, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jLabel18, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(txtCuotas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErCuotas)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtImei, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblErImei, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
        );

        jPanel5.setComponentPopupMenu(jPopupMenu1);
        jPanel5.setNextFocusableComponent(txtLinea);
        jPanel5.setOpaque(false);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Fecha de Asignacion:");

        dtpAsignacion.setNextFocusableComponent(dtpCambio);

        lblErAsignacion.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErAsignacion.setForeground(new java.awt.Color(255, 0, 0));
        lblErAsignacion.setText("Error");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Fecha Cambio de Equipo:");

        dtpCambio.setNextFocusableComponent(dtpFacturacion);

        lblErCambio.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErCambio.setForeground(new java.awt.Color(255, 0, 0));
        lblErCambio.setText("Error");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha de Facturacion:");

        dtpFacturacion.setNextFocusableComponent(rdbSiSeguro);

        jPanel2.setComponentPopupMenu(jPopupMenu1);
        jPanel2.setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Firma:");
        jPanel2.add(jLabel9, new org.netbeans.lib.awtextra.AbsoluteConstraints(35, 12, -1, -1));

        rdbSiFirma.setText("SI");
        rdbSiFirma.setName(""); // NOI18N
        rdbSiFirma.setNextFocusableComponent(rdbNoFirma);
        rdbSiFirma.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbSiFirmaItemStateChanged(evt);
            }
        });
        jPanel2.add(rdbSiFirma, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 6, -1, -1));

        rdbNoFirma.setText("NO");
        rdbNoFirma.setNextFocusableComponent(rdbOtro);
        rdbNoFirma.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbNoFirmaItemStateChanged(evt);
            }
        });
        jPanel2.add(rdbNoFirma, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 6, -1, -1));

        rdbOtro.setText("Otro");
        rdbOtro.setNextFocusableComponent(txtAnterior);
        rdbOtro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbOtroItemStateChanged(evt);
            }
        });
        jPanel2.add(rdbOtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(88, 46, -1, -1));

        txtOtro.setBackground(new java.awt.Color(255, 255, 255));
        txtOtro.setForeground(new java.awt.Color(0, 0, 0));
        txtOtro.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 0, 1, 0, new java.awt.Color(0, 0, 0)));
        txtOtro.setPreferredSize(new java.awt.Dimension(65, 26));
        txtOtro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtOtroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtOtroKeyTyped(evt);
            }
        });
        jPanel2.add(txtOtro, new org.netbeans.lib.awtextra.AbsoluteConstraints(151, 48, 182, -1));

        lblErFirma.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErFirma.setForeground(new java.awt.Color(255, 0, 0));
        lblErFirma.setText("Error");
        jPanel2.add(lblErFirma, new org.netbeans.lib.awtextra.AbsoluteConstraints(100, 80, -1, 13));

        lblErFacturacion.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErFacturacion.setForeground(new java.awt.Color(255, 0, 0));
        lblErFacturacion.setText("Error");

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Paga seguro?");

        jPanel7.setOpaque(false);

        rdbSiSeguro.setText("SI");
        rdbSiSeguro.setNextFocusableComponent(rdbNoSeguro);
        rdbSiSeguro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbSiSeguroItemStateChanged(evt);
            }
        });

        rdbNoSeguro.setText("NO");
        rdbNoSeguro.setNextFocusableComponent(rdbSiFirma);
        rdbNoSeguro.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                rdbNoSeguroItemStateChanged(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(rdbSiSeguro)
                .addGap(36, 36, 36)
                .addComponent(rdbNoSeguro)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(rdbSiSeguro)
                    .addComponent(rdbNoSeguro))
                .addGap(0, 9, Short.MAX_VALUE))
        );

        lblErPago.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErPago.setForeground(new java.awt.Color(255, 0, 0));
        lblErPago.setText("Error");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErPago)
                            .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(lblErCambio)
                                .addComponent(lblErAsignacion)
                                .addComponent(dtpAsignacion, javax.swing.GroupLayout.DEFAULT_SIZE, 207, Short.MAX_VALUE)
                                .addComponent(dtpCambio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(dtpFacturacion, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblErFacturacion)
                                .addComponent(jPanel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, 360, Short.MAX_VALUE)))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtpAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErAsignacion, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpCambio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErCambio, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErFacturacion, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(7, 7, 7)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErPago, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setComponentPopupMenu(jPopupMenu1);
        jPanel6.setNextFocusableComponent(txtLinea);
        jPanel6.setOpaque(false);

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Plan Anterior:");

        txtAnterior.setNextFocusableComponent(txtNuevo);
        txtAnterior.setPreferredSize(new java.awt.Dimension(65, 26));
        txtAnterior.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAnteriorKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAnteriorKeyTyped(evt);
            }
        });

        txtNuevo.setNextFocusableComponent(txtPresupuesto);
        txtNuevo.setPreferredSize(new java.awt.Dimension(65, 26));
        txtNuevo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNuevoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNuevoKeyTyped(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Plan Nuevo:");

        lblErAnterior.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErAnterior.setForeground(new java.awt.Color(255, 0, 0));
        lblErAnterior.setText("Error");

        lblErNuevo.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErNuevo.setForeground(new java.awt.Color(255, 0, 0));
        lblErNuevo.setText("Error");

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Presupuesto:");

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Reconocimiento Mensual:");

        txtPresupuesto.setNextFocusableComponent(txtMensual);
        txtPresupuesto.setPreferredSize(new java.awt.Dimension(65, 26));
        txtPresupuesto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtPresupuestoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtPresupuestoKeyTyped(evt);
            }
        });

        txtMensual.setNextFocusableComponent(btnGuardar);
        txtMensual.setPreferredSize(new java.awt.Dimension(65, 26));
        txtMensual.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtMensualKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtMensualKeyTyped(evt);
            }
        });

        lblErPresupuesto.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErPresupuesto.setForeground(new java.awt.Color(255, 0, 0));
        lblErPresupuesto.setText("Error");

        lblErMensual.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErMensual.setForeground(new java.awt.Color(255, 0, 0));
        lblErMensual.setText("Error");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel15)
                    .addComponent(jLabel13)
                    .addComponent(jLabel11)
                    .addComponent(jLabel12))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblErMensual)
                    .addComponent(txtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErAnterior)
                    .addComponent(lblErNuevo)
                    .addComponent(txtPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblErPresupuesto)
                    .addComponent(txtMensual, javax.swing.GroupLayout.PREFERRED_SIZE, 133, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(24, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel11))
                .addGap(2, 2, 2)
                .addComponent(lblErAnterior, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel12))
                .addGap(1, 1, 1)
                .addComponent(lblErNuevo, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErPresupuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtMensual, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel15, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErMensual, javax.swing.GroupLayout.PREFERRED_SIZE, 13, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        lblTotalPlanNuevo.setForeground(new java.awt.Color(0, 0, 0));
        lblTotalPlanNuevo.setText("Total del Plan Nuevo:");

        lblTotalPresupuesto.setForeground(new java.awt.Color(0, 0, 0));
        lblTotalPresupuesto.setText("Total del Presupuesto:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addContainerGap(28, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(lblTotalPlanNuevo)
                    .addComponent(lblTotalPresupuesto))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTotalPlanNuevo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblTotalPresupuesto)
                .addContainerGap(21, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)))
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(84, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblLineasMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblLineasMouseClicked
        LimpiarErrores();
        CargarListas();
        //se trata de obtener los datos de la tabla para mostrarlos en las casillas respectivas con ayuda de sql
        try {
            AccionesCrud classcrud = new AccionesCrud();
            ResultSet rs = classcrud.Seleccion(tblLineas, "select * from [VistaLineasTelefonicas] where [Linea]=?");
            while (rs.next()) {
                txtLinea.setText(rs.getString("Linea"));
                txtNumExpediente.setText(rs.getString("Expediente"));
                cmbDisponibilidad.setSelectedItem(rs.getString("Disponible"));
                txtYear.setValue(rs.getInt("Año Renovacion"));
                txtCuotas.setValue(rs.getInt("Cuotas"));
                txtImei.setText(rs.getString("Imei"));
                txtAnterior.setText(rs.getString("PlanAnterior"));
                txtNuevo.setText(rs.getString("NuevoPlan"));
                txtPresupuesto.setText(rs.getString("Presupuesto"));
                txtMensual.setText(rs.getString("ReconocidoPlan"));

                //formato para mostrar la fecha en el JDateChooser
                SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha;
                try {
                    fecha = formatofecha.parse(rs.getString("FechaAsignacion"));
                    dtpAsignacion.setDate(fecha);
                } catch (ParseException ex) {
                    Logger.getLogger(pnlEquipos.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    fecha = formatofecha.parse(rs.getString("FechaCambioEquipo"));
                    dtpCambio.setDate(fecha);
                } catch (ParseException ex) {
                    Logger.getLogger(pnlEquipos.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    fecha = formatofecha.parse(rs.getString("FechaFacturacion"));
                    dtpFacturacion.setDate(fecha);
                } catch (ParseException ex) {
                    Logger.getLogger(pnlEquipos.class.getName()).log(Level.SEVERE, null, ex);
                }

                //switch para saber que radio button seleccionar
                String rdbFirma = rs.getString("Firma");
                switch (rdbFirma) {
                    case "SI":
                        btgFirma.setSelected(rdbSiFirma.getModel(), true);
                        break;
                    case "NO":
                        btgFirma.setSelected(rdbNoFirma.getModel(), true);
                        break;
                    default:
                        btgFirma.setSelected(rdbOtro.getModel(), true);
                        txtOtro.setText(rdbFirma);
                }
                //switch para saber que radio button seleccionar
                String rdbPagoSeguro = rs.getString("PagoSeguro");
                switch (rdbPagoSeguro) {
                    case "SI":
                        btgPago.setSelected(rdbSiSeguro.getModel(), true);
                        break;
                    case "NO":
                        btgPago.setSelected(rdbNoSeguro.getModel(), true);
                        break;
                    default:
                        break;
                }

            }
            txtLinea.enable(false);
            btnModificar.setVisible(true);
            btnEliminar.setVisible(true);
            btnCancelar.setVisible(true);
            btnGuardar.setVisible(false);
            LimpiarErrores();
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_tblLineasMouseClicked

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //se utiliza la funcion Eliminar de la clase AccionesCrud enviando el ID
        AccionesCrud classcrud = new AccionesCrud();
        if (classcrud.Eliminar(txtLinea, "exec EliminarLineaTelefonica ?")) {
            DatosTablas Datos = new DatosTablas();
            Datos.CargarTabla(tblLineas, "select * from [VistaLineasTelefonicas]");
            Limpiar();
            lblTotalPlanNuevo.setText("Suma Total de los Plan Nuevos: " + SumarValores(12) + "$");
            lblTotalPresupuesto.setText("Suma Total de los Presupuestos: " + SumarValores(13) + "$");
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        LimpiarErrores();
        if (ValidarCampos()) {
            //se crea un arreglo de objetos para enviar a la clase de AccionesCrud y la funcion de Guardar_Modificar
            Object[] datos = new Object[15];
            datos[0] = txtLinea.getText();
            datos[1] = txtNumExpediente.getText();
            datos[2] = cmbDisponibilidad.getSelectedItem().toString();
            datos[3] = txtYear.getYear();
            datos[4] = (Integer) txtCuotas.getValue();
            datos[5] = txtImei.getText();
            try {
                Date date = dtpAsignacion.getDate();
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);
                datos[6] = fecha.toString();
            } catch (Exception e) {
                datos[6] = "";
            }
            try {
                Date date = dtpCambio.getDate();
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);
                datos[7] = fecha.toString();
            } catch (Exception e) {
                datos[7] = "";
            }
            try {
                Date date = dtpFacturacion.getDate();
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);
                datos[8] = fecha.toString();
            } catch (Exception e) {
                datos[8] = "";
            }
            if (rdbSiSeguro.isSelected() == true) {
                datos[9] = 1;
            } else if (rdbNoSeguro.isSelected() == true) {
                datos[9] = 2;
            }
            if (rdbSiFirma.isSelected() == true) {
                datos[10] = "SI";
            } else if (rdbNoFirma.isSelected() == true) {
                datos[10] = "NO";
            } else if (rdbOtro.isSelected() == true) {
                datos[10] = txtOtro.getText();
            }

            datos[11] = Double.parseDouble(txtAnterior.getText());
            datos[12] = Double.parseDouble(txtNuevo.getText());
            datos[13] = Double.parseDouble(txtPresupuesto.getText());
            datos[14] = Double.parseDouble(txtMensual.getText());

            AccionesCrud classcrud = new AccionesCrud();
            if (classcrud.Guardar_Modificar(datos, "exec [AgregarLineaTelefonica] ?, ? ,?  ,? ,? ,? ,? ,? ,? ,?,?,?,?,?,?")) {
                DatosTablas Datos = new DatosTablas();
                Datos.CargarTabla(tblLineas, "select * from [VistaLineasTelefonicas]");
                lblTotalPlanNuevo.setText("Suma Total de los Plan Nuevos: " + SumarValores(12) + "$");
                lblTotalPresupuesto.setText("Suma Total de los Presupuestos: " + SumarValores(13) + "$");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        LimpiarErrores();
        if (ValidarCampos()) {
            //se crea un arreglo de objetos para enviar a la clase de AccionesCrud y la funcion de Guardar_Modificar
            Object[] datos = new Object[15];
            datos[0] = txtLinea.getText();
            datos[1] = txtNumExpediente.getText();
            if (cmbDisponibilidad.getSelectedItem() != null) {
                datos[2] = cmbDisponibilidad.getSelectedItem().toString();
            } else {
                datos[2] = "";
            }
            datos[3] = txtYear.getYear();
            datos[4] = (Integer) txtCuotas.getValue();
            datos[5] = txtImei.getText();
            try {
                Date date = dtpAsignacion.getDate();
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);
                datos[6] = fecha.toString();
            } catch (Exception e) {
                datos[6] = "";
            }
            try {
                Date date = dtpCambio.getDate();
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);
                datos[7] = fecha.toString();
            } catch (Exception e) {
                datos[7] = "";
            }
            try {
                Date date = dtpFacturacion.getDate();
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);
                datos[8] = fecha.toString();
            } catch (Exception e) {
                datos[8] = "";
            }
            if (rdbSiSeguro.isSelected() == true) {
                datos[9] = 1;
            } else if (rdbNoSeguro.isSelected() == true) {
                datos[9] = 2;
            }
            if (rdbSiFirma.isSelected() == true) {
                datos[10] = "SI";
            } else if (rdbNoFirma.isSelected() == true) {
                datos[10] = "NO";
            } else if (rdbOtro.isSelected() == true) {
                datos[10] = txtOtro.getText();
            }
            datos[11] = Double.parseDouble(txtAnterior.getText());
            datos[12] = Double.parseDouble(txtNuevo.getText());
            datos[13] = Double.parseDouble(txtPresupuesto.getText());
            datos[14] = Double.parseDouble(txtMensual.getText());

            AccionesCrud classcrud = new AccionesCrud();
            if (classcrud.Guardar_Modificar(datos, "exec [UpdateLineaTelefonica] ?, ? ,?  ,? ,? ,? ,? ,? ,? ,?,?,?,?,?,?")) {
                DatosTablas Datos = new DatosTablas();
                Datos.CargarTabla(tblLineas, "select * from [VistaLineasTelefonicas]");
                lblTotalPlanNuevo.setText("Suma Total de los Plan Nuevos: " + SumarValores(12) + "$");
                lblTotalPresupuesto.setText("Suma Total de los Presupuestos: " + SumarValores(13) + "$");
                Limpiar();
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    //Funicon para asignar el tipo de busqueda que se va hacer por medio de un switc y los valores de la vista de la BD
    private void cmbBuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBuscarItemStateChanged
        //Cada vez que se cambia el estado del combobox se cambia el filtro de busqueda global para la funcion de busqueda
        String elementoSeleccionado = (String) cmbBuscar.getSelectedItem();
        switch (elementoSeleccionado) {
            case "IMEI":
                Busqueda = "Imei";
                break;
            case "Linea de Telefono":
                Busqueda = "Linea";
                break;
            case "N. expediente":
                Busqueda = "Expediente";
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cmbBuscarItemStateChanged

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        //cada vez que se precione una tecla se va a buscar junto al filtro de busqueda en la vista correspondiente
        DatosTablas BusquedaTabla = new DatosTablas();
        //se limpia la tabla
        DefaultTableModel modelo = (DefaultTableModel) tblLineas.getModel();
        modelo.setRowCount(0);
        //se muestra los resultados de la busqueda
        BusquedaTabla.CargarTabla(tblLineas, "select * from VistaLineasTelefonicas where " + Busqueda + " LIKE '%" + txtBuscar.getText() + "%'");
        lblTotalPlanNuevo.setText("Suma Total de los Plan Nuevos: " + SumarValores(12) + "$");
        lblTotalPresupuesto.setText("Suma Total de los Presupuestos: " + SumarValores(13) + "$");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void btnDisponibilidadActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDisponibilidadActionPerformed
        //Abrir Formulario de Disponibilidad
        Disponibilidad CrudDisponible = new Disponibilidad();
        CrudDisponible.setVisible(true);
        CrudDisponible.pack();
        CrudDisponible.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnDisponibilidadActionPerformed

    private void cmbDisponibilidadItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbDisponibilidadItemStateChanged
        //al seleccionar un item se quita el estado de error
        val.CMBcorrecto(cmbDisponibilidad, lblErDisponible);
    }//GEN-LAST:event_cmbDisponibilidadItemStateChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNumExpedienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExpedienteKeyTyped
        int key = evt.getKeyChar();
        //solo perimitir numeros y retroceso
        boolean numero = key >= 48 && key <= 57 || key == KeyEvent.VK_BACK_SPACE;
        if (txtNumExpediente.getText().length() == 5 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNumExpedienteKeyTyped

    private void txtNumExpedienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExpedienteKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtNumExpediente, lblErExpediente);
    }//GEN-LAST:event_txtNumExpedienteKeyReleased

    private void txtLineaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLineaKeyTyped
        String text = txtLinea.getText();
        int key = evt.getKeyChar();
        //Solo permitir numeros
        boolean numero = key >= 48 && key <= 57 || key == KeyEvent.VK_BACK_SPACE;
        //identificar si es evento de retroceso
        boolean backSpace = (key == KeyEvent.VK_BACK_SPACE);
        //no permitir mas de 9 digitos y que no sea un guion
        if (txtLinea.getText().length() == 9 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
            //si son 4 caracteres y no es un retroceso se agrega un guion
        } else if (text.length() == 4 && !backSpace) {
            txtLinea.setText(text + "-");
        }
    }//GEN-LAST:event_txtLineaKeyTyped

    private void txtLineaKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLineaKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtLinea, lblErLinea);
    }//GEN-LAST:event_txtLineaKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CargarListas();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Limpiar();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtImeiKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImeiKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtImei, lblErImei);
    }//GEN-LAST:event_txtImeiKeyReleased

    private void txtImeiKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtImeiKeyTyped
        int key = evt.getKeyChar();
        //solo permite numeros y retroceso
        boolean numero = key >= 48 && key <= 57 || key == KeyEvent.VK_BACK_SPACE;
        if (txtImei.getText().length() == 15 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtImeiKeyTyped

    private void txtAnteriorKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnteriorKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtAnterior, lblErAnterior);
    }//GEN-LAST:event_txtAnteriorKeyReleased

    private void txtAnteriorKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAnteriorKeyTyped
        int key = evt.getKeyChar();
        //expresion regular que solo permite numeros, tecla de eliminar y un punto
        boolean numero = (key >= 48 && key <= 57) || (key == 46 && !txtAnterior.getText().contains(".")) || key == KeyEvent.VK_BACK_SPACE;
        if (txtAnterior.getText().length() == 8 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtAnteriorKeyTyped

    private void txtNuevoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevoKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtNuevo, lblErNuevo);
    }//GEN-LAST:event_txtNuevoKeyReleased

    private void txtNuevoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNuevoKeyTyped
        int key = evt.getKeyChar();
        //expresion regular que solo permite numeros, tecla de eliminar y un punto
        boolean numero = (key >= 48 && key <= 57) || (key == 46 && !txtNuevo.getText().contains(".")) || key == KeyEvent.VK_BACK_SPACE;
        if (txtNuevo.getText().length() == 8 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNuevoKeyTyped

    private void txtPresupuestoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresupuestoKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtPresupuesto, lblErPresupuesto);
    }//GEN-LAST:event_txtPresupuestoKeyReleased

    private void txtPresupuestoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtPresupuestoKeyTyped
        int key = evt.getKeyChar();
        //expresion regular que solo permite numeros, tecla de eliminar y un punto
        boolean numero = (key >= 48 && key <= 57) || (key == 46 && !txtPresupuesto.getText().contains(".")) || key == KeyEvent.VK_BACK_SPACE;
        if (txtPresupuesto.getText().length() == 8 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtPresupuestoKeyTyped

    private void txtMensualKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMensualKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtMensual, lblErMensual);
    }//GEN-LAST:event_txtMensualKeyReleased

    private void txtMensualKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtMensualKeyTyped
        int key = evt.getKeyChar();
        //expresion regular que solo permite numeros, tecla de eliminar y un punto
        boolean numero = (key >= 48 && key <= 57) || (key == 46 && !txtMensual.getText().contains(".")) || key == KeyEvent.VK_BACK_SPACE;
        if (txtMensual.getText().length() == 8 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtMensualKeyTyped

    private void txtOtroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtroKeyTyped
        int key = evt.getKeyChar();
        //perimite escribir solo letras , numeros y retroceso
        boolean letra = (key >= 65 && key <= 90) || (key >= 97 && key <= 122 || key >= 48 && key <= 57 || key == KeyEvent.VK_SPACE || key == KeyEvent.VK_BACK_SPACE);
        if (txtOtro.getText().length() == 50 || !letra) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtOtroKeyTyped

    private void txtOtroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtOtroKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtOtro, lblErFirma);
    }//GEN-LAST:event_txtOtroKeyReleased

    private void rdbNoFirmaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbNoFirmaItemStateChanged
        //al seleccionar este radioButton se pone el estado en correcto y se pone invisible el txt de la opcion otro
        txtOtro.setVisible(false);
        val.GENcorrecto(lblErFirma);
    }//GEN-LAST:event_rdbNoFirmaItemStateChanged

    private void rdbSiFirmaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbSiFirmaItemStateChanged
        //al seleccionar este radioButton se pone el estado en correcto y se pone invisible el txt de la opcion otro
        txtOtro.setVisible(false);
        val.GENcorrecto(lblErFirma);
    }//GEN-LAST:event_rdbSiFirmaItemStateChanged

    private void rdbOtroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbOtroItemStateChanged
        //al seleccionar este radioButton se pone el estado en correcto y se pone visible el text junto al focus para escribir
        txtOtro.setVisible(true);
        txtOtro.requestFocus();
        val.GENcorrecto(lblErFirma);
    }//GEN-LAST:event_rdbOtroItemStateChanged

    private void txtCuotasStateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_txtCuotasStateChanged
        //al cambiar el numero de cuotas se pone el estado en correcto
        val.GENcorrecto(lblErCuotas);
    }//GEN-LAST:event_txtCuotasStateChanged

    private void rdbSiSeguroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbSiSeguroItemStateChanged
        //al seleccionar un radio button de seguros se quita el mensaje de error
        val.GENcorrecto(lblErPago);
    }//GEN-LAST:event_rdbSiSeguroItemStateChanged

    private void rdbNoSeguroItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_rdbNoSeguroItemStateChanged
        //al seleccionar un radio button de seguros se quita el mensaje de error
        val.GENcorrecto(lblErPago);
    }//GEN-LAST:event_rdbNoSeguroItemStateChanged

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        int key = evt.getKeyChar();
        // evaluar si la tecla presionada representa una letra (mayúscula o minúscula), un número, un espacio en blanco, la tecla de retroceso o cualquier otra tecla que no sea el signo "+" 
        boolean letra = (key >= 65 && key <= 90) || (key >= 97 && key <= 122 || key >= 46 && key <= 57 || (key != 43) || key == KeyEvent.VK_SPACE || key == KeyEvent.VK_BACK_SPACE);
        if (txtBuscar.getText().length() == 30 || !letra) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro btnCancelar;
    private javax.swing.JButton btnDisponibilidad;
    private rsbuttom.RSButtonMetro btnEliminar;
    private rsbuttom.RSButtonMetro btnGuardar;
    private rsbuttom.RSButtonMetro btnModificar;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmbDisponibilidad;
    private com.toedter.calendar.JDateChooser dtpAsignacion;
    private com.toedter.calendar.JDateChooser dtpCambio;
    private com.toedter.calendar.JDateChooser dtpFacturacion;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel18;
    private javax.swing.JLabel jLabel19;
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
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErAnterior;
    private javax.swing.JLabel lblErAsignacion;
    private javax.swing.JLabel lblErCambio;
    private javax.swing.JLabel lblErCuotas;
    private javax.swing.JLabel lblErDisponible;
    private javax.swing.JLabel lblErExpediente;
    private javax.swing.JLabel lblErFacturacion;
    private javax.swing.JLabel lblErFirma;
    private javax.swing.JLabel lblErImei;
    private javax.swing.JLabel lblErLinea;
    private javax.swing.JLabel lblErMensual;
    private javax.swing.JLabel lblErNuevo;
    private javax.swing.JLabel lblErPago;
    private javax.swing.JLabel lblErPresupuesto;
    private javax.swing.JLabel lblTotalPlanNuevo;
    private javax.swing.JLabel lblTotalPresupuesto;
    private javax.swing.JRadioButton rdbNoFirma;
    private javax.swing.JRadioButton rdbNoSeguro;
    private javax.swing.JRadioButton rdbOtro;
    private javax.swing.JRadioButton rdbSiFirma;
    private javax.swing.JRadioButton rdbSiSeguro;
    private javax.swing.JTable tblLineas;
    private javax.swing.JTextField txtAnterior;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JSpinner txtCuotas;
    private javax.swing.JTextField txtImei;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtMensual;
    private javax.swing.JTextField txtNuevo;
    private javax.swing.JTextField txtNumExpediente;
    private javax.swing.JTextField txtOtro;
    private javax.swing.JTextField txtPresupuesto;
    private com.toedter.calendar.JYearChooser txtYear;
    // End of variables declaration//GEN-END:variables
}
