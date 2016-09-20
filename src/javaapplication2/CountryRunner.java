/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javaapplication2;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.net.MalformedURLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

/**
 *
 * @author ASUS
 */
public class CountryRunner {
    
    
    private Display display;
    private BufferedImage img;
    private BufferedImage icon;
    private BufferedImage agentIcon;
    private String basePath;
    public Environment env;
    private static Graphics2D g2d;
    private JPanel header;
    private JFrame frame;
    private int agent;
    private int soldier;
    private int untouchable;
    private int citizen;
    private int camp;
    private int storage;
    private int terrorist;
    
    
    public CountryRunner() throws IOException
    {
       
        // header = new JPanel();
        
        //setUpScene();
       parseConfig();
       frame = new JFrame("New Country");
        env = new Environment(Display.WIDTH,Display.HEIGHT,Display.TOP_PANEL_HEIGHT,
        agent,soldier,untouchable,citizen,camp,storage,terrorist);
        display = new Display(env);
        display.setEnabled(true);
  
         frame.add                     ( display              ) ;
    frame.setLocationByPlatform   ( true                 ) ;
    frame.setResizable            ( false                ) ;
    frame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE ) ;
    frame.pack                    (                      ) ;
      
        
    }
   // public JFrame jpanel = new JFrame();
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException, InterruptedException {
        // TODO code application logic here
      CountryRunner runner = new CountryRunner();
      runner.frame.setVisible(true);
  
       while(true)
       {
           
           
             runner.display.repaint();
             runner.run();
             Thread.sleep(50);
           
       
           
       }
    
    }
    public void run()
    {
     
        env.stepAll(0);
    }
    private void parseConfig()
    {
        String f;
        try
        {
          
        BufferedReader reader = new BufferedReader(new FileReader("config.txt"));
        StringBuilder sb = new StringBuilder();
        String line = reader.readLine();
        agent = Integer.parseInt(reader.readLine().split("=")[1]);
        reader.readLine();
        reader.readLine();
        soldier = Integer.parseInt(reader.readLine().split("=")[1]);
        reader.readLine();
        reader.readLine();
        untouchable = Integer.parseInt(reader.readLine().split("=")[1]);
        reader.readLine();
        reader.readLine();
        citizen = Integer.parseInt(reader.readLine().split("=")[1]);
        reader.readLine();
        reader.readLine();
        camp = Integer.parseInt(reader.readLine().split("=")[1]);
        reader.readLine();
        reader.readLine();
        storage = Integer.parseInt(reader.readLine().split("=")[1]);
        reader.readLine();
        reader.readLine();
        terrorist = Integer.parseInt(reader.readLine().split("=")[1]);
        reader.close();

            
           
     
        }
        catch(Exception  e)
        {
            System.out.println("Config file is missing.");
        }
        
    }
        
  
    
}
