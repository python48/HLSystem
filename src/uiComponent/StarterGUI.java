/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package uiComponent;

import com.sun.awt.AWTUtilities;
import java.awt.Dimension;
import java.awt.Shape;
import java.awt.Toolkit;
import java.awt.geom.RoundRectangle2D;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ImageIcon;

/**
 *
 * @author Armando
 */
public class StarterGUI extends javax.swing.JFrame {
    
    /**
     * Creates new form StarterGUI
     */
    public static boolean Access = false;
    
    public StarterGUI() {
        initComponents();
        setProperties();
        fillBar();//waits forthe user access to start loading the progress bar 
        promptPass();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jProgressBar1 = new javax.swing.JProgressBar();
        status = new javax.swing.JLabel();
        version = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);
        setTitle("HL Manager");
        setCursor(new java.awt.Cursor(java.awt.Cursor.DEFAULT_CURSOR));
        setMaximumSize(new java.awt.Dimension(355, 351));
        setMinimumSize(new java.awt.Dimension(355, 351));
        setUndecorated(true);
        setPreferredSize(new java.awt.Dimension(355, 351));
        setResizable(false);
        setType(java.awt.Window.Type.UTILITY);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        jProgressBar1.setForeground(new java.awt.Color(230, 76, 4));
        jProgressBar1.setStringPainted(true);
        getContentPane().add(jProgressBar1, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 290, 160, -1));

        status.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        status.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        status.setText("Prompting Password...");
        getContentPane().add(status, new org.netbeans.lib.awtextra.AbsoluteConstraints(110, 310, 160, 20));

        version.setFont(new java.awt.Font("Arial", 0, 12)); // NOI18N
        version.setText("v1.0");
        getContentPane().add(version, new org.netbeans.lib.awtextra.AbsoluteConstraints(290, 320, 30, 20));

        jLabel1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/sources/Starter.png"))); // NOI18N
        jLabel1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        getContentPane().add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(-150, 0, 510, 350));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    
    private void promptPass(){
        new Thread(new TempoPrompting()).start();
    }
    
    private void fillBar(){
        new Thread(new TempoFilling()).start();
    }
    
    private void disposeWin(){
        this.dispose();
    }
    
   
    
    private void setProperties() {
        Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
        this.setLocation(dim.width/2-this.getSize().width/2, dim.height/2-this.getSize().height/2);
        this.setIconImage(new ImageIcon(getClass().getResource("/sources" + "/LOGO180X180.png")).getImage());
        Shape shape = new RoundRectangle2D.Float(1, 5, 350, 338, 90, 210);
        AWTUtilities.setWindowShape(this, shape);
        
   }
    



    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    public javax.swing.JProgressBar jProgressBar1;
    private javax.swing.JLabel status;
    private javax.swing.JLabel version;
    // End of variables declaration//GEN-END:variables
   
    class TempoPrompting implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 50; i ++){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StarterGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            new LoginGUI().setVisible(true);
        }
        
    }
    
    class TempoLastDelay implements Runnable{

        @Override
        public void run() {
            for(int i = 0; i < 50; i ++){
                try {
                    Thread.sleep(50);
                } catch (InterruptedException ex) {
                    Logger.getLogger(StarterGUI.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            disposeWin();
            new MainMenuGUI().setVisible(true);
        }
        
    }
    
    class TempoFilling implements Runnable{
        
        @Override
        public void run() {
            while(Access == false){
                //waits intul changes to different state
                System.out.print(".");
            }
            
            status.setText("Connecting... Please Wait");
            
            for(int i = 0; i <= 100; i ++){
                    try {
                        jProgressBar1.setValue(i);
                        jProgressBar1.repaint();
                        Thread.sleep(100);
                    } catch (InterruptedException ex) {
                        Logger.getLogger(StarterGUI.class.getName()).log(Level.SEVERE, null, ex);
                    }
                }
                new Thread(new TempoLastDelay()).start();
            
        }
        
    }
    
}
