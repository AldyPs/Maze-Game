/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Design;

import model.Sel;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

/**
 *
 * @author
 */
public class Dinding extends Sel {
    public Dinding(int x, int y) {
        super(x,y);
        
        URL loc = this.getClass().getResource("Dinding2.jpg");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
}
