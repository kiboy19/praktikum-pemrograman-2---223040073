import java.awt.event.*;
import javax.swing.*;

public class HelloRadioButton extends JFrame {

    public HelloRadioButton() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelInput = new JLabel("Nama:");
        labelInput.setBounds(15, 40, 350, 10);

        JTextField textField = new JTextField();
        textField.setBounds(15, 60, 350, 30);

        JLabel labelRadio = new JLabel("Jenis Member:");
        // Geser posisi label Radio lebih ke bawah agar tidak tertutup
        labelRadio.setBounds(15, 110, 350, 30);

        JRadioButton radioButton1 = new JRadioButton("Silver", true);
        radioButton1.setBounds(15, 140, 350, 30);

        JRadioButton radioButton2 = new JRadioButton("Gold");
        radioButton2.setBounds(15, 170, 350, 30);

        JRadioButton radioButton3 = new JRadioButton("Platinum");
        radioButton3.setBounds(15, 200, 350, 30);

        // Adding radio buttons
        this.add(radioButton1);
        this.add(radioButton2);
        this.add(radioButton3);

        // ButtonGroup to ensure only one radio button is selected at a time
        ButtonGroup bg = new ButtonGroup();
        bg.add(radioButton1);
        bg.add(radioButton2);
        bg.add(radioButton3);

        JButton button = new JButton("Simpan");
        // Geser posisi tombol Simpan sedikit lebih ke bawah
        button.setBounds(15, 240, 350, 40);

        JTextArea textOutput = new JTextArea("");
        textOutput.setBounds(15, 290, 350, 100);

        // ActionListener for button
        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String jenisMember = "";
                if (radioButton1.isSelected()) {
                    jenisMember = radioButton1.getText();
                }
                if (radioButton2.isSelected()) {
                    jenisMember = radioButton2.getText();
                }
                if (radioButton3.isSelected()) {
                    jenisMember = radioButton3.getText();
                }

                String nama = textField.getText();
                textOutput.append("Hello " + nama + "\n");
                textOutput.append("Anda adalah member " + jenisMember + "\n");
                textField.setText("");
            }
        });

        // Adding components to frame
        this.add(button);
        this.add(textField);
        this.add(labelRadio);
        this.add(labelInput);
        this.add(textOutput);

        this.setSize(400, 450);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                HelloRadioButton h = new HelloRadioButton();
                h.setVisible(true);
            }
        });
    }
}
