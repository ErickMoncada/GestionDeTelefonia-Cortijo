package paneles;

import Clases.AccionesCrud;
import Clases.DatosTablas;
import java.awt.Color;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
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

    private void Limpiar() {
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

    }

    private void CargarDatosPrincipal() {
        //rellenar datos de la tabla
        DatosTablas Datos = new DatosTablas();
        Datos.CargarTabla(tblFiniquitos, "select * from VistaFiniquitos");

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



        return valor1 == 1; //Expreciones regulares de los campos
        //4 o menos digitos numericos 
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblFiniquitos = new javax.swing.JTable();
        txtBuscar = new javax.swing.JTextField();
        cmbBuscar = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

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

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Fecha de Solicitud\n");

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Por parte de RRHH:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Fecha de Corte:");

        txtCobro.setPreferredSize(new java.awt.Dimension(65, 26));
        txtCobro.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCobroKeyTyped(evt);
            }
        });

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Valor de Cobro:");

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Linea Telefonica:");

        txtLinea.setPreferredSize(new java.awt.Dimension(65, 26));
        txtLinea.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtLineaKeyTyped(evt);
            }
        });

        txtObs1.setPreferredSize(new java.awt.Dimension(65, 26));
        txtObs1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObs1KeyTyped(evt);
            }
        });

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Observacion 1:");

        txtObs2.setPreferredSize(new java.awt.Dimension(65, 26));
        txtObs2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtObs2KeyTyped(evt);
            }
        });

        jLabel12.setForeground(new java.awt.Color(0, 0, 0));
        jLabel12.setText("Observacion 2:");

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Fecha de Cobro:");

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
                                    .addComponent(dtpSolicitud, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(dtpCobro, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(50, 50, 50)
                                        .addComponent(jLabel10))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGap(56, 56, 56)
                                        .addComponent(jLabel9)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtCobro, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel11))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel12)))
                                .addGap(18, 18, 18)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(txtObs2, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(txtObs1, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(41, 41, 41)
                                .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 128, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                .addContainerGap(717, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(txtIDFiniquitos, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jLabel4)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 12, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                            .addComponent(jLabel9)
                                            .addComponent(txtCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                            .addComponent(jLabel11)
                                            .addComponent(txtObs1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(6, 6, 6))
                                    .addComponent(dtpSolicitud, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 34, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(dtpCorte, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jLabel10)
                                .addComponent(txtLinea, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel12)
                                .addComponent(txtObs2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 32, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addComponent(dtpCobro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnGuardar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnModificar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEliminar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

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
        if (ValidarCampos()) {
            Object[] datos = new Object[8];
            //se manda el ID pero no se utiliza en Agregar
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
        if (ValidarCampos()) {
           Object[] datos = new Object[8];
          
           datos[0]="";
            
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
        DatosTablas BusquedaTabla = new DatosTablas();
        //se limpia la tabla
        DefaultTableModel modelo = (DefaultTableModel) tblFiniquitos.getModel();
        modelo.setRowCount(0);
        //se muestra los resultados de la busqueda
        BusquedaTabla.CargarTabla(tblFiniquitos,  "select * from VistaFiniquitos where " + Busqueda + " LIKE '%" + txtBuscar.getText() + "%'");
    }//GEN-LAST:event_txtBuscarKeyReleased

    private void txtCobroKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCobroKeyTyped
        int key = evt.getKeyChar();
        boolean numero = (key >= 48 && key <= 57) || (key == 46 && !txtCobro.getText().contains(".")) || key == KeyEvent.VK_BACK_SPACE;
        if (txtCobro.getText().length() == 8 || !numero) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCobroKeyTyped

    private void txtLineaKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtLineaKeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtLineaKeyTyped

    private void txtObs1KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObs1KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObs1KeyTyped

    private void txtObs2KeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtObs2KeyTyped
        // TODO add your handling code here:
    }//GEN-LAST:event_txtObs2KeyTyped


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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tblFiniquitos;
    private javax.swing.JTextField txtBuscar;
    private javax.swing.JTextField txtCobro;
    private javax.swing.JTextField txtIDFiniquitos;
    private javax.swing.JTextField txtLinea;
    private javax.swing.JTextField txtObs1;
    private javax.swing.JTextField txtObs2;
    // End of variables declaration//GEN-END:variables
}
