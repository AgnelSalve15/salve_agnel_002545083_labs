package ui;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import model.AccountDirectory;
import model.Account;

public class ManageAccountsJPanel extends JPanel {
    private JPanel userProcessContainer;
    private AccountDirectory accountDirectory;
    private JTable tblAccounts;
    private DefaultTableModel tableModel;
    private JTextField txtSearch;
    
    public ManageAccountsJPanel(JPanel userProcessContainer, AccountDirectory accountDirectory) {
        this.userProcessContainer = userProcessContainer;
        this.accountDirectory = accountDirectory;
        initComponents();
        populateTable();
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        setBackground(Color.LIGHT_GRAY);
        
        // Back button
        JButton btnBack = new JButton("<<< Back");
        btnBack.addActionListener(evt -> btnBackActionPerformed(evt));
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(btnBack);
        add(topPanel, BorderLayout.NORTH);
        
        // Title
        JLabel title = new JLabel("Manage Account", JLabel.CENTER);
        title.setFont(new Font("Arial", Font.BOLD, 16));
        add(title, BorderLayout.CENTER);
        
        // Create table
        String[] columnNames = {"Bank Name", "Routing Number", "Account Number", "Balance"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        
        tblAccounts = new JTable(tableModel);
        tblAccounts.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
        JScrollPane scrollPane = new JScrollPane(tblAccounts);
        scrollPane.setPreferredSize(new Dimension(600, 200));
        
        // Search and buttons panel
        JPanel bottomPanel = new JPanel(new BorderLayout());
        
        // Search panel
        JPanel searchPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        searchPanel.add(new JLabel("Search:"));
        txtSearch = new JTextField(15);
        JButton btnSearch = new JButton("Search");
        btnSearch.addActionListener(evt -> btnSearchActionPerformed(evt));
        searchPanel.add(txtSearch);
        searchPanel.add(btnSearch);
        
        // Buttons panel
        JPanel buttonPanel = new JPanel(new FlowLayout());
        JButton btnViewDetails = new JButton("View Details");
        JButton btnDeleteAccount = new JButton("Delete Account");
        
        btnViewDetails.addActionListener(evt -> btnViewDetailsActionPerformed(evt));
        btnDeleteAccount.addActionListener(evt -> btnDeleteActionPerformed(evt));
        
        buttonPanel.add(btnViewDetails);
        buttonPanel.add(btnDeleteAccount);
        
        bottomPanel.add(searchPanel, BorderLayout.NORTH);
        bottomPanel.add(buttonPanel, BorderLayout.SOUTH);
        
        // Main content panel
        JPanel contentPanel = new JPanel(new BorderLayout());
        contentPanel.add(title, BorderLayout.NORTH);
        contentPanel.add(scrollPane, BorderLayout.CENTER);
        contentPanel.add(bottomPanel, BorderLayout.SOUTH);
        
        add(contentPanel, BorderLayout.CENTER);
    }
    
    private void populateTable() {
        tableModel.setRowCount(0);
        for (Account account : accountDirectory.getAccountList()) {
            Object[] row = {
                account.getBankName(),
                account.getRoutingNumber(),
                account.getAccountNumber(),
                account.getBalance()
            };
            tableModel.addRow(row);
        }
    }
    
    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {
        String searchText = txtSearch.getText().trim();
        if (searchText.isEmpty()) {
            populateTable();
            return;
        }
        
        tableModel.setRowCount(0);
        for (Account account : accountDirectory.getAccountList()) {
            if (account.getAccountNumber().contains(searchText)) {
                Object[] row = {
                    account.getBankName(),
                    account.getRoutingNumber(),
                    account.getAccountNumber(),
                    account.getBalance()
                };
                tableModel.addRow(row);
            }
        }
    }
    
    private void btnViewDetailsActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = tblAccounts.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an account from the list.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            Account selectedAccount = (Account) tblAccounts.getValueAt(selectedRow, 0);
            // Find the actual account object
            String accountNumber = (String) tblAccounts.getValueAt(selectedRow, 2);
            selectedAccount = accountDirectory.searchAccount(accountNumber);
            
            ViewAccountJPanel panel = new ViewAccountJPanel(userProcessContainer, accountDirectory, selectedAccount);
            userProcessContainer.add("ViewAccountJPanel", panel);
            CardLayout layout = (CardLayout) userProcessContainer.getLayout();
            layout.next(userProcessContainer);
        }
    }
    
    private void btnDeleteActionPerformed(java.awt.event.ActionEvent evt) {
        int selectedRow = tblAccounts.getSelectedRow();
        if (selectedRow < 0) {
            JOptionPane.showMessageDialog(this, "Please select an account from the list to delete.", "Warning", JOptionPane.WARNING_MESSAGE);
        } else {
            int confirm = JOptionPane.showConfirmDialog(this, 
                "Are you sure you want to delete this account?", 
                "Confirm Delete", 
                JOptionPane.YES_NO_OPTION);
            
            if (confirm == JOptionPane.YES_OPTION) {
                String accountNumber = (String) tblAccounts.getValueAt(selectedRow, 2);
                Account accountToDelete = accountDirectory.searchAccount(accountNumber);
                accountDirectory.deleteAccount(accountToDelete);
                populateTable();
                JOptionPane.showMessageDialog(this, "Account deleted successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
            }
        }
    }
    
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {
        userProcessContainer.remove(this);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.previous(userProcessContainer);
    }
}
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    // End of variables declaration                   


    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

