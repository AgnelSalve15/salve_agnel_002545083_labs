package UserInterface.WorkAreas.StudentRole;

import Business.Business;
import Business.ConfigureABusiness;
import Business.Profiles.StudentProfile;
import Business.UserAccounts.UserAccount;
import UserInterface.WorkAreas.AdminRole.AdminRoleWorkAreaJPanel;
import UserInterface.WorkAreas.FacultyRole.FacultyWorkAreaJPanel;
import javax.swing.JOptionPane;
import java.awt.CardLayout;

public class ProfileWorkAreaMainFrame extends javax.swing.JFrame {

    Business business;
    
    public ProfileWorkAreaMainFrame(Business business) {
        this.business = business;
        initComponents();
        setSize(1000, 700);
        setLocationRelativeTo(null);
    }

    @SuppressWarnings("unchecked")
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jTextFieldUserName = new javax.swing.JTextField();
        jPasswordField = new javax.swing.JPasswordField();
        jButtonLogin = new javax.swing.JButton();
        jButtonSignUp = new javax.swing.JButton();
        workContainer = new javax.swing.JPanel();
        jLabelTitle = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setTitle("Profile Work Area - Lab 5");

        jLabel1.setText("Username:");
        jLabel2.setText("Password:");

        jButtonLogin.setText("Login");
        jButtonLogin.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonLoginActionPerformed(evt);
            }
        });

        jButtonSignUp.setText("Sign Up (Student)");
        jButtonSignUp.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButtonSignUpActionPerformed(evt);
            }
        });

        workContainer.setLayout(new CardLayout());

        jLabelTitle.setFont(new java.awt.Font("Dialog", 1, 24));
        jLabelTitle.setText("Welcome to Profile Management System");

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(250, 250, 250)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel1)
                            .addComponent(jLabel2))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(jTextFieldUserName)
                            .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jButtonLogin)
                                .addGap(18, 18, 18)
                                .addComponent(jButtonSignUp))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(200, 200, 200)
                        .addComponent(jLabelTitle)))
                .addContainerGap(250, Short.MAX_VALUE))
            .addComponent(workContainer, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(50, 50, 50)
                .addComponent(jLabelTitle)
                .addGap(50, 50, 50)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jTextFieldUserName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButtonLogin)
                    .addComponent(jButtonSignUp))
                .addGap(30, 30, 30)
                .addComponent(workContainer, javax.swing.GroupLayout.DEFAULT_SIZE, 350, Short.MAX_VALUE))
        );

        pack();
    }

    private void jButtonLoginActionPerformed(java.awt.event.ActionEvent evt) {                                             
        String userName = jTextFieldUserName.getText();
        String password = jPasswordField.getText();
        
        UserAccount userAccount = business.getUserAccountDirectory().AuthenticateUser(userName, password);
        
        if (userAccount == null) {
            JOptionPane.showMessageDialog(this, "Invalid username or password", "Login Failed", JOptionPane.ERROR_MESSAGE);
            return;
        }
        
        String role = userAccount.getRole();
        
        if ("Admin".equals(role)) {
            AdminRoleWorkAreaJPanel adminWorkArea = new AdminRoleWorkAreaJPanel(business, workContainer);
            workContainer.add("AdminWorkArea", adminWorkArea);
            ((CardLayout) workContainer.getLayout()).next(workContainer);
            
        } else if ("Student".equals(role)) {
            StudentProfile studentProfile = (StudentProfile) userAccount.getAssociatedPersonProfile();
            StudentWorkAreaJPanel studentWorkArea = new StudentWorkAreaJPanel(business, studentProfile, workContainer);
            workContainer.add("StudentWorkArea", studentWorkArea);
            ((CardLayout) workContainer.getLayout()).next(workContainer);
            
        } else if ("Faculty".equals(role)) {
            FacultyWorkAreaJPanel facultyWorkArea = new FacultyWorkAreaJPanel(business, workContainer);
            workContainer.add("FacultyWorkArea", facultyWorkArea);
            ((CardLayout) workContainer.getLayout()).next(workContainer);
        }
    }

    private void jButtonSignUpActionPerformed(java.awt.event.ActionEvent evt) {                                              
        StudentSignUpJPanel signUpPanel = new StudentSignUpJPanel(business, workContainer);
        workContainer.add("StudentSignUp", signUpPanel);
        ((CardLayout) workContainer.getLayout()).next(workContainer);
    }

    public static void main(String args[]) {
        Business business = ConfigureABusiness.initialize();
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new ProfileWorkAreaMainFrame(business).setVisible(true);
            }
        });
    }

    private javax.swing.JButton jButtonLogin;
    private javax.swing.JButton jButtonSignUp;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabelTitle;
    private javax.swing.JPasswordField jPasswordField;
    private javax.swing.JTextField jTextFieldUserName;
    private javax.swing.JPanel workContainer;
}