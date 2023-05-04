# Calculus
This program aims to reproduce a Calculus game such as the one in the
Joe application from Dynseo.

The language used is java.
The project was started the 3rd of may and was mostly finish on thursday.
The main idea of this project is not the graphic part but the generator
of questions and answer.

In this program, I aimed to do a realistic game of mental calculation.
The graphic aspect in the file Calculus.java was largely inspired by
what Wooclap does and thus, the question and answer are disposed in
the same way. A few parts of the graphic part was taken from internet.

The graphic part was made such as it takes a list of questions and
the questions are composed of a string, which is the question, a
list of string which are the different possibles answers, and finally
the index of the right answer. This way, it is easier for me to verify
wether the user choosed the right answer or not.
With this list of quesiton, I tried to make it so it will be easily
runnable and fast. With that in place, it made the project much easier 
to test and it allowed me to focus mainly en the quesiton generator.
I also added a few functionalities such as the running time, a button
to go to the next question and finally the right answer int the case
of an error.


I mainly worked on the Question generator which is the heart of this
project. In this project, there are 2 generators, first is the question
generator and next is the answer generator. In order to produce these,
I used a lot of randomizer so that it will never be the same between
each run. The question generator was pretty simple to do. In order to
make it readable, I added a few comments and I will describe my plan
for the different difficulties.

- For the easy difficulty I planned to make it so the two number of the
question are quite close so that it will be easier to answer. Also, there
are no possible negative items nor answers. It is made so that it only
contains basic addition and substraction. I was not sure what would be
a fair level for the easy part so that it is easy but not obvious.
Then for the answer generation here, I tried to make it so the possible
choice are close from the actual answer but not too close. In order to
achieve that, I made it so a random variable determine if it should be
above or below the actual solution.

- For the medium difficulty, I removed all of my previous restriction for
the easy mode making the medium mode, easier to program. From now, the
propositions might be negative, are globally closer to the real answer,
and that negative answer might appear. There is not much news in the answer
generator compared to the previous one but the distance from the real solution
is tighten.

- For the hard difficulty, the addition and substraction are the same as the
medium one with larger numbers, but I also added multiplication and division.
Here for the multiplication, I make it so that the answer will never be 0 and
that the to number never go above 2500. for the generation of answer, I adapted
the possible answers depending of the weight of the real answer. The bigger the
answer and the harder it will be to find the right answer.

I know that this project might be lacking in some parts and is not bugfree but
it is still functionnal. It is my first time manipulating a graphic library on
java and I learned quite a lot by doing this project.

Thank you for reading.