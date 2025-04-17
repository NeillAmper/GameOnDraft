
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import javax.swing.*;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Quiz extends javax.swing.JFrame {

    public static int score = 0;
    public static int maxscore = 0;
    private String playerName, correctanswer;
    private static final String[] FILE_PATH = {"src/QuizData.json", "src/UserData.json"};
    private final List<JSONObject> userlist = new ArrayList<>();
    private int index = 0;
    private String selectedCategory;
    private javax.swing.Timer questionTimer;
    private int timeLeft = 300; // 5 minutes per question

    public Quiz(String playerName) {
        initComponents();
        this.playerName = playerName;
        selectedCategory = QuizSelection.getCategorySelection_selected();
        if (selectedCategory == null || selectedCategory.isEmpty()) {
            selectedCategory = "Default";
        }
        loadQuizData(selectedCategory);
        startQuiz();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        questionUI = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        opt1UI = new javax.swing.JToggleButton();
        opt2UI = new javax.swing.JToggleButton();
        opt3UI = new javax.swing.JToggleButton();
        opt4UI = new javax.swing.JToggleButton();
        nxtbtn = new javax.swing.JButton();
        compbtn = new javax.swing.JButton();
        Timer = new javax.swing.JLabel();
        Score = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        questionUI.setText("jLabel1");

        jLabel2.setText("jLabel2");

        buttonGroup1.add(opt1UI);
        opt1UI.setText("jToggleButton1");
        opt1UI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt1UIActionPerformed(evt);
            }
        });

        buttonGroup1.add(opt2UI);
        opt2UI.setText("jToggleButton2");
        opt2UI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt2UIActionPerformed(evt);
            }
        });

        buttonGroup1.add(opt3UI);
        opt3UI.setText("jToggleButton3");
        opt3UI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt3UIActionPerformed(evt);
            }
        });

        buttonGroup1.add(opt4UI);
        opt4UI.setText("jToggleButton4");
        opt4UI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt4UIActionPerformed(evt);
            }
        });

        nxtbtn.setText("Next");
        nxtbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nxtbtnActionPerformed(evt);
            }
        });

        compbtn.setText("Complete");
        compbtn.setEnabled(false);
        compbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compbtnActionPerformed(evt);
            }
        });

        Timer.setText("jLabel1");

        Score.setText("jLabel1");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(nxtbtn)
                        .addGap(121, 121, 121)
                        .addComponent(compbtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(Timer)
                                .addGap(56, 56, 56)
                                .addComponent(Score))
                            .addComponent(opt1UI))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(opt2UI)
                                .addGap(18, 18, 18)
                                .addComponent(opt3UI)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(opt4UI))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel2)
                                .addGap(5, 5, 5)))))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(questionUI)
                .addGap(274, 274, 274))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(jLabel2))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Timer)
                            .addComponent(Score))))
                .addGap(68, 68, 68)
                .addComponent(questionUI)
                .addGap(106, 106, 106)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opt1UI)
                    .addComponent(opt2UI)
                    .addComponent(opt3UI)
                    .addComponent(opt4UI))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nxtbtn)
                    .addComponent(compbtn))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void nxtbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nxtbtnActionPerformed
        if (buttonGroup1.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Please select an answer.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }
        checkAnswer();
        if (questionTimer != null) {
            questionTimer.stop();
        }
        startQuiz();
    }//GEN-LAST:event_nxtbtnActionPerformed

    private void opt1UIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt1UIActionPerformed


    }//GEN-LAST:event_opt1UIActionPerformed

    private void opt2UIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt2UIActionPerformed


    }//GEN-LAST:event_opt2UIActionPerformed

    private void opt3UIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt3UIActionPerformed


    }//GEN-LAST:event_opt3UIActionPerformed

    private void opt4UIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt4UIActionPerformed


    }//GEN-LAST:event_opt4UIActionPerformed

    private void compbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compbtnActionPerformed
        playerName = QuizSelection.getCategorySelection_Player();
        try {
            saveResults();
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
        }
        dispose();
        new QuizResult(playerName, score, maxscore, selectedCategory).setVisible(true);
    }//GEN-LAST:event_compbtnActionPerformed

    private void loadQuizData(String selectedCategory) {
        try (FileReader reader = new FileReader(FILE_PATH[0])) {
            JSONObject root = (JSONObject) new JSONParser().parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            if (quizzes != null) {
                for (Object obj : quizzes) {
                    JSONObject quiz = (JSONObject) obj;
                    String category = (String) quiz.get("Category");

                    if (selectedCategory.equalsIgnoreCase(category)) {
                        JSONArray questions = (JSONArray) quiz.get("Questions");
                        if (questions != null) {
                            for (Object q : questions) {
                                JSONObject questionObj = (JSONObject) q;

                                JSONObject question = new JSONObject();
                                question.put("question", questionObj.get("question"));
                                question.put("answer", questionObj.get("answer"));
                                question.put("option1", questionObj.get("option1"));
                                question.put("option2", questionObj.get("option2"));
                                question.put("option3", questionObj.get("option3"));
                                question.put("option4", questionObj.get("option4"));
                                question.put("category", category);
                                question.put("scenarios", questionObj.get("scenarios")); // scenario branching
                                userlist.add(question);
                            }
                        }
                    }
                }
            }
        } catch (IOException | ParseException ex) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, ex);
            JOptionPane.showMessageDialog(this, "Failed to load quiz data.", "Error", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void startQuiz() {
        if (index < userlist.size()) {
            JSONObject current = userlist.get(index);
            questionUI.setText((String) current.get("question"));
            opt1UI.setText((String) current.get("option1"));
            opt2UI.setText((String) current.get("option2"));
            opt3UI.setText((String) current.get("option3"));
            opt4UI.setText((String) current.get("option4"));
            jLabel2.setText("Category: " + current.get("category"));
            correctanswer = (String) current.get("answer");

            JSONArray scenarios = (JSONArray) current.get("scenarios");
            if (scenarios != null && !scenarios.isEmpty()) {
                handleScenario((String) scenarios.get(0)); // Placeholder
            }

            buttonGroup1.clearSelection();
            startQuestionTimer();
            index++;
            maxscore++;
        } else {
            compbtn.setEnabled(true);
            nxtbtn.setEnabled(false);
            JOptionPane.showMessageDialog(this, "Quiz Completed!");
        }
    }

    private void checkAnswer() {
        if (opt1UI.isSelected() && opt1UI.getText().equalsIgnoreCase(correctanswer)) {
            score++;
        } else if (opt2UI.isSelected() && opt2UI.getText().equalsIgnoreCase(correctanswer)) {
            score++;
        } else if (opt3UI.isSelected() && opt3UI.getText().equalsIgnoreCase(correctanswer)) {
            score++;
        } else if (opt4UI.isSelected() && opt4UI.getText().equalsIgnoreCase(correctanswer)) {
            score++;
        }
        Score.setText("Score: " + score);
    }

    private void saveResults() throws IOException, ParseException {
        FileReader reader = new FileReader(FILE_PATH[1]);
        JSONObject root = (JSONObject) new JSONParser().parse(reader);
        JSONArray standings = (JSONArray) root.get("Standing");

        if (standings == null) {
            standings = new JSONArray();
            root.put("Standing", standings);
        }

        JSONObject result = new JSONObject();
        result.put("name", playerName);
        result.put("score", score);
        result.put("quizzesDone", maxscore);
        result.put("category", selectedCategory);
        standings.add(result);

        try (FileWriter writer = new FileWriter(FILE_PATH[1])) {
            writer.write(root.toJSONString());
        }
    }

    private void startQuestionTimer() {
        timeLeft = 300;
        Timer.setText("Time Left: " + formatTime(timeLeft));
        questionTimer = new javax.swing.Timer(1000, e -> {
            timeLeft--;
            Timer.setText("Time Left: " + formatTime(timeLeft));
            if (timeLeft <= 0) {
                questionTimer.stop();
                JOptionPane.showMessageDialog(this, "Time's up for this question!", "Time Up", JOptionPane.WARNING_MESSAGE);
                startQuiz();
            }
        });
        questionTimer.start();
    }

    private String formatTime(int time) {
        int minutes = time / 60;
        int seconds = time % 60;
        return String.format("%02d:%02d", minutes, seconds);
    }

    private void handleScenario(String scenario) {
        // Placeholder for branching logic
        System.out.println("Scenario: " + scenario);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Quiz("TestName").setVisible(true); // Replace "TestName" with any string for testing
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Score;
    private javax.swing.JLabel Timer;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JButton compbtn;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nxtbtn;
    private javax.swing.JToggleButton opt1UI;
    private javax.swing.JToggleButton opt2UI;
    private javax.swing.JToggleButton opt3UI;
    private javax.swing.JToggleButton opt4UI;
    private javax.swing.JLabel questionUI;
    // End of variables declaration//GEN-END:variables
}
