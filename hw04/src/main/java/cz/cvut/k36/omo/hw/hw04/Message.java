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
public abstract class Message {
    final PeerInterface sender;
 
    public Message(PeerInterface sender) {
        this.sender = sender;
    }
 
    public PeerInterface getSender()
    {
        return sender;
    }
 
    public abstract boolean accept(MessageVisitor visitor);
}