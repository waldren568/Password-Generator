import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.AdjustmentEvent;
import java.awt.event.AdjustmentListener;
import java.util.Random;

public class Gui extends JFrame {

    JScrollBar choosePassLength;

    JLabel sbValueLbl;

    private int sbValue;

    Random rand = new Random();


    // Array password
    char passArray[] = {
            'a', 'b', 'c', 'd', 'e', 'f', 'g','h', 'i', 'j', 'k', 'l', 'm', 'n', 'o', 'p', 'q','r', 's', 't', 'u', 'v', 'w', 'z', '-', '?'
    };

    public Gui(){

        super("Generate Random Password");

        setSize(500, 450);

        setLayout(new GridLayout(4, 1, 0, 70));

        setLocationRelativeTo(null);

        setDefaultCloseOperation(EXIT_ON_CLOSE);

        addGuiComponents();
    }

    private void addGuiComponents(){

        // Choose password length
        choosePassLength = new JScrollBar(Adjustable.HORIZONTAL);
        choosePassLength.setValue(2);
        choosePassLength.setMinimum(2);
        choosePassLength.setMaximum(110);
        choosePassLength.addAdjustmentListener(new AdjustmentListener() {
            @Override
            public void adjustmentValueChanged(AdjustmentEvent e) {
                sbValueLbl.setText("Number of characters: " + (choosePassLength.getValue()));
                sbValue = choosePassLength.getValue();
            }
        });
        add(choosePassLength);
        sbValue = choosePassLength.getValue();

        // Value of scrollbar label
        sbValueLbl = new JLabel("Number of characters: " + sbValue);
        sbValueLbl.setHorizontalAlignment(SwingConstants.CENTER);
        sbValueLbl.setFont(new Font("Dialog", Font.BOLD, 24));
        add(sbValueLbl);

        // Generate password button
        JButton generatePasswordBtn = new JButton("Generate Password");
        generatePasswordBtn.setFont(new Font("Dialog", Font.BOLD, 24));
        add(generatePasswordBtn);

        // Textfield password
        JTextArea passwordGenerated = new JTextArea("Password: ", 1, 20);
        passwordGenerated.setEditable(false);
        passwordGenerated.setFont(new Font("Dialog", Font.BOLD, 24));
        add(passwordGenerated);

        generatePasswordBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(e.getSource().equals(generatePasswordBtn)){
                    if(sbValue == 0){
                        JOptionPane.showMessageDialog(null, "Please enter a value");
                    } else{
                        passwordGenerated.setText("Password: ");
                        for(int i = 0; i <= sbValue; i++){
                            int n = rand.nextInt(passArray.length);
                            passwordGenerated.append("" + passArray[n]);
                        }
                    }
                }
            }
        });

        // ScrollBar
        JScrollPane SP = new JScrollPane(passwordGenerated);
        add(SP);
    }
}