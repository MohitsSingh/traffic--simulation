/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

/**
 *
 * @author Anne
 */
public class Street {

    private double length;
    private Node startNode, endNode;

    public Street(Node s, Node e){
        startNode = s;
        endNode = e;
        setLength(s.getX(), s.getY(), e.getX(), e.getY());
    }

    public void setLength(int x1, int y1, int x2, int y2){

        int dx = Math.abs(x2-x1);
        int dy = Math.abs(y2-y1);

        length = Math.sqrt(dx * dx + dy*dy);
    }

    public double getLength(){
        return length;
    }

    public int getStartpointX(){
        return startNode.getX();

    }

    public int getStartpointY(){
        return startNode.getY();

    }

    public int getEndpointX(){
        return endNode.getX();

    }

    public int getEndpointY(){
        return endNode.getY();

    }

}
