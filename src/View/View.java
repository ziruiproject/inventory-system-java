package View;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.*;

public class View {
    private JFrame frame;
    private JPanel mainPanel;
    private JTable productTable, categoryTable;
    private JButton productAddButton, productEditButton, productDeleteButton, productViewButton;
    private JButton categoryAddButton, categoryEditButton, categoryDeleteButton, categoryViewButton;
    private DefaultTableModel productTableModel, categoryTableModel;
    private JList<String> sidebar;
    private CardLayout cardLayout;
    private JPanel cardPanel;

    public View() {
        // Set up the frame
        frame = new JFrame("Inventory System");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.setLayout(new BorderLayout());

        // Set up the sidebar for categories and products
        String[] sidebarItems = {"Products", "Categories"};
        sidebar = new JList<>(sidebarItems);
        sidebar.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        sidebar.setSelectedIndex(0);

        // Set up the main panel with CardLayout to switch between product and category views
        cardLayout = new CardLayout();
        cardPanel = new JPanel(cardLayout);

        // Set up the product CRUD panel
        JPanel productPanel = new JPanel(new BorderLayout());
        setupProductPanel(productPanel);

        // Set up the category CRUD panel
        JPanel categoryPanel = new JPanel(new BorderLayout());
        setupCategoryPanel(categoryPanel);

        // Add the panels to the card panel
        cardPanel.add(productPanel, "Products");
        cardPanel.add(categoryPanel, "Categories");

        // Add a listener to the sidebar to switch between views
        sidebar.addListSelectionListener(e -> {
            if (!e.getValueIsAdjusting()) {
                String selected = sidebar.getSelectedValue();
                cardLayout.show(cardPanel, selected);
            }
        });

        // Set up the split pane with the sidebar and the card panel
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, new JScrollPane(sidebar), cardPanel);
        splitPane.setDividerLocation(150);

        // Add the split pane to the frame
        frame.add(splitPane, BorderLayout.CENTER);

        // Display the frame
        frame.setVisible(true);
    }

    private void setupProductPanel(JPanel productPanel) {
        // Set up the panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));

        // Initialize buttons
        productAddButton = new JButton("Add");
        productEditButton = new JButton("Edit");
        productDeleteButton = new JButton("Delete");
        productViewButton = new JButton("View");

        // Add buttons to the panel
        buttonPanel.add(productAddButton);
        buttonPanel.add(productEditButton);
        buttonPanel.add(productDeleteButton);
        buttonPanel.add(productViewButton);

        // Add the button panel to the product panel
        productPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set up the table for displaying product data
        String[] columnNames = {"Product ID", "Name", "Stock", "Price", "Description", "Category", "Created At", "Updated At"};
        productTableModel = new DefaultTableModel(columnNames, 0);
        productTable = new JTable(productTableModel);
        JScrollPane scrollPane = new JScrollPane(productTable);
        productPanel.add(scrollPane, BorderLayout.CENTER);
    }


    private void viewProduct() {
    }

    private void deleteProduct() {
    }

    private void editProduct() {
    }

    private void setupCategoryPanel(JPanel categoryPanel) {
        // Set up the panel for buttons
        JPanel buttonPanel = new JPanel();
        buttonPanel.setLayout(new GridLayout(1, 4));

        // Initialize buttons
        categoryAddButton = new JButton("Add");
        categoryEditButton = new JButton("Edit");
        categoryDeleteButton = new JButton("Delete");
        categoryViewButton = new JButton("View");

        // Add buttons to the panel
        buttonPanel.add(categoryAddButton);
        buttonPanel.add(categoryEditButton);
        buttonPanel.add(categoryDeleteButton);
        buttonPanel.add(categoryViewButton);

        // Add the button panel to the category panel
        categoryPanel.add(buttonPanel, BorderLayout.SOUTH);

        // Set up the table for displaying category data
        String[] columnNames = {"Category ID", "Name"};
        categoryTableModel = new DefaultTableModel(columnNames, 0);
        categoryTable = new JTable(categoryTableModel);
        JScrollPane scrollPane = new JScrollPane(categoryTable);
        categoryPanel.add(scrollPane, BorderLayout.CENTER);

        // Add action listeners to buttons
        categoryAddButton.addActionListener(e -> showAddCategoryDialog());
        categoryEditButton.addActionListener(e -> editCategory());
        categoryDeleteButton.addActionListener(e -> deleteCategory());
        categoryViewButton.addActionListener(e -> viewCategory());
    }

    private void viewCategory() {
    }

    private void deleteCategory() {
    }

    private void editCategory() {
    }

    public String[] showAddProductDialog() {
        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(20);
        JTextField quantityField = new JTextField(10);
        JTextField priceField = new JTextField(10);
        JTextField descriptionField = new JTextField(20);

        // Assuming categories are fetched from some controller or predefined list
        String[] categories = {"Category1", "Category2", "Category3"}; // replace with actual categories
        JComboBox<String> categoryComboBox = new JComboBox<>(categories);

        // Current date-time as default values for createdAt and updatedAt
        JTextField createdAtField = new JTextField(20);
        createdAtField.setText(java.time.LocalDateTime.now().toString());
        createdAtField.setEditable(false); // making it non-editable
        JTextField updatedAtField = new JTextField(20);
        updatedAtField.setText(java.time.LocalDateTime.now().toString());
        updatedAtField.setEditable(false); // making it non-editable

        JPanel panel = new JPanel(new GridLayout(9, 2));
        panel.add(new JLabel("Product ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);
        panel.add(new JLabel("Quantity:"));
        panel.add(quantityField);
        panel.add(new JLabel("Price:"));
        panel.add(priceField);
        panel.add(new JLabel("Description:"));
        panel.add(descriptionField);
        panel.add(new JLabel("Category:"));
        panel.add(categoryComboBox);
        panel.add(new JLabel("Created At:"));
        panel.add(createdAtField);
        panel.add(new JLabel("Updated At:"));
        panel.add(updatedAtField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add Product", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return new String[]{
                    idField.getText(),
                    nameField.getText(),
                    quantityField.getText(),
                    priceField.getText(),
                    descriptionField.getText(),
                    (String) categoryComboBox.getSelectedItem(),
                    createdAtField.getText(),
                    updatedAtField.getText()
            };
        }
        return null;
    }


    public String[] showAddCategoryDialog() {
        JTextField idField = new JTextField(10);
        JTextField nameField = new JTextField(20);

        JPanel panel = new JPanel(new GridLayout(3, 2));
        panel.add(new JLabel("Category ID:"));
        panel.add(idField);
        panel.add(new JLabel("Name:"));
        panel.add(nameField);

        int result = JOptionPane.showConfirmDialog(frame, panel, "Add Category", JOptionPane.OK_CANCEL_OPTION, JOptionPane.PLAIN_MESSAGE);
        if (result == JOptionPane.OK_OPTION) {
            return new String[]{idField.getText(), nameField.getText()};
        }
        return null;
    }

    public void addProductListener(ActionListener listener) {
        productAddButton.addActionListener(listener);
    }

    public void editProductListener(ActionListener listener) {
        productEditButton.addActionListener(listener);
    }

    public void deleteProductListener(ActionListener listener) {
        productDeleteButton.addActionListener(listener);
    }

    public void viewProductListener(ActionListener listener) {
        productViewButton.addActionListener(listener);
    }

    public void addCategoryListener(ActionListener listener) {
        categoryAddButton.addActionListener(listener);
    }

    public void editCategoryListener(ActionListener listener) {
        categoryEditButton.addActionListener(listener);
    }

    public void deleteCategoryListener(ActionListener listener) {
        categoryDeleteButton.addActionListener(listener);
    }

    public void viewCategoryListener(ActionListener listener) {
        categoryViewButton.addActionListener(listener);
    }

    public void clearProductTable() {
        productTableModel.setRowCount(0);
    }

    public void addProductToTable(Object[] rowData) {
        productTableModel.addRow(rowData);
    }

    public int getSelectedProductRow() {
        return productTable.getSelectedRow();
    }

    public JFrame getFrame() {
        return frame;
    }
}
