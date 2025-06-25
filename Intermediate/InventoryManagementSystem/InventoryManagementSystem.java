import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Item {
    int id;
    String name;
    int quantity;
    double price;

    Item(int id, String name, int quantity, double price) {
        this.id = id;
        this.name = name;
        this.quantity = quantity;
        this.price = price;
    }
}

public class InventoryManagementSystem extends JFrame {
    private ArrayList<Item> itemList = new ArrayList<>();
    private JTable table;
    private DefaultTableModel model;

    private JTextField idField, nameField, quantityField, priceField;

    public InventoryManagementSystem() {
        setTitle("Inventory Management System");
        setSize(700, 400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        // Input Panel
        JPanel inputPanel = new JPanel(new GridLayout(2, 5, 10, 10));
        idField = new JTextField();
        nameField = new JTextField();
        quantityField = new JTextField();
        priceField = new JTextField();

        inputPanel.add(new JLabel("ID"));
        inputPanel.add(new JLabel("Name"));
        inputPanel.add(new JLabel("Quantity"));
        inputPanel.add(new JLabel("Price"));
        inputPanel.add(new JLabel("")); // empty cell

        inputPanel.add(idField);
        inputPanel.add(nameField);
        inputPanel.add(quantityField);
        inputPanel.add(priceField);

        // Buttons Panel
        JPanel btnPanel = new JPanel();
        JButton addBtn = new JButton("Add");
        JButton updateBtn = new JButton("Update");
        JButton deleteBtn = new JButton("Delete");

        btnPanel.add(addBtn);
        btnPanel.add(updateBtn);
        btnPanel.add(deleteBtn);

        // Table
        model = new DefaultTableModel(new String[]{"ID", "Name", "Quantity", "Price"}, 0);
        table = new JTable(model);
        JScrollPane tablePane = new JScrollPane(table);

        // Add listeners
        addBtn.addActionListener(e -> addItem());
        updateBtn.addActionListener(e -> updateItem());
        deleteBtn.addActionListener(e -> deleteItem());
        table.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent e) {
                int row = table.getSelectedRow();
                idField.setText(model.getValueAt(row, 0).toString());
                nameField.setText(model.getValueAt(row, 1).toString());
                quantityField.setText(model.getValueAt(row, 2).toString());
                priceField.setText(model.getValueAt(row, 3).toString());
            }
        });

        // Layout
        setLayout(new BorderLayout(10, 10));
        add(inputPanel, BorderLayout.NORTH);
        add(btnPanel, BorderLayout.CENTER);
        add(tablePane, BorderLayout.SOUTH);
    }

    private void addItem() {
        try {
            int id = Integer.parseInt(idField.getText());
            String name = nameField.getText();
            int quantity = Integer.parseInt(quantityField.getText());
            double price = Double.parseDouble(priceField.getText());

            itemList.add(new Item(id, name, quantity, price));
            model.addRow(new Object[]{id, name, quantity, price});
            clearFields();
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Please enter valid data.");
        }
    }

    private void updateItem() {
        int row = table.getSelectedRow();
        if (row != -1) {
            try {
                int id = Integer.parseInt(idField.getText());
                String name = nameField.getText();
                int quantity = Integer.parseInt(quantityField.getText());
                double price = Double.parseDouble(priceField.getText());

                itemList.set(row, new Item(id, name, quantity, price));
                model.setValueAt(id, row, 0);
                model.setValueAt(name, row, 1);
                model.setValueAt(quantity, row, 2);
                model.setValueAt(price, row, 3);
                clearFields();
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this, "Please enter valid data.");
            }
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to update.");
        }
    }

    private void deleteItem() {
        int row = table.getSelectedRow();
        if (row != -1) {
            itemList.remove(row);
            model.removeRow(row);
            clearFields();
        } else {
            JOptionPane.showMessageDialog(this, "Please select an item to delete.");
        }
    }

    private void clearFields() {
        idField.setText("");
        nameField.setText("");
        quantityField.setText("");
        priceField.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new InventoryManagementSystem().setVisible(true);
        });
    }
}
