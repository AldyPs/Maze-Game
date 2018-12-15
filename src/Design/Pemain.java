
package Design;

import model.Sel;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;


public class Pemain extends Sel {

     public Pemain(int x, int y){
        super(x,y);
        
        URL loc = this.getClass().getResource("Pemain2.jpg");
        ImageIcon iia = new ImageIcon(loc);
        Image image = iia.getImage();
        this.setImage(image);
    }
    public void Gerak(int x, int y){
        int nx = this.getPosisiX() + x;
        int ny = this.getPosisiY() + y;
        this.setPosisiX(nx);
        this.setPosisiY(ny);
    }
}
