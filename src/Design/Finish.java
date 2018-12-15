
package Design;

import model.Sel;
import java.awt.Image;
import java.net.URL;
import javax.swing.ImageIcon;

public class Finish extends Sel {

    public Finish(int x, int y) {
        super(x,y);
        
        URL loc = this.getClass().getResource("finish2.jpg");
        ImageIcon g = new ImageIcon(loc);
        Image image = g.getImage();
        this.setImage(image);
    }
}
