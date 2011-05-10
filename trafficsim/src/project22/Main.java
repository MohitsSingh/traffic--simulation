/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project22;


import javax.swing.JFrame;


/**
 *
 * @author Anne
 */
public class Main {
   
   public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(700,700);
        frame.setTitle("Street");

       

        StreetComponent street = new StreetComponent();
        frame.add(street);

        frame.setVisible(true);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

}
