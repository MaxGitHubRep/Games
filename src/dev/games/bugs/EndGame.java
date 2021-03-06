package dev.games.bugs;

/**
 *
 * @author mc170171
 */
public class EndGame extends javax.swing.JFrame {

    public EndGame(String output) {
        initComponents();
        scoreOutput.setText(output);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        close = new javax.swing.JLabel();
        scoreOutput = new javax.swing.JLabel();
        goToMenu = new javax.swing.JButton();
        goToMenu1 = new javax.swing.JButton();
        bugs = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        back.setBackground(new java.awt.Color(102, 102, 102));
        back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        title.setFont(new java.awt.Font("Agency FB", 1, 100)); // NOI18N
        title.setForeground(new java.awt.Color(51, 204, 0));
        title.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/games/bugs/resources/textmodels/title.png"))); // NOI18N

        close.setFont(new java.awt.Font("Agency FB", 1, 30)); // NOI18N
        close.setForeground(new java.awt.Color(0, 255, 0));
        close.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/games/bugs/resources/textmodels/close.png"))); // NOI18N
        close.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                closeMouseClicked(evt);
            }
        });

        scoreOutput.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        scoreOutput.setForeground(new java.awt.Color(0, 153, 51));
        scoreOutput.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        scoreOutput.setText("Final Score: 0 - 0");

        goToMenu.setBackground(new java.awt.Color(51, 153, 0));
        goToMenu.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        goToMenu.setForeground(new java.awt.Color(51, 102, 0));
        goToMenu.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/games/bugs/resources/bugmodels/three/1.png"))); // NOI18N
        goToMenu.setText("Main Menu");
        goToMenu.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                goToMenuActionPerformed(evt);
            }
        });

        goToMenu1.setBackground(new java.awt.Color(51, 153, 0));
        goToMenu1.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        goToMenu1.setForeground(new java.awt.Color(51, 102, 0));
        goToMenu1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/games/bugs/resources/bugmodels/two/1.png"))); // NOI18N
        goToMenu1.setText("Previous Scores");

        bugs.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/games/bugs/resources/background/bugs.png"))); // NOI18N

        javax.swing.GroupLayout backLayout = new javax.swing.GroupLayout(back);
        back.setLayout(backLayout);
        backLayout.setHorizontalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(close)
                    .addGroup(backLayout.createSequentialGroup()
                        .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(goToMenu1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(goToMenu, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(title, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(bugs, javax.swing.GroupLayout.PREFERRED_SIZE, 426, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(scoreOutput, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(33, Short.MAX_VALUE))
        );
        backLayout.setVerticalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backLayout.createSequentialGroup()
                .addGap(30, 30, 30)
                .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, backLayout.createSequentialGroup()
                        .addComponent(bugs, javax.swing.GroupLayout.PREFERRED_SIZE, 95, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(scoreOutput, javax.swing.GroupLayout.PREFERRED_SIZE, 82, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(title))
                .addGap(26, 26, 26)
                .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(backLayout.createSequentialGroup()
                        .addComponent(goToMenu, javax.swing.GroupLayout.PREFERRED_SIZE, 67, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(goToMenu1))
                    .addComponent(close))
                .addContainerGap(30, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void closeMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_closeMouseClicked
        this.dispose();
        System.exit(0);
    }//GEN-LAST:event_closeMouseClicked

    private void goToMenuActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_goToMenuActionPerformed
        this.dispose();
        new Menu().setVisible(true);
    }//GEN-LAST:event_goToMenuActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(EndGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(EndGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(EndGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(EndGame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new EndGame("").setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back;
    private javax.swing.JLabel bugs;
    private javax.swing.JLabel close;
    private javax.swing.JButton goToMenu;
    private javax.swing.JButton goToMenu1;
    private javax.swing.JLabel scoreOutput;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
