
import javax.swing.*;
import java.io.*;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

public final class CreateQuiz extends javax.swing.JFrame {

    private String title, category, question, opt1, opt2, opt3, opt4, correctanswer;
    private int questionCounter = 0; // Tracks the current question being entered
    private int numberOfQuizToEnter = 0; // Total number of questions for the quiz
    private final JSONArray newQuizArray = new JSONArray(); // Stores questions for the current quiz
    private static final JSONParser jsonParser = new JSONParser();
    private static final String FILE_PATH = "src/QuizData.json";
    private final String gameMasterName;
    private final String usname;
    private final ButtonGroup answerGroup;
    private int currentQuestionIndex = -1; // Tracks the currently displayed question
    private static final String DEFAULT_CATEGORY = "Select a Category";

    public CreateQuiz(String gameMasterName, String usname) {
        initComponents();
        this.gameMasterName = gameMasterName;
        this.usname = usname;

        // Group radio buttons for selecting the correct answer
        answerGroup = new ButtonGroup();
        answerGroup.add(answer1);
        answerGroup.add(answer2);
        answerGroup.add(answer3);
        answerGroup.add(answer4);

        resetAllFields();
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        categorySelection = new javax.swing.JComboBox<>();
        labelquestioncounter = new javax.swing.JLabel();
        questionField = new javax.swing.JTextField();
        answer1 = new javax.swing.JRadioButton();
        option1Field = new javax.swing.JTextField();
        answer2 = new javax.swing.JRadioButton();
        answer3 = new javax.swing.JRadioButton();
        answer4 = new javax.swing.JRadioButton();
        option2Field = new javax.swing.JTextField();
        option3Field = new javax.swing.JTextField();
        option4Field = new javax.swing.JTextField();
        saveQuizButton = new javax.swing.JButton();
        Back = new javax.swing.JButton();
        SelectedItem = new javax.swing.JLabel();
        questionAmount = new javax.swing.JComboBox<>();
        inputButton = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        quizTitle = new javax.swing.JTextField();
        previousQuestionButton = new javax.swing.JButton();
        nextQuestionButton = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jLabel1.setText("Create Quiz");

        jLabel2.setText("Category:");

        categorySelection.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Select a Category", "Math", "Science", "History", "English" }));
        categorySelection.setActionCommand("");
        categorySelection.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                categorySelectionActionPerformed(evt);
            }
        });

        labelquestioncounter.setText("Question #1:");

        questionField.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionFieldActionPerformed(evt);
            }
        });

        buttonGroup.add(answer1);
        answer1.setText("Option #1:");
        answer1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                answer1ActionPerformed(evt);
            }
        });

        option1Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option1FieldActionPerformed(evt);
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

        option2Field.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                option2FieldActionPerformed(evt);
            }
        });

        saveQuizButton.setText("Save");
        saveQuizButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveQuizButtonActionPerformed(evt);
            }
        });

        Back.setText("<");
        Back.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BackActionPerformed(evt);
            }
        });

        SelectedItem.setText("# of Questions");

        questionAmount.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" }));
        questionAmount.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                questionAmountActionPerformed(evt);
            }
        });

        inputButton.setText("Input");
        inputButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                inputButtonActionPerformed(evt);
            }
        });

        jLabel4.setText("Quiz Title: ");

        previousQuestionButton.setText("Previous");
        previousQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                previousQuestionButtonActionPerformed(evt);
            }
        });

        nextQuestionButton.setText("Next");
        nextQuestionButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                nextQuestionButtonActionPerformed(evt);
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
                                    .addComponent(categorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(SelectedItem)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(questionAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addGap(18, 18, 18)
                                    .addComponent(inputButton))))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(75, 75, 75)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(previousQuestionButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                    .addComponent(nextQuestionButton)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(saveQuizButton))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(answer2)
                                        .addComponent(answer3)
                                        .addComponent(answer1))
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(questionField)
                                        .addComponent(option3Field)
                                        .addComponent(option2Field)
                                        .addComponent(option1Field)))
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addComponent(answer4)
                                    .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                    .addComponent(option4Field)))
                            .addGap(22, 22, 22))))
                .addGap(14, 14, 14))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(110, 110, 110)
                .addComponent(jLabel4)
                .addGap(18, 18, 18)
                .addComponent(quizTitle, javax.swing.GroupLayout.PREFERRED_SIZE, 192, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
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
                    .addComponent(quizTitle, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(24, 24, 24)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(categorySelection, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(SelectedItem)
                    .addComponent(questionAmount, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(inputButton))
                .addGap(34, 34, 34)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(labelquestioncounter)
                    .addComponent(questionField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(20, 20, 20)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answer1)
                    .addComponent(option1Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(7, 7, 7)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answer2)
                    .addComponent(option2Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(answer3)
                    .addComponent(option3Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(option4Field, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(answer4))
                .addGap(26, 26, 26)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(saveQuizButton)
                    .addComponent(nextQuestionButton)
                    .addComponent(previousQuestionButton))
                .addContainerGap(62, Short.MAX_VALUE))
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

        correctanswer = option1Field.getText();
        System.out.println(correctanswer);

    }//GEN-LAST:event_answer1ActionPerformed

    private void BackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BackActionPerformed
        resetAllFields();
        GameMaster g = new GameMaster(gameMasterName, usname);
        g.setVisible(true);
        this.setVisible(false);
    }//GEN-LAST:event_BackActionPerformed

    private void answer4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer4ActionPerformed

        correctanswer = option4Field.getText();
        System.out.println(correctanswer);

    }//GEN-LAST:event_answer4ActionPerformed

    private void answer2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer2ActionPerformed

        correctanswer = option2Field.getText();
        System.out.println(correctanswer);

    }//GEN-LAST:event_answer2ActionPerformed

    private void saveQuizButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveQuizButtonActionPerformed
        saveCurrentQuestion();

        if (newQuizArray.size() == numberOfQuizToEnter) {
            saveQuizToFile();
            resetAllFields();
            showMessage("Quiz saved successfully!", "Success", JOptionPane.INFORMATION_MESSAGE);
        }
    }//GEN-LAST:event_saveQuizButtonActionPerformed

    private void questionFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionFieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_questionFieldActionPerformed

    private void option2FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option2FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option2FieldActionPerformed

    private void answer3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_answer3ActionPerformed

        correctanswer = option3Field.getText();
        System.out.println(correctanswer);

    }//GEN-LAST:event_answer3ActionPerformed

    private void savequizActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_savequizActionPerformed

    }//GEN-LAST:event_savequizActionPerformed

    private void categorySelectionActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_categorySelectionActionPerformed


    }//GEN-LAST:event_categorySelectionActionPerformed

    private void inputButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_inputButtonActionPerformed
        title = quizTitle.getText().trim();
        numberOfQuizToEnter = Integer.parseInt((String) questionAmount.getSelectedItem());

        if (DEFAULT_CATEGORY.equals(categorySelection.getSelectedItem())) {
            showMessage("You must select a category.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (title.isEmpty() || numberOfQuizToEnter <= 0) {
            showMessage("Please input a quiz title and number of questions.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return;
        }

        if (isDuplicateQuizTitle(title)) {
            showMessage("A quiz with the same title already exists.", "Duplicate Title", JOptionPane.WARNING_MESSAGE);
            return;
        }

        questionCounter = 0;
        currentQuestionIndex = 0;
        newQuizArray.clear();
        labelquestioncounter.setText("Question #1");
        toggleInputFields(true);
        updateNavigationButtons();
        saveQuizButton.setEnabled(false);
        showMessage("Ready to enter " + numberOfQuizToEnter + " questions.", "Quiz Setup", JOptionPane.INFORMATION_MESSAGE);
    }//GEN-LAST:event_inputButtonActionPerformed

    private void questionAmountActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_questionAmountActionPerformed


    }//GEN-LAST:event_questionAmountActionPerformed

    private void option1FieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_option1FieldActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_option1FieldActionPerformed

    private void previousQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_previousQuestionButtonActionPerformed
        saveCurrentQuestion();
        if (currentQuestionIndex > 0) {
            currentQuestionIndex--;
            loadQuestion(currentQuestionIndex);
        }
        updateNavigationButtons();
    }//GEN-LAST:event_previousQuestionButtonActionPerformed

    private void nextQuestionButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_nextQuestionButtonActionPerformed
        if (!validateQuestionInput()) return;

        saveCurrentQuestion();
        if (currentQuestionIndex < newQuizArray.size() - 1) {
            currentQuestionIndex++;
            loadQuestion(currentQuestionIndex);
        } else {
            clearFields();
            currentQuestionIndex++;
            labelquestioncounter.setText("Question #" + (currentQuestionIndex + 1));
        }
        updateNavigationButtons();
    }//GEN-LAST:event_nextQuestionButtonActionPerformed

    private void loadCreateQuiz() {
        toggleInputMode(numberofquiz != null);
    }

    private void toggleInputMode(boolean enable) {
        questionField.setEnabled(enable);
        option1Field.setEnabled(enable);
        option2Field.setEnabled(enable);
        option3Field.setEnabled(enable);
        option4Field.setEnabled(enable);
        answer1.setEnabled(enable);
        answer2.setEnabled(enable);
        answer3.setEnabled(enable);
        answer4.setEnabled(enable);
        saveQuizButton.setEnabled(enable);
        labelquestioncounter.setEnabled(enable);
    }

    private void resetAllFields() {
        // Reset title, category, and question amount fields
        quizTitle.setText("");
        quizTitle.setEnabled(true); // Make title field visible and editable
        categorySelection.setSelectedIndex(0); // Reset to "Select a Category"
        categorySelection.setEnabled(true); // Enable category selection
        questionAmount.setSelectedIndex(0); // Reset to the first value (e.g., 1)
        questionAmount.setEnabled(true); // Enable question amount selection
        inputButton.setEnabled(true); // Enable input button

        // Reset question-related fields and disable them
        questionField.setText("");
        questionField.setEnabled(false); // Disable question input
        option1Field.setText("");
        option1Field.setEnabled(false); // Disable option fields
        option2Field.setText("");
        option2Field.setEnabled(false);
        option3Field.setText("");
        option3Field.setEnabled(false);
        option4Field.setText("");
        option4Field.setEnabled(false);
        answerGroup.clearSelection(); // Clear selected answer
        answer1.setEnabled(false); // Disable radio buttons
        answer2.setEnabled(false);
        answer3.setEnabled(false);
        answer4.setEnabled(false);

        // Reset labels and counters
        labelquestioncounter.setText("Question #1");
        newQuizArray.clear(); // Clear the quiz array
        questionCounter = 0; // Reset question counter
        numberOfQuizToEnter = 0; // Reset total number of questions
        SelectedItem.setText("# of Questions"); // Reset the selected item label
        updateNavigationButtons(); // Ensure buttons are disabled
    }

    private void updateNavigationButtons() {
        previousQuestionButton.setEnabled(currentQuestionIndex > 0);
        nextQuestionButton.setEnabled(currentQuestionIndex < numberOfQuizToEnter - 1);
        saveQuizButton.setEnabled(newQuizArray.size() == numberOfQuizToEnter);
    }

    private void loadQuestion(int index) {
        if (index < 0 || index >= newQuizArray.size()) return;

        JSONObject questionObject = (JSONObject) newQuizArray.get(index);
        questionField.setText((String) questionObject.get("question"));
        option1Field.setText((String) questionObject.get("option1"));
        option2Field.setText((String) questionObject.get("option2"));
        option3Field.setText((String) questionObject.get("option3"));
        option4Field.setText((String) questionObject.get("option4"));

        String correctAnswer = (String) questionObject.get("answer");
        if (correctAnswer.equalsIgnoreCase(option1Field.getText())) {
            answerGroup.setSelected(answer1.getModel(), true);
        } else if (correctAnswer.equalsIgnoreCase(option2Field.getText())) {
            answerGroup.setSelected(answer2.getModel(), true);
        } else if (correctAnswer.equalsIgnoreCase(option3Field.getText())) {
            answerGroup.setSelected(answer3.getModel(), true);
        } else if (correctAnswer.equalsIgnoreCase(option4Field.getText())) {
            answerGroup.setSelected(answer4.getModel(), true);
        }

        labelquestioncounter.setText("Question #" + (index + 1));
    }


    private void saveCurrentQuestion() {
        if (currentQuestionIndex < 0) return;

        JSONObject questionObject = createQuestionObject();
        if (currentQuestionIndex < newQuizArray.size()) {
            newQuizArray.set(currentQuestionIndex, questionObject);
        } else {
            newQuizArray.add(questionObject);
        }
    }

    private boolean validateQuestionInput() {
        category = (String) categorySelection.getSelectedItem();
        question = questionField.getText().trim();
        opt1 = option1Field.getText().trim();
        opt2 = option2Field.getText().trim();
        opt3 = option3Field.getText().trim();
        opt4 = option4Field.getText().trim();

        if (DEFAULT_CATEGORY.equals(category) || question.isEmpty() || opt1.isEmpty() || opt2.isEmpty() || opt3.isEmpty() || opt4.isEmpty()) {
            showMessage("Please complete all fields and select the correct answer.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!areOptionsUnique(opt1, opt2, opt3, opt4)) {
            showMessage("Options must be unique.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (isDuplicateQuestion(question)) {
            showMessage("This question already exists in the quiz.", "Duplicate Question", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        if (!Arrays.asList(opt1, opt2, opt3, opt4).contains(correctanswer)) {
            showMessage("The correct answer must match one of the options.", "Validation Error", JOptionPane.WARNING_MESSAGE);
            return false;
        }

        return true;
    }

    private boolean areOptionsUnique(String... options) {
        return Arrays.stream(options).distinct().count() == options.length;
    }

    private boolean isDuplicateQuestion(String question) {
        return newQuizArray.stream()
                .anyMatch(obj -> ((JSONObject) obj).get("question").toString().equalsIgnoreCase(question));
    }

    private boolean isDuplicateQuizTitle(String title) {
        try (FileReader reader = new FileReader(FILE_PATH)) {
            JSONObject root = (JSONObject) jsonParser.parse(reader);
            JSONArray quizzes = (JSONArray) root.get("Quizzes");

            for (Object obj : quizzes) {
                JSONObject existingQuiz = (JSONObject) obj;
                if (existingQuiz.get("QuizTitle").toString().equalsIgnoreCase(title)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            Logger.getLogger(CreateQuiz.class.getName()).log(Level.WARNING, "Quiz data file not found.", e);
        } catch (IOException | ParseException e) {
            Logger.getLogger(CreateQuiz.class.getName()).log(Level.SEVERE, "An error occurred while validating quiz title.", e);
        }
        return false;
    }

    private JSONObject createQuestionObject() {
        JSONObject questionObject = new JSONObject();
        questionObject.put("questionnumber", currentQuestionIndex + 1);
        questionObject.put("question", question);
        questionObject.put("option1", opt1);
        questionObject.put("option2", opt2);
        questionObject.put("option3", opt3);
        questionObject.put("option4", opt4);
        questionObject.put("answer", correctanswer);
        return questionObject;
    }

    private void clearFields() {
        questionField.setText("");
        option1Field.setText("");
        option2Field.setText("");
        option3Field.setText("");
        option4Field.setText("");
        answerGroup.clearSelection();
    }

    private void resetAllFields() {
        quizTitle.setText("");
        categorySelection.setSelectedIndex(0);
        questionAmount.setSelectedIndex(0);
        clearFields();
        newQuizArray.clear();
        questionCounter = 0;
        currentQuestionIndex = -1;
        toggleInputFields(false);
        updateNavigationButtons();
    }

    private void saveQuizToFile() {
        try (FileWriter writer = new FileWriter(FILE_PATH)) {
            JSONObject root = new JSONObject();
            JSONArray quizzes = new JSONArray();

            File file = new File(FILE_PATH);
            if (file.exists()) {
                try (FileReader reader = new FileReader(FILE_PATH)) {
                    root = (JSONObject) jsonParser.parse(reader);
                    quizzes = (JSONArray) root.getOrDefault("Quizzes", new JSONArray());
                } catch (ParseException e) {
                    Logger.getLogger(CreateQuiz.class.getName()).log(Level.WARNING, "Existing file corrupted. Overwriting.", e);
                }
            }

            JSONObject newQuiz = new JSONObject();
            newQuiz.put("QuizTitle", title);
            newQuiz.put("Creator", gameMasterName);
            newQuiz.put("Category", category);
            newQuiz.put("Questions", newQuizArray);
            quizzes.add(newQuiz);

            root.put("Quizzes", quizzes);
            writer.write(root.toJSONString());
        } catch (IOException e) {
            showMessage("Failed to save the quiz.", "Save Error", JOptionPane.ERROR_MESSAGE);
            Logger.getLogger(CreateQuiz.class.getName()).log(Level.SEVERE, "Error saving quiz.", e);
        }
    }


    private void showMessage(String message, String title, int messageType) {
        JOptionPane.showMessageDialog(this, message, title, messageType);
    }

    private void toggleInputFields(boolean enable) {
        questionField.setEnabled(enable);
        option1Field.setEnabled(enable);
        option2Field.setEnabled(enable);
        option3Field.setEnabled(enable);
        option4Field.setEnabled(enable);
        answer1.setEnabled(enable);
        answer2.setEnabled(enable);
        answer3.setEnabled(enable);
        answer4.setEnabled(enable);
        saveQuizButton.setEnabled(enable);
        labelquestioncounter.setEnabled(enable);
    }


    public static void main(String args[]) {
        java.awt.EventQueue.invokeLater(() -> {
            new CreateQuiz("TestName", "tests").setVisible(true);
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Back;
    private javax.swing.JLabel SelectedItem;
    private javax.swing.JRadioButton answer1;
    private javax.swing.JRadioButton answer2;
    private javax.swing.JRadioButton answer3;
    private javax.swing.JRadioButton answer4;
    private javax.swing.ButtonGroup buttonGroup;
    private javax.swing.JComboBox<String> categorySelection;
    private javax.swing.JButton inputButton;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JLabel labelquestioncounter;
    private javax.swing.JButton nextQuestionButton;
    private javax.swing.JTextField option1Field;
    private javax.swing.JTextField option2Field;
    private javax.swing.JTextField option3Field;
    private javax.swing.JTextField option4Field;
    private javax.swing.JButton previousQuestionButton;
    private javax.swing.JComboBox<String> questionAmount;
    private javax.swing.JTextField questionField;
    private javax.swing.JTextField quizTitle;
    private javax.swing.JButton saveQuizButton;
    // End of variables declaration//GEN-END:variables
}
