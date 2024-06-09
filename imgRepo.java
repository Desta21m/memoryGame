import java.awt.Image;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.swing.ImageIcon;

public class imgRepo {
    ArrayList<ImageIcon> icons = new ArrayList<ImageIcon>();
    int ox=0;
    imgRepo(){
        icons.add(new ImageIcon("image/aliii.jpg"));
        icons.add(new ImageIcon("image/anbasa.jpg"));
        icons.add(new ImageIcon("image/antishark.jpg"));
        icons.add(new ImageIcon("image/ayti.jpg"));
        icons.add(new ImageIcon("image/bardi3.jpg"));
        icons.add(new ImageIcon("image/barid1.jpg"));
        icons.add(new ImageIcon("image/cangaro.jpg"));
        icons.add(new ImageIcon("image/dimate.jpg"));
        icons.add(new ImageIcon("image/doro.jpg"));
        icons.add(new ImageIcon("image/esisist.jpg"));
        icons.add(new ImageIcon("image/fiyal.jpg"));
        icons.add(new ImageIcon("image/gemal2.jpg"));
        icons.add(new ImageIcon("image/goshi.jpg"));
        icons.add(new ImageIcon("image/gugut.jpg"));
        icons.add(new ImageIcon("image/gumara.jpg"));
        icons.add(new ImageIcon("image/kabaro.jpg"));
        icons.add(new ImageIcon("image/kachina.jpg"));
        icons.add(new ImageIcon("image/karkaro.jpg"));
        icons.add(new ImageIcon("image/nabri.jpg"));
        icons.add(new ImageIcon("image/no.jpg"));
        icons.add(new ImageIcon("image/no3.jpg"));
        icons.add(new ImageIcon("image/nsiir.jpg"));
        icons.add(new ImageIcon("image/panda.jpg"));
        icons.add(new ImageIcon("image/picok.jpg"));
        icons.add(new ImageIcon("image/picok2.jpg"));
        icons.add(new ImageIcon("image/pii.jpg"));
        icons.add(new ImageIcon("image/rgib.jpg"));
        icons.add(new ImageIcon("image/takula.jpg"));
        icons.add(new ImageIcon("image/tinchal.jpg"));
        icons.add(new ImageIcon("image/wisha.jpg"));
        icons.add(new ImageIcon("image/yabag gilgali.jpg"));
        icons.add(new ImageIcon("image/yamida fiyal.jpg"));
        icons.add(new ImageIcon("image/zebra.jpg"));
        icons.add(new ImageIcon("image/zehon.jpg"));
        icons.add(new ImageIcon("image/zenjoro.jpg"));


    }
    public ArrayList<Pimage> pairedArray(int size) {
        // Ensure size is even for pairing
        if (size % 2 != 0) {
            throw new IllegalArgumentException("Size must be even for pairing.");
        }

        ArrayList<Pimage> images = new ArrayList<>(size);

        // Create Pimage objects and add to the list
        for (int i = 0; i < size; i++) {
            Pimage pm = new Pimage();
            pm.setIssetted(false);
            images.add(pm);
        }

        // Shuffle indices to ensure randomness
        ArrayList<Integer> indices = new ArrayList<>();
        for (int i = 0; i < size; i++) {
            indices.add(i);
        }
        Collections.shuffle(indices);

        ArrayList<Integer> indicess = new ArrayList<>();
        for (int i = 0; i < 35; i++) {
            indicess.add(i);
        }
         Collections.shuffle(indicess);


        for (int i = 0; i < size; i += 2) {

            ImageIcon icon = icons.get(indicess.get(ox));

            int index1 = indices.get(i);
            int index2 = indices.get(i + 1);

            // Set the same ImageIcon to both Pimage objects
            Pimage image1 = images.get(index1);
            image1.setPic(icon);
            image1.setIssetted(true);
            image1.setId(ox);
            image1.setIdentity(index1);
            images.set(index1, image1);

            Pimage image2 = images.get(index2);
            image2.setPic(icon);
            image2.setId(ox);
            image2.setIdentity(index2);
            image2.setIssetted(true);
            images.set(index2, image2);
            ox++;
        }

        return images;
    }
    
}
