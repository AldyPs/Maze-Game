/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

/**
 *
 * @author Aldy
 */
public class Sel {
    private char nilai;
    private int posisiX;
    private int posisiY;

    public Sel() {
    }

    public Sel(char nilai, int posisiX, int posisiY) {
        this.nilai = nilai;
        this.posisiX = posisiX;
        this.posisiY = posisiY;
    }
    
    public boolean IsPemain(){
        return false;
    }
    
    public boolean IsHambatan(){
        return false;
    }
}
