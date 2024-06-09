import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class selectionPanel extends JPanel {
    private jester jest;
    private CardLayout cardLayout;
    private JPanel mainPanel;
    public imagepane imgPane2x2, imgPane4x4, imgPane6x6, imgPane8x8;

    selectionPanel(CardLayout cardLayout, JPanel mainPanel) {
        jest  =new jester();
        this.cardLayout = cardLayout;
        this.mainPanel = mainPanel;
        
        this.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        JButton btn2x2 = new JButton("2x2");
        JButton btn4x4 = new JButton("4x4");
        JButton btn6x6 = new JButton("6x6");
        JButton btn8x8 = new JButton("8x8");

        Dimension buttonSize = new Dimension(100, 100);
        btn2x2.setPreferredSize(buttonSize);
        btn4x4.setPreferredSize(buttonSize);
        btn6x6.setPreferredSize(buttonSize);
        btn8x8.setPreferredSize(buttonSize);

        gbc.insets = new Insets(10, 10, 10, 10); // Adds some space around the buttons

        // Position each button in the 2x2 grid
        gbc.gridx = 0;
        gbc.gridy = 0;
        this.add(btn2x2, gbc);

        gbc.gridx = 1;
        gbc.gridy = 0;
        this.add(btn4x4, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        this.add(btn6x6, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        this.add(btn8x8, gbc);
         // Add action listeners to the buttons
         btn2x2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "2x2");
                imgPane2x2.inti();
            }
        });

        btn4x4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "4x4");
                imgPane4x4.inti();
            }
        });

        btn6x6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "6x6");
                imgPane6x6.inti();
            }
        });

        btn8x8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                cardLayout.show(mainPanel, "8x8");
                imgPane8x8.inti();
            }
        });
    }
    
}
