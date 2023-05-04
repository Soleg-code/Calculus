package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.lang.model.util.ElementScanner14;

public class QuestionGenerator {
    protected static List<Question> generateEasyQuestions(int nbQuestions) {
        // Through the different diffculties, the random variable will closer to the
        // real answer
        // leading to a necessity of good answer

        // Here will only appear addition and substraction
        List<Question> questions = new ArrayList<Question>();
        List<String> answers;
        Random rand = new Random();
        int operator;
        int n = nbQuestions;

        int a; // first number
        int b; // second number
        int answer; // the answer of the question (index of the correct answer)
        int upper; // will tell whether the random number will be upper or lower than the answer

        for (int i = 0; i < n; i++) {
            operator = rand.nextInt(2);
            if (operator == 0) // will be addition
            {
                // the addition should not be too hard
                a = rand.nextInt(100);
                b = rand.nextInt(15) + 1 + a;
                answer = rand.nextInt(4);
                operator = rand.nextInt(2);
                answers = new ArrayList<String>();
                for (int j = 0; j < 4; j++) {
                    if (j == answer) {
                        answers.add(Integer.toString(a + b));
                    } else {
                        // propositions should be positive or it was my mistake
                        upper = rand.nextInt(2);
                        if (upper == 0 && a + b > 15) // lower
                        {
                            int temp = a + b - (rand.nextInt(15) + 1);
                            while (answers.contains(Integer.toString(temp)))
                                temp = a + b - (rand.nextInt(15) + 1);
                            answers.add(Integer.toString(temp));
                        } else // upper
                        {
                            int temp = rand.nextInt(15) + 1 + a + b;
                            while (answers.contains(Integer.toString(temp)))
                                temp = rand.nextInt(15) + 1 + a + b;
                            answers.add(Integer.toString(temp));
                        }
                    }
                }
                Question q;
                if (operator == 0)
                    q = new Question(a + " + " + b + " = ?", answers, answer);
                else
                    q = new Question(b + " + " + a + " = ?", answers, answer);
                questions.add(q);
            } else // will be substraction
            {
                // the substraction should only have positive results
                a = rand.nextInt(100) + 16;
                b = rand.nextInt(a - 15) + 1;
                answer = rand.nextInt(4);
                operator = rand.nextInt(2);
                answers = new ArrayList<String>();
                for (int j = 0; j < 4; j++) {
                    if (j == answer) {
                        answers.add(Integer.toString(a - b));
                    } else {
                        upper = rand.nextInt(2);
                        if (upper == 0 && a - b > 15) // lower
                        {
                            int temp = a - b - (rand.nextInt(15) + 1);
                            while (answers.contains(Integer.toString(temp)))
                                temp = a - b - (rand.nextInt(15) + 1);
                            answers.add(Integer.toString(temp));
                        } else // upper
                        {
                            int temp = rand.nextInt(15) + 1 + a - b;
                            while (answers.contains(Integer.toString(temp)))
                                temp = rand.nextInt(15) + 1 + a - b;
                            answers.add(Integer.toString(temp));
                        }
                    }
                }
                Question q;
                q = new Question(a + " - " + b + " = ?", answers, answer);
                questions.add(q);
            }
        }

        return questions;
    }

    protected static List<Question> generateMediumQuestions(int nbQuestions) {
        // Here questions will be much more random but will still be only addition and
        // substraction
        // plus there might be negative answers and the numbers will be bigger.
        List<Question> questions = new ArrayList<Question>();
        List<String> answers;
        Random rand = new Random();
        int n = nbQuestions;
        int operator;

        int a; // first number
        int b; // second number
        int answer; // the answer of the question (index of the correct answer)
        int upper; // will tell whether the random number will be upper or lower than the answer

        for (int i = 0; i < n; i++) {
            operator = rand.nextInt(2);
            if (operator == 0) // will be a addition
            {
                a = rand.nextInt(200);
                b = rand.nextInt(200);
                answer = rand.nextInt(4);
                answers = new ArrayList<String>();
                for (int j = 0; j < 4; j++) {
                    if (j == answer)
                        answers.add(Integer.toString(a + b));
                    else {
                        upper = rand.nextInt(2);
                        if (upper == 0) {
                            int temp = rand.nextInt(10) + 1 + a + b;
                            while (answers.contains(Integer.toString(temp))) {
                                temp = rand.nextInt(10) + 1 + a + b;
                            }
                            answers.add(Integer.toString(temp));
                        } else {
                            int temp = a + b - (rand.nextInt(10) + 1);
                            while (answers.contains(Integer.toString(temp))) {
                                temp = a + b - (rand.nextInt(10) + 1);
                            }
                            answers.add(Integer.toString(temp));
                        }
                    }
                }
                Question q = new Question(a + " + " + b + " = ?", answers, answer);
                questions.add(q);
            } else // will be a substraction
            {
                a = rand.nextInt(200);
                b = rand.nextInt(200);
                answer = rand.nextInt(4);
                answers = new ArrayList<String>();
                for (int j = 0; j < 4; j++) {
                    if (j == answer)
                        answers.add(Integer.toString(a - b));
                    else {
                        upper = rand.nextInt(2);
                        if (upper == 0) {
                            int temp = rand.nextInt(10) + 1 + a - b;
                            while (answers.contains(Integer.toString(temp))) {
                                temp = rand.nextInt(10) + 1 + a - b;
                            }
                            answers.add(Integer.toString(temp));
                        } else {
                            int temp = a - b - (rand.nextInt(10) + 1);
                            while (answers.contains(Integer.toString(temp))) {
                                temp = a - b - (rand.nextInt(10) + 1);
                            }
                            answers.add(Integer.toString(temp));
                        }
                    }
                }
                Question q = new Question(a + " - " + b + " = ?", answers, answer);
                questions.add(q);
            }
        }

        return questions;
    }

    protected static List<Question> generateHardQuestions(int nbQuestions) {
        // this time there will be multiplication and division.
        // Additions and substractions will be a little more complex
        // But it will still have the same pattern as normal.
        // multiplication and division will always be clean if no mistakes.
        List<Question> questions = new ArrayList<Question>();
        List<String> answers;
        Random rand = new Random();
        int n = nbQuestions;
        int operator;

        int a; // first number
        int b; // second number
        int answer; // the answer of the question (index of the correct answer)
        int upper; // will tell whether the random number will be upper or lower than the answer

        for (int i = 0; i < n; i++) {
            operator = rand.nextInt(4);
            if (operator == 0) // will be a addition
            {
                a = rand.nextInt(200);
                b = rand.nextInt(200);
                answer = rand.nextInt(4);
                answers = new ArrayList<String>();
                for (int j = 0; j < 4; j++) {
                    if (j == answer)
                        answers.add(Integer.toString(a + b));
                    else {
                        upper = rand.nextInt(2);
                        if (upper == 0) {
                            int temp = rand.nextInt(10) + 1 + a + b;
                            while (answers.contains(Integer.toString(temp))) {
                                temp = rand.nextInt(10) + 1 + a + b;
                            }
                            answers.add(Integer.toString(temp));
                        } else {
                            int temp = a + b - (rand.nextInt(10) + 1);
                            while (answers.contains(Integer.toString(temp))) {
                                temp = a + b - (rand.nextInt(10) + 1);
                            }
                            answers.add(Integer.toString(temp));
                        }
                    }
                }
                Question q = new Question(a + " + " + b + " = ?", answers, answer);
                questions.add(q);
            } else if (operator == 1) // will be a substraction
            {
                a = rand.nextInt(200);
                b = rand.nextInt(200);
                answer = rand.nextInt(4);
                answers = new ArrayList<String>();
                for (int j = 0; j < 4; j++) {
                    if (j == answer)
                        answers.add(Integer.toString(a - b));
                    else {
                        upper = rand.nextInt(2);
                        if (upper == 0) {
                            int temp = rand.nextInt(10) + 1 + a - b;
                            while (answers.contains(Integer.toString(temp))) {
                                temp = rand.nextInt(10) + 1 + a - b;
                            }
                            answers.add(Integer.toString(temp));
                        } else {
                            int temp = a - b - (rand.nextInt(10) + 1);
                            while (answers.contains(Integer.toString(temp))) {
                                temp = a - b - (rand.nextInt(10) + 1);
                            }
                            answers.add(Integer.toString(temp));
                        }
                    }
                }
                Question q = new Question(a + " - " + b + " = ?", answers, answer);
                questions.add(q);
            } else if (operator == 2) { // will be a multiplication
                a = rand.nextInt(50) + 1;
                b = rand.nextInt(50) + 1;
                answer = rand.nextInt(4);
                answers = new ArrayList<String>();
                for (int j = 0; j < 4; j++) {
                    if (j == answer) {
                        answers.add(Integer.toString(a * b));
                    } else {
                        upper = rand.nextInt(2);
                        if (upper == 0) {
                            if (a * b > 1000) {
                                int temp = a * b + ((rand.nextInt(5) + 1) * 100);
                                while (answers.contains(Integer.toString(temp))) {
                                    temp = a * b + ((rand.nextInt(5) + 1) * 100);
                                }
                                answers.add(Integer.toString(temp));
                            } else if (a * b > 100) {
                                int temp = a * b + ((rand.nextInt(3) + 1) * 10);
                                while (answers.contains(Integer.toString(temp))) {
                                    temp = a * b + ((rand.nextInt(3) + 1) * 10);
                                }
                                answers.add(Integer.toString(temp));
                            } else {
                                int temp = a * b + ((rand.nextInt(15) + 1));
                                while (answers.contains(Integer.toString(temp))) {
                                    temp = a * b + ((rand.nextInt(15) + 1));
                                }
                                answers.add(Integer.toString(temp));
                            }
                        } else {
                            if (a * b > 1000) {
                                int temp = a * b - ((rand.nextInt(5) + 1) * 100);
                                while (answers.contains(Integer.toString(temp))) {
                                    temp = a * b - ((rand.nextInt(5) + 1) * 100);
                                }
                                answers.add(Integer.toString(temp));
                            } else if (a * b > 100) {
                                int temp = a * b - ((rand.nextInt(3) + 1) * 10);
                                while (answers.contains(Integer.toString(temp))) {
                                    temp = a * b - ((rand.nextInt(3) + 1) * 10);
                                }
                                answers.add(Integer.toString(temp));
                            } else {
                                int temp = a * b - ((rand.nextInt(15) + 1));
                                while (answers.contains(Integer.toString(temp))) {
                                    temp = a * b - ((rand.nextInt(15) + 1));
                                }
                                answers.add(Integer.toString(temp));
                            }
                        }
                    }
                }
                Question q = new Question(a + " * " + b + " = ?", answers, answer);
                questions.add(q);
            } else { // will be a division
                a = rand.nextInt(50) + 1;
                b = rand.nextInt(50) + 1;
                answer = rand.nextInt(4);
                answers = new ArrayList<String>();
                for (int j = 0; j < 4; j++) {
                    if (j == answer) {
                        answers.add(Integer.toString(a));
                    } else {
                        upper = rand.nextInt(2);
                        if (upper == 0) {
                            int temp = a + rand.nextInt(15) + 1;
                            while (answers.contains(Integer.toString(temp))) {
                                temp = a + rand.nextInt(15) + 1;
                            }
                            answers.add(Integer.toString(temp));
                        } else {
                            int temp = a - (rand.nextInt(15) + 1);
                            while (answers.contains(Integer.toString(temp))) {
                                temp = a - (rand.nextInt(15) + 1);
                            }
                            answers.add(Integer.toString(temp));
                        }
                    }
                }
                Question q = new Question((a * b) + " : " + b + " = ?", answers, answer);
                questions.add(q);
            }
        }
        return questions;
    }
}
