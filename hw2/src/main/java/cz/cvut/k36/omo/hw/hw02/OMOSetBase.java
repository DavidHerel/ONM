/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cz.cvut.k36.omo.hw.hw02;

/**
 *
 * @author fuji
 */
public abstract class OMOSetBase implements OMOSetView {
    public abstract void add(int element); //přidá prvek "element" do množiny
    public abstract void remove(int element); //odebere prvek "element" z množiny
}
