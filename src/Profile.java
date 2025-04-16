
import javax.swing.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Profile extends javax.swing.JFrame {

    private final String currentUsername;
    private final String userType;
    private static final String FILE_PATH = "src/UserData.json";

    public Profile(String userType, String username) {
        this.currentUsername = username;
        this.userType = userType;
        initComponents();
        jLabel1.setText("Edit Profile Information for " + currentUsername + "");

        // ✅ Set JComboBox selection based on userType
        TypeComboBox.setSelectedItem(userType.equalsIgnoreCase("GameMaster") ? "Game Master" : "Player");
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        BackButton = new javax.swing.JButton();
        jLabel1 = new javax.swing.JLabel();
        NewUsernameField = new javax.swing.JTextField();
        NewPasswordField = new javax.swing.JTextField();
        ConfirmNewPasswordField = new javax.swing.JTextField();
        ConfirmButton = new javax.swing.JButton();
        TypeComboBox = new javax.swing.JComboBox<>();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        BackButton.setText("<");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        jLabel1.setText("Edit Profile Information for (...)");

        NewUsernameField.setText("Enter New Username");
        NewUsernameField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                NewUsernameFieldActionPerformed(evt);
            }
        });

        NewPasswordField.setText("Enter New Password");

        ConfirmNewPasswordField.setText("Confirm New Password");

        ConfirmButton.setText("Confirm");
        ConfirmButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ConfirmButtonActionPerformed(evt);
            }
        });

        TypeComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Player", "Game Master" }));

        jLabel2.setText("Enter New Username:");

        jLabel3.setText("Enter New Password:");

        jLabel4.setText("Confirm New Password:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addComponent(BackButton)
                .addGap(60, 60, 60)
                .addComponent(jLabel1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ConfirmButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(34, 34, 34)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jLabel3)
                            .addComponent(jLabel4))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(ConfirmNewPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(NewPasswordField, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(NewUsernameField, javax.swing.GroupLayout.DEFAULT_SIZE, 167, Short.MAX_VALUE)
                            .addComponent(TypeComboBox, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addGap(40, 40, 40))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(17, 17, 17)
                        .addComponent(BackButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(39, 39, 39)
                        .addComponent(jLabel1)))
                .addGap(44, 44, 44)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewUsernameField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(NewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmNewPasswordField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(18, 18, 18)
                .addComponent(TypeComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ConfirmButton)
                .addContainerGap(43, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackButtonActionPerformed
        if ("GameMaster".equalsIgnoreCase(userType) || "Game Master".equalsIgnoreCase(userType)) {
            new GameMaster(currentUsername).setVisible(true);
        } else {
            new Player(currentUsername).setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        String newUsername = NewUsernameField.getText().trim();
        String newPassword = NewPasswordField.getText().trim();
        String confirmPassword = ConfirmNewPasswordField.getText().trim();
        String newType = TypeComboBox.getSelectedItem().toString();

        // ✅ Check if nothing was changed
        if (newUsername.equals("Enter New Username") && newPassword.equals("Enter New Password") && confirmPassword.equals("Confirm New Password") && newType.equalsIgnoreCase("Game Master") && (userType.equalsIgnoreCase("GameMaster") || (newType.equalsIgnoreCase("Player") && userType.equalsIgnoreCase("Player")))) {
            JOptionPane.showMessageDialog(this, "No changes were made to your profile.", "No Changes", JOptionPane.INFORMATION_MESSAGE);
            return;
        } else {
        }

        int confirm = JOptionPane.showConfirmDialog(this,
                "Are you sure you want to update your profile?",
                "Confirm Changes", JOptionPane.YES_NO_OPTION);

        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            JSONParser parser = new JSONParser();
            FileReader reader = new FileReader(FILE_PATH);
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray users = (JSONArray) root.get("Accounts");

            if (users == null) {
                JOptionPane.showMessageDialog(this, "No users found in the database file.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            boolean updated = false;

            for (Object obj : users) {
                JSONObject user = (JSONObject) obj;
                if (user.get("username").toString().equals(currentUsername)) {

                    if (!newUsername.isBlank() && !newUsername.equals("Enter New Username")) {
                        user.put("username", newUsername);
                    } else {
                        newUsername = currentUsername; // Keep current if not changed
                    }

                    if (!newPassword.isBlank() && !newPassword.equals("Enter New Password")) {
                        if (!newPassword.equals(confirmPassword)) {
                            JOptionPane.showMessageDialog(this, "Passwords do not match!");
                            return;
                        }
                        user.put("password", newPassword);
                    }

                    if (newType != null && !newType.equals(user.get("type").toString())) {
                        user.put("type", newType);
                    }

                    updated = true;
                    break;
                }
            }

            if (updated) {
                try (FileWriter writer = new FileWriter(FILE_PATH)) {
                    root.put("Users", users);
                    writer.write(root.toJSONString());
                }
                JOptionPane.showMessageDialog(this, "Profile updated successfully!");

                if ("Game Master".equals(newType)) {
                    new GameMaster(newUsername).setVisible(true);
                } else {
                    new Player(newUsername).setVisible(true);
                }
                this.dispose();
            } else {
                JOptionPane.showMessageDialog(this, "User not found!");
            }

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error updating profile: " + e.getMessage());
        }
    }//GEN-LAST:event_ConfirmButtonActionPerformed

    private void NewUsernameFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_NewUsernameFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_NewUsernameFieldActionPerformed

    public static void main(String[] args) {
        new Profile("Game Master", "GameMasterName").setVisible(true);
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JTextField ConfirmNewPasswordField;
    private javax.swing.JTextField NewPasswordField;
    private javax.swing.JTextField NewUsernameField;
    private javax.swing.JComboBox<String> TypeComboBox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
