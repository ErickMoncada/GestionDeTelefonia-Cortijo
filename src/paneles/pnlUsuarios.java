package paneles;

import Clases.AccionesCrud;
import Clases.DatosTablas;
import Clases.validaciones;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import paneles.ExtraUsuarios.Categoria;
import paneles.ExtraUsuarios.CentroCosto;
import paneles.ExtraUsuarios.Planilla;
import paneles.ExtraUsuarios.PuestoTrabajo;
import paneles.ExtraUsuarios.Ubicacion;

public class pnlUsuarios extends javax.swing.JPanel {

    public pnlUsuarios(String NIVEL) {
        initComponents();
        CargarDatosPrincipal();
        Limpiar();
        asignarEventos();
        //se comprueba si es lector o administrador
        if ("Lector".equals(NIVEL)) {
            jPanel3.setVisible(false);
            jPanel2.setVisible(false);
            jPanel4.setVisible(false);
        }
        NivelAcceso = NIVEL;
    }
    //se inicializa para la busqueda por medio de Categoria
    String Busqueda = "CategoriaUser";
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
        txtNumExpediente.enable(true);

        txtNumExpediente.setText("");
        txtCodEmpleado.setText("");
        txtNombre.setText("");
        cmbCentroCosto.setSelectedIndex(-1);
        cmbPlanilla.setSelectedIndex(-1);
        cmbPuesto.setSelectedIndex(-1);
        txtSAP.setText("");
        txtJefe.setText("");
        cmbUbicacion.setSelectedIndex(-1);
        cmbCategoria.setSelectedIndex(-1);
        LimpiarErrores();
    }

    private void asignarEventos() {
        //funcion para asignar los eventos a los mensajes de obligatorio con la clase de validaciones
        val.asignarEventosMouse(lblObligatorio);
        val.asignarEventosMouse(lblObligatorio2);
        val.asignarEventosMouse(lblObligatorio3);
        val.asignarEventosMouse(lblObligatorio4);
        val.asignarEventosMouse(lblObligatorio5);
        val.asignarEventosMouse(lblObligatorio6);
        val.asignarEventosMouse(lblObligatorio7);
        val.asignarEventosMouse(lblObligatorio8);
    }

    private void CargarDatosPrincipal() {
        //rellenar datos de la tabla
        DatosTablas Datos = new DatosTablas();
        Datos.CargarTabla(tblUsuarios, "select * from VistaUsuarios");
        //llenar los datos de los combobox
        CargarListas();
    }

    private void CargarListas() {
        // Lista de JComboBox para actualizar datos
        JComboBox[] comboBoxes = {cmbCentroCosto, cmbPlanilla, cmbPuesto, cmbUbicacion, cmbCategoria};

        // Recorrer cada JComboBox y eliminar los elementos
        for (JComboBox comboBox : comboBoxes) {
            DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
            model.removeAllElements();
            model.addElement("");
        }
        //cargar los datos de los combobox
        DatosTablas Datos = new DatosTablas();
        Datos.cargarComboBox("select CentroCosto from VistaCentroCosto", "CentroCosto", cmbCentroCosto);
        Datos.cargarComboBox("select Planilla from VistaPlanillas", "Planilla", cmbPlanilla);
        Datos.cargarComboBox("select Puesto from VistaPuestosTrabajos", "Puesto", cmbPuesto);
        Datos.cargarComboBox("select Ubicacion from VistaUbicaciones", "Ubicacion", cmbUbicacion);
        Datos.cargarComboBox("select Categoria from VistaCategoriaUser", "Categoria", cmbCategoria);
    }

    private void LimpiarErrores() {
        //usando la clase de validaciones se establecen los valores en correcto
        val.TXTcorrecto(txtNumExpediente, lblErExpediente);
        val.TXTcorrecto(txtCodEmpleado, lblErCodigo);
        val.TXTcorrecto(txtNombre, lblErNombre);
        val.CMBcorrecto(cmbCentroCosto, lblErCosto);
        val.CMBcorrecto(cmbPlanilla, lblErPlanilla);
        val.CMBcorrecto(cmbPuesto, lblErPuesto);
        val.CMBcorrecto(cmbUbicacion, lblErUbicacion);
        val.CMBcorrecto(cmbCategoria, lblErCategoria);
        val.TXTcorrecto(txtSAP, lblErSAP);
    }

    private boolean ValidarCampos() {

        int valor1 = 1;
        String error;
        //validar que no este vacio u otro parametro mas
        if (txtNumExpediente.getText().isEmpty() || !txtNumExpediente.getText().matches("\\d{0,4}")) {
            //asignar 0 al valor para devolver falso en la validacion
            valor1 = 0;
            //mensaje de error para el respectivo campo de texto
            error = "El numero de expediente no puede estar en blanco";
            //asignar colores de error a cada campo
            val.TXTincorrecto(txtNumExpediente, lblErExpediente, error);
        }
        if (txtCodEmpleado.getText().isEmpty() || !txtCodEmpleado.getText().matches("\\d{0,6}")) {
            valor1 = 0;
            error = "El codigo de empleado no puede estar en blanco";
            val.TXTincorrecto(txtCodEmpleado, lblErCodigo, error);
        }
        if (txtNombre.getText().isEmpty() || !txtNombre.getText().matches("^[A-Za-z\\s]+$")) {
            valor1 = 0;
            error = "El nombre del empleado no puede estar en blanco";
            val.TXTincorrecto(txtNombre, lblErNombre, error);
        }
        if (cmbCentroCosto.getSelectedItem() == null || cmbCentroCosto.getSelectedItem() == "") {
            valor1 = 0;
            error = "Seleccione un Centro de Costo";
            val.CMBincorrecto(cmbCentroCosto, lblErCosto, error);
        }
        if (cmbPlanilla.getSelectedItem() == null || cmbPlanilla.getSelectedItem() == "") {
            valor1 = 0;
            error = "Seleccione una planilla";
            val.CMBincorrecto(cmbPlanilla, lblErPlanilla, error);
        }
        if (cmbCategoria.getSelectedItem() == null || cmbCategoria.getSelectedItem() == "") {
            valor1 = 0;
            error = "Seleccione una Categoria";
            val.CMBincorrecto(cmbCategoria, lblErCategoria, error);
        }
        if (cmbPuesto.getSelectedItem() == null || cmbPuesto.getSelectedItem() == "") {
            valor1 = 0;
            error = "Seleccione un Puesto";
            val.CMBincorrecto(cmbPuesto, lblErPuesto, error);
        }
        if (cmbUbicacion.getSelectedItem() == null || cmbUbicacion.getSelectedItem() == "") {
            valor1 = 0;
            error = "Seleccione una Ubicacion";
            val.CMBincorrecto(cmbUbicacion, lblErUbicacion, error);
        }

        if (!"".equals(txtSAP.getText()) && !txtSAP.getText().matches("\\d{8}")) {
             valor1 = 0;
            error = "Codigo incompleto";
            val.TXTincorrecto(txtSAP, lblErSAP, error);
        }

        return valor1 == 1; //Expreciones regulares de los campos
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        cmbBuscar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumExpediente = new javax.swing.JTextField();
        btnCancelar = new rsbuttom.RSButtonMetro();
        lblErExpediente = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtCodEmpleado = new javax.swing.JTextField();
        lblErCodigo = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        lblErNombre = new javax.swing.JLabel();
        lblObligatorio = new javax.swing.JLabel();
        lblObligatorio2 = new javax.swing.JLabel();
        lblObligatorio3 = new javax.swing.JLabel();
        btnGuardar = new rsbuttom.RSButtonMetro();
        btnModificar = new rsbuttom.RSButtonMetro();
        btnEliminar = new rsbuttom.RSButtonMetro();
        jPanel4 = new javax.swing.JPanel();
        btnCrudCC3 = new javax.swing.JButton();
        btnCrudUbi = new javax.swing.JButton();
        jLabel11 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtJefe = new javax.swing.JTextField();
        cmbUbicacion = new javax.swing.JComboBox<>();
        jLabel10 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        lblErUbicacion = new javax.swing.JLabel();
        lblErCategoria = new javax.swing.JLabel();
        lblObligatorio7 = new javax.swing.JLabel();
        lblObligatorio8 = new javax.swing.JLabel();
        jPanel2 = new javax.swing.JPanel();
        jLabel5 = new javax.swing.JLabel();
        cmbCentroCosto = new javax.swing.JComboBox<>();
        btnCrudCC = new javax.swing.JButton();
        jLabel7 = new javax.swing.JLabel();
        cmbPlanilla = new javax.swing.JComboBox<>();
        btnCRUDPlanilla = new javax.swing.JButton();
        lblErCosto = new javax.swing.JLabel();
        lblErPlanilla = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSAP = new javax.swing.JTextField();
        lblErPuesto = new javax.swing.JLabel();
        lblObligatorio4 = new javax.swing.JLabel();
        lblObligatorio5 = new javax.swing.JLabel();
        lblErSAP = new javax.swing.JLabel();
        cmbPuesto = new javax.swing.JComboBox<>();
        jLabel8 = new javax.swing.JLabel();
        btnCrudPuesto = new javax.swing.JButton();
        lblObligatorio6 = new javax.swing.JLabel();

        jMenuItem1.setText("Actualizar datos desplegables");
        jMenuItem1.setName("actualizarTabla"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        jMenuItem2.setLabel("Limpiar Campos");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem2);

        setBackground(new java.awt.Color(255, 255, 255));
        setComponentPopupMenu(jPopupMenu1);
        setNextFocusableComponent(txtNumExpediente);
        setPreferredSize(new java.awt.Dimension(1920, 781));

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 403));

        tblUsuarios.setBackground(new java.awt.Color(204, 255, 204));
        tblUsuarios.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N. Expediente", "Nombre", "Cod. Empleado", "Num. Centro Costo", "Centro de Costo", "Planilla", "Cod. SAP", "Puesto de Trabajo", "Jefe", "Ubicación", "Categoría"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.setGridColor(new java.awt.Color(0, 0, 0));
        tblUsuarios.setSelectionBackground(new java.awt.Color(51, 153, 0));
        tblUsuarios.getTableHeader().setReorderingAllowed(false);
        tblUsuarios.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblUsuariosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblUsuarios);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtBuscarKeyTyped(evt);
            }
        });

        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoría", "Centro Costo", "Cod. Empleado", "Codigo SAP", "Jefe", "N. Expediente", "Nombre", "Planilla", "Puesto de Trabajo", "Ubicación" }));
        cmbBuscar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbBuscarItemStateChanged(evt);
            }
        });

        jLabel2.setText("Buscar por:");

        jPanel3.setNextFocusableComponent(txtNumExpediente);
        jPanel3.setOpaque(false);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Número de Expediente:");

        txtNumExpediente.setNextFocusableComponent(txtCodEmpleado);
        txtNumExpediente.setPreferredSize(new java.awt.Dimension(65, 26));
        txtNumExpediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumExpedienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumExpedienteKeyTyped(evt);
            }
        });

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

        lblErExpediente.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErExpediente.setForeground(new java.awt.Color(255, 0, 0));
        lblErExpediente.setText("Error");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Código Empleado:");

        txtCodEmpleado.setNextFocusableComponent(txtNombre);
        txtCodEmpleado.setPreferredSize(new java.awt.Dimension(65, 26));
        txtCodEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodEmpleadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodEmpleadoKeyTyped(evt);
            }
        });

        lblErCodigo.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErCodigo.setForeground(new java.awt.Color(255, 0, 0));
        lblErCodigo.setText("Error");

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre de usuario:");

        txtNombre.setNextFocusableComponent(cmbCentroCosto);
        txtNombre.setPreferredSize(new java.awt.Dimension(65, 26));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        lblErNombre.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErNombre.setForeground(new java.awt.Color(255, 0, 0));
        lblErNombre.setText("Error");

        lblObligatorio.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio.setText("*");
        lblObligatorio.setToolTipText("");

        lblObligatorio2.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio2.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio2.setText("*");
        lblObligatorio2.setToolTipText("");

        lblObligatorio3.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio3.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio3.setText("*");
        lblObligatorio3.setToolTipText("");

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

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel1)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblErNombre)
                            .addComponent(lblErCodigo)
                            .addComponent(lblErExpediente)
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(txtCodEmpleado, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                    .addComponent(txtNumExpediente, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel3Layout.createSequentialGroup()
                                        .addComponent(lblObligatorio)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(lblObligatorio2)))
                            .addGroup(jPanel3Layout.createSequentialGroup()
                                .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(lblObligatorio3))))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txtNumExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObligatorio, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErExpediente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtCodEmpleado, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addComponent(lblObligatorio2, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErCodigo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3)
                    .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(lblObligatorio3, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErNombre)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        jPanel4.setNextFocusableComponent(txtNumExpediente);
        jPanel4.setOpaque(false);

        btnCrudCC3.setText("+");
        btnCrudCC3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudCC3ActionPerformed(evt);
            }
        });

        btnCrudUbi.setText("+");
        btnCrudUbi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudUbiActionPerformed(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Categoría:");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Jefe:");

        txtJefe.setNextFocusableComponent(cmbUbicacion);
        txtJefe.setPreferredSize(new java.awt.Dimension(65, 26));
        txtJefe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJefeKeyTyped(evt);
            }
        });

        cmbUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbUbicacion.setNextFocusableComponent(cmbCategoria);
        cmbUbicacion.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbUbicacionItemStateChanged(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Ubicación:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbCategoria.setNextFocusableComponent(btnGuardar);
        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });

        lblErUbicacion.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErUbicacion.setForeground(new java.awt.Color(255, 0, 0));
        lblErUbicacion.setText("Error");

        lblErCategoria.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErCategoria.setForeground(new java.awt.Color(255, 0, 0));
        lblErCategoria.setText("Error");

        lblObligatorio7.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio7.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio7.setText("*");
        lblObligatorio7.setToolTipText("");

        lblObligatorio8.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio8.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio8.setText("*");
        lblObligatorio8.setToolTipText("");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel11)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel10)
                        .addComponent(jLabel9)))
                .addGap(18, 18, 18)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(lblErCategoria)
                    .addComponent(lblErUbicacion)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(cmbCategoria, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(txtJefe, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel4Layout.createSequentialGroup()
                                .addComponent(cmbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnCrudCC3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblObligatorio8))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(btnCrudUbi)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblObligatorio7)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel9)
                    .addComponent(txtJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(cmbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrudUbi, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObligatorio7, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(3, 3, 3)
                .addComponent(lblErUbicacion)
                .addGap(1, 1, 1)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel11)
                    .addComponent(btnCrudCC3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObligatorio8, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErCategoria)
                .addContainerGap(79, Short.MAX_VALUE))
        );

        jPanel2.setMaximumSize(new java.awt.Dimension(319, 200));
        jPanel2.setNextFocusableComponent(txtNumExpediente);
        jPanel2.setOpaque(false);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Centro de Costo:");

        cmbCentroCosto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbCentroCosto.setMaximumSize(new java.awt.Dimension(33, 26));
        cmbCentroCosto.setNextFocusableComponent(cmbPlanilla);
        cmbCentroCosto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCentroCostoItemStateChanged(evt);
            }
        });

        btnCrudCC.setText("+");
        btnCrudCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudCCActionPerformed(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Planilla:");

        cmbPlanilla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbPlanilla.setMaximumSize(new java.awt.Dimension(33, 26));
        cmbPlanilla.setNextFocusableComponent(txtSAP);
        cmbPlanilla.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPlanillaItemStateChanged(evt);
            }
        });

        btnCRUDPlanilla.setText("+");
        btnCRUDPlanilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCRUDPlanillaActionPerformed(evt);
            }
        });

        lblErCosto.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErCosto.setForeground(new java.awt.Color(255, 0, 0));
        lblErCosto.setText("Error");

        lblErPlanilla.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErPlanilla.setForeground(new java.awt.Color(255, 0, 0));
        lblErPlanilla.setText("Error");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Código SAP:");

        txtSAP.setNextFocusableComponent(cmbPuesto);
        txtSAP.setPreferredSize(new java.awt.Dimension(65, 26));
        txtSAP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSAPKeyTyped(evt);
            }
        });

        lblErPuesto.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErPuesto.setForeground(new java.awt.Color(255, 0, 0));
        lblErPuesto.setText("Error");

        lblObligatorio4.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio4.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio4.setText("*");
        lblObligatorio4.setToolTipText("");

        lblObligatorio5.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio5.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio5.setText("*");
        lblObligatorio5.setToolTipText("");

        lblErSAP.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErSAP.setForeground(new java.awt.Color(255, 0, 0));
        lblErSAP.setText("Error");

        cmbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbPuesto.setMaximumSize(new java.awt.Dimension(33, 26));
        cmbPuesto.setNextFocusableComponent(txtJefe);
        cmbPuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPuestoItemStateChanged(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Puesto de Trabajo:");

        btnCrudPuesto.setText("+");
        btnCrudPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudPuestoActionPerformed(evt);
            }
        });

        lblObligatorio6.setFont(new java.awt.Font("Dialog", 1, 18)); // NOI18N
        lblObligatorio6.setForeground(new java.awt.Color(51, 51, 51));
        lblObligatorio6.setText("*");
        lblObligatorio6.setToolTipText("");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jLabel7))
                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(txtSAP, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbPlanilla, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCRUDPlanilla)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblObligatorio5))
                            .addComponent(lblErSAP)
                            .addComponent(lblErCosto)
                            .addComponent(lblErPlanilla))
                        .addGap(0, 0, Short.MAX_VALUE))))
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(cmbCentroCosto, 0, 244, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCrudCC)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblObligatorio4)
                .addContainerGap())
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 106, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel2Layout.createSequentialGroup()
                        .addComponent(cmbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 244, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnCrudPuesto)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblObligatorio6))
                    .addComponent(lblErPuesto))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(cmbCentroCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCrudCC, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObligatorio4, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(cmbPlanilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCRUDPlanilla, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObligatorio5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErPlanilla, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtSAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErSAP, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel8)
                    .addComponent(btnCrudPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblObligatorio6, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 20, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(50, 50, 50)
                        .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 1920, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)))
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 496, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCrudCCActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudCCActionPerformed
        //Abrir Formulario de CentroCosto
        CentroCosto CrudCosto = new CentroCosto();
        CrudCosto.setVisible(true);
        CrudCosto.pack();
        CrudCosto.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCrudCCActionPerformed

    private void btnCrudPuestoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudPuestoActionPerformed
        //Abrir Formulario de Puestos de Trabajo
        PuestoTrabajo PuestoTrabajo = new PuestoTrabajo();
        PuestoTrabajo.setVisible(true);
        PuestoTrabajo.pack();
        PuestoTrabajo.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCrudPuestoActionPerformed

    private void btnCRUDPlanillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCRUDPlanillaActionPerformed
        //Abrir Formulario de Planilla
        Planilla CrudPlanilla = new Planilla();
        CrudPlanilla.setVisible(true);
        CrudPlanilla.pack();
        CrudPlanilla.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCRUDPlanillaActionPerformed

    private void btnCrudCC3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudCC3ActionPerformed
        //Abrir Formulario de Categoria de usuario
        Categoria CrudCategoria = new Categoria();
        CrudCategoria.setVisible(true);
        CrudCategoria.pack();
        CrudCategoria.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCrudCC3ActionPerformed

    private void btnCrudUbiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCrudUbiActionPerformed
        //Abrir Formulario de Ubicacion
        Ubicacion CrudUbicacion = new Ubicacion();
        CrudUbicacion.setVisible(true);
        CrudUbicacion.pack();
        CrudUbicacion.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCrudUbiActionPerformed

    private Object[] ArregloDatos() {
        //se crea un arreglo de objetos para enviar a la clase de AccionesCrud y la funcion de Guardar_Modificar
        Object[] datos = new Object[10];
        datos[0] = Integer.parseInt(txtNumExpediente.getText());
        datos[1] = txtNombre.getText().trim();
        datos[2] = Integer.parseInt(txtCodEmpleado.getText());
        datos[3] = cmbCentroCosto.getSelectedItem().toString();
        datos[4] = cmbPlanilla.getSelectedItem().toString();
        datos[5] = txtSAP.getText();
        if (cmbPuesto.getSelectedItem() != null) {
            datos[6] = cmbPuesto.getSelectedItem().toString();
        } else {
            datos[6] = "";
        }
        datos[7] = txtJefe.getText().trim();
        if (cmbUbicacion.getSelectedItem() != null) {
            datos[8] = cmbUbicacion.getSelectedItem().toString();
        } else {
            datos[8] = "";
        }
        datos[9] = cmbCategoria.getSelectedItem().toString();
        return datos;
    }
    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        LimpiarErrores();
        if (ValidarCampos()) {
            AccionesCrud classcrud = new AccionesCrud();
            if (classcrud.Guardar_Modificar(ArregloDatos(), "exec [UpdateUsuario] ?, ? ,?  ,? ,? ,? ,? ,? ,? ,?")) {
                DatosTablas Datos = new DatosTablas();
                Datos.CargarTabla(tblUsuarios, "select * from VistaUsuarios");
            }
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        LimpiarErrores();
        if (ValidarCampos()) {
            AccionesCrud classcrud = new AccionesCrud();
            if (classcrud.Guardar_Modificar(ArregloDatos(), "exec [AgregarUsuario] ?, ? ,?  ,? ,? ,? ,? ,? ,? ,?")) {
                DatosTablas Datos = new DatosTablas();
                Datos.CargarTabla(tblUsuarios, "select * from VistaUsuarios");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //se utiliza la funcion Eliminar de la clase AccionesCrud enviando el ID
        AccionesCrud classcrud = new AccionesCrud();
        if (classcrud.Eliminar(txtNumExpediente, "exec EliminarUsuario ?")) {
            DatosTablas Datos = new DatosTablas();
            Datos.CargarTabla(tblUsuarios, "select * from VistaUsuarios");
            Limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        if ("Administrador".equals(NivelAcceso)) {
            LimpiarErrores();
            CargarListas();
            //se trata de obtener los datos de la tabla para mostrarlos en las casillas respectivas con ayuda de sql
            try {
                AccionesCrud classcrud = new AccionesCrud();
                ResultSet rs = classcrud.Seleccion(tblUsuarios, "select * from [VistaUsuarios] where [NumeroExpediente]=?", "N. Expediente");
                while (rs.next()) {
                    txtNumExpediente.setText(rs.getString("NumeroExpediente"));
                    txtNombre.setText(rs.getString("UsuarioDeLinea"));
                    txtCodEmpleado.setText(rs.getString("CodigoEmpleado"));
                    cmbCentroCosto.setSelectedItem(rs.getString("CentroCosto"));
                    cmbPlanilla.setSelectedItem(rs.getString("Planilla"));
                    txtSAP.setText(rs.getString("CodSAP"));
                    cmbPuesto.setSelectedItem(rs.getString("Puesto"));
                    txtJefe.setText(rs.getString("Superior_jefe"));
                    cmbUbicacion.setSelectedItem(rs.getString("Ubicacion"));
                    cmbCategoria.setSelectedItem(rs.getString("CategoriaUser"));
                }
                txtNumExpediente.enable(false);
                btnModificar.setVisible(true);
                btnEliminar.setVisible(true);
                btnCancelar.setVisible(true);
                btnGuardar.setVisible(false);
            } catch (SQLException e) {
                JOptionPane.showMessageDialog(null, e.toString());
            }
        }
    }//GEN-LAST:event_tblUsuariosMouseClicked

    //Funicon para asignar el tipo de busqueda que se va hacer por medio de un switc y los valores de la vista de la BD
    private void cmbBuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBuscarItemStateChanged
        //Cada vez que se cambia el estado del combobox se cambia el filtro de busqueda global para la funcion de busqueda
        String elementoSeleccionado = (String) cmbBuscar.getSelectedItem();
        switch (elementoSeleccionado) {
            case "Categoría":
                Busqueda = "CategoriaUser";
                break;
            case "Centro Costo":
                Busqueda = "CentroCosto";
                break;
            case "Cod. Empleado":
                Busqueda = "CodigoEmpleado";
                break;
            case "Codigo SAP":
                Busqueda = "CodSAP";
                break;
            case "Jefe":
                Busqueda = "Superior_jefe";
                break;
            case "N. Expediente":
                Busqueda = "NumeroExpediente";
                break;
            case "Nombre":
                Busqueda = "UsuarioDeLinea";
                break;
            case "Planilla":
                Busqueda = "Planilla";
                break;
            case "Puesto de Trabajo":
                Busqueda = "Puesto";
                break;
            case "Ubicación":
                Busqueda = "Ubicacion";
                break;
            default:
                break;
        }
        txtBuscar.setText("");
    }//GEN-LAST:event_cmbBuscarItemStateChanged

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        //cada vez que se precione una tecla se va a buscar junto al filtro de busqueda en la vista correspondiente
        DatosTablas BusquedaTabla = new DatosTablas();
        //se limpia la tabla
        DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
        modelo.setRowCount(0);
        //se muestra los resultados de la busqueda
        BusquedaTabla.CargarTabla(tblUsuarios, "select * from VistaUsuarios where " + Busqueda + " LIKE '%" + txtBuscar.getText().trim() + "%'");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtNumExpedienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExpedienteKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtNumExpediente, lblErExpediente);
    }//GEN-LAST:event_txtNumExpedienteKeyReleased

    private void txtCodEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodEmpleadoKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtCodEmpleado, lblErCodigo);
    }//GEN-LAST:event_txtCodEmpleadoKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtNombre, lblErNombre);
        String nombre = txtNombre.getText().toUpperCase();
        txtNombre.setText(nombre);
    }//GEN-LAST:event_txtNombreKeyReleased

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        //al seleccionar un item se quita el estado de error
        val.CMBcorrecto(cmbCategoria, lblErCategoria);
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void cmbCentroCostoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCentroCostoItemStateChanged
        //al seleccionar un item se quita el estado de error
        val.CMBcorrecto(cmbCentroCosto, lblErCosto);
    }//GEN-LAST:event_cmbCentroCostoItemStateChanged

    private void cmbPlanillaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPlanillaItemStateChanged
        //al seleccionar un item se quita el estado de error
        val.CMBcorrecto(cmbPlanilla, lblErPlanilla);
    }//GEN-LAST:event_cmbPlanillaItemStateChanged

    private void cmbPuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPuestoItemStateChanged
        //al seleccionar un item se quita el estado de error
        val.CMBcorrecto(cmbPuesto, lblErPuesto);
    }//GEN-LAST:event_cmbPuestoItemStateChanged

    private void txtNumExpedienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExpedienteKeyTyped
        val.EntradaNumeros(txtNumExpediente, evt, 4);
    }//GEN-LAST:event_txtNumExpedienteKeyTyped

    private void txtCodEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodEmpleadoKeyTyped
        val.EntradaNumeros(txtCodEmpleado, evt, 5);
    }//GEN-LAST:event_txtCodEmpleadoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        //validado para campo de tipo normal
        val.EntradaSoloLetas(txtNombre, evt, 80);
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtSAPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSAPKeyTyped
        //validado para el campo tipo SAP
        val.EntradaNumeros(txtSAP, evt, 8);
    }//GEN-LAST:event_txtSAPKeyTyped

    private void txtJefeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJefeKeyTyped
        //validacion para un campo de tipo normal
        val.EntradaTextoNormal(txtJefe, evt, 50);
    }//GEN-LAST:event_txtJefeKeyTyped

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        CargarListas();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void cmbUbicacionItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbUbicacionItemStateChanged
        //al seleccionar un item se quita el estado de error
        val.CMBcorrecto(cmbUbicacion, lblErUbicacion);
    }//GEN-LAST:event_cmbUbicacionItemStateChanged

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Limpiar();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtBuscarKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyTyped
        switch (Busqueda) {
            case "CategoriaUser":
                val.EntradaLetrasNumeroGuion(txtBuscar, evt, 15);
                break;
            case "CentroCosto":
                val.EntradaTextoNormal(txtBuscar, evt, 80);
                break;
            case "CodigoEmpleado":
                val.EntradaNumeros(txtBuscar, evt, 5);
                break;
            case "CodSAP":
                val.EntradaNumeros(txtBuscar, evt, 8);
                break;
            case "Superior_jefe":
                val.EntradaTextoNormal(txtBuscar, evt, 50);
                break;
            case "NumeroExpediente":
                val.EntradaNumeros(txtBuscar, evt, 4);
                break;
            case "UsuarioDeLinea":
                val.EntradaSoloLetas(txtBuscar, evt, 80);
                break;
            case "Planilla":
                val.EntradaTextoNormal(txtBuscar, evt, 30);
                break;
            case "Puesto":
                val.EntradaTextoNormal(txtBuscar, evt, 60);
                break;
            case "Ubicacion":
                val.EntradaTextoNormal(txtBuscar, evt, 80);
                break;
            default:
                break;
        }
    }//GEN-LAST:event_txtBuscarKeyTyped


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCRUDPlanilla;
    private rsbuttom.RSButtonMetro btnCancelar;
    private javax.swing.JButton btnCrudCC;
    private javax.swing.JButton btnCrudCC3;
    private javax.swing.JButton btnCrudPuesto;
    private javax.swing.JButton btnCrudUbi;
    private rsbuttom.RSButtonMetro btnEliminar;
    private rsbuttom.RSButtonMetro btnGuardar;
    private rsbuttom.RSButtonMetro btnModificar;
    private javax.swing.JComboBox<String> cmbBuscar;
    private javax.swing.JComboBox<String> cmbCategoria;
    private javax.swing.JComboBox<String> cmbCentroCosto;
    private javax.swing.JComboBox<String> cmbPlanilla;
    private javax.swing.JComboBox<String> cmbPuesto;
    private javax.swing.JComboBox<String> cmbUbicacion;
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
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErCategoria;
    private javax.swing.JLabel lblErCodigo;
    private javax.swing.JLabel lblErCosto;
    private javax.swing.JLabel lblErExpediente;
    private javax.swing.JLabel lblErNombre;
    private javax.swing.JLabel lblErPlanilla;
    private javax.swing.JLabel lblErPuesto;
    private javax.swing.JLabel lblErSAP;
    private javax.swing.JLabel lblErUbicacion;
    private javax.swing.JLabel lblObligatorio;
    private javax.swing.JLabel lblObligatorio2;
    private javax.swing.JLabel lblObligatorio3;
    private javax.swing.JLabel lblObligatorio4;
    private javax.swing.JLabel lblObligatorio5;
    private javax.swing.JLabel lblObligatorio6;
    private javax.swing.JLabel lblObligatorio7;
    private javax.swing.JLabel lblObligatorio8;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodEmpleado;
    private javax.swing.JTextField txtJefe;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumExpediente;
    private javax.swing.JTextField txtSAP;
    // End of variables declaration//GEN-END:variables
}
