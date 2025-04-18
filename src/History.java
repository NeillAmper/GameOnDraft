
import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.swing.event.DocumentListener;
import javax.swing.event.DocumentEvent;

public class History extends javax.swing.JFrame {

    private final String gameMasterName;
    private final String playerName;
    private static final String FILE_PATH = "src/UserData.json"; // Correct file path

    public History(String gameMasterName, String playerName) {
        this.gameMasterName = gameMasterName;
        this.playerName = playerName;
        initComponents();
        populateCategorySelection(); // Populate the combo box
        loadHistory(); // Load history data
        addSearchListener(); // Adds listener to search field for live updates
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        HistoryTable = new javax.swing.JTable();
        BackButton = new javax.swing.JButton();
        SearchField = new javax.swing.JTextField();
        CategorySelection = new javax.swing.JComboBox<>();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("History");

        HistoryTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Player", "Category", "Score", "Result", "Timestamp"
            }
        ));
        HistoryTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                HistoryTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(HistoryTable);

        BackButton.setText("<");
        BackButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackButtonActionPerformed(evt);
            }
        });

        SearchField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                SearchFieldActionPerformed(evt);
            }
        });

        CategorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Math", "Science", "History", "English" }));
        CategorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategorySelectionActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(BackButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(49, 49, 49)
                            .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 212, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(CategorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 615, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(17, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(BackButton))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(CategorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(47, 47, 47)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 340, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(46, Short.MAX_VALUE))
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
        if (gameMasterName != null && !gameMasterName.isEmpty()) {
            new GameMaster(gameMasterName).setVisible(true);
        } else if (playerName != null && !playerName.isEmpty()) {
            new Player(playerName, "Player", 1, 2, "Player").setVisible(true);
        }
        this.dispose();
    }//GEN-LAST:event_BackButtonActionPerformed

    private void HistoryTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_HistoryTableAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_HistoryTableAncestorAdded

    private void SearchFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_SearchFieldActionPerformed
        String keyword = SearchField.getText().trim();
        if (!keyword.isEmpty()) {
            searchHistory(keyword);
        } else {
            loadHistory();
        }
    }//GEN-LAST:event_SearchFieldActionPerformed

    private void CategorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategorySelectionActionPerformed
        String keyword = SearchField.getText().trim();
        if (!keyword.isEmpty()) {
            searchHistory(keyword);
        } else {
            loadHistory();
        }
    }//GEN-LAST:event_CategorySelectionActionPerformed

    private void loadHistory() {
        String selectedCategory = (String) CategorySelection.getSelectedItem();
        if (selectedCategory == null) {
            selectedCategory = "All";
        }

        DefaultTableModel model = (DefaultTableModel) HistoryTable.getModel();
        model.setRowCount(0);

        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray history = (JSONArray) root.get("History");

            if (history == null) {
                JOptionPane.showMessageDialog(this, "Tries data is missing or empty.", "Error", JOptionPane.ERROR_MESSAGE);
                return;
            }

            ArrayList<JSONObject> entries = new ArrayList<>();
            for (Object obj : history) {
                JSONObject entry = (JSONObject) obj;
                String category = (String) entry.get("category");
                String player = (String) entry.get("player");

                // Only add entries:
                // 1. If Administrator, allow all
                // 2. If Game Master, allow only game master's entries
                // 3. If Player, allow only that player's entries
                boolean canView = false;
                if ("Administrator".equals(playerName)) {
                    canView = true;
                } else if (gameMasterName != null && !gameMasterName.isEmpty()) {
                    canView = gameMasterName.equals(player);
                } else if (playerName != null && !playerName.isEmpty()) {
                    canView = playerName.equals(player);
                }

                if (canView && (selectedCategory.equals("All") || selectedCategory.equals(category))) {
                    entries.add(entry);
                }
            }

            Collections.sort(entries, (JSONObject o1, JSONObject o2) -> {
                String scoreStr1 = (String) o1.get("score");
                String scoreStr2 = (String) o2.get("score");

                int score1 = Integer.parseInt(scoreStr1.split("/")[0].trim());
                int score2 = Integer.parseInt(scoreStr2.split("/")[0].trim());

                return Integer.compare(score2, score1);
            });

            for (JSONObject entry : entries) {
                model.addRow(new Object[]{
                    entry.get("player"),
                    entry.get("category"),
                    entry.get("score"),
                    entry.get("result"),
                    entry.get("timestamp")
                });
            }

        } catch (IOException | ParseException | NumberFormatException e) {
            JOptionPane.showMessageDialog(this, "Failed to load history!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void populateCategorySelection() {
        try (FileReader reader = new FileReader(FILE_PATH)) { // Fixed file path issue
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray history = (JSONArray) root.get("History");

            Set<String> categories = new HashSet<>();
            for (Object obj : history) {
                JSONObject entry = (JSONObject) obj;
                categories.add((String) entry.get("category"));
            }

            // Add categories to the selection box
            CategorySelection.removeAllItems();
            CategorySelection.addItem("All");
            for (String category : categories) {
                CategorySelection.addItem(category);
            }
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error populating categories.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void addSearchListener() {
        SearchField.getDocument().addDocumentListener(new DocumentListener() {
            @Override
            public void insertUpdate(DocumentEvent e) {
                searchHistory(SearchField.getText().trim());
            }

            @Override
            public void removeUpdate(DocumentEvent e) {
                searchHistory(SearchField.getText().trim());
            }

            @Override
            public void changedUpdate(DocumentEvent e) {
                searchHistory(SearchField.getText().trim());
            }
        });
    }

    private void searchHistory(String keyword) {
        String selectedCategory = (String) CategorySelection.getSelectedItem();
        if (selectedCategory == null) {
            selectedCategory = "All";
        }

        DefaultTableModel model = (DefaultTableModel) HistoryTable.getModel();
        model.setRowCount(0);

        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONParser parser = new JSONParser();
            JSONObject root = (JSONObject) parser.parse(reader);
            JSONArray history = (JSONArray) root.get("History");

            for (Object obj : history) {
                JSONObject entry = (JSONObject) obj;
                String player = (String) entry.get("player");
                String category = (String) entry.get("category");
                String score = (String) entry.get("score");
                String result = (String) entry.get("result");
                String timestamp = (String) entry.get("timestamp");

                // Check access permission
                boolean canView = false;
                if ("Administrator".equals(playerName)) {
                    canView = true;
                } else if (gameMasterName != null && !gameMasterName.isEmpty()) {
                    canView = gameMasterName.equals(player);
                } else if (playerName != null && !playerName.isEmpty()) {
                    canView = playerName.equals(player);
                }

                if (!canView) {
                    continue;
                }

                // Match keyword against any relevant field
                boolean matchesKeyword = player.toLowerCase().contains(keyword.toLowerCase())
                        || category.toLowerCase().contains(keyword.toLowerCase())
                        || score.toLowerCase().contains(keyword.toLowerCase())
                        || result.toLowerCase().contains(keyword.toLowerCase())
                        || timestamp.toLowerCase().contains(keyword.toLowerCase());

                boolean matchesCategory = selectedCategory.equals("All") || selectedCategory.equals(category);

                if (matchesKeyword && matchesCategory) {
                    model.addRow(new Object[]{player, category, score, result, timestamp});
                }
            }
        } catch (IOException | ParseException e) {
            JOptionPane.showMessageDialog(this, "Error searching history!", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    // Main method for testing
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new History("Player", "GameMaster").setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton BackButton;
    private javax.swing.JComboBox<String> CategorySelection;
    private javax.swing.JTable HistoryTable;
    private javax.swing.JTextField SearchField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
