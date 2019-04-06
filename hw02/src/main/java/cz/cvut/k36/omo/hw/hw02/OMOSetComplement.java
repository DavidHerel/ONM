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
public class OMOSetComplement implements OMOSetView { 
    private OMOSetView A;
    private OMOSetView B;
    
    OMOSetComplement(OMOSetView setA, OMOSetView setB) {
        A = setA;
        B = setB;
    }

    @Override
    public boolean contains(int element) {
        return (A.contains(element) && !B.contains(element));
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
        int[] b = B.toArray();
        for (int i = 0; i < a.length; i++) {
            o.add(a[i]);
        }
        for (int i = 0; i < b.length; i++) {
            if (o.contains(b[i])) {
                o.remove(b[i]);
            }
        }
        return o;
    }
    
}
