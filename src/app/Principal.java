package app;

import java.awt.Color;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;
import paneles.CambiaPanel;
import Clases.Reescalado_Imagenes;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;
import javax.swing.Timer;

public class Principal extends javax.swing.JFrame {

    public Principal() {
        initComponents();
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setLocationRelativeTo(this);
        //iniciar con la seleccion en el boton 1
        //this.btnUserTel.setSelected(true);
        //se declara la clase para cambiar de paneles, en este caso para mostrar el primer panel al cargar el form
        new CambiaPanel(pnlPrincipal, new paneles.pnlHome());

        //iniciar funcion para el icono
        Reescalado_Imagenes reescalar = new Reescalado_Imagenes();
        setIconImage(reescalar.getIconImage());
        //Iniciar funcion para iconos del submenu y titulo
        IconosBarraLateral();
        //iniciar funcion de hora
        Reloj();

    }

    //asignar los iconos de cada submenu y titulo
    private void IconosBarraLateral() {
        Reescalado_Imagenes reescalar = new Reescalado_Imagenes();
        btnUserTel.setIcon(reescalar.IconoTextoMenu(50, 50, "img1/agregar-usuario.png"));
        btnEquipos.setIcon(reescalar.IconoTextoMenu(50, 50, "img1/equipos.png"));
        btnFiniquitos.setIcon(reescalar.IconoTextoMenu(50, 50, "img1/pago.png"));
        btnLineasTelefonicas.setIcon(reescalar.IconoTextoMenu(50, 50, "img1/signal.png"));
        lblTituloTelefonia.setIcon(reescalar.IconoTextoMenu(50, 50, "img1/Pollos-El-Cortijo.png"));
    }

    ///funcion para mostrar reloj
    private void Reloj() {

        // Crear un ActionListener para actualizar la hora
        ActionListener actualizarHora = new ActionListener() {
            public void actionPerformed(ActionEvent evento) {
                // Obtener la hora actual
                Date horaActual = new Date();
                SimpleDateFormat formatoHora = new SimpleDateFormat("MMM dd yyyy, hh:mm a");

                // Actualizar la etiqueta con la hora actual
                lblHora.setText(formatoHora.format(horaActual));
            }
        };

        // Crear un Timer para actualizar la hora cada segundo
        Timer timer = new Timer(1000, actualizarHora);
        timer.start();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {
        java.awt.GridBagConstraints gridBagConstraints;

        jPanel1 = new javax.swing.JPanel();
        pnlMenu = new javax.swing.JPanel();
        btnUserTel = new rsbuttom.RSButtonMetro();
        jPanel4 = new javax.swing.JPanel();
        lblTelefonia = new javax.swing.JLabel();
        btnFiniquitos = new rsbuttom.RSButtonMetro();
        btnEquipos = new rsbuttom.RSButtonMetro();
        jPanel5 = new javax.swing.JPanel();
        jLabel3 = new javax.swing.JLabel();
        btnAjustes = new rsbuttom.RSButtonMetro();
        btnLineasTelefonicas = new rsbuttom.RSButtonMetro();
        pnlCentro = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        lblHora = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        pnlPrincipal = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        btnMenu = new javax.swing.JButton();
        lblTituloTelefonia = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Telefonia-Cortijo");
        setMinimumSize(new java.awt.Dimension(1300, 700));
        setSize(new java.awt.Dimension(1450, 700));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setPreferredSize(new java.awt.Dimension(1450, 700));
        jPanel1.setLayout(new java.awt.GridBagLayout());

        pnlMenu.setBackground(new java.awt.Color(239, 238, 244));
        pnlMenu.setBorder(javax.swing.BorderFactory.createMatteBorder(0, 5, 0, 0, new java.awt.Color(239, 238, 244)));

        btnUserTel.setBackground(new java.awt.Color(239, 238, 244));
        btnUserTel.setForeground(new java.awt.Color(128, 128, 131));
        btnUserTel.setText("Usuarios");
        btnUserTel.setColorHover(new java.awt.Color(204, 204, 204));
        btnUserTel.setColorNormal(new java.awt.Color(204, 204, 204));
        btnUserTel.setColorPressed(new java.awt.Color(204, 204, 204));
        btnUserTel.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnUserTel.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnUserTel.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnUserTel.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnUserTel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnUserTel.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnUserTel.setIconTextGap(25);
        btnUserTel.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnUserTelMousePressed(evt);
            }
        });
        btnUserTel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUserTelActionPerformed(evt);
            }
        });

        jPanel4.setBackground(new java.awt.Color(239, 238, 244));

        lblTelefonia.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblTelefonia.setForeground(new java.awt.Color(128, 128, 131));
        lblTelefonia.setText("TELEFONIA");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTelefonia)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap(41, Short.MAX_VALUE)
                .addComponent(lblTelefonia)
                .addContainerGap())
        );

        btnFiniquitos.setBackground(new java.awt.Color(239, 238, 244));
        btnFiniquitos.setForeground(new java.awt.Color(128, 128, 131));
        btnFiniquitos.setText("Finiquitos");
        btnFiniquitos.setColorHover(new java.awt.Color(204, 204, 204));
        btnFiniquitos.setColorNormal(new java.awt.Color(239, 238, 244));
        btnFiniquitos.setColorPressed(new java.awt.Color(204, 204, 204));
        btnFiniquitos.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnFiniquitos.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnFiniquitos.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnFiniquitos.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnFiniquitos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnFiniquitos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnFiniquitos.setIconTextGap(19);
        btnFiniquitos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnFiniquitosMousePressed(evt);
            }
        });
        btnFiniquitos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiniquitosActionPerformed(evt);
            }
        });

        btnEquipos.setBackground(new java.awt.Color(239, 238, 244));
        btnEquipos.setForeground(new java.awt.Color(128, 128, 131));
        btnEquipos.setText("Equipos");
        btnEquipos.setColorHover(new java.awt.Color(204, 204, 204));
        btnEquipos.setColorNormal(new java.awt.Color(239, 238, 244));
        btnEquipos.setColorPressed(new java.awt.Color(204, 204, 204));
        btnEquipos.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnEquipos.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnEquipos.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnEquipos.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnEquipos.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnEquipos.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnEquipos.setIconTextGap(25);
        btnEquipos.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnEquiposMousePressed(evt);
            }
        });
        btnEquipos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEquiposActionPerformed(evt);
            }
        });

        jPanel5.setBackground(new java.awt.Color(239, 238, 244));

        jLabel3.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(128, 128, 131));
        jLabel3.setText("Aplicacion");
        jLabel3.setToolTipText("");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel3)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap(23, Short.MAX_VALUE)
                .addComponent(jLabel3)
                .addContainerGap())
        );

        btnAjustes.setBackground(new java.awt.Color(239, 238, 244));
        btnAjustes.setForeground(new java.awt.Color(128, 128, 131));
        btnAjustes.setText("Ajustes");
        btnAjustes.setColorHover(new java.awt.Color(204, 204, 204));
        btnAjustes.setColorNormal(new java.awt.Color(239, 238, 244));
        btnAjustes.setColorPressed(new java.awt.Color(204, 204, 204));
        btnAjustes.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnAjustes.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnAjustes.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnAjustes.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnAjustes.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnAjustes.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnAjustes.setIconTextGap(25);
        btnAjustes.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnAjustesMousePressed(evt);
            }
        });
        btnAjustes.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAjustesActionPerformed(evt);
            }
        });

        btnLineasTelefonicas.setBackground(new java.awt.Color(239, 238, 244));
        btnLineasTelefonicas.setForeground(new java.awt.Color(128, 128, 131));
        btnLineasTelefonicas.setText("Lineas Telefonicas");
        btnLineasTelefonicas.setColorHover(new java.awt.Color(204, 204, 204));
        btnLineasTelefonicas.setColorNormal(new java.awt.Color(239, 238, 244));
        btnLineasTelefonicas.setColorPressed(new java.awt.Color(204, 204, 204));
        btnLineasTelefonicas.setColorTextHover(new java.awt.Color(128, 128, 131));
        btnLineasTelefonicas.setColorTextNormal(new java.awt.Color(128, 128, 131));
        btnLineasTelefonicas.setColorTextPressed(new java.awt.Color(128, 128, 131));
        btnLineasTelefonicas.setFont(new java.awt.Font("SansSerif", 1, 14)); // NOI18N
        btnLineasTelefonicas.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        btnLineasTelefonicas.setHorizontalTextPosition(javax.swing.SwingConstants.RIGHT);
        btnLineasTelefonicas.setIconTextGap(19);
        btnLineasTelefonicas.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mousePressed(java.awt.event.MouseEvent evt) {
                btnLineasTelefonicasMousePressed(evt);
            }
        });
        btnLineasTelefonicas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLineasTelefonicasActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlMenuLayout = new javax.swing.GroupLayout(pnlMenu);
        pnlMenu.setLayout(pnlMenuLayout);
        pnlMenuLayout.setHorizontalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addGroup(pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btnUserTel, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiniquitos, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnLineasTelefonicas, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, 258, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(0, 0, Short.MAX_VALUE))
        );
        pnlMenuLayout.setVerticalGroup(
            pnlMenuLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMenuLayout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(btnUserTel, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnEquipos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnFiniquitos, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(btnLineasTelefonicas, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(44, 44, 44)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(4, 4, 4)
                .addComponent(btnAjustes, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(166, 166, 166))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.fill = java.awt.GridBagConstraints.VERTICAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.WEST;
        gridBagConstraints.weighty = 8.3;
        gridBagConstraints.insets = new java.awt.Insets(0, 0, 0, 1);
        jPanel1.add(pnlMenu, gridBagConstraints);

        pnlCentro.setBackground(new java.awt.Color(255, 255, 255));

        jPanel6.setBackground(new java.awt.Color(255, 255, 255));

        lblHora.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblHora.setForeground(new java.awt.Color(128, 128, 131));
        lblHora.setText("9:57 A.M. Miercoles");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHora)
                .addContainerGap(1022, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblHora)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setBorder(null);

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setLayout(new javax.swing.BoxLayout(pnlPrincipal, javax.swing.BoxLayout.LINE_AXIS));
        jScrollPane1.setViewportView(pnlPrincipal);

        javax.swing.GroupLayout pnlCentroLayout = new javax.swing.GroupLayout(pnlCentro);
        pnlCentro.setLayout(pnlCentroLayout);
        pnlCentroLayout.setHorizontalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        pnlCentroLayout.setVerticalGroup(
            pnlCentroLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlCentroLayout.createSequentialGroup()
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 590, Short.MAX_VALUE)
                .addContainerGap())
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 1;
        gridBagConstraints.gridy = 1;
        gridBagConstraints.gridwidth = 2;
        gridBagConstraints.fill = java.awt.GridBagConstraints.BOTH;
        gridBagConstraints.weightx = 0.4;
        gridBagConstraints.weighty = 0.1;
        jPanel1.add(pnlCentro, gridBagConstraints);

        jPanel2.setBackground(new java.awt.Color(57, 181, 74));
        jPanel2.setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));

        btnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/menu.png"))); // NOI18N
        btnMenu.setBorder(null);
        btnMenu.setContentAreaFilled(false);
        btnMenu.setCursor(new java.awt.Cursor(java.awt.Cursor.HAND_CURSOR));
        btnMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnMenuActionPerformed(evt);
            }
        });

        lblTituloTelefonia.setBackground(new java.awt.Color(255, 255, 255));
        lblTituloTelefonia.setFont(new java.awt.Font("SansSerif", 0, 18)); // NOI18N
        lblTituloTelefonia.setForeground(new java.awt.Color(255, 255, 255));
        lblTituloTelefonia.setText("Telefonia - Cortijo");

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btnMenu)
                .addGap(18, 18, 18)
                .addComponent(lblTituloTelefonia)
                .addContainerGap(1233, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(btnMenu, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(lblTituloTelefonia, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        gridBagConstraints = new java.awt.GridBagConstraints();
        gridBagConstraints.gridx = 0;
        gridBagConstraints.gridy = 0;
        gridBagConstraints.gridwidth = 3;
        gridBagConstraints.fill = java.awt.GridBagConstraints.HORIZONTAL;
        gridBagConstraints.anchor = java.awt.GridBagConstraints.PAGE_START;
        gridBagConstraints.weightx = 0.2;
        jPanel1.add(jPanel2, gridBagConstraints);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    //Genera la accion para cambiar de panel USUARIOS llamando a la clase del paquete paneles y cambia los colores de los que se seleccionaron antes
    private void btnUserTelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUserTelActionPerformed
        new CambiaPanel(pnlPrincipal, new paneles.pnlUsuarios());
        if (this.btnUserTel.isSelected()) {
            this.btnUserTel.setColorNormal(new Color(204, 204, 204));
            this.btnEquipos.setColorNormal(new Color(239, 238, 244));
            this.btnFiniquitos.setColorNormal(new Color(239, 238, 244));
            this.btnLineasTelefonicas.setColorNormal(new Color(239, 238, 244));
            this.btnAjustes.setColorNormal(new Color(239, 238, 244));
        } else {
            this.btnUserTel.setColorNormal(new Color(239, 238, 244));
        }
    }//GEN-LAST:event_btnUserTelActionPerformed

    //Establecer el estado de seleccionado al correspondiente boton y los demas con el estado desactivado
    private void btnUserTelMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnUserTelMousePressed
        this.btnUserTel.setSelected(true);
        this.btnEquipos.setSelected(false);
        this.btnFiniquitos.setSelected(false);
        this.btnLineasTelefonicas.setSelected(false);
        this.btnAjustes.setSelected(false);
    }//GEN-LAST:event_btnUserTelMousePressed

    //Genera la accion para cambiar de panel llamando a la clase del paquete paneles y cambia los colores de los que se seleccionaron antes
    private void btnFiniquitosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiniquitosActionPerformed
        new CambiaPanel(pnlPrincipal, new paneles.pnlFiniquitos());
        if (this.btnFiniquitos.isSelected()) {
            this.btnFiniquitos.setColorNormal(new Color(204, 204, 204));
            this.btnEquipos.setColorNormal(new Color(239, 238, 244));
            this.btnUserTel.setColorNormal(new Color(239, 238, 244));
            this.btnLineasTelefonicas.setColorNormal(new Color(239, 238, 244));
            this.btnAjustes.setColorNormal(new Color(239, 238, 244));
        } else {
            this.btnUserTel.setColorNormal(new Color(239, 238, 244));
        }
    }//GEN-LAST:event_btnFiniquitosActionPerformed

    //Establecer el estado de seleccionado al correspondiente boton y los demas con el estado desactivado
    private void btnFiniquitosMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnFiniquitosMousePressed
        this.btnUserTel.setSelected(false);
        this.btnEquipos.setSelected(false);
        this.btnFiniquitos.setSelected(true);
        this.btnLineasTelefonicas.setSelected(false);
        this.btnAjustes.setSelected(false);
    }//GEN-LAST:event_btnFiniquitosMousePressed

    //Establecer el estado de seleccionado al correspondiente boton y los demas con el estado desactivado
    private void btnEquiposMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnEquiposMousePressed
        this.btnUserTel.setSelected(false);
        this.btnEquipos.setSelected(true);
        this.btnFiniquitos.setSelected(false);
        this.btnLineasTelefonicas.setSelected(false);
        this.btnAjustes.setSelected(false);
    }//GEN-LAST:event_btnEquiposMousePressed

    //Genera la accion para cambiar de panel llamando a la clase del paquete paneles y cambia los colores de los que se seleccionaron antes
    private void btnEquiposActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEquiposActionPerformed
        new CambiaPanel(pnlPrincipal, new paneles.pnlEquipos());
        if (this.btnEquipos.isSelected()) {
            this.btnEquipos.setColorNormal(new Color(204, 204, 204));
            this.btnUserTel.setColorNormal(new Color(239, 238, 244));
            this.btnFiniquitos.setColorNormal(new Color(239, 238, 244));
            this.btnLineasTelefonicas.setColorNormal(new Color(239, 238, 244));
            this.btnAjustes.setColorNormal(new Color(239, 238, 244));
        } else {
            this.btnEquipos.setColorNormal(new Color(239, 238, 244));
        }
    }//GEN-LAST:event_btnEquiposActionPerformed

    //Accion de boton hamburguesa para desplegar o esconder el menu lateral utilizando la libreria de NefAnimacion
    private void btnMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnMenuActionPerformed
        int posicion = pnlMenu.getX();
        if (posicion > -1) {
            Animacion.Animacion.mover_izquierda(0, -264, 2, 2, pnlMenu);
            Timer timer = new Timer(400, new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    pnlMenu.setVisible(false);
                }
            });
            timer.setRepeats(false);
            timer.start();

        } else {
            Animacion.Animacion.mover_derecha(-264, 0, 2, 2, pnlMenu);
            pnlMenu.setVisible(true);
        }
    }//GEN-LAST:event_btnMenuActionPerformed

    //Establecer el estado de seleccionado al correspondiente boton y los demas con el estado desactivado
    private void btnAjustesMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAjustesMousePressed
        this.btnUserTel.setSelected(false);
        this.btnEquipos.setSelected(false);
        this.btnFiniquitos.setSelected(false);
        this.btnLineasTelefonicas.setSelected(false);
        this.btnAjustes.setSelected(true);
    }//GEN-LAST:event_btnAjustesMousePressed

    //Genera la accion para cambiar de panel llamando a la clase del paquete paneles y cambia los colores de los que se seleccionaron antes
    private void btnAjustesActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAjustesActionPerformed

    }//GEN-LAST:event_btnAjustesActionPerformed

    //Establecer el estado de seleccionado al correspondiente boton y los demas con el estado desactivado
    private void btnLineasTelefonicasMousePressed(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnLineasTelefonicasMousePressed
        this.btnUserTel.setSelected(false);
        this.btnEquipos.setSelected(false);
        this.btnFiniquitos.setSelected(false);
        this.btnLineasTelefonicas.setSelected(true);
        this.btnAjustes.setSelected(false);
    }//GEN-LAST:event_btnLineasTelefonicasMousePressed

    //Genera la accion para cambiar de panel llamando a la clase del paquete paneles y cambia los colores de los que se seleccionaron antes
    private void btnLineasTelefonicasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnLineasTelefonicasActionPerformed
        new CambiaPanel(pnlPrincipal, new paneles.pnlLineasTelefonicas());
        if (this.btnLineasTelefonicas.isSelected()) {
            this.btnLineasTelefonicas.setColorNormal(new Color(204, 204, 204));
            this.btnUserTel.setColorNormal(new Color(239, 238, 244));
            this.btnFiniquitos.setColorNormal(new Color(239, 238, 244));
            this.btnEquipos.setColorNormal(new Color(239, 238, 244));
            this.btnAjustes.setColorNormal(new Color(239, 238, 244));
        } else {
            this.btnEquipos.setColorNormal(new Color(239, 238, 244));
        }
    }//GEN-LAST:event_btnLineasTelefonicasActionPerformed

    public static void main(String args[]) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    /*Se establece el aspecto visual del administrador de la interfaz de usuario (UIManager) con el aspecto visual predeterminado del sistema utilizando el método setLookAndFeel
                    Se intenta cargar la clase del aspecto visual del sistema utilizando el método getSystemLookAndFeelClassName. Este método recupera el nombre de clase completamente cualificado del aspecto visual predeterminado proporcionado por el sistema operativo.
                     */
                    UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
                    new Principal().setVisible(true);
                } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
                    //se registra un mensaje de error utilizando la clase Logger, que forma parte de la API de registro de Java.
                    Logger.getLogger(Principal.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private rsbuttom.RSButtonMetro btnAjustes;
    private rsbuttom.RSButtonMetro btnEquipos;
    private rsbuttom.RSButtonMetro btnFiniquitos;
    private rsbuttom.RSButtonMetro btnLineasTelefonicas;
    private javax.swing.JButton btnMenu;
    private rsbuttom.RSButtonMetro btnUserTel;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblHora;
    private javax.swing.JLabel lblTelefonia;
    private javax.swing.JLabel lblTituloTelefonia;
    private javax.swing.JPanel pnlCentro;
    private javax.swing.JPanel pnlMenu;
    private javax.swing.JPanel pnlPrincipal;
    // End of variables declaration//GEN-END:variables
}
