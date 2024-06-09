import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.awt.event.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.Timer;

public class imagepane extends JPanel{
    ArrayList<Pimage> images;
    private List<JLabel> imageLabels = new ArrayList<>();
    Random random;
    GridBagConstraints c;
    boolean picked = false;
    int pickedCount = 0;
    imgRepo imR;
    int full;
    int m;
    imagepane(int xMatrix){
        this.setLayout(new GridBagLayout());
        c = new GridBagConstraints();
        imR= new imgRepo();
        this.m=xMatrix;
        full=xMatrix*xMatrix;
        c.insets = new Insets(5, 5, 5, 5);
      
    }
    public void inti(){
        
            addPairs();
            int tx=0;
            int ty=0;
        
        for(int j=0; j<full;j++){
            JLabel imageLabel1 = new JLabel(images.get(j).getPic(70));
            imageLabel1.setPreferredSize(new Dimension(70, 70));

            // Center the image in the label
            imageLabel1.setHorizontalAlignment(JLabel.CENTER);
            imageLabel1.setVerticalAlignment(JLabel.CENTER);

             // Add mouse listener to handle click events
             imageLabel1.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    JLabel clickedLabel = (JLabel) e.getSource();
                    handleLabelClick(clickedLabel);
                }
            });
            c.gridx=tx;
            c.gridy=ty;

            this.add(imageLabel1,c);
            imageLabels.add(imageLabel1);

            if(tx<m-1){
                tx++;
            }
            else{
                tx=0;
                ty++;
            }



        }
        Timer timer = new Timer(2000, e -> updateImages());
        timer.setRepeats(false); // Only execute once
        timer.start();
    }
    private void updateImages() {
        ImageIcon qq=new ImageIcon("image/qq.png");
        Image squareImage1 = qq.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon squareImageIcon1 = new ImageIcon(squareImage1);
        for (int i = 0; i < imageLabels.size(); i++) {
            // Assuming newImages has the new images to set
            imageLabels.get(i).setIcon(squareImageIcon1);
        }
        // Revalidate and repaint to ensure the UI updates
        this.revalidate();
        this.repaint();
    }
    private void updateImage(int x,int y) {
        ImageIcon qq=new ImageIcon("image/qq.png");
        Image squareImage1 = qq.getImage().getScaledInstance(70, 70, Image.SCALE_SMOOTH);
        ImageIcon squareImageIcon1 = new ImageIcon(squareImage1);
        
            // Assuming newImages has the new images to se
            imageLabels.get(x).setIcon(squareImageIcon1);
            imageLabels.get(y).setIcon(squareImageIcon1);
        // Revalidate and repaint to ensure the UI updates
        this.revalidate();
        this.repaint();
    }
    private void addPairs(){
          this.images = imR.pairedArray(full);
    }
    private void handleLabelClick(JLabel clickedLabel) {
        int index = imageLabels.indexOf(clickedLabel);
        if (index != -1) {
            // Handle the click event for the label at the given index
            System.out.println("Label at index " + index + " was clicked.");
            if(picked){
                Pimage pimage1 = images.get(index);
                Pimage pimage2 = images.get(pickedCount);
                if(pimage1.getId() == pimage2.getId()&& pimage1.getIdentity()!=pimage2.getIdentity()){
                    imageLabels.get(index).setIcon(images.get(index).getPic(70));
                }
                else {
                    imageLabels.get(index).setIcon(images.get(index).getPic(70));
                    Timer timer = new Timer(500, e -> updateImage(index,pickedCount));
                    timer.setRepeats(false); // Only execute once
                    timer.start();
                }
                picked=false;
            }
            else{
                imageLabels.get(index).setIcon(images.get(index).getPic(70));
                pickedCount=index;
                picked=true;

            }
            // Add your reaction or event handling logic here
        }
    }
}
