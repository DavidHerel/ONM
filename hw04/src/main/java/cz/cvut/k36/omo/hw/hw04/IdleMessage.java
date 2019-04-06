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
public class IdleMessage extends Message {
    public IdleMessage(PeerInterface sender) {
        super(sender);
    }
 
    @Override
    public boolean accept(MessageVisitor visitor) {
        return visitor.visitIdleMessage(this);
    }
}