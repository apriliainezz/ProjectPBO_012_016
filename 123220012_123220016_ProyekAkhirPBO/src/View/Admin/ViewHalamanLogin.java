package View.Admin;

import Controller.ControllerLogin;
import Model.Admin.ModelAdmin;
import View.User.ViewHalamanUtama;

public class ViewHalamanLogin extends javax.swing.JFrame {

    public ViewHalamanLogin() {
        initComponents();
        setLocationRelativeTo(null);
        setVisible(true);
    }
    ModelAdmin model = new ModelAdmin();
    ControllerLogin controller = new ControllerLogin(model,this);
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        inputUsername = new javax.swing.JTextField();
        inputPassword = new javax.swing.JPasswordField();
        tombolLogin = new javax.swing.JButton();
        tombolKembali = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(445, 315));
        setSize(new java.awt.Dimension(431, 297));
        getContentPane().setLayout(null);

        jLabel1.setFont(new java.awt.Font("Times New Roman", 1, 24)); // NOI18N
        jLabel1.setText("Login Admin");
        getContentPane().add(jLabel1);
        jLabel1.setBounds(140, 20, 170, 29);

        jLabel2.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel2.setText("Username");
        getContentPane().add(jLabel2);
        jLabel2.setBounds(30, 80, 90, 21);

        jLabel3.setFont(new java.awt.Font("Times New Roman", 1, 18)); // NOI18N
        jLabel3.setText("Password");
        getContentPane().add(jLabel3);
        jLabel3.setBounds(30, 140, 80, 16);
        getContentPane().add(inputUsername);
        inputUsername.setBounds(140, 80, 260, 30);
        getContentPane().add(inputPassword);
        inputPassword.setBounds(140, 140, 260, 30);

        tombolLogin.setFont(new java.awt.Font("Times New Roman", 1, 14)); // NOI18N
        tombolLogin.setText("Login");
        tombolLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolLoginActionPerformed(evt);
            }
        });
        getContentPane().add(tombolLogin);
        tombolLogin.setBounds(160, 220, 110, 40);

        tombolKembali.setFont(new java.awt.Font("Times New Roman", 1, 12)); // NOI18N
        tombolKembali.setText("Kembali");
        tombolKembali.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                tombolKembaliActionPerformed(evt);
            }
        });
        getContentPane().add(tombolKembali);
        tombolKembali.setBounds(10, 10, 100, 22);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void tombolLoginActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolLoginActionPerformed
        tombolLoginAction(inputUsername.getText(),inputPassword.getText());
    }//GEN-LAST:event_tombolLoginActionPerformed

    private void tombolKembaliActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tombolKembaliActionPerformed
        tombolKembaliAction();
    }//GEN-LAST:event_tombolKembaliActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPasswordField inputPassword;
    private javax.swing.JTextField inputUsername;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JButton tombolKembali;
    private javax.swing.JButton tombolLogin;
    // End of variables declaration//GEN-END:variables

    private void tombolLoginAction(String usn, String pw) {
        controller.login(usn,pw);
    }

    private void tombolKembaliAction() {
        new ViewHalamanUtama().setVisible(true);
        this.dispose();
    }
    
}

