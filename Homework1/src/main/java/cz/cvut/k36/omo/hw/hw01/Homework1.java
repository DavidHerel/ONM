/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.hw.hw01;

/**
 *
 * @author fuji
 */
public class Homework1 {
    int counter = 0;
    static int counter2 = 0;

    public Homework1() {
    }
    
    
    
    public boolean f(){
        return true;
    }
    
    public static boolean g(){
        return false;
    }
    
    public int h(){
        counter++;
        return counter;
    }
    
    public int i(){
        counter2++;
        return counter2;
    }
    
    
    
}
