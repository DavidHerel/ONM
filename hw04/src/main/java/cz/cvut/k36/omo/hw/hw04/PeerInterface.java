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
/**
 * Instance implementujici PeerInterface reprezentuje lokalni uzel nebo uzel
 * pripojeny pres sit.
 */
public interface PeerInterface {
    /**
     * Sdeli vzdalenemu uzlu, ze uzel sender prave obdrzel blok s indexem
     * blockIndex.
     */
    public void have(PeerInterface sender, int blockIndex);
 
    /**
     * Pozada vzdaleny uzel o blok s indexem blockIndex.
     */
    public void request(PeerInterface sender, int blockIndex);
 
    /**
     * Zasle vzdalenemu uzlu blok s indexem blockIndex.
     */
    public void piece(PeerInterface sender, int blockIndex, byte[] data);
}
