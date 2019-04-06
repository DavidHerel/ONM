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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Homework1 hm = new Homework1();
        Homework1 hm2 = new Homework1();
        hm.i();
        hm2.h();
        System.out.println("pocet h na 1 objektu " +hm.h());
        System.out.println("pocet h na 1 objektu " +hm.i());
    }
    
}
