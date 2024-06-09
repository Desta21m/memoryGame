import java.awt.CardLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class jester {
    private imagepane imgFiled;
    private JPanel gameFiled;
    private  selectionPanel selectionPanel;
    private JFrame frame;
    private mouseclickedEE LI;

    public void start(){
        JFrame frame = new JFrame("Selection Panel Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(2200, 1200);

        CardLayout cardLayout = new CardLayout();
        JPanel mainPanel = new JPanel(cardLayout);

        // Add the selection panel and other panels for different grid sizes
        selectionPanel = new selectionPanel(cardLayout, mainPanel);
        mainPanel.add(selectionPanel, "Selection");

        imagepane imgPane2x2i = new imagepane(2);
        imagepane imgPane4x4i = new imagepane(4);
        imagepane imgPane6x6i = new imagepane(6);
        imagepane imgPane8x8i = new imagepane(8);

        mainPanel.add(imgPane2x2i, "2x2");
        mainPanel.add(imgPane4x4i, "4x4");
        mainPanel.add(imgPane6x6i, "6x6");
        mainPanel.add(imgPane8x8i, "8x8");

        selectionPanel.imgPane2x2= imgPane2x2i;
        selectionPanel.imgPane4x4=imgPane4x4i;
        selectionPanel.imgPane6x6=imgPane6x6i;
        selectionPanel.imgPane8x8=imgPane8x8i;

        frame.add(mainPanel);
        frame.setLocationRelativeTo(null); // Center the frame on the screen
        frame.setVisible(true);

        // Show the selection panel initially
        cardLayout.show(mainPanel, "Selection");
       

    }
    public void updatescore(){

    }

}
