
import java.awt.HeadlessException;
import javax.swing.table.DefaultTableModel;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import java.awt.event.*;
import java.io.FileReader;
import java.io.IOException;
import java.util.*;
import javax.swing.JOptionPane;

public class Leaderboard extends javax.swing.JFrame {

    private final String adminName;
    private final String gameMasterName;
    private final String playerName;
    private final String usname;
    private final DefaultTableModel tableModel;
    private static final String[] FILE_PATH = {"src/QuizData.json", "src/UserData.json"};
    private boolean isLoadingCategories = false;

    public Leaderboard(String adminName, String gameMasterName, String playerName, String usname) {
        this.adminName = adminName;
        this.gameMasterName = gameMasterName;
        this.playerName = playerName;
        this.usname = usname;
        initComponents();
        tableModel = (DefaultTableModel) LeaderboardTable.getModel();
        loadCategories();
        loadAllLeaderboardData();
        addSearchListener();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        CategorySelection = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        LeaderboardTable = new javax.swing.JTable();
        Back = new javax.swing.JButton();
        SearchField = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Leaderboard");

        CategorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "All", "Math", "Science", "History", "English" }));
        CategorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategorySelectionActionPerformed(evt);
            }
        });

        LeaderboardTable.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null},
                {null, null, null, null, null}
            },
            new String [] {
                "Rank", "Title", "Player", "Quizzes Done", "Category"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        LeaderboardTable.addAncestorListener(new javax.swing.event.AncestorListener() {
            public void ancestorAdded(javax.swing.event.AncestorEvent evt) {
                LeaderboardTableAncestorAdded(evt);
            }
            public void ancestorMoved(javax.swing.event.AncestorEvent evt) {
            }
            public void ancestorRemoved(javax.swing.event.AncestorEvent evt) {
            }
        });
        jScrollPane1.setViewportView(LeaderboardTable);

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
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 375, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(31, 31, 31)
                                .addComponent(Back)
                                .addGap(85, 85, 85)
                                .addComponent(jLabel1))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(57, 57, 57)
                        .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(CategorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12)))
                .addContainerGap(19, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(13, 13, 13)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Back))
                .addGap(12, 12, 12)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(CategorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SearchField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 275, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
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
    }//GEN-LAST:event_BackActionPerformed

    private void CategorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategorySelectionActionPerformed
        // Skip if categories are still being loaded
        if (isLoadingCategories) {
            return;
        }
        String selectedCategory = (String) CategorySelection.getSelectedItem();
        if (selectedCategory != null) {
            filterByCategory(selectedCategory);
        }
    }//GEN-LAST:event_CategorySelectionActionPerformed

    private void LeaderboardTableAncestorAdded(javax.swing.event.AncestorEvent evt) {//GEN-FIRST:event_LeaderboardTableAncestorAdded
        // TODO add your handling code here:
    }//GEN-LAST:event_LeaderboardTableAncestorAdded

    private void loadAllLeaderboardData() {
        try (FileReader reader = new FileReader(FILE_PATH[1])) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray standing = (JSONArray) jsonObject.get("Standing");

            List<JSONObject> allData = new ArrayList<>();
            for (Object obj : standing) {
                allData.add((JSONObject) obj);
            }

            loadLeaderBoard(allData);
        } catch (IOException | ParseException ex) {
        }
    }

    private void filterByCategory(String selectedCategory) {
        try (FileReader reader = new FileReader(FILE_PATH[1])) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray standing = (JSONArray) jsonObject.get("Standing");

            List<JSONObject> filtered = new ArrayList<>();
            for (Object obj : standing) {
                JSONObject entry = (JSONObject) obj;
                String category = (String) entry.get("category");
                if (selectedCategory.equals("All") || selectedCategory.equalsIgnoreCase(category)) {
                    filtered.add(entry);
                }
            }

            // Load all data into the leaderboard table
            loadLeaderBoard(filtered);
        } catch (IOException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Error loading leaderboard: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void loadLeaderBoard(List<JSONObject> dataList) {
        tableModel.setRowCount(0);

        // Sort the data by quizzesDone in descending order
        dataList.sort((a, b) -> Long.compare((long) b.get("quizzesDone"), (long) a.get("quizzesDone")));

        int rank = 1;
        for (JSONObject obj : dataList) {
            // Determining rank titles
            String title = switch (rank) {
                case 1 ->
                    "Platinum";
                case 2 ->
                    "Gold";
                case 3 ->
                    "Silver";
                default ->
                    "Bronze";
            };

            Object quizzesDoneObj = obj.get("quizzesDone");
            long quizzesDone = (quizzesDoneObj instanceof Number) ? ((Number) quizzesDoneObj).longValue() : 0L;

            Object player = obj.get("player");
            Object category = obj.get("category");

            // Add all entries to the leaderboard table
            tableModel.addRow(new Object[]{
                rank, // Rank column
                title, // Title column
                player != null ? player.toString() : "", // Player name
                quizzesDone, // Number of quizzes done
                category != null ? category.toString() : "" // Category column
            });

            rank++;
        }
    }

    private void addSearchListener() {
        SearchField.addKeyListener(new KeyAdapter() {
            @Override
            public void keyReleased(KeyEvent e) {
                String keyword = SearchField.getText().trim().toLowerCase();
                if (keyword.isEmpty()) {
                    loadAllLeaderboardData();
                } else {
                    searchQuizzes(keyword);
                }
            }
        });
    }

    private void searchQuizzes(String keyword) {
        try (FileReader reader = new FileReader(FILE_PATH[1])) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray leaderboard = (JSONArray) jsonObject.get("Standing");

            List<JSONObject> allData = new ArrayList<>();
            for (Object obj : leaderboard) {
                allData.add((JSONObject) obj);
            }

            // Get highest score per player
            Map<String, JSONObject> bestScores = new HashMap<>();
            for (JSONObject entry : allData) {
                String player = (String) entry.get("player");
                if (player == null) {
                    continue;
                }

                long quizzesDone = (entry.get("quizzesDone") instanceof Number)
                        ? ((Number) entry.get("quizzesDone")).longValue()
                        : 0L;

                if (!bestScores.containsKey(player) || quizzesDone > (long) bestScores.get(player).get("quizzesDone")) {
                    bestScores.put(player, entry);
                }
            }

            List<JSONObject> sorted = new ArrayList<>(bestScores.values());
            sorted.sort((a, b) -> Long.compare((long) b.get("quizzesDone"), (long) a.get("quizzesDone")));

            List<Object[]> matchedRows = new ArrayList<>();
            String keywordLower = keyword.toLowerCase();

            for (int i = 0; i < sorted.size(); i++) {
                JSONObject entry = sorted.get(i);
                int rank = i + 1;

                String title = switch (rank) {
                    case 1 ->
                        "Platinum";
                    case 2 ->
                        "Gold";
                    case 3 ->
                        "Silver";
                    default ->
                        "Bronze";
                };

                String player = (String) entry.get("player");
                String category = (String) entry.get("category");
                long quizzesDone = (entry.get("quizzesDone") instanceof Number)
                        ? ((Number) entry.get("quizzesDone")).longValue()
                        : 0L;

                // Convert each field to lower case string
                String rankStr = String.valueOf(rank).toLowerCase();
                String titleStr = title.toLowerCase();
                String playerStr = player != null ? player.toLowerCase() : "";
                String quizzesDoneStr = String.valueOf(quizzesDone);
                String categoryStr = category != null ? category.toLowerCase() : "";

                // Check if keyword is in ANY field (partial match)
                boolean match = rankStr.contains(keywordLower)
                        || titleStr.contains(keywordLower)
                        || playerStr.contains(keywordLower)
                        || quizzesDoneStr.contains(keywordLower)
                        || categoryStr.contains(keywordLower);

                if (match) {
                    matchedRows.add(new Object[]{
                        rank,
                        title,
                        player != null ? player : "",
                        quizzesDone,
                        category != null ? category : ""
                    });
                }
            }

            tableModel.setRowCount(0);
            for (Object[] row : matchedRows) {
                tableModel.addRow(row);
            }

        } catch (IOException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Error loading search results: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void loadCategories() {
        isLoadingCategories = true;
        Set<String> categories = new HashSet<>();

        try (FileReader reader = new FileReader(FILE_PATH[1])) {
            JSONParser parser = new JSONParser();
            JSONObject jsonObject = (JSONObject) parser.parse(reader);
            JSONArray leaderboard = (JSONArray) jsonObject.get("Standing");

            for (Object obj : leaderboard) {
                JSONObject quiz = (JSONObject) obj;
                String category = (String) quiz.get("category");
                if (category != null && !category.isEmpty()) {
                    categories.add(category);
                }
            }

            // Populate category dropdown
            CategorySelection.removeAllItems();
            CategorySelection.addItem("All");
            for (String category : categories) {
                CategorySelection.addItem(category);
            }

        } catch (IOException | ParseException ex) {
            JOptionPane.showMessageDialog(this, "Error loading categories: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
        } finally {
            isLoadingCategories = false;
        }
    }

    // Main method for testing
    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Leaderboard("Player", "GameMaster", "Admin", "Test").setVisible(true);
        });
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JComboBox<String> CategorySelection;
    private javax.swing.JTable LeaderboardTable;
    private javax.swing.JTextField SearchField;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
