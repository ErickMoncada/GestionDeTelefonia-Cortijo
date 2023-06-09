
package paneles;
import Clases.DatosTablas;
import paneles.ExtraUsuarios.Categoria;
import paneles.ExtraUsuarios.CentroCosto;
import paneles.ExtraUsuarios.Planilla;
import paneles.ExtraUsuarios.PuestoTrabajo;
import paneles.ExtraUsuarios.Ubicacion;

public class pnlUsuarios extends javax.swing.JPanel {


    public pnlUsuarios() {
        initComponents();
        CargarDatosPrincipal();
        
        
    }
    
    private void CargarDatosPrincipal(){
    //rellenar datos de la tabla
        DatosTablas Datos = new DatosTablas();
        Datos.CargarTabla(tblUsuarios,null,"select * from VistaUsuarios");
        Datos.cargarComboBox("select CentroCosto from VistaCentroCosto", "CentroCosto", cmbCentroCosto);
        Datos.cargarComboBox("select Planilla from VistaPlanillas", "Planilla", cmbPlanilla);
        Datos.cargarComboBox("select Puesto from VistaPuestosTrabajos", "Puesto", cmbPuesto);
        Datos.cargarComboBox("select Ubicacion from VistaUbicaciones", "Ubicacion", cmbUbicacion);
        Datos.cargarComboBox("select Categoria from VistaCategoriaUser", "Categoria", cmbCategoria);
        
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        filler1 = new javax.swing.Box.Filler(new java.awt.Dimension(0, 0), new java.awt.Dimension(0, 0), new java.awt.Dimension(32767, 0));
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jLabel3 = new javax.swing.JLabel();
        jTextField3 = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        jTextField4 = new javax.swing.JTextField();
        jLabel8 = new javax.swing.JLabel();
        cmbPuesto = new javax.swing.JComboBox<>();
        cmbCentroCosto = new javax.swing.JComboBox<>();
        cmbPlanilla = new javax.swing.JComboBox<>();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        jTextField6 = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        cmbUbicacion = new javax.swing.JComboBox<>();
        jLabel11 = new javax.swing.JLabel();
        cmbCategoria = new javax.swing.JComboBox<>();
        btnCodigo = new javax.swing.JButton();
        btnCodigo1 = new javax.swing.JButton();
        btnCodigo2 = new javax.swing.JButton();
        btnBuscar = new javax.swing.JButton();
        btnCrudCC = new javax.swing.JButton();
        btnCrudPuesto = new javax.swing.JButton();
        btnCRUDPlanilla = new javax.swing.JButton();
        btnCrudCC3 = new javax.swing.JButton();
        btnCrudUbi = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblUsuarios = new javax.swing.JTable();

        setBackground(new java.awt.Color(255, 255, 255));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jLabel1.setForeground(new java.awt.Color(0, 0, 0));
        jLabel1.setText("Numero de Expediente:");

        jTextField1.setPreferredSize(new java.awt.Dimension(65, 26));

        jLabel2.setForeground(new java.awt.Color(0, 0, 0));
        jLabel2.setText("Numero de Linea:");

        jTextField2.setPreferredSize(new java.awt.Dimension(65, 26));
        jTextField2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jTextField2ActionPerformed(evt);
            }
        });

        jLabel3.setForeground(new java.awt.Color(0, 0, 0));
        jLabel3.setText("Nombre de usuario:");

        jTextField3.setPreferredSize(new java.awt.Dimension(65, 26));

        jLabel4.setForeground(new java.awt.Color(0, 0, 0));
        jLabel4.setText("Codigo Empleado:");

        jTextField4.setPreferredSize(new java.awt.Dimension(65, 26));

        jLabel8.setForeground(new java.awt.Color(0, 0, 0));
        jLabel8.setText("Puesto de Trabajo:");

        cmbPuesto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        cmbCentroCosto.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        cmbPlanilla.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel5.setForeground(new java.awt.Color(0, 0, 0));
        jLabel5.setText("Centro de Costo:");

        jLabel6.setForeground(new java.awt.Color(0, 0, 0));
        jLabel6.setText("Codigo SAP:");

        jTextField5.setPreferredSize(new java.awt.Dimension(65, 26));

        jLabel7.setForeground(new java.awt.Color(0, 0, 0));
        jLabel7.setText("Planilla:");

        jLabel9.setForeground(new java.awt.Color(0, 0, 0));
        jLabel9.setText("Jefe:");

        jTextField6.setPreferredSize(new java.awt.Dimension(65, 26));

        jLabel10.setForeground(new java.awt.Color(0, 0, 0));
        jLabel10.setText("Ubicacion:");

        cmbUbicacion.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        jLabel11.setForeground(new java.awt.Color(0, 0, 0));
        jLabel11.setText("Categoria:");

        cmbCategoria.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { " " }));

        btnCodigo.setBackground(new java.awt.Color(114, 191, 68));
        btnCodigo.setText("Guardar");
        btnCodigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodigoActionPerformed(evt);
            }
        });

        btnCodigo1.setBackground(new java.awt.Color(114, 191, 68));
        btnCodigo1.setText("Remover");
        btnCodigo1.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCodigo1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodigo1ActionPerformed(evt);
            }
        });

        btnCodigo2.setBackground(new java.awt.Color(114, 191, 68));
        btnCodigo2.setText("Modificar");
        btnCodigo2.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCodigo2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodigo2ActionPerformed(evt);
            }
        });

        btnBuscar.setText("Buscar");
        btnBuscar.setMaximumSize(new java.awt.Dimension(40, 40));
        btnBuscar.setMinimumSize(new java.awt.Dimension(40, 40));
        btnBuscar.setPreferredSize(new java.awt.Dimension(40, 40));

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

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(btnCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(168, 168, 168)
                        .addComponent(btnCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel4)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(143, 143, 143)
                                .addComponent(btnCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 111, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel1)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGroup(jPanel1Layout.createSequentialGroup()
                                        .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addGap(54, 54, 54)
                                        .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 83, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE))))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 40, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel8)
                            .addComponent(jLabel7)
                            .addComponent(jLabel5)
                            .addComponent(jLabel6))
                        .addGap(32, 32, 32)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
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
                                            .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmbPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 158, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnCrudPuesto)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel1)
                            .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnBuscar, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel2)
                            .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel4)
                            .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCodigo1, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnCodigo2, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
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
                                    .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                    .addComponent(jLabel9)
                                    .addComponent(jTextField6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
                            .addComponent(btnCrudPuesto, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );

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
                "N. Expediente", "N. Linea", "Nombre", "Cod. Empleado", "Centro de Costo", "Planilla", "Cod. SAP", "Puesto de Trabajo", "Jefe", "Ubicacion", "Categoria"
            }
        ));
        tblUsuarios.setGridColor(new java.awt.Color(0, 0, 0));
        tblUsuarios.setSelectionBackground(new java.awt.Color(51, 153, 0));
        jScrollPane1.setViewportView(tblUsuarios);

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
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 454, Short.MAX_VALUE)
                .addGap(25, 25, 25))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void btnCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCodigoActionPerformed

    private void btnCodigo1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodigo1ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCodigo1ActionPerformed

    private void btnCodigo2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodigo2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCodigo2ActionPerformed

    private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jTextField2ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jTextField2ActionPerformed

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


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnBuscar;
    private javax.swing.JButton btnCRUDPlanilla;
    private javax.swing.JButton btnCodigo;
    private javax.swing.JButton btnCodigo1;
    private javax.swing.JButton btnCodigo2;
    private javax.swing.JButton btnCrudCC;
    private javax.swing.JButton btnCrudCC3;
    private javax.swing.JButton btnCrudPuesto;
    private javax.swing.JButton btnCrudUbi;
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
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JTextField jTextField6;
    private javax.swing.JTable tblUsuarios;
    // End of variables declaration//GEN-END:variables
}
