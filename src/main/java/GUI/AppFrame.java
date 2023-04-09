/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package GUI;

import compressor.compressor;
import compressor.decompressor;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

/**
 *
 * @author Meteor
 */
public class AppFrame extends JFrame implements ActionListener{
    
    JButton compressButton;
    JButton decompressButton;
    
    AppFrame(){
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//how jframe to b closed
        this.setLayout(null);
        
        compressButton=new JButton("Select file to compress"); //title in GUI
        compressButton.addActionListener(this);//button click
        compressButton.setBounds(20,100,200,30);
        
        decompressButton=new JButton("Select file to decompress");
        decompressButton.addActionListener(this);
        decompressButton.setBounds(250,100,200,30);
        
        //adding components for GUI
        this.add(compressButton); 
        this.add(decompressButton);
        this.setSize(500,200);
        //contentpane isi something which is used to hold objects in jframe
        this.getContentPane().setBackground(Color.black);
        
        this.setVisible(true);
    }
//abstract class
    @Override
    //handle the action performed here below
    //for compressed button
    public void actionPerformed(ActionEvent e) {
        //getSource is to check whether button is clicked or not
        if(e.getSource()==compressButton){
            JFileChooser filechooser=new JFileChooser();//to choose file in a system
            //store the chosen file in response variable
            int response=filechooser.showSaveDialog(null);
            
            //now to return valid file
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                // whatever we get from filepath we can see on console
                System.out.println(file); 
                //to handle some unexpected error while executing a file so use try catch
                try{
                    //method function of compressor class
                    compressor.method(file);   
                }
                catch(Exception exp){
                    // to show a save as dialog box option
                    JOptionPane.showMessageDialog(null, exp.toString());
                }
            }            
        }
        
         //for decompressed button
        if(e.getSource()==decompressButton){
            JFileChooser filechooser=new JFileChooser();
            int response=filechooser.showSaveDialog(null);
            
            if(response==JFileChooser.APPROVE_OPTION){
                File file = new File(filechooser.getSelectedFile().getAbsolutePath());
                System.out.println(file);
                try{
                    decompressor.method(file);
                    
                }
                catch(Exception excp){
                    JOptionPane.showMessageDialog(null, excp.toString());
                    
                }
            }
            
        }
    }
}