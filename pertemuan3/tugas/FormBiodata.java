import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormBiodata extends JFrame {
    private JTextField namaField, nomorHPField;
    private JRadioButton lakiLakiButton, perempuanButton;
    private JCheckBox wnaCheckBox;

    public FormBiodata() {
        setTitle("Form Biodata");
        setSize(600, 500);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridBagLayout());  // Menggunakan GridBagLayout
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);  // Margin antar komponen

        // Label Header
        JLabel headerLabel = new JLabel("Form Biodata");
        headerLabel.setFont(new Font("Arial", Font.BOLD, 16));
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(headerLabel, gbc);

        // Nama
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Nama:"), gbc);

        namaField = new JTextField(5);
        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(namaField, gbc);

        // Nomor HP
        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Nomor HP:"), gbc);

        nomorHPField = new JTextField(5);
        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        add(nomorHPField, gbc);

        // Jenis Kelamin
        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        add(new JLabel("Jenis Kelamin:"), gbc);

        JPanel genderPanel = new JPanel(new FlowLayout(FlowLayout.LEFT, 0, 0));
        lakiLakiButton = new JRadioButton("Laki-Laki");
        perempuanButton = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(lakiLakiButton);
        genderGroup.add(perempuanButton);
        genderPanel.add(lakiLakiButton);
        genderPanel.add(perempuanButton);

        gbc.gridx = 1;
        gbc.gridy = 3;
        gbc.anchor = GridBagConstraints.WEST;
        add(genderPanel, gbc);

        // Warga Negara Asing
        wnaCheckBox = new JCheckBox("Warga Negara Asing");
        gbc.gridx = 1;
        gbc.gridy = 4;
        gbc.anchor = GridBagConstraints.WEST;
        add(wnaCheckBox, gbc);

        // Tombol Simpan
        JButton simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanData();
            }
        });
        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        add(simpanButton, gbc);

        setVisible(true);
    }

    private void simpanData() {
        String nama = namaField.getText();
        String nomorHP = nomorHPField.getText();
        String jenisKelamin = lakiLakiButton.isSelected() ? "Laki-Laki" : "Perempuan";
        String wna = wnaCheckBox.isSelected() ? "Ya" : "Tidak";

        String result = "Nama: " + nama + "\n" +
                        "Nomor HP: " + nomorHP + "\n" +
                        "Jenis Kelamin: " + jenisKelamin + "\n" +
                        "Warga Negara Asing: " + wna;

        JOptionPane.showMessageDialog(this, result, "Hasil Form", JOptionPane.INFORMATION_MESSAGE);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(FormBiodata::new);
    }
}
