
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
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Quiz extends javax.swing.JFrame {

    public static int score = 0;
    public static int maxscore = 0;
    private final String playerName;
    private String correctanswer;
    private static final String[] FILE_PATH = {"src/QuizData.json", "src/UserData.json"};
    private int index = 0;
    private String selectedCategory;
    private javax.swing.Timer questionTimer;
    private int timeLeft = 300;
    private final List<JSONObject> scenarioList = new ArrayList<>();
    private final List<String> scenarioHistory = new ArrayList<>();
    private final List<String> scenarioPaths = new ArrayList<>();

    public Quiz(String playerName) {
        initComponents();
        this.playerName = playerName;
        selectedCategory = QuizSelection.getCategorySelection_selected();
        if (selectedCategory == null || selectedCategory.isEmpty()) {
            selectedCategory = "Default";
        }
        loadQuizData();
        loadNextQuestion();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        questionLabel = new javax.swing.JLabel();
        categoryLabel = new javax.swing.JLabel();
        option1 = new javax.swing.JToggleButton();
        option2 = new javax.swing.JToggleButton();
        option3 = new javax.swing.JToggleButton();
        option4 = new javax.swing.JToggleButton();
        nextButton = new javax.swing.JButton();
        compbtn = new javax.swing.JButton();
        timerLabel = new javax.swing.JLabel();
        scenarioLabel = new javax.swing.JLabel();
        previousQuestionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        questionLabel.setText("jLabel1");

        categoryLabel.setText("jLabel2");

        buttonGroup1.add(option1);
        option1.setText("jToggleButton1");
        option1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1ActionPerformed(evt);
            }
        });

        buttonGroup1.add(option2);
        option2.setText("jToggleButton2");
        option2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2ActionPerformed(evt);
            }
        });

        buttonGroup1.add(option3);
        option3.setText("jToggleButton3");
        option3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option3ActionPerformed(evt);
            }
        });

        buttonGroup1.add(option4);
        option4.setText("jToggleButton4");
        option4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option4ActionPerformed(evt);
            }
        });

        nextButton.setText("Next");
        nextButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextButtonActionPerformed(evt);
            }
        });

        compbtn.setText("Complete");
        compbtn.setEnabled(false);
        compbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                compbtnActionPerformed(evt);
            }
        });

        timerLabel.setText("jLabel1");

        scenarioLabel.setText("jLabel1");

        previousQuestionButton.setText("Previous");
        previousQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousQuestionButtonActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(177, 177, 177)
                        .addComponent(nextButton)
                        .addGap(121, 121, 121)
                        .addComponent(compbtn))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(45, 45, 45)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(timerLabel)
                                .addGap(98, 98, 98))
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(previousQuestionButton)
                                .addComponent(option1)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(option2)
                                .addGap(18, 18, 18)
                                .addComponent(option3)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(option4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(categoryLabel)
                                .addGap(5, 5, 5)))))
                .addContainerGap(32, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(questionLabel)
                .addGap(274, 274, 274))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(273, 273, 273)
                .addComponent(scenarioLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(26, 26, 26)
                        .addComponent(categoryLabel))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(timerLabel)))
                .addGap(7, 7, 7)
                .addComponent(scenarioLabel)
                .addGap(44, 44, 44)
                .addComponent(questionLabel)
                .addGap(106, 106, 106)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option1)
                    .addComponent(option2)
                    .addComponent(option3)
                    .addComponent(option4))
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(nextButton)
                    .addComponent(compbtn)
                    .addComponent(previousQuestionButton))
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

    private void nextButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextButtonActionPerformed
        if (buttonGroup1.getSelection() == null) {
            JOptionPane.showMessageDialog(this, "Please select an answer.", "Warning", JOptionPane.WARNING_MESSAGE);
            return;
        }

        String selected = null;
        if (option1.isSelected()) {
            selected = option1.getText();
        }
        if (option2.isSelected()) {
            selected = option2.getText();
        }
        if (option3.isSelected()) {
            selected = option3.getText();
        }
        if (option4.isSelected()) {
            selected = option4.getText();
        }

        checkAnswer(selected);
        if (questionTimer != null) {
            questionTimer.stop();
        }
        loadNextQuestion();
    }//GEN-LAST:event_nextButtonActionPerformed

    private void option1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1ActionPerformed

    }//GEN-LAST:event_option1ActionPerformed

    private void option2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2ActionPerformed


    }//GEN-LAST:event_option2ActionPerformed

    private void option3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option3ActionPerformed


    }//GEN-LAST:event_option3ActionPerformed

    private void option4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option4ActionPerformed


    }//GEN-LAST:event_option4ActionPerformed

    private void compbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_compbtnActionPerformed
        try {
            saveQuizResults();
        } catch (IOException | ParseException e) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, e);
        }
        JOptionPane.showMessageDialog(this, "Quiz Completed!");
        dispose();
    }//GEN-LAST:event_compbtnActionPerformed

    private void previousQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousQuestionButtonActionPerformed
        if (index > 0) {
            index--;
            loadPreviousQuestion();
        }
    }//GEN-LAST:event_previousQuestionButtonActionPerformed

    private void loadQuizData() {
        try (FileReader reader = new FileReader(FILE_PATH[0])) {
            JSONParser jsonParser = new JSONParser();
            JSONObject quizData = (JSONObject) jsonParser.parse(reader);
            JSONArray quizzes = (JSONArray) quizData.get("Quizzes");

            for (Object obj : quizzes) {
                JSONObject quiz = (JSONObject) obj;
                String category = quiz.get("category").toString();

                if (category.equalsIgnoreCase(selectedCategory)) {
                    JSONArray questions = (JSONArray) quiz.get("questions");
                    for (Object qObj : questions) {
                        JSONObject question = (JSONObject) qObj;
                        JSONObject scenarioQuestion = new JSONObject();
                        scenarioQuestion.put("question", question.get("question"));
                        scenarioQuestion.put("option1", question.get("option1"));
                        scenarioQuestion.put("option2", question.get("option2"));
                        scenarioQuestion.put("option3", question.get("option3"));
                        scenarioQuestion.put("option4", question.get("option4"));
                        scenarioQuestion.put("answer", question.get("answer"));
                        scenarioQuestion.put("nextScenario", question.getOrDefault("nextScenario", ""));
                        scenarioList.add(scenarioQuestion);
                    }
                }
            }
        } catch (IOException | ParseException e) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadNextQuestion() {
        if (index >= scenarioList.size()) {
            compbtn.setEnabled(true);
            nextButton.setEnabled(false);
            if (questionTimer != null) {
                questionTimer.stop();
            }
            return;
        }

        JSONObject currentScenario = scenarioList.get(index);

        // Add question to scenarioHistory only if it's not already there
        if (!scenarioHistory.contains(currentScenario.get("question").toString())) {
            scenarioHistory.add(currentScenario.get("question").toString());
        }

        questionLabel.setText(currentScenario.get("question").toString());
        scenarioLabel.setText(currentScenario.getOrDefault("scenario", "Scenario").toString());
        option1.setText(currentScenario.get("option1").toString());
        option2.setText(currentScenario.get("option2").toString());
        option3.setText(currentScenario.get("option3").toString());
        option4.setText(currentScenario.get("option4").toString());
        correctanswer = currentScenario.get("answer").toString();

        maxscore++;
        buttonGroup1.clearSelection();
        startTimer();
        index++;
    }

    private void loadPreviousQuestion() {
        if (index < 0 || index >= scenarioList.size()) {
            return;
        }
        JSONObject previousScenario = scenarioList.get(index);
        questionLabel.setText(previousScenario.get("question").toString());
        scenarioLabel.setText(previousScenario.getOrDefault("scenario", "Scenario").toString());
        option1.setText(previousScenario.get("option1").toString());
        option2.setText(previousScenario.get("option2").toString());
        option3.setText(previousScenario.get("option3").toString());
        option4.setText(previousScenario.get("option4").toString());
        correctanswer = previousScenario.get("answer").toString();
    }

    private void checkAnswer(String selected) {
        if (selected.equals(correctanswer)) {
            score += 10;
        }

        JSONObject currentScenario = scenarioList.get(index - 1);
        String nextScenario = (String) currentScenario.get("nextScenario");

        // Add nextScenario to scenarioPaths only if it's not already there
        if (nextScenario != null && !nextScenario.isEmpty() && !scenarioPaths.contains(nextScenario)) {
            scenarioPaths.add(nextScenario);
            index = findNextQuestion(nextScenario);
        }
    }

    private int findNextQuestion(String nextScenario) {
        for (int i = 0; i < scenarioList.size(); i++) {
            JSONObject scenario = scenarioList.get(i);
            if (scenario.get("question").equals(nextScenario)) {
                return i;
            }
        }
        return index;
    }

    private void startTimer() {
        if (questionTimer != null) {
            questionTimer.stop();
        }

        timeLeft = 300; // Reset to 5 minutes
        timerLabel.setText("Time Left: " + formatTime(timeLeft));

        questionTimer = new javax.swing.Timer(1000, e -> {
            timeLeft--;
            timerLabel.setText("Time Left: " + formatTime(timeLeft));

            if (timeLeft <= 0) {
                questionTimer.stop();
                nextButtonActionPerformed(null);  // Automatically move to next question
            }
        });
        questionTimer.start();
    }

    private void saveQuizResults() throws IOException, ParseException {
        FileReader reader = new FileReader(FILE_PATH[1]);
        JSONParser jsonParser = new JSONParser();
        JSONObject userData = (JSONObject) jsonParser.parse(reader);
        JSONArray historyArray = (JSONArray) userData.get("History");
        JSONArray standingArray = (JSONArray) userData.get("Standing");

        JSONObject history = new JSONObject();
        history.put("player", playerName);
        history.put("score", score + "/" + maxscore);
        history.put("category", selectedCategory);
        history.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss")));
        history.put("status", score >= (maxscore / 2) ? "Passed" : "Failed");

        historyArray.add(history);

        boolean updated = false;
        for (Object obj : standingArray) {
            JSONObject standing = (JSONObject) obj;
            if (standing.get("player").equals(playerName) && standing.get("category").equals(selectedCategory)) {
                long quizzesDone = (long) standing.get("quizzesDone");
                standing.put("quizzesDone", quizzesDone + 1);
                updated = true;
                break;
            }
        }

        if (!updated) {
            JSONObject newStanding = new JSONObject();
            newStanding.put("player", playerName);
            newStanding.put("category", selectedCategory);
            newStanding.put("quizzesDone", 1L);
            standingArray.add(newStanding);
        }

        try (FileWriter writer = new FileWriter(FILE_PATH[1])) {
            writer.write(userData.toJSONString());
            writer.flush();
        }
    }

    private String formatTime(int seconds) {
        int minutes = seconds / 60;
        int remainingSeconds = seconds % 60;
        return String.format("%02d:%02d", minutes, remainingSeconds);
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Quiz("Player1").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JButton compbtn;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nextButton;
    private javax.swing.JToggleButton option1;
    private javax.swing.JToggleButton option2;
    private javax.swing.JToggleButton option3;
    private javax.swing.JToggleButton option4;
    private javax.swing.JButton previousQuestionButton;
    private javax.swing.JLabel questionLabel;
    private javax.swing.JLabel scenarioLabel;
    private javax.swing.JLabel timerLabel;
    // End of variables declaration//GEN-END:variables
}
