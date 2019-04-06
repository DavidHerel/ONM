/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.hw.hw02;

import cz.cvut.k36.omo.hw.hw02.OMOSet;
import cz.cvut.k36.omo.hw.hw02.OMOSetIntersection;
import cz.cvut.k36.omo.hw.hw02.OMOSetView;
import java.util.HashSet;
import java.util.Set;

class Main {

    public static void main(String[] args) {
        OMOSet setA = new OMOSet();
        OMOSet setB = new OMOSet();

        int[] a ={1, 14, 5, 8, 2};
        int[] b = {32, 12, 14, 4, 5};

        OMOSetView setC = setA.copy();



        for (int x : a){
            setA.add(x);
        }

        for (int y : b){
            setB.add(y);
        }
        System.out.println();



//        for (int i = 1; i < 10; i +=2){
//            setA.add(i);
//        }
//        setA.add(1);
//
//
//        for (int i = 6; i < 14; i+=2){
//            setB.add(i);
//        }
//        OMOSetView setC = setA.copy();
        System.out.println("Union: ");
        OMOSetUnion union = new OMOSetUnion(setA, setB);
        for(int i : union.toArray()){
            System.out.println(i);
        }
        System.out.println("Intersection: ");
        OMOSetIntersection intersection = new OMOSetIntersection(setA, setB);
        for(int i : intersection.toArray()){
            System.out.println(i);
        }
        System.out.println("Complement:");
        OMOSetComplement complement= new OMOSetComplement(setA, setB);
        for(int i : complement.toArray()){
            System.out.println(i);
        }
        System.out.println("Even:");

        OMOSetEven even = new OMOSetEven(setB);
        for(int i : even.toArray()){
            System.out.println(i);
        }
        setA.add(12);

        System.out.println("Intersection: ");
        for(int i : intersection.toArray()){
            System.out.println(i);
        }

        System.out.println("C should not contain 12: ");

        for(int i : setC.toArray()){
            System.out.println(i);
        }

        setA.remove(12);
        System.out.println("Intersection: ");
        for(int i : intersection.toArray()){
            System.out.println(i);
        }
    }
}