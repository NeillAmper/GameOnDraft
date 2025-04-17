

public final class QuizResult extends javax.swing.JFrame {

    private final String playerName;
    private final String category;
    private final int maxScore;
    private final int finalScore;
    private final String quizData;

    public QuizResult(String playerName, String quizData, int finalScore, int maxScore, String category) {
        this.quizData = quizData;
        this.playerName = playerName;
        this.finalScore = finalScore;
        this.maxScore = maxScore;
        this.category = category;

        initComponents();
        displayResults(); // Show the passed data in UI
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        MenuButton = new javax.swing.JButton();
        LeaderboardButton = new javax.swing.JButton();
        RetryButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        categoryUI = new javax.swing.JLabel();
        scoreUI = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("QUIZ DONE!");

        jLabel2.setText("Score:");

        jLabel3.setText("Good Job!");

        MenuButton.setText("Menu");
        MenuButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                MenuButtonActionPerformed(evt);
            }
        });

        LeaderboardButton.setText("Leaderboard");
        LeaderboardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                LeaderboardButtonActionPerformed(evt);
            }
        });

        RetryButton.setText("Retry");
        RetryButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                RetryButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Category:");

        jLabel5.setText("jLabel5");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(22, 22, 22)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel4)
                            .addComponent(MenuButton))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(39, 39, 39)
                                .addComponent(LeaderboardButton)
                                .addGap(34, 34, 34)
                                .addComponent(RetryButton))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(51, 51, 51)
                                .addComponent(jLabel1))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(scoreUI, javax.swing.GroupLayout.PREFERRED_SIZE, 141, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(categoryUI, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE)))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(152, 152, 152)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(148, 148, 148)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addComponent(jLabel3))))
                .addContainerGap(30, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(29, 29, 29)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(categoryUI, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4))
                .addGap(31, 31, 31)
                .addComponent(jLabel2)
                .addGap(15, 15, 15)
                .addComponent(scoreUI, javax.swing.GroupLayout.PREFERRED_SIZE, 16, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(MenuButton)
                    .addComponent(LeaderboardButton)
                    .addComponent(RetryButton))
                .addContainerGap(22, Short.MAX_VALUE))
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

    private void RetryButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_RetryButtonActionPerformed
        this.setVisible(false);
        new QuizSelection(playerName, quizData).setVisible(true);
    }//GEN-LAST:event_RetryButtonActionPerformed

    private void LeaderboardButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_LeaderboardButtonActionPerformed
        this.setVisible(false);
        new Leaderboard(playerName, quizData).setVisible(true); // ✅ Fixed by adding "GameMaster"
    }//GEN-LAST:event_LeaderboardButtonActionPerformed

    private void MenuButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_MenuButtonActionPerformed
        Player p = new Player(playerName, "Player", 1, 2, "Player");
        p.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_MenuButtonActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new QuizResult("DefaultPlayer", "Science", 1, 2, "Test").setVisible(true); // Example
        });
    }

    private void displayResults() {
        categoryUI.setText(category != null ? category : "N/A");
        scoreUI.setText(finalScore + " / " + maxScore);
    }
    public void entryTime() {
        // Reserved for future enhancements
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton LeaderboardButton;
    private javax.swing.JButton MenuButton;
    private javax.swing.JButton RetryButton;
    private javax.swing.JLabel categoryUI;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel scoreUI;
    // End of variables declaration//GEN-END:variables
}
