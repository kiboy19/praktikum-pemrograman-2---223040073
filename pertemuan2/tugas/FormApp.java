import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class FormApp extends JFrame {
    private JTextField namaField, nomorHPField;
    private JRadioButton lakiLakiButton, perempuanButton;
    private JCheckBox wnaCheckBox;
    private JTextArea resultArea;
    private JList<String> jenisTabunganList;
    private JSpinner frekuensiTransaksiSpinner, tanggalLahirSpinner;
    private JPasswordField passwordField, confirmPasswordField;

    public FormApp() {
        setTitle("Form Pendaftaran Nasabah Bank");
        setSize(500, 600);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(9, 1));

        // Menu bar
        JMenuBar menuBar = new JMenuBar();
        JMenu menu = new JMenu("Menu");
        JMenuItem resetItem = new JMenuItem("Reset");
        JMenuItem exitItem = new JMenuItem("Exit");

        resetItem.addActionListener(e -> resetForm());
        exitItem.addActionListener(e -> System.exit(0));

        menu.add(resetItem);
        menu.add(exitItem);
        menuBar.add(menu);
        setJMenuBar(menuBar);

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

        // Panel untuk Jenis Tabungan
        JPanel panelJenisTabungan = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel jenisTabunganLabel = new JLabel("Jenis Tabungan:");
        String[] jenisTabungan = {"Tabungan Muda", "Tabungan Haji", "Tabungan Berjangka", "Tabungan Bisnis"};
        jenisTabunganList = new JList<>(jenisTabungan);
        jenisTabunganList.setVisibleRowCount(4);
        JScrollPane jenisTabunganScroll = new JScrollPane(jenisTabunganList);
        panelJenisTabungan.add(jenisTabunganLabel);
        panelJenisTabungan.add(jenisTabunganScroll);
        add(panelJenisTabungan);

        // Checkbox untuk Warga Negara Asing
        JPanel panelWNA = new JPanel(new FlowLayout(FlowLayout.LEFT));
        wnaCheckBox = new JCheckBox("Warga Negara Asing");
        panelWNA.add(wnaCheckBox);
        add(panelWNA);

        // Panel untuk Frekuensi Transaksi
        JPanel panelFrekuensi = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel frekuensiLabel = new JLabel("Frekuensi Transaksi per Bulan:");
        SpinnerModel frekuensiModel = new SpinnerNumberModel(1, 1, 100, 1);
        frekuensiTransaksiSpinner = new JSpinner(frekuensiModel);
        panelFrekuensi.add(frekuensiLabel);
        panelFrekuensi.add(frekuensiTransaksiSpinner);
        add(panelFrekuensi);

        // Panel untuk Tanggal Lahir
        JPanel panelTanggalLahir = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel tanggalLahirLabel = new JLabel("Tanggal Lahir:");
        SpinnerDateModel tanggalLahirModel = new SpinnerDateModel();
        tanggalLahirSpinner = new JSpinner(tanggalLahirModel);
        JSpinner.DateEditor dateEditor = new JSpinner.DateEditor(tanggalLahirSpinner, "dd-MM-yyyy");
        tanggalLahirSpinner.setEditor(dateEditor);
        panelTanggalLahir.add(tanggalLahirLabel);
        panelTanggalLahir.add(tanggalLahirSpinner);
        add(panelTanggalLahir);

        // Panel untuk Password dan Confirm Password
        JPanel panelPassword = new JPanel(new FlowLayout(FlowLayout.LEFT));
        JLabel passwordLabel = new JLabel("Password:");
        passwordField = new JPasswordField(15);
        JLabel confirmPasswordLabel = new JLabel("Confirm Password:");
        confirmPasswordField = new JPasswordField(15);
        panelPassword.add(passwordLabel);
        panelPassword.add(passwordField);
        panelPassword.add(confirmPasswordLabel);
        panelPassword.add(confirmPasswordField);
        add(panelPassword);

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
        String jenisTabungan = jenisTabunganList.getSelectedValue();
        String wna = wnaCheckBox.isSelected() ? "Ya" : "Tidak";
        int frekuensi = (int) frekuensiTransaksiSpinner.getValue();
        String tanggalLahir = tanggalLahirSpinner.getValue().toString();
        String password = new String(passwordField.getPassword());
        String confirmPassword = new String(confirmPasswordField.getPassword());

        if (!password.equals(confirmPassword)) {
            resultArea.setText("Password dan Confirm Password tidak cocok!\n");
            return;
        }

        String result = "Nama: " + nama + "\n" +
                        "Nomor HP: " + nomorHP + "\n" +
                        "Jenis Kelamin: " + jenisKelamin + "\n" +
                        "Jenis Tabungan: " + jenisTabungan + "\n" +
                        "WNA: " + wna + "\n" +
                        "Frekuensi Transaksi: " + frekuensi + "\n" +
                        "Tanggal Lahir: " + tanggalLahir + "\n" +
                        "========================================\n";

        resultArea.setText(result);
    }

    private void resetForm() {
        namaField.setText("");
        nomorHPField.setText("");
        lakiLakiButton.setSelected(false);
        perempuanButton.setSelected(false);
        jenisTabunganList.clearSelection();
        wnaCheckBox.setSelected(false);
        frekuensiTransaksiSpinner.setValue(1);
        passwordField.setText("");
        confirmPasswordField.setText("");
        resultArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new FormApp());
    }
}
