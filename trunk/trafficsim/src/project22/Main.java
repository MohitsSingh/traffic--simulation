/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project22;

import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JComponent;
import javax.swing.JFrame;

/**
 *
 * @author Anne
 */
public class Main {

    public Main(){
        JFrame frame = new JFrame();
        frame.setSize(400,400);
        frame.setTitle("Street");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StreetComponent street = new StreetComponent();
        frame.add(street);

        frame.setVisible(true);

        StreetComponent comp = new StreetComponent();
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        JFrame frame = new JFrame();
        frame.setSize(700,700);
        frame.setTitle("Street");

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        StreetComponent street = new StreetComponent();
        frame.add(street);

        frame.setVisible(true);

        StreetComponent comp = new StreetComponent();      
    }

}

class StreetComponent extends JComponent
{
    public void paint(Graphics g)
    {
        Graphics2D g2 = (Graphics2D)g;

        Street intersection1 = new Street(4, 60, 160, 200);
        intersection1.drawStreet(g2);

        Street TJunction1 = new Street(6, 60, 60, 200);
        TJunction1.drawStreet(g2);

        Street corner1 = new Street(5,160,60,0, 90 );
        corner1.drawStreet(g2);

        Street corner2 = new Street(5,160,85,0, -90 );
        corner2.drawStreet(g2);

        Street smallStreet = new Street(1,310,160,25);
        smallStreet.drawStreet(g2);

        Street verticalStreet1 = new Street(1,135,360,150);
        verticalStreet1.drawStreet(g2);

        Street corner3 = new Street(5,135,410,180,90);
        corner3.drawStreet(g2);

        Street TJunction2 = new Street(6, 235, 560, 200);
        TJunction2.drawStreet(g2);

        Street corner4 = new Street(5,335,410,-90,90);
        corner4.drawStreet(g2);

        Street verticalStreet2 = new Street(1,485,0,510);
        verticalStreet2.drawStreet(g2);
    }

}
