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
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        final long startTime = System.currentTimeMillis();

        Node node = new Node(1, new Node(2, null, new Node(4, null, new Node(5, new Node(6, null, null), new Node(7, new Node(8, null, null), null)))), new Node(3, null ,null));
        //Node node = new Node(13, new Node(39, new Node(84, new Node(98,null,null), new Node(71,null,null)),null),new Node(83, new Node(58, null,new Node(5,null,null)),new Node(28,null,null)));
        CustomIterator  node2 = node.postorderIterator();
        while (node2.hasNext()){
            System.out.println(node2.next());
        }
        final long endTime = System.currentTimeMillis();

        System.out.println("Total execution time: " + (endTime - startTime) );
        System.out.println("-----");
        postorder(node);
    }
    
    public static void inorder(Node node){
        if (node == null) return;
        inorder(node.getLeft());
        System.out.println(node.getContents());
        inorder(node.getRight());
    }
    
    public static void preorder(Node node){
        if (node == null) return;
        System.out.println(node.getContents());        
        preorder(node.getLeft());
        preorder(node.getRight());
    }
    
    public static void postorder(Node node){
        if (node == null) return;                
        postorder(node.getLeft());
        postorder(node.getRight());
        System.out.println(node.getContents());
    }
    
}
