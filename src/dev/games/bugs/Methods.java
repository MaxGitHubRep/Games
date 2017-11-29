package dev.games.bugs;

import java.awt.Color;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.util.Random;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JProgressBar;

/**
 *
 * @author Max
 */
public class Methods {
    
    private final int BORDER = 400;
    private final int SPACE = 40;
    private final int MAX_SCORE = 10;

    protected int SCORE_ONE;
    protected int SCORE_TWO;
    
    private int DIREC_ONE = 1; // 1 = UP, 2 = DOWN, 3 = RIGHT, 4 = LEFT 
    private int DIREC_TWO = 1; // 1 = UP, 2 = DOWN, 3 = RIGHT, 4 = LEFT 
    private int INTERVAL = 0;
    
    private boolean eatMe = false;
    private boolean needBugFormat = true;
    
    JLabel eatMeOne = new JLabel("");
    JLabel eatMeTwo = new JLabel("");
    
    protected void formatProgressBar(JProgressBar bar, int score) {
        bar.setStringPainted(true);
        bar.setForeground(new Color(51, 204, 0));
        bar.setString((score*(100/MAX_SCORE)) + "%");
        
        bar.setMaximum(MAX_SCORE*MAX_SCORE);
        bar.setMinimum(0);
        bar.setValue(score*(100/MAX_SCORE));
        
    }
    
    protected void spawnFood(JLabel label) {
        label.setLocation(getRCoord(), getRCoord());

    }
    
    protected void formatFood(JLabel label, JPanel add) {
        label.setBackground(Color.cyan);
        label.setSize(SPACE, SPACE);
        label.setVisible(true);
        String direc = "/dev/games/bugs/resources/foodmodels/food.fw.png";
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource(direc)));
        add.add(label);
        label.setLocation(getRCoord(), getRCoord());

    }
    
    protected void formatImageIcon(String model, JLabel label) {
        String direc = "/dev/games/bugs/resources/bugmodels/" + model + "/1.png";
        label.setIcon(new javax.swing.ImageIcon(getClass().getResource(direc)));
    }
    
    protected int randomInt(int min, int max) {
        return new Random().nextInt((max-min)+1)+min;
    }
    
    protected int getRCoord() {
        return randomInt(1, 8)*SPACE;
    }
    
    protected void addPosition(JLabel label, int direction, String type) {
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
    
    protected void correctPosition(JLabel label) {
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
 
}
