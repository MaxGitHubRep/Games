/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.games.bugs;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author mc170171
 */
public class Singleplayer extends javax.swing.JFrame {

    protected final int BORDER = 400, SPACE = 40, MAX_SCORE = 10, SPEED = 200;
    
    protected final String bugModelOne = "one", bugModelTwo = "two";
    
    protected int SCORE_ONE, SCORE_TWO, DIREC_ONE = 1, DIREC_TWO = 1, INTERVAL = 0;
    
    protected boolean eatMe = false, needBugFormat = true, stopFlow = false;
    
    protected JLabel eatMeOne = new JLabel("");
    protected JLabel eatMeTwo = new JLabel("");
    
    protected Methods m = new Methods();
    
    private void playGame() {
        m.formatProgressBar(pBarOne, SCORE_ONE);
        m.formatProgressBar(pBarTwo, SCORE_TWO);
        
        if (needBugFormat == true) {
            needBugFormat = false;
            m.formatImageIcon(bugModelOne, bOne);
            m.formatImageIcon(bugModelTwo, bTwo);
 
        }
        
        int distX, distY;

        if (bTwo.getX() > eatMeTwo.getX()) {
            distX = bTwo.getX() - eatMeTwo.getX();
        } else {
            distX = eatMeTwo.getX() - bTwo.getX();
        }
        
        if (bTwo.getY() > eatMeTwo.getY()) {
            distY = bTwo.getY() - eatMeTwo.getY();
        } else {
            distY = eatMeTwo.getY() - bTwo.getY();
        }
        
        if (distX > distY) {
            if (eatMeTwo.getX() > bTwo.getX()) {
                DIREC_TWO = 3;
                
            } else {
                DIREC_TWO = 4;
            }
            
            
        } else {
            if (eatMeTwo.getY() > bTwo.getY()) {
                DIREC_TWO = 1;
                
            } else {
                DIREC_TWO = 1;
            }

        }
        
        if (INTERVAL == 5) {
            if (eatMe == false) {
                eatMe = true;
                m.formatFood(eatMeOne, one);
                m.formatFood(eatMeTwo, two);
                
            } 
            
        } else {
            INTERVAL++;
        }
        
        m.addPosition(bOne, DIREC_ONE, bugModelOne);
        m.addPosition(bTwo, DIREC_TWO, bugModelTwo);
        m.correctPosition(bOne);
        m.correctPosition(bTwo);
        
        if (bOne.getX() == eatMeOne.getX() && bOne.getY() == eatMeOne.getY()) {
            foodEaten(1);
            
        } else if (bTwo.getX() == eatMeTwo.getX() && bTwo.getY() == eatMeTwo.getY()) {
            foodEaten(2);
            
        }
        
    }

    private void foodEaten(int player) {
        switch (player) {
            case 1:
                SCORE_ONE++;
                break;
            case 2:
                SCORE_TWO++;
                break;
        }

        if (stopFlow == false) {
            if (SCORE_ONE == MAX_SCORE || SCORE_TWO == MAX_SCORE) {
                stopFlow = true;
                this.dispose();
                new EndGame("Final Score: " +SCORE_ONE + " - " + SCORE_TWO).setVisible(eatMe);
            }

            INTERVAL = 0;
            m.spawnFood(eatMeOne);
            m.spawnFood(eatMeTwo);
        }
        
        
        
    }
    
    private void startGame() {
        Thread threads = new Thread();
        threads = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    playGame();
                    try {
                        Thread.sleep(SPEED);
                        
                    } catch (Exception ex) {
                    
                    }
                }
            }
        });

        threads.start();
    }
    
    public Singleplayer(boolean race) {
        initComponents();
        startGame();
        this.setIconImage(new ImageIcon(getClass().getResource("/dev/games/bugs/resources/bugmodels/three/1.png")).getImage());
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JPanel();
        banner = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        two = new javax.swing.JPanel();
        bTwo = new javax.swing.JLabel();
        one = new javax.swing.JPanel();
        bOne = new javax.swing.JLabel();
        pBarOne = new javax.swing.JProgressBar();
        pBarTwo = new javax.swing.JProgressBar();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bugs • Singleplayer");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        back.setBackground(new java.awt.Color(102, 102, 102));
        back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        banner.setBackground(new java.awt.Color(153, 153, 153));

        title.setFont(new java.awt.Font("Agency FB", 1, 62)); // NOI18N
        title.setForeground(new java.awt.Color(51, 204, 0));
        title.setText("Bugs • Singleplayer");

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/games/bugs/resources/background/bugs.png"))); // NOI18N

        javax.swing.GroupLayout bannerLayout = new javax.swing.GroupLayout(banner);
        banner.setLayout(bannerLayout);
        bannerLayout.setHorizontalGroup(
            bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bannerLayout.createSequentialGroup()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 425, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );
        bannerLayout.setVerticalGroup(
            bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        two.setBackground(new java.awt.Color(0, 204, 204));
        two.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                twoKeyPressed(evt);
            }
        });

        bTwo.setBackground(new java.awt.Color(0, 204, 204));
        bTwo.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        bTwo.setText(" ");
        bTwo.setMaximumSize(new java.awt.Dimension(40, 40));
        bTwo.setMinimumSize(new java.awt.Dimension(40, 40));
        bTwo.setOpaque(true);

        javax.swing.GroupLayout twoLayout = new javax.swing.GroupLayout(two);
        two.setLayout(twoLayout);
        twoLayout.setHorizontalGroup(
            twoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(twoLayout.createSequentialGroup()
                .addComponent(bTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        twoLayout.setVerticalGroup(
            twoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(twoLayout.createSequentialGroup()
                .addComponent(bTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 360, Short.MAX_VALUE))
        );

        one.setBackground(new java.awt.Color(0, 204, 204));

        bOne.setBackground(new java.awt.Color(0, 204, 204));
        bOne.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        bOne.setText(" ");
        bOne.setMaximumSize(new java.awt.Dimension(40, 40));
        bOne.setMinimumSize(new java.awt.Dimension(40, 40));
        bOne.setOpaque(true);

        javax.swing.GroupLayout oneLayout = new javax.swing.GroupLayout(one);
        one.setLayout(oneLayout);
        oneLayout.setHorizontalGroup(
            oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oneLayout.createSequentialGroup()
                .addComponent(bOne, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        oneLayout.setVerticalGroup(
            oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oneLayout.createSequentialGroup()
                .addComponent(bOne, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 360, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout backLayout = new javax.swing.GroupLayout(back);
        back.setLayout(backLayout);
        backLayout.setHorizontalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(pBarOne, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE)
                    .addComponent(one, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(two, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pBarTwo, javax.swing.GroupLayout.DEFAULT_SIZE, 400, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addComponent(banner, javax.swing.GroupLayout.PREFERRED_SIZE, 836, Short.MAX_VALUE)
        );
        backLayout.setVerticalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backLayout.createSequentialGroup()
                .addComponent(banner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pBarOne, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pBarTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 25, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void twoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_twoKeyPressed
        
    }//GEN-LAST:event_twoKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        switch(evt.getKeyCode()) { 
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                DIREC_ONE = 1;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                DIREC_ONE = 2;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                DIREC_ONE = 3;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                DIREC_ONE = 4;
                break;
        }
    }//GEN-LAST:event_formKeyPressed

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
            java.util.logging.Logger.getLogger(Singleplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Singleplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Singleplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Singleplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Singleplayer(true).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bOne;
    private javax.swing.JLabel bTwo;
    private javax.swing.JPanel back;
    private javax.swing.JPanel banner;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel one;
    private javax.swing.JProgressBar pBarOne;
    private javax.swing.JProgressBar pBarTwo;
    private javax.swing.JLabel title;
    private javax.swing.JPanel two;
    // End of variables declaration//GEN-END:variables
}
