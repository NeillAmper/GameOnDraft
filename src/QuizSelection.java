
import javax.swing.JOptionPane;

public class QuizSelection extends javax.swing.JFrame {

    private static String Player, selected;
    private final String playerName;
    
    public QuizSelection(String playerName) {
        this.playerName = playerName;
        initComponents();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        playername = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        mathbtn = new javax.swing.JToggleButton();
        sciencebtn = new javax.swing.JToggleButton();
        historybtn = new javax.swing.JToggleButton();
        englishbtn = new javax.swing.JToggleButton();
        jButton1 = new javax.swing.JButton();
        Back = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        playername.setText("Enter player name");

        jLabel1.setText("Category Selection");

        jLabel2.setText("Please Select a Category");

        buttonGroup1.add(mathbtn);
        mathbtn.setText("Math");

        buttonGroup1.add(sciencebtn);
        sciencebtn.setText("Science");

        buttonGroup1.add(historybtn);
        historybtn.setText("History");

        buttonGroup1.add(englishbtn);
        englishbtn.setText("English");

        jButton1.setText("START GAME");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        Back.setText("<");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(101, 101, 101)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(playername, javax.swing.GroupLayout.PREFERRED_SIZE, 206, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(123, 123, 123)
                        .addComponent(jButton1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Back)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(92, 92, 92))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(mathbtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(sciencebtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(historybtn)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(englishbtn)))))
                .addContainerGap(74, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(Back)))
                .addGap(18, 18, 18)
                .addComponent(playername, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jLabel2)
                .addGap(47, 47, 47)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(mathbtn)
                    .addComponent(sciencebtn)
                    .addComponent(historybtn)
                    .addComponent(englishbtn))
                .addGap(18, 18, 18)
                .addComponent(jButton1)
                .addContainerGap(32, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        Player g = new Player(playerName);
        g.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed

        answer();

        GameUI_Entry();

    }//GEN-LAST:event_jButton1ActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new QuizSelection("Test").setVisible(true);
        });
    }

    public void answer() {
        Player = playername.getText();

        if (buttonGroup1.getSelection() == null) {
            JOptionPane.showMessageDialog(null, "Please select an answer to proceed.", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (Player.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter a player name to proceed.", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if (mathbtn.isSelected()) {
            selected = mathbtn.getActionCommand();
            System.out.println("You've selected: " + selected);
        }

        if (sciencebtn.isSelected()) {
            selected = sciencebtn.getActionCommand();
            System.out.println("You've selected: " + selected);
        }

        if (historybtn.isSelected()) {
            selected = historybtn.getActionCommand();
            System.out.println("You've selected: " + selected);
        }

        if (englishbtn.isSelected()) {
            selected = englishbtn.getActionCommand();
            System.out.println("You've selected: " + selected);
        }

        // Set the selected category to the static variable (for use in Quiz)
        QuizSelection.setCategorySelection(selected);

        setVisible(false);
    }

    public static void setCategorySelection(String category) {
        selected = category;  // This sets the selected category globally within QuizSelection
    }

    public void GameUI_Entry() {

        // Ensure the category is set before launching the quiz
        if (selected == null || selected.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please select a category to proceed.", "Error!", JOptionPane.ERROR_MESSAGE);
            return;
        }

        if ("Math".equals(selected)) {
            Quiz x = new Quiz(playerName);
            x.setVisible(true);
        }

        if ("Science".equals(selected)) {
            Quiz x = new Quiz(playerName);
            x.setVisible(true);
        }

        if ("History".equals(selected)) {
            Quiz x = new Quiz(playerName);
            x.setVisible(true);
        }

        if ("English".equals(selected)) {
            Quiz x = new Quiz(playerName);
            x.setVisible(true);
        }
    }

    public static String getCategorySelection_Player() {

        return Player;

    }

    public static String getCategorySelection_selected() {

        return selected;

    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JToggleButton englishbtn;
    private javax.swing.JToggleButton historybtn;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JToggleButton mathbtn;
    private javax.swing.JTextField playername;
    private javax.swing.JToggleButton sciencebtn;
    // End of variables declaration//GEN-END:variables
}
