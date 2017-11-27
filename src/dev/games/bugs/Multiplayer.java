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

/**
 *
 * @author mc170171
 */
public class Multiplayer extends javax.swing.JFrame {

    private final int BORDER = 400;
    private final int SPACE = 40;
    private final int MAX_SCORE = 21;
    private final int SPEED = 200;
    
    private final String bugModelOne = "one";
    private final String bugModelTwo = "two";
    
    private int DIREC_ONE = 1; // 1 = UP, 2 = DOWN, 3 = RIGHT, 4 = LEFT 
    private int DIREC_TWO = 1; // 1 = UP, 2 = DOWN, 3 = RIGHT, 4 = LEFT 
    private int SCORE_ONE = 0;
    private int SCORE_TWO = 0;
    private int INTERVAL = 0;
    private int PASSED = 0;
    
    private boolean eatMe = false;
    private boolean needBugFormat = true;
    
    JLabel eatMeOne = new JLabel("");
    JLabel eatMeTwo = new JLabel("");
    
    private void playGame() {
        //scoreLabel.setText("Score: " + SCORE_ONE + " - " + SCORE_TWO + "  (Out of " + MAX_SCORE + ")");
        
        if (INTERVAL == 5) {
            if (eatMe == false) {
                eatMe = true;
                formatFood(eatMeOne, one);
                formatFood(eatMeTwo, two);
            } 
            
        } else {
            INTERVAL++;
        }
        
        if (needBugFormat == true) {
            String direc;
            needBugFormat = false;
            
            direc = "/dev/games/bugs/resources/bugmodels/" + bugModelOne + "/1.png";
            bOne.setIcon(new javax.swing.ImageIcon(getClass().getResource(direc)));
            direc = "/dev/games/bugs/resources/bugmodels/" + bugModelTwo + "/1.png";
            bTwo.setIcon(new javax.swing.ImageIcon(getClass().getResource(direc)));
 
        }
        
        addPosition(bOne, DIREC_ONE, bugModelOne);
        addPosition(bTwo, DIREC_TWO, bugModelTwo);
        correctPosition(bOne);
        correctPosition(bTwo);

        if (bOne.getX() == eatMeOne.getX() && bOne.getY() == eatMeOne.getY()) {
            foodEaten(1);
            
        } else if (bTwo.getX() == eatMeTwo.getX() && bTwo.getY() == eatMeTwo.getY()) {
            foodEaten(2);
            
        }
    }
    
    private void formatFood(JLabel label, JPanel add) {
        label.setBackground(Color.cyan);
        label.setSize(SPACE, SPACE);
        label.setVisible(true);
        String direc = "/dev/games/bugs/resources/foodmodels/food.fw.png";
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource(direc)));
        add.add(label);
        label.setLocation(getRCoord(), getRCoord());
        
        
    }
    
    private void spawnFood() {
        eatMeOne.setLocation(getRCoord(), getRCoord());
        eatMeTwo.setLocation(getRCoord(), getRCoord());

    }
    
    private void foodEaten(int player) {
        PASSED++;
        switch ( player ) {
            case 1:
                SCORE_ONE++;
                break;
            case 2:
                SCORE_TWO++;
                break;
        }
        
        if (PASSED == MAX_SCORE) {
            this.dispose();
            new Menu().setVisible(true);
            System.out.println("Player 1 got: " + SCORE_ONE);
            System.out.println("Player 2 got: " + SCORE_TWO);
        }
        
        INTERVAL = 0;
        spawnFood();
        
    }
    
    public int randomInt(int min, int max) {
        return new Random().nextInt((max-min)+1)+min;
    }
    
    private int getRCoord() {
        return randomInt(1, 8)*SPACE;
    }
    
    private void addPosition(JLabel label, int direction, String type) {
        try {
            switch (direction) {
                case 1:
                    label.setLocation(label.getX(), label.getY()-SPACE);
                    break;
                case 2:
                    label.setLocation(label.getX(), label.getY()+SPACE);
                    break;
                case 3:
                    label.setLocation(label.getX()+SPACE, label.getY());
                    break;
                case 4:
                    label.setLocation(label.getX()-SPACE, label.getY());
                    break;
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
        }
        
        String direc = "/dev/games/bugs/resources/bugmodels/" + type + "/" + direction + ".png";
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource(direc)));
        
    }
    
    private void correctPosition(JLabel label) {
        try {
            if (label.getY() >= BORDER) {
                label.setLocation(label.getX(), 0);

            } else if (label.getY() < 0) {
                label.setLocation(label.getX(), BORDER);
            }

            if (label.getX() >= BORDER) {
                label.setLocation(0, label.getY());

            } else if (label.getX() < 0) {
                label.setLocation(BORDER, label.getY());
            }
            
        } catch (Exception ex) {
            System.out.println(ex);
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
    
    public Multiplayer() {
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
        two = new javax.swing.JPanel();
        bTwo = new javax.swing.JLabel();
        one = new javax.swing.JPanel();
        bOne = new javax.swing.JLabel();
        scoreLabel = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Bugs - Multiplyer");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        back.setBackground(new java.awt.Color(255, 255, 255));
        back.setBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0), 2));

        banner.setBackground(new java.awt.Color(153, 153, 153));

        title.setFont(new java.awt.Font("Agency FB", 1, 62)); // NOI18N
        title.setForeground(new java.awt.Color(51, 204, 0));
        title.setText("Bugs - Multiplayer");

        javax.swing.GroupLayout bannerLayout = new javax.swing.GroupLayout(banner);
        banner.setLayout(bannerLayout);
        bannerLayout.setHorizontalGroup(
            bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bannerLayout.createSequentialGroup()
                .addComponent(title)
                .addContainerGap(457, Short.MAX_VALUE))
        );
        bannerLayout.setVerticalGroup(
            bannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(title)
        );

        two.setBackground(new java.awt.Color(0, 204, 204));
        two.setMinimumSize(new java.awt.Dimension(400, 400));
        two.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                twoKeyPressed(evt);
            }
        });

        bTwo.setBackground(new java.awt.Color(0, 204, 204));
        bTwo.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        bTwo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/games/bugs/resources/bugmodels/two/1.png"))); // NOI18N
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
                .addGap(0, 360, Short.MAX_VALUE))
        );
        twoLayout.setVerticalGroup(
            twoLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(twoLayout.createSequentialGroup()
                .addComponent(bTwo, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 360, Short.MAX_VALUE))
        );

        one.setBackground(new java.awt.Color(0, 204, 204));
        one.setMinimumSize(new java.awt.Dimension(400, 400));
        one.setName(""); // NOI18N

        bOne.setBackground(new java.awt.Color(0, 204, 204));
        bOne.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        bOne.setIcon(new javax.swing.ImageIcon(getClass().getResource("/dev/games/bugs/resources/bugmodels/one/1.png"))); // NOI18N
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
                .addGap(0, 360, Short.MAX_VALUE))
        );
        oneLayout.setVerticalGroup(
            oneLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(oneLayout.createSequentialGroup()
                .addComponent(bOne, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 360, Short.MAX_VALUE))
        );

        scoreLabel.setFont(new java.awt.Font("Agency FB", 1, 48)); // NOI18N
        scoreLabel.setForeground(new java.awt.Color(0, 204, 51));
        scoreLabel.setHorizontalAlignment(javax.swing.SwingConstants.LEFT);
        scoreLabel.setText("Score: 0 - 0 ");

        javax.swing.GroupLayout backLayout = new javax.swing.GroupLayout(back);
        back.setLayout(backLayout);
        backLayout.setHorizontalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(banner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(backLayout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(12, 12, 12)
                .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(backLayout.createSequentialGroup()
                    .addGap(20, 20, 20)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 214, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap(602, Short.MAX_VALUE)))
        );
        backLayout.setVerticalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backLayout.createSequentialGroup()
                .addComponent(banner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(7, 7, 7)
                .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(one, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(two, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(80, Short.MAX_VALUE))
            .addGroup(backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, backLayout.createSequentialGroup()
                    .addContainerGap(498, Short.MAX_VALUE)
                    .addComponent(scoreLabel, javax.swing.GroupLayout.PREFERRED_SIZE, 52, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGap(12, 12, 12)))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(back, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void twoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_twoKeyPressed
        
    }//GEN-LAST:event_twoKeyPressed

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        int keyCode = evt.getKeyCode();
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                DIREC_TWO = 1;
                break;
            case KeyEvent.VK_DOWN:
                DIREC_TWO = 2;
                break;
            case KeyEvent.VK_RIGHT:
                DIREC_TWO = 3;
                break;
            case KeyEvent.VK_LEFT:
                DIREC_TWO = 4;
                break;
                
            case KeyEvent.VK_W:
                DIREC_ONE = 1;
                break;
            case KeyEvent.VK_S:
                DIREC_ONE = 2;
                break;
            case KeyEvent.VK_D:
                DIREC_ONE = 3;
                break;
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
            java.util.logging.Logger.getLogger(Multiplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Multiplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Multiplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Multiplayer.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Multiplayer().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel bOne;
    private javax.swing.JLabel bTwo;
    private javax.swing.JPanel back;
    private javax.swing.JPanel banner;
    private javax.swing.JPanel one;
    private javax.swing.JLabel scoreLabel;
    private javax.swing.JLabel title;
    private javax.swing.JPanel two;
    // End of variables declaration//GEN-END:variables
}
