// a question has a number of options and answers.

import java.util.Random;
public interface Question {
    public Random random = new Random();
    public boolean[] getAnswers();
    public int getNumberOfOptions();
    public void generateAnswers();
}

// a multipleChoiceQuestion has 5 answer choice options
class multipleChoiceQuestion implements Question{
    private int numberOfOptions = 5;
    private boolean[] answers =  new boolean[numberOfOptions];

    public boolean[] getAnswers() {
        return answers;
    }
    public int getNumberOfOptions() {
        return numberOfOptions;
    }
    //for each answer choice, generates true or false
    public void generateAnswers(){
        for(int i = 0; i<this.getNumberOfOptions(); i++){
            answers[i] = random.nextBoolean();
        }
    }
}

// a trueFalseQuestion has 2 answer choices
class trueFalseQuestion implements Question{
    private int numberOfOptions = 2;
    private boolean[] answers = new boolean[numberOfOptions];

    public boolean[] getAnswers() {
        return answers;
    }

    public int getNumberOfOptions() {
        return numberOfOptions;
    }
    /* If an answer is true, the other must 
     * be the opposite and vice-versa 
     */
    public void generateAnswers(){
        boolean bln = random.nextBoolean();
        answers[0] = bln;
        answers[1] = !bln;
    }
}
