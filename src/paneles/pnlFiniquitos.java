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
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;

public class pnlFiniquitos extends javax.swing.JPanel {

    public pnlFiniquitos() {
        initComponents();
        CargarDatosPrincipal();
        Limpiar();
        txtIDFiniquitos.setVisible(false);

    }
    //se inicializa para la busqueda por medio de Categoria
    String Busqueda = "Linea";
    //se inicializa la clase de validaciones
    validaciones val = new validaciones();

    private void Limpiar() {
        //funcion para reiniciar todos los valores de la pantalla
        btnCancelar.setVisible(false);
        btnModificar.setVisible(false);
        btnEliminar.setVisible(false);
        btnGuardar.setVisible(true);

        txtIDFiniquitos.setText("");
        txtCobro.setText("");
        txtLinea.setText("");
        txtObs1.setText("");
        txtObs2.setText("");
        dtpSolicitud.setDate(null);
        dtpCorte.setDate(null);
        dtpCobro.setDate(null);
        LimpiarErrores();
    }

    private void CargarDatosPrincipal() {
        //rellenar datos de la tabla
        DatosTablas Datos = new DatosTablas();
        //llenar los datos de los combobox
        Datos.CargarTabla(tblFiniquitos, "select * from VistaFiniquitos");
    }

    private void LimpiarErrores() {
        //usando la clase de validaciones se establecen los valores en correcto
        val.GENcorrecto(lblErSolicitud);
        val.GENcorrecto(lblErCorte);
        val.GENcorrecto(lblErCobro);
        val.TXTcorrecto(txtCobro, lblErValor);
        val.TXTcorrecto(txtLinea, lblErLinea);
    }

    private boolean ValidarCampos() {

        int valor1 = 1;
        String error;
        Date date;
        //se trata de obtener la fecha y si no se puede genera un error
        try {
            date = dtpSolicitud.getDate();
            long d = date.getTime();
        } catch (Exception e) {
            error = "La fecha de Solicitud tiene que ser valida";
            val.GENIncorrecto(lblErSolicitud, error);
            valor1 = 0;
        }
        try {
            date = dtpCorte.getDate();
            long d = date.getTime();
        } catch (Exception e) {
            error = "La fecha de Corte tiene que ser valida";
            val.GENIncorrecto(lblErCorte, error);
            valor1 = 0;
        }
        try {
            date = dtpCobro.getDate();
            long d = date.getTime();
        } catch (Exception e) {
            error = "La fecha de Cobro tiene que ser valida";
            val.GENIncorrecto(lblErCobro, error);
            valor1 = 0;
        }

        if (txtCobro.getText().isEmpty() || Double.parseDouble(txtCobro.getText()) <= 0) {
            valor1 = 0;
            error = "El valor del cobro no puede estar vacío o en 0";
            val.TXTincorrecto(txtCobro, lblErValor, error);
        }
        if (txtLinea.getText().isEmpty() || !txtLinea.getText().matches("\\d{4}-\\d{4}")) {
            valor1 = 0;
            error = "Escriba un numero de telefono valido";
            val.TXTincorrecto(txtLinea, lblErLinea, error);
        }

        return valor1 == 1; //Expreciones regulares de los campos
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPopupMenu1 = new javax.swing.JPopupMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jPanel1 = new javax.swing.JPanel();
        txtIDFiniquitos = new javax.swing.JTextField();
        btnModificar = new rsbuttom.RSButtonMetro();
        btnGuardar = new rsbuttom.RSButtonMetro();
        btnEliminar = new rsbuttom.RSButtonMetro();
        btnCancelar = new rsbuttom.RSButtonMetro();
        dtpCorte = new com.toedter.calendar.JDateChooser();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        dtpSolicitud = new com.toedter.calendar.JDateChooser();
        txtCobro = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        txtLinea = new javax.swing.JTextField();
        txtObs1 = new javax.swing.JTextField();
        jLabel11 = new javax.swing.JLabel();
        txtObs2 = new javax.swing.JTextField();
        jLabel12 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        dtpCobro = new com.toedter.calendar.JDateChooser();
        lblErSolicitud = new javax.swing.JLabel();
        lblErCorte = new javax.swing.JLabel();
        lblErCobro = new javax.swing.JLabel();
        lblErValor = new javax.swing.JLabel();
        lblErLinea = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFiniquitos = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        cmbBuscar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        jMenuItem1.setText("Limpiar Campos");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jPopupMenu1.add(jMenuItem1);

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setComponentPopupMenu(jPopupMenu1);
        jPanel1.setNextFocusableComponent(dtpSolicitud);

        txtIDFiniquitos.setPreferredSize(new java.awt.Dimension(65, 26));

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

        dtpCorte.setNextFocusableComponent(dtpCobro);

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha de Solicitud\n");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Por parte de RRHH:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha de Corte:");

        dtpSolicitud.setNextFocusableComponent(dtpCorte);

        txtCobro.setNextFocusableComponent(txtLinea);
        txtCobro.setPreferredSize(new java.awt.Dimension(65, 26));
        txtCobro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtCobroKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCobroKeyTyped(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Valor de Cobro:");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Linea Telefonica:");

        txtLinea.setNextFocusableComponent(txtObs1);
        txtLinea.setPreferredSize(new java.awt.Dimension(65, 26));
        txtLinea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtLineaKeyReleased(evt);
            }
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLineaKeyTyped(evt);
            }
        });

        txtObs1.setNextFocusableComponent(txtObs2);
        txtObs1.setPreferredSize(new java.awt.Dimension(65, 26));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Observacion 1:");

        txtObs2.setNextFocusableComponent(btnGuardar);
        txtObs2.setPreferredSize(new java.awt.Dimension(65, 26));

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Observacion 2:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Fecha de Cobro:");

        dtpCobro.setNextFocusableComponent(txtCobro);

        lblErSolicitud.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErSolicitud.setForeground(new java.awt.Color(255, 0, 0));
        lblErSolicitud.setText("Error");

        lblErCorte.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErCorte.setForeground(new java.awt.Color(255, 0, 0));
        lblErCorte.setText("Error");

        lblErCobro.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErCobro.setForeground(new java.awt.Color(255, 0, 0));
        lblErCobro.setText("Error");

        lblErValor.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErValor.setForeground(new java.awt.Color(255, 0, 0));
        lblErValor.setText("Error");

        lblErLinea.setFont(new java.awt.Font("Dialog", 0, 10)); // NOI18N
        lblErLinea.setForeground(new java.awt.Color(255, 0, 0));
        lblErLinea.setText("Error");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 103, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel6)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel5)
                                        .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.TRAILING))
                                    .addComponent(txtIDFiniquitos, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dtpCorte, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(dtpSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErSolicitud)
                                    .addComponent(lblErCorte)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(dtpCobro, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(lblErCobro))))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(32, 32, 32)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(148, 148, 148)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(jLabel10)
                                    .addComponent(jLabel9))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(lblErLinea)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(lblErValor)
                                            .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(txtCobro, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(118, 118, 118)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addComponent(jLabel12)
                                            .addComponent(jLabel11, javax.swing.GroupLayout.Alignment.TRAILING))
                                        .addGap(18, 18, 18)
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                            .addComponent(txtObs1, javax.swing.GroupLayout.DEFAULT_SIZE, 190, Short.MAX_VALUE)
                                            .addComponent(txtObs2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))))))
                .addContainerGap(487, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(txtIDFiniquitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel4)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addComponent(dtpSolicitud, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErSolicitud)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(dtpCorte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErCorte))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(txtCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jLabel9))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(lblErValor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel10)
                                    .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel11)
                                    .addComponent(txtObs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel12)
                                    .addComponent(txtObs2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblErLinea)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(dtpCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblErCobro)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 24, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jScrollPane1.setComponentPopupMenu(jPopupMenu1);
        jScrollPane1.setPreferredSize(new java.awt.Dimension(800, 403));

        tblFiniquitos.setBackground(new java.awt.Color(204, 255, 204));
        tblFiniquitos.setFont(new java.awt.Font("Dialog", 1, 12)); // NOI18N
        tblFiniquitos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null},
                {null, null, null, null, null, null, null, null}
            },
            new String [] {
                "ID Finiquitos", "Linea Telefonica", "Fecha Solicitud RRHH", "Fecha de Corte", "Valor del Cobro", "Observacion 1", "Observacion 2", "Fecha Cobro"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblFiniquitos.setGridColor(new java.awt.Color(0, 0, 0));
        tblFiniquitos.setSelectionBackground(new java.awt.Color(51, 153, 0));
        tblFiniquitos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblFiniquitosMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblFiniquitos);

        txtBuscar.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txtBuscarKeyReleased(evt);
            }
        });

        cmbBuscar.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Linea Telefonica" }));
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
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 1627, Short.MAX_VALUE)
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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(cmbBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 659, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnModificarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnModificarActionPerformed
        LimpiarErrores();
        if (ValidarCampos()) {
            Object[] datos = new Object[8];
            //se crea un arreglo de objetos para enviar a la clase de AccionesCrud y la funcion de Guardar_Modificar
            datos[0] = Integer.parseInt(txtIDFiniquitos.getText());
            datos[1] = txtLinea.getText();

            try {
                Date date = dtpSolicitud.getDate();
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);
                datos[2] = fecha.toString();
            } catch (Exception e) {
                datos[2] = "";
            }
            try {
                Date date = dtpCorte.getDate();
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);
                datos[3] = fecha.toString();
            } catch (Exception e) {
                datos[3] = "";
            }
            datos[4] = Double.parseDouble(txtCobro.getText());
            datos[5] = txtObs1.getText();
            datos[6] = txtObs2.getText();

            try {
                Date date2 = dtpCobro.getDate();
                long d2 = date2.getTime();
                java.sql.Date fecha2 = new java.sql.Date(d2);
                datos[7] = fecha2.toString();
            } catch (Exception e) {
                datos[7] = "";
            }

            AccionesCrud classcrud = new AccionesCrud();
            if (classcrud.Guardar_Modificar(datos, "exec [UpdateFiniquito] ?,?,?,?,?,?,?,?")) {
                DatosTablas Datos = new DatosTablas();
                Datos.CargarTabla(tblFiniquitos, "select * from VistaFiniquitos");
            }
        }

    }//GEN-LAST:event_btnModificarActionPerformed

    private void btnGuardarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnGuardarActionPerformed
        LimpiarErrores();
        if (ValidarCampos()) {
            Object[] datos = new Object[8];
            //se crea un arreglo de objetos para enviar a la clase de AccionesCrud y la funcion de Guardar_Modificar
            datos[0] = "";
            datos[1] = txtLinea.getText();
            try {
                Date date = dtpSolicitud.getDate();
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);
                datos[2] = fecha.toString();
            } catch (Exception e) {
                datos[2] = "";
            }
            try {
                Date date = dtpCorte.getDate();
                long d = date.getTime();
                java.sql.Date fecha = new java.sql.Date(d);
                datos[3] = fecha.toString();
            } catch (Exception e) {
                datos[3] = "";
            }
            datos[4] = Double.parseDouble(txtCobro.getText());
            datos[5] = txtObs1.getText();
            datos[6] = txtObs2.getText();
            try {
                Date date2 = dtpCobro.getDate();
                long d2 = date2.getTime();
                java.sql.Date fecha2 = new java.sql.Date(d2);
                datos[7] = fecha2.toString();
            } catch (Exception e) {
                datos[7] = "";
            }
            AccionesCrud classcrud = new AccionesCrud();
            if (classcrud.Guardar_Modificar(datos, "exec [AgregarFiniquito] ?,?,?,?,?,?,?,?")) {
                DatosTablas Datos = new DatosTablas();
                Datos.CargarTabla(tblFiniquitos, "select * from VistaFiniquitos");
            }
        }
    }//GEN-LAST:event_btnGuardarActionPerformed

    private void btnEliminarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEliminarActionPerformed
        //se utiliza la funcion Eliminar de la clase AccionesCrud enviando el ID
        AccionesCrud classcrud = new AccionesCrud();
        if (classcrud.Eliminar(txtIDFiniquitos, "exec EliminarFiniquito ?")) {
            DatosTablas Datos = new DatosTablas();
            Datos.CargarTabla(tblFiniquitos, "select * from VistaFiniquitos");
            Limpiar();
        }
    }//GEN-LAST:event_btnEliminarActionPerformed

    private void btnCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCancelarActionPerformed
        Limpiar();
    }//GEN-LAST:event_btnCancelarActionPerformed

    private void tblFiniquitosMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblFiniquitosMouseClicked
        LimpiarErrores();
          //se trata de obtener los datos de la tabla para mostrarlos en las casillas respectivas con ayuda de sql
        try {
            AccionesCrud classcrud = new AccionesCrud();
            ResultSet rs = classcrud.Seleccion(tblFiniquitos, "select * from [VistaFiniquitos] where [ID]=?");
            while (rs.next()) {
                txtIDFiniquitos.setText(rs.getString("ID"));
                //formato para mostrar la fecha en el JDateChooser
                SimpleDateFormat formatofecha = new SimpleDateFormat("yyyy-MM-dd");
                Date fecha;
                try {
                    fecha = formatofecha.parse(rs.getString("Solicitud"));
                    dtpSolicitud.setDate(fecha);
                } catch (ParseException ex) {
                    Logger.getLogger(pnlEquipos.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    fecha = formatofecha.parse(rs.getString("Corte"));
                    dtpCorte.setDate(fecha);
                } catch (ParseException ex) {
                    Logger.getLogger(pnlEquipos.class.getName()).log(Level.SEVERE, null, ex);
                }
                try {
                    fecha = formatofecha.parse(rs.getString("Fecha Cobro"));
                    dtpCobro.setDate(fecha);
                } catch (ParseException ex) {
                    Logger.getLogger(pnlEquipos.class.getName()).log(Level.SEVERE, null, ex);
                }
                txtCobro.setText(rs.getString("Valor Cobro"));
                txtLinea.setText(rs.getString("Linea"));
                txtObs1.setText(rs.getString("Observacion 1"));
                txtObs2.setText(rs.getString("Observacion 2"));

            }
            txtIDFiniquitos.enable(false);
            btnModificar.setVisible(true);
            btnEliminar.setVisible(true);
            btnCancelar.setVisible(true);
            btnGuardar.setVisible(false);
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, e.toString());
        }
    }//GEN-LAST:event_tblFiniquitosMouseClicked

    //Funicon para asignar el tipo de busqueda que se va hacer por medio de un switc y los valores de la vista de la BD
    private void cmbBuscarItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_cmbBuscarItemStateChanged
        //Cada vez que se cambia el estado del combobox se cambia el filtro de busqueda global para la funcion de busqueda
        String elementoSeleccionado = (String) cmbBuscar.getSelectedItem();
        switch (elementoSeleccionado) {
            case "Linea Telefonica":
                Busqueda = "Linea";
                break;
            default:
                break;
        }
    }//GEN-LAST:event_cmbBuscarItemStateChanged

    private void txtBuscarKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtBuscarKeyReleased
          //cada vez que se precione una tecla se va a buscar junto al filtro de busqueda en la vista correspondiente
        DatosTablas BusquedaTabla = new DatosTablas();
        //se limpia la tabla
        DefaultTableModel modelo = (DefaultTableModel) tblFiniquitos.getModel();
        modelo.setRowCount(0);
        //se muestra los resultados de la busqueda
        BusquedaTabla.CargarTabla(tblFiniquitos, "select * from VistaFiniquitos where " + Busqueda + " LIKE '%" + txtBuscar.getText() + "%'");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtCobroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCobroKeyTyped
        int key = evt.getKeyChar();
        //expresion regular que solo permite numeros, tecla de eliminar y un punto
        boolean numero = (key >= 48 && key <= 57) || (key == 46 && !txtCobro.getText().contains(".")) || key == KeyEvent.VK_BACK_SPACE;
        if (txtCobro.getText().length() == 8 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCobroKeyTyped

    private void txtLineaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLineaKeyTyped
        String text = txtLinea.getText();
        int key = evt.getKeyChar();
        //Solo permitir numeros
        boolean numero= key >= 48 && key <= 57 || key == KeyEvent.VK_BACK_SPACE;
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

    private void txtCobroKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCobroKeyReleased
        //al escribir se quita el estado de error
        val.TXTcorrecto(txtCobro, lblErValor);
    }//GEN-LAST:event_txtCobroKeyReleased

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        Limpiar();
    }//GEN-LAST:event_jMenuItem1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro btnCancelar;
    private rsbuttom.RSButtonMetro btnEliminar;
    private rsbuttom.RSButtonMetro btnGuardar;
    private rsbuttom.RSButtonMetro btnModificar;
    private javax.swing.JComboBox<String> cmbBuscar;
    private com.toedter.calendar.JDateChooser dtpCobro;
    private com.toedter.calendar.JDateChooser dtpCorte;
    private com.toedter.calendar.JDateChooser dtpSolicitud;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel12;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPopupMenu jPopupMenu1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblErCobro;
    private javax.swing.JLabel lblErCorte;
    private javax.swing.JLabel lblErLinea;
    private javax.swing.JLabel lblErSolicitud;
    private javax.swing.JLabel lblErValor;
    private javax.swing.JTable tblFiniquitos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCobro;
    private javax.swing.JTextField txtIDFiniquitos;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtObs1;
    private javax.swing.JTextField txtObs2;
    // End of variables declaration//GEN-END:variables
}
