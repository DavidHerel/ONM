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
        Set<Integer> list2;
        Set<Integer> list1;
        list2 = new HashSet<>();
        list1 = new HashSet<>();
        for (int i = 0 ; i < A.toArray().length; i++){
            list2.add(A.toArray()[i]);
        }
        for (Integer i : list2){
            if ((i%2)==0){
                list1.add(i);
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
        Set<Integer> list2;
        Set<Integer> list1;
        list2 = new HashSet<>();
        list1 = new HashSet<>();
        for (int i = 0 ; i < A.toArray().length; i++){
            list2.add(A.toArray()[i]);
        }
        for (Integer i : list2){
            if ((i%2)==0){
                list1.add(i);
            }
        }
        return new OMOSet(list1);
    }
    
}
