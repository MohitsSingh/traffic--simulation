/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.util.List;

/**
 *
 * @author Anne
 */
public class MapComponent {

    private List<Node> nodes;
    private List<Street> streets;

    public MapComponent(List<Node> a,List<Street> s ){
        nodes = a;
        streets = s;
        drawStreet();
        drawNode();
    }


    public void drawStreet(){

        for(int i=0; i < streets.size(); i++){
            Street f = streets.get(i);
            int x1 = f.getStartpointX();
            int y1 = f.getStartpointY();
            int x2 = f.getEndpointX();
            int y2 = f.getEndpointY();
            Line2D line = new Line2D.Double(x1, y1, x2, y2);

        }
    }

    public void drawNode(){
            for(int i=0; i < nodes.size(); i++){
            Node n = nodes.get(i);
            int x1 = n.getX();
            int y1 = n.getY();
            Ellipse2D node = new Ellipse2D.Double(x1-5, y1-5, 10, 10);

        }
    }

    

}
