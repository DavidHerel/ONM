/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.hw.hw02;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

/**
 *
 * @author fuji
 */
public class OMOSet extends OMOSetBase implements OMOSetView {
    private Set<Integer> numbers;

    public OMOSet() {
        numbers = new HashSet<>();
    }

    public OMOSet(Set<Integer> numbers) {
        this.numbers = numbers;
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
        int[] integers = new int[numbers.size()];
        int j = 0;
        for (Integer i : numbers){
            integers[j]=i;
            j++;
        }
        return integers;
    }

    @Override
    public OMOSetView copy() {
        return new OMOSet(this.numbers);
    }

    
    
 
    
}
