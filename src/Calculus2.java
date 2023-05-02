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
import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class Calculus2 extends JFrame {
    private JPanel mainPanel;
    private JPanel questionPanel;
    private JPanel answerPanel;

    public Calculus2() {
        super("QCM");

        mainPanel = new JPanel(new GridBagLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(100, 100, 100, 100));

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

        this.getContentPane().add(mainPanel);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLocationRelativeTo(null);
        this.setVisible(true);
        this.pack();
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

        if (isCorrect) {
            //answerButton.setBackground(Color.decode("#B7EB8F"));
            answerButton.setBackground(new Color(255,255,255));
        } else {
            answerButton.setBackground(new Color(255,255,255));
            //answerButton.setBackground(Color.decode("#EBA18F"));
        }

        answerButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (isCorrect) {
                    answerButton.setBackground(new Color(0, 128, 0)); // Change color to dark green if correct
                } else {
                    answerButton.setBackground(Color.RED); // Keep red color if incorrect
                }
                for (Component component : answerPanel.getComponents()) {
                    if (component instanceof JButton) {
                        component.setEnabled(false); // Disable all answer buttons after selection
                    }
                }
            }
        });

        GridBagConstraints c = new GridBagConstraints();
        c.gridx = 0;
        c.gridy = answerPanel.getComponentCount();
        c.insets = new Insets(5, 0, 5, 0);
        c.anchor = GridBagConstraints.CENTER;
        answerPanel.add(answerButton, c);
    }

    public static void main(String[] args) {
        Calculus2 qcmInterface = new Calculus2();
        qcmInterface.setQuestion("Quelle est la capitale de la France ?");
        qcmInterface.addAnswerButton("Paris", true);
        qcmInterface.addAnswerButton("Berlin", false);
        qcmInterface.addAnswerButton("Londres", false);
        qcmInterface.addAnswerButton("Rome", false);
        qcmInterface.addAnswerButton("Madrid", false);

        // qcmInterface.removeAll();
        // qcmInterface.setQuestion("Quelle est la capitale de l'Allemagne ?");
        // qcmInterface.addAnswerButton("Paris", false);
        // qcmInterface.addAnswerButton("Berlin", true);
        // qcmInterface.addAnswerButton("Londres", false);
        // qcmInterface.addAnswerButton("Rome", false);
        // qcmInterface.addAnswerButton("Madrid", false);
    }
}
