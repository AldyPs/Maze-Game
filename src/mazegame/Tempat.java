/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mazegame;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Aldy
 */
public class Tempat {
    private ArrayList<Sel>isi = new <Sel>ArrayList();
    private int tinggi;
    private int lebar;

    public int getTinggi() {
        return tinggi;
    }

    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

    public int getLebar() {
        return lebar;
    }

    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    public Tempat() {
    }

    public Tempat(int tinggi, int lebar) {
        this.tinggi = tinggi;
        this.lebar = lebar;
    }
    
    public void bacaConfiguration(File file){
        try{
            FileInputStream fis = new FileInputStream(file);
            
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public void simpanConfiguration(File file){
        try{
            FileOutputStream fos = new FileOutputStream(file);
            String hasil = " ";
            char data;
            for (int i = 0; i < isi.size(); i++) {
                
            }
        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void maju(int langkah){
        
    }
    
    private Sel cariPemain(){
        for (int i = 0; i < isi.size(); i++) {
            if (isi.get(i).IsPemain()) {
                return isi.get(i);
            }
        }
        return null;
    }
}
