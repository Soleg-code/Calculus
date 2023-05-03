package src;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.lang.model.util.ElementScanner14;

public class QuestionGenerator {
    protected static List<Question> generateEasyQuestions(int nbQuestions) {
        // Through the different diffculties, the random variable will closer to the real answer
        // leading to a necessity of good answer


        // Here will only appear addition and substraction
        List<Question> questions = new ArrayList<Question>();
        List<String> answers;
        Random rand = new Random();
        int operator;
        int n = nbQuestions;

        int a;          // first number
        int b;          // second number
        int answer;     // the answer of the question (index of the correct answer)
        int upper;      // will tell whether the random number will be upper or lower than the answer

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
                for (int j = 0; j < 4; j++)
                {
                    if (j == answer)
                    {
                        answers.add(Integer.toString(a + b));
                    }
                    else
                    {
                        // propositions should be positive or it was my mistake
                        upper = rand.nextInt(2);
                        if (upper == 0 && a + b > 15) // lower
                        {
                            int temp = a + b - (rand.nextInt(15) + 1);
                            while (answers.contains(Integer.toString(temp)))
                                temp = a + b - (rand.nextInt(15) + 1);
                            answers.add(Integer.toString(temp));
                        }
                        else // upper
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
                for (int j = 0; j < 4; j++)
                {
                    if (j == answer)
                    {
                        answers.add(Integer.toString(a - b));
                    }
                    else
                    {
                        upper = rand.nextInt(2);
                        if (upper == 0 && a - b > 15) // lower
                        {
                            int temp = a - b - (rand.nextInt(15) + 1);
                            while (answers.contains(Integer.toString(temp)))
                                temp = a - b - (rand.nextInt(15) + 1);
                            answers.add(Integer.toString(temp));
                        }
                        else // upper
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
}
