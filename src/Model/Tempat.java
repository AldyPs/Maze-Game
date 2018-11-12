/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Model;

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

    private int tinggi; // tinggi tempat Game
    private int lebar;  // lebar tempat Game
    private ArrayList<Sel> daftarSel; // daftar sel

    private ArrayList<Sel> isi = new ArrayList<>();// isi file konfigurasi

    public static int batasKanan;
    public static int batasBawah;

    public static int getBatasKanan() {
        return batasKanan;
    }

    public static void setBatasKanan(int batasKanan) {
        Tempat.batasKanan = batasKanan;
    }

    public static int getBatasBawah() {
        return batasBawah;
    }

    public static void setBatasBawah(int batasBawah) {
        Tempat.batasBawah = batasBawah;
    }

    public Tempat() {
        daftarSel = new ArrayList<Sel>();
    }

    /**
     * Fungsi pembaca file konfigurasi. Hasil pembacaan file akan disimpan di
     * atribut 'isi' dan juga di atribut daftarSel
     *
     * @param file
     */
    public void bacaKonfigurasi(File file) {
        try {
            FileInputStream fis = new FileInputStream(file);

        } catch (FileNotFoundException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Fungsi penambah daftar sel.
     *
     * @param sel
     */
    public void tambahSel(Sel sel) {
        daftarSel.add(sel);
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
     * @return the daftarSel
     */
    public ArrayList<Sel> getDaftarSel() {
        return daftarSel;
    }

    /**
     * @param daftarSel the daftarSel to set
     */
    public void setDaftarSel(ArrayList<Sel> daftarSel) {
        this.daftarSel = daftarSel;
    }

    /**
     * @return the isi
     */
    public ArrayList<Sel> getIsi() {
        return isi;
    }

    /**
     * @param isi the isi to set
     */
    public void setIsi(ArrayList<Sel> isi) {
        this.isi = isi;
    }

    public Sel cariPemain() {
        for (int i = 0; i < isi.size(); i++) {
            if (isi.get(i).isPemain()) {
                return isi.get(i);
            }
        }
        return null;
    }
}
