package images;


import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.filechooser.FileNameExtensionFilter;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author ask
 */
public class YourImage {
    
    public File setImage(JLabel yourLabel, boolean setDefault){
            
        Image yourImage = null;
        
        File newFile = null;
        
        if( !setDefault ) {
            JFileChooser choosePhoto = new JFileChooser();
            FileNameExtensionFilter fileExtentions = new FileNameExtensionFilter("images", "jpg","png");
            choosePhoto.setFileFilter(fileExtentions);
            choosePhoto.showOpenDialog(null);
            newFile = choosePhoto.getSelectedFile();
        }
        
        try {
            if( !setDefault )
                yourImage = ImageIO.read(newFile);
            else
                yourImage = ImageIO.read(getClass().getResource("/unknown.jpg"));
        } catch( Exception e ) {    }
        
        ImageIcon icon = new ImageIcon(resizeYourImage(yourImage,yourLabel));
        if( yourImage != null )
        yourLabel.setIcon(icon);
        
        return newFile;

    }
    
    public Image resizeYourImage(Image yourImage,JLabel yourLabel){
        
        int labelWidth = yourLabel.getWidth();
        int labelHeight = yourLabel.getHeight();
        
        BufferedImage resizedImage = new BufferedImage(labelWidth, labelHeight, BufferedImage.TYPE_INT_RGB);
        
        Graphics2D g2 = resizedImage.createGraphics();
        g2.drawImage(yourImage, 0, 0,labelWidth,labelHeight,null);
        g2.dispose();
        
        return resizedImage;
    }
    
    
    
    public static void main(String[] str){
        
        try{
            UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
        }catch(Exception e){
            System.out.println("Here");
            e.printStackTrace();
        }
        
        JLabel j=new JLabel();
        JFrame jf=new JFrame();
        jf.add(j);
        jf.setSize(400, 400);
        j.setBounds(0, 0, 400, 400);
        jf.setVisible(true);
        File f=new YourImage().setImage(j,false);
        try{
            if(f != null){
            String s=f.getCanonicalFile().toString();
            System.out.println(s);}
        }catch(Exception e){
            e.printStackTrace();
        }
        
    }
}



/*   choosePhoto.setFileSelectionMode(JFileChooser.FILES_ONLY);
        
        choosePhoto.addChoosableFileFilter(fileExtentions);
        choosePhoto.setAcceptAllFileFilterUsed(false);
        int returnVal=choosePhoto.showOpenDialog(this);
        File f=null;
        if(returnVal == JFileChooser.APPROVE_OPTION){
            f=choosePhoto.getSelectedFile();
            if(Desktop.isDesktopSupported()){
                try{
                    Desktop.getDesktop().open(f);
                }catch(Exception e){
                    e.printStackTrace();
                }
            }
        }           */