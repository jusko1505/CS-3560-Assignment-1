// A question has a number of options and answers.

import java.util.Random;
public class Question {
    protected Random random = new Random();
}

class multipleChoiceQuestion extends Question{
    private int numberOfOptions = 5;
    private boolean[] answers =  new int[numberOfOptions];

    public boolean[] getAnswers() {
        return answers;
    }
    public int getNumberOfOptions() {
        return numberOfOptions;
    }
    public void generateAnswers(){
        for(int i = 0; i<this.getNumberOfOptions(); i++){
            answers[i] = this.random.nextBoolean();
        }
    }

}

class trueFalseQuestion extends Question{
    private int numberOfOptions = 2;
    private boolean[] answers = new int[numberOfOptions];

    public boolean[] getAnswers() {
        return answers;
    }

    public int getNumberOfOptions() {
        return numberOfOptions;
    }

    public void generateAnswers(){
        boolean bln = random.nextBoolean();
        answers[0] = bln;
        answers[1] = !bln;
    }
}
