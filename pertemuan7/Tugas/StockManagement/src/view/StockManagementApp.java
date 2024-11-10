package view;

import dao.ProductDao;
import model.Product;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.sql.SQLException;
import java.util.List;

public class StockManagementApp extends JFrame {
    private DefaultTableModel tableModel;
    private JTable table;
    private ProductDao productDao;

    public StockManagementApp() {
        setTitle("Sistem Manajemen Stok");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        productDao = new ProductDao();

        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuStock = new JMenu("Manajemen Stok");
        JMenuItem addItem = new JMenuItem("Tambah Stok");
        JMenuItem exitItem = new JMenuItem("Keluar");

        menuFile.add(exitItem);
        menuStock.add(addItem);
        menuBar.add(menuFile);
        menuBar.add(menuStock);
        setJMenuBar(menuBar);

        addItem.addActionListener(e -> openAddStockForm());
        exitItem.addActionListener(e -> System.exit(0));

        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nama Barang");
        tableModel.addColumn("Deskripsi");
        tableModel.addColumn("Kategori");
        tableModel.addColumn("Jumlah");
        tableModel.addColumn("Harga");
        tableModel.addColumn("Diskon");

        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);

        loadStockData();
    }

    private void openAddStockForm() {
        JFrame addStockFrame = new JFrame("Tambah Barang Baru");
        addStockFrame.setSize(500, 400);
        addStockFrame.setLayout(new BorderLayout());

        JPanel inputPanel = new JPanel(new GridLayout(6, 2));
        JTextField itemNameField = new JTextField();
        JTextArea descriptionArea = new JTextArea();
        JComboBox<String> categoryBox = new JComboBox<>(new String[]{"Elektronik", "Pakaian", "Makanan"});
        JSlider quantitySlider = new JSlider(1, 100, 1);
        JTextField priceField = new JTextField();
        JCheckBox onSaleBox = new JCheckBox("Sedang Diskon");

        quantitySlider.setMajorTickSpacing(10);
        quantitySlider.setPaintTicks(true);
        quantitySlider.setPaintLabels(true);

        inputPanel.add(new JLabel("Nama Barang:"));
        inputPanel.add(itemNameField);
        inputPanel.add(new JLabel("Deskripsi:"));
        inputPanel.add(new JScrollPane(descriptionArea));
        inputPanel.add(new JLabel("Kategori:"));
        inputPanel.add(categoryBox);
        inputPanel.add(new JLabel("Jumlah:"));
        inputPanel.add(quantitySlider);
        inputPanel.add(new JLabel("Harga:"));
        inputPanel.add(priceField);
        inputPanel.add(new JLabel("Sedang Diskon:"));
        inputPanel.add(onSaleBox);

        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Tambah");
        JButton cancelButton = new JButton("Batal");

        addButton.addActionListener(e -> {
            String itemName = itemNameField.getText();
            String description = descriptionArea.getText();
            String category = (String) categoryBox.getSelectedItem();
            int quantity = quantitySlider.getValue();
            int price;
            boolean onSale = onSaleBox.isSelected();

            try {
                price = Integer.parseInt(priceField.getText());
            } catch (NumberFormatException ex) {
                JOptionPane.showMessageDialog(addStockFrame, "Harga harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            Product product = new Product(0, itemName, description, category, quantity, price, onSale);
            try {
                productDao.addProduct(product);
                tableModel.addRow(new Object[]{itemName, description, category, quantity, price, onSale ? "Ya" : "Tidak"});
                JOptionPane.showMessageDialog(addStockFrame, "Barang berhasil ditambahkan!");
            } catch (SQLException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(addStockFrame, "Terjadi kesalahan saat menyimpan data ke database.", "Error", JOptionPane.ERROR_MESSAGE);
            }

            addStockFrame.dispose();
        });

        cancelButton.addActionListener(e -> addStockFrame.dispose());
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        addStockFrame.add(inputPanel, BorderLayout.CENTER);
        addStockFrame.add(buttonPanel, BorderLayout.SOUTH);
        addStockFrame.setVisible(true);
    }

    private void loadStockData() {
        try {
            List<Product> products = productDao.getAllProducts();
            for (Product product : products) {
                tableModel.addRow(new Object[]{
                    product.getItemName(),
                    product.getDescription(),
                    product.getCategory(),
                    product.getQuantity(),
                    product.getPrice(),
                    product.isOnSale() ? "Ya" : "Tidak"
                });
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(this, "Terjadi kesalahan saat memuat data dari database.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StockManagementApp app = new StockManagementApp();
            app.setVisible(true);
        });
    }
}
