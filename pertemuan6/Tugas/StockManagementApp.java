import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StockManagementApp extends JFrame {

    private DefaultTableModel tableModel;
    private JTable table;

    public StockManagementApp() {
        // Set title and default close operation
        setTitle("Sistem Manajemen Stok");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);

        // Create menu bar and menus
        JMenuBar menuBar = new JMenuBar();
        JMenu menuFile = new JMenu("File");
        JMenu menuStock = new JMenu("Manajemen Stok");
        JMenuItem addItem = new JMenuItem("Tambah Stok");
        JMenuItem exitItem = new JMenuItem("Keluar");

        // Add menu items
        menuFile.add(exitItem);
        menuStock.add(addItem);
        menuBar.add(menuFile);
        menuBar.add(menuStock);
        setJMenuBar(menuBar);

        // Action for adding new stock
        addItem.addActionListener(e -> openAddStockForm());

        // Action for exit
        exitItem.addActionListener(e -> System.exit(0));

        // Set up table to show stock items
        tableModel = new DefaultTableModel();
        tableModel.addColumn("Nama Barang");
        tableModel.addColumn("Deskripsi");
        tableModel.addColumn("Kategori");
        tableModel.addColumn("Jumlah");
        tableModel.addColumn("Harga");

        table = new JTable(tableModel);
        add(new JScrollPane(table), BorderLayout.CENTER);
    }

    private void openAddStockForm() {
        // Create a new frame for adding stock
        JFrame addStockFrame = new JFrame("Tambah Barang Baru");
        addStockFrame.setSize(500, 400);
        addStockFrame.setLayout(new BorderLayout());

        // Panel for form inputs
        JPanel inputPanel = new JPanel();
        inputPanel.setLayout(new GridLayout(6, 2));

        // Form inputs
        JTextField itemNameField = new JTextField();
        JTextArea descriptionArea = new JTextArea();
        JComboBox<String> categoryBox = new JComboBox<>(new String[] {"Elektronik", "Pakaian", "Makanan"});
        JSlider quantitySlider = new JSlider(1, 100, 1);
        JTextField priceField = new JTextField();
        JCheckBox onSaleBox = new JCheckBox("Sedang Diskon");

        // Slider setup for quantity
        quantitySlider.setMajorTickSpacing(10);
        quantitySlider.setPaintTicks(true);
        quantitySlider.setPaintLabels(true);

        // Add components to input panel with Indonesian labels
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

        // Panel for buttons
        JPanel buttonPanel = new JPanel();
        JButton addButton = new JButton("Tambah");
        JButton cancelButton = new JButton("Batal");

        // Add action listener to add button
        addButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                // Get input values
                String itemName = itemNameField.getText();
                String description = descriptionArea.getText();
                String category = (String) categoryBox.getSelectedItem();
                int quantity = quantitySlider.getValue();
                String priceText = priceField.getText();
                int price = 0;

                // Parse price field as integer
                try {
                    price = Integer.parseInt(priceText);
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(addStockFrame, "Harga harus berupa angka!", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Add new row to the table
                tableModel.addRow(new Object[] {itemName, description, category, quantity, price});

                // Close the form
                addStockFrame.dispose();
            }
        });

        // Action for cancel button
        cancelButton.addActionListener(e -> addStockFrame.dispose());

        // Add buttons to button panel
        buttonPanel.add(addButton);
        buttonPanel.add(cancelButton);

        // Add panels to the frame
        addStockFrame.add(inputPanel, BorderLayout.CENTER);
        addStockFrame.add(buttonPanel, BorderLayout.SOUTH);

        // Set frame visibility
        addStockFrame.setVisible(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            StockManagementApp app = new StockManagementApp();
            app.setVisible(true);
        });
    }
}
