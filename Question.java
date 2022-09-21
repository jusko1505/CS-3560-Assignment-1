// A question has a number of options and answers.

import java.util.Random;
public interface Question {
    public Random random = new Random();
    public boolean[] getAnswers();
    public int getNumberOfOptions();
    public void generateAnswers();
}

class multipleChoiceQuestion implements Question{
    private int numberOfOptions = 5;
    private boolean[] answers =  new boolean[numberOfOptions];

    public boolean[] getAnswers() {
        return answers;
    }
    public int getNumberOfOptions() {
        return numberOfOptions;
    }
    public void generateAnswers(){
        for(int i = 0; i<this.getNumberOfOptions(); i++){
            answers[i] = random.nextBoolean();
        }
    }

}

class trueFalseQuestion implements Question{
    private int numberOfOptions = 2;
    private boolean[] answers = new boolean[numberOfOptions];

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
