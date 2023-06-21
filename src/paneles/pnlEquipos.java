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
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import paneles.ExtraEquipos.Categoria;
import paneles.ExtraEquipos.Estado;
import paneles.ExtraEquipos.LugarCompra;
import paneles.ExtraEquipos.Marca;
import paneles.ExtraEquipos.Tipo;

public class pnlEquipos extends javax.swing.JPanel {

    public pnlEquipos() {
        initComponents();
        CargarDatosPrincipal();
        Limpiar();
    }
    //se inicializa para la busqueda por medio de Imei
    String Busqueda = "Imei";
    //se inicializa la clase de validaciones
    validaciones val = new validaciones();

    private void Limpiar() {
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

    private void CargarDatosPrincipal() {
        //rellenar datos de la tabla
        DatosTablas Datos = new DatosTablas();
        Datos.CargarTabla(tblEquipos, "select * from [VistaEquipos]");
        Datos.cargarComboBox("select Categoria from VistaCategoriaEquipo", "Categoria", cmbCategoria);
        Datos.cargarComboBox("select Marca from VistaMarcaEquipos", "Marca", cmbMarca);
        Datos.cargarComboBox("select Lugar from VistaLugarCompra", "Lugar", cmbLugar);
        Datos.cargarComboBox("select Estado from VistaEstadoEquipos", "Estado", cmbEstado);
        Datos.cargarComboBox("select Tipo from VistaTipoEquipos", "Tipo", cmbTipo);

    }

    private void LimpiarErrores() {
        val.TXTcorrecto(txtNumIMEI, lblErImei);
        val.TXTcorrecto(txtNumExpediente, lblErExpediente);
        val.CMBcorrecto(cmbEstado, lblErEstado);
        val.CMBcorrecto(cmbTipo, lblErTipo);
        val.DTPcorrecto(lblErDatePrestamo);
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
            //lblErImei.setText("Debe llenar los 15 caracteres del IMEI");
            //asignar colores de error a cada campo
            val.TXTincorrecto(txtNumIMEI, lblErImei, error);
            //incorrecto(txtNumIMEI, null, lblErImei);
        }
        if (txtNumExpediente.getText().isEmpty()) {
            valor1 = 0;
            error = "Debe escribir un expediente";
            //lblErExpediente.setText("Debe escribir un expediente");
            val.TXTincorrecto(txtNumExpediente, lblErExpediente, error);
            //incorrecto(txtNumExpediente, null, lblErExpediente);
        }
        if (cmbEstado.getSelectedItem() == null) {
            valor1 = 0;
            error = "Debe seleccionar un Estado";
            val.CMBincorrecto(cmbEstado, lblErEstado, error);
            //incorrecto(null, cmbEstado,lblErEstado);
        }
        if (cmbTipo.getSelectedItem() == null) {
            valor1 = 0;
            error = "Debe seleccionar un Tipo de equipo";
            val.CMBincorrecto(cmbTipo, lblErTipo, error);
            //incorrecto(null, cmbEstado,lblErEstado);
        }
        //se trata de obtener la fecha y si no se puede genera un error
        try {
            Date date = dtpPrestamo.getDate();
            long d = date.getTime();
        } catch (Exception e) {
            error = "La fecha tiene que ser valida";
            val.DTPIncorrecto(lblErDatePrestamo, error);
            valor1 = 0;
        }

        if (cmbCategoria.getSelectedItem() == null) {
            valor1 = 0;
            error = "Debe seleccionar una Categoria de equipo";
            val.CMBincorrecto(cmbCategoria, lblErCategoria, error);
        }
        if (cmbMarca.getSelectedItem() == null) {
            valor1 = 0;
            error = "Debe seleccionar una Marca de equipo";
            val.CMBincorrecto(cmbMarca, lblErMarca, error);
        }
        if (txtModelo.getText().isEmpty()) {
            valor1 = 0;
            error = "Debe ecribir un modelo de equipo";
            val.TXTincorrecto(txtModelo, lblErModelo, error);
        }
        if (cmbLugar.getSelectedItem() == null) {
            valor1 = 0;
            error = "Debe seleccionar un lugar de compra del equipo";
            val.CMBincorrecto(cmbLugar, lblErLugar, error);
        }

        return valor1 == 1; //Expreciones regulares de los campos
        //4 o menos digitos numericos 
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
        jPanel3 = new javax.swing.JPanel();
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
        jPanel4 = new javax.swing.JPanel();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNumFactura = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtComentario = new javax.swing.JTextField();
        dtpCompra = new com.toedter.calendar.JDateChooser();
        jLabel9 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEquipos = new javax.swing.JTable();

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

        txtBuscar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtBuscarActionPerformed(evt);
            }
        });
        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Categoria", "Comentario", "Estado", "IMEI", "Marca", "N. Expediente", "Tipo" }));
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

        jPanel2.setOpaque(false);

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Categoria del Equipo:");

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
                                .addComponent(cmbLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnCategoria))
                            .addComponent(lblErModelo)
                            .addComponent(lblErMarca)
                            .addComponent(lblErCategoria)
                            .addComponent(txtAccesorio, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel2Layout.createSequentialGroup()
                                .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(btnMarca)))))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErCategoria)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 28, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErMarca)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(txtAccesorio, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(14, 14, 14)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErModelo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel8, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(cmbLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErLugar)
                .addGap(13, 13, 13))
        );

        jPanel3.setOpaque(false);

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Numero de IMEI:");

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
        jLabel4.setText("Numero de Expediente:");

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

        dtpPrestamo.setNextFocusableComponent(cmbCategoria);

        lblErDatePrestamo.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErDatePrestamo.setForeground(new java.awt.Color(255, 0, 0));
        lblErDatePrestamo.setText("Error");

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
                        .addComponent(txtNumIMEI, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(txtNumExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEstado))
                    .addGroup(jPanel3Layout.createSequentialGroup()
                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnTipo))
                    .addComponent(dtpPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtNumIMEI, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErImei, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txtNumExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErExpediente)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErEstado)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel13)
                    .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErTipo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(dtpPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel17))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErDatePrestamo)
                .addContainerGap())
        );

        jPanel4.setOpaque(false);

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Fecha de Compra:");

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Numero de Factura:");

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
        jLabel9.setText("Costo del Equipo:");

        txtCosto.setNextFocusableComponent(txtNumFactura);
        txtCosto.setPreferredSize(new java.awt.Dimension(65, 26));
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                        .addComponent(jLabel9)
                        .addGap(18, 18, 18)
                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(54, 54, 54))
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
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(146, 146, 146)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(126, 126, 126)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(23, 23, 23))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1054, 1054, 1054))
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
                        .addGap(18, 18, 18))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(74, 74, 74)))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addContainerGap())
        );

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 403));

        tblEquipos.setBackground(new java.awt.Color(204, 255, 204));
        tblEquipos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tblEquipos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null, null, null, null, null, null, null}
            },
            new String [] {
                "IMEI", "Estado del Equipo", "Num. Expediente", "Fecha de Prestamo", "Tipo", "Categoria", "Marca", "Modelo", "Accesorio", "Lugar", "Fecha de Compra", "Costo", "Num. Factura", "Comentario"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false, false, false, false, false, true, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblEquipos.setGridColor(new java.awt.Color(0, 0, 0));
        tblEquipos.setSelectionBackground(new java.awt.Color(51, 153, 0));
        tblEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblEquiposMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblEquipos);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquiposMouseClicked
        LimpiarErrores();
        try {
            AccionesCrud classcrud = new AccionesCrud();
            ResultSet rs = classcrud.Seleccion(tblEquipos, "select * from [VistaEquipos] where [IMEI]=?");
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

            }
            txtNumIMEI.enable(false);
            btnModificar.setVisible(true);
            btnEliminar.setVisible(true);
            btnCancelar.setVisible(true);
            btnGuardar.setVisible(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_tblEquiposMouseClicked

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        DatosTablas Datos = new DatosTablas();
        // Lista de JComboBox para actualizar datos
        JComboBox[] comboBoxes = {cmbEstado, cmbTipo, cmbCategoria, cmbMarca, cmbLugar};

        // Recorrer cada JComboBox y eliminar los elementos
        for (JComboBox comboBox : comboBoxes) {
            DefaultComboBoxModel model = (DefaultComboBoxModel) comboBox.getModel();
            model.removeAllElements();
            model.addElement("");
        }

        Datos.cargarComboBox("select Categoria from VistaCategoriaEquipo", "Categoria", cmbCategoria);
        Datos.cargarComboBox("select Marca from VistaMarcaEquipos", "Marca", cmbMarca);
        Datos.cargarComboBox("select Lugar from VistaLugarCompra", "Lugar", cmbLugar);
        Datos.cargarComboBox("select Estado from VistaEstadoEquipos", "Estado", cmbEstado);
        Datos.cargarComboBox("select Tipo from VistaTipoEquipos", "Tipo", cmbTipo);
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        Limpiar();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        int key = evt.getKeyChar();
        boolean numero = (key >= 48 && key <= 57) || (key == 46 && !txtCosto.getText().contains(".")) || key == KeyEvent.VK_BACK_SPACE;
        if (txtCosto.getText().length() == 8 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtComentarioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtComentarioKeyTyped
        int key = evt.getKeyChar();
        boolean letra = (key >= 65 && key <= 90) || (key >= 97 && key <= 122 || key >= 48 && key <= 57 || (key != 43) || key == KeyEvent.VK_SPACE || key == KeyEvent.VK_BACK_SPACE);
        if (txtAccesorio.getText().length() == 50 || !letra) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtComentarioKeyTyped

    private void txtNumFacturaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumFacturaKeyTyped
        int key = evt.getKeyChar();
        boolean letra = (key >= 65 && key <= 90) || (key >= 97 && key <= 122 || key >= 48 && key <= 57 || (key != 43) || key == KeyEvent.VK_SPACE || key == KeyEvent.VK_BACK_SPACE);
        if (txtNumFactura.getText().length() == 30 || !letra) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
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
        val.CMBcorrecto(cmbTipo, lblErTipo);
    }//GEN-LAST:event_cmbTipoItemStateChanged

    private void cmbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoItemStateChanged
        val.CMBcorrecto(cmbEstado, lblErEstado);
    }//GEN-LAST:event_cmbEstadoItemStateChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void txtNumExpedienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExpedienteKeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57 || key == KeyEvent.VK_BACK_SPACE;
        if (txtNumExpediente.getText().length() == 5 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNumExpedienteKeyTyped

    private void txtNumExpedienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExpedienteKeyReleased
        val.TXTcorrecto(txtNumExpediente, lblErExpediente);
    }//GEN-LAST:event_txtNumExpedienteKeyReleased

    private void txtNumIMEIKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumIMEIKeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57 || key == KeyEvent.VK_BACK_SPACE;
        if (txtNumIMEI.getText().length() == 15 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNumIMEIKeyTyped

    private void txtNumIMEIKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumIMEIKeyReleased
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
        val.CMBcorrecto(cmbLugar, lblErLugar);
    }//GEN-LAST:event_cmbLugarItemStateChanged

    private void txtModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyTyped
        int key = evt.getKeyChar();
        boolean letra = (key >= 65 && key <= 90) || (key >= 97 && key <= 122 || key >= 48 && key <= 57 || key == KeyEvent.VK_SPACE || key == KeyEvent.VK_BACK_SPACE);
        if (txtModelo.getText().length() == 50 || !letra) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtModeloKeyTyped

    private void txtModeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyReleased
        val.TXTcorrecto(txtModelo, lblErModelo);
    }//GEN-LAST:event_txtModeloKeyReleased

    private void txtAccesorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccesorioKeyTyped
        int key = evt.getKeyChar();
        boolean letra = (key >= 65 && key <= 90) || (key >= 97 && key <= 122 || key >= 46 && key <= 57 || (key != 43) || key == KeyEvent.VK_SPACE || key == KeyEvent.VK_BACK_SPACE);
        if (txtAccesorio.getText().length() == 30 || !letra) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtAccesorioKeyTyped

    private void btnMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcaActionPerformed
        //Abrir Formulario de CentroCosto
        Marca CrudMarca = new Marca();
        CrudMarca.setVisible(true);
        CrudMarca.pack();
        CrudMarca.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMarcaActionPerformed

    private void cmbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMarcaItemStateChanged
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
        val.CMBcorrecto(cmbCategoria, lblErCategoria);
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        AccionesCrud classcrud = new AccionesCrud();
        if (classcrud.Eliminar(txtNumIMEI, "exec EliminarEquipo ?")) {
            DatosTablas Datos = new DatosTablas();
            Datos.CargarTabla(tblEquipos, "select * from [VistaEquipos]");
            Limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        LimpiarErrores();
        if (ValidarCampos()) {
            Object[] datos = new Object[14];
            datos[0] = txtNumIMEI.getText();
            if (cmbEstado.getSelectedItem() != null) {
                datos[1] = cmbEstado.getSelectedItem().toString();
            } else {
                datos[1] = "";
            }
            datos[2] = Integer.parseInt(txtNumExpediente.getText());
            try {
                Date date2 = dtpPrestamo.getDate();
                long d2 = date2.getTime();
                java.sql.Date fecha2 = new java.sql.Date(d2);
                datos[3] = fecha2.toString();
            } catch (Exception e) {
                datos[3] = "";
            }
            if (cmbTipo.getSelectedItem() != null) {
                datos[4] = cmbTipo.getSelectedItem().toString();
            } else {
                datos[4] = "";
            }
            if (cmbCategoria.getSelectedItem() != null) {
                datos[5] = cmbCategoria.getSelectedItem().toString();
            } else {
                datos[5] = "";
            }
            if (cmbMarca.getSelectedItem() != null) {
                datos[6] = cmbMarca.getSelectedItem().toString();
            } else {
                datos[6] = "";
            }
            datos[7] = txtModelo.getText();
            datos[8] = txtAccesorio.getText();
            if (cmbLugar.getSelectedItem() != null) {
                datos[9] = cmbLugar.getSelectedItem().toString();
            } else {
                datos[9] = "";
            }
            try {
                Date date = dtpCompra.getDate();
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);
                datos[10] = fecha.toString();
            } catch (Exception e) {
                datos[10] = "";
            }
            try {
                datos[11] = Double.parseDouble(txtCosto.getText());
            } catch (NumberFormatException e) {
                datos[11] = "";
            }
            datos[12] = txtNumFactura.getText();
            datos[13] = txtComentario.getText();
            AccionesCrud classcrud = new AccionesCrud();
            if (classcrud.Guardar_Modificar(datos, "exec [AgregarEquipo] ?, ? ,?  ,? ,? ,? ,? ,? ,? ,?,?,?,?,?")) {
                DatosTablas Datos = new DatosTablas();
                Datos.CargarTabla(tblEquipos, "select * from [VistaEquipos]");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
       LimpiarErrores();
        if (ValidarCampos()) {
            Object[] datos = new Object[14];
            datos[0] = txtNumIMEI.getText();
            if (cmbEstado.getSelectedItem() != null) {
                datos[1] = cmbEstado.getSelectedItem().toString();
            } else {
                datos[1] = "";
            }
            datos[2] = Integer.parseInt(txtNumExpediente.getText());
            try {
                Date date2 = dtpPrestamo.getDate();
                long d2 = date2.getTime();
                java.sql.Date fecha2 = new java.sql.Date(d2);
                datos[3] = fecha2.toString();
            } catch (Exception e) {
                datos[3] = "";
            }
            if (cmbTipo.getSelectedItem() != null) {
                datos[4] = cmbTipo.getSelectedItem().toString();
            } else {
                datos[4] = "";
            }
            if (cmbCategoria.getSelectedItem() != null) {
                datos[5] = cmbCategoria.getSelectedItem().toString();
            } else {
                datos[5] = "";
            }
            if (cmbMarca.getSelectedItem() != null) {
                datos[6] = cmbMarca.getSelectedItem().toString();
            } else {
                datos[6] = "";
            }
            datos[7] = txtModelo.getText();
            datos[8] = txtAccesorio.getText();
            if (cmbLugar.getSelectedItem() != null) {
                datos[9] = cmbLugar.getSelectedItem().toString();
            } else {
                datos[9] = "";
            }
            try {
                Date date = dtpCompra.getDate();
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);
                datos[10] = fecha.toString();
            } catch (Exception e) {
                datos[10] = "";
            }
            try {
                datos[11] = Double.parseDouble(txtCosto.getText());
            } catch (NumberFormatException e) {
                datos[11] = "";
            }
            datos[12] = txtNumFactura.getText();
            datos[13] = txtComentario.getText();
            AccionesCrud classcrud = new AccionesCrud();
            if (classcrud.Guardar_Modificar(datos, "exec [UpdateEquipo] ?, ? ,?  ,? ,? ,? ,? ,? ,? ,?,?,?,?,?")) {
                DatosTablas Datos = new DatosTablas();
                Datos.CargarTabla(tblEquipos, "select * from [VistaEquipos]");
            }
        }
    }//GEN-LAST:event_btnModificarActionPerformed

    //Funicon para asignar el tipo de busqueda que se va hacer por medio de un switc y los valores de la vista de la BD
    private void cmbBuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBuscarItemStateChanged
        String elementoSeleccionado = (String) cmbBuscar.getSelectedItem();
        switch (elementoSeleccionado) {
            case "Categoria":
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
            default:
                break;
        }
    }//GEN-LAST:event_cmbBuscarItemStateChanged

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
        DatosTablas BusquedaTabla = new DatosTablas();
        //se limpia la tabla
        DefaultTableModel modelo = (DefaultTableModel) tblEquipos.getModel();
        modelo.setRowCount(0);
        //se muestra los resultados de la busqueda
        BusquedaTabla.CargarTabla(tblEquipos, "select * from VistaEquipos where " + Busqueda + " LIKE '%" + txtBuscar.getText() + "%'");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtBuscarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtBuscarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtBuscarActionPerformed


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
    private javax.swing.JTable tblEquipos;
    private javax.swing.JTextField txtAccesorio;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtComentario;
    private javax.swing.JTextField txtCosto;
    private javax.swing.JTextField txtModelo;
    private javax.swing.JTextField txtNumExpediente;
    private javax.swing.JTextField txtNumFactura;
    private javax.swing.JTextField txtNumIMEI;
    // End of variables declaration//GEN-END:variables
}
