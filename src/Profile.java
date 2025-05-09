
import java.awt.HeadlessException;
import javax.swing.*;
import java.io.*;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.*;

public class Profile extends javax.swing.JFrame {

    private final String gameMasterName;
    private final String playerName;
    private final String adminName;
    private static final String[] FILE_PATH = {"src/QuizData.json", "src/UserData.json"};
    private final String usname; // Mark as final to ensure consistency

    public Profile(String adminName, String gameMasterName, String playerName, String usname) {
        this.adminName = adminName;
        this.gameMasterName = gameMasterName;
        this.playerName = playerName;
        this.usname = usname;

        fetchUserType(); // Fetch type if needed
        initComponents();

        // Correctly set the label to display the username
        jLabel1.setText("Edit Profile Information for " + this.usname);

        // Set the TypeComboBox based on the fetched user type
        if (this.usname != null) {
            TypeComboBox.setSelectedItem(fetchUserType().equalsIgnoreCase("GameMaster") ? "Game Master" : "Player");
        }
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
        DeleteButton = new javax.swing.JButton();

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

        DeleteButton.setText("Delete Account");
        DeleteButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteButtonActionPerformed(evt);
            }
        });

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
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(DeleteButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(ConfirmButton))
                    .addGroup(jPanel1Layout.createSequentialGroup()
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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(ConfirmButton)
                    .addComponent(DeleteButton))
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
        try {
            // Check if adminName is not null or empty
            if (adminName != null && !adminName.isEmpty()) {
                // Navigate back to Administrator with adminName and usname
                new Administrator(adminName, usname).setVisible(true);
            } // Check if gameMasterName is not null or empty
            else if (gameMasterName != null && !gameMasterName.isEmpty()) {
                // Navigate back to GameMaster with gameMasterName and usname
                new GameMaster(gameMasterName, usname).setVisible(true);
            } // Check if playerName is not null or empty
            else if (playerName != null && !playerName.isEmpty()) {
                // Navigate back to Player with appropriate parameters
                new Player(playerName, "Player", 1, 2, "Player", usname).setVisible(true);
            } else {
                // Display an error message if no valid user type is found
                JOptionPane.showMessageDialog(this, "No valid user type found to navigate back.", "Error", JOptionPane.WARNING_MESSAGE);
            }
        } catch (HeadlessException e) {
            // Handle unexpected exceptions and provide feedback to the user
            JOptionPane.showMessageDialog(this, "Error navigating back: " + e.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            // Dispose the current frame to return to the previous one
            this.dispose();
        }
    }//GEN-LAST:event_BackButtonActionPerformed

    private void ConfirmButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ConfirmButtonActionPerformed
        String newUsername = NewUsernameField.getText().trim();
        String newPassword = NewPasswordField.getText().trim();
        String confirmPassword = ConfirmNewPasswordField.getText().trim();
        String newType = TypeComboBox.getSelectedItem().toString();

        if (newUsername.equals("Enter New Username") && newPassword.equals("Enter New Password")
                && confirmPassword.equals("Confirm New Password") && newType.equalsIgnoreCase(usname)) {
            JOptionPane.showMessageDialog(this, "No changes were made to your profile.", "No Changes", JOptionPane.INFORMATION_MESSAGE);
            return;
        }

        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to update your profile?", "Confirm Changes", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            JSONParser parser = new JSONParser();
            JSONObject userData = (JSONObject) parser.parse(new FileReader(FILE_PATH[1]));
            JSONArray users = (JSONArray) userData.get("Accounts");

            boolean updated = false;

            for (Object obj : users) {
                JSONObject user = (JSONObject) obj;
                if (user.get("username").toString().equals(usname)) {
                    if (!newUsername.isBlank() && !newUsername.equals("Enter New Username")) {
                        user.put("username", newUsername);
                    } else {
                        newUsername = usname;
                    }

                    if (!newPassword.isBlank() && !newPassword.equals("Enter New Password")) {
                        if (!newPassword.equals(confirmPassword)) {
                            JOptionPane.showMessageDialog(this, "Passwords do not match!");
                            return;
                        }
                        user.put("password", newPassword);
                    }

                    if (!newType.equalsIgnoreCase(user.get("type").toString())) {
                        user.put("type", newType);
                    }

                    updated = true;
                    break;
                }
            }

            if (updated) {
                // Update quizzes
                JSONObject quizData = (JSONObject) parser.parse(new FileReader(FILE_PATH[0]));
                JSONArray quizzes = (JSONArray) quizData.get("Quizzes");
                for (Object obj : quizzes) {
                    JSONObject quiz = (JSONObject) obj;
                    if (!quiz.get("creator").toString().equals(usname)) {
                    } else {
                        quiz.put("creator", newUsername);
                    }
                }
                try (FileWriter writer = new FileWriter(FILE_PATH[0])) {
                    quizData.put("Quizzes", quizzes);
                    writer.write(quizData.toJSONString());
                }

                // Update history and standing
                JSONArray history = (JSONArray) userData.get("History");
                if (history != null) {
                    for (Object obj : history) {
                        JSONObject entry = (JSONObject) obj;
                        if (entry.get("player").toString().equals(usname)) {
                            entry.put("player", newUsername);
                        }
                    }
                }

                JSONArray standing = (JSONArray) userData.get("Standing");
                if (standing != null) {
                    for (Object obj : standing) {
                        JSONObject entry = (JSONObject) obj;
                        if (entry.get("player").toString().equals(usname)) {
                            entry.put("player", newUsername);
                        }
                    }
                }

                try (FileWriter writer = new FileWriter(FILE_PATH[1])) {
                    userData.put("Accounts", users);
                    userData.put("History", history);
                    userData.put("Standing", standing);
                    writer.write(userData.toJSONString());
                }

                JOptionPane.showMessageDialog(this, "Profile updated successfully!");

                if ("Game Master".equals(newType)) {
                    new GameMaster(newUsername, usname).setVisible(true);
                } else {
                    new Player(newUsername, "Player", 1, 2, "Player", usname).setVisible(true);
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

    private void DeleteButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteButtonActionPerformed
        int confirm = JOptionPane.showConfirmDialog(this, "Are you sure you want to permanently delete your account?\nThis will remove all associated data.", "Confirm Deletion", JOptionPane.YES_NO_OPTION);
        if (confirm != JOptionPane.YES_OPTION) {
            return;
        }

        try {
            JSONParser parser = new JSONParser();
            JSONObject userData = (JSONObject) parser.parse(new FileReader(FILE_PATH[1]));
            JSONArray accounts = (JSONArray) userData.get("Accounts");
            JSONArray history = (JSONArray) userData.get("History");
            JSONArray standing = (JSONArray) userData.get("Standing");

            accounts.removeIf(obj -> ((JSONObject) obj).get("username").toString().equals(usname));
            if (history != null) {
                history.removeIf(obj -> ((JSONObject) obj).get("player").toString().equals(usname));
            }
            if (standing != null) {
                standing.removeIf(obj -> ((JSONObject) obj).get("player").toString().equals(usname));
            }

            try (FileWriter writer = new FileWriter(FILE_PATH[1])) {
                userData.put("Accounts", accounts);
                userData.put("History", history);
                userData.put("Standing", standing);
                writer.write(userData.toJSONString());
            }

            // Remove user's quizzes
            JSONObject quizData = (JSONObject) parser.parse(new FileReader(FILE_PATH[0]));
            JSONArray quizzes = (JSONArray) quizData.get("Quizzes");
            quizzes.removeIf(obj -> {
                return ((JSONObject) obj).get("creator").toString().equals(usname);
            });

            try (FileWriter writer = new FileWriter(FILE_PATH[0])) {
                quizData.put("Quizzes", quizzes);
                writer.write(quizData.toJSONString());
            }

            JOptionPane.showMessageDialog(this, "Account deleted successfully.");
            new SignIn(usname, "test").setVisible(true);
            this.dispose();

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error deleting account: " + e.getMessage());
        }
    }//GEN-LAST:event_DeleteButtonActionPerformed

    private String fetchUserType() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject userData = (JSONObject) parser.parse(new FileReader(FILE_PATH[1]));
            JSONArray accounts = (JSONArray) userData.get("Accounts");
            for (Object obj : accounts) {
                JSONObject user = (JSONObject) obj;
                if (user.get("username").toString().equals(usname)) {
                    return user.get("type").toString(); // Return the user type
                }
            }
        } catch (IOException | ParseException e) {
            return "Unknown"; // Return "Unknown" in case of an error
        }
        return "Unknown"; // Default return value if user not found
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Profile("Player", "GameMaster", "Admin", "User").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JButton ConfirmButton;
    private javax.swing.JTextField ConfirmNewPasswordField;
    private javax.swing.JButton DeleteButton;
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
