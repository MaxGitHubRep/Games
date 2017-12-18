package dev.games.snake;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;

public class Snake extends javax.swing.JFrame {

    protected final int SNAKE_SIZE = 20;
    protected final int BOARD_SIZE = 400;
    protected final int BOARD_SQUARES = BOARD_SIZE/SNAKE_SIZE;
    protected final int DEFAULT_INTERVAL = 25;
    protected final int DEFAULT_LENGTH = 3;
    protected final int DEFAULT_SPEED = 200;
    
    protected int direction = 3;
    protected int speed = DEFAULT_SPEED;
    protected int index = DEFAULT_LENGTH;
    protected int interval = 0;
    
    protected JLabel food = new JLabel();
    
    protected JLabel[] snake = new JLabel[BOARD_SQUARES*BOARD_SQUARES];
    
    protected void playGame() {
        for (int i = index; i > 0; i--) {
            snake[i].setLocation(snake[i-1].getX(), snake[i-1].getY());
        }
        addPosition(snake[0]);
        correctPosition(snake[0]);
        checkCrossOver();

        if (snake[0].getX() == food.getX() && snake[0].getY() == food.getY()) {
            interval = DEFAULT_INTERVAL;
            formatLabel(snake[index]);
            index++;
            speed = speed - 1;
        }
        
        if (interval == DEFAULT_INTERVAL) {
            formatFood();
            interval = 0;
        } else {
            interval++;
        }
    }

    protected void checkCrossOver() {
        for (int i = 1; i < index; i++) {
            if (snake[0].getX() == snake[i].getX() && snake[0].getY() == snake[i].getY()) {
                for (int k = DEFAULT_LENGTH; k < index; k++) {
                    snake[k].setVisible(false);
                }
                index = DEFAULT_LENGTH;
                speed = DEFAULT_SPEED;
            }
        }
    }
    
    protected void startGame() {
        for (int i = 0; i < (BOARD_SQUARES*BOARD_SQUARES); i++) {
            snake[i] = new JLabel();
        }
        
        for (int i = 0; i < DEFAULT_LENGTH; i++) {
            formatLabel(snake[i]);
            snake[i].setLocation((DEFAULT_LENGTH-1-i)*SNAKE_SIZE, 0);
        }
        
        Thread threads = new Thread();
        threads = new Thread(new Runnable() {
            public void run() {
                while (true) {
                    playGame();
                    try {
                        Thread.sleep(speed);
                        
                    } catch (Exception ex) {
                        ex.printStackTrace();
                    }
                }
            }
        });

        threads.start();
    }
    
    protected void formatLabel(JLabel label) {
        label.setSize(SNAKE_SIZE, SNAKE_SIZE);
        label.setBackground(Color.green);
        label.setOpaque(true);
        label.setVisible(true);
        back.add(label);
    }  
    
    protected void formatFood() {
        food.setBackground(Color.cyan);
        food.setSize(SNAKE_SIZE, SNAKE_SIZE);
        food.setOpaque(true);
        food.setVisible(true);
        //String direc = "/dev/games/bugs/resources/foodmodels/food.fw.png";
        //food.setIcon(new javax.swing.ImageIcon(getClass().getResource(direc)));
        back.add(food);
        //food.setLocation(getRCoord(), getRCoord());
        setRandomLoc();

    }
    
    protected void setRandomLoc() {
        ArrayList<String> squares = new ArrayList<>();
        for (int i = 0; i < BOARD_SQUARES; i++) {
            for (int k = 0; k < BOARD_SQUARES; k++) {
                squares.add((i*SNAKE_SIZE) + ":" + (k*SNAKE_SIZE));
            }
        }
        
        for (int i = 0; i < index; i++) {
            String coords = snake[i].getX() + ":" + snake[i].getY();
            if (squares.contains(coords)) {
                squares.remove(coords);
            }
        }
        String[] toParse = squares.get(randomInt(1, squares.size()-1)).split(":");
        
        food.setLocation(Integer.parseInt(toParse[0]), Integer.parseInt(toParse[1]));
    }
    
    protected int randomInt(int min, int max) {
        return new Random().nextInt((max-min)+1)+min;
    }
    
    protected int getRCoord() {
        return randomInt(0, (BOARD_SIZE/SNAKE_SIZE))*SNAKE_SIZE;
    }
    
    protected void correctPosition(JLabel label) {
        try {
            if (label.getY() >= BOARD_SIZE) {
                label.setLocation(label.getX(), 0);

            } else if (label.getY() < 0) {
                label.setLocation(label.getX(), BOARD_SIZE);
            }

            if (label.getX() >= BOARD_SIZE) {
                label.setLocation(0, label.getY());

            } else if (label.getX() < 0) {
                label.setLocation(BOARD_SIZE, label.getY());
            }
            
        } catch (Exception ex) {
            
        }
        
    }
    
    protected void addPosition(JLabel label) {
        try {
            switch (direction) {
                case 1:
                    label.setLocation(label.getX(), label.getY()-SNAKE_SIZE);
                    break;
                case 2:
                    label.setLocation(label.getX(), label.getY()+SNAKE_SIZE);
                    break;
                case 3:
                    label.setLocation(label.getX()+SNAKE_SIZE, label.getY());
                    break;
                case 4:
                    label.setLocation(label.getX()-SNAKE_SIZE, label.getY());
                    break;
            }
            
        } catch (Exception ex) {
            
        }
    }
    
    public Snake() {
        initComponents();
        startGame();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        back = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Snake");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        back.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout backLayout = new javax.swing.GroupLayout(back);
        back.setLayout(backLayout);
        backLayout.setHorizontalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        backLayout.setVerticalGroup(
            backLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
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
        switch(evt.getKeyCode()) { 
            case KeyEvent.VK_UP:
            case KeyEvent.VK_W:
                direction = 1;
                break;
            case KeyEvent.VK_DOWN:
            case KeyEvent.VK_S:
                direction = 2;
                break;
            case KeyEvent.VK_RIGHT:
            case KeyEvent.VK_D:
                direction = 3;
                break;
            case KeyEvent.VK_LEFT:
            case KeyEvent.VK_A:
                direction = 4;
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
    // End of variables declaration//GEN-END:variables
}
