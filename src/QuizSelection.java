
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import java.io.FileReader;
import java.io.IOException;
import org.json.simple.*;
import org.json.simple.parser.*;

public class QuizSelection extends javax.swing.JFrame {

    private final String quizData;
    private final String playerName;
    private JSONArray quizzesArray;

    public QuizSelection(String playerName, String quizData) {
        this.playerName = playerName;
        this.quizData = quizData;
        initComponents();
        loadQuizData();
        populateTable(quizzesArray);
        
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        quizSelection = new javax.swing.JLabel();
        startButton = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        quizTable = new javax.swing.JTable();
        categorySelection = new javax.swing.JComboBox<>();
        searchField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        quizSelection.setText("Select a quiz!");

        startButton.setText("START GAME");
        startButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                startButtonActionPerformed(evt);
            }
        });

        Back.setText("<");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        quizTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Quiz Title", "Creator", "Category"
            }
        ));
        jScrollPane1.setViewportView(quizTable);

        categorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Math", "Science", "History", "English", " " }));
        categorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorySelectionActionPerformed(evt);
            }
        });

        searchField.setText("            ");
        searchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                searchFieldActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(18, 18, 18)
                            .addComponent(Back)
                            .addGap(102, 102, 102)
                            .addComponent(quizSelection))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(124, 124, 124)
                            .addComponent(startButton))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(36, 36, 36)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 307, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(53, 53, 53)
                        .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(categorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(56, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(Back)
                    .addComponent(quizSelection))
                .addGap(22, 22, 22)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(searchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(startButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
        new Player(playerName, "Player", 1, 2, "Player").setVisible(true);
        this.dispose();
    }//GEN-LAST:event_BackActionPerformed

    private void startButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_startButtonActionPerformed
        int row = quizTable.getSelectedRow();
        if (row == -1) {
            JOptionPane.showMessageDialog(this, "Please select a quiz from the table.");
            return;
        }

        String selectedTitle = (String) quizTable.getValueAt(row, 0);
        for (Object o : quizzesArray) {
            JSONObject quiz = (JSONObject) o;
            if (quiz.get("QuizTitle").equals(selectedTitle)) {
                Quiz quizFrame = new Quiz(playerName, quizData); // You'll need this constructor
                quizFrame.setVisible(true);
                this.dispose();
                return;
            }
        }

        JOptionPane.showMessageDialog(this, "Selected quiz data not found.");
    }//GEN-LAST:event_startButtonActionPerformed

    private void searchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_searchFieldActionPerformed
        String text = searchField.getText().trim().toLowerCase();
        JSONArray filtered = new JSONArray();

        for (Object o : quizzesArray) {
            JSONObject quiz = (JSONObject) o;
            String title = ((String) quiz.get("QuizTitle")).toLowerCase();
            String creator = ((String) quiz.get("Creator")).toLowerCase();
            String category = ((String) quiz.get("Category")).toLowerCase();

            if (title.contains(text) || creator.contains(text) || category.contains(text)) {
                filtered.add(quiz);
            }
        }

        populateTable(filtered);
    }//GEN-LAST:event_searchFieldActionPerformed

    private void categorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorySelectionActionPerformed
        String selectedCategory = (String) categorySelection.getSelectedItem();
        if (selectedCategory.equals("All")) {
            populateTable(quizzesArray);
            return;
        }

        JSONArray filtered = new JSONArray();
        for (Object o : quizzesArray) {
            JSONObject quiz = (JSONObject) o;
            String category = (String) quiz.get("Category");
            if (category.equalsIgnoreCase(selectedCategory)) {
                filtered.add(quiz);
            }
        }

        populateTable(filtered);
    }//GEN-LAST:event_categorySelectionActionPerformed

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new QuizSelection("Test", "Tests").setVisible(true);
        });
    }

    private void loadQuizData() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject obj = (JSONObject) parser.parse(new FileReader("QuizData.json"));
            quizzesArray = (JSONArray) obj.get("Quizzes");
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Failed to load quiz data.");
            quizzesArray = new JSONArray();
        }
    }

    private void populateTable(JSONArray array) {
        DefaultTableModel model = (DefaultTableModel) quizTable.getModel();
        model.setRowCount(0); // Clear existing rows

        for (Object o : array) {
            JSONObject quiz = (JSONObject) o;
            String title = (String) quiz.get("QuizTitle");
            String creator = (String) quiz.get("Creator");
            String category = (String) quiz.get("Category");
            model.addRow(new Object[]{title, creator, category});
        }
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JComboBox<String> categorySelection;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel quizSelection;
    private javax.swing.JTable quizTable;
    private javax.swing.JTextField searchField;
    private javax.swing.JButton startButton;
    // End of variables declaration//GEN-END:variables
}
