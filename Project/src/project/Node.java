/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

/**
 *
 * @author Anne
 */
public class Node {
    
    private Point2D.Double position;
    private HashMap<Node,Street> neighbourMap;
    private List<Node> neighbourNodes;

    public Node(int x, int y){
        position = new Point2D.Double(x,y);
        neighbourMap = new HashMap<Node,Street>();
        neighbourNodes = new ArrayList<Node>();
    }

    public int getY(){
        return (int) position.getY();
    }

    public int getX(){
        return (int) position.getX();
    }

    public void addNeighbour(Node n, Street a){
        neighbourNodes.add(n);
        neighbourMap.put(n,a);
    }

    public List<Node> getNeighbourNodes() {
        return neighbourNodes;
    }

    public Street getStreet (Node destination) {
        return neighbourMap.get(destination);
    }

    
}
