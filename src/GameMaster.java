
public class GameMaster extends javax.swing.JFrame {

    private final String gameMasterName;
    private final String usname;

    public GameMaster(String gameMasterName, String usname) {
        this.gameMasterName = gameMasterName;
        this.usname = usname;
        initComponents();
        WelcomeMessage.setText("Welcome, Game Master" + gameMasterName + "!"); // ✅ Fixed from usernameLabel
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        WelcomeMessage = new javax.swing.JLabel();
        CreateQuiz = new javax.swing.JButton();
        DeleteQuiz = new javax.swing.JButton();
        EditQuiz = new javax.swing.JButton();
        Leaderboard = new javax.swing.JButton();
        History = new javax.swing.JButton();
        Logout = new javax.swing.JButton();
        ProfileButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        WelcomeMessage.setText("Welcome, Game Master (...)!");

        CreateQuiz.setText("Create Quiz");
        CreateQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateQuizActionPerformed(evt);
            }
        });

        DeleteQuiz.setText("Delete Quiz");
        DeleteQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                DeleteQuizActionPerformed(evt);
            }
        });

        EditQuiz.setText("Edit Quiz");
        EditQuiz.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditQuizActionPerformed(evt);
            }
        });

        Leaderboard.setText("Leaderboard");
        Leaderboard.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaderboardActionPerformed(evt);
            }
        });

        History.setText("History");
        History.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                HistoryActionPerformed(evt);
            }
        });

        Logout.setText("Logout");
        Logout.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LogoutActionPerformed(evt);
            }
        });

        ProfileButton.setText("Profile");
        ProfileButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ProfileButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(106, 106, 106)
                        .addComponent(WelcomeMessage))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(139, 139, 139)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(Leaderboard, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(EditQuiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(DeleteQuiz, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(History, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(Logout, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CreateQuiz)
                            .addComponent(ProfileButton, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap(128, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(WelcomeMessage)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(CreateQuiz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(DeleteQuiz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(EditQuiz)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(Leaderboard)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(History)
                .addGap(7, 7, 7)
                .addComponent(ProfileButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(Logout)
                .addContainerGap(31, Short.MAX_VALUE))
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

    private void LogoutActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LogoutActionPerformed
        SignIn b = new SignIn(usname, "pass");
        b.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_LogoutActionPerformed

    private void CreateQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateQuizActionPerformed
        this.setVisible(false);
        new CreateQuiz(gameMasterName, usname).setVisible(true);
    }//GEN-LAST:event_CreateQuizActionPerformed

    private void DeleteQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_DeleteQuizActionPerformed
        this.setVisible(false);
        new DeleteQuiz(gameMasterName, usname).setVisible(true);
    }//GEN-LAST:event_DeleteQuizActionPerformed

    private void EditQuizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditQuizActionPerformed
        this.setVisible(false);
        new EditQuizTable(gameMasterName, usname).setVisible(true); // ✅ Fixed here
    }//GEN-LAST:event_EditQuizActionPerformed

    private void LeaderboardActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaderboardActionPerformed
        String gameMasterName = usname;
        this.setVisible(false);
        new Leaderboard(gameMasterName, usname, "GameMaster", "GameMaster").setVisible(true); // ✅ Fixed by adding "GameMaster"
    }//GEN-LAST:event_LeaderboardActionPerformed

    private void HistoryActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_HistoryActionPerformed
        this.setVisible(false);
        new History(gameMasterName, usname, "GameMaster", "GameMaster").setVisible(true);
    }//GEN-LAST:event_HistoryActionPerformed

    private void ProfileButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ProfileButtonActionPerformed
        this.setVisible(false);
        new Profile(gameMasterName, null, "Game Master", gameMasterName).setVisible(true);
    }//GEN-LAST:event_ProfileButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new GameMaster("TestName", "Testss").setVisible(true); // Replace "TestName" with any string for testing
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton CreateQuiz;
    private javax.swing.JButton DeleteQuiz;
    private javax.swing.JButton EditQuiz;
    private javax.swing.JButton History;
    private javax.swing.JButton Leaderboard;
    private javax.swing.JButton Logout;
    private javax.swing.JButton ProfileButton;
    private javax.swing.JLabel WelcomeMessage;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
