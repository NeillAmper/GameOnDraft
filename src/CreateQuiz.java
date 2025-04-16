
import javax.swing.*;
import java.awt.*;
import java.io.*;
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
    private final String usname;
    private final ButtonGroup answerGroup;

    public CreateQuiz(String usname) {
        initComponents();
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
        categorybox = new javax.swing.JComboBox<>();
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
        numberquizUI = new javax.swing.JComboBox<>();
        InputBtn = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        quiztitleUI = new javax.swing.JTextField();
        CreateAgain = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Create Quiz");

        jLabel2.setText("Category:");

        categorybox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Math", "Science", "History", "English" }));
        categorybox.setActionCommand("");
        categorybox.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categoryboxActionPerformed(evt);
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

        numberquizUI.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        numberquizUI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                numberquizUIActionPerformed(evt);
            }
        });

        InputBtn.setText("Input");
        InputBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                InputBtnActionPerformed(evt);
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
                                    .addComponent(categorybox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(SelectedItem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(numberquizUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(InputBtn)))
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
                        .addComponent(quiztitleUI, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)))
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
                    .addComponent(quiztitleUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(categorybox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectedItem)
                    .addComponent(numberquizUI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(InputBtn))
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
        GameMaster g = new GameMaster(usname);
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
            category = (String) categorybox.getSelectedItem();
            question = questionUI.getText();
            opt1 = opt1UI.getText();
            opt2 = opt2UI.getText();
            opt3 = opt3UI.getText();
            opt4 = opt4UI.getText();

            if (question.isEmpty() || opt1.isEmpty() || opt2.isEmpty() || opt3.isEmpty() || opt4.isEmpty() || answerGroup.getSelection() == null) {
                JOptionPane.showMessageDialog(null, "Please complete all fields and select the correct answer.");
                return;
            }

            if (answer1.isSelected()) {
                correctanswer = opt1;
            } else if (answer2.isSelected()) {
                correctanswer = opt2;
            } else if (answer3.isSelected()) {
                correctanswer = opt3;
            } else if (answer4.isSelected()) {
                correctanswer = opt4;
            }

            JSONObject questionObject = new JSONObject();
            questionObject.put("questionnumber", String.valueOf(questionCounter + 1));  // ✅ stored as string
            questionObject.put("question", question);
            questionObject.put("answer", correctanswer);
            questionObject.put("option1", opt1);
            questionObject.put("option2", opt2);
            questionObject.put("option3", opt3);
            questionObject.put("option4", opt4);

            newQuizArray.add(questionObject);
            questionCounter++;

            clearFields();

            if (questionCounter == numberOfQuizToEnter) {
                saveQuizToFile();
            } else {
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

    private void categoryboxActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categoryboxActionPerformed


    }//GEN-LAST:event_categoryboxActionPerformed

    private void InputBtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_InputBtnActionPerformed
        title = quiztitleUI.getText();
        numberofquiz = (String) numberquizUI.getSelectedItem();

        if (title.isEmpty() || numberofquiz == null) {
            JOptionPane.showMessageDialog(null, "Please input quiz title and number of questions.");
            return;
        }

        numberOfQuizToEnter = Integer.parseInt(numberofquiz);
        questionCounter = 0;
        labelquestioncounter.setText("Question #1");
        loadCreateQuiz();
        JOptionPane.showMessageDialog(null, "Ready to enter " + numberOfQuizToEnter + " questions.");
    }//GEN-LAST:event_InputBtnActionPerformed

    private void numberquizUIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_numberquizUIActionPerformed


    }//GEN-LAST:event_numberquizUIActionPerformed

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
        quiztitleUI.setText("");
        quiztitleUI.setEnabled(true);
        categorybox.setEnabled(true);
        numberquizUI.setEnabled(true);
        InputBtn.setEnabled(true);
        numberquizUI.setSelectedIndex(0);

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
        quiztitleUI.setEnabled(!ready);
        categorybox.setEnabled(!ready);
        InputBtn.setEnabled(!ready);
        numberquizUI.setEnabled(!ready);
        labelquestioncounter.setEnabled(ready);
        AddButton.setEnabled(ready);
        questionUI.setEnabled(ready);
        opt1UI.setEnabled(ready);
        opt2UI.setEnabled(ready);
        opt3UI.setEnabled(ready);
        opt4UI.setEnabled(ready);
        answer1.setEnabled(ready);
        answer2.setEnabled(ready);
        answer3.setEnabled(ready);
        answer4.setEnabled(ready);
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
            quizObject.put("Creator", usname);           // ✅ Automatically use signed-in username
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

    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new GameMaster("TestName").setVisible(true); // Replace "TestName" with any string for testing
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton AddButton;
    private javax.swing.JButton Back;
    private javax.swing.JButton CreateAgain;
    private javax.swing.JButton InputBtn;
    private javax.swing.JLabel SelectedItem;
    private javax.swing.JRadioButton answer1;
    private javax.swing.JRadioButton answer2;
    private javax.swing.JRadioButton answer3;
    private javax.swing.JRadioButton answer4;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JComboBox<String> categorybox;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelquestioncounter;
    private javax.swing.JComboBox<String> numberquizUI;
    private javax.swing.JTextField opt1UI;
    private javax.swing.JTextField opt2UI;
    private javax.swing.JTextField opt3UI;
    private javax.swing.JTextField opt4UI;
    private javax.swing.JTextField questionUI;
    private javax.swing.JTextField quiztitleUI;
    // End of variables declaration//GEN-END:variables
}
