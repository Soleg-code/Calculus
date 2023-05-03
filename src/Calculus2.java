package src;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.CubicCurve2D;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculus2 extends JFrame {
    private JPanel mainPanel;
    private JPanel questionPanel;
    private JPanel answerPanel;
    private JButton nextButton;
    private int indexQuestion = 0;
    private List<Question> questions;
    private int score;
    private int total;

    public Calculus2(List<Question> questions) {
        super("CALCULUS");

        this.questions = questions;
        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(200, 200, 200, 200));

        questionPanel = new JPanel();
        questionPanel.setBackground(Color.WHITE);
        questionPanel.setPreferredSize(new Dimension(800, 200));
        questionPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        answerPanel = new JPanel(new GridBagLayout());
        answerPanel.setBackground(Color.WHITE);
        answerPanel.setBorder(BorderFactory.createCompoundBorder(
                BorderFactory.createLineBorder(Color.GRAY, 1),
                BorderFactory.createEmptyBorder(20, 20, 20, 20)));

        


        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = 0;
        c.insets = new Insets(0, 0, 10, 0);
        c.anchor = GridBagConstraints.CENTER;
        mainPanel.add(questionPanel, c);
        c.gridy = 1;
        mainPanel.add(answerPanel, c);

        nextButton = new JButton("Suivant");
        nextButton.setPreferredSize(new Dimension(100, 30));
        nextButton.setFont(new Font("Arial", Font.PLAIN, 14));
        nextButton.setEnabled(false);
        nextButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                nextQuestion();
            }
        });


        c.gridy = 2;
        mainPanel.add(nextButton,c);

        this.getContentPane().add(mainPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();

        score = 0;
        total = questions.size();

        showCurrentQuestion();
    }

    private void showCurrentQuestion()
    {
        Question question = questions.get(indexQuestion);
        setQuestion(question.getQuestion());
        for (String answer : question.getAnswers()) {
            if (answer.equals(question.getAnswers().get(question.getCorrectAnswer()))) {
                addAnswerButton(answer, true);
            } else {
                addAnswerButton(answer, false);
            }
        }
    }

    private void clearAnswerPanel()
    {
        answerPanel.removeAll();
        answerPanel.revalidate();
        answerPanel.repaint();
    }

    private void nextQuestion()
    {
        indexQuestion++;
        if (indexQuestion < questions.size()) {
            questionPanel.removeAll();
            answerPanel.removeAll();
            // nextButton.setEnabled(false);
            showCurrentQuestion();
            nextButton.setVisible(false);
        } else {
            // this.dispose();
            double percent = (double) score / total * 100;
            JLabel scoreLabel = new JLabel(String.format("Score: %.2f%%", percent));
            scoreLabel.setFont(new Font("Arial", Font.PLAIN, 24));
            questionPanel.removeAll();
            questionPanel.add(scoreLabel);
            answerPanel.removeAll();
            nextButton.setText("Terminer");
            nextButton.setVisible(true);
            nextButton.setEnabled(true);
            // need to redirect to the menu.
        }
    }

    public void setQuestion(String questionText) {
        JLabel questionLabel = new JLabel(questionText);
        questionLabel.setFont(new Font("Arial", Font.PLAIN, 24));
        questionPanel.add(questionLabel);
    }

    public void addAnswerButton(String answerText, boolean isCorrect) {
        JButton answerButton = new JButton(answerText);
        answerButton.setPreferredSize(new Dimension(400, 50));
        answerButton.setFont(new Font("Arial", Font.PLAIN, 20));
        answerButton.setFocusPainted(false);

        answerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                checkAnswer(answerButton, isCorrect);
            }
        });

        // if (isCorrect) {
        //     answerButton.setBackground(new Color(255,255,255));
        // } else {
        //     answerButton.setBackground(new Color(255,255,255));
        // }

        // answerButton.addActionListener(new ActionListener() {
        //     public void actionPerformed(ActionEvent e) {
        //         if (isCorrect) {
        //             answerButton.setBackground(new Color(0, 128, 0)); // Change color to dark green if correct
        //         } else {
        //             answerButton.setBackground(Color.RED); // Keep red color if incorrect
        //         }
        //         for (Component component : answerPanel.getComponents()) {
        //             if (component instanceof JButton) {
        //                 component.setEnabled(false); // Disable all answer buttons after selection
        //                 nextButton.setEnabled(true);
        //             }
        //         }
        //     }
        // });

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = answerPanel.getComponentCount();
        c.insets = new Insets(5, 0, 5, 0);
        c.anchor = GridBagConstraints.CENTER;
        answerPanel.add(answerButton, c);
        answerButton.revalidate();
        answerButton.repaint();
    }

    private void checkAnswer(JButton answerButton, boolean isCorrect) {
        answerButton.setEnabled(false);
        if (isCorrect) {
            answerButton.setBackground(Color.GREEN); // Change color to dark green if correct
            score++;
            nextButton.setEnabled(true);
        } else {
            answerButton.setBackground(Color.RED); // Keep red color if incorrect
            nextButton.setEnabled(true);
        }
        nextButton.setVisible(true);
    }

    public static void main(String[] args) {
        List<String> answers = List.of("Paris", "Berlin", "Londres", "Rome", "Madrid");
        Question question = new Question("Quelle est la capitale de la France ?", answers, 0);
        Question question2 = new Question("Quelle est la capitale de l'Allemagne ?", answers, 1);
        Question question3 = new Question("Quelle est la capitale de l'Angleterre ?", answers, 2);
        List<Question> questions = List.of(question, question2, question3);
        Calculus2 qcmInterface = new Calculus2(questions);
    }
}
