/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.hw.hw03;

/**
 *
 * @author fuji
 */
public class postorderIterator implements CustomIterator{
    private Node iter;

    public postorderIterator(Node node) {
        iter = Node.iterateUp(node);
        iter = Node.iterateLeft(iter);
        while (iter.getRight() != null){
            iter = Node.iterateLeft(iter.getRight());
        }
       // System.out.println("it is " + iter.getContents());
    }
 

    @Override
    public boolean hasNext(){
        return iter != null;
    }
   

    @Override
    public int next(){
        int val = iter.getContents();
        if (iter.getParent() == null){
            iter = null;
            return val;
        }
        
        if(iter.getParent().getLeft() != null && iter.getParent().getRight() != null && iter.getParent().getLeft() == iter){
            iter = iter.getParent().getRight();
            iter = Node.iterateLeft(iter);
            while (iter.getRight() != null){
                iter = Node.iterateLeft(iter.getRight());
            }
            return val;
        }else if (iter.getParent().getLeft() != null && iter.getParent().getRight() != null && iter.getParent().getRight() == iter){
            iter = iter.getParent();
            return val;
        }
        if(iter.getParent().getRight() == null){
            if (iter.getParent() == null){
                iter = null;
                return val;
            }
            iter = iter.getParent();
            return val;
        }
        if (iter.getLeft() != null && iter.getRight() != null){
           
            iter= iter.getParent();
            return val;
        }
        if (iter.getLeft() == null){
            iter = iter.getParent();
            return val;
        }
        if (iter.getLeft() != null){
            iter = iter.getParent();
            return val;
        }
        return val;
     }
 }
