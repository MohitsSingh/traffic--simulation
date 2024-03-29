/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project22;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.geom.Arc2D;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.Point2D;
import java.awt.geom.RoundRectangle2D;
import javax.swing.JComponent;

/**
 *
 * @author Anne
 */
public class Street {

    private int x;
    private int y;
    private int var; // var(variable) is 1 for vertical, 2 for horizantal, 3 for circle, 4 for intersection
                     // 5 for angle, 6 for T-junction
    private int length;
    private int angle;
    private int start;

    private final int WIDTH_STREET = 50;
    private final int LENGTH_MIDLINE = 5;
    private static final int OPEN = 0;// angle property

   //dashed mid line
    private float[] dashPattern = { 10, 5, 10, 5 };
    
   // private int[][] road;

   
    public Street(int var, int x, int y, int length){
        this.x = x;
        this.y = y;
        this.var = var;
        this.length = length;
    }

    // constructor for a corner (angle and start angle integer included)
    public Street(int var, int x, int y, int start, int angle){
        this.x = x;
        this.y = y;
        this.var = var;
        this.angle = angle;
        this.start = start;
        length = 200;

    }

    public void drawStreet(Graphics2D g2){
        if(var == 1){
            Point2D.Double r1 = new Point2D.Double(x, y);
            Point2D.Double r2 = new Point2D.Double(x, y + length);
            Line2D.Double leftSide = new Line2D.Double(r1,r2);
            g2.draw(leftSide);
            Point2D.Double a3 = new Point2D.Double(x + WIDTH_STREET, y);
            Point2D.Double a4 = new Point2D.Double(x + WIDTH_STREET, y + length);
            Line2D.Double rightSide = new Line2D.Double(a3,a4);
            g2.draw(rightSide);

            float dash1[] = {10.0f};
            Line2D.Double realMidLine = new Line2D.Double(new Point2D.Double(x+ WIDTH_STREET/2,y ), new Point2D.Double(x+ WIDTH_STREET/2, y+ length));
            g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT,
                                  BasicStroke.JOIN_MITER, 10,
                                  dashPattern, 0));
            g2.draw(realMidLine);
            g2.setStroke(new BasicStroke());
        }
        else if(var == 2){
            Point2D.Double c1 = new Point2D.Double(x, y);
            Point2D.Double c2 = new Point2D.Double(x + length, y);
            Line2D.Double upperSide = new Line2D.Double(c1,c2);
            g2.draw(upperSide);
            Point2D.Double b3 = new Point2D.Double(x, y + WIDTH_STREET);
            Point2D.Double b4 = new Point2D.Double(x + length, y + WIDTH_STREET);
            Line2D.Double lowerSide = new Line2D.Double(b3,b4);
            g2.draw(lowerSide);

            float dash1[] = {10.0f};
            Line2D.Double realMidLine = new Line2D.Double(new Point2D.Double(x,y + WIDTH_STREET/2), new Point2D.Double(x+length, y + WIDTH_STREET/2));
            g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT,
                                  BasicStroke.JOIN_MITER, 10,
                                  dashPattern, 0));
            g2.draw(realMidLine);
            g2.setStroke(new BasicStroke());
            
        }
        else if(var == 3){
            Ellipse2D.Double circle = new Ellipse2D.Double(x,y,length,length);
            g2.draw(circle);
            Ellipse2D.Double innerCircle = new Ellipse2D.Double(x+WIDTH_STREET,y+WIDTH_STREET,length - (WIDTH_STREET*2),length - (WIDTH_STREET*2));
            g2.draw(innerCircle);

            g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT,
                                  BasicStroke.JOIN_MITER, 10,
                                  dashPattern, 0));
            Ellipse2D.Double midLine = new Ellipse2D.Double(x+(WIDTH_STREET/2),y+(WIDTH_STREET/2),length - WIDTH_STREET,length - WIDTH_STREET);
            g2.draw(midLine);

            g2.setStroke(new BasicStroke());
            
            
        }
        else if(var == 4){
            //left
            Point2D.Double e1 = new Point2D.Double(x, y+(length - WIDTH_STREET)/2);
            Point2D.Double e2 = new Point2D.Double(x + (length - WIDTH_STREET)/2, y + (length - WIDTH_STREET)/2);
            Line2D.Double leftUpperSide = new Line2D.Double(e1,e2);
            g2.draw(leftUpperSide);
            Point2D.Double f1 = new Point2D.Double(x, y+(length - WIDTH_STREET)/2 + WIDTH_STREET);
            Point2D.Double f2 = new Point2D.Double(x + (length - WIDTH_STREET)/2, y + (length - WIDTH_STREET)/2 + WIDTH_STREET);
            Line2D.Double leftUnderSide = new Line2D.Double(f1,f2);
            g2.draw(leftUnderSide);

             Line2D.Double realMidLine7 = new Line2D.Double(new Point2D.Double(x, y+(length - WIDTH_STREET)/2 + WIDTH_STREET/2), new Point2D.Double(x + (length - WIDTH_STREET)/2, y + (length - WIDTH_STREET)/2 + WIDTH_STREET/2 ));
            g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT,
                                  BasicStroke.JOIN_MITER, 10,
                                  dashPattern, 0));
            g2.draw(realMidLine7);
            g2.setStroke(new BasicStroke());

            
            //upper
            Point2D.Double h1 = new Point2D.Double(x +(length - WIDTH_STREET)/2, y);
            Point2D.Double h2 = new Point2D.Double(x + (length - WIDTH_STREET)/2, y + (length - WIDTH_STREET)/2);
            Line2D.Double lupperSide = new Line2D.Double(h1,h2);
            g2.draw(lupperSide);
            Point2D.Double j1 = new Point2D.Double(x+(length - WIDTH_STREET)/2 + WIDTH_STREET, y);
            Point2D.Double j2 = new Point2D.Double(x + (length - WIDTH_STREET)/2 + WIDTH_STREET, y + (length - WIDTH_STREET)/2);
            Line2D.Double rupperSide = new Line2D.Double(j1,j2);
            g2.draw(rupperSide);

            Line2D.Double realMidLine6 = new Line2D.Double(new Point2D.Double(x +(length - WIDTH_STREET)/2 + WIDTH_STREET/2 , y ), new Point2D.Double(x +(length - WIDTH_STREET)/2 + WIDTH_STREET/2 , y + (length - WIDTH_STREET)/2));
            g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT,
                                  BasicStroke.JOIN_MITER, 10,
                                  dashPattern, 0));
            g2.draw(realMidLine6);
            g2.setStroke(new BasicStroke());
           

            //right
            Point2D.Double k1 = new Point2D.Double(x +(length - WIDTH_STREET)/2 + WIDTH_STREET, y + (length - WIDTH_STREET)/2);
            Point2D.Double k2 = new Point2D.Double(x + length, y + (length - WIDTH_STREET)/2);
            Line2D.Double rightUpperSide = new Line2D.Double(k1,k2);
            g2.draw(rightUpperSide);
            Point2D.Double l1 = new Point2D.Double(x+(length - WIDTH_STREET)/2 + WIDTH_STREET, y + (length - WIDTH_STREET)/2 + WIDTH_STREET);
            Point2D.Double l2 = new Point2D.Double(x + length, y + (length - WIDTH_STREET)/2 + WIDTH_STREET);
            Line2D.Double rightDownSide = new Line2D.Double(l1,l2);
            g2.draw(rightDownSide);


            Line2D.Double realMidLine5 = new Line2D.Double(new Point2D.Double(x +(length - WIDTH_STREET)/2 + WIDTH_STREET , y + (length - WIDTH_STREET)/2 + WIDTH_STREET/2), new Point2D.Double(x + length, y + (length - WIDTH_STREET)/2 + WIDTH_STREET/2));
            g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT,
                                  BasicStroke.JOIN_MITER, 10,
                                  dashPattern, 0));
            g2.draw(realMidLine5);
            g2.setStroke(new BasicStroke());
            

            //down
            Point2D.Double z1 = new Point2D.Double(x +(length - WIDTH_STREET)/2, y + (length - WIDTH_STREET)/2 + WIDTH_STREET);
            Point2D.Double z2 = new Point2D.Double(x + (length - WIDTH_STREET)/2, y + length );
            Line2D.Double deftSide = new Line2D.Double(z1,z2);
            g2.draw(deftSide);
            Point2D.Double v1 = new Point2D.Double(x+(length - WIDTH_STREET)/2 + WIDTH_STREET, y+(length - WIDTH_STREET)/2 + WIDTH_STREET);
            Point2D.Double v2 = new Point2D.Double(x + (length - WIDTH_STREET)/2 + WIDTH_STREET, y + length);
            Line2D.Double dightSide = new Line2D.Double(v1,v2);
            g2.draw(dightSide);

            Line2D.Double realMidLine1 = new Line2D.Double(new Point2D.Double(x +(length - WIDTH_STREET)/2 + WIDTH_STREET/2, y + (length - WIDTH_STREET)/2 + WIDTH_STREET), new Point2D.Double(x + (length - WIDTH_STREET)/2 + WIDTH_STREET/2, y + length ));
            g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT,
                                  BasicStroke.JOIN_MITER, 10,
                                  dashPattern, 0));
            g2.draw(realMidLine1);
            g2.setStroke(new BasicStroke());


        }
        else if(var == 5){
            Arc2D.Double out = new Arc2D.Double(x, y, length, length , 1, angle, OPEN);
            out.setAngleStart(start);
            g2.draw(out);
            Arc2D.Double in = new Arc2D.Double(x+ WIDTH_STREET, y + WIDTH_STREET, length/2 , length/2, 0, angle, OPEN);
            in.setAngleStart(start);
            g2.draw(in);
           
            g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT,
                                  BasicStroke.JOIN_MITER, 10,
                                  dashPattern, 0));
            Arc2D.Double mid = new Arc2D.Double(x + (WIDTH_STREET/2), y + (WIDTH_STREET/2), length - WIDTH_STREET, length- WIDTH_STREET, 0, angle, OPEN);
            mid.setAngleStart(start);
            g2.draw(mid);

            g2.setStroke(new BasicStroke());

        }
        else if(var == 6){
            //left
            Point2D.Double o1 = new Point2D.Double(x, y);
            Point2D.Double o2 = new Point2D.Double(x + length , y );
            Line2D.Double upperLine = new Line2D.Double(o1,o2);
            g2.draw(upperLine);
            Point2D.Double v1 = new Point2D.Double(x, y + WIDTH_STREET);
            Point2D.Double v2 = new Point2D.Double(x + (length - WIDTH_STREET)/2, y + WIDTH_STREET);
            Line2D.Double underLine = new Line2D.Double(v1,v2);
            g2.draw(underLine);

            Line2D.Double realMidLine2 = new Line2D.Double(new Point2D.Double(x ,y + WIDTH_STREET/2), new Point2D.Double(x + (length - WIDTH_STREET)/2, y + WIDTH_STREET/2));
            g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT,
                                  BasicStroke.JOIN_MITER, 10,
                                  dashPattern, 0));
            g2.draw(realMidLine2);
            g2.setStroke(new BasicStroke());


            //down
            Point2D.Double z1 = new Point2D.Double(x +(length - WIDTH_STREET)/2, y + WIDTH_STREET);
            Point2D.Double z2 = new Point2D.Double(x +(length - WIDTH_STREET)/2, y + (length - WIDTH_STREET)/2 + WIDTH_STREET);
            Line2D.Double deftSide = new Line2D.Double(z1,z2);
            g2.draw(deftSide);
            Point2D.Double x1 = new Point2D.Double(x+(length - WIDTH_STREET)/2 + WIDTH_STREET, y + WIDTH_STREET);
            Point2D.Double x2 = new Point2D.Double(x+(length - WIDTH_STREET)/2 + WIDTH_STREET, y + (length - WIDTH_STREET)/2 + WIDTH_STREET);
            Line2D.Double dightSide = new Line2D.Double(x1,x2);
            g2.draw(dightSide);

            Line2D.Double realMidLine4 = new Line2D.Double(new Point2D.Double(x +(length - WIDTH_STREET)/2 + WIDTH_STREET/2,y + WIDTH_STREET), new Point2D.Double(x +(length - WIDTH_STREET)/2 + WIDTH_STREET/2, y + (length - WIDTH_STREET)/2 + WIDTH_STREET));
            g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT,
                                  BasicStroke.JOIN_MITER, 10,
                                  dashPattern, 0));
            g2.draw(realMidLine4);
            g2.setStroke(new BasicStroke());


            //right
            Point2D.Double r1 = new Point2D.Double(x+(length - WIDTH_STREET)/2 + WIDTH_STREET, y + WIDTH_STREET);
            Point2D.Double r2 = new Point2D.Double(x + length, y + WIDTH_STREET);
            Line2D.Double rightDownSide = new Line2D.Double(r1,r2);
            g2.draw(rightDownSide);

            Line2D.Double realMidLine3 = new Line2D.Double(new Point2D.Double(x+(length - WIDTH_STREET)/2 + WIDTH_STREET,y + WIDTH_STREET/2), new Point2D.Double(x + length, y  + WIDTH_STREET/2));
            g2.setStroke(new BasicStroke(1, BasicStroke.CAP_BUTT,
                                  BasicStroke.JOIN_MITER, 10,
                                  dashPattern, 0));
            g2.draw(realMidLine3);
            g2.setStroke(new BasicStroke());

        }
        else{
            System.out.println("error var");
            //JOptionPane.showMessageDialog(null, "error"); //get stack over flow!
        }
            

    }

}




