/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Anne
 */
public class MainLoop {

    List<Node> nodes = new ArrayList<Node>();
    List<Street> streets = new ArrayList<Street>();
   

     public void run() {
       

       Node node1 = new Node(100,100);
        Node node2 = new Node(150,100);
        Node node3 = new Node(150, 150);
        Node node4 = new Node(100,150);
        Node node5 = new Node(200,150);
        nodes.add(node1);
        nodes.add(node2);
        nodes.add(node3);
        nodes.add(node4);
        nodes.add(node5);
        
        Street street1 = new Street(node1,node2);
        Street street2 = new Street(node4, node1);
        Street street3 = new Street(node2, node3);
        Street street4 = new Street(node3,node4);
        Street street5 = new Street(node4,node5);
        streets.add(street1);
        streets.add(street2);
        streets.add(street3);
        streets.add(street4);
        streets.add(street5);

        

        node1.addNeighbour(node2, street1);
        node1.addNeighbour(node4, street2);
        node2.addNeighbour(node1, street1);
        node2.addNeighbour(node4, street3);
        node3.addNeighbour(node2, street3);
        node3.addNeighbour(node4, street4);
        node4.addNeighbour(node3, street4);
        node4.addNeighbour(node1, street2);
        node4.addNeighbour(node5, street5);
        node5.addNeighbour(node4, street5);

        MapComponent comp = new MapComponent( nodes, streets);
       

    }

     public List getStreets(){
         return streets;
     }

     public List getNodes(){
         return nodes;
     }
}
