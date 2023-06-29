package app;

import Clases.Reescalado_Imagenes;
import java.awt.Toolkit;
import java.awt.event.KeyEvent;

public class Recuperar extends javax.swing.JFrame {

    public Recuperar() {
        initComponents();
        //asignar icono mediante otra clase
        Reescalado_Imagenes reescalar = new Reescalado_Imagenes();
        setIconImage(reescalar.getIconImage());
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlPrincipal = new javax.swing.JPanel();
        pnlIzquierda = new javax.swing.JPanel();
        icnMenu = new javax.swing.JLabel();
        pnlDerecha = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        btnEnviar = new javax.swing.JButton();
        txtNewPassword = new javax.swing.JPasswordField();
        lblNewPassword = new javax.swing.JLabel();
        lblRepPassword = new javax.swing.JLabel();
        txtRepPassword = new javax.swing.JPasswordField();
        btnCambiar = new javax.swing.JButton();
        txtCodigo = new javax.swing.JTextField();
        lblCodigo = new javax.swing.JLabel();
        btnCodigo = new javax.swing.JButton();
        lblInicio = new javax.swing.JLabel();
        btnInicio = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Recuperar Contraseña");
        setMaximumSize(new java.awt.Dimension(800, 530));
        setMinimumSize(new java.awt.Dimension(800, 530));
        setPreferredSize(new java.awt.Dimension(800, 530));
        setResizable(false);
        setSize(new java.awt.Dimension(800, 530));

        pnlPrincipal.setBackground(new java.awt.Color(255, 255, 255));
        pnlPrincipal.setPreferredSize(new java.awt.Dimension(800, 500));
        pnlPrincipal.setLayout(null);

        pnlIzquierda.setBackground(new java.awt.Color(57, 181, 74));

        icnMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img1/Pollos-El-Cortijo.png"))); // NOI18N

        javax.swing.GroupLayout pnlIzquierdaLayout = new javax.swing.GroupLayout(pnlIzquierda);
        pnlIzquierda.setLayout(pnlIzquierdaLayout);
        pnlIzquierdaLayout.setHorizontalGroup(
            pnlIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlIzquierdaLayout.createSequentialGroup()
                .addContainerGap(53, Short.MAX_VALUE)
                .addComponent(icnMenu)
                .addGap(47, 47, 47))
        );
        pnlIzquierdaLayout.setVerticalGroup(
            pnlIzquierdaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlIzquierdaLayout.createSequentialGroup()
                .addGap(58, 58, 58)
                .addComponent(icnMenu)
                .addContainerGap(152, Short.MAX_VALUE))
        );

        pnlPrincipal.add(pnlIzquierda);
        pnlIzquierda.setBounds(0, 0, 400, 500);

        pnlDerecha.setBackground(new java.awt.Color(255, 255, 255));

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 32)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 136, 64));
        lblTitulo.setText("Recuperar Contraseña");

        lblCorreo.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblCorreo.setText("Correo");

        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });
        txtCorreo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCorreoKeyTyped(evt);
            }
        });

        btnEnviar.setBackground(new java.awt.Color(0, 136, 64));
        btnEnviar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEnviar.setForeground(new java.awt.Color(255, 255, 255));
        btnEnviar.setText("Enviar Codigo");
        btnEnviar.setBorder(null);
        btnEnviar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEnviarActionPerformed(evt);
            }
        });

        txtNewPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtNewPasswordKeyTyped(evt);
            }
        });

        lblNewPassword.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblNewPassword.setText("Contraseña Nueva");

        lblRepPassword.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblRepPassword.setText("Repetir Contraseña");

        txtRepPassword.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtRepPasswordKeyTyped(evt);
            }
        });

        btnCambiar.setBackground(new java.awt.Color(114, 191, 68));
        btnCambiar.setText("Cambiar Contraseña");
        btnCambiar.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCambiar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCambiarActionPerformed(evt);
            }
        });

        txtCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCodigoActionPerformed(evt);
            }
        });
        txtCodigo.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyTyped(java.awt.event.KeyEvent evt) {
                txtCodigoKeyTyped(evt);
            }
        });

        lblCodigo.setFont(new java.awt.Font("SansSerif", 0, 14)); // NOI18N
        lblCodigo.setText("Ingresa el codigo:");

        btnCodigo.setBackground(new java.awt.Color(114, 191, 68));
        btnCodigo.setText("Confirmar");
        btnCodigo.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));
        btnCodigo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnCodigoActionPerformed(evt);
            }
        });

        lblInicio.setText("Inicia sesión:");

        btnInicio.setBackground(new java.awt.Color(255, 255, 255));
        btnInicio.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnInicio.setForeground(new java.awt.Color(114, 191, 68));
        btnInicio.setText("Inicio");
        btnInicio.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnInicioActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDerechaLayout = new javax.swing.GroupLayout(pnlDerecha);
        pnlDerecha.setLayout(pnlDerechaLayout);
        pnlDerechaLayout.setHorizontalGroup(
            pnlDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDerechaLayout.createSequentialGroup()
                .addGroup(pnlDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(pnlDerechaLayout.createSequentialGroup()
                            .addContainerGap()
                            .addGroup(pnlDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(lblCorreo)))
                        .addGroup(pnlDerechaLayout.createSequentialGroup()
                            .addGap(26, 26, 26)
                            .addComponent(lblTitulo))
                        .addGroup(pnlDerechaLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGroup(pnlDerechaLayout.createSequentialGroup()
                            .addContainerGap()
                            .addComponent(lblCodigo)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGap(18, 18, 18)
                            .addComponent(btnCodigo, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlDerechaLayout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(pnlDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblNewPassword)
                            .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblRepPassword)
                            .addComponent(txtRepPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlDerechaLayout.createSequentialGroup()
                                .addComponent(lblInicio)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE))))
                    .addGroup(pnlDerechaLayout.createSequentialGroup()
                        .addGap(134, 134, 134)
                        .addComponent(btnCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 126, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(22, Short.MAX_VALUE))
        );
        pnlDerechaLayout.setVerticalGroup(
            pnlDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDerechaLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnEnviar, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(pnlDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(txtCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(lblCodigo)
                    .addComponent(btnCodigo, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblNewPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(txtNewPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblRepPassword)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtRepPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btnCambiar, javax.swing.GroupLayout.PREFERRED_SIZE, 29, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 47, Short.MAX_VALUE)
                .addGroup(pnlDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblInicio)
                    .addComponent(btnInicio, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        pnlPrincipal.add(pnlDerecha);
        pnlDerecha.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 121, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(pnlPrincipal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 73, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnEnviarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEnviarActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnEnviarActionPerformed

    private void btnCambiarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCambiarActionPerformed

    }//GEN-LAST:event_btnCambiarActionPerformed

    private void txtCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCodigoActionPerformed

    private void btnCodigoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnCodigoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_btnCodigoActionPerformed

    private void btnInicioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnInicioActionPerformed
        Login LoginFrame = new Login(); 
        LoginFrame.setVisible(true);
        LoginFrame.pack();
        LoginFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnInicioActionPerformed

    private void txtCorreoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCorreoKeyTyped
          int key = evt.getKeyChar();
        boolean TeclaBuscar = (key >= 65 && key <= 90) || // Letras mayúsculas
                      (key >= 97 && key <= 122) || // Letras minúsculas
                      (key >= 48 && key <= 57) || // Números
                      (key == KeyEvent.VK_BACK_SPACE) || // Retroceso
                      (key == 64 && !txtCorreo.getText().contains("@"))|| // Símbolo @
                      (key == 46 && !txtCorreo.getText().contains(".")); // Punto
        if (txtCorreo.getText().length() == 80 || !TeclaBuscar) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCorreoKeyTyped

    private void txtCodigoKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtCodigoKeyTyped
        int key = evt.getKeyChar();
        boolean TeclaBuscar = 
                      (key >= 48 && key <= 57) || // Números
                      (key == KeyEvent.VK_SPACE) || // Espacio
                      (key == KeyEvent.VK_BACK_SPACE); // Retroceso
        if (txtCodigo.getText().length() == 5 || !TeclaBuscar) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtCodigoKeyTyped

    private void txtNewPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtNewPasswordKeyTyped
           int key = evt.getKeyChar();
        boolean TeclaBuscar = (key >= 65 && key <= 90) || // Letras mayúsculas
                      (key >= 97 && key <= 122) || // Letras minúsculas
                      (key >= 48 && key <= 57) || // Números
                      (key == KeyEvent.VK_BACK_SPACE) ; // Retroceso
        if (txtNewPassword.getText().length() == 50 || !TeclaBuscar) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtNewPasswordKeyTyped

    private void txtRepPasswordKeyTyped(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txtRepPasswordKeyTyped
        int key = evt.getKeyChar();
        boolean TeclaBuscar = (key >= 65 && key <= 90) || // Letras mayúsculas
                      (key >= 97 && key <= 122) || // Letras minúsculas
                      (key >= 48 && key <= 57) || // Números
                      (key == KeyEvent.VK_BACK_SPACE) ; // Retroceso
        if (txtRepPassword.getText().length() == 50 || !TeclaBuscar) {
            evt.consume();
            Toolkit.getDefaultToolkit().beep();
        }
    }//GEN-LAST:event_txtRepPasswordKeyTyped



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnCambiar;
    private javax.swing.JButton btnCodigo;
    private javax.swing.JButton btnEnviar;
    private javax.swing.JButton btnInicio;
    private javax.swing.JLabel icnMenu;
    private javax.swing.JLabel lblCodigo;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblInicio;
    private javax.swing.JLabel lblNewPassword;
    private javax.swing.JLabel lblRepPassword;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlDerecha;
    private javax.swing.JPanel pnlIzquierda;
    private javax.swing.JPanel pnlPrincipal;
    private javax.swing.JTextField txtCodigo;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JPasswordField txtNewPassword;
    private javax.swing.JPasswordField txtRepPassword;
    // End of variables declaration//GEN-END:variables
}
