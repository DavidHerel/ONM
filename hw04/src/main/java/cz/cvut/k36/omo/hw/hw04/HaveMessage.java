/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.hw.hw04;

/**
 *
 * @author fuji
 */
 
public class HaveMessage extends Message {
    final int blockIndex;
 
    public HaveMessage(int blockIndex, PeerInterface sender) {
        super(sender);
        this.blockIndex = blockIndex;
    }
 
    public int getBlockIndex()
    {
        return blockIndex;
    }
 
    public boolean accept(MessageVisitor visitor) {
        return visitor.visitHaveMessage(this);
    }
}