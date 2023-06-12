package paneles;

import Clases.AccionesCrud;
import Clases.DatosTablas;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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
    //se inicializa para la busqueda por medio de Categoria
    String Busqueda = "CategoriaUser";

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

    }

    private void CargarDatosPrincipal() {
        //rellenar datos de la tabla
        DatosTablas Datos = new DatosTablas();
        Datos.CargarTabla(tblEquipos, null, "select * from [VistaEquipos]");
        Datos.cargarComboBox("select Categoria from VistaCategoriaEquipo", "Categoria", cmbCategoria);
        Datos.cargarComboBox("select Marca from VistaMarcaEquipos", "Marca", cmbMarca);
        Datos.cargarComboBox("select Lugar from VistaLugarCompra", "Lugar", cmbLugar);
        Datos.cargarComboBox("select Estado from VistaEstadoEquipos", "Estado", cmbEstado);
        Datos.cargarComboBox("select Tipo from VistaTipoEquipos", "Tipo", cmbTipo);

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

        if (txtNumIMEI.getText().isEmpty() || !txtNumIMEI.getText().matches("\\d{15}")) {
            valor1 = 0;
            incorrecto(txtNumIMEI, null);
        }
        if (txtNumExpediente.getText().isEmpty() || !txtNumExpediente.getText().matches("\\d{0,6}")) {
            valor1 = 0;
            incorrecto(txtNumExpediente, null);
        }

        return valor1 == 1; //Expreciones regulares de los campos
        //4 o menos digitos numericos 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        txtNumIMEI = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        txtNumExpediente = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbLugar = new javax.swing.JComboBox<>();
        cmbCategoria = new javax.swing.JComboBox<>();
        cmbMarca = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        txtAccesorio = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        txtCosto = new javax.swing.JTextField();
        btnCategoria = new javax.swing.JButton();
        btnLugar = new javax.swing.JButton();
        btnMarca = new javax.swing.JButton();
        btnCancelar = new rsbuttom.RSButtonMetro();
        cmbEstado = new javax.swing.JComboBox<>();
        btnEstado = new javax.swing.JButton();
        jLabel13 = new javax.swing.JLabel();
        cmbTipo = new javax.swing.JComboBox<>();
        btnTipo = new javax.swing.JButton();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        txtNumFactura = new javax.swing.JTextField();
        jLabel16 = new javax.swing.JLabel();
        txtComentario = new javax.swing.JTextField();
        dtpPrestamo = new com.toedter.calendar.JDateChooser();
        jLabel17 = new javax.swing.JLabel();
        dtpCompra = new com.toedter.calendar.JDateChooser();
        jLabel10 = new javax.swing.JLabel();
        txtModelo = new javax.swing.JTextField();
        txtBuscar = new javax.swing.JTextField();
        cmbBuscar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        btnModificar = new rsbuttom.RSButtonMetro();
        btnGuardar = new rsbuttom.RSButtonMetro();
        btnEliminar = new rsbuttom.RSButtonMetro();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblEquipos = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Numero de IMEI:");

        txtNumIMEI.setPreferredSize(new java.awt.Dimension(65, 26));
        txtNumIMEI.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumIMEIKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumIMEIKeyTyped(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Estado del equipo:");

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Numero de Expediente:");

        txtNumExpediente.setPreferredSize(new java.awt.Dimension(65, 26));
        txtNumExpediente.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtNumExpedienteKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumExpedienteKeyTyped(evt);
            }
        });

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Lugar de Compra:");

        cmbLugar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbLugar.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbLugarItemStateChanged(evt);
            }
        });

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbCategoria.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbCategoriaItemStateChanged(evt);
            }
        });

        cmbMarca.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbMarca.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbMarcaItemStateChanged(evt);
            }
        });

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Categoria del Equipo:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Accesorio:");

        txtAccesorio.setPreferredSize(new java.awt.Dimension(65, 26));
        txtAccesorio.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtAccesorioKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtAccesorioKeyTyped(evt);
            }
        });

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Marca:");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Costo del Equipo:");

        txtCosto.setPreferredSize(new java.awt.Dimension(65, 26));
        txtCosto.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCostoKeyTyped(evt);
            }
        });

        btnCategoria.setText("+");
        btnCategoria.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCategoriaActionPerformed(evt);
            }
        });

        btnLugar.setText("+");
        btnLugar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLugarActionPerformed(evt);
            }
        });

        btnMarca.setText("+");
        btnMarca.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMarcaActionPerformed(evt);
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

        cmbEstado.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbEstado.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbEstadoItemStateChanged(evt);
            }
        });

        btnEstado.setText("+");
        btnEstado.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEstadoActionPerformed(evt);
            }
        });

        jLabel13.setForeground(new java.awt.Color(0, 0, 0));
        jLabel13.setText("Tipo de Equipo:");

        cmbTipo.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));
        cmbTipo.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                cmbTipoItemStateChanged(evt);
            }
        });

        btnTipo.setText("+");
        btnTipo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTipoActionPerformed(evt);
            }
        });

        jLabel14.setForeground(new java.awt.Color(0, 0, 0));
        jLabel14.setText("Fecha de Compra:");

        jLabel15.setForeground(new java.awt.Color(0, 0, 0));
        jLabel15.setText("Numero de Factura:");

        txtNumFactura.setPreferredSize(new java.awt.Dimension(65, 26));
        txtNumFactura.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNumFacturaKeyTyped(evt);
            }
        });

        jLabel16.setForeground(new java.awt.Color(0, 0, 0));
        jLabel16.setText("Comentario:");

        txtComentario.setPreferredSize(new java.awt.Dimension(65, 26));
        txtComentario.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtComentarioKeyTyped(evt);
            }
        });

        jLabel17.setForeground(new java.awt.Color(0, 0, 0));
        jLabel17.setText("Fecahd e Prestamo:");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Modelo:");

        txtModelo.setPreferredSize(new java.awt.Dimension(65, 26));
        txtModelo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtModeloKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtModeloKeyTyped(evt);
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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addComponent(jLabel1)
                                        .addComponent(jLabel4))
                                    .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.TRAILING))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtNumIMEI, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 122, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel13)
                                    .addComponent(jLabel17))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnTipo))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(btnEstado))
                                    .addComponent(txtNumExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dtpPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 15, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel10, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtAccesorio, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(12, 12, 12)
                                        .addComponent(btnCategoria))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnMarca))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(cmbLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(btnLugar)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel9)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(60, 60, 60))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel15)
                                        .addGap(18, 18, 18)
                                        .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                            .addComponent(jLabel14)
                                            .addComponent(jLabel16))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtComentario, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                            .addComponent(dtpCompra, javax.swing.GroupLayout.DEFAULT_SIZE, 212, Short.MAX_VALUE))
                                        .addContainerGap())))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addContainerGap())))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel2)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(btnCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel5)
                                        .addComponent(cmbCategoria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(12, 12, 12)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel7)
                                    .addComponent(cmbMarca, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(btnMarca, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel15)
                                    .addComponent(txtNumFactura, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel6)
                                    .addComponent(txtAccesorio, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel16)
                                    .addComponent(txtComentario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel9)
                                .addComponent(txtCosto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel14, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(dtpCompra, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(txtNumIMEI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.DEFAULT_SIZE, 28, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(txtNumExpediente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(cmbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel3)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(txtModelo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel13)
                                .addComponent(cmbTipo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnTipo, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel17, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel8)
                                .addComponent(cmbLugar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(btnLugar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dtpPrestamo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 39, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel2))))
                .addContainerGap())
        );

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
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 557, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void tblEquiposMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblEquiposMouseClicked
        try {
            AccionesCrud classcrud = new AccionesCrud();
            ResultSet rs = classcrud.Seleccion(tblEquipos, "select * from [VistaEquipos] where [IMEI]=?");
            while (rs.next()) {
                txtNumIMEI.setText(rs.getString("IMEI"));
                txtNumExpediente.setText(rs.getString("NumeroExpediente"));
                cmbEstado.setSelectedItem(rs.getString("Estado del Equipo"));
                cmbTipo.setSelectedItem(rs.getString("Tipo"));
                dtpPrestamo.setDateFormatString(rs.getString("FechaPrestamo"));
                cmbCategoria.setSelectedItem(rs.getString("Categoria"));
                cmbMarca.setSelectedItem(rs.getString("Marca"));
                txtModelo.setText(rs.getString("Modelo"));
                txtAccesorio.setText(rs.getString("Accesorio"));
                cmbLugar.setSelectedItem(rs.getString("Lugar"));
                dtpCompra.setDateFormatString(rs.getString("FechaCompra"));
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

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        AccionesCrud classcrud = new AccionesCrud();
        if (classcrud.Eliminar(txtNumIMEI, "exec EliminarEquipo ?")) {
            DatosTablas Datos = new DatosTablas();
            Datos.CargarTabla(tblEquipos, null, "select * from [VistaEquipos]");
            Limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        if (ValidarCampos()) {
            Object[] datos = new Object[14];
            datos[0] = txtNumIMEI.getText();
            datos[1] = cmbEstado.getSelectedItem().toString();
            datos[2] = Integer.parseInt(txtNumExpediente.getText());
            
            Date date2=dtpCompra.getDate();
            long d2 = date2.getTime();
            java.sql.Date fecha2 = new java.sql.Date(d2);
            datos[3] = fecha2.toString();
            
            datos[4] = cmbTipo.getSelectedItem().toString();
            datos[5] = cmbCategoria.getSelectedItem().toString();
            datos[6] = cmbMarca.getSelectedItem().toString();
            datos[7] = txtModelo.getText();
            datos[8] = txtAccesorio.getText();
            datos[9] = cmbLugar.getSelectedItem().toString();
            
            Date date=dtpCompra.getDate();
            long d = date.getTime();
            java.sql.Date fecha = new java.sql.Date(d);
            datos[10] = fecha.toString();
            
            datos[11] = Double.parseDouble(txtCosto.getText());
            datos[12] = txtNumFactura.getText();
            datos[13] = txtComentario.getText();
            AccionesCrud classcrud = new AccionesCrud();
            if (classcrud.Guardar(datos, "exec [AgregarEquipo] ?, ? ,?  ,? ,? ,? ,? ,? ,? ,?,?,?,?,?")) {
                DatosTablas Datos = new DatosTablas();
                Datos.CargarTabla(tblEquipos, null, "select * from [VistaEquipos]");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        if (ValidarCampos()) {
            Object[] datos = new Object[14];
            datos[0] = txtNumIMEI.getText();
            datos[1] = cmbEstado.getSelectedItem().toString();
            datos[2] = txtNumExpediente.getText();
            datos[3] = dtpPrestamo.getDateFormatString();
            datos[4] = cmbTipo.getSelectedItem().toString();
            datos[5] = cmbCategoria.getSelectedItem().toString();
            datos[6] = cmbMarca.getSelectedItem().toString();
            datos[7] = txtModelo.getText();
            datos[8] = txtAccesorio.getText();
            datos[9] = cmbLugar.getSelectedItem().toString();
            datos[10] = dtpCompra.getDateFormatString();
            datos[11] = txtCosto.getText();
            datos[12] = txtNumFactura.getText();
            datos[13] = txtComentario.getText();
            AccionesCrud classcrud = new AccionesCrud();
            if (classcrud.Guardar(datos, "exec [UpdateEquipo] ?, ? ,?  ,? ,? ,? ,? ,? ,? ,?,?,?,?,?")) {
                DatosTablas Datos = new DatosTablas();
                Datos.CargarTabla(tblEquipos, null, "select * from [VistaEquipos]");
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
        BusquedaTabla.CargarTabla(tblEquipos, null, "select * from VistaEquipos where " + Busqueda + " LIKE '%" + txtBuscar.getText() + "%'");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtModeloKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyTyped
        int key = evt.getKeyChar();
        boolean letra = (key >= 65 && key <= 90) || (key >= 97 && key <= 122 || key >= 48 && key <= 57 || key == KeyEvent.VK_SPACE || key == KeyEvent.VK_BACK_SPACE);
        if (txtModelo.getText().length() == 50 || !letra) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtModeloKeyTyped

    private void txtModeloKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtModeloKeyReleased
        // TODO add your handling code here:
    }//GEN-LAST:event_txtModeloKeyReleased

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

    private void btnTipoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTipoActionPerformed
        //Abrir Formulario de Tipo
        Tipo CrudTipo = new Tipo();
        CrudTipo.setVisible(true);
        CrudTipo.pack();
        CrudTipo.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnTipoActionPerformed

    private void cmbTipoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbTipoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbTipoItemStateChanged

    private void btnEstadoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEstadoActionPerformed
        //Abrir Formulario de Estado
        Estado CrudEstado = new Estado();
        CrudEstado.setVisible(true);
        CrudEstado.pack();
        CrudEstado.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnEstadoActionPerformed

    private void cmbEstadoItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbEstadoItemStateChanged
        // TODO add your handling code here:
    }//GEN-LAST:event_cmbEstadoItemStateChanged

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void btnMarcaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMarcaActionPerformed
        //Abrir Formulario de CentroCosto
        Marca CrudMarca = new Marca();
        CrudMarca.setVisible(true);
        CrudMarca.pack();
        CrudMarca.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnMarcaActionPerformed

    private void btnLugarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLugarActionPerformed
        //Abrir Formulario de Lugar de compra
        LugarCompra LugarCompra = new LugarCompra();
        LugarCompra.setVisible(true);
        LugarCompra.pack();
        LugarCompra.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnLugarActionPerformed

    private void btnCategoriaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCategoriaActionPerformed
        //Abrir Formulario de CentroCosto
        Categoria CrudCategoria = new Categoria();
        CrudCategoria.setVisible(true);
        CrudCategoria.pack();
        CrudCategoria.setLocationRelativeTo(null);
    }//GEN-LAST:event_btnCategoriaActionPerformed

    private void txtCostoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCostoKeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57 || key == 46 || key == KeyEvent.VK_BACK_SPACE;
        if (txtCosto.getText().length() == 8 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCostoKeyTyped

    private void txtAccesorioKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccesorioKeyTyped
        int key = evt.getKeyChar();
        boolean letra = (key >= 65 && key <= 90) || (key >= 97 && key <= 122 || key >= 46 && key <= 57 || (key != 43) || key == KeyEvent.VK_SPACE || key == KeyEvent.VK_BACK_SPACE);
        if (txtAccesorio.getText().length() == 30 || !letra) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtAccesorioKeyTyped

    private void txtAccesorioKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtAccesorioKeyReleased
        correcto(txtAccesorio, null);
    }//GEN-LAST:event_txtAccesorioKeyReleased

    private void cmbMarcaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbMarcaItemStateChanged
        correcto(null, cmbMarca);
    }//GEN-LAST:event_cmbMarcaItemStateChanged

    private void cmbCategoriaItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbCategoriaItemStateChanged
        correcto(null, cmbCategoria);
    }//GEN-LAST:event_cmbCategoriaItemStateChanged

    private void cmbLugarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbLugarItemStateChanged
        correcto(null, cmbLugar);
    }//GEN-LAST:event_cmbLugarItemStateChanged

    private void txtNumExpedienteKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExpedienteKeyTyped
        int key = evt.getKeyChar();
        boolean numero = key >= 48 && key <= 57 || key == KeyEvent.VK_BACK_SPACE;
        if (txtNumExpediente.getText().length() == 5 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNumExpedienteKeyTyped

    private void txtNumExpedienteKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNumExpedienteKeyReleased
        correcto(txtNumExpediente, null);
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
        correcto(txtNumIMEI, null);
    }//GEN-LAST:event_txtNumIMEIKeyReleased


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
    private javax.swing.Box.Filler filler1;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
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
