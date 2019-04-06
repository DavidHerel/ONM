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
public class preorderIterator implements CustomIterator{
    private Node iter;

    public preorderIterator(Node node) {
        iter = node;
                /*Node.iterateUp(node);
        while (iter.getRight() != null && iter.getLeft() != null){
            iter = Node.iterateRight(iter);
            iter = Node.iterateLeft(iter);
        }
       // System.out.println("iter je " + iter.getContents());*/
        iter.setEnd(1);
        //iter = Node.iterateUp(iter);
        
    }
    
    @Override
    public boolean hasNext() {
        return iter != null;
    }

    @Override
    public int next(){
        int val = iter.getContents();
        
        if (iter.getLeft() != null && iter.getLeft() != null){
            iter = iter.getLeft();
            return val;
        }else if (iter.getRight() != null && iter.getLeft() == null){
            //System.out.println("iter = "+ r);
            iter = iter.getRight();
            return val;
        } else{
            //int i = 0;
            while (iter != null){
               // i++;
               // System.out.println(iter.getContents()+"ted");
               if (iter.getEnd() == 1){
                 
                        iter = null;
                        return val;
                }
               if (iter.getParent() == null && iter.getRight() != null){
              
                    if (iter.getEnd() == 1){
   
                        iter = null;
                        return val;
                    }
                    iter = iter.getRight();
                    return val;
                }else if (iter.getParent().getLeft() == iter){
                    if (iter.getParent().getRight() != null){
                        iter = iter.getParent().getRight();
                        return val;
                    }else{
                        iter = iter.getParent();
                    }
                    
                }
                
                iter = iter.getParent();
            }
        }
        return val;
     }

    
}
