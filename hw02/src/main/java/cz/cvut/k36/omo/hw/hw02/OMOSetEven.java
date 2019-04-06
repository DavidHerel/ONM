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
public class OMOSetEven implements OMOSetView {
    private OMOSetView A;
    
    OMOSetEven(OMOSetView setA) {
        A = setA;
 
    }
    
    @Override
    public boolean contains(int element) {
        return (((element%2)==0) && A.contains(element));
    }

    @Override
    public int[] toArray() {
        OMOSet o = (OMOSet) copy();
        return o.toArray();
    }

    @Override
    public OMOSetView copy() {
        OMOSet o = new OMOSet();
        int[] a = A.toArray();
        for (int i = 0; i < a.length; i++) {
            if ((a[i]%2) ==0){
                o.add(a[i]);
            }
        }
        return o;
    }
    
}
