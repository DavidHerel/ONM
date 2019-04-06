/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.hw.hw04;

import java.util.Map;

/**
 * WTF? Zakomentuji vse a porad build fail
 * @author fuji
 */
public class Homework4 extends MessageVisitor {

    public Homework4(Peer peer) {
        super(peer);
    }

    /*
    * Mark that this uzel have block with index
    **jsem dement > ukladam do temp ktery mi zanikne..musim zmenit v peer
    */
    @Override
    public boolean visitHaveMessage(HaveMessage message) {
        boolean[] temp;
        /*temp = peer.peers2BlocksMap.get(message.sender);
        //
        temp[message.blockIndex] = true;*/
        peer.peers2BlocksMap.get(message.getSender())[message.getBlockIndex()] = true;
        return false;
    }

    
    /*
    * If this block has block in request -> send it
    * else ignore
    */
    @Override
    public boolean visitRequestMessage(RequestMessage message) {
        if (this.peer.data[message.getBlockIndex()] != null){
            message.getSender().piece(this.peer, message.getBlockIndex(), this.peer.data[message.getBlockIndex()]);
        }
        return false;
    }

    
    /*
    * store datas from message into uzel, increase downloadedblock by 1
    * send message to all other uzels
    * if downloaded == now true
    * else false 
    */
    @Override
    public boolean visitPieceMessage(PieceMessage message) {
       
        this.peer.data[message.getBlockIndex()] = message.getData();
        this.peer.downloadedBlocksCount++;
        /*Functional operation can be  used -> hint from ide
        * maybe it saves some lines of code, but i am not sure if i understand it properly
        peer.peers2BlocksMap.entrySet().stream().map((temp) -> temp.getKey()).forEachOrdered((send) -> {
            send.have(peer, message.blockIndex);
        });
        * lets keep old good for loop
        */ 
        for (Map.Entry<PeerInterface, boolean[]> temp : peer.peers2BlocksMap.entrySet()){
            PeerInterface send = temp.getKey();
            //send them that i have a packet
            send.have(peer, message.getBlockIndex());
        }
        
        //redundant - > another hint from ide to short it like this   
        return peer.totalBlocksCount == peer.downloadedBlocksCount;
    }
    
    
    /*
    * receives message - > takes rerest undownloaded block
    * and rqeust it from some other uzels
    * The most rerest one is one which is owned by least uzels
    * If there are more of them - > take random
    * uzel = node
    */
    @Override
    public boolean visitIdleMessage(IdleMessage message) {
        //initialize varibles to use in for loop
        // do it now to not take too much memory
        PeerInterface currNode;
        int currOwners;
        
        PeerInterface finalPeer = null;  
        
        //variable to find block with lowest owners
        int minimumOwners = Integer.MAX_VALUE;
        
        //index of requested node
        int nodeIndex = Integer.MIN_VALUE;;
        
        for(int i = 0; i <= peer.data.length-1; i++){
            
            //if undownloaded
            if (peer.data[i] == null) {
                currNode = null;
                currOwners = 0;
                
                for (Map.Entry<PeerInterface, boolean[]> temp: peer.peers2BlocksMap.entrySet()){
                    
                    //if block is avaliable - > raise currOwners, stores currNode
                    if (temp.getValue()[i]){
                        
                            currOwners+=1;
                            
                            //to avoid repeat overwrite currNode
                            if(currNode == null){
                                currNode = temp.getKey();                                
                            }
                    }
                }
                
                //at this  point we should filter
                if(currNode != null && currOwners < minimumOwners){
                    minimumOwners = currOwners;
                    nodeIndex = i;  
                    finalPeer = currNode;
                }
            }
        }
        
        //at this point all is filtered - > always return false
        if(finalPeer != null && nodeIndex >= 0){
            finalPeer.request(peer, nodeIndex);        
            return false;
        } else{
            return false;
        }
    }
    
}
