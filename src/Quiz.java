
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
    private final String usname;
    private final String quizData;
    private String correctanswer;
    private static final String[] FILE_PATH = {"src/QuizData.json", "src/UserData.json"};
    private int index = 0;
    private final String selectedQuiz;
    private javax.swing.Timer questionTimer;
    private int timeLeft = 300;  // 5-minute timer per question
    private final List<JSONObject> scenarioList = new ArrayList<>();
    private final List<String> scenarioHistory = new ArrayList<>();
    private final List<String> scenarioPaths = new ArrayList<>();
    private final List<JSONObject> answerLog = new ArrayList<>(); // ✅ log of question answers

    public Quiz(String playerName, String quizData, String selectedQuiz, String usname) {
        initComponents();
        this.playerName = playerName;
        this.usname = usname;
        this.quizData = quizData;
        this.selectedQuiz = selectedQuiz;
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
        completeButton = new javax.swing.JButton();
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

        completeButton.setText("Complete");
        completeButton.setEnabled(false);
        completeButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                completeButtonActionPerformed(evt);
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
                        .addComponent(completeButton))
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
                    .addComponent(completeButton)
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

    private void completeButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_completeButtonActionPerformed
        try {
            saveQuizResults();
        } catch (IOException | ParseException e) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, e);
        }
        JOptionPane.showMessageDialog(this, "Quiz Completed!");
        this.setVisible(false);
        new QuizResult(playerName, quizData, score, maxscore, "Player", usname).setVisible(true);
    }//GEN-LAST:event_completeButtonActionPerformed

    private void previousQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousQuestionButtonActionPerformed
        if (index > 0) {
            index--;
            loadPreviousQuestion();
        }
    }//GEN-LAST:event_previousQuestionButtonActionPerformed

    private void loadQuizData() {
        try {
            // Load the quiz data from the QuizData.json
            FileReader reader = new FileReader(FILE_PATH[0]);
            JSONParser parser = new JSONParser();
            JSONArray quizzes = (JSONArray) parser.parse(reader);

            // Loop through the quizzes and find the selected quiz
            for (Object obj : quizzes) {
                JSONObject quizEntry = (JSONObject) obj;  // Renamed variable to quizEntry
                if (quizEntry.get("title").equals(selectedQuiz)) {  // Match the selected quiz title
                    JSONArray questions = (JSONArray) quizEntry.get("questions");  // Get the questions array

                    // Add questions to the scenarioList and set maxscore
                    for (Object questionObj : questions) {
                        JSONObject questionData = (JSONObject) questionObj;
                        scenarioList.add(questionData);
                        maxscore++;  // Increment the score count
                    }
                    break;  // Exit after finding the selected quiz
                }
            }
        } catch (IOException | ParseException e) {
            Logger.getLogger(Quiz.class.getName()).log(Level.SEVERE, null, e);
        }
    }

    private void loadNextQuestion() {
        if (index < scenarioList.size()) {
            if (questionTimer != null) {
                questionTimer.stop();
            }

            JSONObject currentScenario = scenarioList.get(index);
            questionLabel.setText((String) currentScenario.get("question"));
            option1.setText((String) currentScenario.get("option1"));
            option2.setText((String) currentScenario.get("option2"));
            option3.setText((String) currentScenario.get("option3"));
            option4.setText((String) currentScenario.get("option4"));
            correctanswer = (String) currentScenario.get("answer");

            String scenario = (String) currentScenario.get("scenario");
            scenarioLabel.setText(scenario != null ? scenario : "");

            scenarioHistory.add((String) currentScenario.get("scenario"));
            scenarioPaths.add((String) currentScenario.get("path"));

            JOptionPane.showMessageDialog(this, "Scenario: " + scenario);

            timeLeft = 300;
            startTimer();

            index++;
        } else {
            completeButton.setEnabled(true);
            nextButton.setEnabled(false);
            JOptionPane.showMessageDialog(this, "You have completed the quiz!", "Complete", JOptionPane.INFORMATION_MESSAGE);
        }
    }

    private void startTimer() {
        timeLeft = 300;

        if (questionTimer != null) {
            questionTimer.stop();
        }

        questionTimer = new javax.swing.Timer(1000, e -> {
            if (timeLeft > 0) {
                timeLeft--;
                LocalDateTime time = LocalDateTime.now();
                DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd, hh:mm a");
                String formattedDate = time.format(formatter);
                timerLabel.setText(formattedDate + " | Time Left: " + timeLeft + "s");
            } else {
                JOptionPane.showMessageDialog(this, "Time's up!");
                loadNextQuestion();
            }
        });
        questionTimer.start();
    }

    private void checkAnswer(String selectedAnswer) {
        boolean correct = selectedAnswer.equals(correctanswer);
        if (correct) {
            score++;
        }

        JSONObject answerEntry = new JSONObject();
        answerEntry.put("question", questionLabel.getText());
        answerEntry.put("selectedAnswer", selectedAnswer);
        answerEntry.put("correctAnswer", correctanswer);
        answerEntry.put("isCorrect", correct);
        answerLog.add(answerEntry);

        String feedbackMessage = correct ? "Correct!" : "Incorrect. The correct answer is: " + correctanswer;
        JOptionPane.showMessageDialog(this, feedbackMessage);
    }

    private void saveQuizResults() throws IOException, ParseException {
        JSONObject historyData = new JSONObject();
        historyData.put("player", playerName);
        historyData.put("score", score + "/" + maxscore);
        historyData.put("category", selectedQuiz);
        historyData.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd, hh:mm a")));
        historyData.put("status", score == maxscore ? "pass" : "fail");

        JSONArray answers = new JSONArray();
        answers.addAll(answerLog);
        historyData.put("answers", answers);

        FileReader reader = new FileReader(FILE_PATH[1]);
        JSONParser parser = new JSONParser();
        JSONObject userData = (JSONObject) parser.parse(reader);
        JSONArray historyArray = (JSONArray) userData.get("History");
        historyArray.add(historyData);

        JSONArray standingArray = (JSONArray) userData.get("Standing");
        boolean playerUpdated = false;
        for (Object standingObj : standingArray) {
            JSONObject standingEntry = (JSONObject) standingObj;
            String standingCategory = (String) standingEntry.get("category");
            String standingPlayer = (String) standingEntry.get("player");

            if (standingPlayer.equals(playerName) && standingCategory.equals(selectedQuiz)) {
                if (score == maxscore) {
                    int quizzesDone = ((Long) standingEntry.get("quizzesDone")).intValue();
                    standingEntry.put("quizzesDone", quizzesDone + 1);
                    standingEntry.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd, hh:mm a")));
                    playerUpdated = true;
                }
                break;
            }
        }

        if (!playerUpdated && score == maxscore) {
            JSONObject newStandingEntry = new JSONObject();
            newStandingEntry.put("player", playerName);
            newStandingEntry.put("category", selectedQuiz);
            newStandingEntry.put("quizzesDone", 1);
            newStandingEntry.put("timestamp", LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd, hh:mm a")));
            standingArray.add(newStandingEntry);
        }

        try (FileWriter writer = new FileWriter(FILE_PATH[1])) {
            writer.write(userData.toJSONString());
        }

        JOptionPane.showMessageDialog(this, "Quiz Results Saved!");
    }

    private void loadPreviousQuestion() {
        if (index > 0) {
            index--;
            JSONObject previousScenario = scenarioList.get(index);
            questionLabel.setText((String) previousScenario.get("question"));
            option1.setText((String) previousScenario.get("option1"));
            option2.setText((String) previousScenario.get("option2"));
            option3.setText((String) previousScenario.get("option3"));
            option4.setText((String) previousScenario.get("option4"));
            correctanswer = (String) previousScenario.get("answer");
        }
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new Quiz("Player1", "Test", "SampleCategory", "Testss").setVisible(true);
        });
}

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel categoryLabel;
    private javax.swing.JButton completeButton;
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
