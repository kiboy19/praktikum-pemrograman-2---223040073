import java.awt.event.*;
import javax.swing.*;

public class BiodataApp extends JFrame {

    public BiodataApp() {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JLabel labelName = new JLabel("Nama:");
        labelName.setBounds(50, 40, 100, 20);

        JTextField textName = new JTextField();
        textName.setBounds(150, 40, 200, 25);

        JLabel labelPhone = new JLabel("No. Telepon:");
        labelPhone.setBounds(50, 80, 100, 20);

        JTextField textPhone = new JTextField();
        textPhone.setBounds(150, 80, 200, 25);

        JButton button = new JButton("Tambah Biodata");
        button.setBounds(150, 120, 150, 30);

        JTextArea txtOutput = new JTextArea("");
        txtOutput.setBounds(50, 160, 300, 200);
        txtOutput.setEditable(false);

        button.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nama = textName.getText();
                String phone = textPhone.getText();

                txtOutput.append(nama + " - " + phone + "\n");

                textName.setText("");
                textPhone.setText("");
            }
        });

        this.add(button);
        this.add(textName);
        this.add(textPhone);
        this.add(labelName);
        this.add(labelPhone);
        this.add(txtOutput);

        this.setSize(400, 450);
        this.setLayout(null);
    }

    public static void main(String[] args) {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {
                BiodataApp app = new BiodataApp();
                app.setVisible(true);
            }
        });
    }
}
