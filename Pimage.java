import java.awt.Image;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class Pimage   {
    int id;
    int identity;
    JLabel mageLabels;
    ImageIcon pic;
    boolean issetted;
    ImageIcon hiddIcon;

    public int getIdentity() {
        return identity;
    }
    public void setIdentity(int identity) {
        this.identity = identity;
    }


    public boolean isIssetted() {
        return issetted;
    }
   public ImageIcon getPic() {
    return pic;
}
public ImageIcon getHiddIcon() {
    return hiddIcon;
}
public void setHiddIcon(ImageIcon hiddIcon) {
    this.hiddIcon = hiddIcon;
}
 public void setIssetted(boolean issetted) {
        this.issetted = issetted;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public ImageIcon getPic(int x) {
        Image squareImage1 = pic.getImage().getScaledInstance(x, x, Image.SCALE_SMOOTH);
        ImageIcon squareImageIcon1 = new ImageIcon(squareImage1);
        return squareImageIcon1;
    }
    public void setPic(ImageIcon pic) {
        this.pic = pic;
    }
    
}
