import javax.swing.*;
import javax.swing.border.TitledBorder;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ProductGUI extends JFrame {
    
    // Input components for left pane
    private JTextField nameField;
    private JTextArea descriptionArea;
    private JTextField availNumField;
    private JTextField priceField;
    
    // Manufacture address fields
    private JTextField mfgStreetField;
    private JTextField mfgUnitField;
    private JTextField mfgCityField;
    private JTextField mfgZipField;
    
    // Shipping address fields
    private JTextField shipStreetField;
    private JTextField shipUnitField;
    private JTextField shipCityField;
    private JTextField shipZipField;
    
    // Display components for right pane
    private JTextArea displayArea;
    
    // Buttons
    private JButton createButton;
    private JButton clearButton;
    
    // Product instance
    private Product product;
    
    public ProductGUI() {
        initializeComponents();
        setupLayout();
        setupEventHandlers();
        
        setTitle("Product Information System");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
    }
    
    private void initializeComponents() {
        // Initialize input fields
        nameField = new JTextField(20);
        descriptionArea = new JTextArea(3, 20);
        descriptionArea.setLineWrap(true);
        descriptionArea.setWrapStyleWord(true);
        availNumField = new JTextField(20);
        priceField = new JTextField(20);
        
        // Manufacture address fields
        mfgStreetField = new JTextField(20);
        mfgUnitField = new JTextField(20);
        mfgCityField = new JTextField(20);
        mfgZipField = new JTextField(20);
        
        // Shipping address fields
        shipStreetField = new JTextField(20);
        shipUnitField = new JTextField(20);
        shipCityField = new JTextField(20);
        shipZipField = new JTextField(20);
        
        // Display area
        displayArea = new JTextArea();
        displayArea.setEditable(false);
        displayArea.setFont(new Font(Font.MONOSPACED, Font.PLAIN, 12));
        displayArea.setBackground(Color.LIGHT_GRAY);
        
        // Buttons
        createButton = new JButton("Create Product");
        clearButton = new JButton("Clear Form");
    }
    
    private void setupLayout() {
        // Create left panel (input form)
        JPanel leftPanel = createInputPanel();
        
        // Create right panel (display)
        JPanel rightPanel = createDisplayPanel();
        
        // Create JSplitPane
        JSplitPane splitPane = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT, leftPanel, rightPanel);
        splitPane.setDividerLocation(400);
        splitPane.setResizeWeight(0.5);
        
        add(splitPane);
    }
    
    private JPanel createInputPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Product Information Form"));
        
        JPanel formPanel = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;
        
        int row = 0;
        
        // Product basic info
        gbc.gridx = 0; gbc.gridy = row;
        formPanel.add(new JLabel("Product Name:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        formPanel.add(nameField, gbc);
        
        gbc.gridx = 0; gbc.gridy = row;
        formPanel.add(new JLabel("Description:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        formPanel.add(new JScrollPane(descriptionArea), gbc);
        
        gbc.gridx = 0; gbc.gridy = row;
        formPanel.add(new JLabel("Available Number:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        formPanel.add(availNumField, gbc);
        
        gbc.gridx = 0; gbc.gridy = row;
        formPanel.add(new JLabel("Price:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        formPanel.add(priceField, gbc);
        
        // Manufacture Address section
        gbc.gridx = 0; gbc.gridy = row++; gbc.gridwidth = 2;
        JLabel mfgLabel = new JLabel("Manufacture Address");
        mfgLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        formPanel.add(mfgLabel, gbc);
        gbc.gridwidth = 1;
        
        gbc.gridx = 0; gbc.gridy = row;
        formPanel.add(new JLabel("Street Name:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        formPanel.add(mfgStreetField, gbc);
        
        gbc.gridx = 0; gbc.gridy = row;
        formPanel.add(new JLabel("Unit Number:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        formPanel.add(mfgUnitField, gbc);
        
        gbc.gridx = 0; gbc.gridy = row;
        formPanel.add(new JLabel("City:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        formPanel.add(mfgCityField, gbc);
        
        gbc.gridx = 0; gbc.gridy = row;
        formPanel.add(new JLabel("Zip Code:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        formPanel.add(mfgZipField, gbc);
        
        // Shipping Address section
        gbc.gridx = 0; gbc.gridy = row++; gbc.gridwidth = 2;
        JLabel shipLabel = new JLabel("Shipping Address");
        shipLabel.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 12));
        formPanel.add(shipLabel, gbc);
        gbc.gridwidth = 1;
        
        gbc.gridx = 0; gbc.gridy = row;
        formPanel.add(new JLabel("Street Name:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        formPanel.add(shipStreetField, gbc);
        
        gbc.gridx = 0; gbc.gridy = row;
        formPanel.add(new JLabel("Unit Number:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        formPanel.add(shipUnitField, gbc);
        
        gbc.gridx = 0; gbc.gridy = row;
        formPanel.add(new JLabel("City:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        formPanel.add(shipCityField, gbc);
        
        gbc.gridx = 0; gbc.gridy = row;
        formPanel.add(new JLabel("Zip Code:"), gbc);
        gbc.gridx = 1; gbc.gridy = row++;
        formPanel.add(shipZipField, gbc);
        
        // Button panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        buttonPanel.add(createButton);
        buttonPanel.add(clearButton);
        
        panel.add(new JScrollPane(formPanel), BorderLayout.CENTER);
        panel.add(buttonPanel, BorderLayout.SOUTH);
        
        return panel;
    }
    
    private JPanel createDisplayPanel() {
        JPanel panel = new JPanel(new BorderLayout());
        panel.setBorder(BorderFactory.createTitledBorder("Product Details"));
        
        JScrollPane scrollPane = new JScrollPane(displayArea);
        panel.add(scrollPane, BorderLayout.CENTER);
        
        return panel;
    }
    
    private void setupEventHandlers() {
        createButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                createProduct();
            }
        });
        
        clearButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                clearForm();
            }
        });
    }
    
    private void createProduct() {
        try {
            // Validate inputs (optional requirement)
            if (!validateInputs()) {
                return;
            }
            
            // Create product instance
            product = new Product();
            
            // Set basic product info
            product.setName(nameField.getText().trim());
            product.setDescription(descriptionArea.getText().trim());
            product.setAvailNum(Integer.parseInt(availNumField.getText().trim()));
            product.setPrice(Double.parseDouble(priceField.getText().trim()));
            
            // Set manufacture address
            Address mfgAddress = new Address();
            mfgAddress.setStreetName(mfgStreetField.getText().trim());
            mfgAddress.setUnitNum(mfgUnitField.getText().trim());
            mfgAddress.setCity(mfgCityField.getText().trim());
            mfgAddress.setZipCode(mfgZipField.getText().trim());
            product.setManufactureAddress(mfgAddress);
            
            // Set shipping address
            Address shipAddress = new Address();
            shipAddress.setStreetName(shipStreetField.getText().trim());
            shipAddress.setUnitNum(shipUnitField.getText().trim());
            shipAddress.setCity(shipCityField.getText().trim());
            shipAddress.setZipCode(shipZipField.getText().trim());
            product.setShippingAddress(shipAddress);
            
            // Display product details
            displayProduct();
            
            JOptionPane.showMessageDialog(this, "Product created successfully!", 
                    "Success", JOptionPane.INFORMATION_MESSAGE);
            
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this, 
                    "Please enter valid numbers for Available Number and Price.", 
                    "Input Error", JOptionPane.ERROR_MESSAGE);
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, 
                    "Error creating product: " + ex.getMessage(), 
                    "Error", JOptionPane.ERROR_MESSAGE);
        }
    }
    
    private boolean validateInputs() {
        // Check for empty required fields
        if (nameField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Product name is required.", 
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            nameField.requestFocus();
            return false;
        }
        
        if (descriptionArea.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Description is required.", 
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            descriptionArea.requestFocus();
            return false;
        }
        
        if (availNumField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Available number is required.", 
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            availNumField.requestFocus();
            return false;
        }
        
        if (priceField.getText().trim().isEmpty()) {
            JOptionPane.showMessageDialog(this, "Price is required.", 
                    "Validation Error", JOptionPane.WARNING_MESSAGE);
            priceField.requestFocus();
            return false;
        }
        
        return true;
    }
    
    private void displayProduct() {
        if (product != null) {
            StringBuilder sb = new StringBuilder();
            sb.append("PRODUCT INFORMATION\n");
            sb.append("==================\n\n");
            
            sb.append("Name: ").append(product.getName()).append("\n");
            sb.append("Description: ").append(product.getDescription()).append("\n");
            sb.append("Available Number: ").append(product.getAvailNum()).append("\n");
            sb.append("Price: $").append(String.format("%.2f", product.getPrice())).append("\n\n");
            
            sb.append("MANUFACTURE ADDRESS\n");
            sb.append("------------------\n");
            Address mfgAddr = product.getManufactureAddress();
            sb.append("Street: ").append(mfgAddr.getStreetName()).append("\n");
            sb.append("Unit: ").append(mfgAddr.getUnitNum()).append("\n");
            sb.append("City: ").append(mfgAddr.getCity()).append("\n");
            sb.append("Zip Code: ").append(mfgAddr.getZipCode()).append("\n\n");
            
            sb.append("SHIPPING ADDRESS\n");
            sb.append("---------------\n");
            Address shipAddr = product.getShippingAddress();
            sb.append("Street: ").append(shipAddr.getStreetName()).append("\n");
            sb.append("Unit: ").append(shipAddr.getUnitNum()).append("\n");
            sb.append("City: ").append(shipAddr.getCity()).append("\n");
            sb.append("Zip Code: ").append(shipAddr.getZipCode()).append("\n");
            
            displayArea.setText(sb.toString());
        }
    }
    
    private void clearForm() {
        // Clear all input fields
        nameField.setText("");
        descriptionArea.setText("");
        availNumField.setText("");
        priceField.setText("");
        
        // Clear manufacture address fields
        mfgStreetField.setText("");
        mfgUnitField.setText("");
        mfgCityField.setText("");
        mfgZipField.setText("");
        
        // Clear shipping address fields
        shipStreetField.setText("");
        shipUnitField.setText("");
        shipCityField.setText("");
        shipZipField.setText("");
        
        // Clear display area
        displayArea.setText("");
        
        // Reset focus
        nameField.requestFocus();
    }
    
    public static void main(String[] args) {
        // Set look and feel
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
        } catch (Exception e) {
            e.printStackTrace();
        }
        
        // Create and show GUI
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                new ProductGUI().setVisible(true);
            }
        });
    }
}