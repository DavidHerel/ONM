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
public class inorderIterator implements CustomIterator{
    private Node iter;

    public inorderIterator(Node node) {
        iter = Node.iterateLeft(node);
        System.out.println("parent"+iter.getParent());
    }
 

    @Override
    public boolean hasNext(){
        return iter != null;
    }
   

    @Override
    public int next(){
        int val = iter.getContents();

        
        if (iter.getRight() != null && iter.getLeft() == null){
            iter = Node.iterateLeft(iter.getRight());
            return val;
        }else if (iter.getRight() != null && iter.getLeft() != null){
            iter = Node.iterateLeft(iter.getRight());
            return val;
        } else{
            while (iter != null){
               if (iter.getParent() == null){
                    iter = null;
                    return val;
                }else if (iter.getParent().getLeft() == iter){
                    iter = iter.getParent();
                    return val;
                }
                
                iter = iter.getParent();
            }
        }
        return val;
     }
 }