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
        Set<Integer> list1;
        Set<Integer> list2;
        list1 = new HashSet<>();
        list2 = new HashSet<>();
        for (int i = 0 ; i < A.toArray().length; i++){
            list1.add(A.toArray()[i]);
        }
        for (int i = 0 ; i <B.toArray().length; i++){
            list2.add(B.toArray()[i]);
        }
        for (Integer i : list2){
            if (list1.contains(i)){
                list1.remove(i);
            }
        }
        int[] integers = new int[list1.size()];
        int j = 0;
        for (Integer i : list1){
            integers[j]=i;
            j++;
        }
        return integers;
    }

    @Override
    public OMOSetView copy() {
        Set<Integer> list1;
        Set<Integer> list2;
        list1 = new HashSet<>();
        list2 = new HashSet<>();
        for (int i = 0 ; i < A.toArray().length; i++){
            list1.add(A.toArray()[i]);
        }
        for (int i = 0 ; i <B.toArray().length; i++){
            list2.add(B.toArray()[i]);
        }
        for (Integer i : list2){
            if (list1.contains(i)){
                list1.remove(i);
            }
        }
        return new OMOSet(list1);
    }
    
}
