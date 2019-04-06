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
public class PieceMessage extends Message {
    final int blockIndex;
    final byte[] data;
 
    public PieceMessage(int blockIndex, byte[] data, PeerInterface sender) {
        super(sender);
        this.blockIndex = blockIndex;
        this.data = data;
    }
 
    public int getBlockIndex()
    {
        return blockIndex;
    }
 
    public byte[] getData()
    {
        return data;
    }
 
    public boolean accept(MessageVisitor visitor) {
        return visitor.visitPieceMessage(this);
    }
}
