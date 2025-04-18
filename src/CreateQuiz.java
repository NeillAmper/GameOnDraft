
import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.util.Arrays;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public final class CreateQuiz extends javax.swing.JFrame {

    private static String title, category, numberofquiz, question, opt1, opt2, opt3, opt4, correctanswer;
    private int questionCounter = 0;
    private int numberOfQuizToEnter = 0;
    private final JSONArray newQuizArray = new JSONArray();
    private static final JSONParser jsonParser = new JSONParser();
    private static final String FILE_PATH = "src/QuizData.json";
    private final String gameMasterName;
    private final String usname;
    private final ButtonGroup answerGroup;

    public CreateQuiz(String gameMasterName, String usname) {
        initComponents();
        this.gameMasterName = gameMasterName;
        this.usname = usname;
        answerGroup = new ButtonGroup();
        answerGroup.add(answer1);
        answerGroup.add(answer2);
        answerGroup.add(answer3);
        answerGroup.add(answer4);
        loadCreateQuiz();
        CreateAgain.setEnabled(false); // ❌ Not allowed until quiz is saved
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        CategorySelection = new javax.swing.JComboBox<>();
        labelquestioncounter = new javax.swing.JLabel();
        questionUI = new javax.swing.JTextField();
        answer1 = new javax.swing.JRadioButton();
        opt1UI = new javax.swing.JTextField();
        answer2 = new javax.swing.JRadioButton();
        answer3 = new javax.swing.JRadioButton();
        answer4 = new javax.swing.JRadioButton();
        opt2UI = new javax.swing.JTextField();
        opt3UI = new javax.swing.JTextField();
        opt4UI = new javax.swing.JTextField();
        AddButton = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        SelectedItem = new javax.swing.JLabel();
        QuestionAmount = new javax.swing.JComboBox<>();
        InputButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        QuizTitle = new javax.swing.JTextField();
        CreateAgain = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Create Quiz");

        jLabel2.setText("Category:");

        CategorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Math", "Science", "History", "English" }));
        CategorySelection.setActionCommand("");
        CategorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CategorySelectionActionPerformed(evt);
            }
        });

        labelquestioncounter.setText("Question #1:");

        questionUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionUIActionPerformed(evt);
            }
        });

        buttonGroup.add(answer1);
        answer1.setText("Option #1:");
        answer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer1ActionPerformed(evt);
            }
        });

        opt1UI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt1UIActionPerformed(evt);
            }
        });

        buttonGroup.add(answer2);
        answer2.setText("Option #2:");
        answer2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer2ActionPerformed(evt);
            }
        });

        buttonGroup.add(answer3);
        answer3.setText("Option #3:");
        answer3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer3ActionPerformed(evt);
            }
        });

        buttonGroup.add(answer4);
        answer4.setText("Choice #4:");
        answer4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer4ActionPerformed(evt);
            }
        });

        opt2UI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                opt2UIActionPerformed(evt);
            }
        });

        AddButton.setText("ADD");
        AddButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                AddButtonActionPerformed(evt);
            }
        });

        Back.setText("<");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        SelectedItem.setText("# of Questions");

        QuestionAmount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        QuestionAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuestionAmountActionPerformed(evt);
            }
        });

        InputButton.setText("Input");
        InputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Quiz Title: ");

        CreateAgain.setText("Create More");
        CreateAgain.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                CreateAgainActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel1Layout.createSequentialGroup()
                        .addGap(87, 87, 87)
                        .addComponent(labelquestioncounter)
                        .addGap(81, 81, 81))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(17, 17, 17)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(Back)
                                    .addGap(126, 126, 126)
                                    .addComponent(jLabel1))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(jLabel2)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(CategorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(SelectedItem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(QuestionAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(InputButton)))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 43, Short.MAX_VALUE))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(answer2)
                                        .addComponent(answer3)
                                        .addComponent(answer1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(questionUI)
                                        .addComponent(opt3UI)
                                        .addComponent(opt2UI)
                                        .addComponent(opt1UI)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(answer4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(opt4UI)))
                            .addGap(22, 22, 22))))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(178, 178, 178)
                        .addComponent(AddButton)
                        .addGap(64, 64, 64)
                        .addComponent(CreateAgain))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(110, 110, 110)
                        .addComponent(jLabel4)
                        .addGap(18, 18, 18)
                        .addComponent(QuizTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(73, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(16, 16, 16)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(Back))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(QuizTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(CategorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectedItem)
                    .addComponent(QuestionAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InputButton))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelquestioncounter)
                    .addComponent(questionUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answer1)
                    .addComponent(opt1UI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answer2)
                    .addComponent(opt2UI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answer3)
                    .addComponent(opt3UI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(opt4UI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answer4))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 36, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(AddButton)
                    .addComponent(CreateAgain))
                .addGap(52, 52, 52))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void answer1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer1ActionPerformed

        correctanswer = opt1UI.getText();
        System.out.println(correctanswer);

    }//GEN-LAST:event_answer1ActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        GameMaster g = new GameMaster(gameMasterName, usname);
        g.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void answer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer4ActionPerformed

        correctanswer = opt4UI.getText();
        System.out.println(correctanswer);

    }//GEN-LAST:event_answer4ActionPerformed

    private void answer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer2ActionPerformed

        correctanswer = opt2UI.getText();
        System.out.println(correctanswer);

    }//GEN-LAST:event_answer2ActionPerformed

    private void AddButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_AddButtonActionPerformed
        try {
            // Get the input values
            category = (String) CategorySelection.getSelectedItem();
            question = questionUI.getText();
            opt1 = opt1UI.getText();
            opt2 = opt2UI.getText();
            opt3 = opt3UI.getText();
            opt4 = opt4UI.getText();

            // Validate the inputs
            if (question.isEmpty() || opt1.isEmpty() || opt2.isEmpty() || opt3.isEmpty() || opt4.isEmpty() || answerGroup.getSelection() == null) {
                JOptionPane.showMessageDialog(null, "Please complete all fields and select the correct answer.");
                return;
            }

            // Identify the selected correct answer
            if (answer1.isSelected()) {
                correctanswer = opt1;
            } else if (answer2.isSelected()) {
                correctanswer = opt2;
            } else if (answer3.isSelected()) {
                correctanswer = opt3;
            } else if (answer4.isSelected()) {
                correctanswer = opt4;
            }

            // Create a JSONObject for the current question
            JSONObject questionObject = new JSONObject();
            questionObject.put("questionnumber", String.valueOf(questionCounter + 1));
            questionObject.put("question", question);
            questionObject.put("answer", correctanswer);
            questionObject.put("option1", opt1);
            questionObject.put("option2", opt2);
            questionObject.put("option3", opt3);
            questionObject.put("option4", opt4);

            // Create the scenarios for correct and wrong answers
            JSONArray scenarios = new JSONArray();

            // Scenario for correct answer
            JSONObject correctScenario = new JSONObject();
            correctScenario.put("condition", "correct");
            correctScenario.put("action", "Go to next question");
            correctScenario.put("next", questionCounter + 2); // Move to next question

            // Scenario for wrong answer
            JSONObject wrongScenario = new JSONObject();
            wrongScenario.put("condition", "wrong");
            wrongScenario.put("action", "Trigger wrong end scenario");
            wrongScenario.put("next", "end"); // End the quiz scenario if wrong

            // Add both scenarios to the scenarios array
            scenarios.add(correctScenario);
            scenarios.add(wrongScenario);

            // Add the scenarios and current question index to the questionObject
            questionObject.put("scenarioIndex", questionCounter);
            questionObject.put("scenarios", scenarios);

            // If this is not the first question, link the previous question's "next_if_correct" and "next_if_wrong"
            if (questionCounter > 0) {
                JSONObject previousQuestion = (JSONObject) newQuizArray.get(questionCounter - 1);
                previousQuestion.put("next_if_correct", String.valueOf(questionCounter + 1)); // Move to next question on correct answer
                previousQuestion.put("next_if_wrong", String.valueOf(questionCounter + 2)); // Move to next question or end on wrong answer
            }

            // Add the current question to the quiz array
            newQuizArray.add(questionObject);
            questionCounter++;

            // If we've added the required number of questions, save the quiz and reset fields
            if (questionCounter == numberOfQuizToEnter) {
                saveQuizToFile(); // Will enable CreateAgain button
                resetInputFields(); // Reset input fields only (not full form)
                toggleInputMode(false); // Disable question UI
                toggleStartFields(true); // Enable title/category input again
            } else {
                // If more questions are left, clear the fields for the next question and prompt for next
                clearFields(); // Ready for next question
                labelquestioncounter.setText("Question #" + (questionCounter + 1));
                JOptionPane.showMessageDialog(null, "Question saved. Enter the next one.");
            }

        } catch (HeadlessException e) {
            Logger.getLogger(CreateQuiz.class.getName()).log(Level.SEVERE, null, e);
        }
    }//GEN-LAST:event_AddButtonActionPerformed

    private void questionUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionUIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_questionUIActionPerformed

    private void opt2UIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt2UIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt2UIActionPerformed

    private void answer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer3ActionPerformed

        correctanswer = opt3UI.getText();
        System.out.println(correctanswer);

    }//GEN-LAST:event_answer3ActionPerformed

    private void savequizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savequizActionPerformed

    }//GEN-LAST:event_savequizActionPerformed

    private void CategorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CategorySelectionActionPerformed


    }//GEN-LAST:event_CategorySelectionActionPerformed

    private void InputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputButtonActionPerformed
        title = QuizTitle.getText();
        numberofquiz = (String) QuestionAmount.getSelectedItem();

        if (title.isEmpty() || numberofquiz == null) {
            JOptionPane.showMessageDialog(null, "Please input quiz title and number of questions.");
            return;
        }

        numberOfQuizToEnter = Integer.parseInt(numberofquiz);
        questionCounter = 0;
        labelquestioncounter.setText("Question #1");
        loadCreateQuiz();
        JOptionPane.showMessageDialog(null, "Ready to enter " + numberOfQuizToEnter + " questions.");
    }//GEN-LAST:event_InputButtonActionPerformed

    private void QuestionAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuestionAmountActionPerformed


    }//GEN-LAST:event_QuestionAmountActionPerformed

    private void opt1UIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_opt1UIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_opt1UIActionPerformed

    private void CreateAgainActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_CreateAgainActionPerformed
        title = "";
        numberofquiz = null;
        questionCounter = 0;
        numberOfQuizToEnter = 0;
        newQuizArray.clear();

        // Reset all UI elements
        QuizTitle.setText("");
        QuizTitle.setEnabled(true);
        CategorySelection.setEnabled(true);
        QuestionAmount.setEnabled(true);
        InputButton.setEnabled(true);
        QuestionAmount.setSelectedIndex(0);

        labelquestioncounter.setText("Question #1:");
        labelquestioncounter.setEnabled(false);

        questionUI.setText("");
        questionUI.setEnabled(false);
        opt1UI.setText("");
        opt1UI.setEnabled(false);
        opt2UI.setText("");
        opt2UI.setEnabled(false);
        opt3UI.setText("");
        opt3UI.setEnabled(false);
        opt4UI.setText("");
        opt4UI.setEnabled(false);

        answer1.setEnabled(false);
        answer2.setEnabled(false);
        answer3.setEnabled(false);
        answer4.setEnabled(false);
        answerGroup.clearSelection();

        AddButton.setEnabled(false);
        CreateAgain.setEnabled(false); // ❌ Disable until new quiz is saved again

        SelectedItem.setText("# of Questions");

        JOptionPane.showMessageDialog(null, "You can now create a new quiz set.");
    }//GEN-LAST:event_CreateAgainActionPerformed

    private void clearFields() {
        questionUI.setText("");
        opt1UI.setText("");
        opt2UI.setText("");
        opt3UI.setText("");
        opt4UI.setText("");
        answerGroup.clearSelection();
    }

    private void loadCreateQuiz() {
        boolean ready = numberofquiz != null;
        toggleStartFields(!ready);     // ❌ Disable title/category when quiz starts
        toggleInputMode(ready);        // ✅ Enable question input
        if (ready) {
            SelectedItem.setText("Selected: " + numberofquiz);
        }
    }

    private void saveQuizToFile() {
        try {
            File file = new File(FILE_PATH);
            JSONObject root = new JSONObject();
            JSONArray quizArray = new JSONArray();

            // Load existing JSON if it exists
            if (file.exists() && file.length() > 0) {
                try (FileReader reader = new FileReader(file)) {
                    root = (JSONObject) jsonParser.parse(reader);
                    quizArray = (JSONArray) root.getOrDefault("Quizzes", new JSONArray());
                }
            }

            // Build new quiz structure that matches your required format
            JSONObject quizObject = new JSONObject();
            quizObject.put("QuizTitle", title);          // ✅ Correct key
            quizObject.put("Creator", gameMasterName);   // ✅ Automatically use signed-in username
            quizObject.put("Category", category);        // ✅ Category
            quizObject.put("Questions", newQuizArray);   // ✅ Questions array

            quizArray.add(quizObject);
            root.put("Quizzes", quizArray);              // ✅ Maintain key casing

            try (FileWriter writer = new FileWriter(FILE_PATH)) {
                writer.write(root.toJSONString());
            }

            JOptionPane.showMessageDialog(null, "Quiz saved successfully!");
            questionCounter = 0;
            newQuizArray.clear();
            CreateAgain.setEnabled(true); // ✅ Allow creating another quiz

        } catch (IOException | ParseException e) {
            Logger.getLogger(CreateQuiz.class.getName()).log(Level.SEVERE, null, e);
            JOptionPane.showMessageDialog(null, "Failed to save the quiz.");
        }
    }

    private void toggleInputMode(boolean enable) {
        questionUI.setEnabled(enable);
        opt1UI.setEnabled(enable);
        opt2UI.setEnabled(enable);
        opt3UI.setEnabled(enable);
        opt4UI.setEnabled(enable);
        answer1.setEnabled(enable);
        answer2.setEnabled(enable);
        answer3.setEnabled(enable);
        answer4.setEnabled(enable);
        AddButton.setEnabled(enable);
        labelquestioncounter.setEnabled(enable);
    }

    private void toggleStartFields(boolean enable) {
        QuizTitle.setEnabled(enable);
        CategorySelection.setEnabled(enable);
        QuestionAmount.setEnabled(enable);
        InputButton.setEnabled(enable);
    }

    private void resetInputFields() {
        questionUI.setText("");
        opt1UI.setText("");
        opt2UI.setText("");
        opt3UI.setText("");
        opt4UI.setText("");
        answerGroup.clearSelection();
        labelquestioncounter.setText("Question #1");
    }

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new GameMaster("TestName", "tests").setVisible(true); // Replace "TestName" with any string for testing
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton Back;
    private javax.swing.JComboBox<String> CategorySelection;
    private javax.swing.JButton CreateAgain;
    private javax.swing.JButton InputButton;
    private javax.swing.JComboBox<String> QuestionAmount;
    private javax.swing.JTextField QuizTitle;
    private javax.swing.JLabel SelectedItem;
    private javax.swing.JRadioButton answer1;
    private javax.swing.JRadioButton answer2;
    private javax.swing.JRadioButton answer3;
    private javax.swing.JRadioButton answer4;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelquestioncounter;
    private javax.swing.JTextField opt1UI;
    private javax.swing.JTextField opt2UI;
    private javax.swing.JTextField opt3UI;
    private javax.swing.JTextField opt4UI;
    private javax.swing.JTextField questionUI;
    // End of variables declaration//GEN-END:variables
}
