/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.hw.hw02;

import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author fuji
 */
public class OMOSet extends OMOSetBase implements OMOSetView {
    Set<Integer> numbers;
    
    public OMOSet() {
        numbers = new HashSet<>();
    }

    
            
    @Override
    public void add(int element) {
        numbers.add(element);
    }

    @Override
    public void remove(int element) {
        numbers.remove(element);
    }

    @Override
    public boolean contains(int element) {
        return numbers.contains(element);
    }

    @Override
    public int[] toArray() {
        OMOSet o = new OMOSet();
        Object[] arr = numbers.toArray();
        int[] a = new int[arr.length];
        for (int i = 0; i < arr.length; i++){
            a[i] = (int) arr[i];
        }
        return a;
    }

    @Override
    public OMOSetView copy() {
        OMOSet o = new OMOSet();
        int[] a = this.toArray();
        for (int i = 0; i < a.length; i++){
            o.add(a[i]);
        }
        return o;
    }

    
    
 
    
}
