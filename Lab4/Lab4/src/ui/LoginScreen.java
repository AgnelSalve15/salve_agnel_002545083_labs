package ui;

import model.Supplier;
import model.SupplierDirectory;
import ui.admin.AdminWorkAreaJPanel;
import ui.supplier.SupplierWorkAreaJPanel;
import java.awt.CardLayout;
import javax.swing.JPanel;

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
        populateSupplierCombo();
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

        cmbRole.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Administrator" }));

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
            AdminWorkAreaJPanel adminWorkArea = new AdminWorkAreaJPanel(mainWorkArea, supplierDirectory);
            mainWorkArea.add("AdminWorkArea", adminWorkArea);
        } else {
            // It's a supplier
            Supplier selectedSupplier = (Supplier) cmbRole.getSelectedItem();
            SupplierWorkAreaJPanel supplierWorkArea = new SupplierWorkAreaJPanel(mainWorkArea, selectedSupplier);
            mainWorkArea.add("SupplierWorkArea", supplierWorkArea);
        }
        
        CardLayout layout = (CardLayout) mainWorkArea.getLayout();
        layout.next(mainWorkArea);
    }

    public void populateSupplierCombo() {
        cmbRole.removeAllItems();
        cmbRole.addItem("Administrator");
        
        for (Supplier supplier : supplierDirectory.getSupplierList()) {
            cmbRole.addItem(supplier);
        }
    }

    // Variables declaration - do not modify
    private javax.swing.JButton btnLogin;
    private javax.swing.JComboBox<Object> cmbRole;
    private javax.swing.JLabel lblChooseRole;
    private javax.swing.JLabel lblTitle;
    // End of variables declaration
}