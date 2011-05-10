/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project22;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComponent;

/**
 *
 * @author Anne
 */
public class StreetComponent extends JComponent
{
    private static final int HEIGHT_CAR = 15;

    private int[] cars;
    @Override
    public void paint(Graphics g)
    {

    // CARS
        Car auto = new Car();
        int[] a = { 50, 50, 70};
        int[] b = { 102, 20, 70};
        int[] c = {30,  100, 50};
        auto.update(a, b, c);
        cars = auto.getCars();

        Graphics2D g2 = (Graphics2D)g;

        int d = cars.length;

        for(int i =0; i< d; i = i+3){
            RoundRectangle2D car = new RoundRectangle2D.Float(cars[i],cars[i+1],cars[i+2], HEIGHT_CAR,10,10);
            g2.setColor(Color.GREEN);
            g2.fill(car);
            g2.draw(car);
        }
        g2.setColor(Color.BLACK);

    // STREET

        //Plan 1 Large plan

//        Street intersection1 = new Street(4, 60, 160, 200);
//        intersection1.drawStreet(g2);
//
//        Street TJunction1 = new Street(6, 60, 60, 200);
//        TJunction1.drawStreet(g2);
//
//        Street corner1 = new Street(5,160,60,0, 90 );
//        corner1.drawStreet(g2);
//
//        Street corner2 = new Street(5,160,85,0, -90 );
//        corner2.drawStreet(g2);
//
//        Street smallStreet = new Street(1,310,160,25);
//        smallStreet.drawStreet(g2);
//
//        Street verticalStreet1 = new Street(1,135,360,150);
//        verticalStreet1.drawStreet(g2);
//
//        Street corner3 = new Street(5,135,410,180,90);
//        corner3.drawStreet(g2);
//
//        Street TJunction2 = new Street(6, 235, 560, 200);
//        TJunction2.drawStreet(g2);
//
//        Street corner4 = new Street(5,335,410,-90,90);
//        corner4.drawStreet(g2);
//
//        Street verticalStreet2 = new Street(1,485,0,510);
//        verticalStreet2.drawStreet(g2);

          //plan 2 Medium

//        Street horizontalStreet1 = new Street(2,50,50,100);
//        horizontalStreet1.drawStreet(g2);
//
//        Street TJunction3 = new Street(6, 150, 50, 100);
//        TJunction3.drawStreet(g2);
//
//        Street verticalStreet3 = new Street(1,175,125,200);
//        verticalStreet3.drawStreet(g2);
//
//        Street corner4 = new Street(5, 175, 225, -180,90);
//        corner4.drawStreet(g2);
//
//        Street horizontalStreet2 = new Street(2,275,375,150);
//        horizontalStreet2.drawStreet(g2);
//
//        Street corner5 = new Street(5, 325, 225,-90,90);
//        corner5.drawStreet(g2);
//
//        Street verticalStreet4 = new Street(1,475,125,200);
//        verticalStreet4.drawStreet(g2);
//
//        Street TJunction4 = new Street(6, 450, 50, 100);
//        TJunction4.drawStreet(g2);
//
//        Street horizontalStreet3 = new Street(2,250,50,200);
//        horizontalStreet3.drawStreet(g2);
//
//        Street horizontalStreet4 = new Street(2,550,50,200);
//        horizontalStreet4.drawStreet(g2);

        //plan3  Horizontal street
        Street horizontalStreet5 = new Street(2, 0, 100, 800);
        horizontalStreet5.drawStreet(g2);
 }
}