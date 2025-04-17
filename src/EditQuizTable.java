
import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import javax.swing.table.DefaultTableModel;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashSet;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EditQuizTable extends javax.swing.JFrame {

    private static final String[] FILE_PATH = {"src/QuizData.json", "src/UserData.json"};
    private final String gameMasterName;

    public EditQuizTable(String gameMasterName) {
        this.gameMasterName = gameMasterName;
        initComponents();
        loadQuizzesByCreator();
        populateCategorySelection(); // Populates category combo box with available categories
        loadCategoryQuizzes(); // Loads quizzes based on the selected category
        addSearchListener(); // Adds listener to search field for live updates
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        QuizTable = new javax.swing.JTable();
        SearchField = new javax.swing.JTextField();
        CategorySelection = new javax.swing.JComboBox<>();
        EditButton = new javax.swing.JButton();
        BackButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        QuizTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null},
                {null, null, null},
                {null, null, null},
                {null, null, null}
            },
            new String [] {
                "Category", "Quiz ID", "Question"
            }
        ));
        QuizTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                QuizTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(QuizTable);

        SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFieldActionPerformed(evt);
            }
        });

        CategorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Science", "Math", "History", "English" }));
        CategorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategorySelectionActionPerformed(evt);
            }
        });

        EditButton.setText("Edit");
        EditButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditButtonActionPerformed(evt);
            }
        });

        BackButton.setText("<");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(51, 51, 51)
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CategorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap(41, Short.MAX_VALUE)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 300, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addGap(59, 59, 59))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(EditButton)
                .addGap(82, 82, 82))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(14, 14, 14)
                .addComponent(BackButton)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(18, Short.MAX_VALUE)
                .addComponent(BackButton)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(CategorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(EditButton)
                .addGap(12, 12, 12))
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
        GameMaster g = new GameMaster(gameMasterName);
        g.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BackButtonActionPerformed

    private void CategorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategorySelectionActionPerformed
        loadCategoryQuizzes(); // WHEN CATEGORY IS CHANGED, RELOAD QUIZZES
    }//GEN-LAST:event_CategorySelectionActionPerformed

    private void EditButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditButtonActionPerformed
        int selectedRow = QuizTable.getSelectedRow();
        if (selectedRow == -1) {
            JOptionPane.showMessageDialog(this, "Please select a quiz to edit.");
            return;
        }

        String selectedQuizID = QuizTable.getValueAt(selectedRow, 1).toString();

        try (FileReader reader = new FileReader(FILE_PATH[0])) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;
                if (quiz.get("quizid").equals(selectedQuizID)) {
                    break;
                }
            }
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Failed to read quiz for undo.", "Error", JOptionPane.ERROR_MESSAGE);
        }

        EditQuiz e = new EditQuiz(selectedQuizID, gameMasterName);
        e.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_EditButtonActionPerformed

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        // Optional: Handle search field enter key
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void QuizTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_QuizTableAncestorAdded
        // Optional: Handle table ancestor events
    }//GEN-LAST:event_QuizTableAncestorAdded

    private void populateCategorySelection() {
        try (FileReader reader = new FileReader(FILE_PATH[0])) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");
            Set<String> categories = new HashSet<>();

            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;
                categories.add(quiz.get("category").toString());
            }

            CategorySelection.removeAllItems();
            CategorySelection.addItem("All");
            for (String category : categories) {
                CategorySelection.addItem(category);
            }

            // Set default selected item to "All"
            CategorySelection.setSelectedItem("All");

            // Load quizzes only after categories are populated
            loadCategoryQuizzes();

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Failed to load categories.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCategoryQuizzes() {
        DefaultTableModel model = (DefaultTableModel) QuizTable.getModel();
        model.setRowCount(0); // Clear current table data

        try (FileReader reader = new FileReader(FILE_PATH[0])) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            Object selectedItem = CategorySelection.getSelectedItem();
            if (selectedItem == null) {
                return; // No category selected yet
            }

            String selectedCategory = selectedItem.toString();
            String keyword = SearchField.getText().toLowerCase();

            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;
                String category = quiz.get("category").toString();
                String quizid = quiz.get("quizid").toString();
                String question = quiz.get("question").toString();

                // Convert values to lowercase for case-insensitive matching
                String categoryLower = category.toLowerCase();
                String quizidLower = quizid.toLowerCase();
                String questionLower = question.toLowerCase();

                // Filter by category from dropdown
                boolean categoryDropdownMatch = selectedCategory.equals("All") || category.equals(selectedCategory);

                // Filter by keyword match in category, quizid, or question
                boolean keywordMatch = keyword.isEmpty()
                        || categoryLower.contains(keyword)
                        || quizidLower.contains(keyword)
                        || questionLower.contains(keyword);

                if (categoryDropdownMatch && keywordMatch) {
                    model.addRow(new Object[]{
                        category,
                        quizid,
                        question
                    });
                }
            }

        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Failed to load quizzes.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // ADDED SEARCH LISTENER
    private void addSearchListener() {
        SearchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                loadCategoryQuizzes();
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                loadCategoryQuizzes();
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                loadCategoryQuizzes();
            }
        });
    }

    private void loadQuizzesByCreator() {
        try {
            JSONParser parser = new JSONParser();
            JSONObject data = (JSONObject) parser.parse(new FileReader("data.json"));
            JSONArray quizzes = (JSONArray) data.get("Quizzes");

            DefaultTableModel model = (DefaultTableModel) QuizTable.getModel();
            model.setRowCount(0);

            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;
                if (gameMasterName.equals(quiz.get("creator"))) {
                    model.addRow(new Object[]{
                        quiz.get("quizid"),
                        quiz.get("category"),
                        quiz.get("question")
                    });
                }
            }
        } catch (IOException | ParseException e) {
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> new EditQuizTable("Test").setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox<String> CategorySelection;
    private javax.swing.JButton EditButton;
    private javax.swing.JTable QuizTable;
    private javax.swing.JTextField SearchField;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables

}
