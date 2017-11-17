/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dev.games.snake;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.Random;
import javax.swing.JLabel;

/**
 *
 * @author mc170171
 */
public class Snake extends javax.swing.JFrame {

    private final int SPACE = 40;
    private final int BORDER = 400;
    private final int ROWS = 8;
    private final int SQUARES = ROWS*ROWS;
    
    private int DIREC = 1; // 1 = UP, 2 = DOWN, 3 = RIGHT, 4 = LEFT 
    private int INTERVAL = 0;
    private int SCORE = 0;
    private int SPEED = 200;
    private int ITERATION = 0;
    
    private int[] historyX = new int[9999];
    private int[] historyY = new int[9999];
    private int[] histDirec = new int[9999];
    JLabel[] tiles = new JLabel[SQUARES];
    
    Random random = new Random();
    
    private boolean food = false;
    
    JLabel eatme = new JLabel("");
    
    private void moveSnake() {

        if (SCORE != 0) {
            ITERATION++;
        }
        
        historyX[ITERATION] = snake.getX();
        historyY[ITERATION] = snake.getY();
        histDirec[ITERATION] = DIREC;
        
        int oldX = snake.getX();
        int oldY = snake.getY();
        
        if (food == false) {
            INTERVAL++;
        }

        addPosition(snake, DIREC);
        for (int i = 0; i < SCORE; i++) {
            addPosition(tiles[i], histDirec[ITERATION-i]);
        }
        
        if (snake.getX() == eatme.getX() && snake.getY() == eatme.getY()) {
            food = false;
            INTERVAL = 10;
            SPEED = SPEED - 10;
            formatJLabel(tiles[SCORE], oldX, oldY);
            SCORE++;
        } 

        correctPosition(snake);
        for (int i = 0; i < SCORE; i++) {
            correctPosition(tiles[i]);
        }
        
        if (INTERVAL == 10) {

            eatme.setBackground(Color.red);
            eatme.setSize(SPACE, SPACE);
            eatme.setOpaque(true);
            eatme.setVisible(true);
            back.add(eatme);
            eatme.repaint();
            eatme.setLocation(getRCoord(), getRCoord());

            food = true;
            INTERVAL = 0;

        }
    }
    
    private void formatJLabel(JLabel label, int oldX, int oldY) {
        label = new JLabel("");
        label.setSize(SPACE, SPACE);
        label.setOpaque(true);
        label.setBackground(Color.cyan);
        label.setLocation(oldX, oldY);
        back.add(label);
        label.repaint();
    }
    
    private void addPosition(JLabel label, int direction) {
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
        
    }
    
    private void correctPosition(JLabel label) {
        try {
            
          /*  if (!" ".equals(label.getText())) {
                label = new JLabel("");
            }*/

            if (label.getY() >= BORDER) {
                label.setLocation(snake.getX(), 0);

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
                    moveSnake();
                    
                    try {
                        Thread.sleep(SPEED);
                        
                    } catch (Exception ex) {
                    
                    }
                }
            }
        });

        threads.start();
    }
    
    
    private int getRCoord() {
        return random.nextInt(8)*SPACE;
    }
    
    public Snake() {
        initComponents();
        startGame();
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
        snake = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        back.setBackground(new java.awt.Color(0, 0, 0));

        snake.setBackground(new java.awt.Color(102, 255, 51));
        snake.setFont(new java.awt.Font("Agency FB", 1, 18)); // NOI18N
        snake.setText(" ");
        snake.setMaximumSize(new java.awt.Dimension(40, 40));
        snake.setMinimumSize(new java.awt.Dimension(40, 40));
        snake.setOpaque(true);

        javax.swing.GroupLayout backLayout = new javax.swing.GroupLayout(back);
        back.setLayout(backLayout);
        backLayout.setHorizontalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backLayout.createSequentialGroup()
                .addComponent(snake, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 360, Short.MAX_VALUE))
        );
        backLayout.setVerticalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(backLayout.createSequentialGroup()
                .addComponent(snake, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 360, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(back, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void formKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_formKeyPressed
        int keyCode = evt.getKeyCode();
        switch( keyCode ) { 
            case KeyEvent.VK_UP:
                DIREC = 1;
                break;
            case KeyEvent.VK_DOWN:
                DIREC = 2;
                break;
            case KeyEvent.VK_RIGHT:
                DIREC = 3;
                break;
            case KeyEvent.VK_LEFT:
                DIREC = 4;
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
            java.util.logging.Logger.getLogger(Snake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Snake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Snake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Snake.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Snake().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel back;
    private javax.swing.JLabel snake;
    // End of variables declaration//GEN-END:variables
}
