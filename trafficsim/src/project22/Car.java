/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package project22;

/**
 *
 * @author Anne
 */
public class Car {
    
   
    private static final int HEIGHT_CAR = 10;
   
    private int[] cars; 

    public Car(){
        
    }

    public void update(int a[], int b[], int c[]){

        int d = a.length;
        cars = new int[d*3];
        for(int i = 0; i < d; i++){
            cars[(i*3)] = a[i];
            cars[(i*3)+1] = b[i];
            cars[(i*3)+2] = c[i];
         
        }
    }

    public int[] getCars(){
        return cars;
    }

}