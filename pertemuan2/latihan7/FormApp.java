import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormApp extends JFrame {
    private JTextField namaField, nomorHPField;
    private JRadioButton lakiLakiButton, perempuanButton;
    private JCheckBox wnaCheckBox;
    private JTextArea resultArea;

    public FormApp() {
        setTitle("Form Data Diri");
        setSize(400, 400);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(7, 1));

        // Panel untuk Nama
        JPanel panelNama = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel namaLabel = new JLabel("Nama:");
        namaField = new JTextField(20);
        panelNama.add(namaLabel);
        panelNama.add(namaField);
        add(panelNama);

        // Panel untuk Nomor HP
        JPanel panelNomorHP = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel nomorHPLabel = new JLabel("Nomor HP:");
        nomorHPField = new JTextField(20);
        panelNomorHP.add(nomorHPLabel);
        panelNomorHP.add(nomorHPField);
        add(panelNomorHP);

        // Panel untuk Jenis Kelamin
        JPanel panelJenisKelamin = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel jenisKelaminLabel = new JLabel("Jenis Kelamin:");
        lakiLakiButton = new JRadioButton("Laki-Laki");
        perempuanButton = new JRadioButton("Perempuan");
        ButtonGroup genderGroup = new ButtonGroup();
        genderGroup.add(lakiLakiButton);
        genderGroup.add(perempuanButton);
        panelJenisKelamin.add(jenisKelaminLabel);
        panelJenisKelamin.add(lakiLakiButton);
        panelJenisKelamin.add(perempuanButton);
        add(panelJenisKelamin);

        // Checkbox untuk Warga Negara Asing
        JPanel panelWNA = new JPanel(new FlowLayout(FlowLayout.LEFT));
        wnaCheckBox = new JCheckBox("Warga Negara Asing");
        panelWNA.add(wnaCheckBox);
        add(panelWNA);

        // Tombol Simpan
        JButton simpanButton = new JButton("Simpan");
        simpanButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                simpanData();
            }
        });
        JPanel panelButton = new JPanel(new FlowLayout(FlowLayout.CENTER));
        panelButton.add(simpanButton);
        add(panelButton);

        // Area untuk menampilkan hasil
        resultArea = new JTextArea(5, 30);
        resultArea.setEditable(false);
        add(new JScrollPane(resultArea));

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
                        "WNA: " + wna + "\n" +
                        "========================================\n";

        resultArea.setText(result);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormApp());
    }
}
