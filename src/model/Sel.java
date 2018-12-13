/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.awt.Color;

/**
 *
 * @author user only
 */
public class Sel {

    private int baris;
    private int kolom;
    private int lebar;
    private int tinggi;
    private char nilai;
    private Color warna;
    public Sel() {
    }

    public Sel(int baris, int kolom, char nilai) {
        this.baris = baris;
        this.kolom = kolom;
        this.nilai = nilai;
    }

    public Sel(int baris, int kolom, char nilai, Color warna) {
        this.baris = baris;
        this.kolom = kolom;
        this.nilai = nilai;
        this.warna = warna;
    }

    public Sel(int baris, int kolom, int lebar, int tinggi, char nilai, Color warna) {
        this.baris = baris;
        this.kolom = kolom;
        this.lebar = lebar;
        this.tinggi = tinggi;
        this.nilai = nilai;
        this.warna = warna;
    }

    /**
     * Fungsi mengecek sel ada di batas kiri
     *
     * @return
     */
    public boolean isBatasKiri() {
        return kolom * lebar <= 0;

    }

    /**
     * Fungsi ceking sel ada di batas kanan
     *
     * @return
     */
    public boolean isBatasKanan() {
        return kolom * lebar + lebar >= Tempat.batasKanan;
    }

    /**
     * Fungsi untuk mengecek sel ada di batas atas
     * @return 
     */
    public boolean isBatasAtas() {
        return baris * lebar <= 0;
    }

    /**
     * Fungsi untuk mengecek sel ada di batas bawah
     * @return 
     */
    public boolean isBatasBawah() {
        return baris * lebar + lebar >= Tempat.batasKanan;
    }
    
    /**
     * Fungsi untuk menggeser sel ke kanan
     */
   public void geserKanan(int x) {
        if (isBatasKanan() == false) {
            this.setKolom(kolom += x);
        }
    }

    /**
     * Fungsi untuk menggeser sel ke kiri
     */
    public void geserKiri(int x) {
        if (isBatasKiri() == false) {
            this.setKolom(kolom -= x);
        }
    }

    /**
     * Fungsi untuk menggeser sel ke atas
     */
    public void geserAtas(int x) {
        if (isBatasAtas() == false) {
            this.setBaris(baris -= x);
        }
    }

    /**
     * Fungsi untuk menggeser sel ke bawah
     */
    public void geserBawah(int x) {
        if (isBatasBawah() == false) {
            this.setBaris(baris += x);
        }
    }

    /**
     * @return the baris
     */
    public int getBaris() {
        return baris;
    }

    /**
     * @param baris the baris to set
     */
    public void setBaris(int baris) {
        this.baris = baris;
    }

    /**
     * @return the kolom
     */
    public int getKolom() {
        return kolom;
    }

    /**
     * @param kolom the kolom to set
     */
    public void setKolom(int kolom) {
        this.kolom = kolom;
    }

    /**
     * @return the nilai
     */
    public char getNilai() {
        return nilai;
    }

    /**
     * @param nilai the nilai to set
     */
    public void setNilai(char nilai) {
        this.nilai = nilai;
    }

    /**
     * @return the warna
     */
    public Color getWarna() {
        return warna;
    }

    /**
     * @param warna the warna to set
     */
    public void setWarna(Color warna) {
        this.warna = warna;
    }

    /**
     * @return the lebar
     */
    public int getLebar() {
        return lebar;
    }

    /**
     * @param lebar the lebar to set
     */
    public void setLebar(int lebar) {
        this.lebar = lebar;
    }

    /**
     * @return the tinggi
     */
    public int getTinggi() {
        return tinggi;
    }

    /**
     * @param tinggi the tinggi to set
     */
    public void setTinggi(int tinggi) {
        this.tinggi = tinggi;
    }

}
