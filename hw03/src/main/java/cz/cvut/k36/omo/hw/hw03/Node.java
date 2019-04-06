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
public class Node {
    private final int contents;
    private final Node left, right;
    private Node parent;
    public int end;

    public int getEnd() {
        return end;
    }

    public void setEnd(int end) {
        this.end = end;
    }
 
    public Node(int contents, Node left, Node right) {
        this.contents = contents;
        this.left = left;
        if (left != null) left.parent = this;
        this.right = right;
        if (right != null) right.parent = this;
        end = 0;
    }

    public int getContents() {
        return contents;
    }

    public Node getLeft() {
        return left;
    }

    public Node getRight() {
        return right;
    }

    public Node getParent() {
        return parent;
    }
    
    public static Node iterateUp(Node node) {
        while (node.getParent() != null){
            node = node.getParent();
        }
        return node;
    }
    
    public static Node iterateLeft(Node node){
        while (node.getLeft() != null){
            node = node.getLeft();
        }
        return node;
    }
    
    public static Node iterateRight(Node node){
        while (node.getRight() != null){
            node = node.getRight();
        }
        return node;
    }
    
    public CustomIterator preorderIterator(){
        return new preorderIterator(this);
    }
    
    public CustomIterator inorderIterator(){
        return new inorderIterator(this);
    }
    
    public CustomIterator postorderIterator(){
        return new postorderIterator(this);
    }
    
}
