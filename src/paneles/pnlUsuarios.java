package paneles;

import Clases.AccionesCrud;
import Clases.DatosTablas;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.table.DefaultTableModel;
import paneles.ExtraUsuarios.Categoria;
import paneles.ExtraUsuarios.CentroCosto;
import paneles.ExtraUsuarios.Planilla;
import paneles.ExtraUsuarios.PuestoTrabajo;
import paneles.ExtraUsuarios.Ubicacion;

public class pnlUsuarios extends javax.swing.JPanel {

    public pnlUsuarios() {
        initComponents();
        CargarDatosPrincipal();
        Limpiar();

    }
    //se inicializa para la busqueda por medio de Categoria
    String Busqueda = "CategoriaUser";

    private void Limpiar() {
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
    }

    private void CargarDatosPrincipal() {
        //rellenar datos de la tabla
        DatosTablas Datos = new DatosTablas();
        Datos.CargarTabla(tblUsuarios, null, "select * from VistaUsuarios");
        Datos.cargarComboBox("select CentroCosto from VistaCentroCosto", "CentroCosto", cmbCentroCosto);
        Datos.cargarComboBox("select Planilla from VistaPlanillas", "Planilla", cmbPlanilla);
        Datos.cargarComboBox("select Puesto from VistaPuestosTrabajos", "Puesto", cmbPuesto);
        Datos.cargarComboBox("select Ubicacion from VistaUbicaciones", "Ubicacion", cmbUbicacion);
        Datos.cargarComboBox("select Categoria from VistaCategoriaUser", "Categoria", cmbCategoria);

    }

    private void correcto(JTextField campo, JComboBox campo2) {
        if (campo != null) {
            campo.setBackground(Color.WHITE);
        }
        //if(campo!= null){ campo.setBackground(Color.BLACK);}
        if (campo2 != null) {
            campo2.setBackground(Color.WHITE);
        }
    }

    private void incorrecto(JTextField campo, JComboBox campo2) {
        if (campo != null) {
            campo.setBackground(Color.RED);
        }
        if (campo2 != null) {
            campo2.setBackground(Color.RED);
        }
        //campo.setForeground(Color.white);
    }

    private boolean ValidarCampos() {

        int valor1 = 1;

        if (txtNumExpediente.getText().isEmpty() || !txtNumExpediente.getText().matches("\\d{0,4}")) {
            valor1 = 0;
            incorrecto(txtNumExpediente, null);
        }
        if (txtCodEmpleado.getText().isEmpty() || !txtCodEmpleado.getText().matches("\\d{0,6}")) {
            valor1 = 0;
            incorrecto(txtCodEmpleado, null);
        }
        if (txtNombre.getText().isEmpty() || !txtNombre.getText().matches("^[A-Za-z\\s]+$")) {
            valor1 = 0;
            incorrecto(txtNombre, null);
        }
        if (txtSAP.getText().isEmpty() || !txtSAP.getText().matches("\\d{8}")) {
            valor1 = 0;
            incorrecto(txtSAP, null);
        }
        if (cmbCentroCosto.getSelectedItem() == null) {
            valor1 = 0;
            incorrecto(null, cmbCentroCosto);
        }
        if (cmbPlanilla.getSelectedItem() == null) {
            valor1 = 0;
            incorrecto(null, cmbPlanilla);
        }
        if (cmbCategoria.getSelectedItem() == null) {
            valor1 = 0;
            incorrecto(null, cmbCategoria);
        }

        return valor1 == 1; //Expreciones regulares de los campos
        //4 o menos digitos numericos 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumExpediente = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        txtNombre = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        txtCodEmpleado = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbPuesto = new javax.swing.JComboBox<>();
        cmbCentroCosto = new javax.swing.JComboBox<>();
        cmbPlanilla = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtSAP = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtJefe = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbUbicacion = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        btnCrudCC = new javax.swing.JButton();
        btnCrudPuesto = new javax.swing.JButton();
        btnCRUDPlanilla = new javax.swing.JButton();
        btnCrudCC3 = new javax.swing.JButton();
        btnCrudUbi = new javax.swing.JButton();
        btnModificar = new rsbuttom.RSButtonMetro();
        btnGuardar = new rsbuttom.RSButtonMetro();
        btnEliminar = new rsbuttom.RSButtonMetro();
        btnCancelar = new rsbuttom.RSButtonMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        cmbBuscar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jMenuItem1.setText("Actualizar datos desplegables");
        jMenuItem1.setName("actualizarTabla"); // NOI18N
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setBackground(new java.awt.Color(255, 255, 255));
        setComponentPopupMenu(jPopupMenu1);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setComponentPopupMenu(jPopupMenu1);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Numero de Expediente:");

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
        jLabel3.setText("Nombre de usuario:");

        txtNombre.setPreferredSize(new java.awt.Dimension(65, 26));
        txtNombre.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNombreKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNombreKeyTyped(evt);
            }
        });

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Codigo Empleado:");

        txtCodEmpleado.setPreferredSize(new java.awt.Dimension(65, 26));
        txtCodEmpleado.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCodEmpleadoKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodEmpleadoKeyTyped(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Puesto de Trabajo:");

        cmbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbPuesto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPuestoItemStateChanged(evt);
            }
        });

        cmbCentroCosto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbCentroCosto.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCentroCostoItemStateChanged(evt);
            }
        });

        cmbPlanilla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbPlanilla.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbPlanillaItemStateChanged(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Centro de Costo:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Codigo SAP:");

        txtSAP.setPreferredSize(new java.awt.Dimension(65, 26));
        txtSAP.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtSAPKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtSAPKeyTyped(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Planilla:");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Jefe:");

        txtJefe.setPreferredSize(new java.awt.Dimension(65, 26));
        txtJefe.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtJefeKeyTyped(evt);
            }
        });

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Ubicacion:");

        cmbUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Categoria:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });

        btnCrudCC.setText("+");
        btnCrudCC.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudCCActionPerformed(evt);
            }
        });

        btnCrudPuesto.setText("+");
        btnCrudPuesto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCrudPuestoActionPerformed(evt);
            }
        });

        btnCRUDPlanilla.setText("+");
        btnCRUDPlanilla.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCRUDPlanillaActionPerformed(evt);
            }
        });

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel1)
                    .addComponent(jLabel4)
                    .addComponent(jLabel3)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCodEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtNumExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 37, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtSAP, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbCentroCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(btnCrudCC))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbPlanilla, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnCRUDPlanilla)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 32, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel11)
                                        .addGap(18, 18, 18)
                                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(btnCrudCC3))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel10)
                                            .addComponent(jLabel9))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(jPanel1Layout.createSequentialGroup()
                                                .addComponent(cmbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(btnCrudUbi))
                                            .addComponent(txtJefe, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCrudPuesto))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 29, Short.MAX_VALUE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtCodEmpleado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(txtNombre, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(30, 30, 30)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(15, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCrudCC, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(cmbCentroCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(cmbPlanilla, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCRUDPlanilla, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtSAP, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(txtJefe, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(cmbUbicacion, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCrudUbi, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnCrudCC3, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cmbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCrudPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
        );

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 403));

        tblUsuarios.setBackground(new java.awt.Color(204, 255, 204));
        tblUsuarios.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tblUsuarios.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "N. Expediente", "Nombre", "Cod. Empleado", "Centro de Costo", "Planilla", "Cod. SAP", "Puesto de Trabajo", "Jefe", "Ubicacion", "Categoria"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblUsuarios.setGridColor(new java.awt.Color(0, 0, 0));
        tblUsuarios.setSelectionBackground(new java.awt.Color(51, 153, 0));
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
        });

        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria", "Centro Costo", "Cod. Empleado", "Codigo SAP", "Jefe", "N. Expediente", "Nombre", "Planilla", "Puesto de Trabajo", "Ubicacion" }));
        cmbBuscar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbBuscarItemStateChanged(evt);
            }
        });

        jLabel2.setText("Buscar por:");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addGap(16, 16, 16)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 448, Short.MAX_VALUE))
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
        //Abrir Formulario de CentroCosto
        PuestoTrabajo PuestoTrabajo = new PuestoTrabajo();
        PuestoTrabajo.setVisible(true);
        PuestoTrabajo.pack();
        PuestoTrabajo.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCrudPuestoActionPerformed

    private void btnCRUDPlanillaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCRUDPlanillaActionPerformed
        //Abrir Formulario de CentroCosto
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

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (ValidarCampos()) {
            Object[] datos = new Object[10];
            datos[0] = Integer.parseInt(txtNumExpediente.getText());
            datos[1] = txtNombre.getText();
            datos[2] = Integer.parseInt(txtCodEmpleado.getText());
            datos[3] = cmbCentroCosto.getSelectedItem().toString();
            datos[4] = cmbPlanilla.getSelectedItem().toString();
            datos[5] = txtSAP.getText();

            if (cmbPuesto.getSelectedItem() != null) {
                datos[6] = cmbPuesto.getSelectedItem().toString();
            } else {
                datos[6] = "";
            }

            datos[7] = txtJefe.getText();

            if (cmbUbicacion.getSelectedItem() != null) {
                datos[8] = cmbUbicacion.getSelectedItem().toString();
            } else {
                datos[8] = "";
            }

            datos[9] = cmbCategoria.getSelectedItem().toString();
            AccionesCrud classcrud = new AccionesCrud();
            if (classcrud.Guardar(datos, "exec [UpdateUsuario] ?, ? ,?  ,? ,? ,? ,? ,? ,? ,?")) {
                DatosTablas Datos = new DatosTablas();
                Datos.CargarTabla(tblUsuarios, null, "select * from VistaUsuarios");
            }
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (ValidarCampos()) {
            Object[] datos = new Object[10];
            datos[0] = Integer.parseInt(txtNumExpediente.getText());
            datos[1] = txtNombre.getText();
            datos[2] = Integer.parseInt(txtCodEmpleado.getText());
            datos[3] = cmbCentroCosto.getSelectedItem().toString();
            datos[4] = cmbPlanilla.getSelectedItem().toString();
            datos[5] = txtSAP.getText();

            if (cmbPuesto.getSelectedItem() != null) {
                datos[6] = cmbPuesto.getSelectedItem().toString();
            } else {
                datos[6] = "";
            }

            datos[7] = txtJefe.getText();

            if (cmbUbicacion.getSelectedItem() != null) {
                datos[8] = cmbUbicacion.getSelectedItem().toString();
            } else {
                datos[8] = "";
            }

            datos[9] = cmbCategoria.getSelectedItem().toString();
            AccionesCrud classcrud = new AccionesCrud();
            if (classcrud.Guardar(datos, "exec [AgregarUsuario] ?, ? ,?  ,? ,? ,? ,? ,? ,? ,?")) {
                DatosTablas Datos = new DatosTablas();
                Datos.CargarTabla(tblUsuarios, null, "select * from VistaUsuarios");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        AccionesCrud classcrud = new AccionesCrud();
        if (classcrud.Eliminar(txtNumExpediente, "exec EliminarUsuario ?")) {
            DatosTablas Datos = new DatosTablas();
            Datos.CargarTabla(tblUsuarios, null, "select * from VistaUsuarios");
            Limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblUsuariosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblUsuariosMouseClicked
        try {
            AccionesCrud classcrud = new AccionesCrud();
            ResultSet rs = classcrud.Seleccion(tblUsuarios, "select * from [VistaUsuarios] where [NumeroExpediente]=?");
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
    }//GEN-LAST:event_tblUsuariosMouseClicked

    //Funicon para asignar el tipo de busqueda que se va hacer por medio de un switc y los valores de la vista de la BD
    private void cmbBuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBuscarItemStateChanged
        String elementoSeleccionado = (String) cmbBuscar.getSelectedItem();
        switch (elementoSeleccionado) {
            case "Categoria":
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
            case "Ubicacion":
                Busqueda = "Ubicacion";
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cmbBuscarItemStateChanged

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        DatosTablas BusquedaTabla = new DatosTablas();
        //se limpia la tabla
        DefaultTableModel modelo = (DefaultTableModel) tblUsuarios.getModel();
        modelo.setRowCount(0);
        //se muestra los resultados de la busqueda
        BusquedaTabla.CargarTabla(tblUsuarios, null, "select * from VistaUsuarios where " + Busqueda + " LIKE '%" + txtBuscar.getText() + "%'");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtNumExpedienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExpedienteKeyReleased
        correcto(txtNumExpediente, null);
    }//GEN-LAST:event_txtNumExpedienteKeyReleased

    private void txtCodEmpleadoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodEmpleadoKeyReleased
        correcto(txtCodEmpleado, null);
    }//GEN-LAST:event_txtCodEmpleadoKeyReleased

    private void txtNombreKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyReleased
        correcto(txtNombre, null);
    }//GEN-LAST:event_txtNombreKeyReleased

    private void txtSAPKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSAPKeyReleased
        correcto(txtSAP, null);
    }//GEN-LAST:event_txtSAPKeyReleased

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        correcto(null, cmbCategoria);
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void cmbCentroCostoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCentroCostoItemStateChanged
        correcto(null, cmbCentroCosto);
    }//GEN-LAST:event_cmbCentroCostoItemStateChanged

    private void cmbPlanillaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPlanillaItemStateChanged
        correcto(null, cmbPlanilla);
    }//GEN-LAST:event_cmbPlanillaItemStateChanged

    private void cmbPuestoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbPuestoItemStateChanged
        correcto(null, cmbPuesto);
    }//GEN-LAST:event_cmbPuestoItemStateChanged

    private void txtNumExpedienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExpedienteKeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57 || key == KeyEvent.VK_BACK_SPACE;
        if (txtNumExpediente.getText().length() == 4 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNumExpedienteKeyTyped

    private void txtCodEmpleadoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodEmpleadoKeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57 || key == KeyEvent.VK_BACK_SPACE;
        if (txtCodEmpleado.getText().length() == 5 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCodEmpleadoKeyTyped

    private void txtNombreKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNombreKeyTyped
        int key = evt.getKeyChar();
        boolean letra = (key >= 65 && key <= 90) || (key >= 97 && key <= 122 || key == KeyEvent.VK_SPACE || key == KeyEvent.VK_BACK_SPACE);
        if (txtNombre.getText().length() == 80 || !letra) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNombreKeyTyped

    private void txtSAPKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtSAPKeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57 || key == KeyEvent.VK_BACK_SPACE;
        if (txtSAP.getText().length() == 8 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtSAPKeyTyped

    private void txtJefeKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtJefeKeyTyped
        int key = evt.getKeyChar();
        boolean letra = (key >= 65 && key <= 90) || (key >= 97 && key <= 122 || key >= 48 && key <= 57 || key == KeyEvent.VK_SPACE || key == KeyEvent.VK_BACK_SPACE);
        if (txtJefe.getText().length() == 50 || !letra) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtJefeKeyTyped

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DatosTablas Datos = new DatosTablas();
        // Lista de JComboBox para actualizar datos
        JComboBox[] comboBoxes = {cmbCentroCosto, cmbPlanilla, cmbPuesto, cmbUbicacion, cmbCategoria};

        // Recorrer cada JComboBox y eliminar los elementos
        for (JComboBox comboBox : comboBoxes) {
            DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
            model.removeAllElements();
            model.addElement(""); 
        }

        Datos.cargarComboBox("select CentroCosto from VistaCentroCosto", "CentroCosto", cmbCentroCosto);
        Datos.cargarComboBox("select Planilla from VistaPlanillas", "Planilla", cmbPlanilla);
        Datos.cargarComboBox("select Puesto from VistaPuestosTrabajos", "Puesto", cmbPuesto);
        Datos.cargarComboBox("select Ubicacion from VistaUbicaciones", "Ubicacion", cmbUbicacion);
        Datos.cargarComboBox("select Categoria from VistaCategoriaUser", "Categoria", cmbCategoria);
    }//GEN-LAST:event_jMenuItem1ActionPerformed


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
    private javax.swing.Box.Filler filler1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblUsuarios;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCodEmpleado;
    private javax.swing.JTextField txtJefe;
    private javax.swing.JTextField txtNombre;
    private javax.swing.JTextField txtNumExpediente;
    private javax.swing.JTextField txtSAP;
    // End of variables declaration//GEN-END:variables
}
