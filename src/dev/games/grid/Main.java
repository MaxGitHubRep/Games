package dev.games.grid;

import java.awt.Color;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.Random;
import javax.swing.JLabel;

public class Main extends javax.swing.JFrame {

    protected int score = 0;
    protected int count = 0;
    protected int direction = 1; // 1 = up, 2 = down, 3 = right, 4 = left.
    
    protected boolean play = true;
    
    protected JLabel[] tiles = new JLabel[999];
    
    protected void updateGame() {
        
        for (int i = 0; i < count; i++) {
            switch (direction) {
                case 1:
                    tiles[i].setLocation(tiles[i].getX(), tiles[i].getY()-100);
                    break;
                case 2:
                    tiles[i].setLocation(tiles[i].getX(), tiles[i].getY()+100);
                    break;
                case 3:
                    tiles[i].setLocation(tiles[i].getX()+100, tiles[i].getY());
                    break;
                case 4:
                    tiles[i].setLocation(tiles[i].getX()-100, tiles[i].getY());
                    break;
            }
        }
        
        count++;
        createNewTile();
    }
    
    protected void reviseLocation(JLabel label, int X, int Y) {
        
    }
    
    protected void startGame() {
        createNewTile();
        scoreDisplay.setText("Score: 0");
    }
    
    protected void setLoc(JLabel label, String data) {
        String[] coords = data.split(", ");
        
        label.setLocation(Integer.parseInt(coords[0]), Integer.parseInt(coords[1]));
    }
    
    protected void setRCoord(JLabel label) {
        ArrayList squares = new ArrayList<>();
        for (int one = 0; one < 4; one++) {
            for (int two = 0; two < 4; two++) {
                squares.add((one*100) + ", " + (two*100));
            } 
        }   
        ArrayList there = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            there.add(tiles[i].getX() + ", " + tiles[i].getY());
        }
        
        try {

            for (Object item : squares) {
                for (Object in : there) {
                    if (!item.equals(in)) {
                        setLoc(label, ""+item);
                        break;
                    }
                }
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        
    }
    
    protected int randomInt(int min, int max) {
        return new Random().nextInt((max-min)+1)+min;
    }
    
    protected void createNewTile() {
        tiles[count] = new JLabel();
        JLabel label = tiles[count];
        label.setSize(100, 100);
        label.setOpaque(true);
        label.setBackground(Color.red);
        label.setText("2");
        container.add(label);
        setRCoord(label);
        label.setVisible(true);
        repaint();
    }
    
    protected void updateScore() {
        scoreDisplay.setText("Score: " + score);
    }
    
    public Main() {
        initComponents();
        startGame();
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        container = new javax.swing.JPanel();
        titlePanel = new javax.swing.JPanel();
        scoreDisplay = new javax.swing.JLabel();
        title = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("2048");
        setResizable(false);
        addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                formKeyPressed(evt);
            }
        });

        container.setBackground(new java.awt.Color(255, 255, 255));
        container.setMaximumSize(new java.awt.Dimension(400, 400));
        container.setMinimumSize(new java.awt.Dimension(400, 400));

        javax.swing.GroupLayout containerLayout = new javax.swing.GroupLayout(container);
        container.setLayout(containerLayout);
        containerLayout.setHorizontalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        containerLayout.setVerticalGroup(
            containerLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );

        titlePanel.setBackground(new java.awt.Color(0, 0, 0));

        scoreDisplay.setFont(new java.awt.Font("Lithos Pro Regular", 1, 24)); // NOI18N
        scoreDisplay.setForeground(new java.awt.Color(255, 255, 255));
        scoreDisplay.setText("Score:");
        scoreDisplay.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        title.setFont(new java.awt.Font("Lithos Pro Regular", 1, 48)); // NOI18N
        title.setForeground(new java.awt.Color(255, 255, 255));
        title.setText("2048");
        title.setBorder(new javax.swing.border.LineBorder(new java.awt.Color(255, 255, 255), 2, true));

        javax.swing.GroupLayout titlePanelLayout = new javax.swing.GroupLayout(titlePanel);
        titlePanel.setLayout(titlePanelLayout);
        titlePanelLayout.setHorizontalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(title)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(scoreDisplay, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        titlePanelLayout.setVerticalGroup(
            titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, titlePanelLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(titlePanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(title, javax.swing.GroupLayout.DEFAULT_SIZE, 78, Short.MAX_VALUE)
                    .addGroup(titlePanelLayout.createSequentialGroup()
                        .addGap(0, 0, Short.MAX_VALUE)
                        .addComponent(scoreDisplay, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(container, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(titlePanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(titlePanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, 0)
                .addComponent(container, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
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
        updateGame();
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
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(Main.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Main().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel container;
    private javax.swing.JLabel scoreDisplay;
    private javax.swing.JLabel title;
    private javax.swing.JPanel titlePanel;
    // End of variables declaration//GEN-END:variables
}
