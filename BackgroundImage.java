/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package images;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JPanel;

/**
 *
 * @author ask
 */
abstract public class BackgroundImage {
    public static void setBackgroundImage(JFrame frame,String URL) {
        
        JPanel p = new JPanel() {
            public void paintComponent( Graphics g ){
                super.paintComponent(g);
                BufferedImage img = null;
                try {
                    img = ImageIO.read(getClass().getResource(URL));
                } catch (Exception e) {     }
                g.drawImage(img, 0, 0,this);
            }  
        };
        Dimension d = Toolkit.getDefaultToolkit().getScreenSize();
//        p.setBounds(0, 0, 1360, 700);
        p.setSize(d);
        frame.getContentPane().add(p);
    }
    
}
