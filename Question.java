import java.util.Random;
public class Question {
    protected Random random = new Random();
}

class multipleChoiceQuestion extends Question{
    private int numberOfOptions = 5;
    private int[] answers =  new int[numberOfQuestions];

    public int[] getAnswers() {
        return answers;
    }
    public int getNumberOfQuestions() {
        return numberOfQuestions;
    }

}

class trueFalseQuestion extends Question{
    private int numberOfOptions = 2;
    private int[] answers = new int[numberOfOptions];

    public int[] getAnswers() {
        return answers;
    }

    public int getNumberOfOptions() {
        return numberOfOptions;
    }

    public void generateAnswers(){
        for(int i = 0; i<this.getNumberOfOptions(); i++){
            answers[i] = this.random.nextInt();
        }
    }

    

}
