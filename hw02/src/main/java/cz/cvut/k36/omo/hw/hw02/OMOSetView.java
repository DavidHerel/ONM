/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.hw.hw02;

/**
 *
 * @author fuji
 */
public interface OMOSetView {
    boolean contains(int element); // testuje na přítomnost prvku v množině
 
    int[] toArray(); //vrátí kopii prvků množiny v poli (na pořadí prvků nezáleží)
 
    OMOSetView copy(); //vrátí kopii množiny

}
