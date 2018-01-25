package herbs;

import java.awt.Color;

import javax.swing.JFrame;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import javax.swing.DefaultListModel;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.Timer;

import javax.swing.JTabbedPane;
import javax.swing.JTextField;
import javax.swing.ListSelectionModel;
import javax.swing.SpinnerDateModel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JFrame;
import javax.swing.JComponent;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
 
public class Main extends JPanel {
    public Main() {
    	super(new GridLayout(1, 1));
        
        JTabbedPane tabbedPane = new JTabbedPane();      
         
        JComponent panel1 = new Jpanel01();
        tabbedPane.addTab("Appointment", panel1);        
       // tabbedPane.setMnemonicAt(0, KeyEvent.VK_1);
         
        JComponent panel2 = new Jpanel01();
       // tabbedPane.addTab("Patient Record", null);       
       
        JComponent panel3 = new Jpanel01();
      //  tabbedPane.addTab("Total", null);
     
       //Add the tabbed pane to this panel.
        add(tabbedPane);         
        //The following line enables to use scrolling tabs.
       tabbedPane.setTabLayoutPolicy(JTabbedPane.SCROLL_TAB_LAYOUT);
    }
     
  
     
    /** Returns an ImageIcon, or null if the path was invalid. */
    protected static ImageIcon createImageIcon(String path) {
        java.net.URL imgURL = Main.class.getResource(path);
        if (imgURL != null) {
            return new ImageIcon(imgURL);
        } else {
            System.err.println("Couldn't find file: " + path);
            return null;
        }
    }
     
   
    private static void createAndShowGUI() {
        //Create and set up the window.
        JFrame frame = new JFrame("Chinese Herds");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         
        //Add content to the window.
        frame.add(new Main(), BorderLayout.CENTER);
        frame.setSize(1000,1000);
        frame.pack();
        frame.setVisible(true);
    }
     
    public static void main(String[] args) {        
        SwingUtilities.invokeLater(new Runnable() {
            public void run() {  
            	createAndShowGUI();
            }
        });
    }
}//end class

