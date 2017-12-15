/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.games.tiles;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Random;
import javafx.application.Platform;
import javafx.concurrent.Task;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.Timer;
/**
 *
 * @author MC170171
 */
public class Tiles extends javax.swing.JFrame {

    protected final int ROUNDS = 1;
    protected final int TILE_PER_ROUND = 20;
    protected final int TILE_WIDTH = 100;
    protected final int TILE_HEIGHT = 100;
    
    protected int speed = 100;
    protected int counter = 0;
    protected int index = 10;
    protected int round = 0;
    protected int roundCounter = 0;
    protected int timeout = 0;
    
    protected boolean freeze = false;
    
    protected JLabel[] tiles = new JLabel[TILE_PER_ROUND*ROUNDS];
    
    protected void formatTile(JLabel label, JPanel panel) {
        label.setSize(TILE_WIDTH, TILE_HEIGHT);
        label.setBackground(Color.black);
        label.setOpaque(true);
        panel.add(label);
        label.setLocation(0, 0);
        label.setVisible(true);
        repaint();
        
    }
    
    protected void updateTileLocation(JLabel tile) {
        tile.setLocation(tile.getX(), tile.getY()+10);
        if (tile.getY()+TILE_HEIGHT >= slide1.getHeight() && tile.getBackground() != Color.green) {
            freeze = true;
            tile.setBackground(Color.red);
        }
        repaint();
    }
    
    protected JPanel getRandomPanel() {
        switch (randomInt(1,4)) {
            case 1:
                return slide1;
            case 2:
                return slide2;
            case 3:
                return slide3;
            case 4:
                return slide4;
        }
        return slide1;
    }
    
    protected void endGame() {
        JOptionPane.showMessageDialog(rootPane, "Well done you did it!");
        this.dispose();
        
    }
    
    protected void newRound() {
        roundCounter = 0;
        setProgressBar(roundCounter);
        round++;
        
        if (round-1 == ROUNDS) {
            endGame();
            
        } else {
            levelCounter.setText("Round: " + round);
            speed = speed - 2;
            timeout = 0;
        }

    }
    
    protected void playGame() {
        if (freeze == false) {
            for (int i = 0; i < counter; i++) {
                updateTileLocation(tiles[i]);
            }

            if (roundCounter != TILE_PER_ROUND) {
                if (index == 10) {
                    formatTile(tiles[counter], getRandomPanel());
                    index = 0;
                    counter++;
                    roundCounter++;
                } else {
                    index++;
                }
            } else {
                timeout++;
                if (timeout == speed/2) {
                    newRound();
                }
            }
        }
    }
    
    protected void setProgressBar(int i) {
        pBar.setValue(i);
    }
    
    protected void formatProgressBar() {
        pBar.setMaximum(TILE_PER_ROUND);
        pBar.setMinimum(0);
    }
    
    protected void startGame() {
        
        for (int i = 0; i < (TILE_PER_ROUND*ROUNDS); i++) {
            tiles[i] = new JLabel();
            mouseEvent(tiles[i]);
        }
    
        Thread threads;

        threads = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    playGame();
                    try {
                        Thread.sleep(speed);
                    } catch (Exception ex) {
                        System.out.println(ex);
                    }
                }
            }
        });
        threads.start();
        
        
    }

    
    
    
    protected int randomInt(int min, int max) {
        return new Random().nextInt((max-min)+1)+min;
    }
    
    protected void hideTile(JLabel tile) {
        tile.setBackground(Color.green);
        setProgressBar(roundCounter);
    }
    
    protected void mouseEvent(JLabel label) {
        label.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (freeze == false) {
                    hideTile(label);
                }
            }
        }); 
    }
    
    public Tiles() {
        initComponents();
        this.setIconImage(new ImageIcon(getClass().getResource("/dev/games/tiles/resources/icons/tiles_icon.png")).getImage());
        startGame();
        formatProgressBar();
        newRound();
        
        
        
        
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        title = new javax.swing.JLabel();
        levelCounter = new javax.swing.JLabel();
        bottomBanner = new javax.swing.JPanel();
        pBar = new javax.swing.JProgressBar();
        slide1 = new javax.swing.JPanel();
        slide2 = new javax.swing.JPanel();
        slide3 = new javax.swing.JPanel();
        slide4 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Tiles");
        setResizable(false);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        jPanel2.setBackground(new java.awt.Color(0, 0, 0));

        title.setFont(new java.awt.Font("Agency FB", 1, 100)); // NOI18N
        title.setForeground(new java.awt.Color(102, 153, 255));
        title.setText("Tiles");

        levelCounter.setFont(new java.awt.Font("Agency FB", 1, 50)); // NOI18N
        levelCounter.setForeground(new java.awt.Color(102, 153, 255));

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addGap(18, 18, 18)
                .addComponent(levelCounter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(levelCounter, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(title, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 89, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        bottomBanner.setBackground(new java.awt.Color(102, 153, 255));
        bottomBanner.setForeground(new java.awt.Color(255, 0, 0));

        pBar.setForeground(new java.awt.Color(0, 0, 0));

        javax.swing.GroupLayout bottomBannerLayout = new javax.swing.GroupLayout(bottomBanner);
        bottomBanner.setLayout(bottomBannerLayout);
        bottomBannerLayout.setHorizontalGroup(
            bottomBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pBar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        bottomBannerLayout.setVerticalGroup(
            bottomBannerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(bottomBannerLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pBar, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
                .addContainerGap())
        );

        slide1.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout slide1Layout = new javax.swing.GroupLayout(slide1);
        slide1.setLayout(slide1Layout);
        slide1Layout.setHorizontalGroup(
            slide1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        slide1Layout.setVerticalGroup(
            slide1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        slide2.setBackground(new java.awt.Color(153, 255, 204));

        javax.swing.GroupLayout slide2Layout = new javax.swing.GroupLayout(slide2);
        slide2.setLayout(slide2Layout);
        slide2Layout.setHorizontalGroup(
            slide2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        slide2Layout.setVerticalGroup(
            slide2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        slide3.setBackground(new java.awt.Color(204, 255, 204));

        javax.swing.GroupLayout slide3Layout = new javax.swing.GroupLayout(slide3);
        slide3.setLayout(slide3Layout);
        slide3Layout.setHorizontalGroup(
            slide3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        slide3Layout.setVerticalGroup(
            slide3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 530, Short.MAX_VALUE)
        );

        slide4.setBackground(new java.awt.Color(153, 255, 204));

        javax.swing.GroupLayout slide4Layout = new javax.swing.GroupLayout(slide4);
        slide4.setLayout(slide4Layout);
        slide4Layout.setHorizontalGroup(
            slide4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 100, Short.MAX_VALUE)
        );
        slide4Layout.setVerticalGroup(
            slide4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(bottomBanner, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addComponent(slide1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slide2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slide3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(slide4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(slide3, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(slide2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(slide1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(slide4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, 0)
                .addComponent(bottomBanner, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

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
            java.util.logging.Logger.getLogger(Tiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Tiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Tiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Tiles.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                
                new Tiles().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel bottomBanner;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JLabel levelCounter;
    private javax.swing.JProgressBar pBar;
    private javax.swing.JPanel slide1;
    private javax.swing.JPanel slide2;
    private javax.swing.JPanel slide3;
    private javax.swing.JPanel slide4;
    private javax.swing.JLabel title;
    // End of variables declaration//GEN-END:variables
}
