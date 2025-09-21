package ui;

import javax.swing.*;
import java.awt.*;
import model.AccountDirectory;

public class MainJFrame extends JFrame {
    private JPanel userProcessContainer;
    private final AccountDirectory accountDirectory;
    
    public MainJFrame() {
        accountDirectory = new AccountDirectory();
        initComponents();
        setTitle("MainJFrame");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setExtendedState(JFrame.MAXIMIZED_BOTH);
        setVisible(true);
    }
    
    private void initComponents() {
        setLayout(new BorderLayout());
        
        JButton btnOpenWorkArea = new JButton("Open Account Manager Work Area");
        btnOpenWorkArea.setPreferredSize(new Dimension(250, 30));
        btnOpenWorkArea.addActionListener(evt -> btnOpenWorkAreaActionPerformed(evt));
        
        JPanel topPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
        topPanel.add(btnOpenWorkArea);
        add(topPanel, BorderLayout.NORTH);
        
        userProcessContainer = new JPanel();
        userProcessContainer.setLayout(new CardLayout());
        userProcessContainer.setBackground(Color.LIGHT_GRAY);
        add(userProcessContainer, BorderLayout.CENTER);
    }
    
    private void btnOpenWorkAreaActionPerformed(java.awt.event.ActionEvent evt) {
        AccountManagerWorkAreaJPanel panel = new AccountManagerWorkAreaJPanel(userProcessContainer, accountDirectory);
        userProcessContainer.add("AccountManagerWorkAreaJPanel", panel);
        CardLayout layout = (CardLayout) userProcessContainer.getLayout();
        layout.next(userProcessContainer);
    }
    
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeel());
        } catch (Exception e) {
        }
        
        SwingUtilities.invokeLater(() -> {
            new MainJFrame();
        });
    }
}
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        


    // Variables declaration - do not modify                     
    // End of variables declaration                   


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">                          
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>                        

    
     

    // Variables declaration - do not modify                     
    // End of variables declaration                   


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 400, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 300, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables
}
