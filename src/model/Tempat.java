package model;

import model.Sel;
import java.awt.Color;
import java.awt.Graphics;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import Design.Finish;
import Design.Pemain;
import Design.Dinding;

public class Tempat extends JPanel {

    private ArrayList dinding = new ArrayList();
    private ArrayList peta = new ArrayList();
    private Finish finish;
    private Pemain pemain;
    private int lebar = 0;
    private int tinggi = 0;
    private int jarak = 41;
    private LinkedList<String> undo = new LinkedList<>();
    private File Alamatpeta;
    private ArrayList semuaPerintah = new ArrayList();
    private boolean completed = false;

    public Tempat(File file) {
        setPeta(file);
    }

    public void setPeta(File file) {
        try {
            if (file != null) {
                FileInputStream input = new FileInputStream(file);
                Alamatpeta = file;
                int posisiX = 0;
                int posisiY = 0;
                Dinding wall;
                Finish a;
                int data;
                while ((data = input.read()) != -1) {
                    char item = (char) data;
                    if (item == '\n') {
                        posisiY += jarak;
                        lebar = posisiX;
                        posisiX = 0;
                    } else if (item == '#') {
                        wall = new Dinding(posisiX, posisiY);
                        dinding.add(wall);
                        posisiX += jarak;
                    } else if (item == 'o') {
                        a = new Finish(posisiX, posisiY);
                        finish = new Finish(posisiX, posisiY);
                        posisiX += jarak;
                    } else if (item == '@') {
                        pemain = new Pemain(posisiX, posisiY);
                        posisiX += jarak;
                    } else if (item == '.') {
                        posisiX += jarak;
                    }
                    tinggi = posisiY;
                }
            }

        } catch (IOException ex) {
            Logger.getLogger(Tempat.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.setColor(new Color(255, 255, 255));
        g.fillRect(0, 0, this.getLebar(), this.getTinggi());
        peta.addAll(dinding);
        peta.add(finish);
        peta.add(pemain);
        for (int i = 0; i < peta.size(); i++) {
            if (peta.get(i) != null) {
                Sel item = (Sel) peta.get(i);
                g.drawImage(item.getImage(), item.getPosisiX(), item.getPosisiY(), this);
            }
        }
    }

    public int getLebar() {
        return this.lebar;
    }

    public int getTinggi() {
        return this.tinggi;
    }

    public void PerintahGerak(String input) {
        String in[] = input.split("");
        if (in[0].equalsIgnoreCase("z") && in[1].matches("[123456789]")) {
            semuaPerintah.add(input);
            if (!undo.isEmpty()) {
                for (int index = Integer.parseInt(String.valueOf(in[1])); index > 0; index--) {
                    String x = undo.removeLast();
                    String un[] = x.split("");
                    if (un[0].equalsIgnoreCase("u")) {
                        for (int i = 0; i < Integer.parseInt(String.valueOf(un[1])); i++) {
                            if (cekObjekNabrakDinding(pemain, "u")) {
                                return;
                            } else {
                                pemain.Gerak(0, jarak);
                                repaint();
                            }
                        }
                    } else if (un[0].equalsIgnoreCase("d")) {
                        for (int i = 0; i < Integer.parseInt(String.valueOf(un[1])); i++) {
                            if (cekObjekNabrakDinding(pemain, "d")) {
                                return;
                            } else {
                                pemain.Gerak(0, -jarak);
                                repaint();
                            }
                        }
                    } else if (un[0].equalsIgnoreCase("r")) {
                        for (int i = 0; i < Integer.parseInt(String.valueOf(un[1])); i++) {
                            if (cekObjekNabrakDinding(pemain, "r")) {
                                return;
                            } else {
                                pemain.Gerak(-jarak, 0);
                                repaint();
                            }
                        }
                    } else if (un[0].equalsIgnoreCase("l")) {
                        for (int i = 0; i < Integer.parseInt(String.valueOf(un[1])); i++) {
                            if (cekObjekNabrakDinding(pemain, "l")) {
                                return;
                            } else {
                                pemain.Gerak(jarak, 0);
                                repaint();
                            }
                        }
                    }
                }
            } else {
                JOptionPane.showMessageDialog(null, "perintah mencapai batas");
            }
        } else if (in[0].matches("[udrl]") && in[1].matches("[123456789]") && in.length == 2) {
            undo.addLast(input);
            semuaPerintah.add(input);
            if (in[0].equalsIgnoreCase("u")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (cekObjekNabrakDinding(pemain, "u")) {
                        return;
                    } else {
                        pemain.Gerak(0, -jarak);
                        isCompleted();
                        repaint();
                    }
                    if (completed) {
                        JOptionPane.showMessageDialog(this, "Winner");
                        System.exit(0);
                        break;
                    }

                }
            } else if (in[0].equalsIgnoreCase("d")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (cekObjekNabrakDinding(pemain, "d")) {
                        return;
                    } else {
                        pemain.Gerak(0, jarak);
                        isCompleted();
                        repaint();
                    }
                    if (completed) {
                        JOptionPane.showMessageDialog(this, "Winner");
                        System.exit(0);
                        break;
                    }
                }
            } else if (in[0].equalsIgnoreCase("r")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (cekObjekNabrakDinding(pemain, "r")) {
                        return;
                    } else {
                        pemain.Gerak(jarak, 0);
                        isCompleted();
                        repaint();
                    }
                    if (completed) {
                        JOptionPane.showMessageDialog(this, "Winner");
                        System.exit(0);
                        break;
                    }
                }
            } else if (in[0].equalsIgnoreCase("l")) {
                for (int i = 0; i < Integer.parseInt(String.valueOf(in[1])); i++) {
                    if (cekObjekNabrakDinding(pemain, "l")) {
                        return;
                    } else {
                        pemain.Gerak(-jarak, 0);
                        isCompleted();
                        repaint();
                    }
                    if (completed) {
                        JOptionPane.showMessageDialog(this, "Winner");
                        System.exit(0);
                        break;
                    }
                }
            }
        } else {
            JOptionPane.showMessageDialog(null, "Input Tidak Valid");
        }
    }

    private boolean cekObjekNabrakDinding(Sel pemain, String input) {
        boolean bantu = false;
        if (input.equalsIgnoreCase("l")) {
            for (int i = 0; i < dinding.size(); i++) {
                Dinding wall = (Dinding) dinding.get(i);
                if (pemain.PosisiKiriObjek(wall)) {
                    bantu = true;
                    break;
                }
            }

        } else if (input.equalsIgnoreCase("r")) {
            for (int i = 0; i < dinding.size(); i++) {
                Dinding wall = (Dinding) dinding.get(i);
                if (pemain.PosisiKananObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("u")) {
            for (int i = 0; i < dinding.size(); i++) {
                Dinding wall = (Dinding) dinding.get(i);
                if (pemain.PosisiAtasObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        } else if (input.equalsIgnoreCase("d")) {
            for (int i = 0; i < dinding.size(); i++) {
                Dinding wall = (Dinding) dinding.get(i);
                if (pemain.PosisiBawahObjek(wall)) {
                    bantu = true;
                    break;
                }
            }
        }
        return bantu;//default return false
    }

    public void isCompleted() {
if (pemain.getPosisiX() == finish.getPosisiX()) {
            if (pemain.getPosisiY() == finish.getPosisiY()) {
                completed = true;
            }
        }


    }

    public void restartLevel() {
        semuaPerintah.clear();
        dinding.clear();
        peta.clear();
        setPeta(Alamatpeta);//set
        repaint();//gambar ulang
    }

    public String getTeksPerintah() {
        String bantu = "";
        for (int i = 0; i < semuaPerintah.size(); i++) {
            bantu = bantu + semuaPerintah.get(i) + " ";
        }
        return bantu;
    }

    public int getPoin() {
        int bantu = semuaPerintah.size();
        if (bantu < 20) {
            JOptionPane.showMessageDialog(this, peta);
        }
        return bantu;
    }
}
