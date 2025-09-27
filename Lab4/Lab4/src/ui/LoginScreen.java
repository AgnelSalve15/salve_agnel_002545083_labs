package ui;

import model.Supplier;
import model.SupplierDirectory;
import ui.admin.AdminWorkAreaJPanel;
import ui.supplier.SupplierWorkAreaJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;
import javax.swing.JOptionPane;

/**
 * Login Screen for Lab 4 Demo
 */
public class LoginScreen extends javax.swing.JPanel {
    
    private JPanel mainWorkArea;
    private SupplierDirectory supplierDirectory;

    public LoginScreen(JPanel mainWorkArea, SupplierDirectory supplierDirectory) {
        this.mainWorkArea = mainWorkArea;
        this.supplierDirectory = supplierDirectory;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">
    private void initComponents() {

        lblTitle = new javax.swing.JLabel();
        lblChooseRole = new javax.swing.JLabel();
        cmbRole = new javax.swing.JComboBox<>();
        btnLogin = new javax.swing.JButton();

        setBackground(new java.awt.Color(255, 255, 255));

        lblTitle.setFont(new java.awt.Font("Tahoma", 1, 18)); // NOI18N
        lblTitle.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        lblTitle.setText("Welcome to Lab 4 Demo");

        lblChooseRole.setText("Choose Role:");

        // Only show Administrator and Supplier options
        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator", "Supplier" }));

        btnLogin.setText("Login");
        btnLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnLoginActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(300, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(300, 300, 300))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(lblChooseRole)
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(btnLogin)
                            .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, 150, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(290, 290, 290))))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(200, 200, 200)
                .addComponent(lblTitle)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblChooseRole)
                    .addComponent(cmbRole, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(btnLogin)
                .addContainerGap(250, Short.MAX_VALUE))
        );
    }// </editor-fold>

    private void btnLoginActionPerformed(java.awt.event.ActionEvent evt) {
        String selectedRole = (String) cmbRole.getSelectedItem();
        
        if ("Administrator".equals(selectedRole)) {
            // Go directly to Admin Work Area
            AdminWorkAreaJPanel adminWorkArea = new AdminWorkAreaJPanel(mainWorkArea, supplierDirectory);
            mainWorkArea.add("AdminWorkArea", adminWorkArea);
            CardLayout layout = (CardLayout) mainWorkArea.getLayout();
            layout.next(mainWorkArea);
            
        } else if ("Supplier".equals(selectedRole)) {
            // Show supplier selection dialog
            showSupplierSelection();
        }
    }
    
    private void showSupplierSelection() {
        // Create supplier selection dialog
        Object[] suppliers = supplierDirectory.getSupplierList().toArray();
        
        if (suppliers.length == 0) {
            JOptionPane.showMessageDialog(this, 
                "No suppliers available. Please contact administrator.", 
                "No Suppliers", 
                JOptionPane.WARNING_MESSAGE);
            return;
        }
        
        Object selectedSupplier = JOptionPane.showInputDialog(
            this,
            "Select your supplier:",
            "Supplier Selection",
            JOptionPane.PLAIN_MESSAGE,
            null,
            suppliers,
            suppliers[0]
        );
        
        if (selectedSupplier != null) {
            Supplier supplier = (Supplier) selectedSupplier;
            SupplierWorkAreaJPanel supplierWorkArea = new SupplierWorkAreaJPanel(mainWorkArea, supplier);
            mainWorkArea.add("SupplierWorkArea", supplierWorkArea);
            CardLayout layout = (CardLayout) mainWorkArea.getLayout();
            layout.next(mainWorkArea);
        }
    }

    public void populateSupplierCombo() {
        // This method is called when logging out, but we don't need to repopulate
        // since we only show Administrator/Supplier options
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<String> cmbRole;
    private javax.swing.JLabel lblChooseRole;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration
}