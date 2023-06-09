
package app;

import Clases.Reescalado_Imagenes;



public class Login extends javax.swing.JFrame {


    public Login() {
        initComponents();
        //asignar icono mediante otra clase
        Reescalado_Imagenes reescalar = new Reescalado_Imagenes();
        setIconImage(reescalar.getIconImage());
        String gato=System.getenv("PERRO");
        System.out.println(gato);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        pnlIzquierda = new javax.swing.JPanel();
        icnMenu = new javax.swing.JLabel();
        pnlDerecha = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCorreo = new javax.swing.JLabel();
        txtCorreo = new javax.swing.JTextField();
        lblPassword = new javax.swing.JLabel();
        txtPassword = new javax.swing.JPasswordField();
        btnEntrar = new javax.swing.JButton();
        lblRecovery = new javax.swing.JLabel();
        btnRecovery = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("LOGIN");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(800, 530));
        setMinimumSize(new java.awt.Dimension(800, 530));
        setName("frmLogin"); // NOI18N
        setResizable(false);
        setSize(new java.awt.Dimension(800, 535));

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));
        jPanel1.setMaximumSize(new java.awt.Dimension(800, 530));
        jPanel1.setMinimumSize(new java.awt.Dimension(800, 530));
        jPanel1.setPreferredSize(new java.awt.Dimension(800, 530));
        jPanel1.setLayout(null);

        pnlIzquierda.setBackground(new java.awt.Color(57, 181, 74));
        pnlIzquierda.setMaximumSize(new java.awt.Dimension(400, 500));
        pnlIzquierda.setPreferredSize(new java.awt.Dimension(400, 500));

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
                .addContainerGap(162, Short.MAX_VALUE))
        );

        jPanel1.add(pnlIzquierda);
        pnlIzquierda.setBounds(0, 0, 400, 510);

        pnlDerecha.setBackground(new java.awt.Color(255, 255, 255));
        pnlDerecha.setPreferredSize(new java.awt.Dimension(400, 500));

        lblTitulo.setFont(new java.awt.Font("SansSerif", 1, 36)); // NOI18N
        lblTitulo.setForeground(new java.awt.Color(0, 136, 64));
        lblTitulo.setText("Inicia sesión");

        lblCorreo.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblCorreo.setText("Correo");

        txtCorreo.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        txtCorreo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txtCorreoActionPerformed(evt);
            }
        });

        lblPassword.setFont(new java.awt.Font("SansSerif", 0, 16)); // NOI18N
        lblPassword.setText("Contraseña");

        btnEntrar.setBackground(new java.awt.Color(0, 136, 64));
        btnEntrar.setFont(new java.awt.Font("SansSerif", 0, 12)); // NOI18N
        btnEntrar.setForeground(new java.awt.Color(255, 255, 255));
        btnEntrar.setText("Entrar");
        btnEntrar.setBorder(null);
        btnEntrar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEntrarActionPerformed(evt);
            }
        });

        lblRecovery.setText("Contraseña olvidada?");

        btnRecovery.setBackground(new java.awt.Color(255, 255, 255));
        btnRecovery.setFont(new java.awt.Font("Tahoma", 0, 10)); // NOI18N
        btnRecovery.setForeground(new java.awt.Color(114, 191, 68));
        btnRecovery.setText("Recuperar Contraseña");
        btnRecovery.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRecoveryActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout pnlDerechaLayout = new javax.swing.GroupLayout(pnlDerecha);
        pnlDerecha.setLayout(pnlDerechaLayout);
        pnlDerechaLayout.setHorizontalGroup(
            pnlDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDerechaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDerechaLayout.createSequentialGroup()
                        .addGroup(pnlDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(lblCorreo)
                            .addComponent(lblPassword)
                            .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlDerechaLayout.createSequentialGroup()
                                .addComponent(lblRecovery)
                                .addGap(18, 18, 18)
                                .addComponent(btnRecovery)))
                        .addContainerGap(22, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, pnlDerechaLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(lblTitulo)
                        .addGap(88, 88, 88))
                    .addGroup(pnlDerechaLayout.createSequentialGroup()
                        .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 368, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );
        pnlDerechaLayout.setVerticalGroup(
            pnlDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDerechaLayout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(lblTitulo)
                .addGap(31, 31, 31)
                .addComponent(lblCorreo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txtCorreo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(27, 27, 27)
                .addComponent(lblPassword)
                .addGap(18, 18, 18)
                .addComponent(txtPassword, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(btnEntrar, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 104, Short.MAX_VALUE)
                .addGroup(pnlDerechaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblRecovery)
                    .addComponent(btnRecovery))
                .addContainerGap())
        );

        jPanel1.add(pnlDerecha);
        pnlDerecha.setBounds(400, 0, 400, 500);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void txtCorreoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txtCorreoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txtCorreoActionPerformed

    private void btnEntrarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEntrarActionPerformed
        //Abrir Formulario de Menu Principal
        Principal MenuFrame = new Principal(); 
        MenuFrame.setVisible(true);
        MenuFrame.pack();
        MenuFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnEntrarActionPerformed

    private void btnRecoveryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRecoveryActionPerformed
        //Abrir Formulario de Recuperar Contraseña
        Recuperar RecoveryFrame = new Recuperar(); 
        RecoveryFrame.setVisible(true);
        RecoveryFrame.pack();
        RecoveryFrame.setLocationRelativeTo(null);
        this.dispose();
    }//GEN-LAST:event_btnRecoveryActionPerformed


    public static void main(String args[]) {

        
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEntrar;
    private javax.swing.JButton btnRecovery;
    private javax.swing.JLabel icnMenu;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel lblCorreo;
    private javax.swing.JLabel lblPassword;
    private javax.swing.JLabel lblRecovery;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlDerecha;
    private javax.swing.JPanel pnlIzquierda;
    private javax.swing.JTextField txtCorreo;
    private javax.swing.JPasswordField txtPassword;
    // End of variables declaration//GEN-END:variables
}
