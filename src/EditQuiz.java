
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public class EditQuiz extends javax.swing.JFrame {

    private static final String[] FILE_PATH = {"src/QuizData.json", "src/UserData.json"};
    private static final JSONParser jsonParser = new JSONParser();
    private static JSONObject record = new JSONObject();
    private final String gameMasterName;
    private final String usname;

    public EditQuiz(String selectedQuizID, String gameMasterName, String usname) {
        initComponents();
        this.gameMasterName = gameMasterName;  // Set user name
        this.usname = usname;
        QuizID.setText(selectedQuizID);  // Display the Quiz ID in the text field
        loadQuizData(selectedQuizID);    // Load the quiz data into the form fields
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        CorrectAnswer = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        editQuizTitle = new javax.swing.JLabel();
        Back = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        categoryComboBox = new javax.swing.JComboBox<>();
        jLabel3 = new javax.swing.JLabel();
        QuestionOne = new javax.swing.JLabel();
        QuestionField = new javax.swing.JTextField();
        Option1Button = new javax.swing.JRadioButton();
        Option2Button = new javax.swing.JRadioButton();
        Option3Button = new javax.swing.JRadioButton();
        Option4Button = new javax.swing.JRadioButton();
        Edit = new javax.swing.JButton();
        Option1Field = new javax.swing.JTextField();
        Option2Field = new javax.swing.JTextField();
        Option3Field = new javax.swing.JTextField();
        Option4Field = new javax.swing.JTextField();
        jLabel4 = new javax.swing.JLabel();
        NewQuizID = new javax.swing.JTextField();
        jLabel1 = new javax.swing.JLabel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        quizTitleLabel = new javax.swing.JLabel();
        previousQuestionButton = new javax.swing.JButton();
        nextQuestionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        editQuizTitle.setText("Edit Quiz");

        Back.setText("<");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        jLabel2.setText("Category:");

        categoryComboBox.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Math", "Science", "History", "English" }));

        jLabel3.setText("Quiz Title:");

        QuestionOne.setText("Question #1:");

        QuestionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                QuestionFieldActionPerformed(evt);
            }
        });

        CorrectAnswer.add(Option1Button);
        Option1Button.setText("Option #1:");

        CorrectAnswer.add(Option2Button);
        Option2Button.setText("Option #2:");
        Option2Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Option2ButtonActionPerformed(evt);
            }
        });

        CorrectAnswer.add(Option3Button);
        Option3Button.setText("Option #3:");
        Option3Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Option3ButtonActionPerformed(evt);
            }
        });

        CorrectAnswer.add(Option4Button);
        Option4Button.setText("Option #4:");
        Option4Button.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Option4ButtonActionPerformed(evt);
            }
        });

        Edit.setText("EDIT QUIZ");
        Edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                EditActionPerformed(evt);
            }
        });

        Option1Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                Option1FieldActionPerformed(evt);
            }
        });

        jLabel4.setText("New Quiz Title:");

        jLabel1.setText("# of Questions");

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));

        jButton1.setText("Input");

        quizTitleLabel.setText("Quiz Title Label");

        previousQuestionButton.setText("Previous");

        nextQuestionButton.setText("Next");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(18, 18, 18)
                .addComponent(Back)
                .addGap(46, 46, 46)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel3)
                    .addComponent(jLabel4))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addComponent(NewQuizID)
                        .addContainerGap())
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(35, 35, 35)
                        .addComponent(quizTitleLabel)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(100, 100, 100)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(previousQuestionButton)
                        .addGap(18, 18, 18)
                        .addComponent(nextQuestionButton)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Edit))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Option4Button, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Option3Button, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Option2Button, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(Option1Button, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(QuestionOne, javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(editQuizTitle, javax.swing.GroupLayout.Alignment.TRAILING))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(QuestionField, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 124, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Option2Field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Option3Field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Option1Field, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(Option4Field))))
                .addGap(56, 56, 56))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addGap(27, 27, 27)
                .addComponent(jLabel2)
                .addGap(18, 18, 18)
                .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(35, 35, 35)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, 87, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 33, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(18, 18, 18))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(19, 19, 19)
                .addComponent(editQuizTitle)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(4, 4, 4)
                        .addComponent(Back))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel3)
                            .addComponent(quizTitleLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(NewQuizID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jLabel4))))
                .addGap(21, 21, 21)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(categoryComboBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1)
                    .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton1))
                .addGap(31, 31, 31)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(QuestionOne)
                    .addComponent(QuestionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(Option2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Option1Button)
                            .addComponent(Option1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(Option2Button)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Option3Button)
                            .addComponent(Option3Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(Option4Button)
                            .addComponent(Option4Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(previousQuestionButton)
                            .addComponent(nextQuestionButton)
                            .addComponent(Edit))
                        .addContainerGap(20, Short.MAX_VALUE))))
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
        EditQuizTable e = new EditQuizTable(gameMasterName, usname);
        e.setVisible(true);
        setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void Option2ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Option2ButtonActionPerformed
        CorrectAnswer.clearSelection();
        Option2Button.setSelected(true);
    }//GEN-LAST:event_Option2ButtonActionPerformed

    private void EditActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_EditActionPerformed
        updateQuiz();  // Call method to update the quiz data
    }//GEN-LAST:event_EditActionPerformed

    private void Option3ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Option3ButtonActionPerformed
        CorrectAnswer.clearSelection();
        Option3Button.setSelected(true);
    }//GEN-LAST:event_Option3ButtonActionPerformed

    private void Option4ButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Option4ButtonActionPerformed
        CorrectAnswer.clearSelection();
        Option4Button.setSelected(true);
    }//GEN-LAST:event_Option4ButtonActionPerformed

    private void QuestionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_QuestionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_QuestionFieldActionPerformed

    private void Option1FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_Option1FieldActionPerformed
        CorrectAnswer.clearSelection();
        Option1Button.setSelected(true);
    }//GEN-LAST:event_Option1FieldActionPerformed

    private void loadQuizData(String selectedQuizID) {
        try {
            filecheck();
            JSONArray quizzes = (JSONArray) record.get("Quizzes");

            for (Object obj : quizzes) {
                JSONObject quizObject = (JSONObject) obj;

                if (selectedQuizID.equals(quizObject.get("quizid"))) {
                    QuizID.setText((String) quizObject.get("quizid"));
                    QuestionField.setText((String) quizObject.get("question"));
                    Option1Field.setText((String) quizObject.get("option1"));
                    Option2Field.setText((String) quizObject.get("option2"));
                    Option3Field.setText((String) quizObject.get("option3"));
                    Option4Field.setText((String) quizObject.get("option4"));
                    categoryComboBox.setSelectedItem(quizObject.get("category"));

                    String correctAnswer = (String) quizObject.get("answer");
                    if (Option1Field.getText().equals(correctAnswer)) {
                        Option1Button.setSelected(true);
                    } else if (Option2Field.getText().equals(correctAnswer)) {
                        Option2Button.setSelected(true);
                    } else if (Option3Field.getText().equals(correctAnswer)) {
                        Option3Button.setSelected(true);
                    } else if (Option4Field.getText().equals(correctAnswer)) {
                        Option4Button.setSelected(true);
                    }

                    break;
                }
            }
        } catch (IOException | ParseException e) {
            Logger.getLogger(EditQuiz.class.getName()).log(Level.SEVERE, "Error loading quiz data", e);
        }
    }

    // This method reads from the first file (QuizData.json)
    private void filecheck() throws IOException, ParseException {
        try (FileReader reader = new FileReader(FILE_PATH[0])) {
            record = (JSONObject) jsonParser.parse(reader);
        }
    }

    // This method writes to the first file (QuizData.json)
    private void saveToFile() {
        try (FileWriter file = new FileWriter(FILE_PATH[0])) {
            file.write(record.toJSONString());
            file.flush();
        } catch (IOException e) {
            Logger.getLogger(EditQuiz.class.getName()).log(Level.SEVERE, "Error saving data to file", e);
        }
    }

    private void updateQuiz() {
        String category = categoryComboBox.getSelectedItem().toString();
        String quizid = QuizID.getText().trim();
        String newQuizid = NewQuizID.getText().trim();
        String question = QuestionField.getText().trim();
        String option1 = Option1Field.getText().trim();
        String option2 = Option2Field.getText().trim();
        String option3 = Option3Field.getText().trim();
        String option4 = Option4Field.getText().trim();

        if (quizid.isEmpty()) {
            JOptionPane.showMessageDialog(null, "Please enter an existing Quiz ID.", "Input needed", JOptionPane.ERROR_MESSAGE);
            return;
        }

        try {
            filecheck();
            JSONArray quizzes = (JSONArray) record.get("Quizzes");
            boolean quizFound = false;
            boolean isUpdated = false;

            for (Object obj : quizzes) {
                JSONObject quizObject = (JSONObject) obj;

                if (quizid.equals(quizObject.get("quizid"))) {
                    quizFound = true;

                    if (!newQuizid.isEmpty() && !newQuizid.equals(quizid)) {
                        quizObject.put("quizid", newQuizid);
                        isUpdated = true;
                    }

                    if (!question.isEmpty()) {
                        quizObject.put("question", question);
                        isUpdated = true;
                    }

                    if (!option1.isEmpty()) {
                        quizObject.put("option1", option1);
                        isUpdated = true;
                    }

                    if (!option2.isEmpty()) {
                        quizObject.put("option2", option2);
                        isUpdated = true;
                    }

                    if (!option3.isEmpty()) {
                        quizObject.put("option3", option3);
                        isUpdated = true;
                    }

                    if (!option4.isEmpty()) {
                        quizObject.put("option4", option4);
                        isUpdated = true;
                    }

                    if (!category.isEmpty()) {
                        quizObject.put("category", category);
                        isUpdated = true;
                    }

                    if (Option1Button.isSelected()) {
                        quizObject.put("answer", option1);
                    } else if (Option2Button.isSelected()) {
                        quizObject.put("answer", option2);
                    } else if (Option3Button.isSelected()) {
                        quizObject.put("answer", option3);
                    } else if (Option4Button.isSelected()) {
                        quizObject.put("answer", option4);
                    }

                    break;
                }
            }

            if (!quizFound) {
                JOptionPane.showMessageDialog(null, "Quiz not found!", "Update Failed", JOptionPane.ERROR_MESSAGE);
                return;
            }

            if (!isUpdated) {
                JOptionPane.showMessageDialog(null, "Nothing was updated. Please enter new inputs.", "No Changes Made", JOptionPane.INFORMATION_MESSAGE);
                return;
            }

            int confirm = JOptionPane.showConfirmDialog(null, "Are you sure you want to update the quiz?", "Confirm Update", JOptionPane.YES_NO_OPTION);
            if (confirm == JOptionPane.YES_OPTION) {
                saveToFile();
                JOptionPane.showMessageDialog(null, "Quiz updated successfully!");
            } else {
                JOptionPane.showMessageDialog(null, "Update canceled.", "Cancelled", JOptionPane.INFORMATION_MESSAGE);
            }

        } catch (IOException | ParseException e) {
            Logger.getLogger(EditQuiz.class.getName()).log(Level.SEVERE, "Error updating quiz", e);
        }
    }

    public static void main(String[] args) {
        java.awt.EventQueue.invokeLater(() -> new EditQuizTable("test", "Testss").setVisible(true));
    }


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.ButtonGroup CorrectAnswer;
    private javax.swing.JButton Edit;
    private javax.swing.JTextField NewQuizID;
    private javax.swing.JRadioButton Option1Button;
    private javax.swing.JTextField Option1Field;
    private javax.swing.JRadioButton Option2Button;
    private javax.swing.JTextField Option2Field;
    private javax.swing.JRadioButton Option3Button;
    private javax.swing.JTextField Option3Field;
    private javax.swing.JRadioButton Option4Button;
    private javax.swing.JTextField Option4Field;
    private javax.swing.JTextField QuestionField;
    private javax.swing.JLabel QuestionOne;
    private javax.swing.JComboBox<String> categoryComboBox;
    private javax.swing.JLabel editQuizTitle;
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JButton nextQuestionButton;
    private javax.swing.JButton previousQuestionButton;
    private javax.swing.JLabel quizTitleLabel;
    // End of variables declaration//GEN-END:variables
}
